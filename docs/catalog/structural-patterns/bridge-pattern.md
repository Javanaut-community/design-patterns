## Introduction

![Bridge pattern](../../art/catalog/bridge/bridge.webp){ loading=lazy }

The Bridge design pattern is one of the most commonly used design patterns in Java programming. It is a structural design pattern that decouples an abstraction from its implementation so that both can vary independently. The Bridge pattern is used when there is a need to separate an abstraction from its implementation, allowing them to evolve independently. This pattern is particularly useful when dealing with large and complex software systems that require a high degree of flexibility and scalability.

In Java, the Bridge pattern is implemented using a bridge interface that separates out responsibilities into different abstract classes. The bridge interface uses OOP principles to decouple the abstraction from its implementation. By doing this, the Bridge pattern allows for changes to be made to either the abstraction or the implementation without affecting the other. This makes it easier to maintain and update the software system over time.

Overall, the Bridge design pattern is an essential tool for any Java programmer looking to build large and complex software systems. By decoupling the abstraction from its implementation, the Bridge pattern allows for greater flexibility and scalability, making it easier to maintain and update the software system over time. With its many benefits, it is no wonder that the Bridge pattern has become one of the most widely used design patterns in Java programming.

What is Bridge Design Pattern
-----------------------------

The Bridge design pattern is a structural design pattern that separates an abstraction from its implementation so that both can change independently without affecting each other. It decouples an abstraction from its implementation by creating two separate hierarchies: one for the abstraction (interface or abstract class) and another for the implementation (concrete class).

In simpler terms, the Bridge design pattern is used to decouple an abstraction from its implementation so that they can vary independently. It is useful when you want to create a system that can evolve over time without affecting the client code.

The Bridge design pattern is one of the Gang of Four (GoF) design patterns, which are commonly used in object-oriented programming. It is a good choice when you want to separate the interface from the implementation and allow them to change independently.

The Bridge design pattern is useful when you have a complex system that needs to be broken down into smaller, more manageable parts. By using the Bridge design pattern, you can create a system that is more modular and easier to maintain.

Overall, the Bridge design pattern is a powerful tool for creating flexible and scalable systems. It allows you to separate the interface from the implementation and create a system that can evolve over time without affecting the client code.

Example
--------------------------------
Here's a simple example of the Bridge pattern in Java.

Let's consider a scenario where we have different shapes (e.g., Circle, Square) and different rendering methods (e.g., Red, Green). The Bridge pattern allows us to represent these independently and provide a way to combine them:

```java
// Abstraction
abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

// Refined Abstraction - Circle
class Circle extends Shape {
    private int radius;

    public Circle(Color color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    void draw() {
        System.out.println("Drawing Circle with radius " + radius + " and color " + color.fill());
    }
}

// Refined Abstraction - Square
class Square extends Shape {
    private int side;

    public Square(Color color, int side) {
        super(color);
        this.side = side;
    }

    @Override
    void draw() {
        System.out.println("Drawing Square with side " + side + " and color " + color.fill());
    }
}

// Implementor interface
interface Color {
    String fill();
}

// Concrete Implementor - Red
class Red implements Color {
    @Override
    public String fill() {
        return "Red";
    }
}

// Concrete Implementor - Green
class Green implements Color {
    @Override
    public String fill() {
        return "Green";
    }
}

// Client
public class BridgePatternExample {
    public static void main(String[] args) {
        // Creating shapes with different colors
        Shape redCircle = new Circle(new Red(), 5);
        Shape greenSquare = new Square(new Green(), 8);

        // Drawing shapes
        redCircle.draw();
        greenSquare.draw();
    }
}
```

In this example, we have the Shape abstraction and its refined abstractions, Circle and Square. The Color interface is the implementor interface, and Red and Green are concrete implementors. The Shape abstraction delegates the color-filling functionality to the Color interface, allowing different shapes to be combined with different colors independently.

This separation allows us to add new shapes or colors without modifying the existing code, adhering to the open/closed principle and promoting code flexibility and maintainability.

Key Components of Bridge Pattern
--------------------------------

The Bridge design pattern is a structural design pattern that decouples an abstraction from its implementation so that both can vary independently. The pattern consists of four key components: Abstraction, Refined Abstraction, Implementer, and Concrete Implementer.

### Abstraction

