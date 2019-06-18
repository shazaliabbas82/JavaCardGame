/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epita.spfall.engine;

import fr.epita.spfall.entities.Card;
import fr.epita.spfall.entities.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ShzlAbbs
 */
public class Game {

    private List<Player> players;
    private List<Card> cards;

    private int round;

    public void initialize() {
        this.players = new ArrayList();
        this.cards = new ArrayList();

        //Clubs
        this.cards.add(new Card(Card.TYPE_CLUB, Card.VALUE_2, Card.ORDER_2));
        this.cards.add(new Card(Card.TYPE_CLUB, Card.VALUE_3, Card.ORDER_3));
        this.cards.add(new Card(Card.TYPE_CLUB, Card.VALUE_4, Card.ORDER_4));
        this.cards.add(new Card(Card.TYPE_CLUB, Card.VALUE_5, Card.ORDER_5));
        this.cards.add(new Card(Card.TYPE_CLUB, Card.VALUE_6, Card.ORDER_6));
        this.cards.add(new Card(Card.TYPE_CLUB, Card.VALUE_7, Card.ORDER_7));
        this.cards.add(new Card(Card.TYPE_CLUB, Card.VALUE_8, Card.ORDER_8));
        this.cards.add(new Card(Card.TYPE_CLUB, Card.VALUE_9, Card.ORDER_9));
        this.cards.add(new Card(Card.TYPE_CLUB, Card.VALUE_10, Card.ORDER_10));
        this.cards.add(new Card(Card.TYPE_CLUB, Card.VALUE_A, Card.ORDER_A));
        this.cards.add(new Card(Card.TYPE_CLUB, Card.VALUE_J, Card.ORDER_J));
        this.cards.add(new Card(Card.TYPE_CLUB, Card.VALUE_Q, Card.ORDER_Q));
        this.cards.add(new Card(Card.TYPE_CLUB, Card.VALUE_K, Card.ORDER_K));

        //Diamonds
        this.cards.add(new Card(Card.TYPE_DIAMOND, Card.VALUE_2, Card.ORDER_2));
        this.cards.add(new Card(Card.TYPE_DIAMOND, Card.VALUE_3, Card.ORDER_3));
        this.cards.add(new Card(Card.TYPE_DIAMOND, Card.VALUE_4, Card.ORDER_4));
        this.cards.add(new Card(Card.TYPE_DIAMOND, Card.VALUE_5, Card.ORDER_5));
        this.cards.add(new Card(Card.TYPE_DIAMOND, Card.VALUE_6, Card.ORDER_6));
        this.cards.add(new Card(Card.TYPE_DIAMOND, Card.VALUE_7, Card.ORDER_7));
        this.cards.add(new Card(Card.TYPE_DIAMOND, Card.VALUE_8, Card.ORDER_8));
        this.cards.add(new Card(Card.TYPE_DIAMOND, Card.VALUE_9, Card.ORDER_9));
        this.cards.add(new Card(Card.TYPE_DIAMOND, Card.VALUE_10, Card.ORDER_10));
        this.cards.add(new Card(Card.TYPE_DIAMOND, Card.VALUE_A, Card.ORDER_A));
        this.cards.add(new Card(Card.TYPE_DIAMOND, Card.VALUE_J, Card.ORDER_J));
        this.cards.add(new Card(Card.TYPE_DIAMOND, Card.VALUE_Q, Card.ORDER_Q));
        this.cards.add(new Card(Card.TYPE_DIAMOND, Card.VALUE_K, Card.ORDER_K));

        //Hearts
        this.cards.add(new Card(Card.TYPE_HEART, Card.VALUE_2, Card.ORDER_2));
        this.cards.add(new Card(Card.TYPE_HEART, Card.VALUE_3, Card.ORDER_3));
        this.cards.add(new Card(Card.TYPE_HEART, Card.VALUE_4, Card.ORDER_4));
        this.cards.add(new Card(Card.TYPE_HEART, Card.VALUE_5, Card.ORDER_5));
        this.cards.add(new Card(Card.TYPE_HEART, Card.VALUE_6, Card.ORDER_6));
        this.cards.add(new Card(Card.TYPE_HEART, Card.VALUE_7, Card.ORDER_7));
        this.cards.add(new Card(Card.TYPE_HEART, Card.VALUE_8, Card.ORDER_8));
        this.cards.add(new Card(Card.TYPE_HEART, Card.VALUE_9, Card.ORDER_9));
        this.cards.add(new Card(Card.TYPE_HEART, Card.VALUE_10, Card.ORDER_10));
        this.cards.add(new Card(Card.TYPE_HEART, Card.VALUE_A, Card.ORDER_A));
        this.cards.add(new Card(Card.TYPE_HEART, Card.VALUE_J, Card.ORDER_J));
        this.cards.add(new Card(Card.TYPE_HEART, Card.VALUE_Q, Card.ORDER_Q));
        this.cards.add(new Card(Card.TYPE_HEART, Card.VALUE_K, Card.ORDER_K));

        //Spades
        this.cards.add(new Card(Card.TYPE_SPADE, Card.VALUE_2, Card.ORDER_2));
        this.cards.add(new Card(Card.TYPE_SPADE, Card.VALUE_3, Card.ORDER_3));
        this.cards.add(new Card(Card.TYPE_SPADE, Card.VALUE_4, Card.ORDER_4));
        this.cards.add(new Card(Card.TYPE_SPADE, Card.VALUE_5, Card.ORDER_5));
        this.cards.add(new Card(Card.TYPE_SPADE, Card.VALUE_6, Card.ORDER_6));
        this.cards.add(new Card(Card.TYPE_SPADE, Card.VALUE_7, Card.ORDER_7));
        this.cards.add(new Card(Card.TYPE_SPADE, Card.VALUE_8, Card.ORDER_8));
        this.cards.add(new Card(Card.TYPE_SPADE, Card.VALUE_9, Card.ORDER_9));
        this.cards.add(new Card(Card.TYPE_SPADE, Card.VALUE_10, Card.ORDER_10));
        this.cards.add(new Card(Card.TYPE_SPADE, Card.VALUE_A, Card.ORDER_A));
        this.cards.add(new Card(Card.TYPE_SPADE, Card.VALUE_J, Card.ORDER_J));
        this.cards.add(new Card(Card.TYPE_SPADE, Card.VALUE_Q, Card.ORDER_Q));
        this.cards.add(new Card(Card.TYPE_SPADE, Card.VALUE_K, Card.ORDER_K));

    }

    public List<Card> shuffle() {
        List<Card> cards_copy = new ArrayList();
        Collections.copy(cards, cards_copy);
        return cards_copy;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

}
