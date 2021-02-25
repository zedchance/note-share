---
title: "CS26-lecture-notes"
tags: ["discrete structures", "python"]
---

# CS 26 Lecture Notes

## Jan 28, 2019
### Introduction

Discrete: Not "discreet", opposite of continuous, goes in steps. The graphs we worked with can only be expanded in steps, you can't add a half edge or half vertex.

Structure: a set of related values and the operations on them. (integers, graphs).

Like a venn diagram of math and computer science, discrete structures is the combination.

---
## Jan 30, 2019
### Binary Numbers

Spending method:
89 can be converted to decimal by "buying" the most expensive thing you can from the powers of two.

Repeated division:
89 can be repeatedly divided by 2. the remainders in reverse order will be the binary number.

Hexadecimal - Base 16
Using higher bases means you can pack more information into a smaller space.

Base 32 uses 1..9A..V
Can be easily converted from binary by using groups of 5 bits.

Base 64 uses 1..9A..Za..z+/
Can be easily converted from binary by using groups of 6 bits. Starts from the beginning of the file, grouping into 6 bits then padded with an equals sign (=) for each 2 bits left over.

All data is just numbers. How you "chunk it up" is just a way of representation the information.

---
## Feb 4, 2019
### Signed Integers

- 2's complement
  - In 2's complement subtracting and addition are the same operation.
  - To subtract, add the negative version of the number. The result will be in 2's complement, which needs context to be understood.
  - Without context, there is no way to know which.
  - The CPU does not know (and doesn't care) whether we are using unsigned or 2s complement numbers.
- Sign-magnitude
  - MSB is the sign bit, 1 means negative, 0 means positive.
- Excess-n or Excess-k
  - Splits the numbers in but not in half. It is shifted down to accomodate however many negative numbers you need.

Pros
- Signed magnitude
  - Easy for humans
  - Symmetric range
  - LSB shows even/odd
  - MSB is pos/neg
- 2s Complement
  - Easy arithmetic
  - LSB is even/odd
  - MSB is pos/neg
- Excess-n
  - Easy negation (add or subtract)
  - Definable range

Cons
- Signed magnitude
  - Two zeros
  - difficult for computers
- 2s complement
  - Negation more difficult (than signed magnitude)
- Excess-n

---
## Feb 6, 2019
### Non-integral numbers

`110.101` = 6.625

The places to the right of the radix are still powers of 2 (negative powers)

Certain numbers cannot be broken down into base 2 (for instance 7.6, .6 cannot be broken down into powers of 2). When sending floating point numbers, the radix point cannot be shown in 1s and 0s. You can agree on where the radix point will go before hand, which is called fixed-point.

### Fixed point
`___.___`, the radix point isn't sent along, its just agreed upon where it will be. `0b1101 1100` would turn into 1101.1100)

### Floating point

IEEE-754 is the standard for floating point numbers. Floating point numbers is essentially scientific notation but in binary.

$-6.521 x 10^27$

The three parts you need to pay attention to are the sign, the mantissa (the number after the sign) and the exponent. Numbers must be normalized ($.0314).

Modified IEEE-754 (8 bits):
Trade off between precision and range. Will use 1 bit for the sign (MSB), 4 bits for exponent, and 3 for mantissa.

`_ _ _ _ _ _ _ _`

Sign
- 0 is pos
- 1 is neg

Exponent
- Represented in excess-n

Mantissa
- Fractional binary

The leftmost digit after normalized is always a 1, so that can be ommited when transfering to a floating point number. IEEE-754 says if you are using 4 bits for exponent, you should use excess-7. To find the number of bits to shift by you should use $n = 2^{b-1} - 1$ where $b$ is the number of bits used to express the exponent.

Range of values
- Smallest positive value (in our modified 8 bit version, in the real version it says if all bits are 0 then the number is 0)
  - `0b0000 0000` = $1.000 x 2^-7$ = $1/128$
- Largest positive value
  - `0b0111 1111` = $1.111 x 2^8$ = $480$
- Next largest
  - `0b1111 1110` = $1.110 x 2^8$ = $448$


---
## Feb 11, 2019
### Gates and Logic
74163 - 4 bit counter
74138 - 3 to 8 bit decoder
7400 - NAND

These chips can be mounted on PCBs to make a computer.

Two circuits/expressions are equivalent if they have the same truth tables.

NAND is a universal gate, meaning you can make any other gate out of just NANDs.

---
## Feb 13, 2019
### Boolean Logic

Boolean expressions are equivalent if they have the same truth table. To flip the output of a truth table over, not the result.

---
## Feb 20, 2019
### Karnaugh Maps

How to:
1. Get expression into SoP (Sum of products) or DNF (Disjunctive normal form)
2. Make grid, label axes, use grade code to fill out any multiple variable columns
3. Dot boxes for each term
4. Circle adjacent dots
   1. As big as possible
   2. Dimensions of circle must be powers of 2
   3. As few circles as possible to cover all dots
   4. Overlap circles in order to make them as big as possible
5. Each circle is a term in the minimized expression

### Lab 3: Satisfiability

pseudo:

```text
for x from 0 to 1
   for y from 0 to 1
      for x from 0 to 1
         if x == 0 or y == 1 and z == 1 or y == 0
            print x, y, z
```

---
## Feb 27, 2019
### Modular Arithmetic and Cryptography

Overview
- Shift cipher (Caesar)
- Linear cipher
- Vigenere cipher
- Hasing and passwords
- Symmetric key crypto
- Public key crypto

Encoding is just transforming from one form to another. There isn't any secret information, you just need to know what algorithm is being used. Cryptography uses encoding with some secret information to make the algorithm harder to decode.

**Modular arithmetic**

>18 + 35 mod 7 = 18
>18 + 35 (mod 7) = 4

These expressions are not the same. The first expression the mod is only applying to the 35, whereas the second expression mods the entire sum of whats on the left before mod. **Congruent numbers** are numbers that land on the same spot in the mod circle.

**Remainder vs modulo**

Remainders can be negative, and modulos is always positive.

**Arithmetic properties**

Sum
>123456 + 7891011 (mod 79))
>(a + b) mod n)

