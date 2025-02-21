package timing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This class contains methods for generating ArrayLists of various sizes and
 * orderings.
 */
public class ArrayListGenerator<E> {

    private static final Random rng = new Random();

    /**
     * Generates an ArrayList with problemSize random elements in nearly ascending
     * order.
     *
     * @param problemSize - size of the list
     */
    public static <E extends Comparable<E>> ArrayList<E> generateNearlyAscendingArray(int problemSize) {
        ArrayList<E> list = generateAscendingArray(problemSize);
        slightlyShuffleArray(list);
        return list;
    }

    /**
     * Generates an ArrayList with problemSize random elements in a permuted order.
     *
     * @param problemSize - size of the list
     */
    public static <E extends Comparable<E>> ArrayList<E> generatePermutedArray(int problemSize) {
        ArrayList<E> list = generateAscendingArray(problemSize);
        shuffleArray(list);
        return list;
    }

    /**
     * Generates an ArrayList with problemSize random elements in descending order.
     *
     * @param problemSize - size of the list
     */
    public static <E extends Comparable<E>> ArrayList<E> generateDescendingArray(int problemSize) {
        ArrayList<E> list = generateAscendingArray(problemSize);
        for (int i = 0; i < list.size() / 2; i++) {
            E temp = list.get(i);
            list.set(i, list.get(list.size() - 1 - i));
            list.set(list.size() - 1 - i, temp);
        }
        return list;
    }

    /**
     * Generates an ArrayList with problemSize random elements in ascending order.
     *
     * @param problemSize - size of the list
     */
    @SuppressWarnings("unchecked")
    private static <E extends Comparable<E>> ArrayList<E> generateAscendingArray(int problemSize) {
        ArrayList<E> list = new ArrayList<>(problemSize);
        for (int i = 0; i < problemSize; i++) {
            list.add((E) Integer.valueOf(rng.nextInt(10 * problemSize + 20)));
        }
        Collections.sort(list);
        return list;
    }

    /**
     * Slightly shuffles the contents of the given list, such that it is in nearly
     * ascending order, by swapping a small number of random pairs of nearby
     * elements.
     *
     * @param list to be shuffled slightly
     */
    private static <E> void slightlyShuffleArray(ArrayList<E> list) {
        int swapCount = 5 + rng.nextInt(15);
        for (int i = 0; i < swapCount; i++) {
            int idx1 = rng.nextInt(list.size() - 11);
            int idx2 = idx1 + 1 + rng.nextInt(10);
            swapListElements(list, idx1, idx2);
        }
    }

    /**
     * Shuffles the contents of the given list.
     *
     * @param list to be shuffled
     */
    private static <E> void shuffleArray(ArrayList<E> list) {
        Collections.shuffle(list);
    }

    /**
     * Swaps two elements in the given list.
     *
     * @param list       with elements to be swapped
     * @param firstIndex  to swap
     * @param secondIndex to swap
     * @throws IndexOutOfBoundsException if either index is out of bounds
     */
    private static <E> void swapListElements(ArrayList<E> list, int firstIndex, int secondIndex) {
        if (firstIndex < 0 || firstIndex >= list.size() || secondIndex < 0 || secondIndex >= list.size()) {
            throw new IndexOutOfBoundsException();
        }
        E temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }
}
