View my other projects [here](https://github.com/jkrygo/)!

# Amazon Recommender System

This is a project that builds a recommender system using Amazon data. The data was collected by crawling Amazon and it contains project metadata and review information about 548,552 different products.

It implements a data analytics engine that has a searching function and a recommender function. It divides the co-purchasing data into two data sets: a "training" dataset and a "testing" dataset. 
The input data is parsed by readfile.py so that each entry is converted and saved into parsed.txt as a single line dictionary string, formatted as such:

{'reviews': [('A2JW67OY8U6HHK', 5), ('A2VE83MZF98ITY', 5)], 'ASIN': '0827229534', 'similar': ['0804215715', '156101074X', '0687023955', '0687074231', '082721619X'], 'title': 'Patterns of Preaching: A Sermon Sampler'}

recommend.py reads parsed.txt and converts these strings back into dictionaries and stores them in a Resilient Distributed Dataset (RDD). The RDD then gets transformed into another RDD that contains userid, items purchased by the user, and similar products. Any users that appear multiple times in this RDD are condensed into a single entry. The final RDD contains the userid, followed by a list of products that are recommended to them , formatted as such: 

('ALFXDXFJAUULN',['0439139600','0439136350','0439064864','0590353403','B00005JMAH', '074347676X'])

Users with no recommened products still appear, but any products that would be listed will appear as [].
