# Java Reflection - Complete Guide

## Table of Contents
1. [Introduction to Reflection](#introduction)
2. [Getting Class Objects](#getting-class-objects)
3. [Inspecting Class Information](#inspecting-class-information)
4. [Working with Fields](#working-with-fields)
5. [Working with Methods](#working-with-methods)
6. [Working with Constructors](#working-with-constructors)
7. [Accessing Private Members](#accessing-private-members)
8. [Dynamic Object Creation](#dynamic-object-creation)
9. [Dynamic Method Invocation](#dynamic-method-invocation)
10. [Arrays and Reflection](#arrays-and-reflection)
11. [Proxies and Dynamic Interfaces](#proxies-and-dynamic-interfaces)

## 1. Introduction to Reflection <a name="introduction"></a>

Reflection allows Java code to examine and manipulate:
- Classes
- Interfaces
- Fields
- Methods
- Constructors

**Basic Example:**
```java
Class<?> clazz = String.class;
System.out.println("Class name: " + clazz.getName());
```
## 2. Getting Class 
```java
// 1. Using .class syntax
Class<String> stringClass = String.class;

// 2. Using getClass() method
String str = "Hello";
Class<?> strClass = str.getClass();

// 3. Using Class.forName()
try {
    Class<?> arrayListClass = Class.forName("java.util.ArrayList");
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
```
## 3. Inspecting Class Information

```java
class Person {
    private String name;
    private int age;
    
    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void greet() {
        System.out.println("Hello, my name is " + name);
    }
    
    // getters and setters
}

public class ReflectionDemo {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        
        // Get class name
        System.out.println("Class name: " + personClass.getName());
        System.out.println("Simple name: " + personClass.getSimpleName());
        
        // Get modifiers
        int modifiers = personClass.getModifiers();
        System.out.println("Is public: " + Modifier.isPublic(modifiers));
        
        // Get package info
        Package pkg = personClass.getPackage();
        System.out.println("Package: " + pkg.getName());
        
        // Get superclass
        System.out.println("Superclass: " + personClass.getSuperclass().getName());
        
        // Get interfaces
        Class<?>[] interfaces = personClass.getInterfaces();
        System.out.println("Interfaces: " + Arrays.toString(interfaces));
    }
}
```

## 04 Working with Fields

```java
Class<Person> personClass = Person.class;

// Get all fields (including private)
Field[] fields = personClass.getDeclaredFields();
for (Field field : fields) {
    System.out.println("Field: " + field.getName());
    System.out.println("Type: " + field.getType().getName());
    System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));
}

// Get specific field
try {
    Field nameField = personClass.getDeclaredField("name");
    System.out.println("Found field: " + nameField.getName());
} catch (NoSuchFieldException e) {
    e.printStackTrace();
}

// Get and set field values
Person person = new Person("Tilak", 24);
try {
    Field ageField = personClass.getDeclaredField("age");
    ageField.setAccessible(true); // for private fields
    
    // Get value
    int age = (int) ageField.get(person);
    System.out.println("Current age: " + age);
    
    // Set value
    ageField.set(person, 31);
    System.out.println("New age: " + person.getAge());
} catch (Exception e) {
    e.printStackTrace();
}
```

## 5. Working with Methods

```java
Class<Person> personClass = Person.class;

// Get all methods
Method[] methods = personClass.getDeclaredMethods();
for (Method method : methods) {
    System.out.println("Method: " + method.getName());
    System.out.println("Return type: " + method.getReturnType().getName());
    System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));
    
    // Get parameter types
    Class<?>[] paramTypes = method.getParameterTypes();
    System.out.println("Parameters: " + Arrays.toString(paramTypes));
}

// Get specific method
try {
    Method greetMethod = personClass.getMethod("greet");
    System.out.println("Found method: " + greetMethod.getName());
} catch (NoSuchMethodException e) {
    e.printStackTrace();
}
```

## 6. Working with Constructors

```java
Class<Person> personClass = Person.class;

// Get all constructors
Constructor<?>[] constructors = personClass.getDeclaredConstructors();
for (Constructor<?> constructor : constructors) {
    System.out.println("Constructor: " + constructor.getName());
    System.out.println("Parameter count: " + constructor.getParameterCount());
}

// Get specific constructor and create instance
try {
    Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
    Person person = constructor.newInstance("Tilak", 24);
    person.greet();
} catch (Exception e) {
    e.printStackTrace();
}
```

## 7. Accessing Private Members

```java
class Secret {
    private String secretCode = "12345";
    private void showSecret() {
        System.out.println("The secret is: " + secretCode);
    }
}

public class AccessPrivate {
    public static void main(String[] args) {
        try {
            Secret secret = new Secret();
            Class<?> secretClass = secret.getClass();
            
            // Access private field
            Field secretField = secretClass.getDeclaredField("secretCode");
            secretField.setAccessible(true); // crucial step
            String code = (String) secretField.get(secret);
            System.out.println("Secret code: " + code);
            
            // Change private field
            secretField.set(secret, "54321");
            
            // Access private method
            Method secretMethod = secretClass.getDeclaredMethod("showSecret");
            secretMethod.setAccessible(true);
            secretMethod.invoke(secret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## 8. Dynamic Object Creation 

```java
public class DynamicCreation {
    public static void main(String[] args) {
        try {
            // Get class by name
            Class<?> clazz = Class.forName("java.util.ArrayList");
            
            // Create instance
            List<?> list = (List<?>) clazz.getDeclaredConstructor().newInstance();
            
            // Use the object
            System.out.println("List class: " + list.getClass().getName());
            System.out.println("List size: " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## 9. Dynamic Method Invocation 

```java
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public double multiply(double a, double b) {
        return a * b;
    }
}

public class DynamicInvocation {
    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();
            Class<?> calcClass = calc.getClass();
            
            // Invoke add method
            Method addMethod = calcClass.getMethod("add", int.class, int.class);
            int sum = (int) addMethod.invoke(calc, 5, 7);
            System.out.println("5 + 7 = " + sum);
            
            // Invoke multiply method
            Method multiplyMethod = calcClass.getMethod("multiply", double.class, double.class);
            double product = (double) multiplyMethod.invoke(calc, 3.5, 2.5);
            System.out.println("3.5 * 2.5 = " + product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## 10. Arrays and Reflection

```java
public class ArrayReflection {
    public static void main(String[] args) {
        // Create array dynamically
        int[] intArray = (int[]) Array.newInstance(int.class, 5);
        
        // Set values
        for (int i = 0; i < Array.getLength(intArray); i++) {
            Array.set(intArray, i, i * 10);
        }
        
        // Get values
        for (int i = 0; i < Array.getLength(intArray); i++) {
            System.out.println(Array.get(intArray, i));
        }
        
        // Get component type
        Class<?> componentType = intArray.getClass().getComponentType();
        System.out.println("Component type: " + componentType.getName());
    }
}
```
## 11. Proxies and Dynamic Interfaces 

```java
interface Greeter {
    void greet(String name);
}

public class DynamicProxyDemo {
    public static void main(String[] args) {
        Greeter greeter = (Greeter) Proxy.newProxyInstance(
            Greeter.class.getClassLoader(),
            new Class<?>[] { Greeter.class },
            (proxy, method, args1) -> {
                System.out.println("Hello, " + args1[0] + "!");
                return null;
            }
        );
        
        greeter.greet("Tilak");
        greeter.greet("Sumit");
    }
}
```

## created by - Tilak