To do this on the normal calculator, divide the numbers, minus the quotient, then multiply by the mod number.

Multiplication
>Multiplication

Exponents
>456^789 mod 79 = 58
>(456 mod 79)^789 = 58

You can mod the base but not the exponent!

**Preview of RSA**
- Plaintext
  - the message you want to encrypt
- Ciphertext
  - the encrypted message
  - This is basically the $c = p^{e} mod n$
    - c = cihper text
    - p = plain text
    - e)
    - n > p (n can be as big as 400 digits long)

>(40 digits)^(200 digits) mod (400 digits)

>17^123 (mod 19)  = 17^100 * 17^23 = 17^50 * 17^50 * 17^23

---
## Mar 4, 2019

### Test 1
- Opens Friday 8a, closes Mon 8a
- You have 3 hours to finish once you start
  - Most people need about 1 hour
- Covers
  - Binary
  - Signed integers
  - Gates and circuits
  - Boolean logic
  - K-maps
  - Floating-point
- Work on seperate sheet of paper. Turn in paper next class to get partial credit for problems.

### Linear cipher

Formula
- c)
  - n is size of alphabet
  - c is cipher text
  - p is plaintext
  - m is multiplier

In python:

```python
linear(p, m, k):
   return (p * m + k) % n
```

The process looks like this, using m = 5 and k = 7

```text
C  A  T       plaintext
02 00 19      coded
17 07 102     multiplied and shifted
17 07 24      mod 26
R  H  Y       ciphertext
```

To decipher
- Must know m and k, and reverse the process

What makes good numbers for m and k?
- m should be greater then 0 and less than n
  - If you multiply by anything over n it is the same as multiplying as numbers that are less then n. Multiplying by n is the same as multiplying by 0
- k should be greater than or equal to 0 and less than n
  - Anything below 0 or above n is no point
- **m and n should have no common factors!** (coprime, or relatively prime) This creates non-1:1 mappings!

