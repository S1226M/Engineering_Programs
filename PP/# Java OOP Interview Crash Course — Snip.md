# Java OOP Interview Crash Course — Snippet-Based MCQs

This guide is built around the way interviewers actually test OOP: short code snippets where you predict the output or spot the compile error. For each one, read the code, guess the answer yourself first, _then_ check the explanation. The reasoning matters more than the answer — that's what interviewers probe with follow-up questions.

---

## 1. Encapsulation

**Snippet 1**

```java
class Account {
    private double balance = 100;
}
public class Main {
    public static void main(String[] args) {
        Account a = new Account();
        System.out.println(a.balance);
    }
}
```

**Answer:** Compile-time error — `balance has private access in Account`.
**Why:** `private` restricts access to inside the declaring class only. There's no implicit getter; encapsulation has to be enforced explicitly with public methods.

**Snippet 2**

```java
class Account {
    private double balance;
    public Account(double balance) { this.balance = balance; }
    public double getBalance() { return balance; }
}
```

**Why this matters:** This is the textbook encapsulation pattern — hide state, expose controlled access. A common follow-up: "How would you make this immutable?" Answer: make the class `final`, fields `private final`, no setters, and if a field is a mutable object (like a `List` or `Date`), return a defensive copy from the getter rather than the live reference.

---

## 2. Abstraction (Abstract Classes)

**Snippet 1**

```java
abstract class Shape {
    abstract double area();
}
public class Main {
    public static void main(String[] args) {
        Shape s = new Shape();
    }
}
```

**Answer:** Compile-time error — `Shape is abstract; cannot be instantiated`.

**Snippet 2**

```java
abstract class Shape {
    abstract double area();
}
class Circle extends Shape {
    double radius = 5;
}
```

**Answer:** Compile-time error — `Circle is not abstract and does not override the abstract method area() in Shape`.
**Why:** Any concrete (non-abstract) subclass must implement every inherited abstract method. If `Circle` were also declared `abstract`, this would compile fine.

**Snippet 3**

```java
abstract class Vehicle {
    Vehicle() { System.out.println("Vehicle constructed"); }
    abstract void move();
    void honk() { System.out.println("Beep"); }
}
class Car extends Vehicle {
    void move() { System.out.println("Car moves"); }
}
new Car();
```

**Output:** `Vehicle constructed`
**Why:** Abstract classes _can_ have constructors, concrete methods, and instance variables. They just can't be instantiated directly. The constructor runs via the implicit `super()` call when the subclass is instantiated.

---

## 3. Inheritance

**Snippet 1 — Static methods are hidden, not overridden**

```java
class Parent {
    static void greet() { System.out.println("Parent"); }
}
class Child extends Parent {
    static void greet() { System.out.println("Child"); }
}
Parent p = new Child();
p.greet();
```

**Output:** `Parent`
**Why:** Static methods are resolved at compile time based on the **reference type**, not the object's actual type. This is "method hiding," not polymorphism. Runtime/dynamic dispatch only applies to instance methods.

**Snippet 2 — Fields are never polymorphic**

```java
class Parent { int x = 10; }
class Child extends Parent { int x = 20; }
Parent p = new Child();
System.out.println(p.x);
```

**Output:** `10`
**Why:** Field access is resolved at compile time by the reference type. This trips people up constantly because it looks identical in shape to the next snippet, but behaves oppositely.

**Snippet 3 — Instance methods ARE polymorphic**

```java
class Parent {
    void greet() { System.out.println("Parent"); }
}
class Child extends Parent {
    @Override
    void greet() { System.out.println("Child"); }
}
Parent p = new Child();
p.greet();
```

**Output:** `Child`
**Why:** Instance methods use dynamic dispatch — resolved at runtime based on the actual object type. This is the core mechanism behind runtime polymorphism.

> **Interview gold:** If asked "what's the difference between method hiding and method overriding," lead with this exact contrast — fields/static methods resolve by reference type, instance methods resolve by object type.

**Snippet 4 — Implicit super() failure**

```java
class Parent {
    Parent(int x) { }
}
class Child extends Parent {
    Child() { }
}
```

