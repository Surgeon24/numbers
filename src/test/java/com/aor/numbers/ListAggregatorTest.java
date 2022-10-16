package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ListAggregatorTest {
    List<Integer> list1, list2, list3, list4 = new ArrayList<>();

    @BeforeEach
    public void helper(){
        list1 = Arrays.asList(1,2,4,2,5);
        list2 = Arrays.asList(7,4,3,2,3);
        list3 = Arrays.asList(1,1,8,7,1);
        list4 = Arrays.asList(1,2,3,4,5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator();
        int sum1 = aggregator.sum(list1);
        int sum2 = aggregator.sum(list2);
        int sum3 = aggregator.sum(list3);
        int sum4 = aggregator.sum(list4);
        Assertions.assertEquals(14, sum1);
        Assertions.assertEquals(19, sum2);
        Assertions.assertEquals(18, sum3);
        Assertions.assertEquals(15, sum4);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator();
        int max1 = aggregator.max(list1);
        int max2 = aggregator.max(list2);
        int max3 = aggregator.max(list3);
        int max4 = aggregator.max(list4);
        Assertions.assertEquals(5, max1);
        Assertions.assertEquals(7, max2);
        Assertions.assertEquals(8, max3);
        Assertions.assertEquals(5, max4);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator();
        int min1 = aggregator.min(list1);
        int min2 = aggregator.min(list2);
        int min3 = aggregator.min(list3);
        int min4 = aggregator.min(list4);
        Assertions.assertEquals(1, min1);
        Assertions.assertEquals(2, min2);
        Assertions.assertEquals(1, min3);
        Assertions.assertEquals(1, min4);
    }

    @Test
    public void distinct() {
        ListAggregator aggregator = new ListAggregator();
        int distinct1 = aggregator.distinct(list1);
        int distinct2 = aggregator.distinct(list2);
        int distinct3 = aggregator.distinct(list3);
        int distinct4 = aggregator.distinct(list4);
        Assertions.assertEquals(4, distinct1);
        Assertions.assertEquals(4, distinct2);
        Assertions.assertEquals(3, distinct3);
        Assertions.assertEquals(5, distinct4);
    }

    @Test
    public void max_bug_7263(){
        ListAggregator aggregator = new ListAggregator();
        List<Integer> list = Arrays.asList(-1,-4,-5);
        int max = aggregator.max(list);
        Assertions.assertEquals(-1, max);
    }

    @Test
    public void distinct_bug_8726(){
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2));
        //ListAggregator aggregator = new ListAggregator();
        //List<Integer> list = Arrays.asList(1,2,4,2);
        //int distinct = aggregator.distinct(list);
        Assertions.assertEquals(3, distinct);
    }
}
