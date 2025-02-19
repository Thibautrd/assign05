package Sorters;

import java.util.ArrayList;
import java.util.Random;

public class RandomPivotChooser<E extends Comparable<? super E>> implements PivotChooser<E> {
    @Override
    public int getPivotIndex(ArrayList<E> list, int leftIndex, int rightIndex) {
        Random random = new Random();
        return random.nextInt(leftIndex, rightIndex) ;
    }
}
