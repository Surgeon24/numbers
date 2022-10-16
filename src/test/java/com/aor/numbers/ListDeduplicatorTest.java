package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListDeduplicatorTest {
    List<Integer> list1, list2, list3= new ArrayList<>();

    @BeforeEach
    public void helper(){
        list1 = Arrays.asList(1,2,4,2);
        list2 = Arrays.asList(7,7,3,2,7);
        list3 = Arrays.asList(1,2,5,4,3);
    }

    @Test
    public void deduplicate() {
        class Stub1 implements GenericListSorter {
            public List<Integer> sort(List<Integer> list){
                return Arrays.asList(1,2,2,4);
            }
        }
        class Stub2 implements GenericListSorter {
            public List<Integer> sort(List<Integer> list){
                return Arrays.asList(2,3,7,7,7);
            }
        }
        class Stub3 implements GenericListSorter {
            public List<Integer> sort(List<Integer> list){
                return Arrays.asList(1,2,3,4,5);
            }
        }

        ListDeduplicator deduplicator = new ListDeduplicator();
        GenericListSorter sort1 = new Stub1();
        GenericListSorter sort2 = new Stub2();
        GenericListSorter sort3 = new Stub3();

        List<Integer> distinct1 = deduplicator.deduplicate(list1, sort1);
        List<Integer> distinct2 = deduplicator.deduplicate(list2, sort2);
        List<Integer> distinct3 = deduplicator.deduplicate(list3, sort3);

        Assertions.assertEquals(Arrays.asList(1,2,4), distinct1);
        Assertions.assertEquals(Arrays.asList(2,3,7), distinct2);
        Assertions.assertEquals(Arrays.asList(1,2,3,4,5), distinct3);
    }
}
