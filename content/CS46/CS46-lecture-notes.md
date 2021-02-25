---
title: "CS46-lecture-notes"
tags: "C"
---

# CS 46 Lecture Notes

## August 27

```c
#include <stdio.h>

int main()
{
   printf("I <3 C\n");
}
```



```c
#include <stdio.h>

int main()
{
   for (int i)
   {
      printf("I <3 C\n");
   }
}
```



```c
#include <stdio.h>

int main()
{
   printf("Enter your agge: ");
   int age;
   scanf("%d", &age); // scanf is expecting a decimal (base 10), and stores it in age
   int dogAge = age * 7;
   printf("You are %d dog years old \n", dogAge);
}
```

To compile:  
Type `clang file.c` where file is the name of the file

This will make a new file, to run this program type `./.a.out` where a.out is the name of the file created

```c
#include <stdio.h>

int main()
{
   printf("Enter two numbers: ");
   int a, b;
   scanf("%d%d", &a, &b);
   printf("Average of %d and %d is: %d", a, b, (a + b) / 2)
}
```

Differences between Java and C  
- `#include` is kind of like import but not exactly
- No classes
- Not OO
- No public/private
- String is not a type

Primitive data types
| Java    | C                                                                                               |
| ------- | ----------------------------------------------------------------------------------------------- |
| boolean | no equiavlent, use int                                                                          |
| char    | char is a byte                                                                                  |
| int     | int is defined as a int with as many bits as the machine its running on, most natural data type |
| double  | same                                                                                            |
| float   | same                                                                                            |
| byte    | Use char                                                                                        |
| short   | half the size of an int                                                                         |
| long    | double the size of an int                                                                       |

---

## August 29

### Data types and syntax

Primitive types  
Java | C
--- | ---
int | int
double | double
char | no equivalent
boolean | int
byte | char
String | char[]
float | float

C has unsigned intger types:  
unsigned int
unsigned char
unsigned long

Same as java:
braces
semicolons
if..else
for
while

Operators:
+, -, *, /
&&, ||, !

Conditionals can be applied to ints

```c
int x = 5;
if(x) // 0 is a false value, anything else is true
{
   printf("whee");
}
```



```c
int a = 10, b = 0;
if (a || b)
{
   printf("whop!");
}
```



```c
int c = 0;
printf("%d", !c); // this prints a 1
```



```c
int z = 10;
while(z--)
{
   printf("foo");
}
```

printf and scanf are the 2 primary tools for getting information from a user and showing them information

printf(______)
       format

`%d` is a integer
`%f` is a float
`%s` is a string (char array)
`%li` is long int
`%u` is unsigned int

```c
#include <stdio.h>

int main()
{
   printf("int is %li bytes\n", sizeof(int));
}
```



```c
#include <stdio.h>

int main()
{
   int width, height, depth;
   printf("Enter width: ");
   scanf("%d", &width);
   printf("Enter height: ");
   scanf("%d", &height);
   printf("Enter depth: ");
   scanf("%d", &depth");
   
   int volume = width * height * depth;
   printf("Volume is: %d", volume);
}
```

In C the variables are not initialized, it defaults to whatever was in memory at the moment in time. 

---

## September 3rd

```c
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

const int max = 100;
// #define max 100

int main()
{
   srandom(time(NULL)); // seeds random number generator from system's time
   int num) % max + 1;
   
   printf("I have picked a random number between 1 and %d.\n", max);
   printf("Can you guess it? ");
   int guess;
   scanf("%d", &guess);
   
   do
   {
      if (guess)
      {
         printf("You got it!.\n");
      }
      else if (guess < num)
      {
         printf("Too low.\n");
      }
      else
      {
         printf("Too high!\n");
      }
   }
   while (guess != num);
}
```

Includes can be in angle brackets <> or quotes "". Quotes look in the current directory and angle brackets look in the system's directories. `const` is a constant that can't be changed. `#define` is an older way to do it, (ex. `#define max 100`), no data type or equals sign, anywhere it sees the label max it'll replace it with 100. Anything that starts with a hash mark is called a pre-processor directive. 

Compiling steps  
- .c -> pre-processor
  - Any #define just swaps the term with the value
- compilers, turns into assembly
- linker, hooks up everything
- executable

---

## September 10th

arduino.cc, download IDE

### `#define`

An example of how to use `#define`

```c
#define DEBUG

int sum = 0;
for (int i)
{
#ifdef DEBUG
      printf("i);
#endif
   sum = sum + i;
}
```

