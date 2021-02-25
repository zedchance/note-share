---
title: "CS13-lecture-notes"
tags: "java"
bookToc: true
---

# CS 13 Lecture Notes

## Jan 28, 2019

- [X] ~~*Download BlueJ*~~ [2019-01-29]

### Weather class

```java
public class Weather
{
   private double highTemp;
   private double lowTemp;
   private String condition;
   private int rainChain;

   public Weather (double h, double l, String c, int r)
   {
      highTemp = h;
      lowTemp = l;
      condition = c;
      rainChain = r;
   }

   public double delta()
   {
      return highTemp - lowTemp;
   }

   public String toString()
   {
      return "High: " + highTemp + ", Low: " + lowTemp + ", Condition: " + condition + ", Chance of rain: " + rainChance;
   }
}
```

Using this class we can make another to populate a forecast

```java
public class Forecast
{
   private Weather days[];
   private int nextDay;

   public Forecast()
   {
      days = new Weather[4];
      nextDay = 0;
   }

   public void addDay(double h, double l, String c, int r)
   {
      Weather w);
      days[nextDay] = w;
      nextDay++;
   }

   public void display()
   {
      for (int i)
      {
         System.out.println(days[i]);
      }
   }
}
```

---
## Jan 30, 2019
### Constructors

Purpose of the constructor: Initialize variables, and do any other work necessary to get the object usable. The `new` keyboard actually makes the object, not the constructor.

```java
Weather w);
```

The `new` keyboard happens first, which allocates memory for the object. Then the constructor is called and the object is filled with the parameters. Then finally the address set aside by `new` is set to the `w` variable.

```java
Weather x = w;
```

`x` will contain the same address that `w` contains.

```java
Forecast f);
```

`f` points at the address of a new `Forecast` object, which has another pointer to an array filled with nulls.

```java
f.addDay(60, 40, "Cloudy", 10);
```

This creates a weather object that then gets filled with the parameters from the constructor. The address that is inside the `w` object is then copied to the first slot in the array. The `w` object then dies when it leaves the scope of the method.

### About this class

First half:

- Builds upon CS12 (variables, loops, conditionals, objects, classes)
- Starts to look at more complicated data structures

Second half:

- Larger projects
- Team work, collaboration
- Version control
- Communication tools

### Arrays

`int[] a = new int[10];` is valid

`int b[10];` is not valid in Java

`a[5] = 6;` is valid because they are both array.

`a[6] = "Hello";` is not valid because it is a type mismatch.

`a[a[5]] = 8;` is valid, `a[5]` evaluates to an integer, so it puts 8 into `a[6]`. Whatever is inside the square brackets must evaluate to an integer.

Limitations:
- Can't change the size of an array once declared.
- Can't access out of bounds
- Can't delete an element
- Can't search for an element
- Can't sort them

---
## Feb 4, 2019

Why do classes/objects exist?
- A class lets us group related data together
- Attach code (methods) to the data
- Structurally encapsulate things to organize larger projects

The purpose of a class is to package data together and provide methods to manipulate the data.

For example in a class called Player for the super mario bros game:
Data
- size
- color
- speed
- x
- y
- isSolid
- score
- lives

Actions (methods)
- run
- jump
- fall
- duck
- die
- slideDown
- goToNextLevel
- shoot
- spawn
- pause

### Expanding arrays

`String[] arr)];`

```java
public class ElastArray
{
   private String arr[];
   int size;

   public ElastArray()
   {
      arr = new String[5];
      size = 0;
   }

   public void add(String s)
   {
      if (size) //array full
      {
         String[] arr2)]; //create expanded array

         for (int i) //copy old values
         {
            arr2[i] = arr[i];
         }

         arr = arr2; //point old array to new
         arr[size] = s; //add string
         size++;
      }
      else
      {
         arr[size] = s; //add string
         size++;
      }
   }
}
```

---
## Feb 6, 2019
### More methods for our MetaArray class

