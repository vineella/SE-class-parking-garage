import java.util.Scanner;
import java.util.ArrayList;
class parkingGarage {
    int spots, floors, garage[][];
    int userFloor, userSpots;

    //constructor declaring class
    public parkingGarage(int floors, int spots){
        this.floors = floors;
        this.spots = spots;
        int garage[][] = new int[floors][spots]; //garage array

    }

    //method to get floor, 
    public int getFloors(){
        return floors;
    }

    //method to get spots
    public int getSpots(){
        return spots;
    }

    



    //Method to print info in specific way
    public String toString() {
        return ("The parking floor are" + this.getFloors() + "and the number of spots are" + this.getSpots());
    } 

    //create a code that searches for a specific spot
    public String available(int[][] garage) {
        //for (int i = 0; i < floor; i++){
            //for (int j = 0; i < spots; j++){ //may not need a nested for loop could just do a boolean
                if (garage[userFloor][userSpots] == 0){            //can also just do if(input[userFloor][userSpots] == 0)
                    System.out.print("This spot is available");
                }
                else {
                    System.out.println("This spot is not avaiable");
                }       
    }
        


    //method that gets all the spots
    public String getAllSpots(){
        for (int i=0; i<= floors; i++){
            for (int j = 0; j <= spots; j++){
                if (spots == 0) {
                    System.out.println("This spot is avaiable");
                }
                else {
                    System.out.println("This is spot is not available");
                }
            }
        }
    }

}

