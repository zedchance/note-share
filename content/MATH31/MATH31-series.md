---
title: MATH31-series
tags: ["series"]
---

# Series and sequences

## What is a series 

To evaluate series, first find the partial sum:

{{< katex display >}}
\begin{aligned}
    \sum_{n=1}^\infty n \\
    S_n = 1 + 2 + 3 +\  ...\  + n
\end{aligned}
{{< /katex >}}

Find the formula for {{< katex >}}S_n{{< /katex >}}

$$
S_n= \frac{n(n+1)}{2}
$$

Take the limit as {{< katex >}}n \rightarrow \infty{{< /katex >}}

$$
\lim_{n \rightarrow \infty} \frac{n(n+1)}{2} = \infty
$$

## Telescoping

These series look like two repeating fractions that end up canceling everything except something from the first term and something from the last. For example:

{{< katex display >}}
\begin{aligned}
    \sum_{n=1}^{\infty} \Big(\frac{1}{2n+3} - \frac{1}{2n+1}\Big)
\end{aligned}
{{< /katex >}}

First find the partial sum {{< katex >}}S_n{{< /katex >}}

{{< katex display >}}
\begin{aligned}
    S_n) + \ ...
    +\ \Big ( \frac{1}{2n+1}-\frac{1}{2n-1}\Big ) + \Big ( \frac{1}{2n+3}-\frac{1}{2n+1}\Big )
\end{aligned}
{{< /katex >}}

Almost all of these fractions will cancel if you see the patern. The only 2 left are:

$$
S_n = - \frac{1}{3} + \frac{1}{2n+3}
$$

Take the limit of this partial sum {{< katex >}}S_n{{< /katex >}}

$$
\lim_{n \rightarrow \infty}\big[ - \frac{1}{3} + \frac{1}{2n+3} \big] = - \frac{1}{3}
$$

## Geometric

Geometric series take the form of:

$$\sum_{n=1}^\infty ar^{n-1}$$

The series will converge of {{< katex >}}\big|r\big|< 1{{< /katex >}}, otherwise it will diverge.

If the sum does converge, the sum is:

$$\sum_{n=1}^\infty ar^{n-1} = \frac{a}{1-r}$$

### Shortcut

If the first power of the sequence is 0 then the first term is {{< katex >}}a{{< /katex >}}. {{< katex >}}a{{< /katex >}} stands for the first term in your series.

For example:

{{< katex display >}}
\begin{aligned}
    \sum_{n=1}^{\infty} \Big ( \frac{2}{3} \Big )^n & = \sum_{n=1}^{\infty} \Big ( \frac{2}{3} \Big )\Big ( \frac{2}{3} \Big )^{n-1} \\
    & = \frac{\frac{2}{3}}{1-\frac{2}{3}}
\end{aligned}
{{< /katex >}}

Another example:

{{< katex display >}}
\begin{aligned}
    \sum_{n=2}^{\infty} \frac{e^n}{3^{n+1}} & = \sum_{n=2}^{\infty} \frac{e^n}{3\bullet3^n} \\
    & = \sum_{n=2}^{\infty} \frac{1}{3} \Big( \frac{e}{3}\Big)^n
\end{aligned}
{{< /katex >}}

The mistake most people make here is thinking that {{< katex >}}a = \frac{1}{3}{{< /katex >}}. This isn't the case because plugging in {{< katex >}}n=2{{< /katex >}} doesn't make the first exponent 0. So split off more $\frac{e}{3}$'s to make it in the right form:

Now since the first term makes the exponent go to 0. You can tell what {{< katex >}}a{{< /katex >}} and {{< katex >}}r{{< /katex >}} are now. So:

$$
= \frac{ \frac{e^2}{27} }{1- \frac{e^2}{3}}
$$

So the shortcut here is that you can start with

$$
= \sum_{n=2}^{\infty} \frac{1}{3} \Big( \frac{e}{3}\Big)^n
$$