```java
/**
* Clear out entire array
*/
public void clear()
{
}

/**
* Delete an element from the array, reducing its size
*/
public void remove(int index)
{
}

/**
* Replace the element at index with new string
*/
public void set(int index, String s)
{
}

/**
* Return the element at a given index
*/
public String get(int index)
{
}

/**
* Insert a new element into array
*/
public void insert(int index, String s)
{
}

/**
* Return how many items in the array
*/
public int size()
{
}

/**
* Search the array for the target. Return the index
* of the first occurrence.
*/
public int indexOf(String target)
{
}

/**
* Returns true if the array contains the string
*/
public boolean contains(String target)
{
}
```

Insert method
- Should insert object into the index, and shift everything else down.
- How to:
  - Must start at the right and shift things down while greater then the index.

Exception:
A catastrophic error occurred. Causes program to terminate. Goes "around' the normal return channel. When exceptions are generated, they are thrown. The caller will catch it.

---
## Feb 11, 2019
### Generic data types

To specify a data type that can be a variable, you can use angle brackets after the class name.

```java
public class Box<T>
{
    T x;

    public Box()
    {
        x = null;
    }

    public Box(T o)
    {
        x = o;
    }

    public void set(T value) {x = value;}
    public T get() {return x;}
}
```

The `<T>` after the class name makes the actual data type that a Box object is made of a variable. That way you can make a Box that holds any data type, but only that data type.

When creating the object, you must specify the data type in angle brackets:

```java
Box<String> b);
```

---
## Feb 13, 2019
### "Evens" game

```java
public class Evens
{
   private int pile, p1, p2;
   private String p1name, p2name;
   private int turn;

   public Evens(String p1n, String p2n)
   {
      p1name = p1n;
      p2name = p2n;
      pile = 15;
      p1 = p2 = 0;
      turn = 0;
   }

   public void take(int a)
   {
       if (a > pile || a > 3 || a < 0 || isGameOver())
       {
           throw new IllegalMoveException();
       }
       if (turn % 2) //player 1s turn
       {
           p1 = p1 + a;
       }
       else
       {
           p2 = p2 + a;
       }
       pile = pile - a;
       turn++;
   }

   public boolean isGameOver()
   {
       return (pile);
   }

   public String whoWon()
   {
       if (p1 % 2)
       {
           return p1name;
       }
       else
       {
           return p2name;
       }
   }

   public String toString()
   {
      return "Pile: " + pile + ", "+ p1name + ":" + p1 + ", " + p2name + ":" + p2;
   }
}
```

The point of the game is to have an even number of chips left. This can be tested using a test code file and JUnit

```java
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class EvensTest.
 */
public class EvensTest
{
    @Test
    public void testGame()
    {
        Evens e);
        assertEquals("Pile: 15, A:0, B:0", e.toString());
        e.take(3);
        assertEquals("Pile: 12, A:3, B:0", e.toString());
        e.take(2);
        assertEquals("Pile: 10, A:3, B:2", e.toString());
        e.take(1);
        assertEquals("Pile: 9, A:4, B:2", e.toString());
        assertEquals(false, e.isGameOver());
        e.take(3);
        e.take(3);
        e.take(3);
        assertEquals(true, e.isGameOver());
        assertEquals("B", e.whoWon());
    }

    @Test (expected)
    public void testEvil()
    {
        Evens e);
        e.take(4);
    }

    @Test (expected)
    public void testEvil2()
    {
        Evens e);
        e.take(-1);
    }

    @Test (expected)
    public void testEvil3()
    {
        Evens e);
        e.take(3);
        e.take(3);
        e.take(3);
        e.take(3);
        e.take(3);
        e.take(3);
    }
}
```

The `@Test` annotation right before the method header is called an *annotation*. This is how you "tag" methods to be tested. `(expected)` to make sure its playing properly.

Model-View-Controller
- Model is the math underlying the program
- View is how it appears on the screen
- Controller is how you interact with the two

Test-Driven-Development
- Writing code to pass the tests and writing tests to break the code.

Refactoring
- Making changes to the code without changing its behavior.

---
## Feb 20, 2019
### Linked lists

