---
title: "CS12-lecture-notes"
tags: ["java"]
---

# CS 12 Lecture notes


## Aug 20, 2018

[X] ~~*Download Java JDK and jGRASP*~~ [2018-08-20]

A `class` is a “blueprint" for objects in object-oriented coding

---
## Aug 22, 2018

### `class`

All Java programs are structured in a `class`. It is a the fundamental part of a Java program. The simplest programs have a `main` method, which contains all of the code. The actual java library only has around 40 commands, but it has an extensive library of classes that you can use. `​main`​ is the entry point to the code. 

A more serious java program also includes a `class`​, but it will generally start with fields, then constructors, then accessors, then mutators, then general methods.

```java
public class FirstJava
{
  public static void main(String[] args)
  {
    System.out.println("Hello from Java\n");
  }
}
```

The `public` class determines how exposed the class is to the world. `class` means were going to create a structure these sort of things. `FirstJava` is the identifier of the `class`. It is simply a name for the class, created by the programmer, must start with a alphabetic character. **The java way is to capiatlize the first character of a class, although it doesn’t need to be.** A string is a contiguously allocated sequence of bites. `\n` is an escape character to make a new line.

```java
import java.util.Scanner;

public class MilesPerGallon
{
  public static void main(String[] args)
  {
    double miles;
    double gallons;
    double mpg;
    
    Scanner kb);
    
    System.out.print( "Enter miles driven: " );
    miles);
    
    System.out.print( "Enter gallons used: " );
    gallons);
    
    mpg = miles / gallons;
    
    System.out.println("Your car drove " + mpg + " miles per gallon");
  }// end main
}// end class
```

`public static void main(String[] args)`​

`public` means that it is exposed, a visibility specifier. `static` means that `main` exists, its ready to be used. `void` means that it doesn’t return anything. `main` is the name of the method, a method is a block of code that does something. All java applets must have a `main` method. `(String[] args)` is the parameter list.

---
## Aug 27, 2018

>Programming is a craft, with a lot of trial and error.

Developing software:

1. Understand the problem
2. Develop our key algorithm in pseudocode (plain english)
3. Test the algorithm with pencil and paper
4. Code the algorithm in the target language
5. Test the code (arguably the hardest part of the development)
    1. Usually have to go back to step 4, sometimes back to step 2, and if still not working then step 1\. If steps 1-3 go well then 4-5 are easy.

Algorithms characteristics:

* Unambiguous
* Executable
* Terminates
* Zero or more inpurts
* One or more outputs

To develop an algorithm:

1. Determine the inputs and the outputs (if you know this step its extremely helpful)
    1. Evaluate solutions (survey the landscape)
2. Break our solution into smaller pieces (divide and conquer)
3. Describe each subtask in pseudocode
4. Test pseudocode with a desk-check (pencil and paper test)

Pseudocode for making breakfast:
- Fill kettle with water
- Set kettle on burner
- Turn burner on high
- Grind coffee
- Put pan on burner
- Turn burner on med
- Put butter in pan
- Crack eggs in pan
- Put english muffin in toaster
- scramble eggs
- Pour boiling water into coffee maker
- Pull english muffins out of toaster
- place eggs on muffins
- pour coffee into mug

Pseudocode for Babylonian square root `a`:
- Start with `a` / 2
- this is `g`
- then find average of `g` and `a / g`
  - this is your `newg`
  - `newg`) / 2`
  - repeat until 2 consequtive guesses are “close enough”
- display `newg`

### The rules of quality software

1. Quality software works
    1. It correctly incorporates its specification
2. Quality software can be read and understood
    1. good variable names
    2. commented code
    3. **clear code not clever code**
    4. indentation
3. Quality software is easy to modify

---
## Aug 29, 2018

Program to calculate the area of a rectangle
area = length * width

pseudocode:
- get length from user
- get width from user
- area = length * width
- print area

```java
import javax.swing.JOptionPane;

public class RectangleArea
{
  public static void main(String[] args)
  {
    double length;
    double width;
    double area;
    
    length);
    width);
    
    area = length * width;
    
    System.out.println("Area is " + area);
  }//end main
}//end class
```

`JOptionPane` makes the user input much more user-friendly by using pop-up dialog boxes. The `showInputDialog` is expecting a string, but the `length` variable is expecting a `double`. So the `Double.parseDouble` takes the string of numbers and turn it into a `double`.

Classes contain:
- Fields
- Constructor
- General Methods (behaviors)

---
## Sep 5, 2018

### Data Types in Java
**Integers:**

| Integers | Bits | Range                  |
| -------- | ---- | ---------------------- |
| `byte`   | 8    | -128 > 127             |
| `short`  | 16   | -32,768 > 32,767       |
| `int`    | 32   | ~± 2 billion           |
| `long`   | 64   | ~± 9.2e18 (really big) |

```java
//Example
byte myByte;
myByte = 23; //This is legal
myByte)

