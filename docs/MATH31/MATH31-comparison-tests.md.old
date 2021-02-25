---
title: MATH31-comparison-tests
tags: ["series"]
---

## Comparison tests

Idea: Compare one series to another with a known convergence/divergence (geometric, harmonic, p-series, etc). 

Suppose we have two series {{< katex >}}\sum a_n{{< /katex >}} and {{< katex >}}\sum b_n{{< /katex >}} **with positive terms**:

1. If {{< katex >}}a_b < b_n{{< /katex >}} for all {{< katex >}}n{{< /katex >}}, and {{< katex >}}\sum b_n{{< /katex >}} converges, then {{< katex >}}\sum a_n{{< /katex >}} also converges.
2. If {{< katex >}}a_b > b_n{{< /katex >}} for all {{< katex >}}n{{< /katex >}}, and {{< katex >}}\sum b_n{{< /katex >}} diverges, then {{< katex >}}\sum a_n{{< /katex >}} also diverges.

If you show divergence for {{< katex >}}b_n{{< /katex >}} when {{< katex >}}a_n < b_n{{< /katex >}}, it proves nothing. The upper series diverges up to infinity and that tells us nothing about the lower series. It may diverge or converge. So make sure to show the correct comparison. (The same useless comparison is showing convergence for {{< katex >}}b_n{{< /katex >}} when {{< katex >}}a_n > b_n{{< /katex >}}).

### Example 1

{{< katex display >}}
\begin{aligned}
    \sum_{n=1}^\infty \frac{1}{n^2+2}
\end{aligned}
{{< /katex >}}

First check if it fails divergence test, look for other known series, see if integral test could work (it would), but theres a better way. Consider this comparison:

{{< katex display >}}
\begin{aligned}
    0 \leq \frac{1}{n^2+2} \leq \frac{1}{n^2}
\end{aligned}
{{< /katex >}}

If we're trying to show convergence, we need this to be less than something we know convergence for.

So lets show convergence of {{< katex >}}\frac{1}{n^2}{{< /katex >}}:

$$
\sum_{n=1}^\infty \frac{1}{n^2}
$$

This is a P-series with {{< katex >}}p=2{{< /katex >}}, and since our {{< katex >}}p >1{{< /katex >}} it means the series converges.
This means by the comparison test that the original problem also converges.

### Example 2

$$
\sum_{n=1}^\infty \frac{1}{3+2^n}
$$

All the terms are positive on the interval, consider this comparison:

$$
0 \leq \frac{1}{3+2^n} \leq \frac{1}{2^n}
$$

So try to determine convergence of the rightmost fraction:

{{< katex display >}}
\begin{aligned}
    \sum_{n=1}^\infty \frac{1}{2^n} & = \sum_{n=1}^\infty \Big( \frac{1}{2} \Big)^n \\
    & = \sum_{n=1}^\infty \Big( \frac{1}{2} \Big) \Big( \frac{1}{2}\Big)^{n-1}
\end{aligned}
{{< /katex >}}

This is a geometric sum with {{< katex >}}a = \frac{1}{2}{{< /katex >}} and {{< katex >}}r = \frac{1}{2}{{< /katex >}}, therefore since {{< katex >}}r < 1{{< /katex >}} this will converge.
So by the comparison test the original problem also converges.

### Example 3

$$
\sum_{n=3}^\infty \frac{3^n}{2^n-4}
$$

All the terms on the interval are positive, so lets try a comparison:

$$
\frac{3^n}{2^n - 4} \geq \frac{3^n}{2^n}
$$

We're trying to show divergence of the rightmost fraction, and that will show that the original also diverges.

{{< katex display >}}
\begin{aligned}
    \sum_{n=3}^\infty \frac{3^n}{2^n} & = \sum_{n=3}^\infty \Big( \frac{3}{2} \Big)^n \\
    & = \sum_{n=3}^\infty \Big( \frac{3}{2} \Big)^3 \Big( \frac{3}{2} \Big)^{n-3}
\end{aligned}
{{< /katex >}}

Since this is a geometric and our {{< katex >}}r > 1{{< /katex >}}, it diverges. Therefore the original problem diverges.

### Example 4

$$
\sum_{n=1}^\infty \frac{1}{\sqrt{n} + 1}
$$

Consider this comparison:

$$
0 \leq \frac{1}{\sqrt{n}+1} \leq \frac{1}{\sqrt{n}}
$$

This is a P-series with {{< katex >}}p{{< /katex >}}. This means it diverges. This shows nothing about the original problem!

When you can't use a comparison like this, you can use the limit comparison test.

## Limit comparison test

Idea: If {{< katex >}}\sum a_n{{< /katex >}} and {{< katex >}}\sum b_n{{< /katex >}} have **positive terms**, and this limit exists:

$$
\lim_{n \rightarrow \infty} \frac{a_n}{b_n}
$$

If this limit exists, then that means that both terms are so close together that it doesn't matter. That means that both series either converge or diverge.

If it goes to infinity then the terms must difference enough that one or both of them diverges. 

### Proof

Suppose this limit exists:

$$
\lim_{n \rightarrow \infty} \frac{a_n}{b_n} = L
$$

Then by definition:

$$
\Big| \frac{a_b}{b_n} - L \Big| < \epsilon
$$

So:

{{< katex display >}}
\begin{aligned}
    -\epsilon L <  \frac{a_b}{b_n} - L  < \epsilon L \\
    L-\epsilon L <  \frac{a_b}{b_n} < L + \epsilon L \\
    (1-\epsilon)L \cdot b_n < a_n < (1+ \epsilon)L \cdot b_n
