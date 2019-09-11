#Makefile Script for the Stack Data Structure


Main: *.java
	@javac *.java

edit:
	@vim Main.java

clean:
	@rm *.class

run:
	@java Main