The Abstraction is the core of the Bridge design pattern and defines the crux of the problem. It represents the high-level interface that clients use to interact with the system. This interface is defined as an abstract class or interface that contains a reference to the Implementer.

### Refined Abstraction

The Refined Abstraction extends the Abstraction and takes the finer details one level below. It hides the finer elements from the Implementer and provides a more specific interface to the client.

### Implementer

The Implementer is an interface that defines the interface for implementation classes. It represents the low-level interface that provides the basic operations that the Abstraction needs to perform its tasks. The Implementer interface is typically defined as an abstract class or an interface.

### Concrete Implementer

The Concrete Implementer is a concrete class that implements the Implementer interface. It provides the actual implementation of the low-level operations defined by the Implementer interface. The Concrete Implementer is responsible for providing the actual implementation of the Abstraction's interface.

In summary, the Bridge design pattern is a powerful tool for decoupling an abstraction from its implementation. It provides a flexible and extensible framework for designing complex systems. By separating the abstraction from its implementation, the Bridge pattern allows both to evolve independently, making it easier to maintain and modify the system over time.

Understanding Class Hierarchies
-------------------------------

In object-oriented programming, class hierarchies refer to the relationships between classes that are organized in a hierarchical structure. A class hierarchy is a way of organizing related classes in a logical and meaningful way. In Java, class hierarchies are built using inheritance, where subclasses inherit properties and methods from their parent classes.

The Bridge design pattern is particularly useful when working with class hierarchies. It allows the separation of the abstraction and implementation hierarchies, so that they can vary independently of each other. This means that changes to one hierarchy will not affect the other, making the code more flexible and easier to maintain.

Orthogonal class hierarchies are a specific type of class hierarchy that can be mapped using the Bridge design pattern. Orthogonal hierarchies are a set of hierarchies that are independent of each other, but that need to be used together. For example, in a graphical user interface, there might be a hierarchy of shapes (such as squares, triangles, and circles) and a hierarchy of colors (such as red, blue, and green). These hierarchies are independent of each other, but they need to be used together to draw shapes in different colors.

Using the Bridge design pattern, the abstraction interface is published in a separate inheritance hierarchy, while the implementation is put in its own hierarchy. This allows the implementation to be changed without affecting the abstraction, and vice versa. The bridge is designed up-front to allow the abstraction and implementation to vary independently, making the code more flexible and easier to maintain.

In conclusion, understanding class hierarchies is essential when working with the Bridge design pattern in Java. By using inheritance to create hierarchies of classes, developers can organize related classes in a logical and meaningful way. The Bridge design pattern allows the separation of the abstraction and implementation hierarchies, making the code more flexible and easier to maintain. Orthogonal class hierarchies can be mapped using the Bridge design pattern, allowing independent hierarchies to be used together.

Bridge Pattern Vs Adapter Pattern
---------------------------------

Both Bridge and [Adapter Pattern](adapter-pattern.md) are used to decouple an abstraction from its implementation, but they do it in different ways.

The Adapter pattern is used when you have existing code that needs to be adapted to a new interface. It makes things work after they're designed. In other words, it adapts the interface of a class to be compatible with another interface. This pattern is useful when you have existing code that is out of your control or not changeable to meet the interface you need it to.

On the other hand, the Bridge pattern is used when you want to make things work before they are designed. It separates an abstraction from its implementation so that both can vary independently without impacting each other. This pattern decouples the abstraction and its implementation by creating two separate hierarchies, one for the abstraction and one for the implementation. This makes it easier to modify and extend the system without affecting its functionality.

In summary, the Adapter pattern is used to adapt an existing interface to a new one, while the Bridge pattern is used to decouple an abstraction from its implementation. Both patterns are useful in different situations, and it's important to choose the right one for your specific needs.

Implementation of Bridge Pattern in Java
----------------------------------------

The Bridge pattern is a structural design pattern that separates an object's interface from its implementation, allowing them to vary independently. In Java, the Bridge pattern is implemented using interfaces, abstract classes, and inheritance.

To implement the Bridge pattern in Java, developers create two separate hierarchies: the abstraction hierarchy and the implementation hierarchy. The abstraction hierarchy defines the high-level interface that clients use to interact with the system. The implementation hierarchy defines the low-level implementation details.

The abstraction hierarchy is implemented using an abstract class or interface, and the implementation hierarchy is implemented using concrete classes that extend the abstract class or interface. The abstraction hierarchy contains a reference to the implementation hierarchy, which is passed to it at run-time.

