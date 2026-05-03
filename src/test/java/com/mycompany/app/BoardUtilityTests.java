package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class BoardUtilityTests {

    @Test
    void utilityPrintsCharIntAndMoveBoards() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        try {
            Utility.print(new char[] {'X', 'O', ' ', ' ', 'X', ' ', 'O', ' ', 'X'});
            Utility.print(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
            Utility.print(new ArrayList<Integer>(Arrays.asList(0, 4, 8)));
        } finally {
            System.setOut(originalOut);
        }

        String result = output.toString();
        assertTrue(result.contains("X-O- - -X- -O- -X-"));
        assertTrue(result.contains("1-2-3-4-5-6-7-8-9-"));
        assertTrue(result.contains("0-4-8-"));
    }

    @Test
    void utilityHandlesEmptyArrayList() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        try {
            Utility.print(new ArrayList<Integer>());
        } finally {
            System.setOut(originalOut);
        }

        assertTrue(output.toString().contains(System.lineSeparator()));
    }
}
