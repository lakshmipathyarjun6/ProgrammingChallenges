Copyright Arjun Sriram Lakshmipathy 2015.

The source code is all written in Java and was tested with Java Version 8. It
should work for older versions of Java as well, but I have not tested older
versions.

INSTRUCTIONS TO BUILD AND RUN:
The various classes have already been created and placed in the bin folder. In
otder to start the game, simply type:

java RunGame

The code source files for these classes are in the src folder. If you wish to
recompile the files, type:

javac (insert filename here).java

For the sake of organization and cleanliness, I like to keep my compiled classes
separate from my source files, but you may run the program in the src folder as
well after recompiling the classes.

WHAT YOU SHOULD EXPECT TO SEE:
You should expect to see the number of blank spaces (underscores) of the mystery
phrase at the start of the game. At the start of every turn, the program will
compile a list of possible words that can possibly fill in the blanks in no
particular order. There will then be an output that says:

(letter) is correct!

OR

(letter) is incorrect. Number of attempts remaining: (number)   

OR 

(letter) is incorrect.

The first two outputs correspond to a correct or incorrect guess in normal
gameplay. The last message will be output when all three guesses have been used
up. Additionally, the mystery phrase will be revealed along with either the
comment:

Impressive...most impressive. (success)

OR

You...have failed. (failure)

ADDITIONAL COMMENTS:
The SCOWL library was used to determine the possible list of words on every
iteration. You will find all those source files in the lib folder. Many of these
files contain identical words, but it became extremely cumbersome to prune
through all of them. Many files were already removed in order to improve the
efficiency of the algorithm, but many files had both a combination of "useful"
and "useless" words. It became too time-consuming to remove all the "useless"
words from these files, and thus the desgin of this program could have been
improved in that regard. 
