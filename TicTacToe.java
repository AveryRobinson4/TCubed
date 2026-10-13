import java.util.Scanner;

public class TicTacToe{

    //MAIN
    public static void main(String[] args) {
        //MAKES NEW NON-STATIC GAME
        TicTacToe tester = new TicTacToe();
        tester.run();
    }

    //CHECKS IF WINNER
    public String checkGameResult(char[][] board){

        //IN PROGRESS
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == ' '){
                    return "Game in progress";
                }
            } 
        }

        for(int i = 0; i < 3; i++){
            //ROWS
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                if(board[i][0] == 'X'){
                    return "X wins";
                }
                if(board[i][0] == 'O'){
                    return "O wins";
                }
            }

            //COLUMNS
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                if(board[0][i] == 'X'){
                    return "X wins";
                }
                if(board[0][i] == 'O'){
                    return "O wins";
                }
            }
        }

        //XS
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            if(board[0][0] == 'X'){
                return "X wins";
            }
            if(board[0][0] == 'O'){
                return "O wins";
            }
        }
        if(board[0][2] == board[1][1] &&  board[1][1] == board[2][0]){
            if(board[0][2] == 'X'){
                return "X wins";
            }
            if(board[0][2] == 'O'){
                return "O wins";
            }
        }
        return "Draw";
    }

    //PLAY GAME
    public void run(){
        //CREATE SCANNER AND BOARD
        Scanner scan = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};

        //SETS DEFAULTS
        char currentPlayer = 'X';
        String result = "Game in progress";

        //WHILE GAME IS INCOMPLETE
        while(result.equals("Game in progress")){
            //PRINT BOARD; 3 COLUMNS * 3 ROWS
            for(int i = 0; i <= 2; i++){
                System.out.print(" ");
                for(int j = 0; j <= 2; j++){
                    System.out.print(board[i][j]);
                    if(j < 2){
                        System.out.print(" | ");
                    }
                }
                System.out.println();
                if(i < 2){
                    System.out.println("---+---+---");
                }
            }

            int row;
            int column;

            while (true) {
                //GET USER ROW
                System.out.print("Player " + currentPlayer + ", enter row (0-2): ");
                row = scan.nextInt();

                //GET USER COLUMN
                System.out.print("Player " + currentPlayer + ", enter column (0-2): ");
                column = scan.nextInt();

                //CHECK BOUNDS OF INPUT
                if(row < 0 || row > 2 || column < 0 || column > 2){
                    System.out.println("Row and column must be between 0 and 2.");
                }else if(board[row][column] != ' '){
                    System.out.println("That space is already taken. Try again.");
                }else{
                    break;
                }
            }

            //TODO: --- This is where the error is. The program is not correctly checking for a winner after each move. checkGameResult should be called after each move. ---
            
            //AFTER BREAK, CHANGE TO INPUT
            board[row][column] = currentPlayer;
            result = checkGameResult(board);

            //CHECK AND RERUN
            //result = checkGameResult(board);

            //SWITCH PLAYERS
            if(result.equals("Game in progress")){
                if(currentPlayer == 'X'){
                    currentPlayer = 'O';
                }else if(currentPlayer == 'O'){
                    currentPlayer = 'X';
                }
            }
        }

        //PRINT FINAL. SAME CODE
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println(result);

        scan.close();
    }
}
