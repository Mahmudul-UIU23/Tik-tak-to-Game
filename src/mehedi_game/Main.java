package mehedi_game;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static final char Empty_Box = ' ';
    private static final char Player_1 = 'X';
    private static final char Player_2 = 'O';
    private  static final char[][] gameboard = new char[3][3];
    private final  Scanner input = new Scanner(System.in);
    private String playerone;
    private String playertwo;
    private String currentPlayer;
    private String whowon;


    public void  startGame(){
        initializeGameboard();
        askforusername();
        while(isgamenotover()){
            drawBoard();
            printPlayerTrun();
            askForManeuver();

        }
        printGameOver();
    }
    private void initializeGameboard(){
        for(char[] chars : gameboard){
            Arrays.fill(chars, Empty_Box);
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
        return !(isBoardisFull() || hasAnyPlayerwin());
    }
    private void drawBoard(){
        System.out.println("|---|---|---|");
        for (char[] chars : gameboard) {
            System.out.println("| %c | %c | %c | %n , Chars[0], Chars[1] ,Chars[2]");
            System.out.println("|---|---|---|");
        }
    }

    private void printPlayerTrun(){
        System.out.println(whoisplaying() +"'s turn");
    }

    private void askForManeuver(){
        int row;
        int col;
        do{
            System.out.println("Enter a row number (0, 1, or 2): ");
            row = input.nextInt();
            System.out.println("Enter a col number (0, 1, or 2): ");
            col = input.nextInt();
        } while (!validdateInput(row,col)); 
        if(whoisplaying().equlas(playerone)){ 
            gameboard[row][col] = Player_1;
            currentPlayer = playertwo;
        }else {
            gameboard[row][col] = Player_2;
            currentPlayer = playerone;
        }
       
    }
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
    }
}