**Answer:** Compile-time error — `implicit super constructor Parent() is undefined. Must explicitly invoke another constructor`.
**Why:** Every constructor implicitly calls `super()` as its first line unless you write something else. Since `Parent` has no no-arg constructor (it only has the parameterized one), the compiler can't insert that implicit call.

**Snippet 5 — Private methods aren't inherited**

```java
class Parent {
    private void secret() { System.out.println("Parent secret"); }
}
class Child extends Parent {
    @Override
    private void secret() { System.out.println("Child secret"); } // ?
}
```

**Answer:** Compile-time error on `@Override` — `method does not override a method from its superclass`.
**Why:** Private methods are not visible to, and not inherited by, subclasses. What looks like an override is actually an unrelated new method, so `@Override` is invalid here.

---

## 4. Polymorphism — Compile-Time vs Runtime

**Compile-time (overloading) — ambiguity trap**

```java
class Test {
    void show(int x, double y) { System.out.println("int,double"); }
    void show(double x, int y) { System.out.println("double,int"); }
}
Test t = new Test();
t.show(1, 2);
```

**Answer:** Compile-time error — `reference to show is ambiguous`.
**Why:** Both `int` literals could widen to match either signature equally well. The compiler can't pick one, so it refuses to compile rather than guess.

**Overload resolution order**

```java
class Test {
    void foo(long x) { System.out.println("long"); }
    void foo(Integer x) { System.out.println("Integer"); }
    public static void main(String[] args) {
        new Test().foo(5);
    }
}
```

**Output:** `long`
**Why:** Java prefers **widening** (`int → long`) over **autoboxing** (`int → Integer`) over **varargs**. The resolution priority is: exact match → widening → boxing/unboxing → varargs. This is a favorite trick question.

**Runtime polymorphism — overriding rules**

```java
class Parent {
    protected Object getValue() { return "parent"; }
}
class Child extends Parent {
    @Override
    public String getValue() { return "child"; } // narrower modifier OK? covariant return OK?
}
```

**Answer:** Compiles fine.
**Why:** Two rules at play — (1) you can **widen** access when overriding (protected → public is allowed; the reverse is not), and (2) **covariant return types** are allowed since Java 5 — an overriding method can return a subtype of the original return type (`String` is a subtype of `Object`).

**The illegal version of the above**

```java
class Parent {
    public Object getValue() { return "parent"; }
}
class Child extends Parent {
    @Override
    private Object getValue() { return "child"; } // narrowing access
}
```

**Answer:** Compile-time error — `cannot reduce visibility of the inherited method`.

---

## 5. Abstract Classes vs Interfaces

**Multiple inheritance — what's actually allowed**

```java
class Child extends Parent1, Parent2 { } // ?
```

**Answer:** Compile-time error. A class can extend only **one** class (single inheritance), but it can `implements` **multiple** interfaces. This is the core reason interfaces exist as a design tool — they sidestep the diamond problem for state, while still allowing multiple behavioral contracts.

**The diamond problem, resurrected via default methods**

```java
interface A { default void hello() { System.out.println("A"); } }
interface B { default void hello() { System.out.println("B"); } }
class C implements A, B { }
```

**Answer:** Compile-time error — `class C inherits unrelated defaults for hello() from types A and B`.
**Why:** Java refuses to silently pick a winner. You must override `hello()` in `C` explicitly — and inside that override you can still choose to delegate: `A.super.hello();`

**Interface fields are implicitly constants**

```java
interface Config {
    int MAX = 100;
}
class Impl implements Config {
    void update() { MAX = 200; } // ?
}
```

**Answer:** Compile-time error — `cannot assign a value to final variable MAX`.
**Why:** Interface fields are implicitly `public static final`, whether you write those keywords or not.

**Static methods in interfaces are not inherited**

```java
interface Util {
    static void log() { System.out.println("Util log"); }
}
class Impl implements Util { }
Impl.log(); // ?
```

**Answer:** Compile-time error. Interface static methods belong to the interface itself and must be called as `Util.log()`, not through the implementing class.

**Quick decision rule for "abstract class or interface?"**
Use an abstract class when subclasses share common _state_ or you want to provide a partial, reusable implementation with constructors. Use an interface when you're defining a _capability_ or _contract_ that unrelated classes might implement, especially if a class needs to satisfy multiple such contracts simultaneously.