short myShort = 0; //Legal
myShort = -100000; //Illegal, out of range

int myInt = 100;
long myLong;
```

Twos complement:
> $2 ^ {(bits - 1)} - 1 = max$  
> $-2 ^ {(bits - 1)} = min$

For example in 8 bits:
> $2^{(8 - 1)} - 1)$  
> $-2^{(8 - 1)})$

(The reason you minus one from the max is to compensate for zero)

To go from positive to negative (for example in a byte) **invert the bits and add 1**  
For example with the decimal number 5:
>$0101 = 5_{10}$  
>$1010 + 1 = 1011 = -5_{10}$

**Floating point types:**

| Floats   | Bits | Range                  | Accuracy                   |
| -------- | ---- | ---------------------- | -------------------------- |
| `float`  | 32   | ~± 2 billion           | ~7 decimal digit accuracy  |
| `double` | 64   | ~± 9.2e18 (really big) | ~15 decimal digit accuracy |

```java
//Examples
byte myByte = 97;
int myInt = 5;

myInt = myByte; //This is legal, they are both integers and it will fit in the int type
myBye)
```

```java
float myFloat = 3004.215;
int myInt = 315;
double myDouble = 297.8;

myDouble)
myFloat = myInt; //Legal
myInt)
myFloat = myDouble; //Illegal, 64 bits cannot fit in 32 bits
```

**Other types:**

| Other data types | Bits | Info                  |
| ---------------- | ---- | --------------------- |
| `char`           | 16   | Unicode character set |
| `boolean`        | 1    | `true` or `false`     |

Example:
>‘A’ = 65 = 0x0041  
>‘B’ = 66 = 0x0042  
>‘C’ = 67 = 0x0043  
>‘0’ = 48 = 0x0030  
>‘1’ = 49 = 0x0031  

```java
//Example
char myChar = 'A'; //Use single quotes to assign a char
System.out.println(myChar);
```

```java
//Example
boolean myBool = true; //Can only be true or false
```

**Strings:**

`String` is a class, not an intrinsic data types. This makes them less limited than the built-in data types.

```java
//Example
public class StringFun
{
  public static void main(String[] args)
  {
    String name = "Dave";
    String notHere = "'s not here man";
    String both = name + notHere; //Concatenation of both strings
    
    System.out.println(both);
  }
}
```

Prints `​Dave’s not here man`​

**Strings are just concatenated `char`s from an array.**

---
## Sep 10, 2018

### Cat class  
| Fields | Type   |
| ------ | ------ |
| name   | String |
| weight | double |
| color  | String |
| age    | int    |

| Methods      | Return |
| ------------ | ------ |
| `meow()`     | void   |
| `sleep()`    | void   |
| `scratch()`  | void   |
| `eat()`      | void   |
| `birthday()` | void   |

```java
public class Cat
{
  //Fields
  private String name;
  private double weight;
  private String color;
  private int age;
  
  //Constructors
  public Cat()
  {
    name = "Cat";
    weight = 8;
    color = "Black";
    age = 5;
  }//end default constructor, used to make it easy for testing
  
  public Cat (String n, double w, String c, int a)
  {
    name = n;
    weight = w;
    color = c;
    age = a;
  }//end constructor
  
  //Accessors, let us access a field
  public String getName() {return name;}
  public double getWeight() {return weight;}
  
  //Mutators, let us change a field
  public void setName(String nn) {name = nn;}
  public void setWeight(double nw) {weight = nw;}
  
  //General methods
  public void meow()
  {
    System.out.println(name + " is meowing");
  }
  
  public void hairball()
  {
    System.out.println(name + " is making a hairball");
  }
}//end Cat class
```

In another file to test this:

```java
public class CatTest
{
  public static void main(String[] args)
  {
    //Reference variable
    Cat cat1);
    
    //Calling methods
    cat1.meow();
    cat1.hairball();
    
    //Using an accessor
    System.out.println( cat1.getName() );
    
