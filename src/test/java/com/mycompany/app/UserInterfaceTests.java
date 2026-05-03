package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import org.junit.jupiter.api.Test;

public class UserInterfaceTests {

    @Test
    void ticTacToeCellStoresCoordinatesNumberAndMarker() {
        TicTacToeCell cell = new TicTacToeCell(4, 1, 2);

        assertEquals(4, cell.getNum());
        assertEquals(1, cell.getCol());
        assertEquals(2, cell.getRow());
        assertEquals(' ', cell.getMarker());
        assertEquals(" ", cell.getText());
        assertEquals("Arial", cell.getFont().getName());
        assertEquals(Font.PLAIN, cell.getFont().getStyle());
        assertEquals(40, cell.getFont().getSize());

        cell.setMarker("X");

        assertEquals('X', cell.getMarker());
        assertEquals("X", cell.getText());
        assertFalse(cell.isEnabled());
    }

    @Test
    void ticTacToePanelCreatesNineCellsWithExpectedPositions() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3, 3));

        assertEquals(9, panel.getComponentCount());
        for (int i = 0; i < 9; i++) {
            TicTacToeCell cell = (TicTacToeCell) panel.getComponent(i);
            assertEquals(i, cell.getNum());
            assertEquals(i % 3, cell.getCol());
            assertEquals(i / 3, cell.getRow());
            assertEquals(' ', cell.getMarker());
        }
    }

    @Test
    void ticTacToePanelProcessesFirstClick() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3, 3));
        
        TicTacToeCell firstCell = (TicTacToeCell) panel.getComponent(0);
        ActionEvent event = new ActionEvent(firstCell, ActionEvent.ACTION_PERFORMED, "");
        panel.actionPerformed(event);

        assertEquals('X', firstCell.getMarker());

        boolean hasO = false;
        for (int i = 0; i < 9; i++) {
            TicTacToeCell cell = (TicTacToeCell) panel.getComponent(i);
            if (cell.getMarker() == 'O') {
                hasO = true;
                break;
            }
        }
        assertTrue(hasO);
    }
}