An example in python, using m = 22 and k = 24:

```python
for p in range(0, 26):
   c) % 26
   print(p, c)
```

This pattern creates repeating numbers that don't map 1:1 anymore with numbers, so it isn't a good choice for a multiplier and shift.

**Field**
- A set of values on which the following operations are defined:
  - Addition
  - Multiplication
  - Additive inverse
  - Multiplicative inverse

**Euler's Totient Function**
- How many numbers less the number are coprimes of the number.
- Properties
  - If n is prime
    - then φ(n) = n-1
  - If n = a * b, a and b are coprime and a ≠ b
    - then φ(n))
  - If n)
    - then φ(n))

**Euler's Theorem**
- a^φ(n)), if a and n are coprime

---
## Mar 6, 2019
### Greatest Common Divisor

gcd(15, 21) = 3
gcd(90, 60) = 30

**Euclidean Algorithm**
- gcd(a, 0) = a
- gcd(a, b))

Example:
gcd(90, 60)) = 30

gcd(15, 270)) = 15

In a python function:

```python
def gcd(a, b):
   if b == 0:
      return a
   else:
      return gcd(b, a % b)
```

**Extended Euclidean Algorithm**
- ax + by)
  - You give it a and b, it returns x and y

Try:  
a = 60  
b = 90  

60x + 90y)  
60x + 90y = 30  
2x + 3y = 1  
x = -1, y = 1  
x = 2, y = -1  
x = 5, y = -3  

egcd(15, 21)  
15x + 21y)  
15x + 21 y = 3  
5x + 7y = 1  
x = 3, y = -2  
x = -4, y = 3  

egcd(15, 26)  
15x + 26 y)  
15x + 26y = 1  
x = 7, y = -4  
15 * 7 (mod 26) = 1  
**x is the multiplicative inverse of a mod b**

### Lab 5
Linear cipher
- To encrypt:
  - `c = pm + k % n`
- To decrypt
  - `c) m^-1 % n`
    - `m^-1 % n` is the multiplicative inverse

To calculate multiplicative inverse use the Extended Euclidean Algorithm
egcd(a, 0))

egcd(a, b))
- q equals to `a//b`
- r equals `a mod b`
- (s, t))

In python:

```python
def egcd(a, b):
   if b == 0:
      return (1, 0)
   else:
      q = a // b
      r = a % b
      (s, t))
      return (t, s - q * t)
```

---
## Mar 11, 2019
### Pseudo Random Number Generator (PRNG)

In 1946, Von Neumann proposed a random number generator:
- Start with a 4 digit number
- Square it
- Extract the middle 4 digits
- Use this pseudo random number as the seed for the next

The PRNG gets a seed as input, which is then put through a calculation, and the output is your pseudo random number. The output can then be used as a seed for the next random number.

```python
def vn(seed);
   sq = seed * seed
   # divide by 100 using integer division to remove the rightmost 2 digits, then mod by 10k to keep the rightmost 4 digits
   rnd = sq // 100 % 10000
   return rnd

s = 4321
for i in range(100):
   r)
   print(r)
   s = r
```

### Linear Congruential Generators (LCG)
The formula: rand)

Just like our linear cipher, the multiplier and mod number must be **coprime**. N is the length of the cycle. Any seed you pick will be one of the values in the cycle. This is useful for debugging programs that use a random number generator to see if they are working before letting them loose with random seeds. Inside the computer at a random place in memory, the OS keeps whats called a "Pool of entropy", which stores random bits to be used as starting points for random seeds, this is replenished by random events such as network activity times or times between keypresses etc.

Concerning domain and range:
- If every value in the domain has a 1:1 value in the range, this is called bijection (good for crypto).
- If If every value has a many:1 value in the range, this is called a surjection (not good for crypto). This can't be reversed (its a one way function)

### Checksums
A small number calculated from data being sent that is used to verify the integrity of the data. Designed to be very fast to compute, can catch common problems, not to be used for encryption though.

Luhn algorithm:

```text
4539 7043 5470 6391        double every other digit
                           insert other digits
                           sum up all the resulting single digits
```