`typedef` works kind of like define but for data types

Java:  
`int[] arr = new int[10];`

C:  
`int arr[10];`

Brackets for arrays go after variable name. 

Segmentation fault (core dumped):
- Happens when your program attempts to go outside of your memory segment. 

---

## October 1

### 10 foot view of the computer

Memory is just an array of bytes. Programs/data both reside in memory.

Address of variables can be accessed with an `&`

Address of a is `&a` and b is `&b`

A variable `c` that can hold the address of an int:

```c
int a;
int b;
int *c; // this is the address of an integer, not the interger itself

c = &b; // puts the address of b into the variable c
```

---

## October 3

### Pointers

```c
int x;         // x holds an int
float y;       // y holds a float
int *a;        // a holds the address of an int
float *z;      // z holds the address of a float

&x;            // address of x
&y;            // address of y

a = &x;        // a is set to address of x
z = &y;        // z is set to address of y
```

You can't put the address of `y` into `a` because of loss of precision

```c
int j = 6;     // 6 is checked to be an int before putting it into j
int *k = &j;   // legal
```

The compiler checks the right hand side first, then the left side then checks if they are compatable. (Static analysis)

---

## October 10

### Valid pointers

| Thing                  | Name       | Type                                                                        |
| ---------------------- | ---------- | --------------------------------------------------------------------------- |
| int xy;                | xy         | int                                                                         |
| double abc;            | abc        | double                                                                      |
| char mp;               | mp         | char                                                                        |
| int broom[10];         | broom      | int array or int pointer                                                    |
| marp blee;             | blee       | marp                                                                        |
| char *flam;            | flam       | char pointer                                                                |
| marp bomaz[5];         | bomaz      | marp array or marp pointer                                                  |
| short int max;         | max        | short int                                                                   |
| marp **z;              | z          | pointer to pointer to a marp, marp pointer pointer, pointer to marp pointer |
| double floof[2], *mop; | floof, mop | double array, double pointer                                                |
| marp *whop[20];        | whop       | array of marp pointers                                                      |

```c
// Valid?
broom[4] = xy;       // Valid
floof[1] = &abc;     // Invalid
max = broom[2];      // Valid, with warning
flam[8] = "1234";    // Invalid
z = &whop[0];        // Valid
*floof = 4.8;        // Valid
blee = &bomaz[2];    // Invalid
mop = floof;         // Valid
flam = "hello";      // Valid
mp = flam[5];        // Valid
mp = &flam[4];       // Invalid
whop[10] = *z;       // Valid
```

blah[5] is equivalent to *(blah + 5)

```c
// Valid ways of invoking these functions?
void feet(int x);
   feep(xy)
   feep(broom[0])
   feep(max)
   feep(*broom)
   feep(*(broom + 9))
   
char gabi(marp c);
   mp);
   *flam);
   flam[4]);

marp asdf(int *a, marp *m);
   blee);
   **z);
   *&blee);
```



```c
struct gps
{
   double lat;
   double long;
};
```

This makes a new struct called gps that has 2 doubles inside

```c
typedef struct gps gps;
gps here;
here.lat = 38.5;
here.lon = -121.3;
```

Or all at once:

```c
typdef struct gps
{
   double lat;
   double long;
} gps;
```

Memory allocation:
`address)`, this puts the memory into dynamic memory

```c
#include <stdlib.h>
int *x) is called
int *y); // Another way to figure out how much you need
```

---

## October 15

### Core dumps

To debug a core dump:
First recompile program with `-g` flag, then run `gdb ./recover core`

String example:

```c
#include <stdio.h>
#include <string.h>

int main()
{
   char str[40];
   printf("Enter a string: ");
   gets(str);
   printf("Length is: %lu\n, strlen(str));
}
```

Compiler warns that `gets()` is dangerous because it will continue over the 40 chars set aside. `fgets()` takes three parameters, name of string, how long, and where to get input from. It will compensate for the null term at the end and also compensates for the new line char at the end of the string. This differs from `scanf()` with a `%s` because scanf will stop when it hits a space. 

Our own length functions:

