# Data Structure & Graph Performance Analyzer

**Module:** CIT300 Data Structures and Algorithms
**Assignment:** Graded Practical Assignment 2
**Language:** Java (console application)

## Project Description
A menu-driven Java console application that demonstrates Array, Stack, Queue, Linked List,
Searching (Linear and Binary), Graph (adjacency list with BFS and DFS) and a performance
comparison that records the number of steps and the execution time of the algorithms.

## Team Members

### Member 1
- **Student Name:** MA. Mohamed Hanoos
- **Student ID:** 23DA2-0560
- **Assigned Responsibility:** Array and Searching
- **Individual Contribution:**
  - Implemented `ArrayOperations` (insert, delete, search, sort, display)
  - Implemented `Searching` (Linear Search, Binary Search with step counter and timer)
  - Tested and integrated with the main menu

### Member 2
- **Student Name:** FI. Fazlan Ahamed
- **Student ID:** 23DA2-0717
- **Assigned Responsibility:** Stack and Queue
- **Individual Contribution:**
  - Implemented `MyStack` (push, pop, peek, display, empty-stack handling)
  - Implemented `MyQueue` (enqueue, dequeue, peek, display, empty-queue handling)
  - Tested and integrated with the main menu

### Member 3
- **Student Name:** SA. Sifar Ahamed
- **Student ID:** 23DA2-0559
- **Assigned Responsibility:** Linked List and Main Menu
- **Individual Contribution:**
  - Implemented `MyLinkedList` (insert head/tail/position, delete, search, display)
  - Implemented `Main` (menus) and `InputHelper` (input validation)
  - Tested and integrated with the main menu

### Member 4
- **Student Name:** MR. Mohamed Akshan
- **Student ID:** 23DA2-1020
- **Assigned Responsibility:** Graph and Performance Comparison
- **Individual Contribution:**
  - Implemented `Graph` (add vertex, add edge, display, BFS, DFS)
  - Implemented `PerformanceAnalyzer` (search and traversal comparison, results table)
  - Tested and integrated with the main menu

## Technologies Used
- Java (JDK 11 or later)
- Git and GitHub

## Main Features
- **Array:** insert (end/index), delete (value/index), linear search, sort, display
- **Stack (array based):** push, pop, peek, display, empty-stack handling
- **Queue (linked nodes):** enqueue, dequeue, front, display, empty-queue handling
- **Linked List (singly):** insert (head/tail/position), delete, search, display
- **Searching:** Linear Search O(n) and Binary Search O(log n) with steps and execution time
- **Graph (adjacency list):** add vertex, add edge, display, BFS (uses Queue), DFS (uses Stack)
- **Performance Comparison:** Linear vs Binary search, BFS vs DFS, results table
- **Input validation** and handling of empty data structures

## How to Run
1. Install JDK 11 or later and check it with `javac -version`.
2. Open a terminal in the folder that contains the `.java` files (the `src` folder).
3. Compile and run:

```bash
javac *.java
java Main
```

## Project Structure
```
src/
 |- Main.java                 main menu and submenus
 |- InputHelper.java          safe console input
 |- ArrayOperations.java
 |- Searching.java
 |- MyStack.java
 |- MyQueue.java
 |- MyLinkedList.java
 |- Graph.java
 |- PerformanceAnalyzer.java
```

## Complexity Summary
| Operation | Complexity |
|---|---|
| Array insert/delete in the middle | O(n) |
| Stack push / pop / peek | O(1) |
| Queue enqueue / dequeue / peek | O(1) |
| Linked list insert at head | O(1) |
| Linked list search / delete | O(n) |
| Linear Search | O(n) |
| Binary Search (sorted array) | O(log n) |
| BFS / DFS | O(V + E) |
