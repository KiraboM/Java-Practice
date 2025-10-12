import java.util.ArrayList;
import java.util.List;

public class CardPlayer {

    protected String name;
    protected List<Card> hand;

    public CardPlayer(String name){
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName(){
        return this.name;//Return the player's name
    }

    public List<Card> getHand(){//Return the player's hand
        return this.hand;
    }

    public void addCard(Card card){
        this.hand.add(card);//Add card to the player's hand
    }

    public void displayHand(){
        System.out.println(this.name + "'s hand: ");
        for(Card card : this.hand){
            System.out.print(card.getRank() + card.getSuit() + " , ");//Display each card in the player's hand
        }
    }


    
}
