package com.example.michael.cardgamelab;

/**
 * Created by michael on 07/09/2017.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player player;
    Card card;

    @Before
    public void before(){
        player = new Player("Michael");
        card = new Card(CardSuit.DIAMONDS, CardFace.TWO);
    }

    @Test
    public void testPlayerName(){
        assertEquals("Michael", player.getName());
    }

    @Test
    public void testSetAndGetCard() {
        player.setCards(card);
        assertEquals(card, player.getCards()[0]);
    }
}
