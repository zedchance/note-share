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
        int mid = lo + (hi - lo) / 2;       // find mid point
        sort(a, lo, mid);                   // sort left half (recursive call)
        sort(a, mid + 1, hi);            // sort right half (recursive call)
        merge(a, lo, mid, hi);              // merge 2 sorted arrays
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi)
    {
        // merge a[lo..mid] with a[mid + 1..hi]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
        {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++)
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
        for (int i = 0; i < test.length; i++)
        {
            System.out.print(test[i] + " ");
        }
        System.out.println();
        Merge.sort(test);
        for (int i = 0; i < test.length; i++)
        {
            System.out.print(test[i] + " ");
        }
    }
}
