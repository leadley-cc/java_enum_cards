package com.example.michael.cardgamelab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by michael on 07/09/2017.
 */

public class CardTest {
    Card card;

    @Before
    public void before() {
        card = new Card(CardSuit.SPADES, CardFace.ACE);
    }

    @Test
    public void hasSuit() {
        assertEquals(CardSuit.SPADES, card.getSuit());
    }

    @Test
    public void hasFace() {
        assertEquals(CardFace.ACE, card.getFace());
    }
}