and simply plug in 2 for {{< katex >}}n{{< /katex >}} (the starting point). Since we know that the first term is {{< katex >}}a{{< /katex >}} you can jump to the answer:

$$
= \frac{ \frac{e^2}{27} }{1- \frac{e^2}{3}}
$$

## Harmonic

Harmonc series are defined as:

$$
\sum_{n=1}^{\infty} \frac{1}{n} = \frac{1}{1} + \frac{1}{2} + \frac{1}{3} +\ ...\ + \frac{1}{n}
$$

Harmonic series are divergent. If a sequence {{< katex >}}\{a_n\}{{< /katex >}} is convergent, any subsequence of {{< katex >}}\{a_n\}{{< /katex >}} must also be convergent. To show that a sequence {{< katex >}}\{a_n\}{{< /katex >}} diverges, it is enough to show that a subsequence diverges.

**Note**: If a series converges, then

{{< katex display >}}
\begin{aligned}
    \sum_{n=1}^{\infty} a_n \\
    \lim_{n \rightarrow \infty}^{} a_n = 0
\end{aligned}
{{< /katex >}}

So to show a series diverges, it's enough to show:

$$
\lim_{n \rightarrow \infty} a_n \neq 0
$$

If the limit doesn't equal 0, or {{< katex >}}DNE{{< /katex >}}, the series {{< katex >}}\{a_n\}{{< /katex >}} diverges.

Remember! The limit equaling 0 does **NOT** necessarily mean convergence!

### Example

{{< katex display >}}
\begin{aligned}
    \sum_{n=1}^{\infty} \frac{2n^2-1}{3n^2-1} \\
    \lim_{n \rightarrow \infty} \frac{2n^2-1}{3n^2-1} \neq 0
\end{aligned}
{{< /katex >}}

Diverges because the limit equals 0!

## Properties of convergent series

1. You can always pull a constant out in front of the series

$$
\sum_{n=1}^{\infty} C a_n = C \sum_{n=1}^{\infty} a_n
$$

2. You can split sequences on sums or differences

$$
\sum_{n=1}^{\infty} (a_n \pm b_n) = \sum_{n=1}^{\infty} a_n \pm \sum_{n=1}^{\infty} b_n
$$

### Example

$$
\begin{split}
\sum_{n=1}^{\infty} \Big ( \frac{2^n-5^n}{3^n}\Big ) &) \\
& =\sum_{n=1}^{\infty} \frac{2^n}{3^n} - \sum_{n=1}^{\infty} \frac{5^n}{3^n}
\end{split}
$$

If we split this sequence into parts, each part much be convergent for the entire sequence to be convergent! If any single part is divergent then the entire thing is divergent.

$$
=\sum_{n=1}^{\infty} \Big (\frac{2}{3}\Big )^n - \sum_{n=1}^{\infty} \Big (\frac{5}{3}\Big )^n
$$

In this form we can evaluate them as geometric series. Automatically we know this is divergent because the rightmost fraction's {{< katex >}}r{{< /katex >}} is greater than 1. Since a subsequence of the original diverges, the original does too.

## P series

$$
\sum_{n=1}^\infty \frac{1}{n^P}
$$

When {{< katex >}}P < 1{{< /katex >}} the series will diverge. 

$$
\lim_{n \rightarrow \infty} \frac{1}{n^P}
$$

When {{< katex >}}P > 1{{< /katex >}} the series will converge (can be shown with the integral test).

### Example 1

$$
\sum_{n=1}^{\infty} \frac{1}{n^2}
$$

Here we can see that {{< katex >}}P{{< /katex >}}, so the series must converge.

### Example 2

$$
\sum_{n=1}^\infty \frac{1}{\sqrt[3]{n}}
$$

Here we can see that {{< katex >}}P{{< /katex >}}, so the series diverges.

### Example 3

$$
\sum_{n=1}^\infty n^{-\pi} = \sum_{n=1}^\infty \frac{1}{n^\pi}
$$

Since {{< katex >}}P{{< /katex >}} the series must converge.
