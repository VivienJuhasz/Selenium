package hu.masterfield.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Feladat01 {

    @Test
    public void testFeladat01() {
        String expected = "JUnit Jupiter is working.";
        String actual = "JUnit Jupiter is working.";
        assertEquals(expected, actual);
    }
}

