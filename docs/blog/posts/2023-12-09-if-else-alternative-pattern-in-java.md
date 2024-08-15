---
draft: false 
authors: 
  - StijnDeMulder
date: 2024-01-31 
title: Avoid using If Else statement using Design Patterns
categories:
  - Hello
  - World
---
## Issue
Consider a scenario where a system needs to calculate the price of a product based on its type. One way to implement this would be to use a series of if-else statements to determine the product type and calculate the price accordingly. However, this approach can quickly become unwieldy as the number of product types increases.

``` java
--8<-- "com/javadesignpatterns/blog/avoidifElse/PathFinder.java"
```

1. The **PathFinder** has one method to calculate a path based on an algorith and the inputs required for that algorithm
2. For each algorithm we must add an if-else statement
3. Each implementation of the algorithm has its own method

### The output looks like this:

```java
Executing BFS...
Path found using BFS: [Start -> ... -> End (BFS Path)]
Executing DFS...
Path found using DFS: [Start -> ... -> End (DFS Path)]
Executing Dijkstra...
Path found using Dijkstra: [Start -> ... -> End (Dijkstra Path)]
Executing A*...
Path found using A*: [Start -> ... -> End (A* Path)]
```

### Issues

- Each algorithm requires a new if-else statement, which is not ideal if you plan to support a wide range of algorithms
- All the algorithms are part of the PathFinder class, which means its harder to identify the logic linked to one algorithm

If you want to improve you Java skills:

[Visit the Javanauts community](https://javanauts.dev){ .md-button .md-button--primary }

<!-- more -->

### :fontawesome-solid-graduation-cap: Solution With Design Patterns
!!! quote "What are Design Patterns?"

    Design patterns are reusable solutions to common programming problems. They provide a structured approach to solving problems and promote code reuse, flexibility, and maintainability. Java Design Patterns offer a set of best practices for designing and implementing software applications. They provide a framework for developers to create code that is easy to understand, maintain, and extend.


One of the most common Java Design Patterns used to replace if-else statements is the [Strategy Pattern](../../catalog/behavioral-patterns/strategy-pattern.md). The Strategy Pattern allows developers to define a family of algorithms, encapsulate each one, and make them interchangeable. This pattern promotes code reuse, flexibility, and maintainability. By using the Strategy Pattern, developers can easily add new algorithms without modifying existing code. This approach reduces code complexity and improves the overall quality of the software.

ℹ️ You can find all design pattern described in our [catalog](https://javadesignpatterns.com/catalog/).


Strategy Pattern to Replace Conditional Logic
---------------------------------------------

### Defining Strategy Pattern

The Strategy Pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each one, and makes them interchangeable. This pattern lets the algorithm vary independently from clients that use it. The Strategy Pattern involves two main entities: the Context and the Strategy. The Context is responsible for executing the algorithm, while the Strategy represents the algorithm itself.

### Applying Strategy Pattern

The Strategy Pattern can be used to replace conditional logic in situations where the behavior of an object needs to change dynamically at runtime. By encapsulating the behavior in a separate Strategy object, the Context can switch between different strategies without having to modify its code. This makes the code more modular and easier to maintain.

### Strategy Pattern Example

A better approach would be to use the Strategy Pattern to encapsulate the pricing logic for each product type in a separate Strategy object. The Context object would then be responsible for selecting the appropriate Strategy object based on the product type and invoking its pricing method.

Here is an example implementation of the Strategy Pattern for the product pricing scenario:

``` java
--8<-- "com/javadesignpatterns/blog/avoidifElse/solution/PathFinder.java"
```

1. Create a new interface to encapsulate the path finding algorithm
2. Create new implementations for each algorithm
3. Store the strategy inside the PathFinder
4. Allow an each "change" of algorithm
5. The PathFinder still exposes the find path method, but delegates to the implementation algorithm
   


In this example, the `PathFindingStrategy` interface defines the algorithm behavior, and the `BFSPathFindingStrategy` and `DijkstraPathFindingStrategy` classes implement the behavior for each specific algorithm, respectively. The `PathFinder` class uses the `PathFindingStrategy` interface to calculate the path based on the specific algorithm. This approach allows for easy addition of new algorithm strategies without having to modify existing code.

Overall, the Strategy Pattern provides a flexible and modular approach to replacing conditional logic in Java programs. By encapsulating behavior in separate Strategy objects, the code becomes easier to maintain and modify, and can adapt to changing requirements at runtime.

Using an Enum to replace IF-Else blocks
-----------------------------------
In the example above, we still need to set the specific PathFinderStrategy before calling the **findPath method**. A more elegant solution involves creating an Enum listing all the available PathFinding algorithms together with their strategy:

``` java
--8<-- "com/javadesignpatterns/blog/avoidifElse/solution/factory/PathFindingStrategyType.java"
```

1. List all the algorithms and pass the Strategy in the constructor.
2. Keep the strategy as an internal reference linked to the enum.
3. The enum constructor now forces a strategy

The PathFinder implementation becomes a bit more elegant by passing the desired algorithm type as parameter of the findPath method:

``` java
--8<-- "com/javadesignpatterns/blog/avoidifElse/solution/factory/PathFinder.java"
```

1. Ask the Enum for its strategy and execute it

The resulting PathFinder still works as expected:

```java
Executing BFS...
Path found using BFS: [Start -> ... -> End (BFS Path)]
Executing DFS...
Path found using DFS: [Start -> ... -> End (DFS Path)]
Executing Dijkstra...
Path found using Dijkstra: [Start -> ... -> End (Dijkstra Path)]
Executing A*...
Path found using A*: [Start -> ... -> End (A* Path)]
```

Conclusion
----------

In conclusion, there are various design patterns that can be used to replace if-else statements in Java. The implementation of design patterns can help improve the readability, maintainability, and scalability of code.

One such pattern is the Strategy pattern, which allows for dynamic selection of algorithms at runtime. This pattern can be useful when there are multiple algorithms that can be used to solve a problem and the selection of the algorithm depends on the context.

Another pattern is the Factory pattern, which provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. This pattern can be useful when there is a need to create objects based on a specific set of conditions.

Using a Map can also be a good alternative to if-else statements, as it allows for easy mapping of keys to values. This can be useful when there is a need to perform different operations based on specific inputs.

Finally, it is important to handle exceptions properly when replacing if-else statements with design patterns. Exceptions should be thrown and handled appropriately to ensure that the program runs smoothly and errors are handled gracefully.

Overall, it is important to choose the right design pattern based on the specific requirements of the program. By doing so, developers can write cleaner, more efficient, and more maintainable code.
