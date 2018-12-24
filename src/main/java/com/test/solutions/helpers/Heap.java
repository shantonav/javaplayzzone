package com.test.solutions.helpers;

import java.util.List;

public abstract class Heap<T> {

    private List<T> elements;

    public Heap(List<T> elements){
        this.elements = elements;
    }

    public void addElement(T element){
        elements.add(element);
    }

    public boolean isEmpty(){
        return elements.isEmpty();
    }

    public int parentIndex(int index){
        return (index-1)/2;
    }

    public int leftChildIndex(int index){
        return (2*index +1);
    }

    public int rightChildIndex(int index){
        return (2*index+2);
    }

    public int sizeOfHeap(){
        return elements.size();
    }
    public T getAnElement(int index){
        return elements.get(index);
    }
    public void heapify(int index) {
        int parentIndex = parentIndex(index);
        if (parentIndex >= 0){
            pushDown(parentIndex);
            heapify(parentIndex);
        }
    }

    protected void pushDown(int index){
        int leftChildIndex;
        int rightChildIndex;
        do{
            leftChildIndex = leftChildIndex(index);
            rightChildIndex = rightChildIndex(index);
            if (swap(index,leftChildIndex)){
                index = leftChildIndex;
            }

            if (swap(index,rightChildIndex)){
                index = rightChildIndex;
            }
        }while (leftChildIndex < sizeOfHeap() && rightChildIndex < sizeOfHeap());
    }

    protected void doTheSwap(int parentIndex , int childIndex){
        T elementAtParentIndex = getAnElement(parentIndex);
        T elementAtChildIndex = getAnElement(childIndex);
        elements.set(childIndex,elementAtParentIndex);
        elements.set(parentIndex,elementAtChildIndex);
    }

    abstract public boolean  swap(int parentIndex , int childIndex);

    public List<T> getHeap(){
        return this.elements;
    }

}