When the abstraction hierarchy needs to perform a task, it delegates the task to the implementation hierarchy. This allows the implementation to vary independently of the abstraction, and vice versa.

One advantage of using the Bridge pattern in Java is that it allows developers to change the implementation of a system at run-time. This can be useful when different implementations are required for different situations, or when the implementation needs to be changed dynamically based on user input.

Another advantage of using the Bridge pattern in Java is that it promotes loose coupling between the abstraction and implementation hierarchies. This makes the system more flexible and easier to maintain.

Overall, the Bridge pattern is a powerful tool for creating flexible and extensible systems in Java. By separating the interface from the implementation, developers can create systems that are easier to maintain, more flexible, and more adaptable to changing requirements.

Understanding Decoupling and Composition
----------------------------------------

The Bridge design pattern in Java is all about decoupling an abstraction from its implementation so that the two can vary independently. This means that the pattern separates out responsibilities into different abstract classes using OOP principles.

Decoupling refers to the process of separating two entities, such as classes or objects, so that they are not tightly coupled to each other. In the context of the Bridge pattern, decoupling refers to separating the abstraction from its implementation. This allows the two to change independently without affecting each other, making the system more flexible and easier to maintain.

Composition is another important concept in the Bridge pattern. It refers to the process of building complex objects by combining simpler ones. In the context of the Bridge pattern, composition is preferred over inheritance. This means that the pattern uses composition to create a bridge interface between the abstraction and its implementation, rather than relying on inheritance.

Composition over inheritance is a design principle that suggests that classes should use composition instead of inheritance to achieve code reuse and flexibility. This is because inheritance can lead to tight coupling between classes, making the system more complex and harder to maintain. Composition, on the other hand, allows for more flexible and modular code, making it easier to change and extend.

In summary, the Bridge design pattern in Java uses decoupling and composition to create a flexible and maintainable system. By separating the abstraction from its implementation and using composition over inheritance, the pattern allows for independent changes to both parts, making it easier to modify and extend the system over time.

Bridge Pattern and Inheritance
------------------------------

The Bridge pattern is a design pattern that uses composition instead of inheritance to decouple an abstraction from its implementation. This means that the implementation details can be changed without affecting the abstraction or the client code that uses it.

Inheritance is a mechanism in Java that allows a class to inherit properties and methods from its parent class. Subclassing is the process of creating a new class that inherits from an existing class. Inheritance and subclassing are powerful features of object-oriented programming, but they can also lead to tight coupling between classes.

The Bridge pattern avoids this problem by using composition instead of inheritance. It separates the abstraction and implementation into two separate hierarchies, which are then connected by a bridge interface. This allows the abstraction and implementation to vary independently, without affecting each other.

In the Bridge pattern, the abstraction defines the interface for the client code, while the implementation provides the actual implementation of the interface. The bridge interface connects the two, allowing the client code to use the abstraction without knowing anything about the implementation details.

One advantage of using the Bridge pattern is that it makes it easier to add new implementations without affecting the existing client code. For example, if a new implementation is added, the client code does not need to be modified. The new implementation can simply be connected to the existing abstraction using the bridge interface.

Another advantage of the Bridge pattern is that it makes it easier to test the code. The abstraction and implementation can be tested separately, which makes it easier to isolate and fix bugs.

Overall, the Bridge pattern is a powerful and flexible design pattern that can be used to decouple an abstraction from its implementation. By using composition instead of inheritance, it allows the abstraction and implementation to vary independently, without affecting each other.

Practical Examples of Bridge Pattern
------------------------------------

The Bridge design pattern can be used in various practical scenarios. Here are some examples of how it can be implemented in Java:

### Example 1: Vehicle Manufacturing

Suppose a vehicle manufacturing company wants to produce different types of vehicles like cars, buses, and bikes. The company also wants to produce these vehicles in different locations, which have different workshops for assembling the vehicles. The company can use the Bridge pattern to decouple the vehicle's implementation from its abstraction.

The vehicle abstraction can be defined as an abstract class or interface, which will be implemented by different types of vehicles like cars, buses, and bikes. The vehicle implementation can be defined as another abstract class or interface, which will be implemented by different workshops for assembling the vehicles.

