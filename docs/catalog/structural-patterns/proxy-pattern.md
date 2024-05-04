The Proxy Design Pattern is a structural design pattern that provides a surrogate or placeholder for another object to control access to it. It is used to create a wrapper around the main object's complexity from the client. The proxy pattern is used when we need to represent an object located remotely. Talking to the real object might involve marshalling and unmarshalling of data and talking to the remote object.

In Java, the Proxy Design Pattern is used extensively in various frameworks and libraries to provide a layer of abstraction between the client and the actual implementation. It is used to implement various features such as security, caching, and lazy loading. The proxy pattern is also used to reduce the cost associated with creating fully initialized original objects.

The Proxy Design Pattern in Java is a powerful tool that can be used to simplify the design of a program on its structural level. It provides a way to control access to an object and to add additional functionality to it without changing the original implementation. In the following sections, we will explore the different types of proxies and how they are used in Java.

Understanding Proxy Design Pattern
----------------------------------

The Proxy Design Pattern is a Structural Design Pattern that provides a surrogate or placeholder for another object to control its access. It acts as an intermediary between the client and the real object, hiding the complexity of the real object and providing additional functionality when accessing it.

This pattern is used when we want to create a wrapper around the main object's complexity from the client. It is useful when the real object is heavy to create, or when we want to restrict access to the real object for security reasons. The Proxy Design Pattern is also used when we want to provide additional functionality when accessing the real object.

According to the Gang of Four, the Proxy Design Pattern provides a way to create a representative or surrogate object that can be used in place of the real object. The Proxy object has the same interface as the real object, so the client can use it without knowing that it is not the real object.

The Proxy Design Pattern is a Structural Design Pattern that belongs to the set of Structural Patterns. Structural Patterns are used to simplify the design of a program on its structural level. The Proxy Design Pattern means using a proxy for some other entity.

The Proxy Design Pattern has different types of proxies, such as Remote Proxy, Virtual Proxy, Protection Proxy, and Smart Proxy. The Remote Proxy is responsible for representing the object located remotely. The Virtual Proxy is used when we want a simplified version of a complex or heavy object. The Protection Proxy is used to control access to the real object. The Smart Proxy provides additional functionality when accessing the real object.

In conclusion, the Proxy Design Pattern is a useful design pattern that provides a way to create a surrogate or placeholder for another object to control its access. It is used when we want to create a wrapper around the main object's complexity from the client, or when we want to provide additional functionality when accessing the real object. The Proxy Design Pattern has different types of proxies, such as Remote Proxy, Virtual Proxy, Protection Proxy, and Smart Proxy, each with its own specific use case.

Key Components of Proxy Design Pattern
--------------------------------------

The Proxy Design Pattern is a structural design pattern that provides a surrogate or placeholder for another object to control access to it. It allows for the creation of a representative object that controls access to the original object, thereby providing a level of indirection to support distributed, controlled, or intelligent access. The key components of the Proxy Design Pattern include the Client, Proxy, and Real Subject.

### Client

The Client is the entity that interacts with the Proxy Object. It sends requests to the Proxy Object, which in turn forwards the requests to the Real Subject. The Client and the Proxy Object communicate through a common interface, which enables the Client to treat the Proxy Object and the Real Subject interchangeably.

### Proxy

The Proxy is the entity that acts as an intermediary between the Client and the Real Subject. It provides a surrogate or placeholder for the Real Subject, thereby controlling access to it. The Proxy Object has the same interface as the Real Subject, which enables it to forward requests to the Real Subject. The Proxy Object can also perform additional tasks, such as caching results, validating inputs, or providing security.

### Real Subject

The Real Subject is the entity that contains the actual implementation of the functionality that the Client wants to access. It is the object that the Proxy Object represents. The Real Subject and the Proxy Object have the same interface, which enables the Proxy Object to forward requests to the Real Subject.

In the Proxy Design Pattern, the Client interacts with the Proxy Object, which in turn forwards requests to the Real Subject. The Proxy Object provides a level of indirection that enables it to control access to the Real Subject. The Proxy Object and the Real Subject have the same interface, which enables the Proxy Object to forward requests to the Real Subject.

In summary, the Proxy Design Pattern consists of a Client that interacts with a Proxy Object that provides a surrogate or placeholder for a Real Subject. The Proxy Object and the Real Subject have the same interface, which enables the Proxy Object to forward requests to the Real Subject. The Proxy Object can also perform additional tasks, such as caching results, validating inputs, or providing security.

Types of Proxy Design Pattern
-----------------------------