---

## 6. `static` Keyword

**Shared state across instances**

```java
class Counter {
    static int count = 0;
    Counter() { count++; }
}
new Counter(); new Counter(); new Counter();
System.out.println(Counter.count);
```

**Output:** `3` — one `count` variable shared by the class, not per-instance.

**Initialization order**

```java
class Test {
    static { System.out.println("Static block"); }
    Test() { System.out.println("Constructor"); }
    public static void main(String[] args) {
        System.out.println("Main start");
        new Test();
        new Test();
    }
}
```

**Output:**

```
Static block
Main start
Constructor
Constructor
```

**Why:** Static blocks run exactly once, when the class is first loaded by the JVM — which happens before `main()` runs (since `Test` itself needs loading to execute `main`). Instance constructors run once per `new`.

**Can't reach instance members from a static context**

```java
class Test {
    int x = 5;
    static void show() {
        System.out.println(x); // ?
    }
}
```

**Answer:** Compile-time error — `non-static variable x cannot be referenced from a static context`.
**Why:** Static methods belong to the class, not any particular object, so there's no implicit `this` for them to use to reach instance fields.

---

## 7. `final` Keyword

**Three flavors, one keyword**

```java
final int x = 10;
x = 20; // compile error — final variable, can't reassign

final class Utility { }
class Sub extends Utility { } // compile error — can't extend a final class

class Parent {
    final void process() { }
}
class Child extends Parent {
    void process() { } // compile error — can't override a final method
}
```

**The gotcha — final reference vs final object**

```java
final List<Integer> list = new ArrayList<>();
list.add(1); // fine
list = new ArrayList<>(); // compile error
```

**Why:** `final` on a reference variable locks the _reference_, not the object it points to. You can still mutate the object's internal state (adding to the list) — you just can't make the variable point somewhere else.

**Blank final**

```java
class Test {
    final int x;
    Test(int x) { this.x = x; } // legal — assigned exactly once, in the constructor
}
```

This compiles because a "blank final" field just needs to be definitely assigned exactly once before the constructor finishes — it doesn't need a value at declaration.

---

## 8. `super` Keyword

**Must be the first statement**

```java
class Parent {
    Parent() { System.out.println("Parent"); }
}
class Child extends Parent {
    Child() {
        System.out.println("Before super");
        super(); // ?
    }
}
```

**Answer:** Compile-time error — `call to super must be first statement in constructor`.

**this() and super() can't coexist**

```java
class Child extends Parent {
    Child() {
        super();
        this(5); // ?
    }
    Child(int x) { }
}
```

**Answer:** Compile-time error. A constructor can chain to **either** another constructor in the same class (`this(...)`) **or** the parent's constructor (`super(...)`) — never both, since only one can occupy the mandatory first-statement slot.

**Calling an overridden parent method explicitly**

```java
class Parent {
    void greet() { System.out.println("Parent greet"); }
}
class Child extends Parent {
    @Override
    void greet() {
        super.greet();
        System.out.println("Child greet");
    }
}
new Child().greet();
```

**Output:**

```
Parent greet
Child greet
```

---

## 9. `this` Keyword

**Constructor chaining**

```java
class Box {
    int size;
    Box() {
        this(10);
        System.out.println("no-arg");
    }
    Box(int size) {
        this.size = size;
        System.out.println("param");
    }
}
new Box();
```

**Output:**

```
param
no-arg
```

**Why:** `this(10)` immediately transfers control to the parameterized constructor, which finishes completely _before_ the rest of the no-arg constructor's body resumes.

**this is unavailable in static context**

```java
class Test {
    static void show() {
        System.out.println(this); // compile error
    }
}
```

**Why:** `this` refers to the current object instance — static methods aren't tied to any instance, so there's nothing for `this` to refer to.

---

## 10. Access Modifiers

| Modifier              | Same class | Same package | Subclass (different package) | Everywhere |
| --------------------- | ---------- | ------------ | ---------------------------- | ---------- |
| `private`             | yes        | no           | no                           | no         |
| default (no modifier) | yes        | yes          | no                           | no         |
| `protected`           | yes        | yes          | yes (with caveats)           | no         |
| `public`              | yes        | yes          | yes                          | yes        |

