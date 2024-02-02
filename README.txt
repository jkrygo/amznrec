Dataset download: https://snap.stanford.edu/data/amazon-meta.html

Running Instructions (Linux):
    All Data:
    python2 readfile.py amazon-meta.txt > parsed.txt
    spark-submit recommend.py parsed.txt

    Sample Data:
    python2 readfile.py sample.txt > sample-parsed.txt
    spark-submit recommend.py sample-parsed.txt

    A file named recommendations.txt is created.