    //Using a mutator
    System.out.println("Current weight: " + cat1.getWeight() ); //seeing current weight
    cat1.setWeight(13.2); //new weight
    System.out.println("New weight: " + cat1.getWeight() ); //seeing new weight
  }
}
```

---
## Sep 12, 2018

### Lab 1: Aircraft Class
Create a Java class the encapsulates the concept of a small aircraft.  
Your class should have the following fields:

| Type   | Field Name   | Description                                 |
| ------ | ------------ | ------------------------------------------- |
| String | manufacturer | Name of aircraft manufacturer, e.g., Cessna |
| String | model        | Model number of the aircraft, e.g., 172     |
| double | mtow         | Maximum takeoff weight in pounds            |
| double | emptyWeight  | Empty weight in pounds.                     |
| double | fuelBurnRate | Fuel burn rate in gallons/hour              |

Accessors and mutators for each field, except fuelBurnRate.  
Your class should override the toString() method and return a string with manufacturer and model number.  
Your class should have general methods as follows:  
| Visibility | Return | Method name                         | Comment                                                                                   |
| ---------- | ------ | ----------------------------------- | ----------------------------------------------------------------------------------------- |
| public     | double | `usefulLoad()`                      | // returns the maximum takeoff weight minus the empty weight.                             |
| public     | double | `fuelWeight(double gallons)`        | // returns the weight of gallons of fuel. Aviation fuel (100LL) weighs 6 lbs. per gallon. |
| public     | double | `fueledWeightMargin (double hours)` | // remaining weight margin                                                                |
 
Write a main method that instantiates an airplane and tests the various methods.

### Employee Class  
| Variables | Type   |
| --------- | ------ |
| name      | String |
| salary    | double |

| Methods               | Return |
| --------------------- | ------ |
| `raiseSalary(double)` | void   |

```java
public class Employee
{
  private String name;
  private double salary;

  public Employee (String n, double s)
  {
    name = n;
    salary = s;
  }

  public void raiseSalary(double p)
  {
    salary *= p + 1;
  }
}
```

---
## Sep 17, 2018

Making use of the graphics frame:  
`GraphicsFrame.java` and `Drawable.java` are available on canvas. **Use these files but do not modify them.**

### Chicken class  
| Variables | Type   |
| --------- | ------ |
| name      | String |
| weight    | double |

| Methods  | Return |
| -------- | ------ |
| `crow()` | void   |
| `peck()` | void   |
| `draw()` | void   |

This will use the Chicken class, GraphicsFrame class, Drawable class, and a MakeChicken class (which will contain our main). These must all be in the same folder.

Using the GraphicsFrame
1. Create the base class ( the class you want to draw )
2. Put the `GraphicsFrame.java` and `Drawable.java` into the same folder

`drawString()` prints to the graphics window. `println()` only prints to the console. `implements` keyword after a class refers to an `interface` class. This is basically a promise to put the method that the class is implementing in your code. This is referring to the `draw()` method. This is needed in the Chicken class. The chicken class with the `draw()` method cannot draw itself, but can be used to draw. Use `setColor()` and `getColor()` to change the color back to the default after its drawn so the default color isn't changed for future draws.

___
## Sep 19, 2018

Everything inherits from `Object.java`. The class `Object.java` has a method called `toString()` which returns the address of where the object lives in memory. This method is called on default if you were to call an object on its own, i.e. `System.out.println(a1);` is the same as calling `System.out.println(a1.toString);`. To override `toString()` you could put in your own aircraft class `public String toString() {return manufacturer + " " + model;}` for example. The `toString()` method should return something descriptive about the object, in the case of our Aircraft class, it returns the manufacturer and model of the aircraft object.

### Donut class  
| Variables    | Type   |
| ------------ | ------ |
| type         | String |
| shape        | char   |
| x coordinate | int    |
| y coordinate | int    |
| color        | Color  |

```java
import java.awt.Color;
import java.awt.Graphics;

public class Donut implements Drawable
{
  private String type;
  private char shape; //C for circular, R for rectangle
  private Color color;
  private int x,y;

  public Donut()
  {
    type = "Glazed";
    shape = 'C';
    color = Color.YELLOW;
    x = y = 400;
  }

  public Donut(String t, char s, Color c, int px, int py)
  {
    type = t;
    shape = s;
    color = c;
    x = px;
    y = py;
  }

  public void draw(Graphics g)
  {
    //Draw code goes here
  }

}
```

---
## Sep 24, 2018

### Lab 2: BAC Calculation  
| Fields               | Data type |
| -------------------- | --------- |
| name                 | String    |
| weight, in kg        | double    |
| gender, M or F       | char      |
| standard drinks (SD) | double    |
| drinking period (DP) | double    |

| Local constants                                                   | Data type |
| ----------------------------------------------------------------- | --------- |
| body water (BW, 0.58 for male, 0.49 for female, constants)        | double    |
| metabolism rate (MR, 0.015 for male, 0.017 for female, constants) | double    |


```java
public class EstimatedBloodAlcoholContent
{
  private String name;
  private double weight; //kg
  private char gender; //M or F
  private double SD; //Standard drinks: 10 grams of ethanol per drink
  private double DP; //Drinking hours

