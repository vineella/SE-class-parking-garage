public class client {
    private String firstN;
    private String lastN;
    private String cardNum;
    private String phoneNum; 
    private String dateIn;
    private String timeIn;
    private String dateOut;
    private String timeOut;
    private boolean isMember;
    private int floor;
    private int spot;
        
    public client(String firstN, String lastN, String cardNum, String phoneNum, String dateIn, String timeIn, boolean isMember, int floor, int spot){
        this.firstN = firstN;
        this.lastN = lastN;
        this.cardNum = cardNum;
        this.phoneNum = phoneNum;
        this.dateIn = dateIn;
        this.timeIn = timeIn;
        this.isMember = isMember;
        this.floor = floor;
        this.spot = spot;
    }
    
    public String getfirstN(){
        return firstN;
    }
    public String getLastN(){
        return lastN;
    }
    public String getcardNum(){
        return cardNum;
    }
    public String getphoneNum(){
        return phoneNum;
    }
    public String getdateIn(){
        return dateIn;
    }
    public String gettimeIn(){
        return timeIn;
    }
    public void setdateOut(String newDateOut){
        dateOut=newDateOut;
    }
    public String getdateOut(){
        return dateOut;
    }
    public void settimeOut(String newTimeOut){
        timeOut=newTimeOut;
    }
    public String gettimeOut(){
        return timeOut;
    }
    public boolean getisMember(){
        return isMember;
    }
    public int getFloor(){
        return floor;
    }
    public int getSpot(){
        return spot;
    }
    public String toString(){
        return ("name = " + this.firstN + " " + this.lastN + " card number =" + this.cardNum + 
        " phone number =" + this.phoneNum + " date in = " + this.dateIn + " time in = " + this.timeIn + 
        " date out = " + this.dateOut + " time out = " + this.timeOut + " is member = " + this.isMember +
        " floor: " + floor + " spot: " + spot);
    }
}