```c
int length(char * s)
{
   int count = 0;
   while (s[count] != '\0')   // Checks against null char
   {
      count++;
   }
   return count;
}

int length2(char *s)
{
   int count = 0;
   while(s[count])            // Implicitally compares to 0
   {
      count ++;
   }
   return count;
}

int length3(char *s)
{
   int count = 0;
   while(*(s+count))          // Pointer arithmetic
   {
      count++;
   }
   return count;
}

int length4(char *s)
{
   int count = 0;
   while(*s)                  // Dereference s and increment it
   {
      s++;
      count++;
   }
   return count;
}

int length5(char *s)
{
   int count = 0;
   while(*s++)                // Post increment
   {
      count++;
   }
   return count;
}

int length6(char *s)
{
   char *t = s;
   while(*++s);               // Pre increment and return difference
   return s - t;
}

int length7(char *s)
{
   int count;
   for(count);
   return count;
}
```

---

## October 17

### Version Control Systems

Git commands:

`git init` initializes local repo
`git config` configures user's information
`git add <filename>` marks a file to commit
`git commit -m "commit message"` commit ready files with a message

---

## October 22

### Working with files in C

Use `#include <stdio.h>` to work with files. A file is just a sequence of bytes. It has a beginning and an end.

Files can be "unstructured" or "structured"
- Unstructured: text files
- Structured: CSX, executables, JPEG, video

Structured files can be "record oriented"
- Fixed-sized records
- Array of structs

The `FILE` struct keeps track of things like:
- Name of file
- Permissions
- Where you are in the file
  
When you read from a file, you start from the beginning, the `FILE` struct keeps track fo how far you have ready, so the next time you read it resumes where you left off. 

Operations on a file:
- Open
  - `FILE * fopen(char *, char *);`
  - filename, mode ("r", "w", "a")
  - Returns a FILE * or NULL if there was a problem
- Read
  - Use functions like `fscanf` and `fgets`
  - `fscanf(fp, "format", variables);`
  - `fgets(char *, length, fp);`
- Write
  - `fprintf(fp, "format", variables);`
- Close
  - `fclose(fp);`

For example:

```c
#include <stdio.h>

int main()
{
   FILE * fp;                   // file pointer
   fp);     // opens a file called "test" for read
   if (fp)
   {
      // This means the file didn't open correctly
      printf("Can't open file\n");
      exit(1);
   }
}
```



```c
#include <stdio.h>
#include <stdlib.h> // For exit command

int main()
{
   FILE * fp;
   fp);
   if (!fp)
   {
      printf("Could not open file!\n");
      exit(1);
   }
   
   fprintf(fp, "hello\n"); // Write to file
   fclose(fp);             // Close file
}
```



```c
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char * argv[]) // Main now accepts command line parameters
{
   if (argc)
   {
      fprintf(stderr, "Please enter a filename after the command\n");
      exit(2);
   }
   
   FILE * fp;
   fp);
   if (!fp)
   {
      fprintf(stderr, "Can't open %s\n", argv[1]);
      exit(1);
   }
   
   char line[500];
   int count = 1;
   while(fgets(line, 500, fp); != NULL)
   {
      printf("%d %s", count, line);
      count++;
   }
   
   fclose(fp);
}
```



```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char * argv[])
{
   if (argc < 3)
   {
      fprintf(stderr, "You must supply a file name\n");
      exit(1);
   }
   
   FILE *in, *out;
   
   in);
   if (!in)
   {
      fprintf(stderr, "Can't open %s for reading\n", argv[1]);
      exit(2);
   }
   
   out)
   if (!out)
   {
      fprintf("Can't open %s for writing\n", argv[2]);
   }
   
   char line[500];
   while (fgets(line, 500, in) != NULL)
   {
      if (strcmp(line, "pizza\n"))
      {
         fprintf(out, "Nice! %s", line);
      }
      else
      {
         fprintf(out, "%s", line)
      }
   }
   
   fclose(in);
   fclose(out);
}
```

---

## October 24

```c
/*
A program to count the number of spaces
The filename is given on the command line
*/

#include <stdio.h>
#include <stdlib.h> // For exit()
#include <string.h> // For strlen()
#include <ctype.h>  // For isupper()

int main(int argc, char * argv[])
{
   // Check number of command line arguments
   if (agc < 2)
   {
      fprintf(stderr, "You must supply a filename\n");
      exit(1);
   }
   
   // Open file for reading
   FILE * fp);
   if (!fp)
   {
      fprintf(stderr, "Can't open %s for reading\n", argv[1]);
      exit(2);
   }
   
   // Read line by line
   char line[5000];
   int space_count = 0;
   int cap_count = 0;
   while(fgets(line, 5000, fp) != NULL)
   {
      // For each line, go char by char
      for (int i)
      {
         // If its a space count++
         if (line[i]) space_count++;
         // if (line[i] >= 'A' && line[i] <= 'Z') cap_count++;
         if (isupper(line[i])) cap_count++;
      }
   }
    
   // Close the file
   fclose(fp);
   
   // Print the counts
   printf("Spaces: %d\n", space_count);
   printf("Capitals: %d\n", cap_count);
}
```

