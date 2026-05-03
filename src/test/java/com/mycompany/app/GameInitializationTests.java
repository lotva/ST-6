package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GameInitializationTests {

    @Test
    void gameStartsWithEmptyBoardAndCorrectPlayers() {
        Game game = new Game();

        assertEquals(State.PLAYING, game.state);
        assertEquals('X', game.player1.symbol);
        assertEquals('O', game.player2.symbol);
        assertEquals(9, game.board.length);
        assertArrayEquals(new char[] {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, game.board);
    }

    @Test
    void playerFieldsCanBeSetIndependently() {
        Player player = new Player();
        player.symbol = 'X';
        player.move = 5;
        player.selected = true;
        player.win = false;

        assertEquals('X', player.symbol);
        assertEquals(5, player.move);
    }

    @Test
    void programCanBeInstantiated() {
        Program program = new Program();
        assertEquals(Program.class, program.getClass());
    }
}