If sum is multiple of 10, it's good!
This is designed to catch common data entry errors.
- Transposing adjacent digits
- Mistyping one digit

### Hash
A checksum that is much harder to compute, and used to verify the integrity of a file
| Hash       | Bits     |
| ---------- | -------- |
| MD5        | 128 bits |
| SHA256     | 256 bits |
| SHA512     | 512 bits |
| RipeMD-160 | 160 bits |

These hash values has the same idea as a checksum, but are much bigger. This can be analogous with a coffee grinder. The grinder grinds up a bunch of beans, then a scoop is taken out (the hash). These can't be reversed because only a portion of the "beans" were used as the hash. If working with a huge file (a bucket of beans), a scoop is taken, grinded, then a scoop of that is taken and added to another scoop of beans, where the process repeats. This gives an even representation of the file.

Bash:

```sh
echo -n "Hello" | md5
echo -n "Hola" | md5
```

These hashs work in a chain, and use the last "scoop" in the next so that the entire data structure is represented. The domain is almost infinity, and the range is 2^ number of bits in hash. The chances of 2 documents having the same checksum is 1 in 2^b where b is the number of bits

---
## Mar 13, 2019
### More hashing
- MD5
  - Message digest version 5
- SHA256
  - Secure hashing algorithm
- SHA512
- RipeMD-160

How many possible n-char passwords?
- 8 character password (only letters)
  - 52^8 = 5.3e13
- 8 character with numbers
  - 62^8 = 2.2e14
- 9 character only letters
  - 52^9 = 2.7e15

What makes a good hashing algorithm?
- Should be computationally expensive, but not too expensive
  - MD5 used to be considered a good hash, now it is too easy (fast)
- Outputs should be evenly distributed
  - Think plotting the on a histogram
- Easy to go one way, hard to go the other
- Pre-image resistance
  - For a given hash (h) it should be hard to guess the original message (m), such that hash(m) = h
- Second pre-image resistance
  - For a given message (m1), it's hard to find another message (m2), such that hash(m1))
- Collision resistance
  - Hard to find two messages (m1, m2) such that hash(m1))

---
## Mar 18, 2019
### Symmetric vs. Asymmetric encryption

**Symmetric:**
- Both parties share a secret key
- Faster then asymmetric

Alice and Bob want to communicate, Eve is the eavesdropper. How do Alice and Bob keep Eve from obtaining the key?

**Public Key Cryptosystems (asymmetric)**:
- This solves the "key-exchange" problem.

### RSA
R: Rivesst  
S: Shamir  
A: Adelman

1. Pick two primes p & q
   1. p = 13, q = 47
2. Calculate n)
   1.  n = 611
3.  Calculate totient(n)
    1.  totient(611)) = 552
4.  Find e, such that 1 < e < totient(n) and e & totient(n) are coprime
    1.  These can easily be found using our gcd() function
    2.  271
5.  Find d such that e is the multiplicative inverse of e and totient(n)
    1.  e * d)
    2.  271 * d mod 552 = 1
    3.  d = 55
6.  Throw away p, q, and totient(n)!

3 Ways to find multiplicative inverse
- Loop
- Extended GCD
- Euler's Theorem

RSA Formulas:
- c = p^e mod n
- p = c^d mod n

(e, n) is one key  
(d, n) is another key, you choose which you want to keep private

For communication:
- Alice and bob want to communicate
- They both independently go through the RSA calculations
- Alice's
  - public key Apub)
  - private key Apriv (da, na)
- Bob's
  - public key Bpub)
  - private key Bpriv)
- Alice wants to send Bob a message such that only Bob can read it.
  - A: plain -> Bpub -> cipher
  - B: cipher -> Bpriv -> plain

Let's try:

```text
Hi!            Alice's message
H i !
72 105 33      Ascii values
               Using Bob's public key Alice can encrypt
474 248 266    e = 271, n = 611

72 105 33      Bob uses his private key to decrypt
               d = 55, n = 611
```

