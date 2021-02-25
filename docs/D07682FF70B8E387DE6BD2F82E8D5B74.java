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
        int j = partition(a, lo, hi);   // partition and return index of pivot point
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
            while (less(a[++i], v)) if (i == hi) break; // scan from left until item is greater than pivot
            while (less(v, a[--j])) if (j == lo) break; // scan from right until it em is less than pivot
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
        for (int i = 0; i < a.length; i++)
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
