package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GameStateDetectionTests {

    @Test
    void checkStateDetectsXWinInAllPossibleLines() {
        Game game = new Game();
        game.symbol = 'X';

        char[][] winningBoards = {
            {'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X'},
            {'X', ' ', ' ', 'X', ' ', ' ', 'X', ' ', ' '},
            {' ', 'X', ' ', ' ', 'X', ' ', ' ', 'X', ' '},
            {' ', ' ', 'X', ' ', ' ', 'X', ' ', ' ', 'X'},
            {'X', ' ', ' ', ' ', 'X', ' ', ' ', ' ', 'X'},
            {' ', ' ', 'X', ' ', 'X', ' ', 'X', ' ', ' '}
        };

        for (char[] board : winningBoards) {
            assertEquals(State.XWIN, game.checkState(board));
        }
    }

    @Test
    void checkStateDetectsOWinInDiagonal() {
        Game game = new Game();
        game.symbol = 'O';
        char[] board = {'O', ' ', 'X', 'X', 'O', ' ', ' ', ' ', 'O'};

        assertEquals(State.OWIN, game.checkState(board));
    }

    @Test
    void checkStateDistinguishesPlayingFromDraw() {
        Game game = new Game();
        game.symbol = 'X';

        assertEquals(State.PLAYING, game.checkState(new char[] {
            'X', 'O', 'X',
            'O', 'X', 'O',
            'O', 'X', ' '
        }));
        assertEquals(State.DRAW, game.checkState(new char[] {
            'X', 'O', 'X',
            'X', 'O', 'O',
            'O', 'X', 'X'
        }));
    }

    @Test
    void stateEnumContainsAllRequiredValues() {
        assertEquals(4, State.values().length);
        assertEquals(State.PLAYING, State.valueOf("PLAYING"));
        assertEquals(State.XWIN, State.valueOf("XWIN"));
        assertEquals(State.OWIN, State.valueOf("OWIN"));
        assertEquals(State.DRAW, State.valueOf("DRAW"));
    }
}
