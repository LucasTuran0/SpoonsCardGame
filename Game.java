//package cards;
import java.util.LinkedList;

public class Game {
    public static int numPlayers;
    public static int numSpoons;
    private Dealer dealer;
    private Player [] pList;


    public Game(){
        numPlayers = 0;
        numSpoons = -1;
    }

    public Game(int n){
        dealer = new Dealer();
        pList = new Player[n];
        for (int i = 0; i < n; i++){
            pList[i] = new Player(i, dealer);
        }
        numPlayers = n;
        numSpoons = n-1;
        Player.numSpoonsleft = n-1;
    }

    public void play(){
        LinkedList <Card> discardDeck = new LinkedList<Card>();

        while(Player.numSpoonsleft > 0){
            if(dealer.size() == 0){
                dealer.setDeck(discardDeck);
            }

            Card c = (dealer.deals(1)).get(0);

            for(int i = 0; i < numPlayers; i++){
                //System.out.println("Player " + i + ":");
                c = pList[i].takeTurn(c);
                System.out.println();
                System.out.println();

                if(i == numPlayers-1){
                    discardDeck.add(c);
                }
            }
        }

        for(int i = 0; i < numPlayers; i++){
            System.out.println("Player " + i + " has spoon: ");
            System.out.println(pList[i].hasSpoon) ;
        }

        System.out.println("Spoons left: " + Player.numSpoonsleft);

        for(int i = 0; i < numPlayers; i++){
            if(pList[i].hasSpoon != true){
                System.out.println("Player " + ((pList[i].pNum)) + " is the loser!");
            }
        }
    }

    //no mutators or accessors needed due to public variables
    
}
