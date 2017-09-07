package com.example.michael.cardgamelab;

/**
 * Created by michael on 07/09/2017.
 */

public class Player {
    private String name;
    private Card card;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
