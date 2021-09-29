package prices;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.Scanner;
   

public class priceBracket {
	
	public static double getPrice(int hours, boolean lostTicket, boolean isMember) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		boolean hasLeft = false;
		Scanner in = new Scanner(System.in);
        System.out.print("Enter 1 when you have left: ");
        int done = in.nextInt();
        
		double price = 0;
		if(done == 1) {
			DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			price = dtf1 - dtf;
		}
		price = hours;
		
		if(hours>=12) {
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
	
	public static void main(String[] args) {
		System.out.print(getPrice(13, false, true));
	}

}
