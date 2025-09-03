public class Board{

    protected String[][] myBoard;
    protected int numSymbols;

    public Board(){
        this.myBoard = new String[3][3];
        this.numSymbols = 0;
    }

    public void initialise(){
        //Set each cell in the board to a number from 1 to 9
        int num  = 1;
        for(int i = 0; i < this.myBoard.length; i++){
            for(int j = 0; j < this.myBoard[i].length; j++){
                this.myBoard[i][j] = String.valueOf(num);
                num++;
            }
        }
    }

    public void printBoard(){
        //Print the board in a grid format
        for(int i = 0; i < this.myBoard.length; i++){
            for(int j = 0; j < this.myBoard[i].length; j++){
                System.out.print(this.myBoard[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public boolean place(String symbol, int position){
        //Checking if position is on the board
        if(position < 1 || position > 9){
            System.out.println("Position not on board");
            return false;
        } else{
            int row = (position - 1)/3;
            int col = (position - 1) % 3;
            //Checking if position is already taken
            if(this.myBoard[row][col].equals("X") || this.myBoard[row][col].equals("O")){
                System.out.println("Position already taken");
                return false;
            } else{
                this.myBoard[row][col] = symbol;
                this.numSymbols++;
                return true;
            }
        }
    }

    public boolean checkWin(String symbol){
        //Checking rows for win
        for(int i = 0; i < this.myBoard.length; i++){
            if(this.myBoard[i][0].equals(symbol) && this.myBoard[i][1].equals(symbol) && this.myBoard[i][2].equals(symbol)){
                return true;
            }
        }
        //Checking colums for win
        for(int i = 0; i < this.myBoard.length; i++){
            if(this.myBoard[0][i].equals(symbol) && this.myBoard[1][i].equals(symbol) && this.myBoard[2][i].equals(symbol)){
                return true;
            }
        }
        //Checking diagonals for win
        if(this.myBoard[0][0].equals(symbol) && this.myBoard[1][1].equals(symbol) && this.myBoard[2][2].equals(symbol)){
                return true;
            }
        if(this.myBoard[0][2].equals(symbol) && this.myBoard[1][1].equals(symbol) && this.myBoard[2][0].equals(symbol)){
                return true;
            }
        return false;
    }

    public boolean checkDraw(){
        if (this.numSymbols == this.myBoard.length * this.myBoard[0].length){//Check if there are no free spaces left on the board
            if(!checkWin("X") && !checkWin("O")){//Check if a player has won
                return true;
            } else{
                return false;
            }
        }
        return false;
    }
}