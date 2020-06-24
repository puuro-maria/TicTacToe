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
        boolean ok = false;
        int size = -1;
        while (ok == false) {
            System.out.println("Syötä ristikon koko: ");
            try {
                size = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Täytyy olla kokonaisluku!");
            }
            if (size < 0) {
                System.out.println("Täytyy olla positiivinen luku!");
            } else {
                ok = true;
            }
        }
        
        int need = -1;
        boolean okk = false;
        while (okk == false) {
            System.out.println("Syötä voittorivin pituus");
            try {
            need = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Täytyy olla kokonaisluku!");
            } 
            if (need < 0) {
                System.out.println("Täytyy olla positiivinen luku!");
            } else {
                okk = true;
            }
        }
        controls.setUpGame(size, need);
        System.out.println(controls.printBoard());
        
        while (controls.gameWon() == false & controls.movesLeft()) {
            //play();
            aiStart();
        }
        String winner;
        switch (controls.whoWon()) {
            case 1:
                winner = "AI";
                break;
            case -10:
                winner = "SINÄ!!";
                break;
            default:
                winner = "ei kumpikaan. Ensi kerralla ehkä";
                break;
        }
        System.out.println("Voittaja on: " + winner);
        controls.gameOver();
        System.exit(0);
    }  
    
    public void play() {
        
        int x = -100;
        int y = -100;
        boolean ok = false;
        while (ok == false) {
            System.out.print("Syötä koordinaatti (x,y):");
            String input = sc.nextLine();
            if (input.contains(",") & input.length() > 2) {
                String[] coordinate = input.split(",");
                x = Integer.parseInt(coordinate[0]);
                y = Integer.parseInt(coordinate[1]);
                ok = controls.setCell(x, y, -10);
                controls.setCell(x, y, -10);
            } else {
                System.out.println("Virheellinen syöte.");
            }
        } 
        System.out.println(controls.printBoard());
        if (controls.gameWon() == false & controls.movesLeft()) {
            long start = System.nanoTime();
            controls.aiTurn();
            long end = System.nanoTime();
            //System.out.println("AI:n vuoro kesti " + (end - start) + " nanosekuntia.");
            System.out.println(controls.printBoard());  
        } else { 
            System.out.println("Peli on päättynyt!");
        }
    }
    
    public void aiStart() {
        if (controls.movesLeft()) {
            long start = System.nanoTime();
            controls.aiTurn();
            long end = System.nanoTime();
            //System.out.println("AI:n vuoro kesti " + (end - start) + " nanosekuntia.");
            System.out.println(controls.printBoard());
        }
        if (controls.gameWon() == false & controls.movesLeft()) {
            int x = -100;
            int y = -100;
            boolean ok = false;
            while (ok == false) {
                System.out.print("Syötä koordinaatti (x,y):");
                String input = sc.nextLine();
                if (input.contains(",") & input.length() > 2) {
                    String[] coordinate = input.split(",");
                    x = Integer.parseInt(coordinate[0]);
                    y = Integer.parseInt(coordinate[1]);
                    ok = controls.setCell(x, y, -10);
                    controls.setCell(x, y, -10);
                } else {
                    System.out.println("Virheellinen syöte.");
                }
            } 
            System.out.println(controls.printBoard());
        } else { 
            System.out.println("Peli on päättynyt!");
        }
    }
    
}
