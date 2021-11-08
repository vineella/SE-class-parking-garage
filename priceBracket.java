package prices;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.Scanner;
   

public class priceBracket {
	static final double discount = 0.75;
	static final double finalPrice = 12;
	static final double lostPrice = 18;
	
	public static double getPrice(boolean lostTicket, boolean isMember, boolean hasInsurance) {
		
		double price = 0;
		double change = 0;
		
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter first and last name: ");
        String name =  sc.nextLine();
        
        Scanner inf = new Scanner(System.in);
        System.out.print("Enter hours parked: ");
        double hours = inf.nextDouble();
		
		price = hours;
		
		if(hours>=12) {
			price = finalPrice;
		}
		
		if(lostTicket == true) {
			price = lostPrice;
		}
		
		if(isMember == true) {
			price = price * discount;
		}
		
		if (hasInsurance == true) {
			price = price + 5;
		}
		
		if(hasInsurance == true && lostTicket == true) {
			price = hours;
		}
		
		System.out.println(name + ", you owe $" + price + " today");
		
		
		Scanner in = new Scanner(System.in);
        System.out.print("Enter cash ammount: ");
        double moneyGiven = in.nextInt();
        
        if(moneyGiven < price) {
        	Scanner tp = new Scanner(System.in);
        	System.out.print("Insufficient funds please insert more cash: ");
            double money = tp.nextInt();
            moneyGiven = moneyGiven + money;
  
        }
        
		change = moneyGiven - price;
		System.out.println("Thank you " + name + ", your change is: $" + change);
		System.out.println("Have a nice day!");
	
		return price;
	}
	
	public static void main(String[] args) {
		getPrice(true, false, true);
	}

}
