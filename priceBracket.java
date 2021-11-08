package prices;

public class Program {
	
	public static int getPrice(int hours, boolean lostTicket) {
		int price = 0;
		price = hours;
		
		if(hours>=12) {
			price = 12;
		}
		
		if(lostTicket == true) {
			price = 18;
		}
		
		return price;
	}
	
	public static void main(String[] args) {
		System.out.print(getPrice(13, false));
	}

}
