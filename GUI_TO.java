import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

public class GUI_TO implements ActionListener {
    public  JFrame frame;
    private JPanel panel;
    private JButton done;
    private JLabel dateOutLabel;
    private JTextField dateOutInput;
    private JLabel timeOutLabel;
    private JTextField timeOutInput;
    private String dateOut;
    private String timeOut;
    private client Client;
    private double amountCharged;
    private static final int lengthOfDateString=10;
    private static final int lengthOfTimeString=5;
    private static final int maxMonth=12;
    private static int maxDaysInMonth=30;
    private static final int maxHours=23;
    private static final int maxMinutes=59;
    private static final String strFeb="02";
    private static final String strJan="01";
    private static final String strMar="03";
    private static final String strMay="05";
    private static final String strJul="07";
    private static final String strAug="08";
    private static final String strOct="10";
    private static final String strDec="12";
    private JLabel oopsies;
    private parkingGarage parkingGarage;
    private int whichFloor;
    private int whichSpot;
    private static boolean didJustBecomeMember=false;
    
    public GUI_TO(boolean isThisARedo, parkingGarage parkingGarage, int whichFloor, int whichSpot){
        this.parkingGarage=parkingGarage;
        this.whichFloor=whichFloor;
        this.whichSpot=whichSpot;
        done = new JButton("Click here when finished.");
        done.setActionCommand("d");
        done.addActionListener(this);

        frame=new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(120, 120, 40, 120));
        panel.setLayout(new GridLayout(0, 1));

        dateOutLabel = new JLabel("Please Indicate Today's Date (MM/DD/YYYY):");
        dateOutInput = new JTextField("");
        timeOutLabel = new JLabel("Please Indicate the Current Time Using the Military"+
        "/24-Hour System(HH:mm)");
        timeOutInput = new JTextField("");

        if(isThisARedo==true){
            oopsies = new JLabel("Oops! That information wasn't formatted correctly! Please try again! :)");
            panel.add(oopsies);
        }
        panel.add(dateOutLabel);
        panel.add(dateOutInput);
        panel.add(timeOutLabel);
        panel.add(timeOutInput);
        panel.add(done);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Please provide the information below:");
        frame.pack();
        frame.setVisible(true);
    }

    public static void setDidJustBecomeMember(boolean ans){
        didJustBecomeMember=ans;
    }

    public static boolean isInteger(String str, int start, int end) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i=start; i < end; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isDateFormatted(String timeOut, String dateOut){
        boolean isFormattedCorrectly=true;
        String month;
        String day;
        String year;
        String hour;
        String minute;
        int maxDaysInFeb=28;
        //if the date string isn't the length we desire then we automatically know it's wrong
        if(dateOut.length()!=lengthOfDateString){
            isFormattedCorrectly=false;
        //if the first two characters of the date aren't integers then 
        //we automatically know it's wrong
        }else if(isInteger(dateOut, 0, 2)==false){
            isFormattedCorrectly=false;
        //if the third and fourth characters of the date aren't integers then
        //we automatically know it's wrong
        }else if(isInteger(dateOut, 3, 5)==false){
            isFormattedCorrectly=false;
        //if the year isn't represented only in integers then
        //we automatically know it's wrong
        }else if(isInteger(dateOut, 6,dateOut.length())==false){
            isFormattedCorrectly=false;
        //if the '/' isn't here then the formatter won't take the date
        }else if(dateOut.charAt(2)!= '/'){
            isFormattedCorrectly=false;
        //if the '/' isn't here then the formatter won't take the date
        }else if(dateOut.charAt(5)!= '/'){
            isFormattedCorrectly=false;
        //if the time string isn't the length we desire then we automatically know it's wrong
        }else if(timeOut.length()!=lengthOfTimeString){
            isFormattedCorrectly=false;
        //if the first two characters of the time aren't integers then 
        //we automatically know it's wrong
        }else if(isInteger(timeOut, 0, 2)==false){
            isFormattedCorrectly=false;
        //if the third and fourth characters of the time aren't integers then
        //we automatically know it's wrong
        }else if(isInteger(timeOut, 3, 5)==false){
            isFormattedCorrectly=false;
        //if the ':' isn't here then the formatter won't take the time
        }else if(timeOut.charAt(2)!= ':'){
            isFormattedCorrectly=false;
        }else{
            month=dateOut.substring(0, 2);
            day=dateOut.substring(3, 5);
            year=dateOut.substring(6, dateOut.length());
            hour=timeOut.substring(0, 2);
            minute=timeOut.substring(3, 5);
            if(Integer.parseInt(month)>maxMonth){
                isFormattedCorrectly=false;
            //if the day is the 31st, we have to make sure it is in a month with 31 days
            }else if(Integer.parseInt(day)>maxDaysInMonth){
                isFormattedCorrectly=false;
                if((month.compareTo(strJan)==0 || month.compareTo(strMar)==0 || month.compareTo(strMay)==0
                || month.compareTo(strJul)==0 || month.compareTo(strAug)==0 || month.compareTo(strOct)==0
                || month.compareTo(strDec)==0) && Integer.parseInt(day)==31){
                    isFormattedCorrectly=true;
                }
            }else if(Integer.parseInt(hour)>maxHours){
                isFormattedCorrectly=false;
            }else if(Integer.parseInt(minute)>maxMinutes){
                isFormattedCorrectly=false;
            //now we have to make sure they aren't going over the number of days in February
            }else if(month.compareTo(strFeb)==0){
                //have to be sure to include the case for leap years
                if((Integer.parseInt(year)%4)==0){
                    if((Integer.parseInt(year)%100)==0 && (Integer.parseInt(year)%400)==0){
                        maxDaysInFeb=29;
                    }else if((Integer.parseInt(year)%100) != 0){
                        maxDaysInFeb=29;
                    }
                }
                if(Integer.parseInt(day)>maxDaysInFeb){
                    isFormattedCorrectly=false;
                }
            }
        }
        return isFormattedCorrectly;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            dateOut = dateOutInput.getText();
            timeOut = timeOutInput.getText();
            //the following line is for testing purposes only and should be
            //replaced with an instance of grabbing a specific client from the 
            //database when that becomes possible
            Client = parkingGarage.getClientAt(whichFloor-1, whichSpot-1);
            Client.setdateOut(dateOut);
            Client.settimeOut(timeOut);
            if(isDateFormatted(timeOut, dateOut)==true){
                System.out.println(Client.toString()); //this line is temporary for testing
                try {
                    amountCharged=Client.getPrice(didJustBecomeMember);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                new GUI_P(true, parkingGarage, whichFloor, whichSpot);
                GUI_P.setAmountCharged(amountCharged, Client);
                //test code
                System.out.println(GUI_P.getAmountCharged());
            }else{
                new GUI_TO(true, parkingGarage, whichFloor, whichFloor);
            }
            GUI.updateLabels();
            frame.setVisible(false);
    }
}