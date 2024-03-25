package org.monta.kata.tennis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleMatchTest {

    SimpleMatch simpleMatch = new SimpleMatch(new Player(0,0), new Player(0,0));

    @Test
    void should_playerA_be_the_winner_when_in_deuce_match_ABABABBAAA(){
        simpleMatch.of("ABABABBAAA");

        Player expectedWinner =  new Player(40,2);

        assertEquals(expectedWinner, simpleMatch.getPlayerA());
    }

    @Test
    void should_playerA_be_the_winner_when_match_is_ABABAA(){
        simpleMatch.of("ABABAA");

        assertTrue(simpleMatch.getPlayerA().getScore() > 40);
    }
}
