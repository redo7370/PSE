package test;

import org.junit.Test;

import main.data.PeriodicTable;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Scanner;

// Nur AssertEquals wird im Bash Skript berücksichtigt

public class PSETest {

    @Test
    public void testGetElementColor() {
        Color color = PeriodicTable.getElementColor("Mg");

        assertEquals(new Color(152, 173, 121), color);
    }

}