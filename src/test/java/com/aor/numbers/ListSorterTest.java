package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ListSorterTest {
    List<Integer> list1, list2, list3= new ArrayList<>();

    @BeforeEach
    public void helper(){
        list1 = Arrays.asList(1,2,4,2);
        list2 = Arrays.asList(7,6,4,3,1,1,1);
        list3 = Arrays.asList(1,3,2,4,9);
    }

    @Test
    void sort() {
        ListSorter sorter = new ListSorter();
        List<Integer> sorted1 = sorter.sort(list1);
        List<Integer> sorted2 = sorter.sort(list2);
        List<Integer> sorted3 = sorter.sort(list3);

        Assertions.assertEquals(Arrays.asList(1,2,2,4), sorted1);
        Assertions.assertEquals(Arrays.asList(1,1,1,3,4,6,7), sorted2);
        Assertions.assertEquals(Arrays.asList(1,2,3,4,9), sorted3);
    }
}