**The protected caveat that catches people out**

```java
// package A
public class Parent {
    protected void greet() { }
}
// package B
class Child extends Parent {
    void test(Parent p) {
        p.greet();        // compile error — p is typed as Parent, not Child
        this.greet();     // fine — accessed through inherited reference
    }
}
```

**Why:** A subclass in a different package can access a `protected` member only through a reference of its **own type or a subtype** — not through an arbitrary `Parent`-typed reference. This is one of the more nuanced rules and a great thing to mention proactively if asked about `protected`.

**Overriding can't narrow visibility**

```java
class Parent {
    public void show() { }
}
class Child extends Parent {
    private void show() { } // compile error
}
```

---

## 11. Constructors & Object Lifecycle

**The default constructor disappears the moment you define any constructor**

```java
class A {
    A(int x) { }
}
public class Main {
    public static void main(String[] args) {
        A a = new A(); // ?
    }
}
```

**Answer:** Compile-time error — `constructor A() is undefined`. Java only auto-generates a no-arg constructor if you define **zero** constructors yourself.

**Full initialization order with inheritance — a classic deep-dive question**

```java
class Parent {
    static { System.out.println("Parent static block"); }
    { System.out.println("Parent instance block"); }
    Parent() { System.out.println("Parent constructor"); }
}
class Child extends Parent {
    static { System.out.println("Child static block"); }
    { System.out.println("Child instance block"); }
    Child() { System.out.println("Child constructor"); }
}
new Child();
```

**Output:**

```
Parent static block
Child static block
Parent instance block
Parent constructor
Child instance block
Child constructor
```

**Why:** Static blocks (parent first, then child) run once at class loading, before any object exists. Then, for each object creation: parent's instance blocks and constructor run first (because `super()` is implicitly called first), then child's instance blocks, then child's constructor body.

**Constructor overloading**

```java
class Rectangle {
    int width, height;
    Rectangle() { this(1, 1); }
    Rectangle(int side) { this(side, side); }
    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
```

This is the standard "delegate to the most specific constructor" pattern — useful to write from scratch if asked.

---

## 12. Garbage Collection Basics

Quick facts that tend to come up as rapid-fire questions:

- Objects become eligible for GC once they're unreachable from any live thread/root reference — there's no manual `delete` or deterministic destructor in Java.
- `System.gc()` only **suggests** that the JVM run garbage collection; it's not guaranteed to do anything immediately, or at all.
- `finalize()` is deprecated (and effectively unreliable) — never rely on it for cleanup. The modern equivalent for "always clean this up" logic is `try`-with-resources plus `AutoCloseable`, not finalizers.
- Setting a reference to `null` doesn't force collection — it just removes one path of reachability, making the object _eligible_ sooner.
- Memory leaks in Java are usually about objects staying _reachable_ longer than intended (e.g. forgotten listeners, static collections growing unbounded) — GC can't fix logical retention.

---

## 13. Exception Handling

**finally always runs (with one notable exception)**

```java
static int test() {
    try {
        return 1;
    } finally {
        System.out.println("finally ran");
    }
}
```

**Output:** prints `finally ran`, then returns `1`.
**Why:** `finally` executes even when the `try` block hits a `return`. The only ways to skip it are `System.exit()` or a JVM crash/halt.

**The finally-overrides-return trap**

```java
static int test() {
    try {
        return 1;
    } finally {
        return 2;
    }
}
System.out.println(test());
```

**Output:** `2`
**Why:** If `finally` itself contains a `return` (or throws), it **overrides** whatever the `try` block was about to return. This is considered bad practice, but interviewers love it as a "what's the output" trap.

**Checked vs unchecked**

```java
void readFile() throws IOException {
    throw new IOException("file missing");
}
```

`IOException` extends `Exception` (not `RuntimeException`) — it's **checked**, so the compiler forces you to either catch it or declare `throws IOException`. Compare:

```java
void divide() {
    throw new ArithmeticException("bad math"); // unchecked, no throws needed
}
```

`RuntimeException` and its subclasses are **unchecked** — the compiler doesn't force handling. Quick mental model: checked exceptions represent recoverable conditions the caller should be forced to think about (file not found, network down); unchecked exceptions usually represent programming bugs (null pointer, bad array index, division by zero).

