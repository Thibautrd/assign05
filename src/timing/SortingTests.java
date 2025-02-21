package assign05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SortingTests {
    private RandomPivotChooser<Integer> randomPivotChooser = new RandomPivotChooser<Integer>();
    private FirstPivotChooser<Integer> firstPivotChooser = new FirstPivotChooser<Integer>();
    private MedianOfThreePivotChooser<Integer> medianOfThreePivotChooser = new MedianOfThreePivotChooser<Integer>();
    private MergeSorter<Integer> mergeSorter;
    private QuickSorter<Integer> quickSorter;
    private ArrayList<Integer> testList;

    @BeforeEach
    void setUp() {
        mergeSorter = new MergeSorter<>(5); // Arbitrary threshold
        quickSorter = new QuickSorter<>(medianOfThreePivotChooser);
        testList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2, 7, 4, 6));
    }

    @Test
    void testMergeSort_SortedOrder() {
        ArrayList<Integer> sortedList = new ArrayList<>(testList);
        mergeSorter.sort(sortedList);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), sortedList);
    }

    @Test
    void testQuickSort_SortedOrder() {
        ArrayList<Integer> sortedList = new ArrayList<>(testList);
        quickSorter.sort(sortedList);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), sortedList);
    }

    @Test
    void testMergeSort_EmptyList() {
        ArrayList<Integer> emptyList = new ArrayList<>();
        mergeSorter.sort(emptyList);
        assertTrue(emptyList.isEmpty());
    }

    @Test
    void testQuickSort_EmptyList() {
        ArrayList<Integer> emptyList = new ArrayList<>();
        quickSorter.sort(emptyList);
        assertTrue(emptyList.isEmpty());
    }

    @Test
    void testMergeSort_SingleElement() {
        ArrayList<Integer> singleList = new ArrayList<>(Arrays.asList(42));
        mergeSorter.sort(singleList);
        assertEquals(Arrays.asList(42), singleList);
    }

    @Test
    void testQuickSort_SingleElement() {
        ArrayList<Integer> singleList = new ArrayList<>(Arrays.asList(42));
        quickSorter.sort(singleList);
        assertEquals(Arrays.asList(42), singleList);
    }

    @Test
    void testMergeSort_LargeRandomList() {
        ArrayList<Integer> largeList = generateRandomList(1000);
        ArrayList<Integer> expectedList = new ArrayList<>(largeList);
        mergeSorter.sort(largeList);
        expectedList.sort(Integer::compareTo);
        assertEquals(expectedList, largeList);
    }

    @Test
    void testQuickSort_LargeRandomList() {
        ArrayList<Integer> largeList = generateRandomList(1000);
        ArrayList<Integer> expectedList = new ArrayList<>(largeList);
        quickSorter.sort(largeList);
        expectedList.sort(Integer::compareTo);
        assertEquals(expectedList, largeList);
    }

    private ArrayList<Integer> generateRandomList(int size) {
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(10000)); // Random values from 0 to 9999
        }
        return list;
    }
}
