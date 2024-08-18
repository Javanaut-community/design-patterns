## Introduction
The Builder pattern is a creational design pattern that is widely used in Java. It allows developers to create complex objects step by step, without having to create multiple constructors with different parameters. By using the Builder pattern, developers can create objects with a large number of optional parameters in a more efficient and consistent way.

![Building site](../../art/catalog/builder/builder-overview.png){ loading=lazy }

<div class="grid cards" markdown>

-   :fontawesome-solid-graduation-cap:{ .lg .middle } __Learn__

    ---

    From a specific [`example`](#learn-by-example). Or by looking at the :octicons-code-16: [`source code`](https://github.com/Javanaut-community/design-patterns/tree/main/com/javadesignpatterns/creational/builder) on Github. Or by discussing it in the :people_hugging: [`community`](https://javanauts.dev)

    [:octicons-arrow-right-24: Getting started](#learn-by-example)

-   :simple-instructure:{ .lg .middle } __Structure__

    ---

    A separate Builder class with methods to set different properties and a build() method that constructs and returns the final object,

    [:octicons-arrow-right-24: Reference](#structure)

-   :material-format-font:{ .lg .middle } __Use when__

    ---

    You need to create different but similar objects. Or you want to build an object with lots of optional parameters

-   :material-code-tags:{ .lg .middle } __Implementation__

    ---

    Implement using  [`lazy initialization`](#lazy-initialization), or [`Thread safe`](#thread-safe-singleton) or as an [`enum`](#enum-singleton).

    [:octicons-arrow-right-24: Reference](#singleton-pattern-implementation)

</div>

The Builder pattern is particularly useful when dealing with objects that have a large number of optional parameters. Instead of creating multiple constructors with different parameter combinations, developers can create a separate Builder class that allows them to set each parameter step by step. This approach makes it easier to create objects with a large number of optional parameters, and also makes the code more readable and maintainable.

In Java, the Builder pattern is implemented using a separate Builder class that has methods for setting each parameter. The Builder class is then used to create the final object, which can be done in a single method call. This approach makes it easy to create complex objects with a large number of optional parameters, while also ensuring that the object is created in a consistent and efficient way.

This catalog is managed by Java experts:

[Visit the Javanauts community](https://javanauts.dev){ .md-button .md-button--primary }

## Learn by example
Lets consider an application that creates a query to different databases. One to an SQL database and one for a MongoDB database. We begin with a simple Query interface:

``` java
--8<-- "com/javadesignpatterns/creational/builder/Query.java"
```
With two implementations, one for SQL: 
``` java
--8<-- "com/javadesignpatterns/creational/builder/MongoDbQuery.java"
```
And one for MongoDB:
``` java
--8<-- "com/javadesignpatterns/creational/builder/SqlQuery.java"
```

``` java
--8<-- "com/javadesignpatterns/creational/builder/Builder.java"
```

1. Construction of the SQL Query
2. The MongoDB query can be constructed in exactly the same manner as the MongoDB Query

### The output looks like this:

```java
Executing sqlQuery from: client table where client name = ...
Executing mongoDbQuery from: client table where client name = ...
```

### Issues

- The code to construct the MongoDB and SQL query is identical, yet we have to copy it
- Ideally we can add a forth database without changing much code

### :fontawesome-solid-graduation-cap: The Solution
 In Java, the Builder pattern is implemented by defining a Builder interface that defines the **parts** of the build. 
Each implemenation of that interface constructs the actual object. There is one BuildDirector that uses the Builder interface to construct the individual products.

!!! quote "Builder Pattern Definition"

    Separate the construction of a complex object from its representation so that the same construction process can create different representations.


### Builder Pattern applied to our example

In our example we create a new **QueryBuilder**:

``` java
--8<-- "com/javadesignpatterns/creational/builder/solution/QueryBuilder.java"
```

1. Ability to specify each part of the Query
2. The interface allows one single construction method of a Query and it returns the Query interface

For each Query type we have an implementation of the Query interface:

``` java
--8<-- "com/javadesignpatterns/creational/builder/solution/SQLQueryBuilder.java"
```

1. Holds a reference to the the specific SqlQuery object
2. Uses the internal SqlQuery object to "fill" it up
3. Simply returns the SqlQuery

The **QueryBuildDirectory** takes in the different parts of the building process and the interface to build the Query:

``` java
--8<-- "com/javadesignpatterns/creational/builder/solution/QueryBuildDirector.java"
```

1. Take in all the parts and build the Query


## :material-radio-tower: Builder Pattern Basics

!!! quote "Intent"

    The Singleton pattern restricts the instantiation of a class to a single instance and ensures that the instance is globally accessible. In other words, it guarantees that only one instance of a class is created and provides a global point of access to that instance.

##  Structure

=== "Class Diagram"

    ```mermaid
    classDiagram
    class Product {
        -String partA
        -String partB
        -String partC
    }

    class Builder {
        <<interface>>
        +buildPartA() : Builder
        +buildPartB() : Builder
        +buildPartC() : Builder
        +getResult() : Product
    }

    class ConcreteBuilder {
        -Product product
        +buildPartA() : ConcreteBuilder
        +buildPartB() : ConcreteBuilder
        +buildPartC() : ConcreteBuilder
        +getResult() : Product
    }
    
    class Director {
        +construct(builder: Builder)
    }
    
    Product <-- ConcreteBuilder : creates
    ConcreteBuilder ..|> Builder
    Director --> Builder : uses

    ```
=== "Java"

    ```java
    --8<-- "com/javadesignpatterns/creational/builder/solution/BuilderStructure.java"
    ```

    1. **static instance**: Singleton declares a private static instance of the Singleton class. This will hold the sole instance of the class.
    2. **Singleton()** marks the constructor as private to prevent instantiation from outside the class.
    3. **static getInstance()**: Singleton is a public static method that controls access to the singleton instance. This method creates a new instance of the class if one does not already exist, or returns the existing instance if it does.



### Product

The Product is the complex object that is being built. It is the end result of the Builder pattern. In Java, the Product is often a class with several properties and methods. The Product can be a simple object or a complex object with many interdependent parts.

### Builder

The Builder is an interface or an abstract class that specifies the methods to create the parts of the Product. The Builder is responsible for defining the steps required to construct the Product. The Builder class has methods to set the properties of the Product, such as setName() and setAddress().

### Director

The Director is responsible for managing the construction process. It controls the order in which the Builder methods are called to create the Product. The Director is not required in the Builder pattern, but it can be useful in managing complex object construction. The Director can configure the Builder to create different types of Products by changing the order or parameters of the Builder methods.

### Client

The Client is responsible for creating the Director and the Builder, and for initiating the construction of the Product. The Client creates the Director and the Builder, and then passes the Builder to the Director. The Client can then use the Director to configure the Builder and create the Product.

In summary, the Builder pattern is a design pattern that separates the construction of a complex object from its representation. The pattern consists of four main components: Product, Builder, Director, and Client. The Product is the complex object that is being built, the Builder is responsible for defining the steps required to construct the Product, the Director is responsible for managing the construction process, and the Client is responsible for creating the Director and the Builder, and for initiating the construction of the Product.

Implementation of Builder Pattern in Java
-----------------------------------------

The Builder pattern is a creational design pattern that separates the construction of a complex object from its representation, allowing the same construction process to create different representations. In Java, the Builder pattern can be implemented in different ways, including using Java.lang.StringBuilder and Java.lang.StringBuffer abd Lombok’s @Builder Annotation.

### Java.lang.StringBuilder and Java.lang.StringBuffer

Java.lang.StringBuilder and Java.lang.StringBuffer are two classes that implement the Builder pattern in Java. They are both used to construct strings, but StringBuilder is unsynchronized, while StringBuffer is synchronized. Both classes have a similar implementation, with a constructor and a chainable method called append() that adds characters to the string.

``` java
--8<-- "com/javadesignpatterns/creational/builder/StringBuilderExample.java"
```

1. The builder that can assemble different parts
2. Allow to **chain** different methods

### Lombok’s @Builder Annotation

[Lombok’s @Builder Annotation](https://projectlombok.org/features/Builder) is a popular tool used to implement the Builder pattern in Java. It generates a builder class at compile-time, saving developers from writing boilerplate code. The @Builder annotation can be used on classes, constructors, and methods, and it generates a builder class with chainable methods for each field in the annotated class.


Advantages and Disadvantages of Builder Pattern
-----------------------------------------------

The Builder pattern is a widely used design pattern that offers several advantages over other design patterns. Some of the advantages of using the Builder pattern are:

#### 1\. Separation of Concerns

The Builder pattern separates the construction of a complex object from its representation, allowing for the same construction process to create different representations. This separation of concerns allows for greater flexibility in the design and implementation of complex objects.

#### 2\. Method Chaining

The Builder pattern allows for method chaining, which is a technique used to invoke multiple methods on the same object in a single statement. This technique can improve the readability and maintainability of code, as well as reduce the number of lines of code required to create complex objects.

#### 3\. Immutable Objects

The Builder pattern can be used to create immutable objects, which are objects that cannot be modified once they are created. Immutable objects are useful in situations where the state of an object should not change after it has been created, such as in multi-threaded environments.

#### 4\. Fluent API

The Builder pattern can be used to create a fluent API, which is an API that is designed to be easy to read and understand. A fluent API can improve the readability and maintainability of code, as well as reduce the number of lines of code required to create complex objects.

### Disadvantages

While the Builder pattern offers several advantages, it also has some disadvantages. Some of the disadvantages of using the Builder pattern are:

#### 1\. Complexity

The Builder pattern can add complexity to the design and implementation of code, as it requires the creation of multiple classes and interfaces. This can make the code harder to understand and maintain, especially for developers who are not familiar with the Builder pattern.

#### 2\. Naming Convention

The Builder pattern requires the use of a specific naming convention for the methods used to construct the object. This naming convention can be confusing for developers who are not familiar with the Builder pattern, and can make the code harder to read and understand.

In conclusion, the Builder pattern is a powerful design pattern that offers several advantages over other design patterns. However, it also has some disadvantages that should be considered when deciding whether to use the pattern. Developers should carefully weigh the pros and cons of using the Builder pattern before deciding whether to use it in their code.

Comparison with Other Creational Design Patterns
------------------------------------------------

When it comes to creating objects, there are several Creational Design Patterns that can be used in Java. In this section, we will compare the Builder Pattern with two other popular Creational Design Patterns: the Factory Pattern and the Abstract Factory Pattern.

### Factory Pattern

The [Factory Pattern](factory-method-pattern.md) is a Creational Pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. This pattern is useful when there is a need to create a large number of objects of a similar type.

In contrast, the Builder Pattern is used to create complex objects step-by-step. It allows for the construction of objects that require multiple steps, and provides a clear separation between the construction of an object and its representation.

### Abstract Factory Pattern

The [Abstract Factory Pattern](abstract-factory-pattern.md) is another Creational Pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. This pattern is useful when there is a need to create objects that are related to each other, but may have different implementations.

The Builder Pattern, on the other hand, is used to create objects that have a complex construction process, but do not necessarily have a relationship with other objects. It is useful when there is a need to create objects that require multiple steps, and provides a clear separation between the construction of an object and its representation.

Overall, while the Factory Pattern and the Abstract Factory Pattern are useful for creating objects of a similar type or related objects respectively, the Builder Pattern is best suited for creating complex objects with a clear separation between construction and representation.

Best Practices and Considerations
---------------------------------

When using the Builder pattern in Java, there are several best practices and considerations to keep in mind to ensure a well-designed and maintainable codebase.

### Immutable Classes

One of the main benefits of using the Builder pattern is the ability to create immutable classes. Immutable classes are those whose state cannot be modified after creation. This can greatly simplify code and reduce the risk of errors caused by inconsistent state. When using the Builder pattern to create immutable classes, it is important to ensure that all attributes are set during construction and that there are no setter methods.

### Optional Parameters

The Builder pattern can also be used to create classes with optional parameters. This is achieved by providing default values for the optional parameters in the Builder class. This approach can greatly simplify the code and make it more readable.

### Abstraction

The Builder pattern can be used to abstract the process of object creation. By separating the object creation process from the rest of the code, it becomes easier to modify the creation process without affecting the rest of the code. This can be particularly useful when working with complex objects.

### Chained Method Calls

One of the key features of the Builder pattern is the ability to chain method calls. This can greatly simplify the code and make it more readable. However, it is important to ensure that the method chaining does not become too complex, as this can make the code difficult to understand and maintain.

### Naming Convention

When using the Builder pattern, it is important to follow a consistent naming convention. This can make the code more readable and easier to understand. For example, if the class name is `Computer`, the Builder class should be named `ComputerBuilder`.

### Effective Java

The Builder pattern is discussed in detail in the book "Effective Java" by Joshua Bloch. This book provides valuable insights into best practices for designing and implementing the Builder pattern in Java.

### Generate Builder Classes

Many modern IDEs, such as IntelliJ IDEA, provide built-in support for generating Builder classes. This can greatly simplify the process of implementing the Builder pattern.

### Complexity

While the Builder pattern can simplify code, it is important to ensure that it does not introduce unnecessary complexity. If the object being created is simple, it may be more appropriate to use a simpler approach, such as a constructor with optional parameters.

### Null Values

When using the Builder pattern, it is important to handle null values appropriately. This can be achieved by providing default values for optional parameters or by throwing an exception if a required parameter is not provided.

### Dependencies

The Builder pattern can be used to manage dependencies between objects. By using the Builder pattern to create objects and manage their dependencies, it becomes easier to modify the dependencies without affecting the rest of the code. This can be particularly useful when working with large and complex projects.

### Representation

The Builder pattern can be used to represent complex objects in a more readable and understandable way. By separating the object creation process from the rest of the code, it becomes easier to understand how the object is constructed and what its attributes are. This can be particularly useful when working with complex objects, such as those used in scientific or financial applications.

