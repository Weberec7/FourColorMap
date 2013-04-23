/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fourColor;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author ethan.weber
 */
public class Map {

    private Country[] Countries;
    private final int size;
    private final int nColors;

    public Country[] getCountries() {
        return Countries;
    }

    public void setCountries(Country[] Countries) {
        this.Countries = Countries;
    }
    
    public Map(String src) {
        this.nColors = 4;
        int index = 1;
        URL url = Map.class.getResource(src);
        String filename = url.getFile();
        File file = new File(filename);
        
        //determine # of lines in the file
        this.size = LineCount(file);
      
        // Initialize # of Countries
        Countries = new Country[size+1];
        for(int i = 1; i<=size; i++){
            Countries[i] = new Country(i);
        }
       //Fill Countries
       try{
       Scanner inFile = new Scanner(file);
       while(inFile.hasNextInt()){
           int neighbor = inFile.nextInt();
           if(neighbor == 0){index++;continue;}
           Countries[index].neighbors.add(Countries[neighbor]);
       }
       }
       catch(Exception e)
               {
                   System.out.println("File not Found.. or some other error.");
               }
        }
    
    public void printMap(){
        String Summary = "\nSummary:\n\n";
        for(int i = 1; i<size+1; i++){
            System.out.println("\nCountry: " + i);
            System.out.println("History: " + Countries[i].printHistory());
            System.out.println("Current Color: " + Countries[i].getColor());
            Summary = Summary + i + " " + Countries[i].getColor() + "\n";
    }
        System.out.println(Summary);
    }
    
    public boolean colorizeMap(){
        int index = 1;
        System.out.println("\nSteps:\n");
        while(true){
        
        if(Countries[index].setColor(nColors)){
            index = index + 1;
        }
        else{
                index = index-1;
            }
        if(index>size){
            return true;
        }
        if(index<=0){
            return false;
        }
        }
    }

    private int LineCount(File file) {
        int lines = 0;
        try{
       Scanner inFile = new Scanner(file);
       while(inFile.hasNextLine()){
           inFile.nextLine();
           lines++;
       }
       }
       catch(Exception e)
               {
                   System.out.println("File not Found.. or some other error.");
               }
        System.out.println("Lines: " + lines);
        return lines;
        }
    }
        
           
        
    
    
    
    