Proxy Design Pattern can be divided into three main types: Virtual Proxy, Remote Proxy, and Protection Proxy.

### Virtual Proxy

Virtual Proxy is a type of proxy that creates an object only when it is needed. It is used when creating an object is expensive or time-consuming. The Virtual Proxy creates a placeholder for the object and delays its creation until it is actually needed. This can help improve performance and reduce memory usage in certain situations.

### Remote Proxy

Remote Proxy is used to manage objects that are located in different address spaces. It provides a local representation of the object and allows the client to interact with it as if it were local. The Remote Proxy is responsible for communicating with the actual object and forwarding the requests to it. This can be useful when dealing with distributed systems or remote resources.

### Protection Proxy

Protection Proxy is used to control and manage access to an object. It provides an additional layer of security by restricting access to certain methods or properties of an object. The Protection Proxy checks the access rights of the client before allowing it to access the object. This can be useful when dealing with sensitive data or resources that need to be protected.

In summary, Proxy Design Pattern provides a way to control access to an object or resource. It can be used to improve performance, manage distributed systems, or provide an additional layer of security. The different types of Proxy Design Pattern, such as Virtual Proxy, Remote Proxy, and Protection Proxy, can be used in different situations depending on the requirements of the system.

Proxy vs Decorator and Adapter Patterns
---------------------------------------

When it comes to structural patterns in Java, the Proxy pattern is often compared to the Decorator and Adapter patterns. While all three patterns belong to the same category of structural patterns, they have different use cases and implementation details.

### Proxy vs Decorator

The Decorator pattern is used to add new functionality to an existing object without changing its interface. On the other hand, the Proxy pattern is used to control access to an object by creating a surrogate or placeholder object that forwards requests to the real object.

In terms of implementation, both patterns use composition to achieve their goals. However, the Decorator pattern typically adds new behavior to an object by wrapping it with one or more decorators, whereas the Proxy pattern creates a new object that acts as a proxy for the real object.

### Proxy vs Adapter

The Adapter pattern is used to convert the interface of a class into another interface that clients expect. The Proxy pattern, on the other hand, is used to provide a surrogate or placeholder for another object to control access to it.

In terms of implementation, both patterns use composition to achieve their goals. However, the Adapter pattern typically wraps an existing object to provide a new interface, whereas the Proxy pattern creates a new object that acts as a proxy for the real object.

To summarize, the Proxy pattern is used to control access to an object, while the Decorator pattern is used to add new behavior to an object without changing its interface, and the Adapter pattern is used to convert the interface of a class into another interface that clients expect. All three patterns use composition to achieve their goals.

Implementing Proxy Design Pattern in Java
-----------------------------------------

The Proxy Design Pattern is a structural pattern that provides a surrogate or placeholder object to control access to another object. The proxy object acts as an intermediary between the client and the real object, intercepting client requests and forwarding them to the real object only if the client has the necessary permissions. This pattern is useful in scenarios where a client needs to access a remote object, or when the creation of an object is expensive and should be deferred until necessary.

### Java Proxy Class

In Java, the `java.lang.reflect.Proxy` class is used to create dynamic proxy objects that implement a list of interfaces at runtime. The proxy object intercepts method calls made to the interface methods and forwards them to an invocation handler, which can perform additional logic before or after the method call. The `Proxy` class is part of the Java reflection API and is used extensively in frameworks like Spring and Hibernate.

### Java RMI

Java Remote Method Invocation (RMI) is a Java API that allows objects in one JVM to invoke methods on objects in another JVM, even if those objects are running on a different machine. RMI uses the Proxy Design Pattern to create proxy objects that represent remote objects. The client interacts with the proxy object as if it were the real object, and the proxy object forwards method calls to the remote object over the network.

### Implementation Example

Here is an example implementation of the Proxy Design Pattern in Java:

    public interface Image {
        void display();
    }
    
    public class RealImage implements Image {
        private String filename;
    
        public RealImage(String filename) {
            this.filename = filename;
            loadImageFromDisk();
        }
    
        public void display() {
            System.out.println("Displaying " + filename);
        }
    
        private void loadImageFromDisk() {
            System.out.println("Loading " + filename);
        }
    }
    
    public class ProxyImage implements Image {
        private RealImage realImage;
        private String filename;
    
        public ProxyImage(String filename) {
            this.filename = filename;
        }
    
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            }
            realImage.display();
        }
    }


In this example, `RealImage` is the real object, and `ProxyImage` is the proxy object. The client interacts with `ProxyImage` as if it were the real object, and `ProxyImage` forwards method calls to `RealImage` only if necessary.

### Source Code and Demo