  public EstimatedBloodAlcoholContent()
  {
    name = "Jane Doe";
    weight = 70;
    gender = 'F';
    SD = 2.5;
    DP = 2;
  }

  //Full constructor goes here

  //Accessors
  public String getName() {return name;}

  public double ebac()
  {
    double BW = 0;
    double MR = 0;

    if (gender)
    {
      BW = 0.49;
      MR = 0.017;
    }
    else //gender == 'M'
    {
      BW = 0.58;
      MR = 0.015;
    }

    return (0.806 * SD * 1.2) / (BW * weight) - (MR * DP);
  }//end ebac

  public String toString()
  {
    return name + ", " + gender;
  }

  public static void main (String[] args)
  {
    EstimatedBloodAlcoholContent pf);

    System.out.println(pf.getName() + ": " + pf.ebac());
  }

}//end class
```

`toString()` should return something that is "representative of the object", and should always be overriden.

---
## Oct 1, 2018

- [X] ~~*Ch. 4 Quiz*~~ [2018-10-08]
- [X] ~~*Midterm is on 17th of Oct, covers Ch. 1 - 5.2 (only `if` and `if..else` from Ch. 5)*~~ [2018-10-17]
- [X] ~~*Make midterm notes (**Allowed one 8.5 x 11 sheet of paper**)*~~ [2018-10-17]

### Decision statements

Control Statement review:  
- Simple Sequence
  - Blocks are executed sequentially
- Decision statements
  - if, if..else, switch
- Iterate (repeat/loop)

**if (and if..else):**  
```java
if (boolean_expression)
{
  //Code block goes here
}
```
If the `boolean_expression` is `true`, then the code block gets executed, if `false` the block is skipped and the flow of the program continues normally.

Boolean expressions are formed with **relational operators**:  

| Symbol | Meaning               | Example      | Notes                                                                       |
| ------ | --------------------- | ------------ | --------------------------------------------------------------------------- |
| `==`   | Is equal to           | `a == 5`     | Works with fundamental data types, but be careful with floating point types |
| `!=`   | Is not equal          | `b != a`     |
| `>`    | Greater than          | `5 > 4`      | `true`                                                                      |
| `<`    | Less than             | `10 < 15`    | `false`                                                                     |
| `>=`   | Greater than or equal | `a >= value` |
| `<=`   | Less than or equal    | `a <= c + 5` | Arithmetic is allowed                                                       |

Example:  
```java
if (value >= 21)
{
  //Code
}
```

A simple program to check drinking age:  

```java
if (age >= 21)
{
  System.out.println("Come on in and kill some brain cells");
}
else
{
  System.out.println("Go home punk);
}
```

More complicated (waterfall type if): 

```java
if (age < 21)
{
  System.out.println("No beer for you");
}
else if (age <= 29)
{
  System.out.println("Come on in and spend your limited money killing braincells");
}
else if (age <)
{
  System.out.println("Come in and spends lots and lots of money");
}
else if (age <= 49)
{
  System.out.println("You're a bit old but we want your money");
}
else //over 49
{
  System.out.println("Get back in your Impala and listen to your 8-track");
}
```

---
## Oct 3, 2018

Side read: *Physics for Game Programmers* by Grant Palmer

### Lift and drag calculation  
Lift and drag for a rectangle wing:  
>$lift = \frac{1}{2}ρ*v^2*cl*A$  
$drag = \frac{1}{2}ρ*v^2*cd*A$

| Type         | Name  | Variable         | Description                                                                                           |
| ------------ | ----- | ---------------- | ----------------------------------------------------------------------------------------------------- |
| final double | `rho` | *ρ* (rho)        | Density of air at STP (standard temp and pressure). Looking at sea level air density ($1.225 kg/m^3$) |
| double       | `v`   | velocity         | Velocity in meters per second (will need to be converted to knots)                                    |
| double       | `cl`  | lift coeffecient | Dimensionless                                                                                         |
| double       | `cd`  | drag coeffecient | Dimensionless                                                                                         |
| double       | `b`   | wing span        | In meters                                                                                             |
| double       | `c`   | wing chord       | In meters                                                                                             |


```java
public class Wing
{
  private final double rho = 1.225; //kg/m^3

  private double v;  //meters per second
  private double cl; //dimensionless coeffecient of lift
  private double cd; //dimensionless drag
  private double b;  //span in meters
  private double c;  //chord in meters

  public Wing()
  {
    v)
    cl = 0.4; //coeffecient of lift
    cd = 0.08;//drag
    b = 9.25; //meters
    c = 1.25; //chord
  }

  public Wing(double pv, double pcl, double pcd, double pb, double pc)
  {
    v = pv;
    cl = pcl;
    cd = pcd;
    b = pb;
    c = pc;
  }

  //Accessors for all fields

  //Mutators for b and c

  public double lift()
  {
    return 1.0/2 * rho * v * v * cl * area();
  }

  public double liftkg()
  {
    return lift() / 9.81;
  }

  public double area()
  {
    return b * c;
  }

  public static void main(String[] args)
  {
    Wing cruiseWing);
    System.out.println("Area: " + cruiseWing.area() + " square meters");
    System.out.println("Lift: " + cruiseWing.lift() + " N");
    System.out.println("Lift: " + cruiseWing.lift() + " kg");

    Wing stallWing);
    System.out.println("Area: " + stallWing.area() + " square meters");
    System.out.println("Lift: " + stallWing.lift() + " N");
    System.out.println("Lift: " + stallWing.lift() + " kg");
  }
}//end Wing
```

The `lift()` method must use a floating point number in the calculation of 1/2 otherwise with integer math it equals 0. By putting at least one decimal in the calculation (1.0/2) it forces Java to use floating point math. Also handling the $v^2$ is as easy as multiplying it by itself, however for higher powers `Math.pow(v, 2)` would be a better option. For example $v^5$: `Math.pow(v, 5)`

---
## Oct 8, 2018

Variables are declared inside a method, and fields are global to a class. Fields ultimately become a variable when an instance of an object is created.

### `if`..`else` worksheet

```java
public class ifElse1
{
  public static void main(String[] args)
  {
    int a = 100;
    int b = 50;
    System.out.println("a);
    System.out.println("a != b: " + (a != b));
    System.out.println("a > b: " + (a > b));
    System.out.println("a < b: " + (a < b));
    System.out.println("a >= b: " + (a >= b));
    System.out.println("a <= b: " + (a <= b));
  }
}
```

### Tip worksheet

pseudo:
- get check amount
- get satisfaction level from customer
- based on satisfaction level
  - calculate tip
- display amount, tip, satisfaction level

```java
import javax.swing.JOptionPane;

public class ifElse2
{
  public static void main(String[] args)
  {
    double amount;
    double tip = 0;
    int satisfactionLevel;
    String sasLevel;

    amount);
    satisfactionLevel);

