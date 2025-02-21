package assign05;
import java.util.ArrayList;

import timing.ArrayListGenerator;
import timing.TimingExperiment;

public class QuickSortDescendingTimingExperiment extends TimingExperiment {
	protected ArrayList<Integer> unsortedArray;
    private FirstPivotChooser<Integer> randomPivotChooser = new FirstPivotChooser<Integer>();
    private static String problemSizeDescription = "Quick Sort Worst Case";
    private static int problemSizeMin = 1000;
    private static int problemSizeCount = 20;
    private static int problemSizeStep = 1000;
    private static int experimentIterationCount = 50;


    public static void main(String[] args) {
        TimingExperiment timingExperiment = new QuickSortDescendingTimingExperiment();
        System.out.println("\n---Computing timing results---\n");
        timingExperiment.printResults();
    }

    public QuickSortDescendingTimingExperiment(){
        super(problemSizeDescription, problemSizeMin, problemSizeCount, problemSizeStep, experimentIterationCount);
    }


    /**
     * @param problemSize - the problem size for one experiment
     */
    @Override
    protected void setupExperiment(int problemSize) {
    	unsortedArray = ArrayListGenerator.generateDescendingArray(problemSize);
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