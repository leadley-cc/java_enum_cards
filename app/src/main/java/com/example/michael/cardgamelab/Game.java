package com.example.michael.cardgamelab;

import java.util.*;

/**
 * Created by michael on 07/09/2017.
 */

public class Game {
    Player[] players;
    ArrayList<Card> deck;

//    public Game(int numberOfPlayers) {
//        players = new Player[numberOfPlayers];
//        deck = new ArrayList<>();
//    }

    public Game(Player... players) {
        this.players = players;
        deck = new ArrayList<>();
    }

//    public static void main(String[] args) {
//        Game game = new Game(1);
//        game.generateDeck();
//    }

    public void generateDeck() {
        for (CardSuit suit: CardSuit.values()) {
            for (CardFace face : CardFace.values()) {
                deck.add(new Card(suit, face));
            }
        }
//        for (Card card : deck) {
//            System.out.println("Suit:" + card.getSuit() + " Face: " + card.getFace());
//        }
    }

    public void deal(Player player) {
        Random random = new Random();

        int choice = random.nextInt(deck.size());

        Card card = deck.remove(choice);

        player.setCard(card);
    }

    public void play(){
        for (Player player : players) {
            deal(player);
        }
    }

    public Player winner() {
        int maximum = 0;
        Player winner = null;
        for (int i = 0; i < players.length; i++) {
            int cardValue = players[i].getCard().getFace().getValue();
            if (cardValue > maximum) {
                maximum = cardValue;
                winner = players[i];
            }
        }
        return winner;
    }

    public Player[] getPlayers() {
        return players;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}
