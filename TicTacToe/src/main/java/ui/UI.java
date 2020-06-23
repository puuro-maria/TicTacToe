package ui;

import controls.Controls;
import java.util.Scanner;

/**
 *This class includes the text-UI of the game
 * @author vpuurone
 */
public class UI {
    
    Scanner sc = new Scanner(System.in);
    Controls controls = new Controls();
    
    public void start() {
        System.out.println("Syötä ristikon koko: ");
        int size = Integer.parseInt(sc.nextLine());
        System.out.println("Syötä voittorivin pituus");
        int need = Integer.parseInt(sc.nextLine());
        controls.setUpGame(size, need);
        System.out.println(controls.printBoard());
        
        while (controls.gameWon() == false) {
            play();
        }
        
        System.out.println("Voittaja on: " + controls.whoWon());
        controls.gameOver();
        System.exit(0);
    }  
    
    public void play() {
        controls.aiTurn();
        System.out.println(controls.printBoard());
        //System.out.println(controls.printBoard());
        if (controls.gameWon() == false) {
            System.out.print("Syötä koordinaatti (x,y):");
            String[] coordinate = sc.nextLine().split(",");
            int x = Integer.parseInt(coordinate[0]);
            int y = Integer.parseInt(coordinate[1]);
            controls.setCell(x, y, -10);
        }
    }
    
}
