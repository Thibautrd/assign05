package assign05;

import java.util.ArrayList;

public class MedianOfThreePivotChooser <E extends Comparable<? super E>> implements PivotChooser<E> {

    @Override
    public int getPivotIndex(ArrayList<E> list, int leftIndex, int rightIndex) {
        int mid = leftIndex + (rightIndex - leftIndex) / 2;
        E a = list.get(leftIndex);
        E b = list.get(mid);
        E c = list.get(rightIndex);

        if ((a.compareTo(b) > 0) == (a.compareTo(c) < 0)) {
            return leftIndex;
        } else if ((b.compareTo(a) > 0) == (b.compareTo(c) < 0)) {
            return mid;
        } else
            return rightIndex;
    }

}