package kruskal;

import java.util.ArrayList;
import java.util.List;

public class Sort {
    public static <E extends Comparable<E>> void quicksort(List<E> vector) {
        quicksort_main(vector, 0, vector.size() - 1);
    }

    public static <E extends Comparable<E>> void quicksort_main(List<E> vector, int left, int right) {
        if (left < right) {
            int pivot = quicksort_split(vector, left, right);
            quicksort_main(vector, left, pivot - 1);
            quicksort_main(vector, pivot + 1, right);
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

    public static <E extends Comparable<E>> void mergesort(List<E> vector){
        mergesort_main(vector, 0, vector.size() - 1);
    }

    private static <E extends Comparable<E>> void mergesort_main(List<E> vector, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergesort_main(vector, left, middle);
            mergesort_main(vector, middle + 1, right);
            mergesort_merge(vector, left, middle, right);
        }
    }

    private static <E extends Comparable<E>> void mergesort_merge(List<E> vector, int left, int middle, int right) {
        List<E> temp = new ArrayList<>(vector);
        int i = left, j = middle + 1, k = 0;

        while (i <= middle && j <= right) {
            if (vector.get(i).compareTo(vector.get(j)) <= 0) {
                temp.set(k, vector.get(i));
                k++;
                i++;
            } else {
                temp.set(k, vector.get(j));
                k++;
                j++;
            }
        }

        while (i <= middle) {
            temp.set(k, vector.get(i));
            k++;
            i++;
        }

        while (j <= right) {
            temp.set(k, vector.get(j));
            k++;
            j++;
        }

        for (i = left; i <= right; i++) {
            vector.set(i, temp.get(i - left));
        }
    }
}
