//package cards;
import java.util.LinkedList;
import java.util.Random;
import java.util.HashSet;


public class Player {
    public int pNum;
    private LinkedList <Card> hand;
    public static int numSpoonsleft;
    private int numMatches;
    public boolean hasSpoon;
    private boolean fullMatch;
    public static Deck deck;


    public Player(int n, Dealer dealer){
        pNum = n;
        fullMatch = false;
        hasSpoon = false;
        hand = new LinkedList<Card>();
        hand = dealer.deals(4);
    }

    public boolean getFullMatch(){
        return fullMatch;
    }

    public Card takeTurn(Card c){ //card c will be a random card dealt from the deck
        hand.add(c);
        Card tempCard = new Card();
        LinkedList <Card> tempHand = new LinkedList();
        LinkedList <Integer> matchIndex = new LinkedList();

        for(int i = 0; i < hand.size(); i++){         //I dont think this accounts for having more than two matches
            Card iCard = new Card(hand.get(i));
            
            for(int k = 0; k < hand.size(); k++){
                Card kCard = new Card(hand.get(k));
                if(iCard.getValue() == kCard.getValue() || iCard.getSuit() == kCard.getSuit()){
                    if(hand.get(i) == hand.get(k)){
                        break;
                    }else{
                        
                        matchIndex.add(i);
                        //System.out.println("This is i when there is a match: " + i);
                        matchIndex.add(k);
                        //System.out.println("This is k when there is a match: " + k);


                        tempHand.add(iCard);
                        //System.out.println("this is iCard: " + iCard);
                        tempHand.add(kCard);
                        //System.out.println("this is kCard: " + kCard);
                        
                        
                    }
                }
            }
        }

        HashSet<Integer> uniqueIndexes = new HashSet<Integer>(matchIndex);     //this is to clear duplicates from the matchIndex
        matchIndex.clear();
        matchIndex.addAll(uniqueIndexes);

        if(matchIndex.size() == 4){
            fullMatch = true;
            stealSpoon();
            //System.out.println("*****winner*****");
            //hand = tempHand;
        }

        //debugging stuff4
        //System.out.println("match index size(): " + matchIndex.size());
        //System.out.println("These indexs are in matchIndex: ------------------" );
        // for(int i = 0; i < matchIndex.size(); i++){
        //     System.out.println(matchIndex.get(i));
        // }

        

        for(int i = 0; i < matchIndex.size();i++){       //this is removing the possibility that any cards that are matches get passed on accidentally
            //tempHand.add(hand.get(matchIndex.get(i)));      // with this method none of the indexes are messed up when a card is removed
            hand.remove(hand.get(matchIndex.get(0)));
        }
        
        //debugging stuff
        // System.out.println("+++++++These are the cards tempCard has to choose from+++++++++");
        // for(int i = 0; i < hand.size(); i++){
        //     System.out.println(hand.get(i));
        // }
        
        Random rand = new Random();
        if(hand.isEmpty()){
            return tempCard;
        }else{
            int index = rand.nextInt(hand.size());
            tempCard = hand.get(index);
            hand.remove(index);

            //Add functionality to clear tempHand of any duplicates
            LinkedList<Card> uniqueCards = new LinkedList<Card>();     //this is to clear duplicates from the tempHand
            for (Card card : tempHand) {
                if (uniqueCards.contains(card)) {
                    break;
                }else{
                    uniqueCards.add(card);
                }
            }
            tempHand.clear();
            tempHand.addAll(uniqueCards);

            
            for(int i = 0; i < tempHand.size(); i++){
                hand.add(tempHand.get(i));
            }

            //debugging stuff
            // System.out.println("temporary hand full of matches: ");
            // for(int i = 0; i < tempHand.size(); i++){
            //     System.out.println(tempHand.get(i));
            // }

            

            //System.out.println("This is tempCard: " + tempCard);
            
            int numPlayersPlayer = Game.numPlayers;
            int noticeSpoon = rand.nextInt(101);
            if(numSpoonsleft != numPlayersPlayer-1 &&  noticeSpoon <= 33){
                stealSpoon();
            }
        }

        // System.out.println("The cards in player hand are: ");
        // for(int i = 0; i < Game.numPlayers; i++){   
        //     System.out.println(hand.get(i));
        // }
        
        // System.out.println("The card being passed is: " + tempCard);

        return tempCard;
    }
    

    public void stealSpoon(){
        if(numSpoonsleft >= 1 && hasSpoon == false){
        hasSpoon = true;
        numSpoonsleft--;
        }
    }

    //public static void main(String[] args) {
        // deck = new Deck();

        // Player p1 = new Player(1);

        // // for(int i = 0; i < p1.hand.size(); i++){
        // //     System.out.println(p1.hand.get(i));
        // // }

        // p1.hand.remove(0);
        // p1.hand.remove(0);
        // p1.hand.remove(0);
        // p1.hand.remove(0);

        // System.out.println("==========Current Hand==============");

        // Card a = new Card(5, spades);
        // Card b = new Card(5, diamonds);
        // Card c = new Card(5, hearts);
        // Card d = new Card(4, clubs);

        // Card testCard = new Card(1, 9);

        // p1.hand.add(a);
        // p1.hand.add(b);
        // p1.hand.add(c);
        // p1.hand.add(d);

        // for(int i = 0; i < p1.hand.size(); i++){
        //     System.out.println(p1.hand.get(i)); 
        // }

        // System.out.println("==========================");

        // p1.takeTurn(testCard);


        // System.out.println("=========left over hand======");
        // for(int i = 0; i < p1.hand.size(); i++){
        //     System.out.println(p1.hand.get(i));
        // }



    //}
}
