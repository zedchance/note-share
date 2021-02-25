---
title: "CS39-lecture-notes"
tags: "assembly"
---

# CS 39 Lecture notes

## Aug 21, 2018

Using ARM assembly language

RISC - reduced instructions set computer

ARM is a British company that designs intellectual property, now owned by a japanese company (Softbank).

Last year there was 14 billion ARM chips produced

Software you need:  
Keil ARM MDK - software development kit for M-series microcontrollers  
www.keil.com  
(Windows only)

[X] ~~*Download Keil tool*~~ [2018-08-23]

---
## Aug 23, 2018

A diagram of almost everything
>World -> Sensors  
Sensors -> Signal conditioning  
Signal conditioning -> Analog to digital  
Analog to digital -> cpu  
cpu <-> memory  
cpu -> output  

Place value = ${base}^{position}$  
BYTE = **B**inar**Y TE**rm  
BIT = **B**inary dig**IT**

A byte is the **smallest addressable unit of space in memory**, typically 8 bits in microcomputers.

---
## Aug 28, 2018

Read numbers and codes  
Take numbers and codes quiz

ASCII (7-bit code, 0-127)  
Unicode (16 bit)

CPU Instruction Cycle

1. Fetch instruction
2. Decode the instruction
3. Execute
4. Repeat

Inside CPU lives the General Purpose Registers
Program Counter holes the next instruction to fetch

### MDK Instructions  
Put project in new folder  
Choose M0 Cortex chip  
Choose CMSIS core  
and Startup Code

```arm
        AREA |.text|, CODE, READONLY
        EXPORT __main
__main
        MOVS R0, #1
        MOVS R4, #3
        ADDS R7, R0, R4

done    B done

        END

```

A simple program that adds 2 numbers, in this case the numbers 1 and 3 are stored in `R0` and `R4`. Then it adds them and puts the result in `R7`​. To end the program and ensure it doesnt run through memory forever, you add a loop that calls back to itself, in this case `done`. Note that you must put an enter after the `END`.

Remember in µVision: Debug using the **simulator** under the magic wand icon.

---
## Aug 30, 2018

Part number for the chip we’re using - NUCLEO-L432KC

A directive is information for the tool itself. `AREA` is a directive, it doesn’t produce any machine code technically.

.s files are just text files, not until they are assembled (by a program) is it then turned into a .o file (object code). These .o files are machine code.

The memory map of our chip (32 bit machine) starts at `0x00000000` and goes to `0xFFFFFFFF`. In the low memory address is program memory (flash), 32kB. At `0x20000000`​ RAM begins, 8kB. I/O and peripheral devices are below the RAM, such as timer/counters and USB.

```arm
        AREA |.text|, CODE, READONLY
        EXPORT __main
__main
        ;Code goes here
    
done    B done

        END
    
```

`AREA |.text|` directive tells the code to go to the .text area. `CODE` means it is in the code segment of the file. `READONLY` means it lives in the memory.

`EXPORT`​ gives it an entry point to the label `__main`. A label is just a point of reference, a named memory location, labels turn into addresses. Labels go into lines that you need to refer to. `done` is the label of the loop to end it. `B` means unconditional branch, meaning you always go to this, never skip it. `END` means there is no more code to assemble, **it always needs a carriage return after**.

### Every line of assembly

`​label` *`mnemonic`* *`operands`*`;` *`comments`*
- label must be against the left side
- mnemonic is our instructions
- operands are the parameters of the mnemonic
- comments come after the semicolon

| Starting file |     |            |     | ending file          |
| ------------- | --- | ---------- | --- | -------------------- |
| `.s`          | ->  | assembler  | ->  | `.o` (startup files) |
| `.c`          | ->  | c compiler | ->  | `.o` (startup files) |
| `.s`          | ->  | assembler  | ->  | `.o` (our file)      |

All of those `.o` files are then put into a linker, which resolves external references. meaning it looks through all the .o modules and links the references. Generates the **core image** (the actual machine code file that has all the pieces assembled and put together). The core image is then burned into a chip, (or in our case simulated).

Example variables for arithmetic:  
>R0 : a  
R1 : b  
R2 : c  
R3 : d  
a + b - c + 3

```arm
        ADDS R0, R0, R1; adds a + b
        SUBS R0, R0, R2; (a + b) - c
        ADDS R0, #3; (a + b - c) + 3
```

---
## Sep 4, 2018

### Expression evaluation  
>R0 : a  
R1 : b  
R2 : c  
R3 : d  

To multiply a by 2, you can write `ADDS R0, R0, R0`

>a + b + c \* 2

```arm
        ADDS R2, R2, R2; multiply c by 2
        ADDS R0, R0, R1; adds a + b
        ADDS R0, R0, R2; adds (a + b) + (c * 2)
```

This is a code fragment. 

To write this as a complete program with:  
>a = 5  
b = 2  
c = 7  

```arm
        AREA |.text|, CODE, READONLY
        EXPORT __main
__main
        MOVS R0, #5; a
        MOVS R1, #2; b
        MOVS R2, #7; c

        ADDS R2, R2, R2; multiply c by 2
        ADDS R0, R0, R1; adds a + b
        ADDS R0, R0, R2; adds (a + b) + (c * 2)
    
        LDR R7,)
        STR R0, [R7]; store R0 in the location specified by R7
    
        LDR R4, [R7]; loads R4 with variable at 0x2000 000 in RAM
    
done    B done

        END
    
```

When you run out of registers, you can store variables in RAM (**RAM starts at 20 million hex (`0x2000 0000`)**). When storing something in RAM it takes 2 clock cycles. The chip we are using only supports indexed addressing. This means you need to specify the address you use to specify the address of the RAM (a pointer). Usually use `R6` and `R7`. `LDR` is used to specify registers in RAM. `STR` can be used to store it in RAM. To load back into a register you can use `LDR` also. RAM can only use the `LDR` and `STR` instructions, if you need to perform arithmetic on a stored variable, you need to load (`LDR`) it into register to work on it.

---
## Sep 6, 2018

`MOVS` moves data and updates the flags. `MOV` doesn’t update the flags. Instructions with the S update flags.

