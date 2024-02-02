import ast
import sys
from pyspark import SparkContext
from sets import Set


# to (userID, item_bought, (items similar to item_bought))
def dict_to_users(product):
    res = []
    for review in product['reviews']:
        if review[1] > 3:
            user_tuple = (review[0], ([product['ASIN']], product['similar']))
            res.append(user_tuple)
    return res


def condense_user(first, second):
    items_bought = []
    items_bought.extend(first[0])
    for item in second[0]:
        if item not in items_bought:
            items_bought.append(item)

    recommendations = []
    recommendations.extend(first[1])
    for rec in second[1]:
        if rec not in recommendations:
            recommendations.append(rec)

    value = (items_bought, recommendations)
    return value


if len(sys.argv) < 2:
    print 'You must pass an input file as an argument.'
    exit()

sc = SparkContext()
myrdd = sc.textFile(sys.argv[1])

# converts the dictionaries represented as string in the file back into real dictionaries in an rdd
dictrdd = myrdd.map(lambda string: ast.literal_eval(string))

# converts the product rdd into an rdd that contains userid, item_bought, and similar products
users = dictrdd.flatMap(dict_to_users)

# groups the multipile entries per user into one user entry
grouped = users.reduceByKey(condense_user)

# has only the recommended products per user
simplified = grouped.map(lambda x: (x[0], x[1][1]))

with open('recommendations.txt', 'w') as fout:
    for rec in simplified.collect():
        fout.write(str(rec))
        fout.write('\n')
