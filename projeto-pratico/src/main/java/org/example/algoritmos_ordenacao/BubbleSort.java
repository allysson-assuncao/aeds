package org.example.algoritmos_ordenacao;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
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

    public static void testBubbleSort() {
        int[] sizes = {100, 500, 1000, 5000, 20000, 50000, 100000, 500000};
        String[] orders = {"random", "ascending", "descending"};
        long seed = 42;

        for (int size : sizes) {
            for (String order : orders) {
                int[] array = generateArray(size, order, seed);
                long startTime = System.nanoTime();
                bubbleSort(array);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
                System.out.println("Size: " + size + ", Order: " + order + ", Time: " + duration + " ms");
            }
        }
    }

    public static void main(String[] args) {
        testBubbleSort();
    }
}