RAM space:
0x2000 0000 is the beginning of RAM space (32 bits wide)
0x2000 0004 is the next space

32 bits = word
16 bits = half-word
8 bits = byte

`LDR` and `STR` work with 32 bit numbers. On RISC machines you must use indexed addressing.

To use an offset:  
`LDR R5, [R7,#4]` uses an offset of 4 to point to the address at `0x2000 0004` (After specifying the address of the first slot in memory with `LDR R7,=0x20000000`​)

Example of C++ code to turn on and off LED and run a function called `myFunc`, which is defined in the `.s` file below

```c
//#include "mbed.h"

extern "C" int myFunc(int a, int b, int c); //a b and c correspond to registers R0, R1, R2 respectively

DigitalOut myled(LED1);

Serial pc(USBTX, USBRX);

int main()
{
  pc.printf("myFunc);
  pc.printf("myFunc);
  
  while(1) //"Heartbeat", this turns the LED on and off, a good way to see if the program is running
  {
    myled = 1; //LED is ON
    wait(2.0); //Wait 2 sec
    myled = 0; //LED is OFF
    wait(1.0); //Wait 1 sec
  }
}
```

In another `.s` file:

```arm
        AREA |.text|, CODE, READONLY
        EXPORT myFunc

myFunc
        ADDS R0, R0, R1; a + b
        ADDS R0, R0, R2; + c
    
        BX LR; branch exchange with link register (return)
    
        END
    
```

---
## Sep 11, 2018

### Shifting bits  
`LSLS` is a logical shift left. Multiplies by powers of 2. ($2 ^ {bits}$)  
`LSRS` is a logical shift right. Divides by powers of 2. ($2 ^ {bits}$)  
These commands use a barrel shifter, takes 1 clock cycle. (Takes a lot of hardware real estate though)

`LSLS` 1 bit shift left example:
> 0101 = 5 decimal  
1010)

>0011 = 3 decimal  
0110 = 6 decimal  
1100 = 12 decimal

`LSLS R0, R0, #2` shifts the register `R0` by 2 to the left, then places the answer back into `R0`.
The bit that is shifted "off" the number is transferred into the carry bit. This makes the `LSLS` command really useful to shift numbers into the carry flag. If you wanted to print a binary number to the screen you could individually shift numbers into the carry flag, add 0x30 to it and get the ASCII code for 1 and 0.

`LSRS` 1 bit shift right example:
>1100 = 12 decimal  
0110 = 6 decimal

>0111 = 7 decimal  
0011)

`LSRS R3, R1, #4` effectively divides `R1` by 16 ($2^4$) and puts the answer in `R3`

Examples:
```arm
        LDR R0,=0x00000007 ; loads R0 with 7
        LSLS R0, R0, #2 ; logical shift left 2 bits, answers 0x0000001C (7 * 4)
```

```arm
        LDR R0,=0xC0000000 ; loads R0 with 0xC0000000
        LSRS R0, R0, #1 ; shifts to the right 1 bit, answers 0x60000000 (half of 0xC)
```

---
## Sep 18, 2018
### Logical instructions (bitwise)  
**AND gate:**  

| a     | b     | a `&&` b |
| :---: | :---: | :------: |
| 0     | 0     | 0        |
| 0     | 1     | 0        |
| 1     | 0     | 0        |
| 1     | 1     | 1        |

`ANDS R0, R1` is the biwise AND gate to compare two registers. Can be used to isolate a group or a single bits. Typically used to compare a value with a 'mask' value. 

```arm
        LDR R0, =0xABCDEFA5; input
        MOVS R1, 0xF; mask

        ANDS R0, R1
```

Returns `0x00000005` in the `R0` register. `ANDS` basically clears out all the unwanted bits specified by the register `R1`. (Remember 0xF is 1111 in binary, so the 5 gets passed through).

**OR gate:**  

| a     | b     | a `||` b |
| :---: | :---: | :------: |
| 0     | 0     | 0        |
| 0     | 1     | 1        |
| 1     | 0     | 1        |
| 1     | 1     | 1        |

`OR` turns a bit on if one or the other bit is on. 

```arm
        LDR R0, =0xABCDEFA5; input
        LDR R1, =0xF0000000; mask

        ANDS R0, R1; and

        MOVS R2, #3
        ORRS R0, R2; or
```
Returns `0xA0000003` in the `R0` register. Because the A was left in the register because of the `ANDS` and then turns on the 3 in the last bit because of the `ORRS`.

**To clear a bit `ANDS` it with 0  
To pass a bit `ANDS` it with a 1  
To set a bit `ORRS` it with a 1**

**NOT gate:**

| a     | `!`a  |
| :---: | :---: |
| 0     | 1     |
| 1     | 0     |

```arm
        LDR R1, 0xF0000000; mask
        MVNS R3,R1; not the R1 register
```
Returns `0x0FFFFFFF` into the `R3` register. `MVNS` is the NOT operator for this chip (move register and not).

**Excluse OR (EOR):**  

| a     | b     | a `EOR` b |
| :---: | :---: | :-------: |
| 0     | 0     | 0         |
| 0     | 1     | 1         |
| 1     | 0     | 1         |
| 1     | 1     | 0         |

One or the other, but not both.

```arm
        LDR R0, =0xABCDEFA5
        LDR R1, =0xA5A5A5A5; mask

        EORS R0, R1;
```
Returns `0x0E684A00`. Everything that matchs gets zeroed out. Running the `EORS R0, R1` command again will return the register to the original. **This can be used to encrypt.**

### C->asm  
Start using a `.c` file in microvision. 

```c
extern int myFunc(int a, int b, int c);

int main(void)
{
    int x;

    x);
}

```

`extern` means that the function exists in another block of code. Does need a semicolon after this method header because its connected to the `extern`. **This file also needs a carriage return after the last curly brace.**

In a `.s` file **(thats named differently then the `.c` file)**

```arm
        AREA |.text|,CODE,READONLY
        EXPORT myFunc
myFunc
        ADDS R0, R0, R1; add a + b
        SUBS R0, R0, R2; subtract c

        BX LR

        END

```

`BX LR` is the return. The variables in the `myFunc.c` will coorespond to the registers starting at `R0` onwards (a).

