package test.com.solutions;

import com.test.solutions.helpers.BinaryMinHeap;
import com.test.solutions.helpers.Heap;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestBinaryMinHeap {
    @Ignore
    @Test
    public void testBinaryMinHeapification(){
        List<Integer> elements = Arrays.asList(3,4,5,1,2);

        Heap<Integer> minHeap = new BinaryMinHeap(elements);

        minHeap.heapify(elements.size()-1);

        List<Integer> expectedHeap = Arrays.asList(1,2,5,4,3);

        Assert.assertArrayEquals(expectedHeap.toArray(),minHeap.getHeap().toArray());

    }
}