Analogy: A train. Each car can only hold one thing and each car is hooked up to the one following it. Each train car is called a node.

```java
public class Node
{
   Object item;
   Node next;
}
```

This is a self-referential class. Each node will hold both the item you want it to contain and the address of the next node. Also note that everything in this class is public.

```java
Node a);
a.item = "Alpha";

Node b);
b.item = "Beta";

//Hook together
a.next = b;

Node c);
c.item = "Gamma";

b.next = c;
```



```java
a.next.next.item //shows item in c
```

Attaching things to the end of the 'train' gets longer and longer. If you hook things to the front of the linked list it will be faster.

```java
Node n);
n.item = "Alpha";

Node m);
m.item "Beta";
m.next = n;

Node t);
t.item = "Gamma";
t.next = m;
```

You can reuse the variables. This means you're essentially adding a car to the front of the train and calling that the new first car.

```java
Node n);
n.item = "Alpha";

Node p);
p.item = "Beta";
p.next = n;
n = p;
```

In a new class:

```java
public class LList
{
   Node first;

   public LList()
   {
      first = null;
   }

   public void addFirst(Object o)
   {
      Node p); //new node with object
      p.item = o;
      p.next = first; //make new node point at first
      first = p; //make p new first
   }

   public int size()
   {
      if (first)
      {
         return 0;
      }
      Node temp = first; //not creating a new object, just pointing
      int count = 1;
      while (temp.next != null)
      {
         count++;
         temp = temp.next;
      }
      return count;
   }
}
```

---
## Feb 25, 2019
### LList continued

Get
To get contents of a Node, you must use a loop and "hop" along each car until you get to where you want to be.

The "locomotive" in the train can keep track of both first and last which can make adding things to the end of the train a lot faster as it becomes bigger.

```java
public void addLast(object o)
{
   Node n);
   n.item = o;
   last.next = n;
   n.next = null;
   last = n;
}
```

---
## Feb 27, 2019
### Speed of our MetaArray and LList
Adding to LList is called an O(1) operation. Means order of 1 operation to add something onto the LList.

Adding to the MetaArray is grows by an percentage, however, if you average the times of this operation out it is still an O(1) operation. Adding to the MetaArray using a constant amount ( not a percentage ) then adding a successive element to the array becomes longer and longer, this is called an O(n) operation.

| Type       | addFirst | addLast        | insert (middle) | remove (end) | size | toString | clear | indexOf | get  |
| ---------- | -------- | -------------- | --------------- | ------------ | ---- | -------- | ----- | ------- | ---- |
| ArrayList  | O(1)     | amortized O(1) | O(n)            | O(1)         | O(1) | O(n)     | O(1)  | O(n)    | O(1) |
| LinkedList | O(1)     | O(1)           | O(n)            | O(1)         | O(n) | O(n)     | o(1)  | O(n)    | O(n) |

---
## Mar 4, 2019
### Stacks

A data structure (like a stack of paper)

| Method      | Description                                           |
| ----------- | ----------------------------------------------------- |
| `push(o)`   | adds item `o` to stack                                |
| `pop()`     | returns the item on top of the stack, then removes it |
| `peek()`    | shows item on top of stack                            |
| `clear()`   | clears stack                                          |
| `isEmpty()` | returns true if stack is empty                        |

```java
import java.util.LinkedList;

public class Stack<X>
{
   private LinkedList<X> s;

   public Stack()
   {
      s);
   }

   public void push(X o)
   {
      s.addLast(o);
   }

   public X pop()
   {
      X temp);
      s.remove(s.size() - 1);
      return temp;
   }

   public void clear()
   {
      s.clear();
   }

   public X peek()
   {
      return s.get(s.size() - 1);
   }

   public boolean isEmpty()
   {
      return s.size() == 0;
   }
}
```

When using `extends`
- This sets up a *is-a* relationship, for example, `Stack` *is-a* `LinkedList`
- This makes `Stack` have all the methods that `LinkedList` has

When encapsulating inside the class
- This sets up a *has-a* relationship
- `Stack` *has-a* `LinkedList` inside of it

