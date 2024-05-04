#Overview

## :material-tools: Creational Patterns

Creational design patterns are a category of design patterns in software engineering that deal with object creation mechanisms. The aim of these patterns is to create objects in a manner suitable to the situation, enhancing flexibility and reuse of existing code. Rather than creating objects directly using constructors, these patterns provide a way to encapsulate and abstract the instantiation process. This helps to make a system independent of how its objects are created, composed, and represented.


### :material-table: Creational Patterns List

| Pattern                                                                | Description                          | Usage                                                                                                                                                                                                                                             | 
|------------------------------------------------------------------------|--------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 🌐 [Singleton](creational-patterns/singleton-pattern.md)               | Ensures that a class has only one instance, and provides a global point of access to it. This is useful when exactly one object is needed to coordinate actions across the system.  | Used in logging, database connections, and configuration settings where a single shared resource is operated upon by various parts of an application.                                                                                             |
| 🛠️ [Builder](creational-patterns/builder-pattern.md)                  | Separates the construction of a complex object from its representation, allowing the same construction process to create different representations. This pattern is especially useful for creating complex objects step by step. | Commonly used in the creation of complex or composite objects with multiple parts and configurations, such as building different types of documents (like HTML, PDF, etc.), UIs, or complex data objects.                                         |
| 🏭 [Abstract Factory](creational-patterns/abstract-factory-pattern.md) | Provides an interface for creating families of related or dependent objects without specifying their concrete classes. This pattern allows a client to work with various product families without being tied to the concrete classes of the products. | Widely used in UI toolkits and libraries to manage and maintain families of objects like buttons, checkboxes, and windows that share a common theme or platform dependency without hard-coding their classes.                                     |
| 🧱 [Factory Method](creational-patterns/factory-method-pattern.md)     | Defines an interface for creating an object, but lets subclasses decide which class to instantiate. The Factory Method lets a class defer instantiation to subclasses. | Utilized in applications where class instantiation may depend on user input or configuration settings. It's often seen in application frameworks where the library code needs to instantiate classes that are extended by application developers. |
| 🔁 [Prototype](creational-patterns/prototype-pattern.md)               | Used to create duplicate objects while keeping performance in mind. This pattern involves copying existing objects without the intricacies of creating them from scratch, typically using a 'clone' method. | Useful in scenarios where object creation is costly or complex but a similar object is already existing. This pattern is often used in gaming for creating multiple instances of complex objects like characters, trees, or even entire levels.   |


## :material-tools: Behavioral Patterns

Creational design patterns are a category of design patterns in software engineering that deal with object creation mechanisms. The aim of these patterns is to create objects in a manner suitable to the situation, enhancing flexibility and reuse of existing code. Rather than creating objects directly using constructors, these patterns provide a way to encapsulate and abstract the instantiation process. This helps to make a system independent of how its objects are created, composed, and represented.


### :material-table: Behavioral Patterns List