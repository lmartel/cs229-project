import csv
import cPickle
import numpy as np
from sklearn.naive_bayes import MultinomialNB
from sklearn.feature_extraction.text import CountVectorizer

X = []
y = []
delim = ","

# Note: this class assumes data has been cleaned
with open('nb/naive_bayes.train.inputs') as f:
	scoresAndFeatures = f.readlines()
	partitionedScoresAndFeatures = [entry.partition(delim) for entry in scoresAndFeatures]
	scores = [partitionedEntry[0] for partitionedEntry in partitionedScoresAndFeatures]
	corpus = [partitionedEntry[2] for partitionedEntry in partitionedScoresAndFeatures]
	print "Printing the first entry of the corpus:"
	print "score: ", scores[0], "\n"
	print "comment: ", corpus[0], "\n"
	print "corpus length: ", len(corpus), "\n"
	print "scores length: ", len(scores), "\n"
	vectorizer = CountVectorizer(min_df=1)
	X = vectorizer.fit_transform(corpus)
	y = np.array(scores)

clf = MultinomialNB()
clf.fit(X, y)

print X
print y

# The coefficients
# print "Coefficients: \n", regr.coef_
# The mean square error
squared_errors = np.subtract(clf.predict(X), y)
print squared_errors
print("[TRAINING] Residual sum of squares: %.2f"
      % np.mean((clf.predict(X) - y) ** 2))
# Explained variance score: 1 is perfect prediction
print('[TRAINING] Variance score: %.2f' % clf.score(X, y))

with open('nb/naive_bayes.model', 'wb') as f:
    cPickle.dump(clf, f)