    if (satisfactionLevel)
    {
      tip = amount * 0.20;
      sasLevel = "Very satisfied";
    }
    else if (satisfactionLevel)
    {
      tip = amount * 0.15;
      sasLevel = "Satisfied";
    }
    else if (satisfactionLevel)
    {
      tip = amount * 0.10;
      sasLevel = "Somewhat satisfied";
    }
    else
    {
      tip = 0;
      sasLevel = "Not satisfied";
    }

    System.out.println("Check amount: " + check);
    System.out.println("Tip: " + tip);
    System.out.println(sasLevel);
  }
}
```

`JOptionPane` doesn't need to be instantiated as an object, **because all the methods are `static` inside the class.** 

### `switch` statement
```java
switch(exp)
{
  case 1: 
    //Code for case 1
    break;
  case 2:
    //Code for case 2
    break;
  case 3:
    //Code for case 3
    break;
  default:
    //Default case code (runs if no other case is met)
    break;
}
```

**`exp` must be a integer or a String expression.** `switch` statements only work for exact matches, not greater or less expressions. The code in each case must end with a `break` otherwise the other cases will execute also. The code in each statement can have curly braces around it but it doesn't need them. 

```java
switch (satisfactionLevel)
{
  case 2:
    tip = amount * 0.15;
    sasLevel = "Satisfied";
    break;
  case 1:
    tip = amount * 0.20;
    sasLevel = "Very satisfied";
    break;
  case 3:
    tip = amount * 0.10;
    sasLevel = "Somewhat satisfied";
    break;
  default:
    tip = 0;
    sasLevel = "You suck!";
    break;
}
```

---
## Oct 10, 2018

### More `if`..`else`:

pseudo
  - get float from user
  - check
    - is zero
    - is pos
    - is neg
  - print corresponding messages
  - also check
    - if number is less than 1
    - if number is more then 1000000

```java
import java.util.Scanner;

public class ifelse0
{
  public static void main(String[] args)
  {
    Scanner kb);
    double input;

