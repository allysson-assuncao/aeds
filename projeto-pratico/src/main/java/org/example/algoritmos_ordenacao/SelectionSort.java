package org.example.algoritmos_ordenacao;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

    public static void selectionSort(int[] array) {
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

    public static void testSelectionSort() {
        int[] sizes = {100, 500, 1000, 5000, 20000, 50000, 100000, 500000};
        String[] orders = {"random", "ascending", "descending"};
        long seed = 42;

        for (int size : sizes) {
            for (String order : orders) {
                int[] array = generateArray(size, order, seed);
                long startTime = System.nanoTime();
                selectionSort(array);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
                System.out.println("Size: " + size + ", Order: " + order + ", Time: " + duration + " ms");
            }
        }
    }

    public static void main(String[] args) {
        testSelectionSort();
    }
}
