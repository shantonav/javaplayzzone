package com.test.solutions.helpers;

import java.util.List;

public class BinaryMinHeap extends Heap <Integer> {
    public BinaryMinHeap(List<Integer> elements) {
        super(elements);
    }


    public boolean  swap(int parentIndex, int childIndex) {
        boolean swapped = false;
        if (getAnElement(parentIndex).compareTo(getAnElement(childIndex)) > 0){
            doTheSwap(parentIndex,childIndex);
            swapped = true;
        }
        return swapped;
    }
}
