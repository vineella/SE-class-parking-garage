class parkingGarage {
    private int spots, floors;
    private int[][] garage;
    private int counter;//this is simply test code that can be deleted when the numSpotsAvailable
                        //method is completed

    //constructor declaring class
    public parkingGarage(int floors, int spots){
        this.floors = floors;
        this.spots = spots;
        this.garage = new int[floors][spots]; //garage array
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
        
    //checks a given floor to see how many spots are available on that floor
    public int numSpotsAvailable(int whichFloor){
        counter++; //this is just test code so it will compile
        return counter; //this is just test code so it will compile
    }

}