---
## Sep 20, 2018

### Embedded `C` Programming  

History  
Developed at Bell Labratories in the 70s. Dennis Ritchie and Ken Thompson developed this language. C was derived from the high-level assembly language B. **Major goal of C was systems programming.** The UNIX operating system was re-written in C. Today C is widespread use with a rich standard library of functions. C is the standard language of microcontrollers, this is because C generates small amounts of code compared to other languages (C++ for example). 

Why C?  
Flexible language that imposes few constraints on the programmer. Allows low level access to data, operating system, and hardware. Retains the portability and sophisticated syntax of a high-level language. Supports pointers and bitwise operators. Weak type checking (Good or bad?). Designed for modular programming (for example when we had a `.s` file and a `.c` file). Extensive use of libraries. The lingua franca of embedded systems programming. Not object-oriented, but can be used with an "object-oriented mindset". 

Simplest embedded program  

```c
int main()
{
    while(1);
}
```
This compiles sucessfully but doesn't do anything.

Slightly more useful program:
```c
//#include "mbed.h" (this line breaks the auto-toc)

Serial pc(USBTX, USBRX); //a little c++

int main()
{
    pc.printf("Hello world\n\r");
    while (1); //infinite loop
}
```

Some key elements of a C program:  
`;`
- The semicolon is a statement terminator (just like in Java)
- The simplest expression is a semicolon alone.

`{}`
- Curly braces delineate the beginning and end of a function
- Curly braces also group statements so they are treated as one block

`"text"`
- A string is delineated with double quotes

comments
- `//` or `/* */` are comment delimiters

Identifiers in C:  
- An identifier is a name of something in your prograrm
    - a function, variable, constant
- Identifiers begin with a letter or underscore (_)
    - Followed by a sequence of letters, digits, or underscores
    - Its not good practice to start a identifier with an underscore, because it is reserved identifiers generated by the compiler
- Identifiers are case sensitive
- Identifiers can be any length, *but*
    - some compilers recognize only a limited number of characters (usually 32 characters). This means if 2 identifiers use the same name up to 32 characters they will be treated as the same identifier, even if the characters after are different.
- Reserved words cannot be used as identifiers
    - What are some reserved words in C?
    - i.e. `auto`, `break`, `case`, `char`, `continue`, `default`, `extern`

Variables:  
Variables represent a value that can be changed. Variables are declared by indicating the type followed by an identifier.
```c
int dogs, cats;
unsigned char portInput;
float price;
```
Variables are stored in the relatively small RAM of the microcontroller. The programmer must declare the type, and therefore the size of each variable. 

Variable scope:  
The scope of a variable is its accessibility within the program.
- Local Variables
    - Declared within a function
    - Memory space is allocated when a function is entered
    - Generally, memory space is released when function exits (returns)
    - Can only be accessed from within the function they are declared
    - You can use the same local variable declarations in multiple functions since the compiler sees the local in functions independently
- Global variables
    - Can be accessed by all the functions in a program (unlimited scope)
    - Global variables can be modified by any function and will retain their value as long as the program is under execution

Constants:  
- Constants are fixed values
- In microcontroller programs, constants are usually stored in read-only memory
    - This saves RAM for variables
- Consider this assignment
    - `z = rho + 5;`
    - the five is a numeric constant and becomes part of the code that performs the addition.
- You can declare a named constant as follows:
    - `const` *`type`* *`identifier`* `=` *`expression`*`;`
    - i.e. `const int myIntConstant = 25;`
- Numeric constants can be declared with base or type
- Decimal is the default base
    - `1695`
- Binary constants begin with `0b` prefix
    - `0b01000001`
- Hexadecimal prefixed with `0x`
    - `0x1234ABCD`
- You can specify the type of a numeric constant with a suffix
    - `4000U`, U is for unsigned
    - `15.1F`, F is for float
- Character constants are enclosed in single quotes
    - `'M'`

Operators and expressions:  
- Variables are assigned using the `=`
- A numeric expressions can be on the right side of the assignment operator


---
## Sep 25, 2018

### Compare  
`CMP` is the instruction that compares registers. `CMP R0, #5` compares register `R0` to the immediate 8 bit number `5`. It subtracts the register with the number, if the zero flag is turned on then it means that the comparison is "true", "set", or "logic level one". This is often used in conjunction with the branch conditional instruction, `Bcc` (pg. 34). 

```arm
        CMP R0, #5; checks if R0 is 5
        BEQ doStuff; BEQ means branch if equal, checks if the zero flag is 1
        ;code to skip here
doStuff
```

**`Bcc` Conditional Branch**  
| Specific Flag Tests | Meaning                   | Flags affected |
| ------------------- | ------------------------- | -------------- |
| `BEQ`               | Branch if equal           | `z == 1`       |
| `BNE`               | Branch if not equal       | `z == 0`       |
| `BCS`               | Branch if carry is set    | `c == 1`       |
| `BCC`               | Branch if carry is clear  | `c == 0`       |
| `BMI`               | Branch if minus, negative | `n == 1`       |
| `BPL`               | Branch if plus, positive  | `n == 0`       |
| `BVS`               | Branch if overflow        | `v == 1`       |
| `BVC`               | Branch if no overflow     | `v == 0`       |

| Unsigned/signed tests | Meaning                      | Flags affected     |
| --------------------- | ---------------------------- | ------------------ |
| `BEQ`                 | Branch if equal              | `z == 1`           |
| `BNE`                 | Branch if not equal          | `z == 0`           |
| `BHI`                 | Branch if higher             | `c == 1`, `z == 1` |
| `BLO`                 | Branch if lower              | `c == 0`           |
| `BHS`                 | Branch if higher or the same | `c == 1`           |
| `BLS`                 | Branch if lower or same      | `c == 0`, `z == 1` |

**if statement:**  
For example to translate:

```java
if (a)
{
  a = b + 2;
}
```

In assembly:
>a = `R0`  
b = `R1`

```arm
        CMP R0 #5; compares a to 5
        BNE endif1; branch if not equal, checks if zero flag is 0
        MOVS R1, R0; move b into a
        ADDS R0, #2; b + 2

endif1
```

