import java.util.Scanner;
import java.util.ArrayList;
class parkingGarage {
    int spots, floors;
    int[][] garage;
    int userFloor, userSpots;

    //constructor declaring class
    public parkingGarage(int floors, int spots){
        this.floors = floors;
        this.spots = spots;
        garage = new int[floors][spots]; //garage array
    }


    //method to get floor, 
    public int getFloors(){
        return floors;
    }

    //method to get spots
    public int getSpots(){
        return spots;
    }

    //method to get the garage array
    public int[][] getArray(){
        return garage;
    }

    //method to fill a specific spot
    public void fillSpot(int userFloor, int userSpot){
        garage[userFloor][userSpot]=1;
    }


    //Method to print info in specific way
    public String toString() {
        return ("The parking floor are" + this.getFloors() + "and the number of spots are" + this.getSpots());
    } 

    //create a code that searches for a specific spot
    public boolean isAvailable(int[][] garage, int userFloor, int userSpot) {
        boolean availability;
                if (garage[userFloor][userSpot] == 0){           
                    availability=true;
                }
                else {
                    availability=false;
                }       
        return availability;
    }
        
    //method that gets all the spots
    public void getAllSpots(){
        for (int i=0; i<= floors; i++){
            for (int j = 0; j <= spots; j++){
                if (garage[i][j] == 0) {
                    System.out.println("This spot is avaiable:" + "Floor: " + this.getFloors() + "Spot: " + this.getSpots());
                }
            }
        }
    }

}

