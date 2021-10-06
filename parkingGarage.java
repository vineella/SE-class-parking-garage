import java.util.Scanner;
import java.util.ArrayList;
class parkingGarage {
    int spots, floor;

    //constructor declaring class
    public parkingGarage(int floor, int spots){
        this.floor = floor;
        this.spots = spots;

    }

    //method 1, 
    public int getFloor(){
        return floor;
    }

    //method 2
    public int getSpots(){
        return spots;
    }

    public String toString() {
        return ("The parking floor are" + this.getFloor() + "and the parking spots available are" + this.getSpots());
    } 
    
}

/*

    public class available(int[][] spots)

    public int getSpots(){
        for (i=0; i<=4, i++){
            for (j = 0; i <=4, i++){
                if (spots == 0)
                    System.out.println("This spot is avaiable");
            }
        }
    }

*/
