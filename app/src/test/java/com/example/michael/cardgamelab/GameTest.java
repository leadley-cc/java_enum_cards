package com.example.michael.cardgamelab;

/**
 * Created by michael on 07/09/2017.
 */

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class GameTest {
    Game game;
//    Game spyGame;
    Player player1;
    Player player2;

    @Before
    public void before() {
//        spyGame = Mockito.spy(game);
        player1 = new Player("Alice");
        player2 = new Player("Michael");
        game = new Game(player1, player2);
        game.generateDeck();
    }

    @Test
    public void testPlayersHasCorrectLength() {
        assertEquals(2, game.getPlayers().length);
    }

    @Test
    public void testGameHas52Cards() {
        assertEquals(52, game.getDeck().size());
    }

    @Test
    public void testDealingRemovesCard() {
        game.deal(player1);
        assertEquals(51, game.getDeck().size());
    }

    @Test
    public void testDealingGivesPlayerCard() {
        game.deal(player1);
        assertNotNull(player1.getCard());
    }

    @Test
    public void testPlayDealsCardsToPlayers(){
        game.play();
        assertNotEquals(player1.getCard(), player2.getCard());
        assertEquals(50, game.getDeck().size());
    }

    @Test
    public void testWinnerIsPlayerWithHighestCard() {
        player1.setCard(new Card(CardSuit.CLUBS, CardFace.FIVE));
        player2.setCard(new Card(CardSuit.HEARTS, CardFace.THREE));
        assertEquals(player1, game.winner());
    }

    @Test
    public void testWinnerIsNotJustFirstPlayer() {
        player1.setCard(new Card(CardSuit.DIAMONDS, CardFace.SIX));
        player2.setCard(new Card(CardSuit.SPADES, CardFace.JACK));
        assertEquals(player2, game.winner());
    }

//    @Test
//    public void testCardDealtMatches(){
//        game.deal(player);
//        assertEquals();
//    }
}
