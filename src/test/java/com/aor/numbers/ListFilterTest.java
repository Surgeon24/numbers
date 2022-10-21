package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFilterTest {
    @Test
    public void filter(){
        List<Integer> l1, l2;
        l1 = Arrays.asList(1,2,3,4,5);
        l2 = Arrays.asList(-1,-2,-3,-4,0);

        GenericListFilter filterMockitoTrue =
                Mockito.mock(GenericListFilter.class);
        Mockito.when(filterMockitoTrue.accept(Mockito.anyInt())).thenReturn(true);
        GenericListFilter filterMockitoFalse =
                Mockito.mock(GenericListFilter.class);
        Mockito.when(filterMockitoFalse.accept(Mockito.anyInt())).thenReturn(false);

        ListFilter fTrue = new ListFilter(filterMockitoTrue);
        ListFilter fFalse = new ListFilter(filterMockitoFalse);

        Assertions.assertEquals(l1, fTrue.filter(l1));
        Assertions.assertTrue(fFalse.filter(l2).isEmpty());
    }
}
