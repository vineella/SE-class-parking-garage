import java.util.Scanner;
import java.util.ArrayList;
class parkingGarage {
    int spots, floor;

    //constructor declaring class
    public GUI(int floor, int spots){
        this.floor = floor;
        this.spots = spots;

    

    //method 1, 
    public int getFloor(){
        return floor;
    }

    //method 2
    public int getSpots(){
        return spots;
    }

    public String toString() {
        return("The parking floor are: " + this.getFloor() + " and the 
        parking spots avaiable are " + this.getSpots());
    } 



    }
}


