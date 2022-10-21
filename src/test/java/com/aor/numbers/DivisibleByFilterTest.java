package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {
    @Test
    public void accept(){
        DivisibleByFilter f2 = new DivisibleByFilter(2);
        DivisibleByFilter f5 = new DivisibleByFilter(5);
        Assertions.assertTrue(f2.accept(16));
        Assertions.assertFalse(f2.accept(15));
        Assertions.assertTrue(f5.accept(0));
        Assertions.assertFalse(f5.accept(7));
    }
}