By using the Bridge pattern, the company can produce different types of vehicles in different workshops without affecting the vehicle's implementation. For example, the car can be assembled in a workshop that specializes in car assembly, and the bus can be assembled in a workshop that specializes in bus assembly.

### Example 2: Platform Independence

Suppose a software company wants to develop a software application that can run on different platforms like Windows, Linux, and Mac. The company can use the Bridge pattern to decouple the software application's implementation from its abstraction.

The software application abstraction can be defined as an abstract class or interface, which will be implemented by different platforms like Windows, Linux, and Mac. The software application implementation can be defined as another abstract class or interface, which will be implemented by different software developers for different platforms.

By using the Bridge pattern, the company can develop a software application that can run on different platforms without affecting the software application's implementation. For example, the software application can be developed by a software developer who specializes in Windows development, and the same software application can be developed by a software developer who specializes in Mac development.

### Example 3: Remote Control

Suppose a company wants to develop a remote control for different types of electronic devices like TV, DVD, and AC. The company can use the Bridge pattern to decouple the remote control's implementation from its abstraction.

The remote control abstraction can be defined as an abstract class or interface, which will be implemented by different types of electronic devices like TV, DVD, and AC. The remote control implementation can be defined as another abstract class or interface, which will be implemented by different remote control manufacturers for different types of electronic devices.

By using the Bridge pattern, the company can develop a remote control that can work with different types of electronic devices without affecting the remote control's implementation. For example, the remote control can be developed by a remote control manufacturer who specializes in TV remote control, and the same remote control can be developed by a remote control manufacturer who specializes in DVD remote control.

In conclusion, the Bridge pattern is a powerful design pattern that can be used in various practical scenarios. It helps to decouple the implementation from its abstraction, which makes the system more flexible and adaptable. By using the Bridge pattern, a company can produce different types of vehicles, develop software applications for different platforms, and develop a remote control for different types of electronic devices.


Benefits and Drawbacks of Bridge Pattern
----------------------------------------

The Bridge design pattern provides some benefits over other design patterns, but it also has some drawbacks.

### Benefits

#### Loose Coupling

One of the main benefits of the Bridge pattern is that it promotes loose coupling between the abstraction and implementation. This means that changes in one do not affect the other. The abstraction and implementation can evolve independently, making the system more flexible and easier to maintain.

#### Encapsulation

The Bridge pattern encapsulates the implementation details from the client code. This means that the client code only needs to know about the abstraction, which simplifies the code and makes it easier to understand.

#### Aggregation

The Bridge pattern uses aggregation instead of inheritance, which allows for more flexibility in the implementation. The implementation can be changed at runtime by swapping out the implementor object, which is not possible with inheritance.

#### Compile-time Binding

The Bridge pattern uses compile-time binding, which means that the implementation can be changed without affecting the client code. This makes the system more extensible and easier to maintain.

### Drawbacks

#### Complexity

One potential drawback of the Bridge pattern is that it can add complexity to the system. The separation of interface and implementation can be more difficult to understand and maintain than a simple inheritance hierarchy.

#### Extensibility

The Bridge pattern can be less extensible than other design patterns. Adding new abstractions or implementations can require changes to the existing code, which can be time-consuming and error-prone.

In conclusion, the Bridge pattern provides some benefits over other design patterns, such as loose coupling and encapsulation, but it also has some drawbacks, such as complexity and extensibility. It is important to weigh the benefits and drawbacks carefully when deciding whether to use the Bridge pattern in a particular system.

Conclusion
----------

In conclusion, the Bridge design pattern is a useful pattern for decoupling an abstraction from its implementation. It allows for flexibility and scalability in software development by separating the two components so that they can vary independently.

The Bridge pattern is particularly useful when a parent abstract class defines a set of basic rules, and the concrete classes add additional rules. This pattern ensures that the abstraction and implementation can evolve independently, making it easier to maintain and modify the codebase.

While the Bridge pattern may not be appropriate for every situation, it is a valuable tool to have in a developer's toolkit. It can be applied to a wide range of programming scenarios, from web applications to desktop software.

In terms of clients, the Bridge pattern is beneficial for clients who require a flexible and scalable solution. It allows them to modify the implementation without affecting the abstraction, which can save time and money in the long run.

Overall, the Bridge pattern is a powerful design pattern that can help developers create more flexible and scalable software solutions. By decoupling the abstraction and implementation, it allows for greater flexibility and adaptability, making it a valuable tool for developers across a wide range of industries.