How can Eve decrypt the message?
- Eve has
  - both public keys
    - Composed of 2 pieces (e and n)
  - ciphertext
  - Eve needs d to decrypt
    - However to calculate the totient of n Eve will need to factor n (it is composed of 2 large prime factors)
    - She needs to factor n into p and q
    - This is a hard problem

>Quantum computers have Shor's Algorithm that can factor a number quickly

---
## Apr 20, 2019
### Communicating using public-private key cryptography

Alice and Bob both generate independent sets of keys.
- Alice
  - Apub
  - Apriv
- Bob
  - Bpub
  - Bpriv

**Alice wants to send Bob a message so that only Bob can read it.**
- She needs to run her plaintext thru Bob's public key to obtain ciphertext.
- A: p -> Bpub -> c
- B: c -> Bpriv -> p
- This gives us security

**Alice wants to send Bob a message such that Bob knows it came from Alice:**
- A: p -> Apriv -> cipher
- B: c -> Apub -> plain
- This gives us authenticity

Combining these gives both authenticity and security
- A: p -> Apriv  -> Bpub -> cipher
- B: c -> Bpriv -> Apub -> plain
- This order matters! Otherwise Eve can unlock the outter "box" with Alice's public key

**Alice wants to send a message to Bob such that:**
- Alice is the sender (authenticity)
- Bob is the recipient (security)
- Message has not been tampered with (integrity)
- A: p -> hash -> h
  - p + h -> Apriv -> Bpub -> cipher
- B: c -> Bpriv -> Apub -> p + h
  - p -> hash -> h
  - Compares hashes
- This is called "signing" a document (computing hash, then locking with private key)

How do Alice and Bob know the public-keys are authentic?
- Public keys are embedded in a digital certificate

How can Eve decrypt the message?
- Eve knows Apub, Bpub, and ciphertext
- Both public keys are split into
  - e
  - n
- Eve needs d to decrypt e * d)
- To calculate phi Eve must factor into p and q, this is very hard

### The Real RSA
OpenSSL

```sh
openssl genrsa -out keyfile.pem 2048
openssl rsa -in keyfile.pem -pubout -out key.pub
more key.pub
openssl rsa -in keyfile.pem 

vi plaintext.txt
openssl rsautl -pubin -inkey key.pub -endcrypt -in plaintext.txt -out ciphertext.txt
```

---
## Apr 3, 2019
### Spam filtering

To a spam filter: a message is just a set of words. 
- "Hello I will say Hello"

The filter splits the words up and compiles some information about them. It creates a dictionary. 
| Word  | Occurences |
| ----- | ---------- |
| Hello | 2          |
| I     | 1          |
| will  | 1          |
| say   | 1          |

P("Hello") = 2/5  
P("will") = 1/5  
P("today") = 0

---
## Apr 10, 2019
### Graphs

Planar graph: any graph that can be drawn on flat paper without crossing edges

The graph coloring problem: also known as the cartographers problem. To find the minimum number of colors needed to color a map. Its proven to be no more then 4, but finding the minimum is known as a "intractable problem". 

A lot of problems can be turned into graph problems.
- Shortest path
- Spanning tree
  - Connecting cable to a housing development using the least cable possible
- Travelling salesmen CEO
  - Minimize a metric on a graph (cheapest, shortest, time-spent...)

Terminology
- Vertex
  - point on the graph
- Edge
  - Normal
    - Connects 2 vertex
  - Directed edge
    - Edge that goes one way
  - Weighted edge
    - Has a value associated with the edge (cost, distance...)
- Fully connected graph
  - Each vertice is connected to each other
- Disconnected graph
  - Not all vertices are connected to each other

### Trees
- A graph built down from a root with leaves
- Interior nodes are vertices that aren't leaves
- Depth-first traversal
  - Search as deep as possible before exploring another branch
  - Pre-order depth first traversal
    - As soon as you encounter a node, you record it (think binary search tree)
  - Post-order depth first traversal
    - As you encounter a vertex, you record it the **second** time you encounter it
    - Could be used to turn high-level language into assembly
    - This puts the operation in postfix!
  - In order depth first traversal
    - This puts the operation back to how it was
    - This could be used to turn a high-level language into another high-level language (java <-> c)
