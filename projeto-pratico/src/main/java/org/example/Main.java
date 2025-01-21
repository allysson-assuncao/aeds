package org.example;

import java.util.Arrays;
import java.util.Random;

interface SortAlgorithm {
    void sort(int[] array);
}

class InsertionSort implements SortAlgorithm {
    public void sort(int[] array) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;
        }
    }
}

class SelectionSort implements SortAlgorithm {
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
}

class MergeSort implements SortAlgorithm {
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    /*private void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, middle + 1, rightArray, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }*/

    private void merge(int[] array, int left, int middle, int right) {
        int leftIndex = left, rightIndex = middle + 1, auxIndex = 0;
        int[] auxArray = new int[right - left + 1];

        while (leftIndex <= middle && rightIndex <= right) {
            if (array[leftIndex] <= array[rightIndex]) {
                auxArray[auxIndex] = array[leftIndex];
                leftIndex++;
            } else {
                auxArray[auxIndex] = array[rightIndex];
                rightIndex++;
            }
            auxIndex++;
        }

        while (leftIndex <= middle) {
            auxArray[auxIndex] = array[leftIndex];
            auxIndex++;
            leftIndex++;
        }

        while (rightIndex <= right) {
            auxArray[auxIndex] = array[rightIndex];
            auxIndex++;
            rightIndex++;
        }

        for (auxIndex = 0; auxIndex < auxArray.length; auxIndex++) {
            array[left + auxIndex] = auxArray[auxIndex];
        }
    }
}

class BubbleSort implements SortAlgorithm {
    public void sort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}

class QuickSort implements SortAlgorithm {
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

public class Main {
    public static void testSortAlgorithm(SortAlgorithm algorithm, String algorithmName) {
        int[] sizes = {100, 500, 1000, 5000, 20000, 50000, 100000, 500000};
        String[] orders = {"random", "ascending", "descending"};
        long seed = 42;

        // Calculate the maximum width for each column
        int maxAlgorithmNameLength = Arrays.stream(new String[]{"Algorithm", algorithmName}).mapToInt(String::length).max().orElse(0);
        int maxSizeLength = Arrays.stream(new String[]{"Size", String.valueOf(sizes[sizes.length - 1])}).mapToInt(String::length).max().orElse(0);
        int maxOrderLength = Arrays.stream(new String[]{"Order", "descending"}).mapToInt(String::length).max().orElse(0);
        int maxDurationLength = Arrays.stream(new String[]{"Time (ms)", "10000000"}).mapToInt(String::length).max().orElse(0);

        // Print the header
        System.out.printf("%-" + maxAlgorithmNameLength + "s | %-" + maxSizeLength + "s | %-" + maxOrderLength + "s | %-" + maxDurationLength + "s%n",
                "Algorithm", "Size", "Order", "Time (ms)");
        System.out.println("-".repeat(maxAlgorithmNameLength + maxSizeLength + maxOrderLength + maxDurationLength + 9));

        for (int size : sizes) {
            for (String order : orders) {
                int[] array = generateArray(size, order, seed);
                long startTime = System.nanoTime();
                algorithm.sort(array);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1000000; // In milliseconds

                // Print each result in a formatted manner
                System.out.printf("%-" + maxAlgorithmNameLength + "s | %-" + maxSizeLength + "d | %-" + maxOrderLength + "s | %-" + maxDurationLength + "d%n",
                        algorithmName, size, order, duration);
            }
        }
        System.out.println("\n\n");
    }

    public static void main(String[] args) {
        testSortAlgorithm(new InsertionSort(), "InsertionSort");
        testSortAlgorithm(new SelectionSort(), "SelectionSort");
        testSortAlgorithm(new MergeSort(), "MergeSort");
        testSortAlgorithm(new BubbleSort(), "BubbleSort");
        testSortAlgorithm(new QuickSort(), "QuickSort");
    }

    public static int[] generateArray(int size, String order, long seed) {
        Random random = new Random(seed);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        if (order.equals("ascending")) {
            Arrays.sort(array);
        } else if (order.equals("descending")) {
            Arrays.sort(array);
            for (int i = 0; i < size / 2; i++) {
                int temp = array[i];
                array[i] = array[size - i - 1];
                array[size - i - 1] = temp;
            }
        }
        return array;
    }
}
