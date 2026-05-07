package mehedi_game;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
public class Main {
    private static final char Empty_Box = ' ';
    private static final char Player_1 = 'X';
    private static final char Player_O = 'O';
    private  static final char[][] gameboard = new char[3][3];
    private final  Scanner sc = new Scanner(System.in);
    private String playerone;
    private String playertwo;
    private String currentPlayer;
    private String whowon;


    

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
    }
}