Author: Abinashi Singh

Language: Java

Version: Java 8 and above is required

Running instructions: 
1. Create a directory and add the "src" folder.
2. Add the .CSV in the directory
2. Run the "Tests" class that has all the test cases implemented utilizing JUnit framework, which in turn will initialize the Firewall class and ask for the user input. 
3. Enter the valid path to your CSV file 


While working on this challenge, my main aim was efficiency. Storing all the CSV rules 
in the HashSet made sure that the duplicate rules are ignored and provided a constant time access to a query.
The Firewall class acts as a container of the rules and also initializes the Port and IPAddress classes. The 
Port class will store the ranges of a port and IPAdress is doing the same. 

Optimisations:  
I would like to optimise the lookup time for the range check of an IP Address. Moreover, in the current implementation,
to check a rule, it has to iterate the whole Set of rules. This can be optimized if a TreeMap is used in which only those port numbers are checked that are strictly less than equal to the port number we are trying to check. 
For example, if a port number to check is 1500, then check only those rules that has less than or equal port number. 

Team I want to work with: 
1. Platform team
2. Policy team  
