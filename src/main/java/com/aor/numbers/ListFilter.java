package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilter {
    GenericListFilter filter;

    public ListFilter(GenericListFilter filter) {
        this.filter = filter;
    }
    public List<Integer> filter(List<Integer> list){
        List<Integer> out = new ArrayList<>();
        for (Integer i : list){
            if (filter.accept(i)) {
                out.add(i);
            }
        }
        return out;
    }
}
