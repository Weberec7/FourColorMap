/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fourcolormap;

import fourColor.Map;
import java.util.Scanner;

/**
 *
 * @author Weberec7
 */
public class FourColorMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Map myMap;
       
       Scanner in = new Scanner(System.in);
       System.out.println("Input the name of the file you would like to use.");
       String filename = in.next();
       myMap = new Map(filename);
       myMap.colorizeMap();
       myMap.printMap();
    }
}
