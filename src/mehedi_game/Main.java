package mehedi_game;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static final char Empty_Box = ' ';
    private static final char Player_1 = 'X';
    private static final char Player_O = 'O';
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
        while(true){
   
        }
    }



    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
    }
}