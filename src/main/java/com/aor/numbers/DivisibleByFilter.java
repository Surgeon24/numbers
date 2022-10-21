package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{

    public DivisibleByFilter(Integer dev) {
        this.dev = dev;
    }
    int dev = 1;

    public boolean accept(Integer number) {
        return number % dev == 0;
    }
}
