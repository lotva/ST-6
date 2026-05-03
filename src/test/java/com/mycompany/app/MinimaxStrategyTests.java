package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MinimaxStrategyTests {

    @Test
    void miniMaxChoosesImmediateWinningMoveAndRestoresBoard() {
        Game game = new Game();
        char[] board = {
            'O', 'O', ' ',
            'X', 'X', ' ',
            ' ', ' ', ' '
        };
        char[] original = board.clone();

        int move = game.MiniMax(board, game.player2);

        assertEquals(3, move);
        assertArrayEquals(original, board);
        assertEquals(0, game.q);
    }

    @Test
    void miniMaxBlocksOpponentWinningMove() {
        Game game = new Game();
        char[] board = {
            'O', 'X', 'X',
            'X', ' ', ' ',
            'O', 'O', 'X'
        };

        int move = game.MiniMax(board, game.player2);

        assertEquals(6, move);
    }

    @Test
    void minAndMaxMoveReturnTerminalScoresWithoutChangingBoard() {
        Game game = new Game();
        char[] board = {'O', 'O', 'O', 'X', 'X', ' ', ' ', ' ', ' '};
        char[] original = board.clone();

        game.symbol = 'O';

        assertEquals(Game.INF, game.MinMove(board, game.player2));
        assertEquals(Game.INF, game.MaxMove(board, game.player2));
        assertArrayEquals(original, board);
    }

    @Test
    void miniMaxHandlesCenterOpening() {
        Game game = new Game();
        char[] board = {
            ' ', ' ', ' ',
            ' ', 'X', ' ',
            ' ', ' ', ' '
        };

        int move = game.MiniMax(board, game.player2);

        assertTrue(move > 0 && move <= 9);
    }
}