**Unreachable catch block**

```java
try {
    throw new ArithmeticException();
} catch (Exception e) {
    System.out.println("Exception");
} catch (ArithmeticException e) {
    System.out.println("Arithmetic");
}
```

**Answer:** Compile-time error — `exception ArithmeticException has already been caught`.
**Why:** Catch blocks are checked top-to-bottom; once a broader exception type is caught earlier, a narrower subclass below it can never be reached. More specific catch blocks must always come **before** more general ones.

**Multi-catch restriction**

```java
try {
    riskyCall();
} catch (IOException | FileNotFoundException e) { // ?
    // ...
}
```

**Answer:** Compile-time error. `FileNotFoundException` is a subclass of `IOException`, so listing both in a multi-catch is redundant and illegal — the compiler rejects multi-catch alternatives where one is a subtype of another.

**Overriding and checked exceptions**

```java
class Parent {
    void process() throws IOException { }
}
class Child extends Parent {
    @Override
    void process() throws Exception { } // ?
}
```

**Answer:** Compile-time error. An overriding method cannot throw a **broader or new checked** exception than the method it overrides. It can throw the same, a narrower checked exception, no exception at all, or any unchecked exception freely.

**try-with-resources**

```java
class Res implements AutoCloseable {
    String name;
    Res(String name) { this.name = name; }
    public void close() { System.out.println("Closing " + name); }
}
try (Res a = new Res("A"); Res b = new Res("B")) {
    System.out.println("Using resources");
}
```

**Output:**

```
Using resources
Closing B
Closing A
```

**Why:** Resources declared in a try-with-resources are closed automatically, in **reverse** order of declaration, even if an exception occurs inside the block.

**throw vs throws — don't mix these up out loud**
`throw` is a statement that actually raises an exception instance at runtime (`throw new Exception()`). `throws` is part of a method signature, declaring that the method _might_ propagate a checked exception to its caller. Confusing these in an interview answer is an instant tell that the concept isn't solid.

---

## 14. Rapid-Fire Gotcha List (skim this right before walking in)

- Static/field access resolves by **reference type** at compile time; instance method calls resolve by **object type** at runtime.
- Overloading = compile-time polymorphism (same name, different parameter list). Overriding = runtime polymorphism (same signature, subclass redefines behavior).
- A class: single inheritance only (`extends` one class). An interface: a class can `implements` many.
- Abstract classes can have constructors and concrete methods; interfaces (pre-Java 8) couldn't — now they can have `default`, `static`, and `private` methods too.
- Interface fields are always `public static final`, whether you write it or not.
- `final` variable → can't reassign. `final` method → can't override. `final` class → can't extend.
- Overriding can widen access (protected → public) but never narrow it (public → protected/private).
- Covariant return types are legal in overriding; covariant parameter types are not (that's overloading instead).
- `super()`/`this()` must be the first statement in a constructor, and you can use only one of them, never both.
- Defining any constructor removes the compiler's free default no-arg constructor.
- Initialization order: static (parent → child, once) → instance blocks + constructor (parent → child, every `new`).
- `finally` runs even after a `return` in `try`/`catch` — and a `return`/`throw` inside `finally` silently overrides one from `try`.
- Checked exceptions (subclasses of `Exception`, excluding `RuntimeException`) must be caught or declared; unchecked (`RuntimeException` subclasses) need neither.
- Catch blocks must go from most specific to most general, or it's a compile error.
- An overriding method can't throw a broader checked exception than the parent method declared.

---

## 15. A Few Likely Verbal Follow-Ups

Beyond snippets, be ready to explain in plain language (no code needed):

- Why composition is often preferred over inheritance ("favor composition over inheritance").
- What happens to a constructor's exception handling versus a method's (constructors can throw exceptions too, including checked ones).
- The difference between an `Object`'s `equals()`/`hashCode()` contract and why overriding one without the other breaks hash-based collections.
- What "tightly coupled" means in the context of deep inheritance hierarchies, and why interfaces reduce that coupling.

---

Want me to put together a similar snippet-based set for **Collections, String handling/immutability, or Multithreading basics** — common companion topics in the same interview round?
