package assign05;

import java.util.ArrayList;

import timing.ArrayListGenerator;
import timing.TimingExperiment;

public class MergeSortDescendingTimingExperiment extends TimingExperiment {
	protected ArrayList<Integer> unsortedArray = new ArrayList<>();
    private static String problemSizeDescription = "Insertion Sort Average Case";
    private static int problemSizeMin = 1000;
    private static int problemSizeCount = 20;
    private static int problemSizeStep = 1000;
    private static int experimentIterationCount = 50;

    public MergeSortDescendingTimingExperiment() {
        super(problemSizeDescription, problemSizeMin, problemSizeCount, problemSizeStep, experimentIterationCount);
    }


    public static void main(String[] args) {
        TimingExperiment timingExperiment = new MergeSortDescendingTimingExperiment();
        System.out.println("\n---Computing timing results---\n");
        timingExperiment.printResults();
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
    	MergeSorter<Integer> mergeSorter = new MergeSorter<>(10);
        mergeSorter.sort(unsortedArray);
    }



}