//package cards;
import java.util.LinkedList;
import java.util.Random;

public class Dealer {
    private Deck m_Deck;

    public Dealer(){
        m_Deck = new Deck();           
    }  

    public LinkedList<Card> deals(int n){
        LinkedList <Card> list = new LinkedList();
        
        if(m_Deck.size() == 0){
            return list;
        }

        for(int i = 0; i < n; i++){
            list.add(m_Deck.deal());
        }

        return list;
    }


    public int size(){
        return m_Deck.size();
    }

    public void setDeck(LinkedList <Card> newDeck){
        m_Deck.setDeck(newDeck);
    }
    

    public String toString(){
        String str = "";
        str += m_Deck.toString();
        return str;
    }
}
