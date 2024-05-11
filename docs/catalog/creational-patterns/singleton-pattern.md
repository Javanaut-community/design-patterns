## Introduction
The Singleton pattern is a popular design pattern in Java that
ensures a class has only one instance and provides a global point
of access to that instance. This pattern is widely used in situations
where there is a need for a single object to coordinate actions across
the system.

![Singleton Glowing Orb](../../art/catalog/singleton/glowing-orb.png){ loading=lazy }

<div class="grid cards" markdown>

-   :fontawesome-solid-graduation-cap:{ .lg .middle } __Learn__

    ---

    From a specific [`example`](#learn-by-example). Or by looking at the :octicons-code-16: [`source code`](https://github.com/Javanaut-community/design-patterns/tree/main/com/javadesignpatterns/creational/singleton) on Github. Or by discussing it in the :people_hugging: [`community`](#https://javanaut.community)

    [:octicons-arrow-right-24: Getting started](#learn-by-example)

-   :simple-instructure:{ .lg .middle } __Structure__

    ---

    A private constructor, a private static instance variable, and a public static method that returns the single instance, creating it if necessary.

    [:octicons-arrow-right-24: Reference](#structure)

-   :material-format-font:{ .lg .middle } __Use when__

    ---

    Only one (or limited set) of instances of a class should be allowed at Runtime.

-   :material-code-tags:{ .lg .middle } __Implementation__

    ---

    Implement using  [`lazy initialization`](#lazy-initialization), or [`Thread safe`](#thread-safe-singleton) or as an [`enum`](#enum-singleton).

    [:octicons-arrow-right-24: Reference](#singleton-pattern-implementation)

</div>

## Learn by example
Lets consider an application that paints a window on screen in a certain color. To
make it easy to change that color, we'll create a Preferences class that holds the color. 
The Window class then "uses" the color to to paint the window. The example looks like this: 

``` java
--8<-- "com/javadesignpatterns/creational/singleton/Preferences.java"
```

1. :question: What color will be used to paint the window?

### The output looks like this:

```java
Painting window: blue
Painting window: blue 
```
The color black is lost since the Window only has a reference to the original Preference instance.

### Issues

- There really should only be **one instance** of the Preference class at runtime
- The Java runtime should guarantee that there is only one instance. It should not be possible to create another "by accident".
- It should be **easy to access** that single instance.

### :fontawesome-solid-graduation-cap: The Solution
 In Java, the Singleton pattern is implemented by defining a
class with a private constructor and a static method that returns the instance of the class.

!!! quote "Singleton Pattern Definition"

    Ensure a class only has **one instance**, and provide
    **a global point** of access to it.

The Singleton pattern is often used in situations where there is a need to limit the number of instances of a class to one. This can be useful in a variety of scenarios, such as when working with database connections, logging, and caching. By ensuring that there is only one instance of a class, the Singleton pattern can help to reduce memory usage and improve performance.

Implementing the Singleton pattern in Java can be a bit tricky, as there are several different approaches that can be used. Some of the most common approaches include using a private constructor, a static method, and a static variable to store the instance of the class. While the Singleton pattern can be a powerful tool for managing resources and improving performance, it is important to use it judiciously and to consider the potential drawbacks, such as increased complexity and reduced flexibility.

### Singleton Pattern applied to our example

In our example the **Preferences** class is implemented as a Singleton

``` java
--8<-- "com/javadesignpatterns/creational/singleton/solution/Preferences.java"
```

1. The **Preferences** class has a private static instance variable to hold the single instance of the class.
2. The constructor is private to prevent instantiation from outside the class.
3. The **getInstance()** method is public and provides access to the single instance. If the instance doesn't exist, it creates one; otherwise, it returns the existing instance.
4. The **Window** now directly uses the **Preferences** class
5. The **Preferences** class can be accessed from everywhere and the colour can be changed


## :material-radio-tower: Singleton Pattern Basics

!!! quote "Intent"

    The Singleton pattern restricts the instantiation of a class to a single instance and ensures that the instance is globally accessible. In other words, it guarantees that only one instance of a class is created and provides a global point of access to that instance.

##  Structure

=== "Class Diagram"

    ```mermaid
    classDiagram
        class Singleton {
            -static instance: Singleton
            -Singleton()
            +static getInstance(): Singleton
        }
    ```
=== "Java"

    ```java
    --8<-- "com/javadesignpatterns/creational/singleton/solution/Singleton.java"
    ```

    1. **static instance**: Singleton declares a private static instance of the Singleton class. This will hold the sole instance of the class.
    2. **Singleton()** marks the constructor as private to prevent instantiation from outside the class.
    3. **static getInstance()**: Singleton is a public static method that controls access to the singleton instance. This method creates a new instance of the class if one does not already exist, or returns the existing instance if it does.

### Usage

The Singleton pattern is commonly used in situations where only one instance of a class is required to coordinate actions across a system. It is often used in situations where it is important to limit the number of instances of a class that can be created, such as with database connections, thread pools, and configuration settings.

### :fontawesome-solid-face-smile: Benefits

The Singleton pattern offers a number of benefits, including:

- **Global access to a single instance**: By ensuring that only one instance of a class is created, the Singleton pattern provides a global point of access to that instance, making it easy to coordinate actions across a system.

- **Thread safety**: The Singleton pattern ensures that only one instance of a class is created, which prevents issues with thread safety that can arise when multiple threads attempt to access the same resource.

- **Memory conservation**: By limiting the number of instances of a class that can be created, the Singleton pattern helps conserve memory and improves performance.

### :fontawesome-solid-person-military-pointing: Drawbacks

Despite its many benefits, the Singleton pattern also has a few drawbacks, including:

- **Difficulty with testing**: Because the Singleton pattern relies on a single instance of a class, it can be difficult to test code that uses the Singleton.

- **Potential for abuse**: Because the Singleton pattern provides global access to a single instance of a class, it can be tempting to overuse the pattern, which can lead to issues with maintainability and scalability.

- **Dependency injection issues**: Because the Singleton pattern relies on a single instance of a class, it can be difficult to use dependency injection frameworks that rely on creating multiple instances of a class.

## Singleton Pattern Implementation

Singleton pattern is a design pattern that restricts the instantiation of a class to a single instance and provides a global point of access to that instance. In Java, there are several ways to implement the Singleton pattern, including Eager Initialization, Lazy Initialization, Thread Safe Singleton, Bill Pugh Singleton, and Enum Singleton.

### Eager Initialization

Eager initialization is the simplest way to implement the Singleton pattern. In this approach, the instance of the Singleton class is created at the time of class loading. This approach is not recommended for large Singleton classes as it may cause performance issues.

```java
public class Singleton {
    private static final Singleton INSTANCE = new Singleton(); //(1)!

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

1. Directly initialise the Singleton when the Java runtime starts. 🚀

### Lazy Initialization

Lazy initialization creates the Singleton instance only when it is required, i.e., when the **getInstance()** method is called for the first time. This approach is recommended for larger Singleton classes.

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) { //(1)!
            instance = new Singleton();
        }
        return instance;
    }
}
```

1. Only create the singleton when it is called. This is at runtime and only when needed.

### Thread Safe Singleton

Thread-safe Singleton ensures that the Singleton instance is created only once in a multi-threaded environment. It uses synchronization to prevent multiple threads from creating multiple instances.

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() { //(1)!
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

1. The synnchronised keyword ensure thread safety

### Bill Pugh Singleton
Bill Pugh Singleton is a thread-safe implementation that uses a static inner class to create the Singleton instance. This approach is recommended as it doesn't require synchronization and is lazily loaded.

```java
public class Singleton {
    private Singleton() {
    }

    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static  getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
```

### Enum Singleton
Enum Singleton is a simple, thread-safe, and serializable implementation that uses an enum type to create the Singleton instance.

```java
public enum Singleton {
    INSTANCE;
    // add methods and properties here
}
```

## :fontawesome-solid-users-rays: Usage of Singleton Pattern in Java
The Singleton pattern finds widespread use in Java programming:

### Java Runtime Environment
The Java Runtime Environment (JRE) employs the Singleton pattern to ensure that critical components like the Java Virtual Machine (JVM) are only instantiated once.

### Spring Framework
The Spring Framework utilizes the Singleton pattern to manage the lifecycle of objects, ensuring that only one instance of a given bean is created and managed by the framework.

### Java Logging API
The Java Logging API, a standard logging framework, uses the Singleton pattern to guarantee that only one instance of the logging system is created and used consistently.

### Comparisons and Alternatives
Singleton vs Static Class
While both Singleton pattern and static classes serve the purpose of ensuring only one instance exists, they differ in key aspects. A static class contains only static methods and variables, used primarily for grouping related functionality and data. The Singleton pattern allows instantiation and is created only when required.

### Singleton vs Multiton
Multiton is similar to Singleton but allows for multiple instances with unique keys. It's useful when managing a limited number of instances, each with a unique identifier.

### Alternatives to Singleton
Depending on specific requirements, alternatives like Dependency Injection, Factory Pattern, and Object Pool Pattern can be considered.

## Conclusion
The Singleton pattern is a powerful tool in Java development. It ensures a class has only one instance and provides a global point of access to that instance. However, it's important to use it judiciously, considering potential trade-offs. With proper use and careful consideration, the Singleton pattern can enhance application performance and reliability.