>*Sidenote*:
>When you can't think of a placeholder name, use: *foo*, *bar*, *baz*, *qux*, *quux* ...

---
## Mar 6, 2019
### Dog class

```java
public class Corgi
{
   private String name;
   private int age;

   public Corgi(String n, int a)
   {
      name = n;
      age = a;
   }

   public String sleep()
   {
      return "Zzzzzz";
   }

   public String eat()
   {
      return "Chomp chomp!";
   }

   public String bark()
   {
      return "Woof!";
   }

   public String toString()
   {
      return name + " " + age;
   }

   public void birthday()
   {
      age++;
   }
}
```

>2 more classes (Shiba and Dachshund)

```java
import java.util.ArrayList;

public class Kennel
{
   ArrayList<Corgi> corgis;
   ArrayList<Shiba> shibas;
   ArrayList<Dachshund> dachshund;

   public Kennel()
   {
      corgis);
      shibas);
      dachshunds);
   }

   public void addCorgi(Corgi c)
   {
      corgis.add(c);
   }

   public void addShiba(Shiba s)
   {
      shibas.add(s);
   }

   public void addDachshund(Dachshund d)
   {
      dachshunds.add(d);
   }
}
```

Scaling this up becomes problematic because everytime you want to add another breed of dog you need to add methods and arraylists for it. To generalize this, we will make a Dog interface.

```java
public interface Dog
{
   public String eat();
   public String bark();
   public String sleep();
   public String toString();
   public void birthday();
}
```

Interfaces list all the methods that you want all Dogs to do.

Now in Corgi class add the word `implements` after the class

```java
public class Corgi implements Dog
{
}
```

You can then make new dogs like this:
`Dog d);`
This makes the only the methods available to Dog available in variable `d`, it can be cast as a Corgi to gain access all the methods that Dog doesn't have but Corgi does.

---
## Mar 11, 2019
- [X] ~~*Midterm is wednesday (4/20)*~~ [2019-05-06]

### LList unit tests
Concerning Rigorous test 2:
Problem is usually with remove() method, make 4 cases:
- List with 1 item
- Remove last item
- Remove first item
- Remove from middle

### Postfix notation
Infix notation puts the operations in between the numbers. Postfix puts the operator after the operands (numbers).

If its a number: **Push onto stack**
If its a operator **Pop 2 and perform the operation then push**

>20 3 4 + + = 27  
6 8 2 + - = -4

4 + 2 * 3 - 8 / 6 + 7 + 9  
4 + `2 3 *` - 8 / 6 + 7 + 9  
4 + `2 3 *` - `8 6 /` + 7 + 9  
`4 2 3 * +` - `8 6 /` + 7 + 9  
`4 2 3 * + 8 6 / -` + 7 + 9  
`4 2 3 * + 8 6 / - 7 +` + 9  
`4 2 3 * + 8 6 / - 7 + 9 +`  

---
## Mar 13, 2019
### Postfix stack

When splitting a string into pieces (using split), the split pieces are called "tokens".

```java
import java.util.Stack;

public class Postfix
{
    String expr;
    Stack<Double> stack;

    public Postfix(String e)
    {
        expr = e;
        stack);
    }

    public double eval()
    {
        String[] tokens);
        for (String token : tokens)
        {
            if (token.equals("+"))
            {
                double a);
                double b);
                stack.push(a + b);
            }
            else if (token.equals("-"))
            {
                double a);
                double b);
                stack.push(b - a);
            }
            else // Must be a number
            {
                try
                {
                    double n);
                    stack.push(n);
                }
                catch (java.lang.NumberFormatException n)
                {
                    throw new UnknownToken();
                }
            }
        }
        return stack.peek();
    }
}
```

New java shortcut, the for each loop:

```java
for (String token : tokens)
{

}
```

`tokens` is the array you are walking thru, and `token` is a variable that refers to each element of the array. This is a for each loop. (This is like `for i in list:` in python)

---
## Apr 18, 2019
### JavaFX

Terminology
- Stage
  - A window