Look at the relationship of the high level language and **make the opposite of the comparison**. 

**if..else:**  
Example:

```java
if (a != b)
{
  a = 5;
}
else //a == b
{
  a = 1;
}
```

In assembly:
>a = `R0`  
b = `R1`

```arm
        CMP R0, R1; a != b ?
        BEQ else1; branch if equal, checks if zero flag is 1

        MOVS R0, #5; a = 5

        B endif1

else1   
        MOVS R0, #1; a = 1

endif1
```

**Example with greater than:**  

```java
if (a > 5)
{
  b = a + 2;
}
```

In assembly:
>a = `R0`  
b = `R1`

```arm
        CMP R0 #5;
        BLS endif1; branch if lower or equal, checks if carry flag is 0 and zero flag is 1
        MOVS R1, R0
        ADDS R1, R1, #2

endif1
```

**One more if..else:**  

```java
if (a >= b)
{
    a = 0;
}
else
{
    a = 42;
}
```

In assembly:
>a = `R0`  
b = `R1`

```arm
        CMP R0, R1; a >= b
        BLO else1; branch if lower, (opposite of >=), checks if the carry flag is 0

        MOVS R0, #0
        B endif1

else1
        MOVS R0, #42

endif1
```

**While loop:**  

```java
count = 0;

while (count < 5)
{
    count++;
}
```

In assembly:
>count = `R4`

```arm
        MOVS R4, #0; initilize count
while1
        CMP R4, #5; compare R4 to 5
        BHS endwhile; unsigned higher or same, checks if carry flag is 1

        ADDS R4, #1; increment count

        B while1; B alone is unconditional branch

endwhile
```

### Calculating the length of a String  
In the first document `LE3C.c`, write a function called `slen(char s[])` that takes a char array (String) as the parameter, (slen is short for string length). Also initialize the char array (String), `myString[]` and the int `x`. Then in the `main()` method set the variable `x` to the length of the string `myString`. Both variables are stored in memory because they are global.

```c
extern int slen( char s[] ):

int x = 0;
char myString[] = "anything you want.";

int main()
{
  x);
}
```

Then in our `LE3asm.s` file, we write the assembly to do this:
>`R0` is location in memory of `myString`  
`R1` is char counter  
`R2` is current character

```arm
        AREA |.text|, CODE, READONLY
        EXPORT slen
slen
        MOVS R1, #0; char counter = 0

while1
        LDRB R2, [R0]; current character pointer
        CMP R2, #0; compare for null terminator
        BEQ endWhile
            ADDS R1,#1; increment counter
            ADDS R0,#1; advance pointer
        B while1	
endWhile	
        MOV R0,R1; put char count in return register
        
        BX LR; return

        END

```

The commands after the  `BEQ` check don't need to be indented (and wouldn't normally), but it helps to better visualize what is inside the loop.

### Capitalize first letter of string  
Add to our `LE3C.c` file add a `firstToUpper(char s[])` method that takes an array of chars (String) as parameter. Note we call that method before our `slen` method in the `main()`.

```c
extern int slen( char s[] );
extern void firstToUpper( char s[] );

int x = 0;
char myString[] = "anything you want.";

int main()
{
    firstToUpper( myString );
    
    x);
}

```

In `LE3asm.s` file, we must add another `EXPORT` at the top with our new function `firstToUpper`. Adding `firstToUpper` label down below the other code is perfectly legal. It must be added after the return (`BX LR`) of the `slen` function though. `firstToUpper` also needs it own new return (`BX LR`). Only one `END` with a carriage return is needed.

```arm
        AREA |.text|, CODE, READONLY
        EXPORT slen
        EXPORT firstToUpper
slen
        MOVS R1, #0; char counter = 0

while1
        LDRB R2, [R0]; current character pointer
        CMP R2, #0; compare for null terminator
        BEQ endWhile
            ADDS R1,#1; increment counter
            ADDS R0,#1; advance pointer
        B while1	
endWhile	
        MOV R0,R1; put char count in return register
        
        BX LR; return
;---------------------------------------------------

firstToUpper
        LDRB R1, [R0]; load first character from string into R1
        MOVS R2, #0xDF; mask to clear bit 5
        
        ANDS R1, R2; clear bit 5
        
        STRB R1, [R0]; put char back in string
        
        BX LR; return

        END

```

 `firstToUpper` starts by loading the first char (byte) into `R1` using the `LDRB` (load byte). We `MOVS` the hexadecimal number `0xDF` into `R2` to be used as a mask. This mask is `1101 1111` in binary. This allows us to use the `ANDS` with the mask to minus 32 bit (the 0) from the number (changing it from the ASCII code of the lowercase letter to the ASCII code of the uppercase, 97 - 65).

 | Decimal | Hexadecimal | Binary      | ASCII |
 | ------- | ----------- | ----------- | ----- |
 | 97      | 0x61        | 0b0110 0001 | a     |
 | 65      | 0x41        | 0b0100 0001 | A     |

>`0b01`**`1`**`0 0001` (`0x61`)  
`0b11`**`0`**`1 1111` (`0xDF` mask)  
AND  
`0b01`**`0`**`0 0001` (`0x41`)

---
## Sep 27, 2018  
Video lecture notes

### Memory Review
Loading a variable from RAM into a General Purpose Register  
1. Point at the memory location of the variable
2. Load the ariable from the pointer register location

```arm
LDR R7, =0x20000000; address of variable
LDR R0, [R7]; copy data addressed by R7 to R0
```

Storing a variable into RAM from a General Purpose Register  
1. Point at the memory location of the variable
2. Store the register value at the pointer register location

```arm
LDR R7, =0x20000000; address of variable
STR R0, [R7]; copy value in R0 to location addressed by [R7]
```

### More if..else patterns
if pattern:  

```java
if (a)
{
    b = 9;
}
```

In assembly: 

```arm
        CMP R0, #5; a == 5?
        BNE endif1; if a != 5 then branch
        LDR R7)
        MOVS R1, #9;
        STR R1, [R7]
endif1
```

if..else pattern:

```java
if (a)
{
    b = 9;
}
else
{
    b = 7;
}
```

In assembly:

