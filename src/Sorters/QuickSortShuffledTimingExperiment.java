package Sorters;
import timing.ArrayListGenerator;
import timing.TimingExperiment;

import java.util.ArrayList;

public class QuickSortShuffledTimingExperiment extends TimingExperiment {
    private ArrayList<Integer> unsortedArray;
    private static String problemSizeDescription = "Insertion Sort Average Case";
    private static int problemSizeMin = 1000;
    private static int problemSizeCount = 25;
    private static int problemSizeStep = 1000;
    private static int experimentIterationCount = 20;
    private RandomPivotChooser<Integer> randomPivotChooser = new RandomPivotChooser();
    private FirstPivotChooser<Integer> firstPivotChooser = new FirstPivotChooser();
    private MedianOfThreePivotChooser<Integer> medianOfThreePivotChooser = new MedianOfThreePivotChooser();


    public QuickSortShuffledTimingExperiment() {
        super(problemSizeDescription, problemSizeMin, problemSizeCount, problemSizeStep, experimentIterationCount);
    }


    public static void main(String[] args) {
        TimingExperiment timingExperiment = new QuickSortShuffledTimingExperiment();
        System.out.println("\n---Computing timing results---\n");
        timingExperiment.printResults();
    }



    /**
     * @param problemSize - the problem size for one experiment
     */
    @Override
    protected void setupExperiment(int problemSize) {
        unsortedArray = ArrayListGenerator.generatePermutedArray(problemSize);
    }

    /**
     *
     */
    @Override
    protected void runComputation() {
        QuickSorter<Integer> sorter = new QuickSorter<>(randomPivotChooser);
        sorter.sort(unsortedArray);
//        QuickSorter<Integer> sorter = new QuickSorter<>(firstPivotChooser);
//        sorter.sort(unsortedArray);
//        QuickSorter<Integer> sorter = new QuickSorter<>(medianOfThreePivotChooser);
//        sorter.sort(unsortedArray);
    }



}