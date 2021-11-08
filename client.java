import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.time.format.SimpleDateFormat;
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

    public static double getPrice(String timeIn, String timeOut, String dateIn, String dateOut, boolean lostTicket, boolean isMember){
        double price = 0; /*
        Scanner input1 = new Scanner(System.in);
        System.out.print("Please enter what time you have entered the parking garage in millitary time as such HH:MM");
        String time1 = input1.nextLine();
        
        Scanner input2 = new Scanner(System.in);
        System.out.print("Please enter what time you have entered the parking garage in millitary time as such HH:MM");
        String time2 = input2.nextLine(); */

        SimpleDateFormat format = new SimpleDateFormat("HH:MM");
        Date date1 = format.parse(timeIn);
        Date date2 = format.parse(timeOut);
        int hours = date2.getTime() - date1.getTime();
        
        SimpleDateFormat formatD = new SimpleDateFormat("MM/DD/YYYY");
        Date dayE = formatD.parse(dateIn);
        Date dayL = formatD.parse(dateOut);
        int days = dayL.getDays() - dayE.getDays();
        
        int duration = hours + (days * 24);

        price = duration;

        if(duration>=12) {
			price = 12;
		}
		
		if(lostTicket == true) {
			price = 18;
		}
		
		if(isMember == true) {
			price = price * 0.75;
		}
		
		return price;
    }
}