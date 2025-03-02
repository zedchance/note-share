---
title: "CS26-reading-notes"
---

# CS 26 Reading Notes

* [Ch. 1 Number Representations](#ch-1-number-representations)

## Ch. 1 Number Representations

**Theorem 1**  
Let b be an integer greater than 1. Then if n is a positive integer, n can be expressed uniquely in the form

{{<k>}}n=a_k ·b^k +a_{k−1} ·b^{k−1} +···+a_1 ·b^1 +a_0 ·b^0 {{</k>}}

where {{< katex >}}k{{< /katex >}} is a nonnegative integer, {{< katex >}}a0, a1, · · · , ak{{< /katex >}} are nonnegative integers less than {{< katex >}}b{{< /katex >}} and {{< katex >}}ak ≠ 0{{< /katex >}}.

--- 

The real utility and power of two’s complement is that one can add pairs of two’s complement numbers (whether positive or negative) in the usual way, and the result will be the correct answer, in two’s complement! In the following examples, superscripts in the binary addition represent carries.
