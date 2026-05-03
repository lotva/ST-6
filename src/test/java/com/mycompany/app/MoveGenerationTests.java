package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MoveGenerationTests {

    @Test
    void generateMovesAddsOnlyEmptyCellIndexes() {
        Game game = new Game();
        ArrayList<Integer> moves = new ArrayList<>();

        game.generateMoves(new char[] {
            'X', ' ', 'O',
            ' ', 'X', ' ',
            'O', ' ', 'X'
        }, moves);

        assertEquals(4, moves.size());
        assertTrue(moves.contains(1));
        assertTrue(moves.contains(3));
        assertTrue(moves.contains(5));
        assertTrue(moves.contains(7));
    }

    @Test
    void generateMovesReturnsAllCellsOnEmptyBoard() {
        Game game = new Game();
        ArrayList<Integer> moves = new ArrayList<>();

        game.generateMoves(game.board, moves);

        assertEquals(9, moves.size());
    }

    @Test
    void generateMovesReturnsEmptyListOnFullBoard() {
        Game game = new Game();
        ArrayList<Integer> moves = new ArrayList<>();

        game.generateMoves(new char[] {'X', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'X'}, moves);

        assertEquals(0, moves.size());
    }
}