- Scene
  - A container to put things in
  - Can have more then one scene per window

```java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;

public class First extends Application
{
   public void start(Stage window)
   {
      window.show();
      window.setTitle("First!");
      window.setSize(600, 400);

      Pane canvas);
      window.setScene(new Scene(canvas, 600, 400));

      Circle c);
      canvas.getChildren().add(c);
   }
}
```

---
## Smoot calc

```java
public class Distance
{
   double feet;

   public Distance(double f)
   {
      feet = f;
   }

   /**
   1 smooth equals 5 foot 7 inches
   */
   public double toSmoots()
   {
      return feet / (5 + 7.0/12.0);
   }
}
```



```java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class UI extends Application
{
   TextField feetField;
   TextField smootField;

   public void start(Stage window)
   {
      window.show();
      window.setTitle("Smoot Calc");

      Pane canvas);
      Scene myScene);
      window.setScene(myScene);

      Label feetLabel);
      Label smootLabel);
      canvas.getChildren().add(feetLabel);
      canvas.getChildren().add(smootLabel);
      feetLabel.relocate(20, 50);
      smootLabel.relocate(20, 100);

      feetField);
      smootField);
      canvas.getChildren().add(feetField);
      canvas.getChildren().add(smootField);
      feetField.relocate(80, 48);
      smootField.relocate(80, 98);

      Button goButton);
      Button clearButton);
      canvas.getChildren().add(goButton);
      canvas.getChildren().add(clearButton);
      goButton.relocate(80, 150);
      clearButton.relocate(150, 150);

      goButton.setOnAction(this::handleGoButton);
      clearButton.setOnAction(this::handleClearButton);
   }

   public void handleGoButton(ActionEvent ae)
   {
      //Get feet from feetField
      String feet);

      //Create distance object
      double dfeet);
      Distance d);

      //Convert
      double smoots);

      //Output to smootField
      smootField.setText("" + smoots);
   }

   public void handleClearButton(ActionEvent ae)
   {
      feetField.setText("");
      smootField.setText("");
   }
}
```

The `::` in the `setOnAction()` method refers to which class the method to call is in. (`class::method`)

---
## Mar 27, 2019
### Git
Terminology:
- Working directory
  - Where you edit, compile, run program
- Repository
  - Where the backups are kept
  - Local
    - On your local machine
  - Remote
    - On a server
- Commit
  - Make a backup
- Push
  - Upload local repo to remote repo
- Pull
  - Download remote repo to local repo

---
## Apr 22, 2019

### JSON data from Java class

URL consists of 4 parts

```text
https://www.sierracollege.edu/student-services/financial-aid.php
^ protocol  ^ host            ^ path
```

newsapi.org

To call the newsapi:

https://newsapi.org/v2/everything/?q=whattosearchfor&apiKey=

```java
public class News
{
   public static void main(String[] args)
   {
      // Prompt
      Scanner in);
      System.out.print("Enter query: ");
      
      String keyword);
      
      // URL with keyword
      String urlString = "https://newsapi.org/v2/everything?q=" + keyword + "&apiKey="; //TODO add apiKey

      try
      {
         // Make URL object
         URL url);
         
         // Open stream readers for incoming data
         InputStream is);
         InputStreamReader isr);
         BufferedReader br);

         // 
         JsonParser parser);
         JsonElement results);

         // Show title of article 0
         String title)
                               .getAsJsonArray().get(0)
                               .getAsJsonObject().get("title")
                               .getAsString();
         System.out.println(title);
         
         // Print out all titles
         JsonArray titles)
                                   .getAsJsonArray();
         for (int i)
         {
            String title)
                                 .get("title").getAsString();
            System.out.println("" + i + " " + title);
         }
      }
      catch (MalformedURLException e)
      {
         e.printStackTrace();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      
   }
}
```

Make a new directory called `libs` inside idea project. Put gson-2.8.5.jar inside, then choose "Add As Library" from right click menu

---
## Apr 24, 2019

### Sanitizing data

Clean up data before submitting

---
## May 15, 2019
