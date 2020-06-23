package ui;

import controls.*;

/**
 *
 * @author vpuurone
 */
public class TestClass {
    
    private Controls controls = new Controls();
    
    public void test() {
        controls.setUpGame(3, 3);
        long start = System.nanoTime();
        controls.aiTurn();
        long end = System.nanoTime();
        controls.printBoard();
        System.out.println("AI:n siirtoon meni aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään nolla ruutuun 1,1...");
        controls.setCell(1, 1, -10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        System.out.println("AI:n siirtoon meni nyt aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään jälleen nolla ruutuun 0,1...");
        controls.setCell(0, 1, -10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        System.out.println("AI:n siirtoon meni nyt aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään jälleen nolla ruutuun 1,2...");
        controls.setCell(1, 2, -10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        System.out.println("AI:n siirtoon meni nyt aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään jälleen nolla ruutuun 2,0... Peli päättyy.");
        System.out.println("----------------------------------------------------------------");
        controls.gameOver();
        controls.setUpGame(4, 3);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        controls.printBoard();
        System.out.println("AI:n siirtoon meni aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään nolla ruutuun 0,0...");
        controls.setCell(1, 1, -10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        controls.printBoard();
        System.out.println("AI:n siirtoon meni aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään nolla ruutuun 0,3...");
        controls.setCell(0, 2, -10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        controls.printBoard();
        System.out.println("AI:n siirtoon meni aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään nolla ruutuun 2,3...");
        controls.setCell(1, 0, -10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        controls.printBoard();
        System.out.println("AI voitti.. Viimeinen siirto vei " + (end - start) + " nanosekuntia.");
    }
    
    
    
}
