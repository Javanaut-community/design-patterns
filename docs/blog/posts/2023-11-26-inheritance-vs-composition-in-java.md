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
In Java, inheritance and composition are two major concepts that are widely used in object-oriented programming. Both of these concepts are used to create relationships between classes and objects, and they play an important role in designing software applications. Inheritance is a mechanism that allows a new class to be based on an existing class, whereas composition is a technique that enables a class to be composed of objects of other classes.

<!-- more -->
The main difference between inheritance and composition is that inheritance is an "is-a" relationship, while composition is a "has-a" relationship. In other words, inheritance is used when a new class is a specialized version of an existing class, whereas composition is used when a class is composed of one or more instances of other classes. Inheritance is a powerful mechanism that allows developers to reuse code and create a hierarchy of classes, whereas composition is a flexible technique that allows developers to create complex objects by combining simpler objects.

Understanding the difference between inheritance and composition is crucial for designing software applications that are flexible, maintainable, and extensible. By choosing the right design pattern based on these concepts, developers can create software applications that are easier to understand, modify, and test. In the following sections, we will explore the differences between inheritance and composition in more detail and how they affect design patterns.

Understanding Inheritance and Composition in Java
-------------------------------------------------

Java is an object-oriented programming language that supports both inheritance and composition. These two concepts play a crucial role in designing software systems. Inheritance and composition are used to create relationships between classes, which can help to reuse code and make the code more modular.

### Inheritance in Java

Inheritance is a mechanism in Java that allows a class to inherit properties and behavior from another class. The class that inherits properties and behavior is called the subclass, and the class that provides properties and behavior is called the superclass. The subclass can access the properties and behavior of the superclass using the "extends" keyword. Java supports three types of inheritance: single inheritance, hierarchical inheritance, and multilevel inheritance.

Single inheritance means that a subclass can inherit properties and behavior from only one superclass. Hierarchical inheritance means that multiple subclasses can inherit properties and behavior from a single superclass. Multilevel inheritance means that a subclass can inherit properties and behavior from a superclass, which in turn can inherit properties and behavior from another superclass, and so on.

### Composition in Java

Composition is a mechanism in Java that allows a class to contain objects of other classes. The class that contains objects is called the composite class, and the objects that are contained are called component classes. Composition is used to create a "has-a" relationship between classes.

Composition allows for greater flexibility in designing software systems. It allows the composite class to change the behavior of the component classes without changing their implementation. It also allows for greater code reuse, as the same component classes can be used in multiple composite classes.

In Java, composition is implemented by creating an instance of the component class within the composite class. The composite class can then call methods on the instance of the component class to access its properties and behavior.

In summary, inheritance and composition are two important concepts in Java that are used to create relationships between classes. Inheritance creates an "is-a" relationship between classes, while composition creates a "has-a" relationship between classes. Both inheritance and composition can be used to create modular, reusable code, but they have different use cases. Inheritance is useful when creating a hierarchy of classes, while composition is useful when creating a composite class that contains objects of other classes.

Effects on Design Patterns
--------------------------

Inheritance and Composition are two fundamental concepts in Java that have a significant impact on the design patterns used in software development. Both inheritance and composition allow for code reuse and flexibility in design, but they differ in their implementation and the effects they have on design patterns.

### Influence of Inheritance

Inheritance is a design pattern that allows a subclass to inherit the attributes and behaviors of its superclass. This pattern is useful in situations where a new class can be created by extending an existing class, and the new class can reuse the code of the existing class. Inheritance is used in several design patterns, including the Layer Supertype Pattern and the Template Method Pattern.

The Layer Supertype Pattern is a design pattern that uses inheritance to create a superclass that contains common attributes and behaviors shared by several subclasses. This pattern promotes code reuse and reduces duplication. The Template Method Pattern is another design pattern that uses inheritance to define a skeleton of an algorithm in a superclass, with specific steps implemented in subclasses. This pattern promotes flexibility and allows for variations in the implementation of the algorithm.

