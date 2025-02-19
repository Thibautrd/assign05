package Sorters;
import timing.ArrayListGenerator;
import timing.TimingExperiment;

import java.util.ArrayList;

public class QuickSortNearlyAscendingTimingExperiment extends TimingExperiment {
    private ArrayList<Integer> unsortedArray;
    private static String problemSizeDescription = "Insertion Sort Average Case";
    private static int problemSizeMin = 1000;
    private static int problemSizeCount = 25;
    private static int problemSizeStep = 1000;
    private static int experimentIterationCount = 20;
    private RandomPivotChooser<Integer> randomPivotChooser = new RandomPivotChooser();


    public static void main(String[] args) {
        TimingExperiment timingExperiment = new QuickSortNearlyAscendingTimingExperiment();
        System.out.println("\n---Computing timing results---\n");
        timingExperiment.printResults();
    }

    public QuickSortNearlyAscendingTimingExperiment(){
        super(problemSizeDescription, problemSizeMin, problemSizeCount, problemSizeStep, experimentIterationCount);
    }


    /**
     * @param problemSize - the problem size for one experiment
     */
    @Override
    protected void setupExperiment(int problemSize) {
        unsortedArray = ArrayListGenerator.generateNearlyAscendingArray(problemSize);
    }

    /**
     *
     */
    @Override
    protected void runComputation() {
        QuickSorter<Integer> sorter = new QuickSorter<>(randomPivotChooser);
        sorter.sort(unsortedArray);

    }



}