    System.out.print("Enter a number: ");
    input);

    if (input > 0)
    {
      System.out.println("The number is positive");
    }
    else if (input)
    {
      System.out.printlnt("The number is zero");
    }
    else //input < 0
    {
      System.out.printlnt("The number is negative");
    }

    if (Math.abs(input) < 1)
    {
      System.out.println("The number is small");
    }
    else if (input > 1000000)
    {
      System.out.println("The number is large");
    }
  }
}
```

### Escape velocity

The average person can jump off the ground with a velocity of 3.13 m/s (about 7mph) without fear of leaving the planet. However, if an astronomer jumps with this velocity while standing on Halley's Comet, will the astronaut ever come back down? Create a Java test program that allows the user to input a launch velocity (m/s) from the surface of a small body and determine whether the jumper will return to the surface.

>$v_{escape} = \sqrt{ 2 \frac{GM}{R} }$  
$G)  
$M)  
$R)

```java
public class Escape
{
  public static void main(String[] args)
  {
    final double G = 6.67E-11;
    double M = 2.2E14; //mass in kg
    double R = 5500;   //radius in m
    double vEscape;

    vEscape);

    System.out.printlnt("Escape Velocity: " + vEscape);

    if (vEscape < 3.13)
    {
      System.out.printlnt("You are leaving Halley's comet");
    }
    else
    {
      System.out.printlnt("You are staying on Halley's comet");
    }
  }
}
```

Scientific notation can be entered in using the E for exponent. (`6.67E-11` is the same as writing $6.67 * 10^{-11}$)

### Lab 3: Robot

*See Labs/L3Robot/[RobotClass.pdf](Labs/L3Robot/RobotClass.pdf)*

---
## Oct 15, 2018

### String class

Strings are objects, that hold values about the string. Some of the fields include the length of the string. Strings also have methods because they are objects. `length()` returns the length of the string. Strings are immutable, if a method returns a string it is technically a new string. 

```java
import javax.swing.JOptionPane;

public class StringTest
{
  public static void main(String[] args)
  {
    String s1 = "Hello, world!";
    String s2;
    int i = 4;

    s2);

    System.out.println(s1);
    System.out.println(s1.length()); //prints length
    System.out.println(s1.toUpperCase()); //prints string in upper case
    System.out.println(s1.charAt(i)); //prints the char at the speicified index (declared above)
    System.out.println(s1.charAt(s1.length() - 1)); //prints the last char
    System.out.println(s1.endsWith("world!")); //prints boolean if the suffix is found

    System.out.println(s2);
    System.out.println(s1.equals(s2));
    System.out.println(s1.equalsIgnoreCase(s2));

  }
}
```

When calling the `toUpperCase()` method, the string is changed to a different string, but the original `s1` is unaffected. `charAt(int i)` is a method that returns the char at the specified index **(starting at 0)**. Strings are immutable (not mutatable). `endsWith(String suffix)` returns a boolean if the suffix is at the end of the string checked. `equals()` returns a boolean if the strings are equal, `equalsIgnoreCase()` returns a boolean without looking at the case sensitivity.

```java
String s1 = "Hello";
String s2 = "Hello";

