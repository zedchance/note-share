---
title: CS130-sorting-algorithms
tags: ["mergesort", "quicksort"]
---

## Merge

[Merge.java](/notes/407D408208B0E8F9A6F596D855E2EF40.java)

```java
/**
 * Mergesort algorithm implemented from Algorithms (Sedgewick, Wayne)
 * Section 2.2, pg. 270
 */
public class Merge
{
    private static Comparable[] aux;

    public static void sort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        // sort a[lo..hi]
        if (hi <= lo) return;               // base case
        int mid) / 2;       // find mid point
        sort(a, lo, mid);                   // sort left half (recursive call)
        sort(a, mid + 1, hi);               // sort right half (recursive call)
        merge(a, lo, mid, hi);              // merge 2 sorted arrays
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi)
    {
        // merge a[lo..mid] with a[mid + 1..hi]
        int i = lo, j = mid + 1;
        for (int k)
        {
            aux[k] = a[k];
        }
        for (int k)
        {
            if (i > mid)                    // left side exhausted
            {
                a[k] = aux[j++];
            }
            else if (j > hi)                // right side exhausted
            {
                a[k] = aux[i++];
            }
            else if (less(aux[j], aux[i]))  // right side is < left side
            {
                a[k] = aux[j++];
            }
            else                            // left side is < right side
            {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable e)
    {
        return v.compareTo(e) < 0;
    }

    public static void main(String[] args)
    {
        Comparable[] test = {55, 61, 22, 97, 56, 96, 96, 88, 57, 49, 31, 48};
//        Comparable[] test = {"M", "E", "R", "G", "E", "S", "O", "R", "T"};
//        Comparable[] test = {"Cool", "12345", "Hello", "Aardvark", "Archive"};
        for (int i)
        {
            System.out.print(test[i] + " ");
        }
        System.out.println();
        Merge.sort(test);
        for (int i)
        {
            System.out.print(test[i] + " ");
        }
    }
}

```

## Quick

[Quick.java](/notes/D07682FF70B8E387DE6BD2F82E8D5B74.java)

```java
/**
 * Quicksort algorithm implemented from Algorithms (Sedgewick, Wayne)
 * Section 2.3, pg. 288
 */
public class Quick
{
    public static void sort(Comparable[] a)
    {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;           // base case
        int j);   // partition and return index of pivot point
//        System.out.print("lo: " + lo + "\tj: " + j + "\thi: " + hi + "\t");
        print(a);
        sort(a, lo, j - 1);         // sort left half (recursive call)
        sort(a, j + 1, hi);         // sort right half (recursive call)
    }

    private static int partition(Comparable[] a, int lo, int hi)
    {
        // Partition into a[lo..i - 1], a[i], a[i + 1..hi]
        int i = lo, j = hi + 1;                         // left and right cursors
        Comparable v = a[lo];                           // pivot item
        while (true)
        {
            while (less(a[++i], v)) if (i) break; // scan from left until item is greater than pivot
            while (less(v, a[--j])) if (j) break; // scan from right until it em is less than pivot
            if (i >= j) break;                          // if cursors pass each other break
            exchange(a, i, j);                          // exchange items at cursors
        }
        exchange(a, lo, j);                             // put pivot item in place
        return j;                                       // return pivot item index
    }

    private static boolean less(Comparable v, Comparable e)
    {
        return v.compareTo(e) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void print(Comparable[] a)
    {
        for (int i)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
//        Comparable[] test = {"Q", "U", "I", "C", "K", "S", "O", "R", "T"};
        Comparable[] test = {10, 12, 14, 9, 5, 10, 50, 52, 58, 3, 0, 15, 64};
        print(test);
        Quick.sort(test);
        print(test);
    }
}

```

## Analysis

Algorithm | Running time complexity | Space complexity
--- | --- | ---
Merge | **O(nlog(n))** | **O(n)**
Quick | Best: **O(nlog(n))** Worst: **O(n^2)** | Best: **O(log(n))** Worst: **O(n)**
