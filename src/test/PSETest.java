package test;

import org.junit.Test;

import main.data.PeriodicTable;

import static org.junit.Assert.*;

import java.awt.Color;

// Nur AssertEquals wird im Bash Skript berücksichtigt

public class PSETest {

    @Test
    public void testGetElementColor() {
        Color color = PeriodicTable.getElementColor("Mg");
        assertArrayEquals(new int[] {152, 173, 121}, new int[] { color.getRed(), color.getGreen(), color.getBlue() });
    }

}