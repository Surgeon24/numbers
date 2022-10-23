package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

public class ListAggregatorTest {
    List<Integer> list1, list2, list3, list4, list5, list6, list7 = new ArrayList<>();

    @BeforeEach
    public void helper(){
        list1 = Arrays.asList(1,2,4,2,5);
        list2 = Arrays.asList(7,4,3,2,3);
        list3 = Arrays.asList(1,1,8,7,1);
        list4 = Arrays.asList(1,2,3,4,5);
        list5 = Arrays.asList(-5,-3,-1,0,1);
        list6 = Arrays.asList(0,0,0);
        list7 = Arrays.asList(3,3,3);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator();
        int sum1 = aggregator.sum(list1);
        int sum2 = aggregator.sum(list2);
        int sum3 = aggregator.sum(list3);
        int sum4 = aggregator.sum(list4);
        int sum5 = aggregator.sum(list5);
        int sum6 = aggregator.sum(list6);
        int sum7 = aggregator.sum(list7);
        Assertions.assertEquals(14, sum1);
        Assertions.assertEquals(19, sum2);
        Assertions.assertEquals(18, sum3);
        Assertions.assertEquals(15, sum4);
        Assertions.assertEquals(-8, sum5);
        Assertions.assertEquals(0, sum6);
        Assertions.assertEquals(9, sum7);

    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator();
        int max1 = aggregator.max(list1);
        int max2 = aggregator.max(list2);
        int max3 = aggregator.max(list3);
        int max4 = aggregator.max(list4);
        int max5 = aggregator.max(list5);
        int max6 = aggregator.max(list6);
        int max7 = aggregator.max(list7);
        Assertions.assertEquals(5, max1);
        Assertions.assertEquals(7, max2);
        Assertions.assertEquals(8, max3);
        Assertions.assertEquals(5, max4);
        Assertions.assertEquals(1, max5);
        Assertions.assertEquals(0, max6);
        Assertions.assertEquals(3, max7);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator();
        int min1 = aggregator.min(list1);
        int min2 = aggregator.min(list2);
        int min3 = aggregator.min(list3);
        int min4 = aggregator.min(list4);
        int min5 = aggregator.min(list5);
        int min6 = aggregator.min(list6);
        int min7 = aggregator.min(list7);
        Assertions.assertEquals(1, min1);
        Assertions.assertEquals(2, min2);
        Assertions.assertEquals(1, min3);
        Assertions.assertEquals(1, min4);
        Assertions.assertEquals(-5, min5);
        Assertions.assertEquals(0, min6);
        Assertions.assertEquals(3, min7);
    }

    @Test
    public void distinct() {
        GenericListDeduplicator dedupMockito1 =
                Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(dedupMockito1.deduplicate(Mockito.anyList(), Mockito.any())).thenReturn(Arrays.asList(1, 4, 5));

        GenericListDeduplicator dedupMockito2 =
                Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(dedupMockito2.deduplicate(Mockito.anyList(), Mockito.any())).thenReturn(Arrays.asList(2, 4, 7));

        GenericListDeduplicator dedupMockito3 =
                Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(dedupMockito3.deduplicate(Mockito.anyList(), Mockito.any())).thenReturn(Arrays.asList(7, 8));

        GenericListDeduplicator dedupMockito4 =
                Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(dedupMockito4.deduplicate(Mockito.anyList(), Mockito.any())).thenReturn(Arrays.asList(1, 2, 3, 4, 5));

        GenericListDeduplicator dedupMockito5 =
                Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(dedupMockito5.deduplicate(Mockito.anyList(), Mockito.any())).thenReturn(Arrays.asList(-5, -3, -1, 0, 1));

        GenericListDeduplicator dedupMockito6 =
                Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(dedupMockito6.deduplicate(Mockito.anyList(), Mockito.any())).thenReturn(Arrays.asList());

        GenericListDeduplicator dedupMockito7 =
                Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(dedupMockito7.deduplicate(Mockito.anyList(), Mockito.any())).thenReturn(Arrays.asList());

        ListAggregator aggregator = new ListAggregator();

        int distinct1 = aggregator.distinct(list1, dedupMockito1);
        int distinct2 = aggregator.distinct(list2, dedupMockito2);
        int distinct3 = aggregator.distinct(list3, dedupMockito3);
        int distinct4 = aggregator.distinct(list4, dedupMockito4);
        int distinct5 = aggregator.distinct(list5, dedupMockito5);
        int distinct6 = aggregator.distinct(list6, dedupMockito6);
        int distinct7 = aggregator.distinct(list7, dedupMockito7);

        Assertions.assertEquals(3, distinct1);
        Assertions.assertEquals(3, distinct2);
        Assertions.assertEquals(2, distinct3);
        Assertions.assertEquals(5, distinct4);
        Assertions.assertEquals(5, distinct5);
        Assertions.assertEquals(0, distinct6);
        Assertions.assertEquals(0, distinct7);
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
        ListDeduplicator deduplicator = new ListDeduplicator();
        int distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2), deduplicator);
        Assertions.assertEquals(3, distinct);
    }
}
