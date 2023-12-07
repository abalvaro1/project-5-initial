package com.example.sorting;

public class SortingUtility {


    public static <T extends Comparable<T>> void gnomeSort(T[] data) {
        int i = 0;
        int size = data.length;
        while (i < size) {
            //base case, i == 0
            if (i == 0) {
                i++;
            }
            //case 1, previous data is less than data after it, in order
            if (data[i].compareTo(data[i - 1]) >= 0) {
                i++;
            }
            //case 2, precious data is greater than data after it, need to swap
            else if (data[i].compareTo(data[i - 1]) < 0) {
                swap(data, i, i - 1);
                i--;
            }
        }
    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] data) {
        int size = data.length; //will decrement as we iterate sort
        int start = 0;
        boolean swapped = true;
        while (swapped == true) {

            swapped = false;

            for (int i = start; i < size - 1; i++) { //data[i] - data[i+1]
                if (data[i + 1].compareTo(data[i]) < 0) {
                    swap(data, i, i + 1);
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            } //case where loop is already sorted during sorting

            swapped = false;
            size -= 1;

            for (int i = size - 1; i >= start; i--) {
                if (data[i + 1].compareTo(data[i]) < 0) {
                    swap(data, i, i + 1);
                    swapped = true;
                }
            }

            start += 1; //first value sorted, keep incrementing...
        }
    }


    public static <T extends Comparable<T>> void shellSort(T[] data) {

        int size = data.length;
        //gap being the middle of the array, and divinding by 2
        for (int gap = size/2; gap > 0; gap /= 2) {

            for(int i = 0; i <= gap; i++) {
                if(data[gap+i].compareTo(data[i]) < 0) {    //data[i] - data[gap+i]
                    swap(data, i, gap+i);
                }
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
    }






