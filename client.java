import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class client {
    private String firstN;
    private String lastN;
    private String cardNum;
    private String phoneNum; 
    private String dateIn;
    private String timeIn;
    public String dateOut;
    public String timeOut;
    private boolean isMember;
    private int floor=0;
    private int spot=0;
    private final int millisecondsPerHour=3600000;
    private final int hourlyRate = 1;
    static final double discount = 0.75;
    static final double finalPrice = 12;
    static final int memberCharge = 20;
        
    public client(String firstN, String lastN, String cardNum, String phoneNum, 
    String dateIn, String timeIn, boolean isMember, int floor, int spot){
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

    public double getPrice(boolean becomeMember) throws ParseException{
        double price;

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Date date1 = format.parse(dateIn+" "+timeIn);
        Date date2 = format.parse(dateOut+" "+timeOut);
        double duration = date2.getTime() - date1.getTime();

        double durationInHours = (duration/millisecondsPerHour);
        double durationInDays = (durationInHours/24);

        price = durationInHours*hourlyRate;

        // the following are some edits I suggest making to get the price to work properly
		if (durationInHours > 12) {
            if(durationInDays < 1){
                price=finalPrice;
            }
            else{
                price=finalPrice*durationInDays;
            }
        }

		if(isMember == true && becomeMember == true) {
			price = price * discount + memberCharge;
			
		}
		
		if(isMember == true && becomeMember == false) {
			price = price * discount;
		}

        //the following is test code (temporary)
        System.out.println("Date in: "+date1+" Date out: "+date2+" Duration: "+durationInDays+"days Price: $"+price);
		
        //we need to ensure that the price only has two decimal places
        price=Math.round(price*100.0)/100.0;
        return price;
    }
}