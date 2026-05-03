package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PositionEvaluationTests {

    @Test
    void evaluatePositionScoresWinLossDrawAndOngoingGame() {
        Game game = new Game();
        char[] xWin = {'X', 'X', 'X', 'O', 'O', ' ', ' ', ' ', ' '};
        char[] draw = {'X', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'X'};
        char[] ongoing = {'X', 'O', 'X', ' ', 'O', ' ', ' ', ' ', ' '};

        game.symbol = 'X';
        assertEquals(Game.INF, game.evaluatePosition(xWin, game.player1));
        assertEquals(-Game.INF, game.evaluatePosition(xWin, game.player2));
        assertEquals(0, game.evaluatePosition(draw, game.player1));
        assertEquals(-1, game.evaluatePosition(ongoing, game.player1));
    }

    @Test
    void evaluatePositionReturnsCorrectScoreForOWin() {
        Game game = new Game();
        char[] oWin = {'O', 'O', 'O', 'X', 'X', ' ', ' ', ' ', ' '};
        game.symbol = 'O';

        assertEquals(Game.INF, game.evaluatePosition(oWin, game.player2));
    }
}
