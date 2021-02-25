---
title: "Luhn's Algorithm"
---

# Luhn's Algorithm

An implementation of the [Luhn algorithm](https://en.wikipedia.org/wiki/Luhn_algorithm) in the C language.

This algorithm is used for verification of credit card numbers. It is a simple to follow process that generates the last digit of the credit card (the checksum).

<!--more-->

The algorithm is as follows:

> - From the rightmost digit (excluding the check digit) and moving left, double the value of every second digit. The check digit is neither doubled nor included in this calculation; the first digit doubled is the digit located immediately left of the check digit. If the result of this doubling operation is greater than 9 (e.g., 8 × 2).
> - Take the sum of all the digits.
If the total modulo 10 is equal to 0 (**if the total ends in zero**) then the number is valid according to the Luhn formula; otherwise it is not valid.

So with a number, say `4539704354706391`, we can check the number like so:

```text
4  5  3  9  7  0  4  3  5  4  7  0  6  3  9  1 original number
8  5  6  9 14  0  8  3 10  4 14  0 12  3 18  1 double every other
8 +5 +6+ 9+1+4+0 +8 +3+1+0+4+1+4+0+1+2+3+1+8+1 add all digits
                                          = 70 valid card
```

## Implementing the algorithm

Let `n` be the card number we're checking, we'll store this off in a long called `number`.

```c
long number = n;
```

We'll start a running `sum` at 0. We can extract the rightmost digit by modding the `number` with 10 (`% 10`), then add it to our `sum`. Then we can chop off the digit by dividing by 10.

```c
int sum = 0;
sum = number % 10;                 // add checksum
number = number / 10;              // chop checksum off
```

Next while the number is positive we'll extract the rightmost digit with a mod 10 and double it. If it is a double digit number we'll subtract 9 from it. (i.e. for the number 18: `1 + 8). It is then added to the running sum, and chopped off.

The next number is just added to the sum, and not doubled. This continues until all the digits have been processed.

```c
while(number)
{
    int temp) * 2;  // get rightmost digit and double
    if (temp > 9)                  // if 2 digit number add digits together
    {
        temp = temp - 9;
    }
    sum = sum + temp;              // add digit to sum
    number = number / 10;          // chop rightmost digit off
    temp = number % 10;            // get rightmost digit
    sum = sum + temp;              // add interleaved digit to sum
    number = number / 10;          // chop right digit off
}
```

The function will return the leftmost digit of the card number to determine which company. That's simply dividing the number by 10 until its a one digit number

```c
while (n > 10)                     // get leftmost digit
{
    n = n / 10;
}
```

If the sum after all of this ends in a 0, then the card is valid. If it isn't a `-1` is returned indicating an invalid card number.

```c
if (sum % 10)                      // invalid card number
{
    return -1;
}
return n;                          // return leftmost digit
```

## Visualizing the algorithm

```flow
st=>start: start with credit card number
valid=>end: valid number
return leftmost digit
invalid=>end: invalid number
return -1
chksum=>operation: extract checksum, add to sum, and chop off
ext=>operation: extract rightmost digit
chop=>operation: extract rightmost digit then chop digit off
chop2=>operation: extract rightmost digit
add to sum, chop off
dbl=>operation: double the digit
splt=>operation: subtract 9 from digit
sum=>operation: add to sum
leftmost=>operation: extract leftmost digit to return
isdbl=>condition: doubled digit > 9?
loop=>condition: number still positive?
isvalid=>condition: is sum multiple of 10?

st->chksum->loop
loop(yes)->chop->dbl->isdbl
loop(no)->leftmost
leftmost->isvalid
isdbl(no)->sum
isdbl(yes)->splt->sum->chop2(left)->loop
isvalid(yes)->valid
isvalid(no)->invalid
```

## The working example

Here's an [entire](https://gist.github.com/zedchance/b6480f6ed49793440bccd34ad560b3fc) working example (the algorithm is in the `validate` function):

```c
// Luhn's algorithm for checking credit card numbers
// 4539704354706391 should have a sum of 70 (valid)

#include <stdio.h> 

// #define DEBUG

// Function prototypes
long get_cc();
int validate(long n);

int main()
{
    switch (validate(get_cc()))
    {
        case 3:
            printf("AMEX\n");
            break;
        case 4:
            printf("VISA\n");
            break;
        case 5:
            printf("MASTERCARD\n");
            break;
        case 6:
            printf("DISCOVER\n");
            break;
        default:
            printf("INVALID\n");
    }
}

long get_cc()
{
    printf("Enter a credit card number: ");
    long n;
    scanf("%ld", &n);
    return n;
}

int validate(long n)
{
    long number = n;
    
    #ifdef DEBUG
    printf("Number: %ld\n", number);
    #endif
    
    int sum = 0;
    sum = number % 10;                 // add checksum
    number = number / 10;              // chop checksum off
    while(number)
    {
        int temp) * 2;  // get rightmost digit and double
        if (temp > 9)                  // if 2 digit number add digits together
        {
            temp = temp - 9;
        }
        sum = sum + temp;              // add digit to sum
        number = number / 10;          // chop rightmost digit off
        temp = number % 10;            // get rightmost digit
        sum = sum + temp;              // add interleaved digit to sum
        number = number / 10;          // chop right digit off
    }
    while (n > 10)                     // get leftmost digit
    {
        n = n / 10;
    }
    
    #ifdef DEBUG
    printf("Sum: %d\nLeftmost: %ld\n", sum, n);
    #endif
    
    if (sum % 10)                      // invalid card number
    {
        return -1;
    }
    return n;                          // return leftmost digit
}
```