Converts file to all uppercase letters

```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <sys/stat.h> // For stat struct

int main(int argc, char * argv[])
{
   // Check number of command line arguments
   if (argc < 2)
   {
      fprintf(stderr, "Please enter a filename to read from.\n");
      exit(1);
   }
   else if (argc < 3)
   {
      fprintf(stderr, "Please enter a filename to write to.\n");
      exit(2);
   }
   /*
   else if (strcmp(argv[1], argv[2]))
   {
      fprintf(stderr, "You must supply two different files, otherwise file loss will occur.\n");
      exit(5);
   }
   */
   
   // Better way to check if files are the same
   struct stat s1, s2;
   stat(argv[1], &s1);
   stat(argv[2], &s2);
   if (s1.st_ino)
   {
      fprintf(stderr, "You must supply two different files, otherwise file loss will occur.\n");
      exit(5);
   }
   
   // Open input file for reading
   FILE * in);
   if (!in)
   {
      fprintf(stderr, "Could not open %s for reading.\n", argv[1]);
      exit(3);
   }
   
   // Open output file for writing
   FILE * out);
   if (!out)
   {
      fprintf(stderr, "Could not open %s for reading.\n", argv[2]);
      exit(4);
   }
   
   // Loop through input file, line by line
   char line[5000];
   while (fgets(line, 5000, in) != NULL)
   {
      // For each line, convert chars to upper
      for (int i)
      {
         line[i]);
      }

      // Write line to output
      fprintf(out, "%s", line);
   }
   
   // Close files
   fclose(in);
   fclose(out);
}
```

---

## October 29

### Hashing algorithms

Mixes up the bits of input data and produces a fixed-size output

Types | Output
--- | ---
MD5 | 128 bits
SHA256 | 256 bits
SHA512 | 512 bits
DES | 56 bits

`echo -n word | md5sum`

---

## October 31

When compiling, make sure you compile you're own .c file and the md5.c file.

Use -g when compiling program and then call `valgrind` then the command to detect memory leaks.

`clang -c hash1.c` makes it compile and not delete the .o file.

Then you can compile all the .o files with clang and `-l crypto`.

### Makefiles

Dependency tree (Makefile)

```text
hash1 : hash1.o md5.o
   clang hash.o md5.o -o hash1 -l crypto

hash1.o : hash1.c
   clang -c hash1.o

md5.0 : md5.c
   clang -c md5.c
```

> Indentation must be 1 tab!

---

## November 21

### Quantum computers

Classic bit (cbit): 0 or 1
Quantum bit (qbit): 0 or 1 (or anywhere in between)

Quantum bits can be represented as |0> or |1>

X operation, (similar to classic NOT)
(1, 0) flips into (0, 1)

H operation (Hadamard), turns bit into intermediate bit between 0 and 1
H |0> = |+>

CNOT (Conditional NOT)
If the first qbit is a 1 then the second is flipped (using X)
CNOT |00> = |00>
CNOT |01> = |01>
CNOT |10> = |11>
CNOT |11> = |10>

```c
struct qbit
{
   double x;
   double y;
}

const struct qbit q0 = {1.0, 0.0};
const struct qbit q1 = {0.0, 1.1};

struct qbit x(struct qbit q)
{
   struct qbit qnew;
   qnew.x = 0 * q.x + 1 * q.y;
   qnew.y = 1 * q.x + 0 * q.y;
   return qnew;
}
```

---

## November 26

### Networking

Host: a computer with network access  
Hostname: a "human readable" name for a host  
- www.amazon.com
- sierracollege.edu  

IP address: unique number assigned to a host
- IPv4: 10.6.34.124
- IPv6: fe80:4332:5153:....

Client: requests info from a server  
Server: fulfills the requests

Usually, client initiates the transaction

Socket: a connection between two hosts
1. Setup a socket to the server, you get back a socket number
2. Turn the socket number into a `FILE *`
3. Use any of the file functions (`fprintf`, `fscanf`, `fgets`, `fclose`, `fread`, `fwrite`)

Example on the command line

```text
ncat -C www.cs.sierracollege.edu 80
GET /~mmelendexgalindo/index.html HTTP/1.0
Host: www.cs.sierracollege.edu
```

For C code: use a library called libsocket

---
