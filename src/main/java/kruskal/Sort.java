package kruskal;

import java.util.List;

public class Sort {
    public static <E extends Comparable<E>> void quicksort(List<E> vector, int left, int right) {
        if (left < right) {
            int pivot = quicksort_split(vector, left, right);
            quicksort(vector, left, pivot - 1);
            quicksort(vector, pivot + 1, right);
        }
    }

    private static <E extends Comparable<E>> int quicksort_split(List<E> vector, int left, int right) {
        E pivot = vector.get(left);
        int i = left + 1, j = right;

        while (i <= j) {
            if (vector.get(i).compareTo(pivot) <= 0) {
                i++;
            } else if (pivot.compareTo(vector.get(j)) < 0) {
                j--;
            } else {
                E swap = vector.get(i);
                vector.set(i, vector.get(j));
                vector.set(j, swap);

                i++;
                j--;
            }
        }

        vector.set(left, vector.get(j));
        vector.set(j, pivot);
        return j;
    }
}
