package com.example.michael.cardgamelab;

import java.util.*;

/**
 * Created by michael on 07/09/2017.
 */

public class Game {
    Player[] players;
    ArrayList<Card> deck;
    int level;

//    public Game(int numberOfPlayers) {
//        players = new Player[numberOfPlayers];
//        deck = new ArrayList<>();
//    }

    public Game(int level, Player... players) {
        this.players = players;
        deck = new ArrayList<>();
        this.level = level;
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

        Card[] cards = new Card[level];

        for (int i = 0; i < level; i++) {
            int choice = random.nextInt(deck.size());

            cards[i] = deck.remove(choice);
        }

        player.setCards(cards);
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
            int totalCardValue = 0;
            for (Card card : players[i].getCards()) {
                totalCardValue += card.getFace().getValue();
            }
            if (totalCardValue > maximum) {
                maximum = totalCardValue;
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