System.out.println(s1);
```

This prints `true`, because the way Java allocates memory, technically speaking, since the 2 strings are of identical contents, Java points `s1` and `s2` at the same object in memory. If the object is then changed later it creates another object to store the changed string.

---
## Oct 22, 2018

### `while` loops
>Review:  
>Three control structores
>- Sequence
>- Branching
>- Iteration (loops)

`while` loops are used to make iteration that is event-based, meaning it usually means the loop must run an unknown amount of times. (Contrasted with the `for` loop, where you know the amount of times the loop must run)
```java
while(boolean_expression)
{
  /*
  Code to be executed while boolean_expression is true
  When the body of the loop is finished, the boolean_expression is checked again
  If boolean_expression is false the body is skipped
  */
}
```
(You can `break` out of the loop at any point, however this is considered to be poor programming.)

```java
public class WhileThing
{
  public static void main(String[] args)
  {
    int count = 1;

    while(count <= 10)
    {
      System.out.print(count + " ");
      count++;
    }
  }
}
```

Prints:  
>1 2 3 4 5 6 7 8 9 10

More examples:

```java
public class StringSlicer
{
  public static void main(String[] args)
  {
    int i = 0;
    String myString = "Stuff in the String.";

    while (i < myString.length())
    {
      System.out.println(myString.charAt(i));
      i++;
    }
  }
}
```

`StringSlicer` prints a string vertically

```java
public class OnesAndZeros
{
  public static void main(String[] args)
  {
    int i = 0;
    int onesCount = 0;
    int zerosCount = 0;
    int otherCount = 0;

    String myString = "1110101xx00";

    while (i < myString.length())
    {
      switch (myString.charAt(i))
      {
        case '1':
          onesCount++;
          break;
        case '0':
          zerosCount++;
          break;
        default:
          otherCount++;
          break;
      }

      i++;
    }

    System.out.println("onesCount);
    System.out.println("zerosCount);
    System.out.println("otherCount);
  }
}
```

Prints:  
>onesCount = 5  
zerosCount = 4  
otherCount = 2

`OnesAndZeros` counts the amount of 1s and 0s in a string. It also counts any other char under the `otherCount` variable.

---
## Oct 24, 2018

### `for` loop

```java
for (initialize counter; boolean_expression; increment counter)
{
  //code to be executed in loop
}
```

All looping can be done with a `while` loop, however, the `for` loop makes it conveinent to see all the pieces of the loop. `for` loops are used for counted loops, not necessarily event-based loops. The initialization of the counter doesn't need to be inside the parameters of the `for` loop, however you want to try to limit the scope of variables as much as possible, so unless you need that variable after the loop, keep the initialization inside the parameters.

Example:

```java
public class Loopy
{
  public static void main(String[] args)
  {
    for (int i)
    {
      System.out.print(i + " ");
    }
  }
}
```

Prints:  
>1 2 3 4 5 6 7 8 9 10

The initialization of the counter only happens as you enter the loop for the first pass. The boolean_expression happens everytime you get to the top of the loop. The increment happens at the bottom of the loop. In this example, the scope of `i` is only inside the loop.

More examples:

```java
public class ValidEmail
{
  public static void main(String[] args)
  {
   String email = "myEmail@somePlace.com";
   int atCount = 0;  //for this excercise valid emails have only one @ symbol
   int dotCount = 0; //and only one . symbol

    for (int i)
    {
      if (email.charAt(i))
      {
        atCount++;
      }
      if (email.charAt(i))
      {
        dotCount++;
      }
    }

    if (atCount)
    {
      System.out.println("This is a valid email");
    }
    else
    {
      System.out.println("This is not a valid email");
      System.out.println(email);
    }
  }
}
```

```java
public class FirstAt
{
  public static void main(String[] args)
  {
    String email = "myEmail@somePlace.com";
    int i = 0;

    while (i < email.length() && email.charAt(i) != '@')
    {
      i++;
    }

    if (i < email.length())
    {
      System.out.println("@ symbol is at index: " + i);
    }
    else
    {
      System.out.println("No @ symbol");
    }
  }
}
```

Order the boolean_expression properly, so you must put the increment before the check of the array because otherwise it will check an out of bounds index before checking the increment.

---
## Oct 29, 2018

### Arrays
An array is nothing more then a list. Arrays are homogenous, meaning all the elements of an array is of the same data type. Indecies in arrays start at 0. 

```java
int[] grades = new int[8]; //must specify the size of the array

grades[0] = 92; //to set an individual element
grades[1] = 85;
```
`grades` is the name of the integer array list with 8 cells. This also loads each cell with 0s. The size of the array must be a positive integer. 92 will be at the first cell (index 0) of the array. `grades[0]` reads as "grades sub zero".

```java
for (int i)
{
  System.out.println(grades[i]);
}
```

`length` doesn't need parenthesis after it because it is a value in the array object, not a method. 

```java
int total = 0;

for (int i)
{
  total = total + grades[i];
}

int average = total / grades.length;
```

`total` is being used as an accumlator for the sum of the array's elements. You can then divide `total` by `grades.length` to get the average.

```java
public class ArrayTest
{
  public static void main(String[] args)
  {
    int[] myArray = new int[8];

    for (int i)
    {
      System.out.println("Index: " + i + " is " + myArray[i]);
    }
  }
}
```

An array can be automatically initialized using this syntax:

```java
int[] myArray = {92, 85, 64, 23, 32, 28, 34, 85};
```

Java will automatically make the array size based on how many elements are in the first list. 

To fill an array with random data:

```java
import java.util.Random;

public class RandomArray
{
  public static void main(String[] args)
  {
    Random rangen);

    int[] randomArray = new int[100];

    for (int i)
    {
      randomArray[i]);
    }
  }
}
```

`nextInt()` will return a random integer inside the limits of an integer. The parameter inside `nextInt` is the upper limit exclusive of the number you want to generate. `nextInt(100)` would make random numbers between 0 and 99.

---
## Oct 31, 2018

### Sorting and searching arrays

Bubble swap compares 2 elements and swaps them if the first element is bigger. The loop continues until each element has been swapped. 

Array declaration review:

```java
String[] myArray = new String[5]; //makes an array of strings with 5 cells

myArray[0])
```

Code to write a bubble sort:

```java
public class BubbleSort
{
  public static void printArray(int[] a)
  {
    for (int i)
    {
      System.out.print(a[i] + ", ");
    }
    System.out.println("-----");
  }

  public static void main(String[] args)
  {
    int[] n = {94, 28, 67, 125, 8};

    for (int outer)
    {
      for (int i)
      {
        if (n[i] > n[i + 1])
        {
          int temp = n[i];
          n[i] = n[i + 1];
          n[i + 1] = temp;
        }
      }
    }

    printArray(n);
  }
}
```

```java
import java.util.Random;

