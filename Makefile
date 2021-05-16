######################################
# Author: Utsharga Rozario, rozariou #
# Revised: 	Thursday, April 02, 2020 #
# Description:	"MAKEFILE"		 	 #
######################################

# Assumes JUnit is installed
# Assumes CLASSPATH has been set for Junit

JFLAGS = -g
JCLASS = -cp ./src:.:$(CLASSPATH):/mnt/c/Users/priya/Documents/GitHub/decrypstocks/junit-4.5.jar
JC = javac
JVM = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $(JCLASS) $*.java

CLASSES = \
	src/Main.java \
	src/ArrayMakerADT.java \
	src/Graph.java \
	src/QuickSort.java \
	src/StockADT.java \
	src/BinarySearch.java \

MAIN = AllTests

default: classes

classes: $(CLASSES:.java=.class)

expt: src/Main.java
	$(JC) $(JCLASS) $(JFLAGS) src/Main.java
	$(JVM) $(JCLASS) Main

clean:
	cd src
	rm **/*.class
