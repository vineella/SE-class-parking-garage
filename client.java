public class client {
    private String firstN;
    private String lastN;
    private int cardNum;
    private int phoneNum; 
    private int timeIn;
    private boolean isMember;
        
    public client(String firstN, String lastN, int cardNum, int phoneNum, int timeIn, boolean isMember){
        this.firstN = firstN;
        this.lastN = lastN;
        this.cardNum = cardNum;
        this.phoneNum = phoneNum;
        this.timeIn = timeIn;
        this.isMember = isMember;
    }
        
    //this should be a different class
    /*public CilentCar (int model, int license, int ticket){
        this.model = model;
        this.license = license; 
        this.ticket = ticket;
    }*/
    
    public String getfirstN(){
        return firstN;
    }
    public String getLastN(){
        return lastN;
    }
    public int getcardNum(){
        return cardNum;
    }
    public int getphoneNum(){
        return phoneNum;
    }
    public int gettimeIn(){
        return timeIn;
    }
    public boolean getisMember(){
        return isMember;
    }
    public String toString(){
        return ("name = " + this.firstN + this.lastN + "card number =" + this.cardNum + "phone number =" + this.phoneNum + " time in = " + this.timeIn + "is member = " + this.isMember);
    }
}