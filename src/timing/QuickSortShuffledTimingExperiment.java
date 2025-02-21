package assign05;
import java.util.ArrayList;

import timing.ArrayListGenerator;
import timing.TimingExperiment;

public class QuickSortShuffledTimingExperiment extends TimingExperiment {
	protected ArrayList<Integer> unsortedArray;
    private RandomPivotChooser<Integer> randomPivotChooser = new RandomPivotChooser<Integer>();
    private FirstPivotChooser<Integer> firstPivotChooser = new FirstPivotChooser<Integer>();
    private MedianOfThreePivotChooser<Integer> medianOfThreePivotChooser = new MedianOfThreePivotChooser<Integer>();
    private static String problemSizeDescription = "Insertion Sort Average Case";
    private static int problemSizeMin = 1000;
    private static int problemSizeCount = 20;
    private static int problemSizeStep = 1000;
    private static int experimentIterationCount = 50;

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
        QuickSorter<Integer> sorter = new QuickSorter<>(medianOfThreePivotChooser);
        sorter.sort(unsortedArray);
    }



}