- Breadth-first travesal
  - Search all neighbors before going deeper

---
## Apr 22, 2019
### Minimal spanning tree

How to

1. Initialize the set of visited vertices with any vertext from the graph. Iniialize the set of unvisited vertices to be all but the starting vertex
2. Consider each of the unvisited neighbors of the bisited set. Identify the neighbor with the lowest edge weight
3. Add the neighbors to the visited set. Remove it from the unvisited set. 
4. If the unvisited set is empty, we are done. Otherwise go back to step 2.

Greedy algorithm: Looks at the information it has at the moment, doesn't look ahead. 

- Make a decision based on information you have and no more. 
- Make best decision and don't change your mind.

---
## Apr 24, 2019
### Finite State Machine

There is a **starting** or **initial state** and one or more **accepting states**. Vertices are **states**, and edges are **transitions**. **Strings** describe pathes along the machine, and there are an infinte number of strings because of the looping nature of them. The set of all accepting strings is a **language**.

### How a program gets compiled

Scanning

- Goes thru program and finds and identifies tokens

---
## Apr 29, 2019

### Compilers continued

```text
grammar blub;

program: (assignment | print)* ;

assignment: IDENT ASSIGNOP expr SEMICOLON ;

expr: expr ('*'|'/') expr | expr ('+'|'-') expr | IDENT | INT ;

print: 'print' expr SEMICOLON ;

IDENT: ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
ASSIGNOP: '=' ;
SEMICOLON: ';' ;

INT: ('+'|'-'|'0'..'9')('0'-'9')* ;

WS: (' '|'\n'|'\r'|'\t') -> skip ;
```

---
## May 1, 2019

### State machines cont.

Deterministic state automaton

- Where each state only has one choice, no ambiguous choices.

Non-deterministic state automaton

- State machines that have multiple choices for each state (for example one state could have multiple routes labeled 'x')
- All NFAs can be converted to an equiavlent DFA

---
## May 6, 2019
### NFA with epsilon transition

The epsilon transition is basically like a free door that doesn't consume any letters. 

Thompson's constructions are a general (generic) way of converting a regex to NFA without a lot of analysis.

---
## May 8, 2019

Transform Regex into DFA

1. Transform regex into NFA using Thompson's constructions
2. Transform into DFA
   1. Transform NFA into table
   2. Transform NFA table into DFA table

---
## May 13, 2019
### Mealy and Moore Machines
A state machine without a accepting state, it just outputs a stream.

Takes a input of a string and outputs another string. 

Moore machine is a "dual" of a Mealy machine. (This means you can turn a Mealy into a Moore and vice versa)

A Moore machine takes an input, but instead of the output on the transition, the states are the outputs. Moore machines always output something at the first state(the start). If this isn't what you want, the solution is to add an initial state that doesn't output anything. 

---
## May 15, 2019
### Data compression (text)

Text compression should be lossless, in that none of the information is actually able to be put back after compressed.

Huffman encoding

`THE CAT IN THE HAT CAME BACK`

Start by creating a dictinonary for all the letters

```text
T H E C A I N M B K _
4 3 3 3 4 1 1 1 1 1 6
```

Then order for frequency

```text
_ T A H E C I N M B K
6 4 4 3 3 3 1 1 1 1 1
```

Combine the 2 lowest items

```text
_6 T4 A4 H3 E3 C3 BK 2 N1 M1
_6 T4 A4 H3 E3 C3 NM2 BK2 I1
_6 T4 A4 H3 E3 C3 BKI3 NM2
_6 BKINM5 T4 A4 H3 E3 C3
EC6 _6 BKINM5 T4 A4 H3
AH7 EC6 _6 BKINM5 T4
BKINMT9 AH7 EC6 _6
EC_12 BKINMT9 AH7
BKINMTAH16 EC_12
BKINMTAHEC_28
```

Then build a tree out of the combinations of these and assign 0s and 1s to the branches to get the new bitcodes

---
## 
