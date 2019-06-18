/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epita.spfall.entities;

import java.util.Objects;

/**
 *
 * 
 */
public class Card {

    public static String TYPE_SPADE = "spade";
    public static String TYPE_DIAMOND = "diamond";
    public static String TYPE_HEART = "heart";
    public static String TYPE_CLUB = "club";

    public static String VALUE_A = "A";
    public static String VALUE_2 = "2";
    public static String VALUE_3 = "3";
    public static String VALUE_4 = "4";
    public static String VALUE_5 = "5";
    public static String VALUE_6 = "6";
    public static String VALUE_7 = "7";
    public static String VALUE_8 = "8";
    public static String VALUE_9 = "9";
    public static String VALUE_10 = "10";
    public static String VALUE_J = "J";
    // public static String VALUE_C = "C";
    public static String VALUE_Q = "Q";
    public static String VALUE_K = "K";

    public static int ORDER_A = 15;
    public static int ORDER_2 = 2;
    public static int ORDER_3 = 3;
    public static int ORDER_4 = 4;
    public static int ORDER_5 = 5;
    public static int ORDER_6 = 6;
    public static int ORDER_7 = 7;
    public static int ORDER_8 = 8;
    public static int ORDER_9 = 9;
    public static int ORDER_10 = 10;
    public static int ORDER_J = 11;
    // public static int ORDER_C = 12;
    public static int ORDER_Q = 13;
    public static int ORDER_K = 14;

    private String type;

    private String value;

    private int order;

    public Card(String type, String value, int order) {
        this.type = type;
        this.value = value;
        this.order = order;
    }

    public Card(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public static boolean greater_than(Card A, Card B) {
        return A.order > B.order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.type);
        hash = 59 * hash + Objects.hashCode(this.value);
        hash = 59 * hash + this.order;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.order != other.order) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

    public void describe() {
        System.out.println(this.type + " ->  " + this.value);
    }

}
