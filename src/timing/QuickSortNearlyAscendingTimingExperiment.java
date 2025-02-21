package assign05;
import timing.ArrayListGenerator;
import timing.TimingExperiment;

import java.util.ArrayList;

public class QuickSortNearlyAscendingTimingExperiment extends TimingExperiment {
	protected ArrayList<Integer> unsortedArray;
    private FirstPivotChooser<Integer> medianOfThreePivotChooser = new FirstPivotChooser<Integer>();
    private static String problemSizeDescription = "Insertion Sort Average Case";
    private static int problemSizeMin = 1000;
    private static int problemSizeCount = 20;
    private static int problemSizeStep = 1000;
    private static int experimentIterationCount = 50;


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
   	 QuickSorter<Integer> sorter = new QuickSorter<>(medianOfThreePivotChooser);
     sorter.sort(unsortedArray);
    }



}