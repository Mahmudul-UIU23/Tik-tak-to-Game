package mehedi_game;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static final char EMPTY_BOX = ' ';
    private static final char PLAYER_ONES_SYMBOL = 'X';
    private static final char PLAYER_TWOS_SYMBOL = 'O';
    private  static final char[][] gameBoard = new char[3][3];
    private final  Scanner input = new Scanner(System.in);
    private String playerone;
    private String playertwo;
    private String currentPlayer;
    private String whoWonTheGame;


    public void  startGame(){
        initializegameBoard();
        askforusername();
        while(isgamenotover()){
            drawBoard();
            printPlayerTrun();
            askForManeuver();

        }
        printGameOver();
    }
    private void initializegameBoard(){
        for(char[] chars : gameBoard){
            Arrays.fill(chars, EMPTY_BOX);
        }
    }
    private void askforusername(){
        System.out.println("Welcome to tic tac toe!");
        System.out.println("What's Your name?");
        playerone = input.nextLine();
        System.out.println("Who are you playin with? ");
        playertwo = input.nextLine();
        System.out.println("Who is playing first? press" + "\n1 for" + playerone +"\n2 for " + playertwo);
        int player = input.nextInt();
        if (player == 1) {
         currentPlayer = playerone;
                     } 
        else {
         currentPlayer = playertwo;
            }
    }


    private boolean isgamenotover(){
        return !(isBoardisFull() || hasAnyPlayerWon());
    }
    private void drawBoard(){
        System.out.println("|---|---|---|");
        for (char[] chars : gameBoard) {
            System.out.println("| %c | %c | %c | %n , Chars[0], Chars[1] ,Chars[2]");
            System.out.println("|---|---|---|");
        }
    }

    private void printPlayerTrun(){
        System.out.println(whoIsPlaying() +"'s turn");
    }

    private void askForManeuver(){
        int row;
        int col;
        do{
            System.out.println("Enter a row number (0, 1, or 2): ");
            row = input.nextInt();
            System.out.println("Enter a col number (0, 1, or 2): ");
            col = input.nextInt();
        } while (!validateInput(row,col)); 
        if(whoIsPlaying().equals(playerone)){ 
            gameBoard[row][col] = PLAYER_ONES_SYMBOL;
            currentPlayer = playertwo;
        }else {
            gameBoard[row][col] = PLAYER_TWOS_SYMBOL;
            currentPlayer = playerone;
        }
       
    }
  private void printGameOver(){
    drawBoard();
    System.out.println("\uD83c\uDFAE Game Over!  \uD83c\uDFAE");
    if (whoWonTheGame !=null) {
        System.out.println(whoWonTheGame +" Won the Game" + "Congaratulation! From Mehedi");
    }
    else{
        System.out.println("Sounds like tie play it again!");
    }
  }

 private boolean isBoardisFull() {
    boolean result = true;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (gameBoard[i][j] == EMPTY_BOX) {
                result = false;
                break;
            }
        }
        if (!result)
            break;
    }
    return result;
}

 // ... (Diagonal checks would typically follow here)

private boolean hasAnyPlayerWon() {
    char cross = ' ';

    // Check each row
    for (int i = 0; i < 3; i++) {
        if (gameBoard[i][0] == gameBoard[i][1] && 
            gameBoard[i][1] == gameBoard[i][2] && 
            gameBoard[i][0] != EMPTY_BOX) {
            cross = gameBoard[i][0];
        }
    }

    // Check each column
    for (int j = 0; j < 3; j++) {
        if (gameBoard[0][j] == gameBoard[1][j] && 
            gameBoard[1][j] == gameBoard[2][j] && 
            gameBoard[0][j] != EMPTY_BOX) {
            cross = gameBoard[0][j];
        }
    }
    // Check the diagonals
    if (gameBoard[0][0] == gameBoard[1][1] && 
        gameBoard[1][1] == gameBoard[2][2] && 
        gameBoard[0][0] != EMPTY_BOX) {
        cross = gameBoard[0][0];
    }
    
    if (gameBoard[2][0] == gameBoard[1][1] && 
        gameBoard[1][1] == gameBoard[0][2] && 
        gameBoard[2][0] != EMPTY_BOX) {
        cross = gameBoard[2][0];
    }

    if (cross == PLAYER_ONES_SYMBOL) {
        whoWonTheGame = playerone;
    } else if (cross == PLAYER_TWOS_SYMBOL) {
        whoWonTheGame = playertwo;
    }

    return whoWonTheGame != null;
}

private String whoIsPlaying() {
    return currentPlayer;
}

private boolean validateInput(int row, int col) {
    boolean result = false;
    
    if (row < 0 || col < 0 || row > 2 || col > 2) {
        System.out.println("The position is off the bounds " +
                           "of the board, try again");
    } else if (gameBoard[row][col] != EMPTY_BOX) {
        System.out.println("Someone has already made a move " +
                           "at this position, try again");
    } else {
        result = true;
    }

    return result;
}

    // ... (Diagonal checks would typically follow here)





    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
    }
}