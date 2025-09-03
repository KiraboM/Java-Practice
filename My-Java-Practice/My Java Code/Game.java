import java.util.Scanner;

public class Game{

    protected Board board;//Used to store the game board
    private Scanner scanner;

    public Game(){
        this.board = new Board();
        this.board.initialise();
        this.scanner = new Scanner(System.in);
    }

    public void play(){
        System.out.println("TIC TAC TOE");
        System.out.println("Player 1 is X and Player 2 is O");
        while(this.board.numSymbols < 9){
            //Player 1 turn
            System.out.println("Player 1 turn, enter position 1-9:");
            this.board.printBoard();
            int position = this.scanner.nextInt();
            while(!this.board.place("X", position)){
                System.out.println("Please enter a valid position:");
                try{
                position = this.scanner.nextInt();
            } catch(Exception e){
                System.out.println("Please Enter a valid input");
                this.scanner.next();
            }
            }
            this.board.printBoard();
            //Checking if player 1 has won
            if(this.board.checkWin("X")){
                System.out.println("Player 1 wins");
                break;
            }
            //Checking for a draw
        if(this.board.checkDraw()){
            System.out.println("It's a draw!");
            break;
        }
            //Player 2 turn
            System.out.println("Player 2 turn, enter position 1-9:");
            this.board.printBoard();
            try{
                position = this.scanner.nextInt();
            } catch(Exception e){
                System.out.println("Please Enter a valid input");
                this.scanner.next();
            }
            while(!this.board.place("O", position)){
                System.out.println("Please enter a valid position:");
                try{
                position = this.scanner.nextInt();
            } catch(Exception e){
                System.out.println("Please Enter a valid input");
                this.scanner.next();
            }
            }
            this.board.printBoard();
            //Checking if player 2 has won
            if(this.board.checkWin("O")){
                System.out.println("Player 2 wins");
                break;
            }
            //Checking for a draw
        if(this.board.checkDraw()){
            System.out.println("It's a draw!");
            break;
        }

            
        }
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}