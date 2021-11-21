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
    private String dateOut;
    private String timeOut;
    private boolean isMember;
    private boolean hasInsurance;
    private boolean lostTicket
    private int floor;
    private int spot;
    private final int millisecondsPerHour=3600000;
    private final int hourlyRate = 1;
    static final double discount = 0.75;
    static final double ins = 2;
    static final double finalPrice = 12;
    static final double lostPrice = 18;
        
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

    public double getPrice() throws ParseException{
        double price;

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Date date1 = format.parse(dateIn+" "+timeIn);
        Date date2 = format.parse(dateOut+" "+timeOut);
        double duration = date2.getTime() - date1.getTime();

        double durationInHours = (duration/millisecondsPerHour);
        double durationInDays = (durationInHours/24);

        price = durationInHours*hourlyRate;
        
		if(isMember == true) {
			price = price * discount;
		}
		
		if(hasInsurance == true) {
			price = price + ins;
		}
		
		if (durationInHours > 12) {
			price = finalPrice;
			if(durationInHours % 24 == 0) {
				price = durationInDays * finalPrice;
			}
		
		}
		
		if(lostTicket == true) {
			price = lostPrice;
		}
		
		if(hasInsurance == true && lostTicket == true) {
			price = hours;
		}
		
		

        //the following is test code (temporary)
        System.out.println("Date in: "+date1+" Date out: "+date2+" Duration: "+duration+"ms Price: $"+price);
		
        //we need to ensure that the price only has two decimal places
        Math.round((price*100.0)/100.0);
        return price;
    }
}