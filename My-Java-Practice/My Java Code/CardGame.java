import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardGame {

    private List<CardPlayer> players;//List of players
    private List<Card> deck;//List of cards in the deck
    private boolean gameEnd;//Checks if the game has ended
    private int currentPlayerIndex;//Used to keep track of hte player currenlty playing
    private Scanner scanner;
    private Card currentCard; //Card that was last played

    public CardGame(){
        this.currentCard = null;
        this.players = new ArrayList<>();
        this.gameEnd = false; 
        this.currentPlayerIndex = 0;
        this.scanner = new Scanner(System.in);
        //Initialise the deck of cards
        this.deck = new ArrayList<>();
        String[] suits = {"H","D","C","S"}; //Hearts, Diamonds, Clubs, Spades
        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        for(String suit : suits){
            for(String rank : ranks){
                this.deck.add(new Card(suit, rank));//Add each card to the deck
            }
        }
    }

    public void addPlayer(CardPlayer player){//Add a player to the game
        this.players.add(player);
    }
    
    public Card getCard(){//Retrieve a card from the deck
        if(this.deck.size() == 0){
            return null;
        } else{
            int randomNum = (int)(Math.random() * this.deck.size());
            return this.deck.remove(randomNum); //Remove a random card from the deck and return it
        }
    }

    public void setUpPlayers(){//Set up the players by dealing them cards
        System.out.println("How many people are playing? Choose between 2-5 players:");
        int numPlayers = this.scanner.nextInt();
        //Error checking that number of players is within correct range
        while(numPlayers < 2 || numPlayers > 5){
            System.out.println("Please select a valid number of players between 2-5");
            numPlayers = this.scanner.nextInt();
        }
        for(int i = 1; i <= numPlayers; i++){
            System.out.println("Enter name of player " + Integer.toString(i));
            String name = this.scanner.next();
            CardPlayer player = new CardPlayer(name);
            this.addPlayer(player);
        }
    }

    public void dealCards(int numCards){//Deal cards to each player
        for(CardPlayer player : this.players){
            for(int i = 0; i < numCards; i++){
                Card card = this.getCard();
                if(card != null){
                    player.addCard(card);
                }
            }
        }
    }

    public void play(){//Main game loop
        int index = 0;//Index to keep track of current player
        this.setUpPlayers(); //initialize player
        System.out.println("How many cards do you want to deal to each player? (1-7)");
        int numCards = this.scanner.nextInt();
        while(numCards < 1 || numCards > 7){
            System.out.println("Please select a valid number of cards between 1-7");
            numCards = this.scanner.nextInt();
        }
        this.dealCards(numCards);//Deals cards to each player
        this.currentCard = this.getCard();//Get first card to start the game
        while(!this.gameEnd){
            CardPlayer currentPlayer = this.players.get(index);
            boolean turnEnd = false; //Checks if the turn has ended
            switch(this.currentCard.getRank()){
                case "2":
                    while(!turnEnd){
                        System.out.println("Current card is: " + this.currentCard.getRank() + this.currentCard.getSuit());
                        currentPlayer.displayHand();
                        System.out.println("Choose a card to play by entering its index (starting from 0) or enter -1 to draw a card");
                        int choice = this.scanner.nextInt();
                        while(choice < -1 || choice >= currentPlayer.getHand().size()){
                            System.out.println("Please select a valid index or -1 to draw a card");
                            choice = this.scanner.nextInt();
                        }
                        if(choice == -1){//Player chooses to draw a card
                            for(int i = 0; i < 2; i++){//draw 2 cards as 2 card has been played
                                Card drawnCard = this.getCard();
                                if(drawnCard != null){
                                    currentPlayer.addCard(drawnCard);
                                }
                                index++; //Move to next player
                                if(index >= this.players.size()){
                                    index = 0; //Reset the index if it exceed the number of players
                                }
                                this.currentCard = getCard();
                                turnEnd = true;

                    }
                } else{//Player chooses to play a card
                    Card chosenCard = currentPlayer.getHand().get(choice);
                    if(chosenCard.getRank().equals("2")){
                        this.currentCard = chosenCard;
                        currentPlayer.removeCard(choice);
                        index++; //Move to next player
                                if(index >= this.players.size()){
                                    index = 0; //Reset the index if it exceed the number of players
                                }
                        turnEnd = true;
                        index++; //Move to next player
                                if(index >= this.players.size()){
                                    index = 0; //Reset the index if it exceed the number of players
                                }
                    } else{
                        System.out.println("You must play a 2 or draw cards");
                    }
                    }
        }
        case "3":
            while(!turnEnd){
                         System.out.println("Current card is: " + this.currentCard.getRank() + this.currentCard.getSuit());
                         currentPlayer.displayHand();
                        System.out.println("Choose a card to play by entering its index (starting from 0) or enter -1 to draw a card");
                        int choice = this.scanner.nextInt();
                        while(choice < -1 || choice >= currentPlayer.getHand().size()){
                            System.out.println("Please select a valid index or -1 to draw a card");
                            choice = this.scanner.nextInt();
                        }
                        if(choice == -1){//Player chooses to draw a card
                            for(int i = 0; i < 3; i++){//draw 2 cards as 2 card has been played
                                Card drawnCard = this.getCard();
                                if(drawnCard != null){
                                    currentPlayer.addCard(drawnCard);
                                }
                                index++; //Move to next player
                                if(index >= this.players.size()){
                                    index = 0; //Reset the index if it exceed the number of players
                                }
                                this.currentCard = getCard();
                                turnEnd = true;
                    }
                } else{//Player chooses to play a card
                    Card chosenCard = currentPlayer.getHand().get(choice);
                    if(chosenCard.getRank().equals("3")){
                        this.currentCard = chosenCard;
                        currentPlayer.removeCard(choice);
                        index++; //Move to next player
                                if(index >= this.players.size()){
                                    index = 0; //Reset the index if it exceed the number of players
                                }
                        turnEnd = true;
                    } else{
                        System.out.println("You must play a 3 or draw cards");
                    }
                    }
        }
        case "J":
        while(!turnEnd){
                        System.out.println("Current card is: " + this.currentCard.getRank() + this.currentCard.getSuit());
                        currentPlayer.displayHand();
                        System.out.println("Choose a card to play by entering its index (starting from 0) or enter -1 to draw a card");
                        int choice = this.scanner.nextInt();
                        while(choice < -1 || choice >= currentPlayer.getHand().size()){
                            System.out.println("Please select a valid index or -1 to draw a card");
                            choice = this.scanner.nextInt();
                        }
                        if(choice == -1){//Player chooses to draw a card
                            for(int i = 0; i < 5; i++){//draw 2 cards as 2 card has been played
                                Card drawnCard = this.getCard();
                                if(drawnCard != null){
                                    currentPlayer.addCard(drawnCard);
                                }
                                index++; //Move to next player
                                if(index >= this.players.size()){
                                    index = 0; //Reset the index if it exceed the number of players
                                }
                                this.currentCard = getCard();
                                turnEnd = true;
                    }
                } else{//Player chooses to play a card
                    Card chosenCard = currentPlayer.getHand().get(choice);
                    if(chosenCard.getRank().equals("J")){
                        this.currentCard = chosenCard;
                        currentPlayer.removeCard(choice);
                        index++; //Move to next player
                                if(index >= this.players.size()){
                                    index = 0; //Reset the index if it exceed the number of players
                                }
                        turnEnd = true;
                    } else{
                        System.out.println("You must play a J or draw cards");
                    }
                    }
        }
        default:
            while(!turnEnd){
                        System.out.println("Current card is: " + this.currentCard.getRank() + this.currentCard.getSuit());
                        currentPlayer.displayHand();
                        System.out.println("Choose a card to play by entering its index (starting from 0) or enter -1 to draw a card");
                        int choice = this.scanner.nextInt();
                        while(choice < -1 || choice >= currentPlayer.getHand().size()){
                            System.out.println("Please select a valid index or -1 to draw a card");
                            choice = this.scanner.nextInt();
                        }
                        if(choice == -1){//Player chooses to draw a card
                            for(int i = 0; i < 1; i++){//draw 2 cards as 2 card has been played
                                Card drawnCard = this.getCard();
                                if(drawnCard != null){
                                    currentPlayer.addCard(drawnCard);
                                }
                                index++; //Move to next player
                                if(index >= this.players.size()){
                                    index = 0; //Reset the index if it exceed the number of players
                                }
                                turnEnd = true;
                    }
                } else{//Player chooses to play a card
                    Card chosenCard = currentPlayer.getHand().get(choice);
                    if(chosenCard.getRank().equals(this.currentCard.getRank()) || chosenCard.getSuit().equals(this.currentCard.getSuit())){
                        this.currentCard = chosenCard;
                        currentPlayer.removeCard(choice);
                        index++; //Move to next player
                                if(index >= this.players.size()){
                                    index = 0; //Reset the index if it exceed the number of players
                                }
                        turnEnd = true;
                    } else{
                        System.out.println("You must play a J or draw cards");
                    }
                    }
        }


            }
            //Check if current player has won
            if(currentPlayer.getHand().size() == 0){
                System.out.println(currentPlayer.getName() + " has won! Congratulation!");
                this.gameEnd = true;//End the game
            }
}
    }
    public static void main(String[] args) {
        
        CardGame game = new CardGame();
        game.play();
    }
}

  
