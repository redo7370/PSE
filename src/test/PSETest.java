package test;

import org.junit.Test;
import static org.junit.Assert.*;

// Nur AssertEquals wird im Bash Skript berücksichtigt

public class PSETest {

    @Test
    public void testSomething() {
        assertEquals(2, 1);
    }

    @Test
    public void tesstSomething() {
        assertEquals(546546451, 324324321);
    }

    @Test
    public void tesstsSomething() {
        assertEquals(1324324, 234324322);
    }

    @Test
    public void tesstsSomehing() {
        assertEquals(1323, 2);
    }

    @Test
    public void tesstswSomehing() {
        assertEquals(1323, 6456452);
    }

    @Test
    public void tesswtsSomehing() {
        assertEquals(1323, 56456542);
    }

    @Test
    public void tesstscSomehing() {
        assertEquals(1323, 2);
    }

    @Test
    public void tesstsSaomehing() {
        assertEquals(1323, 2);
    }

    @Test
    public void tesstsdSomehing() {
        assertEquals(1323, 54654652);
    }
}