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
        list1 = Arrays.asList(1,2,4,2,5);
        list2 = Arrays.asList(7,7,3,2,7);
        list3 = Arrays.asList(1,2,5,4,3);
    }

    @Test
    public void deduplicate() {
        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct1 = deduplicator.deduplicate(list1);
        List<Integer> distinct2 = deduplicator.deduplicate(list2);
        List<Integer> distinct3 = deduplicator.deduplicate(list3);

        Assertions.assertEquals(Arrays.asList(1,2,4,5), distinct1);
        Assertions.assertEquals(Arrays.asList(2,3,7), distinct2);
        Assertions.assertEquals(Arrays.asList(1,2,3,4,5), distinct3);
    }
}