A complete implementation of the Proxy Design Pattern in Java, along with a demo application, is available on [GitHub](https://github.com/iluwatar/java-design-patterns/tree/master/proxy). The source code includes examples of using the `java.lang.reflect.Proxy` class to create dynamic proxies, as well as examples of using RMI to create remote proxies.

### Tutorial

A detailed tutorial on the Proxy Design Pattern in Java is available on [Baeldung](https://www.baeldung.com/java-proxy-pattern). The tutorial covers the basic concepts of the pattern, as well as examples of using the `Proxy` class and RMI to create proxies.

Overall, the Proxy Design Pattern is a powerful tool for controlling access to objects in Java. By using proxy objects, developers can add additional logic to object access without modifying the real object, making the code more modular and easier to maintain.

Practical Applications of Proxy Design Pattern
----------------------------------------------

Proxy Design Pattern is a widely used design pattern in Java. It provides a way to control access to an object and add additional functionalities to it. In this section, we will discuss some of the practical applications of Proxy Design Pattern.

### Controlled Access

One of the most common applications of Proxy Design Pattern is to control access to an object. In some cases, it is necessary to restrict access to an object to certain users or groups. This can be achieved by using a Proxy object that checks the user’s credentials before allowing access to the real object. This is particularly useful in applications that deal with sensitive data or require strict access control.

### Lazy Initialization

Another application of Proxy Design Pattern is lazy initialization. In some cases, creating an object can be an expensive operation. If the object is not needed immediately, it is better to delay its creation until it is actually needed. This is where Proxy Design Pattern comes in. A Proxy object can be used to create the real object only when it is needed. This is known as lazy loading.

### Caching

Caching is another practical application of Proxy Design Pattern. In some applications, it is necessary to cache data to improve performance. A Proxy object can be used to cache the data and provide quick access to it. This is particularly useful in applications that deal with large amounts of data or require frequent access to the same data.

Real-world examples of Proxy Design Pattern can be found in many places, including databases and frameworks. For example, Hibernate, a popular Object-Relational Mapping framework, uses Proxy Design Pattern to provide lazy loading of objects. Similarly, Java RMI (Remote Method Invocation) uses Proxy Design Pattern to provide a remote interface to objects.

In conclusion, Proxy Design Pattern is a powerful tool that can be used to add additional functionalities to an object and control access to it. Its practical applications include controlled access, lazy initialization, and caching. It is widely used in many real-world applications, including databases and frameworks.

Benefits and Drawbacks of Proxy Design Pattern
----------------------------------------------

### Benefits

The Proxy Design Pattern offers several benefits when used in Java applications. Some of the key benefits include:

*   **Security**: The Proxy Pattern can be used to restrict access to sensitive resources or objects. By using a proxy, developers can ensure that only authorized users or processes are able to access a particular resource or object.
*   **Performance**: The Proxy Pattern can be used to improve application performance by reducing the number of calls to a resource or object. By using a proxy, developers can cache frequently accessed data and return it without having to make a call to the resource or object every time.
*   **Memory**: The Proxy Pattern can be used to reduce memory usage by delaying the creation of an object until it is actually needed. By using a proxy, developers can avoid creating large objects until they are actually needed, which can help reduce memory usage.
*   **Network Connection**: The Proxy Pattern can be used to reduce network traffic by caching frequently accessed data. By using a proxy, developers can avoid making multiple calls to a remote resource or object, which can help reduce network traffic and improve application performance.
*   **Large Object**: The Proxy Pattern can be used to reduce the overhead associated with creating large objects. By using a proxy, developers can avoid creating a large object until it is actually needed, which can help reduce the overhead associated with creating and managing large objects.

### Drawbacks

While the Proxy Design Pattern offers several benefits, there are also some drawbacks to consider. Some of the key drawbacks include:

*   **Inefficient**: The Proxy Pattern can be inefficient if it is not implemented correctly. If the proxy is not designed to cache frequently accessed data or to restrict access to sensitive resources, it may not provide any performance or security benefits.
*   **Resource Intensive**: The Proxy Pattern can be resource-intensive if it is used to cache large amounts of data. If the proxy is used to cache large objects or data sets, it may require significant amounts of memory or processing power, which can impact application performance.
*   **Cost**: The Proxy Pattern can be expensive to implement if it requires significant changes to an existing application. If the proxy requires changes to the application's architecture or design, it may be costly to implement and test.
*   **Network Connection**: The Proxy Pattern can be less effective if the network connection is unreliable. If the proxy is used to cache data from a remote resource or object, it may not be effective if the network connection is slow or unreliable.