```arm
        CMP R0, #5; a == 5?
        BNE else1; if a != 5 then skip if part
        LDR R7,)
        MOVS R1, #9; data to store in R1
        STR R1, [R7]
        B endif; skip the else
else1   
        LDR R7, =b
        MOVS R1, #7
        STR R1, [R7]
endif
```

Remember: **use the branch that is opposite the high-level operator**

Summary:
- Load variable before doing comparison
- Use the branch opposite of the relational operator after the comparison
    - This will skip the block if the Boolean expression is false
- Place an unconditional branch at the bottom of the if-true block in order to skip the else
    - The if-block and else-block are mutually exclusive

### mbed Compiler Notes
- Typically, no need to load variables before doing comparison
    - mbed compiler passes the first four parameters in `R0`-`R3`
    - The compiler will load the variables before calling your subprogram
- In the following function definition, `a` is passed in `R0`, `b` is passed in `R1` and so on...  
`extern "C" int my_asm(int a, int b, int c);`  
When you call the function in your C code as follows:  
`my_asm(25, x, y + 2);`  
The compiler will load `R0` with 25, `R1` with the value of the variable `x`, which was declared in the C code, and `R2` with the value of the C declared variable `y` plus 2.

The compiler generates code something like this:
```arm
        MOVS R0, #25; first parameter into R0
        LDR R7,)
        LDR R1, [R7]; second parameter, x, into R1
        LDR R7, =y; address of y into R7
        LDR R2, [R7]; third parameter y into R2
        ADDS R2, #2; add 2 to y

        BL my_asm; call your function
```

(`=x` and `=y` are placedholders for where it is in memory for the sake of these notes)

### ARM Architecture
Data sizes and instruction sets
- ARM is a RISC architecture
    - Most instructions execute in a single cycle, orthogonal register set, load-store architecture
- ARM is a 32-bit load-store architecture
    - The only memory accesses allowed are loads and stores (`LDR` and `STR`)
    - Most internal registers are 32-bits wide
- When used in relation to the ARM
    - *Word* means 32 bits (four bytes)
    - *Halfword* means 16 bits (two  bytes)
    - *Doubleword* means 64 bits (eight bytes)
- Most ARM cores implement two instruction sets
    - 32-bit ARM Instruction Set
    - 16/32-bit Thumb Instruction Set
- Older cores support 16-bit Thumb Instructions only
    - Thumb-2 technology in current cores adds 32-bit instructions
    - Maintains code density with increased flexibility

Processor Modes
- Most ARM cores have seven basic operating modes
    - Each mode has access to its own stack space and a different subset of registers
    - Some operations can only be carried out in a privileged mode

| Mode             | Description                                                               | Privileged |
| ---------------- | ------------------------------------------------------------------------- | ---------- |
| Supervisor (SVC) | Entered on reset and when a Supervisor call instruction (SVC) is executed | Yes        |
| FIQ              | Entered when a high priority (fast) interrupt is raised                   | Yes        |
| IRQ              | Entered when a normal priority interrupt is raised                        | Yes        |
| Abort            | Used to handle memory access violations                                   | Yes        |
| Undef            | Used to handle undefined instructions                                     | Yes        |
| System           | Privileged mode using the same registers as User mode                     | Yes        |
| User             | Mode under which most Applications/OS tasks run                           | No         |

(These are modes for ARM A and ARM R chips, ARM M chips have 2 modes: User and Handler)

In ARM M chips:
- 13 General purpose registers
    - Registers `R0` - `R7` (low registers)
    - Registers `R8` - `R12` (high registers)
- 3 Registers with special meaning/usage
    - Stack Pointer (SP) - `R13`
    - Link Register (LR) - `R14`
    - Program Counter (PC) - `R15`
- Special-purpose registers
    - xPSR is the program status register
        - Conditional code flags
            - N)
            - Z)
            - C)
            - V)

ARM Instruction Set
- All instructions are 32 bits long
- Most instructions can be conditionally executed
- Load/Store instruction set - no direction manipulation of memory contents

---
## Oct 2, 2018

