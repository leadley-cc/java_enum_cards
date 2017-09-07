package com.example.michael.cardgamelab;

/**
 * Created by michael on 07/09/2017.
 */

public class Player {
    private String name;
    private Card[] cards;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card... cards) {
        this.cards = cards;
    }
}
