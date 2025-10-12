public class Card {
    
    protected String suit;
    protected String rank;

    public Card(String suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit(){
        return this.suit;
    }

    public String getRank(){
        return this.rank;
    }

    
}
