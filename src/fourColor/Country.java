/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fourColor;

import java.util.ArrayList;

/**
 *
 * @author ethan.weber
 */
public class Country {

    private int color;
    private ArrayList<Integer> history;
    ArrayList<Country> neighbors;
    private int name;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public ArrayList getHistory() {
        return history;
    }

    public void setHistory(ArrayList history) {
        this.history = history;
    }

    public int getColor() {
        return color;
    }

    public boolean setColor(int nColors) {
        int xcolor;
        if(this.color == nColors){
            history.add(this.color);
            System.out.println("Country: " + name + " F");
            this.color = 0;
            return false;
        }
        for(int i=this.color; i<nColors; i++){
            
        if(!neighborsContainsColor(i+1)){
            if(this.color > 0){
            history.add(this.color);
                    }
            this.color = i+1;
            System.out.println("Country: " + name + " "+ this.color);
            return true;
        }
        }
        if(this.color > 0){
            history.add(this.color);
            
                    }
        System.out.println("Country: " + name + " F");
        this.color = 0;
        return false;
    }
    
    public String printHistory(){
        String chistory = "";
        for(int i = 0; i< history.size();i++){
            chistory = chistory + history.get(i) + " ";
        }
        return chistory;
    }
    
    public Country(int name) {
        this.name = name;
        this.color = 0;
        neighbors = new ArrayList<>();
        history = new ArrayList<>();
    }

    private boolean neighborsContainsColor(int x) {
        for(int i = 0; i<neighbors.size();i++){
            if(neighbors.get(i).getColor() == x){
                return true;
            }
        }
        return false;
    }
    
}
