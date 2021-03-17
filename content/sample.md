---
title: "Sample"
date: 2021-02-24T22:10:59-08:00
draft: false
bookToc: true
bookHidden: true
tags: []
---

# Format testing

## Voluptatem sunt ut `asperiores`.

Quis iusto non et aut omnis officiis tempora.
*Odit aut ullam nisi voluptas a.*
Est animi et ut natus molestias sit.
Quis iusto non et aut omnis officiis tempora.
Quis iusto non et aut omnis officiis tempora.
*Odit aut ullam nisi voluptas a.*
Est animi et ut natus molestias sit.
*Odit aut ullam nisi voluptas a.*
Est animi et ut natus molestias sit.

{{< hint danger >}}
Danger!!!

Voluptatem sunt ut asperiores. Quis iusto non et aut omnis officiis tempora. Odit aut ullam nisi voluptas a. Est animi et ut natus molestias sit.

\\[f(x) = \sqrt{n}\\]
{{< columns >}}
one
Voluptatem sunt ut asperiores. Quis iusto non et aut omnis officiis tempora. Odit aut ullam nisi voluptas a. Est animi et ut natus molestias sit.
<--->
Another
Voluptatem sunt ut asperiores. Quis iusto non et aut omnis officiis tempora. Odit aut ullam nisi voluptas a. Est animi et ut natus molestias sit.
{{< /columns >}}
{{< /hint >}}

{{< columns >}}
Here is the first column.
Et `fuga` quae sed.
Tempore facilis *maiores quis ut qui quis a cumque*.
Accusamus quia error est. Veritatis vero dolor et molestiae exercitationem.

```java
System.out.println("Yo, world!");
```

Nostrum et eveniet dolorum. `Soluta` sint voluptas eligendi. **Qui molestiae enim laborum necessitatibus sed cumque** velit. Laborum aut repellendus et qui possimus architecto cum. Quis laboriosam nostrum quia.
<--->
Here is some more stuff in the second column.

```
// code
```

{{< katex display >}}
\begin{aligned}
    f(x) = \sqrt{n}
\end{aligned}
{{< /katex >}}

{{< mermaid class="text-center" >}}
classDiagram
    class Test {
        + int x
        + int y
        + getLocation()
    }
{{< /mermaid >}}

Here we go with some more.
Voluptate ***quo corporis explicabo nobis***.
In excepturi ea enim pariatur qui inventore quibusdam.

{{< /columns >}}

{{< mermaid class="text-center" >}}
gitGraph:
options
{
    "nodeSpacing": 150,
    "nodeRadius": 10
}
end
commit
branch newbranch
checkout newbranch
commit
commit
checkout master
commit
merge newbranch
{{< /mermaid >}}

{{< details title="Example 2" open=true >}}
Is this, here we go.

```
code in here
```

\\[f(x) = \sqrt{n}\\]

## Id non fuga molestias doloribus.

Temporibus iure quam sequi rerum accusantium libero. Dolores odio eaque reprehenderit veniam temporibus voluptatem. Possimus non expedita blanditiis sit sed voluptatibus iste.
Et inventore odit possimus itaque maxime dolorum debitis. Eos explicabo possimus repellat. Earum qui fuga laudantium.
{{< /details >}}

{{< hint info >}}
Here is some info.

I think I can keep putting stuff below.

{{< katex display >}}
\begin{aligned}
    f(x) = 200000
\end{aligned}
{{< /katex >}}

{{< /hint >}}

{{< hint warning >}}
Look out for this warning.

Nostrum et eveniet dolorum. Soluta sint voluptas eligendi. Qui molestiae enim laborum necessitatibus sed cumque velit. Laborum aut repellendus et qui possimus architecto cum. Quis laboriosam nostrum quia.
Voluptatem sunt ut asperiores. Quis iusto non et aut omnis officiis tempora. Odit aut ullam nisi voluptas a. Est animi et ut natus molestias sit.
{{< /hint >}}

## More down here

{{< katex display >}}
\begin{aligned}
    f(x) = \int_a^b \mathrm{d}x
\end{aligned}
{{< /katex >}}

{{< details title="Gist inside" open=false >}}
<script src="https://gist.github.com/zedchance/bf09270ee8304cb6c0490cbb263754fb.js"></script>
{{< /details >}}

Here

```java
public static void main(String[] args)
{
    // cool
    System.out.println("Here is some text!");
}
```

## Mermaid diagrams

{{< columns >}}
{{< mermaid class="text-center" >}}
classDiagram
    Man <-- Employee
    Mo <|-- Man
    Man <.. IMovable
    class Man {
        + String name
        + rest()
        - remember()
    }
    class Employee {
        - int x
        - int y
        + buyAnother()
    }
    class Mo {
        + String type
        - newMethodHere()
    }
    class IMovable {
        + changeDirection()
    }
{{< /mermaid >}}
<--->
{{< mermaid class="text-center" >}}
graph TD
    1 --> 2
    2 --> 3
    HEAD --> 3
{{< /mermaid >}}

{{< mermaid class="text-center" >}}
graph TD
    s1([s1])
    s2([s2])
    s1 -->|a| s1
    s1 -->|b| s2
{{< /mermaid >}}
{{< /columns >}}



{{< mermaid class="text-center" >}}
pie title NETFLIX
         "Time spent looking for movie" : 90
         "Time spent watching it" : 10
{{< /mermaid >}}

{{< mermaid class="text-center" >}}
sequenceDiagram
    Alice ->> Bob: Hello Bob, how are you?
    Bob-->>John: How about you John?
    Bob--x Alice: I am good thanks!
    Bob-x John: I am good thanks!
    Note right of John: Bob thinks a long<br/>long time, so long<br/>that the text does<br/>not fit on a row.

    Bob-->Alice: Checking with John...
    Alice->John: Yes... John, how are you?
{{< /mermaid >}}

{{< mermaid class="text-center" >}}
sequenceDiagram
    Client ->> Server: GET /index
    Server ->> Client: OK 200
{{< /mermaid >}}

{{< mermaid class="text-center" >}}
classDiagram
class Shape{
    <<interface>>
    noOfVertices
    draw()
}
class Color{
    <<enumeration>>
    RED
    BLUE
    GREEN
    WHITE
    BLACK
}
{{< /mermaid >}}


{{< mermaid class="text-center" >}}
classDiagram
    GameObject <|-- Fixed
    GameObject <|-- Movable
    Fixed <|-- Blimp

    class GameObject {
        int x
        int y
        int size
        int color
    }
    class Movable {
        int speed
        int heading
    }
    class Blimp {
        int capacity
    }
{{< /mermaid >}}

