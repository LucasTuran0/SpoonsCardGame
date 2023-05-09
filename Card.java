// Lucas Turano
// 2420768
// turano@chapman.edu
// CPSC 231 - 04
//MP3A

//package cards;

public class Card{
    int value;
    int suit; 
    
    public static final int hearts = 0;
    public static final int spades = 1;
    public static final int clubs = 2;
    public static final int diamonds = 3;

    public static final int jack = 11;
    public static final int queen = 12;
    public static final int king = 13;
    public static final int ace = 14;




    public Card(){
        value = 1;
        suit = 4;
    }

    public Card(int v, int s){
        value = v;
        suit = s;
    }

    public Card(Card c){
        value = c.value;
        suit = c.suit;
    }

    public String toString(){
        String str =  "";

        switch(value){
            case 11:
            str += "Jack";
            break;

            case 12:
            str += "Queen";
            break;

            case 13:
            str += "King";
            break;

            case 14: 
            str += "Ace";
            break;

            default:
            str += value;
        }
        str += " of ";

        switch(suit){
            case 0:
            str += "hearts";
            break;

            case 1:
            str += "spades";
            break;

            case 2:
            str += "clubs";
            break;

            case 3:
            str += "diamonds";
            break;

            case 9:
            str += "null";
            break;
        }
        return str;
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if (!(o instanceof Card)){ 
            return false;
        }

        Card c = (Card) o;

        if(this.value == c.value && this.suit == c.suit){
            return true;
        }
        return false;
    }

    //accessors
    public int getValue(){
        return value;
    }

    public int getSuit(){
        return suit;
    }

    //mutators

    public void setValue(int v){
        value = v;
    }

    public void setSuit(int s){
        suit = s;
    }
}