- [X] ~~*Midterm on Oct 16*~~ [2018-10-16]
- [X] ~~*Make midterm notes*~~ [2018-10-16]  
(Ch. 1 - 5 LCARpi, number conversions, covers instructions we've used, and can use booklet and one 8.5x11 piece of paper for notes)

### Multi-word Arithmetic
Our registers are 32 bits long. The right most position is position 0 and the leftmost is position 31. 

Example:
>`R4` = `1111 1111 1111 1111 1111 1111 1111 1111`  

Adding 1 to this register will clear all the 1s into 0s and turn on the carry flag and the zero flag (effectively loosing the number).

To add larger numbers then  our register size ($2^{32}$ (32 bits)) you will need to use 2 registers at a time, one to specify the lower word and one the higher word.

To demonstrate this:
```arm
        LDR R4, =0xFFFFFFFF
        ADDS R4, #1
```

This clears `R4` and turns on the carry and the zero flags.

To successfully add numbers bigger then 32 bits you must specify a register as the low word and another as the high word. This is a symbolic specification, the registers don't actually get joined, just arithmetic on them can be performed on them individually and thought of them as being joined.

```arm
        LDR R4, =0xFFFFFFFF; low word 64 bit first var
        MOVS R5, #1; high word 64 bit first var

        MOVS R6, #1; low word 64 bit second var
        MOVS R7, #0; high word of 64 bit second var

        ADDS R6, R4, R6; add low words
        ADCS R7, R5; add high words and potential carry
```

`ADCS` is add with carry, takes 2 registers and the carry flag into consideration. To add the first and the second 64-bit variables you must add the low words (with `ADDS`) then the high words (with `ADCS`). 

### Two's Complement
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

`SXTB` instruction:

```arm
        LDR R7, =0x2000000F; load R7 with first address of RAM
        LDRB R0, [R7]; loads byte into R0
```

This returns all 1s in the low byte but 0s in the rest of the register. This means that the signed number (-1) isn't preserved. You must use a `SXTB` (sign extend) instruction which extends an 8 bit value to 32 bits and writes the result to the same register. Continuing from the above example, to preserve the signed number (-1):

```arm
        SXTB R0, R0; sign extend
```
Effectively changing `R0` from
>`0000 0000 0000 0000 0000 0000 0000 1111`  

To:
>`1111 1111 1111 1111 1111 1111 1111 1111`

(Preserving the -1)

### `ASRS` Arithmetic Shift Right
The `ASRS` instruction is like the `LSRS` (logical shift right) instruction, however instead of always injecting a 0 on the left, it injects the same bit as the most significant bit. This means that if the number is signed it preserves the negative. **Effectively this instruction divides by powers of 2 while preserving the sign.** 

---
## Oct 4, 2018

### Counting characters in a string
To count how many times a char occurs in a string:

pseudocode:
- point character pointer at first char in string
- while char isn't null
    - read ASCII of current character
    - if current character == searched char
        - increment count
    - increment char pointer

```c
extern int charCount(char s[], char c)

char myString[] = "aababac";
int x = 0;

int main
{
    x);
}
```

In assembly:
>`myString` will be stored in memory with register `R0` pointing at it. The character thats being searched for will be stored in `R1`

```arm
        AREA |.text|, CODE, READONLY
        EXPORT charCount
charcount
        MOVS R2, #0; initalize count
nextChar
        LDRB R3, [R0]; get character
        CMP R3,#0; end of string?
        BEQ endloop

        CMP R3, R1; is char == c?
        BNE nextIteration
        ADDS R2, #1; count++

nextIteration
        ADDS R0, #1; advance pointer
        B nextChar

endloop
        MOV R0, R2; put char count in return register
        BX LR
        END

```

---
## Oct 9, 2018

### Calculating arithmetic mean

Using a 64 cell array, we can calculate the arithmetic mean of the cells. We are concerned with how fast the mean can be calculated. This will be an array that is passed by some c code. 

In `statsC.c`: 

```c
extern int mean64(short data[]);

short myData[64];
int xbar;

int main()
{
    for(int i)
    {
        myData[i] = 8;
    }

    xbar);
}

```

`short` is a 16 bit data type, so we're working with half words in our registers.

In `statsAsm.s`:
>`R0` = address of array  
`R1` = sum of array elements  
`R2` = current array element  
`R3` = loop counter

```arm
        AREA |.text|, CODE, READONLY
        EXPORT mean64
mean64
        MOVS R1, #0;initialize sum
        MOVS R3, #64;initialize loop count

loop1   LDRH R2, [R0]; get current element
        ADDS R1, R1, R2; add element to sum
        ADDS R0, #2; advance pointer

        SUBS R3, #1; loop count - 1
        BNE loop1; branch if zero flag is on

        ASRS R1, #6; divide by 64 and preserve sign
        MOVS R0, R1; return result in R0

        BX LR
        END

```
**You must advance the for loop by 2 because we are working with half words.** 

Clock cycles:  
512 clock cycles in the loop alone. Clock speed of our chip is 48MHz. To figure out the period $1/f$, where $f$ is the frequency ($1/48MHz$, ~21 nanoseconds). 519 total clocks * 21 nano seconds = 10,899, ~11 micro seconds.

---
## Oct 11, 2018

### 10,000 foot view (software organization)
Problems and concerns when creating embedded systems. In real time systems the software has time dependencies. 

- Soft real time
    - Can miss deadlines, doesn't have an extreme consequence (games, game controllers)
- Hard real time
    - Cannot miss deadlines, if you miss a deadline whatever you were producing is now invalid. May have severe consequences in the system. 

Highly reliable software:  
Software that you don't want to fail. Usually real-time. (Autopilots, landing gear deployment, jet engine fuel controllers). A special way to write software. 

Software organization:
- Super loop
    - Actions are in a non-stop loop, never ending. (not used in Highly-reliable systems). Used more when timing isn't a concern
- Cyclic executive scheduling
    - A lightweight scheduling mechanism
    - A gold standard for highly reliable systems. 
    - Small scale projects (automotive industry, dashboard control)
    - No distinct scheduling mechanism, can be handled with interrupts
    - Used extensively in aerospace, avionics
    - Most real-time applications do not require
        - general purpose multitasking (or preemption)
        - disk access
        - printing
    - Full blown OS not necessary
    - Scheduling Frames
        - Major/minor frames provide a way to organize repeating 'processes'
        - Major frame usually 1 second, but can be any consistent duration
        - 'Process scheduling' is defined by what will be computed during each minor frame
        - Minor frame rate varies from 4/sec up to 100/sec
        - Most important tasks occur first in minor frames, and the less important goes toward the end of the minor frame. Each time the timer goes off the task that is still executing will be cut off and switched to the next minor frame. 
        - The tasks are usually controlled by a `switch` statement. 
        - Frames are usually left with some head room after the tasks, to allow for other interrupts to occur (from a data port for example)
        - Sum of subprogram execution times cannot exceed minor frame time limit.
    - Pros
        - Great for periodic systems
        - intuitively obvious
        - HRT processes not preemptive
            - no shared data problem
        - Lightweight, low overhead scheduler
        - Proven technique
    - Cons
        - Difficult to load balance
        - Processes rates limited by minor frame
        - Time consuming processes must be split into shorter pieces
        - Fragile: may break if you add a process, remove a process, or chance process order
        - Difficult to incorporate sporadic process
- Real-time OS
    - A highly reliable operating system used in real-time systems (however cyclic executive are used more so). (Wind River OS, for example). Allows us to create tasks (functions), and the OS will execute the tasks in turn. (Pre-emptive operating system). The system has a timer that periodically goes off, and the OS will use a context switch (save registers to memory), and go to the next task (and load its registers). One task can supercede another task in a pre-emptive system. 
    - If a shared variable is being used with multiple tasks, if a task gets pre-empted, the variable might not be fully updated. 
    - If the code is interrupted in the middle of a task, the instruction is completed and a 'bookmark' is left in the task. 
    - Instead of turning interrupts off and on after the variable is used, you can use a semafor, a 'flag' that says that the variable is in use in another task and must be completed before it can be used, so the task will pre-empt itself. 

---
## Oct 16, 2018

### LEDs and Switches
**Switches**

| Digital | Voltage          |
| ------- | ---------------- |
| 0       | 0 volts (ground) |
| 1       | 3.3VDC           |

EMF), think of as a pressure.

