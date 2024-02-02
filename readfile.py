import sys

def read_product(fin):
	# skip ID and blank lines
	line = fin.readline()
	if line == '\r\n':
		return read_product(fin)
	# EOF
	elif line == '':
		return 'Done'

	product = {}

	line = fin.readline()
	product['ASIN'] = line[6:].rstrip()

	line = fin.readline()
	if line == '  discontinued product\r\n':
		return None
	product['title'] = line[9:].rstrip()

	fin.readline() # skip group
	fin.readline() # skip salesrank

	line = fin.readline()
	similar_ct = line.split()[1]
	if similar_ct > 0:
		product['similar'] = line.split()[2:]

	line = fin.readline()
	category_ct = line.split()[1]
	for i in range(0, int(category_ct)):
		fin.readline() # skip categories

	product['reviews'] = []
	line = fin.readline()
	review_ct = line.split()[4]
	for i in range(0, int(review_ct)):
		line = fin.readline()
		review_tup = (line.split()[2], int(line.split()[4]))
		product['reviews'].append(review_tup)

	return product

if len(sys.argv) < 2:
    print 'You must pass an input file as an argument.'
    exit()

fin = open(sys.argv[1])

# skip the info at beginning
fin.readline()
fin.readline()
fin.readline()

while True:
	prod = read_product(fin)
	if prod == 'Done':
		break
	elif prod != None:
		print prod
