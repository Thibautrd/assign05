package assign05;

import java.util.ArrayList;

public class MergeSorter<E extends Comparable<? super E>> implements Sorter<E> {

    private int threshold;

    public MergeSorter(int threshold) throws IllegalArgumentException {
        if (threshold <= 0) {
            throw new IllegalArgumentException("Threshold must be positive.");
    }
        this.threshold = threshold;
    }


    @Override
    public void sort(ArrayList<E> list) {
        if(list == null || list.size() <= 1) {
            return;
        }
        if(list.size() <= threshold) {
            threshold = list.size();
        }
        mergeSort(list, 0, list.size() - 1, threshold);
    }

    private void mergeSort(ArrayList<E> list, int left, int right, int threshold) {
        if (right - left + 1 <= threshold) {
            insertionSort(list, left, right);
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(list, left, mid, threshold);
        mergeSort(list, mid + 1, right, threshold);
        merge(list, left, mid, right);
    }


    private void merge(ArrayList<E> list, int left, int mid, int right)  {
        ArrayList<E> temp = new ArrayList<>(list.subList(left, right + 1));
        int i = 0, j = mid - left + 1, k = left;

        while (i <= mid - left && j < temp.size()) {
            if (temp.get(i).compareTo(temp.get(j)) <= 0) {
                list.set(k++, temp.get(i++));
            } else {
                list.set(k++, temp.get(j++));
            }
        }

        while (i <= mid - left) {
            list.set(k++, temp.get(i++));
        }
    }


    private void insertionSort(ArrayList<E> list, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            E key = list.get(i);
            int j = i - 1;
            while (j >= left && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }


}

