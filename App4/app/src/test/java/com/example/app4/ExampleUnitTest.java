package com.example.app4;

import com.example.util.Calc;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void calc_addition_isCorrect() {
        Calc calc = new Calc();
        int result = calc.add(2, 2);
        assertEquals(4, 2 + 2);
    }
}