CompletableFuture Demo Project

Overview

This project demonstrates the use of Java's CompletableFuture class to execute asynchronous tasks. It contains two separate tasks, each implemented in its own file:
Task1.java: Performs asynchronous operations on an integer array.
Task2.java: Performs asynchronous operations on a sequence of double numbers.

Both tasks showcase various CompletableFuture methods, such as:
- supplyAsync()
- thenApplyAsync()
- thenAcceptAsync()
- thenRunAsync()

Task 1

Description

Task 1 generates an integer array asynchronously, modifies it by adding 10 to each element, divides the result by 2 to produce a double array, and prints the arrays at each step. 
Execution times for each asynchronous operation are also displayed.

Steps:

- Generate a random integer array of size 10 asynchronously.
- Add 10 to each element and divide by 2.
- Print the resulting array with execution times.

File: 
Task1.java

Task 2

Description

Task 2 generates a sequence of 20 random double numbers asynchronously. It calculates the product of differences between consecutive elements in 
the sequence and prints the initial sequence, the result, and execution times.

Steps

- Generate a random sequence of 20 double numbers asynchronously.
- Calculate the product of differences between consecutive elements.
- Print the sequence and the result with execution times.

File:
Task2.java


Example Output

Task 1

Task 1:
Initial array: [5, 16, 59, 97, 56, 47, 18, 86, 83, 37]

Generated in: 4 ms

Modified array (added 10 and divided by 2): [7.5, 13.0, 34.5, 53.5, 33.0, 28.5, 14.0, 48.0, 46.5, 23.5]

Modified in: 3 ms

Result array: [7.5, 13.0, 34.5, 53.5, 33.0, 28.5, 14.0, 48.0, 46.5, 23.5]

Result output in: 2 ms

Total time for Task 1: 23 ms

Task 2

Task 2:

Generated sequence: [43.49, 30.10, 38.04, ...]

Generated in: 7 ms

Calculated result: 4.664759880384364E26

Calculated in: 7 ms

Final result: 4.664759880384364E26

Result output in: 0 ms

Total time for Task 2: 16 ms

Notes

The execution times may vary depending on your system.

The TimeUnit.SECONDS.sleep(3) ensures that asynchronous tasks complete before the program exits.
