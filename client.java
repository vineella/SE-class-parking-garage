public class client {
    int firstN;
    int lastN; 
    int payment; 
    int model; 
    int license; 
    int ticket; 
        
    public client(int firstN, int lastN, int payment){
        this.firstN = firstN;
        this.lastN = lastN;
        this.payment = payment;
    }
        
    //this should be a different class
    /*public CilentCar (int model, int license, int ticket){
        this.model = model;
        this.license = license; 
        this.ticket = ticket;
    }*/
    
    public int getfirstN(){
        return firstN;
    }
    public int getLastN(){
        return lastN;
    }
    public int getpayment(){
        return payment;
    }
    public int getmodel(){
        return model;
    }
    public int getLicense(){
        return license;
    }
    public int getticket(){
        return ticket;
    }
    public String toString(){
        return ("name = " + this.firstN + this.lastN + " payment = " + this.payment + " car model = " + this.model + "car license = " + this.license + "client ticket = " + this.ticket);
    }
}