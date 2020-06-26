package ui;

import controls.*;

/**
 *
 * @author vpuurone
 */
public class TestClass {
    
    private Controls controls = new Controls();
    
    public void test() {
      int i = 0;
      long[][] game1 = new long[20][4];
      long[][] game2 = new long[20][3];
      long[][] game3 = new long[20][6];
      String print = "";
      String print2 = "";
      String print3 = "";
      
      while (i < 20) {
        System.out.println("3x3 -peli, joka päättyy tasapeliin molempien hyvän pelin vuoksi");
        controls.setUpGame(3, 3);
        long start = System.nanoTime();
        controls.aiTurn();
        long end = System.nanoTime();
        game1[i][0] = end-start;
        controls.printBoard();
        System.out.println(controls.printBoard());
        System.out.println("AI:n siirtoon meni aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään nolla ruutuun 1,1...");
        controls.setCell(1, 1, -10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        game1[i][1] = end-start;
        System.out.println(controls.printBoard());
        System.out.println("AI:n siirtoon meni nyt aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään jälleen nolla ruutuun 0,1...");
        controls.setCell(0, 1, -10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        game1[i][2] = end-start;
        System.out.println(controls.printBoard());
        System.out.println("AI:n siirtoon meni nyt aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään jälleen nolla ruutuun 1,2...");
        controls.setCell(1, 2, -10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        game1[i][3] = end-start;
        System.out.println(controls.printBoard());
        System.out.println("AI:n siirtoon meni nyt aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään jälleen nolla ruutuun 2,0... Peli päättyy.");
        
        
        System.out.println("----------------------------------------------------------------\n3x3-peli, jossa ihminen tekee virheen ja AI vie voiton");
        controls.setUpGame(3, 3);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        game2[i][0] = (end-start);
        controls.printBoard();
        System.out.println(controls.printBoard());
        System.out.println("AI:n siirtoon meni aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään nolla ruutuun 1,0...");
        controls.setCell(1, 0, -10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        game2[i][1] = (end-start);
        System.out.println(controls.printBoard());
        System.out.println("AI:n siirtoon meni nyt aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään jälleen nolla ruutuun 1,1...");
        controls.setCell(1,1,-10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        game2[i][2] = (end-start);
        controls.printBoard();
        System.out.println(controls.printBoard());
        System.out.println("AI:n siirtoon meni aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Ja ai voitti...");
      
        
        System.out.println("----------------------------------------------------------------\n4x4-peli, jossa voittorivi on 3 ja ihminen tekee rationaalisia valintoja");
        controls.gameOver();
        controls.setUpGame(4, 3);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        game3[i][0] = end-start;
        System.out.println(controls.printBoard());
        System.out.println("AI:n siirtoon meni aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään nolla ruutuun 0,0...");
        controls.setCell(1, 1, -10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        game3[i][1] = end-start;
        System.out.println(controls.printBoard());
        System.out.println("AI:n siirtoon meni aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään nolla ruutuun 0,3...");
        controls.setCell(0, 2, -10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        game3[i][2] = end-start;
        System.out.println(controls.printBoard());
        System.out.println("AI:n siirtoon meni aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään nolla ruutuun 1,0...");
        controls.setCell(1, 0, -10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        game3[i][3] = end-start;
        System.out.println(controls.printBoard());
        System.out.println("AI:n siirtoon meni aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään nolla ruutuun 2,3...");
        controls.setCell(2, 3, -10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        game3[i][4] = end-start;
        System.out.println(controls.printBoard());
        System.out.println("AI:n siirtoon meni aikaa: " + (end - start) + " nanosekuntia.\n"
                + "Lisätään nolla ruutuun 2,2...");
        controls.setCell(2, 2, -10);
        start = System.nanoTime();
        controls.aiTurn();
        end = System.nanoTime();
        game3[i][5] = end-start;
        System.out.println(controls.printBoard());
        System.out.println("AI:n siirtoon meni aikaa: " + (end - start) + " nanosekuntia.\n"
                + "JA AI voitti......");
        
        i++;
      }
      
      for (int j = 0; j < game1.length; j++) {
            for (int k = 0; k < game1[j].length; k++) {
                print += "| " + game1[j][k] + " ";
            }
            print += "|\n";
      }
      
      for (int j = 0; j < game2.length; j++) {
            for (int k = 0; k < game2[j].length; k++) {
                print2 += "| " + game2[j][k] + " ";
            }
            print2 += "|\n";
        }
      
      for (int j = 0; j < game3.length; j++) {
            for (int k = 0; k < game3[j].length; k++) {
                print3 += "| " + game3[j][k] + " ";
            }
            print3 += "|\n";
      }
      
      System.out.println("Ensimmäisen pelin AI:n siirtojen kestot (ns) taulukoituna. Sarakkeissa vuorot 1...n ja riveillä testin toistot.\n" + print + "\n\n");
      System.out.println("Ensimmäisen pelin AI:n siirtojen kestot (ns) taulukoituna. Sarakkeissa vuorot 1...n ja riveillä testin toistot.\n" + print2 + "\n\n");
      System.out.println("Ensimmäisen pelin AI:n siirtojen kestot (ns) taulukoituna. Sarakkeissa vuorot 1...n ja riveillä testin toistot.\n" + print3 + "\n\n");
    }
    
    
    
}
