package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {
    @Test
    public void accept(){
        PositiveFilter f = new PositiveFilter();
        Assertions.assertTrue(f.accept(2));
        Assertions.assertTrue(f.accept(10));
        Assertions.assertFalse(f.accept(0));
        Assertions.assertFalse(f.accept(-2));
    }
}
