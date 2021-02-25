---
title: MATH31-integral-test
tags: ["integration"]
---

## Integral test

For {{< katex >}}f(n)){{< /katex >}} is continous, positive, and decreasing, then we can use the integral to show convergence/divergence of our series. 

So:

$$
\sum_{n=1}^\infty \text{ and } \int_1^\infty f(x)\ dx
$$

will have the same result (either converge or diverge).

- This can tell you convergence/divergence, but does not necessarily give the sum of the series.
- Convergence is **not** affected by the addition or subtraction of a **finite** number of terms from our series. 

We can judge the convergence of {{< katex >}}\sum_{n=1}^\infty a_n{{< /katex >}} with:

$$
\sum_{n=1}^\infty a_n \text{ or } \int_1^\infty f(x)\ dx
$$

But to do the integral test, we can start the integral at {{< katex >}}N{{< /katex >}}, the sum of our integral will not be the sum of the series, but we can at least tell if it converges/diverges.

$$
\int_N^\infty f(x)\ dx
$$

### Example 1

$$
\sum_{n=1}^\infty \frac{1}{n^2+1}
$$

First thing first, you should check the divergence by taking the limit. The limit here equals 0, so it fails the divergence test. (It may be divergent some other way, but we don't know. It may be convergent, but we don't know). It's not telescoping, its not factorable, so lets try the integral test.

$$
f(x) = \frac{1}{x^2+1}
$$

This should act as an upper bound for our sequence provided its always positive, continuous, and decreasing on it's interval {{< katex >}}[1, \infty){{< /katex >}}. If it meets these requirements then we can do the integral test:

$$
\int_1^\infty \frac{1}{x^2+1} dx
$$

This is an improper integral:

{{< katex display >}}
\begin{aligned}
    \lim_{b \rightarrow \infty} \int_1^b \frac{1}{x^2+1} dx & = \lim_{b \rightarrow \infty} \Big[ \tan^{-1}x \Big]_1^b \\
    & = \lim_{b \rightarrow \infty} \Big[ \tan^{-1}b - \tan^{-1}1 \Big] \\
    & = \frac{\pi}{2} - \frac{\pi}{4} \\
    & = \frac{\pi}{4}
\end{aligned}
{{< /katex >}}

Since we got a number, that shows that the series must converge! **Our answer from the integral is not necessarily the sum of the series!**

### Example 2

$$
\sum_{n=1}^\infty \frac{3}{2n-1}
$$

Try the divergence test first. The limit is 0 so it doesn't automatically diverge. 

The integral test:

$$
f(x) = \frac{3}{2x-1}
$$

It isn't always positive, but it is on our interval {{< katex >}}[1, \infty){{< /katex >}}. It is continuous on our interval and it is also decreasing, so lets try the integral test.

{{< katex display >}}
\begin{aligned}
    \int_1^\infty \frac{3}{2x-1} & = \lim_{b \rightarrow \infty} \int_1^b \frac{3}{2x-1} \\
    && u = 2x-1 \\ && du = 2dx \\
    & = \lim_{b \rightarrow \infty} \frac{3}{2} \int \frac{1}{u} du \\
    & = \lim_{b \rightarrow \infty} \frac{3}{2} \ln \ \big[2x-1\big]_1^b \\
    & = \frac{3}{2} \lim_{b \rightarrow \infty} \big[ \ln(2b-1) - \ln(2-1) \big] \\
    & = \infty
\end{aligned}
{{< /katex >}}

Since the limit evaluates to {{< katex >}}\infty{{< /katex >}} the integral diverges. So the series also diverges.

### Example 3

{{< katex display >}}
\begin{aligned}
    \sum_{n=1}^\infty \frac{\ln n}{n} \\
    f(x) = \frac{\ln x}{x}
\end{aligned}
{{< /katex >}}

The function is positive and continuous. To show decreasing show that {{< katex >}}f'(x) < 0{{< /katex >}}:

{{< katex display >}}
\begin{aligned}
    f'(x) & = \frac{1 - \ln x}{x^2} \\
    1 & \leq \ln x \\
    e & \leq x
\end{aligned}
{{< /katex >}}

Choose a interval where {{< katex >}}f(x){{< /katex >}} will be decreasing. {{< katex >}}f(x){{< /katex >}} will certainly be decreasing on the interval {{< katex >}}[3, \infty){{< /katex >}}.

So:

{{< katex display >}}
\begin{aligned}
    \int_3^\infty \frac{\ln x}{x} & = \lim_{b \rightarrow \infty} \int_3^b \frac{\ln x}{x} dx \\
    && u = \ln x \\
    && du = \frac{1}{x} dx \\
    & = \lim_{b \rightarrow \infty} \int_3^b u\ du \\
    & = \lim_{b \rightarrow \infty} \big[ \frac{1}{2} (\ln x)^2\big]_3^b \\
    & = \lim_{b \rightarrow \infty} \big[ \frac{1}{2} (\ln b)^2 - \frac{1}{2} (\ln 3)^2 \big] \\
    & = \infty
\end{aligned}
{{< /katex >}}

Therefore, the integral diverges. So the series also diverges.

### Example 4

$$
\sum_{n=1}^\infty \frac{e^\frac{1}{n}}{n^2}
$$

First do the divergence test, the limit is 0 so it doesn't immediately diverge. Its not a geometric series. Its also not a P-series. Let's try the integral test.

$$
f(x) = \frac{e^\frac{1}{x}}{x^2}
$$

The function must be positive, continuous, and decreasing on the interval.
The function is positive.
Its only discontinuous at 0 and thats not in our interval.
To show decreasing make sure {{< katex >}}f'(x) < 0{{< /katex >}} (alternatively you could show that {{< katex >}}a_{n-1} < a_n{{< /katex >}}):

{{< katex display >}}
\begin{aligned}
    f'(x) & = \frac{-e^\frac{1}{x}-2xe^\frac{1}{x}}{x^4}
\end{aligned}
{{< /katex >}}

This is negative on our interval {{< katex >}}[1, \infty){{< /katex >}}.

So lets do the integral test:

{{< katex display >}}
\begin{aligned}
    \int_1^\infty \frac{e^\frac{1}{x}}{x^2} dx & = \lim_{b \rightarrow \infty} \int_1^b \frac{e^\frac{1}{x}}{x^2} dx \\
    && u & = \frac{1}{x} \\
    && du & = - \frac{1}{x^2} dx \\
    & = - \lim_{b \rightarrow \infty} \int_1^b e^u du \\
    & = - \lim_{b \rightarrow \infty} \big[ e^\frac{1}{x}\big]_1^b \\
    & = - \lim_{b \rightarrow \infty} \big[ e^\frac{1}{b} - e^1 \big] \\
    & = - [1 - e] \\
    & = e - 1
\end{aligned}
{{< /katex >}}

Therefore since the integral converges, the series must converge also.
