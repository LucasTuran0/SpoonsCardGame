// package cards;
import java.util.LinkedList;
import java.util.Random;


public class Deck {
    private LinkedList<Card> m_Deck;

    public Deck(){
        m_Deck = new LinkedList <Card>();

        for(int i = 0; i < 4; i++){
            for(int k = 2; k <= 14; k++){
                m_Deck.add(new Card(k,i));
            }
        }           
    }  
    
    public Deck(Deck d){
        m_Deck = new LinkedList<Card>();

        for(Card c : d.m_Deck){
            m_Deck.add(new Card(c));
        }
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < m_Deck.size(); i++){
            str += m_Deck.get(i) + "\n";
        }
        return str;
    }

    public int size(){
        return m_Deck.size();
    }

    public void setDeck(LinkedList <Card> deck){
        m_Deck = deck;
    }

    public Card deal(){
        Card c = new Card();
        Random rand = new Random();
        int num = rand.nextInt(m_Deck.size());
        c = m_Deck.get(num);
        m_Deck.remove(num);
        return c;
    }
}