**LEDs (light emitting diode)**

Diodes let power go one way, consists of anode (+) and cathode (-).

Ohms Law: 
>$V = IR$  

V is voltage  
I is current  
R is resistance  

Our LEDs use 2ma, so $I). 

>$R = \frac{ V_{sys} - V_f }{ I_{LED} }$

---
## Oct 18, 2018

### Code conversion
Binary -> ASCII hex

To change the byte `0100 0001` to ASCII, you'd have to run it through some code conversion software. That way the correct number will be shown instead of the ASCII letter 'A'. A dumb terminal can't differentiate what you want to do with certain information, all it does it show the ASCII codes for the binary patterns it receives. So by converting our original 65 into a 6 and a 5 in binary, it will show correctly. 

Some c code to show conversion from a PC to the embedded system and back to PC.

```c
Serial pc(USBTX, USBRX); //tx, rx

int main()
{
    pc.printf("Hello world\b\r");

    pc.putc(65); //putc outputs one character
    pc.printf("\n\r"); //flushes buffer with a carriage return and line feed

    while(1)
    {
        pc.putc( pc.getc() ); //echo input back to terminal
    }
}
```

| 4 bit number | ASCII Hex                         |
| ------------ | --------------------------------- |
| `1010`, 0xA  | `0100 0001`, 65$_{10}$, 0x41, 'A' |

The best way to convert these numbers into hex is **table lookup**.

```arm
        AREA |.text|, CODE, READONLY
        EXPORT BtoAH

BtoAH
        ;R0 will contain 4 bit number to convert to ASCII hex
        ;Output: ASCII hex char

        LDR R1,=ASCIIhexTable; address of table into R1
        LDRB R0, [R1, R0]; copy char into R0 from table using R0 as the offset

        BX LR

ASCIIhexTable
        DCB "0123456789ABCDEF"; define constant byte

        END

```

>`BtoAH` stands for binary to ASCII hex

In c:
```c
extern char BtoAH(int n); // 0 to 15
char asciiChar;

int main()
{
    asciiChar);
}
```

---
## Oct 23, 2018

### Lab 4: 32-bit Binary to ASCII hex (B32toAH)

- [X] ~~*Complete L4*~~ [2018-10-23]

Continuing from the code conversion above. This can be possible by using our 4 bit code converter, counted loop, and left and right shifts.

In `B32toAH.c`

```c
extern void B32toAH(int n, char s[]);

char buff8[9]; //one extra spot for null terminator on end

int main()
{
    B32toAH(0xABCDEF01, buff8);
}

```

`B32toAH` returns void, however the second parameter (`char s[]`) will be the result, we will be modifying it but not returning it technically.

In `B32toAHasm.s`

```arm
        AREA |.text|, CODE, READONLY
        EXPORT B32toAH

B32toAH ; R0 32-bit number to convert ASCII hex, passed by c
        ; R1 address of string buffer, passed by c
        ; R2 shift counter and loop count
        ; R3 preserve original number in R0
        ; R4 char read from ASCII table
        ; R5 points to first char in ASCIIhexTab lookup table

        PUSH {R4, R5};        preserve R4 and R5

        MOVS R2, #0;          initialize left shift count and loop count to 0
        MOVS R3, R0;          preserve R0 into R3
        LDR R5, =ASCIIhexTab; load R5 with address of lookup table

while1  LSLS R0, R2;          shift left by shift count
        LSRS R0, #28;         shift most significant byte to least significant byte
        LDRB R4, [R5, R0];    load low byte into R4
        STRB R4, [R1];        store byte from R4 into the location of our string in RAM

        ADDS R1, #1;          increment string pointer by 1
        ADDS R2, #4;          increment shift counter by 4
        MOVS R0, R3;          restore original number

        CMP R2, #32;          shift count != 32
        BNE while1

        MOVS R5, #00;         temporarily put 00 in R5
        STRB R1, [R5];        end string with null terminator

        POP {R4, R5};         restore R4, R5
        BX LR;                return

ASCIIhexTab
        DCB "0123456789ABCDEF"

        END

```

First off we'll want to point at the ASCII hex table, then preserve the original string before we start shifting. **Anything above `R3` must be preserved when the code returns**, so to preserve the higher registers we'll need to use the stack. You want to preserve the registers in the stack first, and restore them once the subprogram has completed. `PUSH` and `POP` can be written using hyphens and/or commas (hyphens go thru from the start to the end), and must use curly braces (i.e. `PUSH {R4-R6, R10}`). **The stacks grows toward low memory.** 

---
## Oct 25, 2018

### More code conversion: ASCII decimal -> binary

For example if the user enters the number '25' on the keyboard, the ASCII codes for that is technically 0x32 and 0x35, and we want to convert it into 0x00000019 (25 in binary) so we can work on it arithmetically.

| ASCII | Hex  |
| ----- | ---- |
| '2'   | 0x32 |
| '5'   | 0x35 |

If we **minus 0x30 from the ASCII code**, we will end up with the value intended in hex, which will then be converted to binary when compiled.

In `ADtoB.c`:

```c
extern int ADtoB(char s[]);

char input[]="25";
int x;

int main()
{
    x);
}

```

In `ADtoBasm.s`

```arm
        AREA |.text|, CODE, READONLY
        EXPORT ADtoB
ADtoB   ; R0 address of string
        ; R1 current char being evaluated
        ; R2 running total, initialized to 0
        ; R3 holds 10 to be used with multiply instruction

        MOVS R2, #0; total = 0
        MOVS R3, #10; multiplier = 10
nextChar
        LDRB R1, [R0]; get char from string
        ADDS R0, #1; advance char pointer

        CMP R1, #0; check for null terminator
        BEQ endLoop1

        SUBS R1, #0x30; strip ASCII
        MULS R2, R3, R2; multiply by 10 to move the total digit to the left

        ADDS R2, R2, R1; add digit to running total
        B nextChar
endLoop1
        MOV R0, R2; put total into R0
        BX LR

        END

```

---
## Oct 30, 2018

