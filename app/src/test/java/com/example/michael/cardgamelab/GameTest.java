package com.example.michael.cardgamelab;

/**
 * Created by michael on 07/09/2017.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class GameTest {
    Game game;
    Game bigGame;
    Player player1;
    Player player2;

    @Before
    public void before() {
        player1 = new Player("Alice");
        player2 = new Player("Michael");
        game = new Game(1, player1, player2);
        game.generateDeck();
        bigGame = new Game(2, player1, player2);
        bigGame.generateDeck();
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
        assertNotNull(player1.getCards()[0]);
    }

    @Test
    public void testPlayDealsCardsToPlayers(){
        game.play();
        assertNotEquals(player1.getCards()[0], player2.getCards()[0]);
        assertEquals(50, game.getDeck().size());
    }

    @Test
    public void testWinnerIsPlayerWithHighestCard() {
        player1.setCards(new Card(CardSuit.CLUBS, CardFace.FIVE));
        player2.setCards(new Card(CardSuit.HEARTS, CardFace.THREE));
        assertEquals(player1, game.winner());
    }

    @Test
    public void testWinnerIsNotJustFirstPlayer() {
        player1.setCards(new Card(CardSuit.DIAMONDS, CardFace.SIX));
        player2.setCards(new Card(CardSuit.SPADES, CardFace.JACK));
        assertEquals(player2, game.winner());
    }

    @Test
    public void testPlayDealsTwoCardsToPlayers(){
        bigGame.play();
        assertEquals(48, bigGame.getDeck().size());
    }

    @Test
    public void testWinnerIsPlayerWithHighestCards() {
        player1.setCards(
                new Card(CardSuit.CLUBS, CardFace.FIVE),
                new Card(CardSuit.HEARTS, CardFace.FOUR)
        );
        player2.setCards(
                new Card(CardSuit.HEARTS, CardFace.THREE),
                new Card(CardSuit.SPADES, CardFace.JACK)
        );
        assertEquals(player2, bigGame.winner());
    }

//    @Test
//    public void testCardDealtMatches(){
//        game.deal(player);
//        assertEquals();
//    }
}
