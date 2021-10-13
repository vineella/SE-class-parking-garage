import java.util.Scanner;
import java.sql;
import java.math;
//super rough draft//
//import are for database connection//
//will rewrite/review it, but this is likely how it will be written or I might change it//

public class client {
    public static void main(String[] args) {
        int firstN;
        int LastN; 
        int payment; 
        int model; 
        int license; 
        int ticket; 
        
        public client(int firstN, int LastN, int payment){
            this.firstN = firstN;
            this.LastN = LastN;
            this.payment = payment;
        }
        
        public CilentCar (int model, int license, int ticket){
            this.model = model;
            this.license = license; 
            this.ticket = ticket;
        }
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
        public toString(){
            system.out.println("name = " + this.firstN + this.lastN + " payment = " + this.payment + " car model = " + this.model + "car license = " + this.license + "client ticket = " + this.ticket);
        }
    }
}
