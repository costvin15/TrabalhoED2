package kruskal;

import java.util.ArrayList;
import java.util.List;

public class Sort {
    public static <E extends Comparable<E>> void quicksort(List<E> vector) {
        quicksort_main(vector, 0, vector.size() - 1);
    }

    private static <E extends Comparable<E>> void quicksort_main(List<E> vector, int left, int right) {
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

    public static <E extends Comparable<E>> void insertsort(List<E> vector) {
        insertsort_main(vector, 0, vector.size());
    }

    private static <E extends Comparable<E>> void insertsort_main(List<E> vector, int left, int right) {
        int i, j;
        E temp;

        for (i = left + 1; i < right; i++) {
            temp = vector.get(i);
            j = i - 1;

            while (j >= left && vector.get(j).compareTo(temp) > 0) {
                vector.set(j + 1, vector.get(j));
                j--;
            }

            vector.set(j + 1, temp);
        }
    }

    public static <E extends Comparable<E>> void shellsort(List<E> vector) {
        int i, j, h;
        E aux;

        for (h = 1; h < vector.size(); h = 3 * h + 1);

        while (h > 0) {
            h = (h - 1) / 3;
            for (i = h; i < vector.size(); i++) {
                aux = vector.get(i);
                j = i;

                while (vector.get(j - h).compareTo(aux) > 0) {
                    vector.set(j, vector.get(j - h));
                    j -= h;
                    if (j < h) {
                        break;
                    }
                }

                vector.set(j, aux);
            }
        }
    }

    public static <E extends Comparable<E>> void heapsort(List<E> vector) {
        int i;
        E aux;

        for (i = vector.size() / 2 - 1; i >= 0; i--) {
            heapify(vector, vector.size(), i);
        }

        for (i = vector.size() - 1; i >= 0; i--) {
            aux = vector.get(0);
            vector.set(0, vector.get(i));
            vector.set(i, aux);

            heapify(vector, i, 0);
        }
    }

    private static <E extends Comparable<E>> void heapify(List<E> vector, int size, int i) {
        int largest = i;
        int leftchild = 2 * i + 1;
        int rightchild = 2 * i + 2;
        E aux;

        if (leftchild < size && vector.get(leftchild).compareTo(vector.get(largest)) > 0){
            largest = leftchild;
        }

        if (rightchild < size && vector.get(rightchild).compareTo(vector.get(largest)) > 0) {
            largest = rightchild;
        }

        if (largest != i) {
            aux = vector.get(i);
            vector.set(i, vector.get(largest));
            vector.set(largest, aux);

            heapify(vector, size, largest);
        }
    }

    public static <E extends Comparable<E>> void quicksortmod1(List<E> vector, int l) {
        quicksortmod1_main(vector, 0, vector.size() - 1, l);
    }

    private static <E extends Comparable<E>> void quicksortmod1_main(List<E> vector, int left, int right, int l) {
        if (right - left + 1 <= l) {
            insertsort_main(vector, left, right + 1);
        } else if (left < right) {
            int pivot = quicksort_split(vector, left, right);
            quicksortmod1_main(vector, left, pivot - 1, l);
            quicksortmod1_main(vector, pivot + 1, right, l);
        }
    }

    public static <E extends Comparable<E>> void quicksortmod2(List<E> vector, int l) {
        quicksortmod2_main(vector, 0, vector.size() - 1, l);
    }

    private static <E extends Comparable<E>> void quicksortmod2_main(List<E> vector, int left, int right, int l) {
        if (left > right && right - left + 1 > l) {
            int pivot = quicksort_split(vector, left, right);
            quicksortmod1_main(vector, left, pivot - 1, l);
            quicksortmod1_main(vector, pivot + 1, right, l);
        } else {
            insertsort_main(vector, left, right + 1);
        }
    }
}
