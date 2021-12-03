class parkingGarage {
    private int spots, floors;
    private int[][] garage;
    private client[][] clients;

    //constructor declaring class
    public parkingGarage(int floors, int spots){
        this.floors = floors;
        this.spots = spots;
        this.garage = new int[floors][spots]; //garage array
        this.clients = new client[floors][spots]; //client array
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

    public void setArray(int floor, int spot, int fullOrNot){
        garage[floor][spot]=fullOrNot;
    }

    //method to fill a specific spot
    public void fillSpot(int userFloor, int userSpot){
        garage[userFloor][userSpot]=1;
    }

    //this method should take in a floor number and a spot number
    //and return the client in that spot
    public client getClientAt(int floor, int spot){
        return clients[floor][spot];
    }

    //this method should take in a floor number, spot number,
    //and a client, and add that client to this class's client
    //array at that floor and spot
    public void setClientAt(int floor, int spot, client client){
        clients[floor][spot] = client;
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
        }else {
            availability=false;
        }       
        return availability;
    }
        
    //checks a given floor to see how many spots are available on that floor
    public int numSpotsAvailable(int whichFloor){
        int counter = 0;
        for(int i =0; i<spots; i++){
            if (garage[whichFloor][i] == 0) {
            counter++; //this is just test code so it will compile
            }
        }  
    return counter; //this is just test code so it will compile
    }
}