\end{aligned}
{{< /katex >}}

{{< katex >}}(1+ \epsilon)L{{< /katex >}} is just a constant (doesn't affect the convergence/divergence of the series), so if {{< katex >}}b_n{{< /katex >}} converges {{< katex >}}a_n{{< /katex >}} is less than that so it also converges. If {{< katex >}}b_n{{< /katex >}} diverges, then {{< katex >}}a_n{{< /katex >}} is greater than that so it also diverges.

### Example 5

So to take a look again at Example 4 above:

$$
\sum_{n=1}^\infty \frac{1}{\sqrt{n} + 1}
$$

Lets try the limit comparison test where:

$$
\lim_{n \rightarrow \infty} \frac{a_n}{b_n}
$$

and

$$
b_n = \frac{1}{\sqrt{n}}
$$

So:

{{< katex display >}}
\begin{aligned}
    \lim_{n \rightarrow \infty} \frac{\frac{1}{\sqrt{n} + 1}}{\frac{1}{\sqrt{n}}} & = \lim_{n \rightarrow \infty} \frac{1}{\sqrt{n} + 1} \cdot \frac{\sqrt{n}}{1} \\
    & = \lim_{n \rightarrow \infty} \frac{\sqrt{n}}{\sqrt{n} + 1} \\
    & = \lim_{n \rightarrow \infty} \frac{1}{1 + \frac{1}{\sqrt{n}}} \\
    & = 1
\end{aligned}
{{< /katex >}}

Since our limit exists, {{< katex >}}a_n{{< /katex >}} and {{< katex >}}b_n{{< /katex >}} are so close together, that if one converges the other must also. If one diverges the other must also. Just because the limit exists it doesn't mean they converge! They will just have the same result. 

Now we know that {{< katex >}}b_n{{< /katex >}} diverges (p-series with {{< katex >}}p < 1{{< /katex >}}), it means the {{< katex >}}a_n{{< /katex >}} does also!

### Example 6

$$
\sum_{n=1}^\infty \frac{2n^2+n}{\sqrt{4n^7+3}}
$$

Lets choose a {{< katex >}}b_n{{< /katex >}} that we know convergence/divergence. Start by trying a {{< katex >}}b_n{{< /katex >}} that models the end behavior of {{< katex >}}a_n{{< /katex >}}:

{{< katex display >}}
\begin{aligned}
    \sum_{n=1}^\infty \frac{2n^2}{\sqrt{4n^7}} & = \sum_{n=1}^\infty \frac{1}{n^{3/2}}
\end{aligned}
{{< /katex >}}

This is a P-series with a {{< katex >}}p = \frac{3}{2}{{< /katex >}}, since {{< katex >}}p > 1{{< /katex >}} it converges!

Limit comparison test:

{{< katex display >}}
\begin{aligned}
    \lim_{n \rightarrow \infty} \frac{a_n}{b_n} & = \lim_{n \rightarrow \infty} \frac{\frac{2n^2+n}{\sqrt{4n^7+3}}}{\frac{1}{n^{3/2}}} \\
    & = \lim_{n \rightarrow \infty} \frac{2n^2+n}{\sqrt{4n^7+3}} \cdot n^{3/2} \\
    & = \lim_{n \rightarrow \infty} \frac{2n^{7/2} + n^{5/2}}{\sqrt{4n^7+3}} \\
    & = \lim_{n \rightarrow \infty} \frac{2 + \frac{1}{n}}{\sqrt{4 + \frac{3}{n^7}}} \\
    & = 1
\end{aligned}
{{< /katex >}}

Since we know the limit exists, and we know that {{< katex >}}b_n{{< /katex >}} converges, {{< katex >}}a_n{{< /katex >}} must converge also!

### Example 7

$$
\sum_{n=1}^\infty \frac{\sqrt{n} + \ln n}{n^2 + 1}
$$

Lets use the limit comparison test, and compare to {{< katex >}}b_n{{< /katex >}} of:

{{< katex display >}}
\begin{aligned}
    b_n & = \sum_{n=1}^\infty \frac{\sqrt{n}}{n^2} \\
    & = \sum_{n=1}^\infty \frac{1}{n^{3/2}}
\end{aligned}
{{< /katex >}}

This is a P-series with {{< katex >}}p{{< /katex >}}.

Limit comparison test:

{{< katex display >}}
\begin{aligned}
    \lim_{n \rightarrow \infty} \frac{\sqrt{n} + \ln n}{n^2 + 1} \cdot n^{3/2} & = \lim_{n \rightarrow \infty} \frac{n^2 + n^{3/2} \ln n}{n^2 + 1} \\
    & = \lim_{n \rightarrow \infty} \frac{1 + \frac{\ln n}{n^{1/2}}}{1 + \frac{1}{n^{2}}} \\
    && = \lim_{n \rightarrow \infty} \frac{\ln n}{n^{1/2}} \\
    && \text{Use L'Hospitals} \\ 
    && = \lim_{n \rightarrow \infty} \frac{\frac{1}{n}}{\frac{1}{2\sqrt{n}}} \\
    && = \lim_{n \rightarrow \infty} \frac{2\sqrt{n}}{n} \\
    && \text{Use L'Hospitals} \\
    && = \lim_{n \rightarrow \infty} \frac{2}{\sqrt{n}} \\
    && = 0 \\
    \therefore & = \lim_{n \rightarrow \infty} \frac{1 + 0}{1 + 0} \\
    & = 1
\end{aligned}
{{< /katex >}}

So since the series {{< katex >}}b_n{{< /katex >}} converges, the series {{< katex >}}a_n{{< /katex >}} also converges.
