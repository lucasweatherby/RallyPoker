RallyPoker
==========

The purpose of this project is to determine Rank of Poker Hand from an input string representation of a poker hand.


Input Format
============
The input arguments for the java progam should be a string of cards separated by spaces. The card should be formated so that the value of the card becomes before the suit. Lettered cards should be uppercase and suits should be lowercase. Example of the agruments format: 7d 4c 8c 6h 5s

JUnit Testing
=============

Testing was executed within Eclipse using JUnit. To run the unit tests, simply run either PokerHandTest.java or PokerRangingsTest.Java from within Eclipse as a JUnitTest.

Run the Progam
==============

The program can either be run through eclipse or as a jar. 

To run as a JAR, the project should be exported as a Runnable JAR File with the launch configuration pointing at Poker.java. Through a command promt, navigate to the JAR file and enter the following command: java -jar JARFILENAME.jar 5d 4d 3d 4h 6h

To run through Eclipse, right click on Poker.java. From here click "Run as>Run Configurations.." Switch to the arguments tab, specify the arguments in the format provided above. Click apply, then click run.