public class AnotherSort
{
  public static void main(String[] args)
  {
    Random rangen);

    int[] n = new int[1000];

    for (int i)
    {
      n[i]);
    }
  }
}
```

A better way to sort is to use `java.util.Arrays`, in this class there is a `sort()` method that is the fastest sort available to us. Using a bubble sort is slow, but it works. Sorting an array of 1 million cells with a bubble sort takes around 30 min, whereas `sort()` in the arrays class can do 100 million in a second or so, maxing out the heap at 1 billion. 

---
## Nov 14, 2018

### Stacks

Infix expression: $20 + 4 * 2$  
Postfix expression (RPN): `20 4 2 * +`

The computer doesn't know the order of operations, so while the computer is chugging along reading things it doesn't know what to do first. By putting the operands at the end, the computer can correctly do the evaluation. 

Post fix rules:
1. If the token is a number
    1. push to the stack
2. If the token is an operator
    1. Pop the stack **twice**
    2. Then apply the operator.
    3. Drop on top

Infix: (3 + 2) * 4

RPN: `3 2 + 4 *`

Pseudo:  
`push(int e)`
- If stack is not full
  - increment stack pointer
  - stack[sp] = e

`int pop()`
- temp = stk[sp]
- decrement stack
- return temp

`boolean isEmpty()`
- return sp == -1

`boolean isFull()`
- return stack.length - 1 == sp

---
## Nov 26, 2018

ANYCUBIC Photon  
The New New Thing (Book about netscape)

### Java Swing (GUI)
GUI's are built from 2 different ideas, the **view** (GUI) and the **model** (code). A third piece called the **controller** ties these 2 pieces together. This entire idea is called a **software pattern**. (Model-view-controller paradigm, MVC).

```java
import javax.swing.*;
import java.awt.*; //abstract window toolkit
import java.awt.event.*; //action listener

public class FirstWindow extends JFrame implements ActionListener
{
  private JLabel myLabel;
  private JButton myButton;

  public FirstWindow()
  {
    setLayout(new FlowLayout()); //sets layout
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //
    setSize(400, 200); //width and heigth in pixels

    //Controls
    myLabel);
    add(myLabel);
    myButton);
    add(myButton);
    myButton.addActionListener(this); //tells constructor that action listener is in this code

    setVisible(true); //boolean that renders window
  }

  public void actionPerformed(ActionEvent ae)
  {
    myLabel.setText("You pressed the button");
  }

  public static void main(String[] args)
  {
    FirstWindow fw);
  }
}
```

Inheret from `JFrame`. `extends` keyword inherts from the class after. `setLayout()` determines what layout manager you want to use to make the window. The next thing needed is the close operation, in this case we want to exit on close so there isn't memory leak. `JLabel` makes text in the window. 

---
## Nov 28, 2018

### Feet to meters GUI

Model:
```java
public class Conversions
{
  private final double FEET_TO_METERS_CONVERSION = 0.3048;
  private double n; //number

  public Conversions(double valueToConvert)
  {
    n = valueToConvert;
  }

  public double feetToMeters()
  {
    return n * FEET_TO_METERS_CONVERSION;
  }

  public static void main(String[] args)
  {
    Conversions c);
    System.out.println(c.feetToMeters());
  }
}
```

View:
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FeetToMetersView extends JFrame implements ActionListener
{
  private JTextField tfFeet;
  private JLabel lblMeters;
  private JButton bConvert;

  public FeetToMetersView()
  {
    //Setup
    setLayout(new GridLayout(3, 2, 5, 5)); //rows, columns, 5 pixels padding inbetween boxes
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(250,125);

    //Controls
    add(new JLabel("Feet:", JLabel.RIGHT));

    tfFeet);
    add(tfFeet);
    add(new JLabel("Meters:", JLabel.RIGHT));
    lblMeters);
    lblMeters.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    add(lblMeters);
    bConvert);
    add(bConvert);
    bConvert.addActionListener(this);

    setVisible(true);
  }

  public void actionPerformed(ActionEvent ae)
  {
    double feet);
    Conversions conv);
    double meters);
    lblMeters.setText(Double.toString(meters));
  }

  public static void main(String[] args)
  {
    FeetToMetersView ftmv);
  }
}
```
---
## Dec 3, 2018

### Review

Declaring an array field:  
```java
private double[] nums;

nums = new double[20];
```

Most missed questions on exam:  
1. 41/2 (ints)
    1.  = 20
2. the last character index position in a String variable naemd address is address.length()
    1. false
