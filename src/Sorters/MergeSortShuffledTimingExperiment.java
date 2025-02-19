package Sorters;
import java.util.ArrayList;

import timing.ArrayListGenerator;
import timing.TimingExperiment;

public class MergeSortShuffledTimingExperiment extends TimingExperiment {
    private ArrayList<Integer> unsortedArray;
    private static String problemSizeDescription = "Insertion Sort Average Case";
    private static int problemSizeMin = 1000;
    private static int problemSizeCount = 25;
    private static int problemSizeStep = 1000;
    private static int experimentIterationCount = 20;

    public MergeSortShuffledTimingExperiment() {
        super(problemSizeDescription, problemSizeMin, problemSizeCount, problemSizeStep, experimentIterationCount);
    }


    public static void main(String[] args) {
        TimingExperiment timingExperiment = new MergeSortShuffledTimingExperiment();
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
        MergeSorter<Integer> mergeSorter = new MergeSorter<>(2);
        mergeSorter.sort(unsortedArray);
    }



}