### More code conversion: Binary to ASCII Binary
We want to convert a 32-bit binary value to ASCII binary. We want to take a binary number and print it in binary on the screen. This will be converted into a 33-byte char array (one for null terminator). This will be possible by left shifting then using a `ADCS` (add with carry), because the carry flag will contain the digit that we shifted out of the register. 


In `BtoAB.c`

```c
extern void btoab(int n, char s[]);

char ascbin[33]; //one extra space for null terminator

int main()
{
    btoab(0xFFFF0000, ascbin);
}
```

In `BtoABasm.s`

```arm
        AREA |.text|,CODE,READONLY
        EXPORT btoab
btoab   ; R0 number to convert
        ; R1 address of first char of the string
        ; R2 holds 0x30, char to store
        ; R3 #0
        ; R4 loop counter
        
        PUSH {R4}; 		preserve R4
        
        MOVS R3, #0; 	0 to add with carry
        MOVS R4, #32; 	loop counter
        
loop1	MOVS R2,#'0';	reset 0

        LSLS R0, #1;	msb into carry flag
        ADCS R2, R3;	add carry to R2
        
        STRB R2, [R1];	store ascii digit into str
        ADDS R1, #1;	increment pointer
        
        SUBS R4, #1;	decrement loop counter
        BNE loop1

        MOVS R2, #0
        STRB R2, [R1];	null terminate string
        
        POP {R4};	restore R4
        BX LR;		return
        
        END

```

---
## Nov 1, 2018

### Lab 5: Cipher

This is a subsitution cipher. To make this cipher easier, and not run into making mid-string null terminators, we will make the message the same length each time. 16 byte messages plus 1 byte for the null terminator.

pseudo:
- initialize variables
- loop 16 times
    - get text char
    - get key char
    - if key char is null terminator
        - reset key pointer
        - get key char
    - increment key pointer
    - EOR text char and key char
    - STRB where R0 points
    - increment text pointer
    - loop test

```c
extern void cipher16(char text[], char key[]);

char str[16] = "This is a test!!";

int main()
{
    cipher16(str, "Bob123");
    cipher16(str, "Bob123");
}

```

```arm
        AREA |.text|, CODE, READONLY
        EXPORT cipher16
cipher16
        ; R0 address of text
        ; R1 address of key
        ; R2 loop counter (16)
        ; R3 preserve key location
        ; R4 current text char
        ; R5 current key char

        PUSH {R4-R5};   preserve registers
        
        MOVS R2, #16;   loop counter = 16
        MOVS R3, R1;    preserving key location

loop1   LDRB R4, [R0];  get text char
        LDRB R5, [R1];  get key char

        CMP R5, #0;     key char == null terminator?
        BNE if1;
        MOVS R1, R3;    reset key
        LDRB R5, [R1];  reload key
if1     ADDS R1, #1;    increment key

        EORS R4, R5;    xor operation
        STRB R4, [R0];  store encrypted char

        ADDS R0, #1;    increment text
        SUBS R2, #1;    decrement loop counter
        BNE loop1;      check if end of loop
        
        POP {R4-R5};    restore registers

        BX LR;          return

        END

```

### Parameter passing

The first 4 parameters of a function are passed thru R0-R3. **Any parameters after the first 4 get pushed onto the stack**. If a variable is passed as a parameter, it will need to go lookup the location of the variable in memory before moving it into a register. When an expression is passed as a parameter

---
## Nov 6, 2018

### ALU
ALU lives inside the CPU, everything else exists to bring data to the ALU. 

Digital logic:  
**AND gate:**  
Only true if all inputs are true

![AND](/LogicGates/AND.png "AND")

| a     | b     | a `&&` b |
| :---: | :---: | :------: |
| 0     | 0     | 0        |
| 0     | 1     | 0        |
| 1     | 0     | 0        |
| 1     | 1     | 1        |

**OR gate (inclusive):**  
True if either input is true. This gate can be made with 3 NANDS. 

![OR](/LogicGates/OR.png "OR")

| a     | b     | a `||` b |
| :---: | :---: | :------: |
| 0     | 0     | 0        |
| 0     | 1     | 1        |
| 1     | 0     | 1        |
| 1     | 1     | 1        |

**NOT gate:**  
Returns the opposite of the input. Also known as a inverter

![NOT](/LogicGates/NOT.png "NOT")

| a     | `!`a  |
| :---: | :---: |
| 0     | 1     |
| 1     | 0     |

**NAND gate:**  
NOT AND, returns opposite of a AND gate. **One of two universal gates**. Uses the least resistors. If you tie the two inputs together it turns into a NOT gate (however the propagation delay is slower then a NOT).

![NAND](/LogicGates/NAND.png "NAND")

| a     | b     | a AND b NOT |
| :---: | :---: | :---------: |
| 0     | 0     | 1           |
| 0     | 1     | 1           |
| 1     | 0     | 1           |
| 1     | 1     | 0           |

**NOR gate:**  
NOT OR gate. **One of the two universal gates**. Was the first integrated circuit to be mass produced (Fairchild organization, second silicon valley company, 1961). 

![NOR](/LogicGates/NOR.png "NOR")

| a     | b     | a OR b NOT |
| :---: | :---: | :--------: |
| 0     | 0     | 1          |
| 0     | 1     | 0          |
| 1     | 0     | 0          |
| 1     | 1     | 0          |

---
## Nov 13, 2018

### The Assembler

Used to translate our .s files to generate .o files. Object code files are not directly executed, they are prepared to be fed into the linker. The linker hooks all the .o files together and creates the core image (actual executable code). Inside the assembler there are 2 critical things we need to look at. The symbol table (label table), and the location counter. There is also a pass counter. The assembler "drinks the characters through a straw", character by character. Lexical analysis. It checks each instruction in it's table and keeps track of the next instruction will be. On the first pass its checking how much room each instruction takes up. The assembler also checks if anything is in column zero ( a label ) and it adds it to the symbol table, and it keeps track of it's address. On the second pass of the assembler it actually makes the machine code for each instruction. It doesn't check labels on the second pass. It looks up each symbol in the symbol table, to look ahead in the code. 

mbed > hardware boards > st microsystems boards > NUCLEO L432KC > Technical references document > Reference manual (RM0394)

STM32L432KC
