package Sorters;

import java.util.ArrayList;

public class QuickSorter<E extends Comparable<? super E>> implements Sorter<E> {

    private final PivotChooser<E> chooser;

    public QuickSorter(PivotChooser<E> chooser) {
        this.chooser = chooser;
    }


    /**
     * @param list - list to be sorted
     */
    @Override
    public void sort(ArrayList<E> list) {
        if (list != null && list.size() > 1) {
            quickSort(list, 0, list.size() - 1);
        }

    }

    /**
     * gets the required
     *
     * @param list - the arraylist
     * @param low  - the lower index of the array
     * @param high - the higher index of the array
     * @return
     */
    private int partition(ArrayList<E> list, int low, int high) {
        E pivot = list.get(chooser.getPivotIndex(list, low, high));
        int i = low - 1;

        for (int j = low; j < high; j++)
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        swap(list, i + 1, high);
        return i + 1;
    }

    private void swap(ArrayList<E> list, int i, int j) {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private void quickSort(ArrayList<E> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

}