However, inheritance can also create dependencies between classes, making it difficult to modify the superclass without affecting its subclasses. This violates the Liskov Substitution Principle, which states that subclasses should be able to substitute for their superclasses without affecting the correctness of the program. Therefore, inheritance should be used judiciously to avoid creating tight coupling and dependencies between classes.

### Influence of Composition

Composition is a design pattern that involves creating objects that contain other objects. This pattern is useful in situations where a class needs to use the functionality of another class without inheriting from it. Composition is used in several design patterns, including the Decorator Pattern and the Strategy Pattern.

The Decorator Pattern is a design pattern that uses composition to add functionality to an object dynamically. This pattern promotes flexibility and allows for the addition of new features without modifying the existing code. The Strategy Pattern is another design pattern that uses composition to encapsulate a family of algorithms and make them interchangeable. This pattern promotes flexibility and allows for the selection of algorithms at runtime.

Composition promotes flexibility and reduces dependencies between classes, making it easier to modify the code without affecting other parts of the program. However, composition can also create more objects and increase the complexity of the code.

In conclusion, both inheritance and composition have their advantages and disadvantages, and the choice between them depends on the specific requirements of the program. Design patterns should be used judiciously to promote flexibility, reduce dependencies, and maintain the correctness of the program.

Practical Examples in Java
--------------------------

### Inheritance Example

Inheritance is a mechanism in object-oriented programming that allows a class to inherit properties and behavior from a parent class. In Java, a subclass can inherit fields, methods, and constructors from a superclass. For example, consider a `Vehicle` class with a `type` attribute and a `drive()` method. A `Car` class can inherit from the `Vehicle` class and add its own attributes and methods, such as `numDoors` and `honk()`.

```java
    class Vehicle {
        String type;
        void drive() {
            System.out.println("Driving a " + type);
        }
    }
    
    class Car extends Vehicle {
        int numDoors;
        void honk() {
            System.out.println("Honking the horn");
        }
    }
```
In this example, the `Car` class is a subclass of the `Vehicle` class, and it inherits the `type` attribute and `drive()` method. The `Car` class also adds its own `numDoors` attribute and `honk()` method. This is an example of the "is-a" relationship, where a `Car` is a type of `Vehicle`.

### Composition Example

Composition is another mechanism in object-oriented programming that allows a class to reuse code from other classes by creating objects of those classes. In Java, a class can have an instance variable that refers to an object of another class. For example, consider a `House` class with a `LivingRoom` object and a `Cat` object.

```java
    class LivingRoom {
        int numWindows;
        void watchTV() {
            System.out.println("Watching TV");
        }
    }
    
    class Cat {
        String name;
        void meow() {
            System.out.println("Meow");
        }
    }
    
    class House {
        LivingRoom livingRoom;
        Cat cat;
        House() {
            livingRoom = new LivingRoom();
            cat = new Cat();
        }
    }
```

In this example, the `House` class has instance variables for a `LivingRoom` object and a `Cat` object. The `House` class creates instances of these objects in its constructor. This is an example of the "has-a" relationship, where a `House` has a `LivingRoom` and a `Cat`.

### Java Design Patterns

Inheritance and composition are two important concepts in Java programming that have an impact on design patterns. Inheritance can be used to create a hierarchy of classes that share common behavior, while composition can be used to reuse code from other classes without creating a hierarchy.

For example, the decorator pattern is a design pattern that uses composition to add behavior to objects at runtime. In this pattern, a decorator class wraps an object and adds behavior to it. The decorator class has the same interface as the wrapped object, so it can be used in place of the wrapped object. This pattern allows behavior to be added to an object without changing its class or modifying its code.

On the other hand, the strategy pattern is a design pattern that uses inheritance to encapsulate algorithms and make them interchangeable. In this pattern, a superclass defines a common interface that is implemented by subclasses. Each subclass implements a different algorithm, and the superclass can use any of the subclasses interchangeably. This pattern allows algorithms to be encapsulated and reused without affecting the clients that use them.

Overall, both inheritance and composition have their benefits and drawbacks, and the choice between them depends on the specific requirements of the job at hand. Inheritance can be useful for creating a hierarchy of classes that share common behavior, while composition can be useful for reusing code from other classes without creating a hierarchy.

