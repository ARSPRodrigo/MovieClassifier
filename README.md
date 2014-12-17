MovieClassifier
===============
MOV 01
E/11/145 —Harshani S.K.E.
E/11/343 — Rodrigo A.R.S.P
E/11/368 — Selvaluxmiy S.

## Introduction
#### BACKGROUND INTRODUCTION
Movie classification is a topic of interest both to academics and industry. Most of the classification
s are focused towards user’s preference on selecting future movies. But a classification
scheme targeted for the future popularity of movie enables producers, financiers, academics or
even viewers to understand the contributing factors that lead to movies success. This is because
too many parameters of different degrees are related and finding a suitable way to represent all
the information related to a movie in a single instance is a cumbersome task. Even if a way is
found out to represent a movie the final choice of classifiers to generate the model requires
considerable research. Again in case of post release movie the point of interest centers on the
financial return. The problem of data representation and classification exits in this case also. So it
is required to design an easily minable dataset along with appropriate classifier that can be used
to generate models to predict the classification of popularity of pre-release and post release
movie.

#### MOTIVATION
The motivation of creating an automated movie classifier software is to identify the genre of a
particular movie purely based on its plot without relying on the other classification and rating
systems.

#### PROBLEM DEFINITION
Public movies’ database such as IMDB provides genre information to assist searching. The
tagging of movies’ genres is still a manual process which involves the collection of users’
suggestions sent to known email addresses of IMDB. Movies are often registered with inaccurate
genres.

#### OBJECTIVES
Objective is to build a movie classifier system. Given a plot (storyline) of a new movie, the system

## PROJECT REQUIREMENTS
Project requirements are as follows
Design a database schema to store data (both the plot and categories)
-	Preprocess the data
  - Removing unwanted characters
  - Removing stopwords
  - Stemming
- Represent data using bag-of-words representation
- Given a plot of a new movie, the system finds the closest movie plot in the database and suggests its category as the category of the new movie.
  - Transform the plot to bag-of-words representation.
  - Calculate the Euclidean distance from the new movie to the all the movies in the database.
  - Find the movie with the lowest distance to the new movie and get the category information.
- Selecting right threshold values for high frequent/ low frequent words – Deciding whether the feature is relevant for the classification or not
- Feature selection – Choosing optimal feature set
- Feature weighting

## DATASET

The structure of dataset consists of three methods and connected with the one other class. Three methods are;
- CreateMovieFile
  - Which create a file called ‘movie.txt’ with movie plots from IMDB plot list file which containing more than 20 lines released up to 2013.
- CreategenreFiles
  - Read IMDB movie genre list file. Select movies which mainly categorized into Action, Drama, Horror, Romance and Thriller genres. Write the movie names into separate file named as above categories.
- WriteMovieFiles
  - Read above files. Make lists from genre files. Extract movie plots from ‘movie.txt’ file for each category and write into files according to above genres. e.g.: ActionMovies.txt

The other class connected to the dataset is RemoveStopWords.java class. Which removes the stop words from movie plot files and do the stemming of words. Finally write back to files which contain the processed words. e.g.: ActionMWords.txt

Until the creation of word files the action done by java classes. Next is the creation of version.csv file, which contain the document term matrix.

## CLASSIFIER
There are five methods used for classification part.

- CreateMatrix
  - This class is called from controller and it creates two matrices from version.csv file. One matrix containing all the words in the csv file and another two dimensional matrix containing the counts of each word.
- NewPlotControl
  - This class is also called from controller and it selects whether the input is from the interface text area or from a file which is called ‘plot.txt’ (this file is used for testing purposes)
- NewPlotMatrix
  - After the selection of plot it has to be added to another matrix and the matrices created in CreateMatrix class have to be reduced. Because those matrices have words which are not in the new plot and it reduces the accuracy of the calculation. In this class create three matrices from above matrices and new plot. For new plot matrix it class use the RemoveStopWords class to filter out unwanted words. Then it selects the distinct words which are both in the dataset word matrix and new plot and creates a new word matrix. Then extract word count of those words from dataset word count matrix and also creates a new matrix containing word counts from new plot.
- KNN
  - Class KNN do the calculations from above matrices and find the Kth nearest values. Because of the over lapping of movies, which means one movie can be categorized into many genres, this class return all the genres which are in less percentage distance from the average percentage distance. Average percentage distance is the distance can get when one movie is equally related to all categories. This class uses Euclidian distance algorithm to calculate distance. 

## INTERFACE
Interface is designed using JavaFX, because it is easy to develop and easily customizable. Interface is simple, fixed size and consist with text area, two buttons and a result label (Figure 6.4).

Interface is controlled by controller class. The text area is to enter the plot. Result label is to display the results. Two buttons are ‘Find’ and ‘Clear’. ‘Clear’ buttons event is handled by controller class and it clears the text area and the result label. ‘Find’ button click action calls the classifier classes and the result from KNN class displays in the result label.

## CONCLUSION
This project has presented an Automated Movie Classifier System. Which has been an interesting topic for both academics and industry. 

Until now all the movie classification in the word has done manually. So this project has required to design an easily minable dataset along with appropriate classifier that can be used to predict the classification of pre-release and post release movies. 

After the literature revive K-Nearest Neighbor Method has selected as the classification method. The project requirements have given as preprocess the data, represent data as bag of word representation method and find the closest genre for given movie plot.

The system design has consisted with three main parts, user interface, classifier and dataset. Dataset has created using IMDB plot files for genres action, drama, horror, romance and thriller. Classifier has implemented using java and user interface has designed using JavaFX.

The system has tested for movies released in 2014 of above five genres. Test results has showed over fifty present of success.
