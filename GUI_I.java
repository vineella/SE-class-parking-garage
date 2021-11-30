import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class GUI_I implements ActionListener{
    public  JFrame frame;
    private JPanel panel;
    private JButton done;
    private JLabel firstNameLabel;
    private JTextField firstNameInput;
    private JLabel lastNameLabel;
    private JTextField lastNameInput;
    private JLabel cardNumberLabel;
    private JTextField cardNumberInput;
    private JLabel phoneNumberLabel;
    private JTextField phoneNumberInput;
    private JLabel dateInLabel;
    private JTextField dateInInput;
    private JLabel timeInLabel;
    private JTextField timeInInput;
    private JLabel isMember;
    private JButton isMemberInput;
    private boolean boolIsMember;
    private int whichFloor;
    private int whichSpot;
    private String firstName;
    private String lastName;
    private String cardNumber;
    private String phoneNumber;
    private String dateIn;
    private String timeIn;
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


    public GUI_I(int whichFloor, int whichSpot, boolean isThisARedo, parkingGarage parkingGarage){
        this.whichFloor=whichFloor;
        this.whichSpot=whichSpot;
        this.parkingGarage=parkingGarage;
        done = new JButton("Click here when finished.");
        done.setActionCommand("d");
        done.addActionListener(this);
        firstNameLabel = new JLabel("Please input your first name.");
        firstNameInput = new JTextField("");
        lastNameLabel = new JLabel("Please input your last name.");
        lastNameInput = new JTextField("");
        cardNumberLabel = new JLabel("Please input your credit card number");
        cardNumberInput = new JTextField("");
        phoneNumberLabel = new JLabel("Please input your phone number");
        phoneNumberInput = new JTextField("");
        dateInLabel = new JLabel("Please Indicate Today's Date (MM/DD/YYYY):");
        dateInInput = new JTextField("");
        timeInLabel = new JLabel("Please Indicate the Current Time Using the Military"+
        "/24-Hour System(HH:mm)");
        timeInInput = new JTextField("");


        frame = new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(210, 210, 65, 210));
        panel.setLayout(new GridLayout(0, 1));


        if(isThisARedo==true){
            oopsies = new JLabel("Oops! That information wasn't formatted correctly! Please try again! :)");
            panel.add(oopsies);
        }
        panel.add(firstNameLabel);
        panel.add(firstNameInput);
        panel.add(lastNameLabel);
        panel.add(lastNameInput);
        panel.add(cardNumberLabel);
        panel.add(cardNumberInput);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberInput);
        panel.add(dateInLabel);
        panel.add(dateInInput);
        panel.add(timeInLabel);
        panel.add(timeInInput);

        if(boolIsMember==false){
            isMember = new JLabel("Would you like to become a member?" +
            "(This adds a $20 charge to your account, but gives you 25%"
            + "off per hour you stay here for the next 30 days)");
            isMemberInput = new JButton("Click here to become a member!");
            isMemberInput.setActionCommand("m");
            isMemberInput.addActionListener(this);
            panel.add(isMember);
            panel.add(isMemberInput);
        }
        panel.add(done);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Please provide the information below:");
        frame.pack();
        frame.setVisible(true);
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

    public static boolean isDateFormatted(String timeIn, String dateIn){
        boolean isFormattedCorrectly=true;
        String month;
        String day;
        String year;
        String hour;
        String minute;
        int maxDaysInFeb=28;
        //if the date string isn't the length we desire then we automatically know it's wrong
        if(dateIn.length()!=lengthOfDateString){
            isFormattedCorrectly=false;
        //if the first two characters of the date aren't integers then 
        //we automatically know it's wrong
        }else if(isInteger(dateIn, 0, 2)==false){
            isFormattedCorrectly=false;
        //if the third and fourth characters of the date aren't integers then
        //we automatically know it's wrong
        }else if(isInteger(dateIn, 3, 5)==false){
            isFormattedCorrectly=false;
        //if the year isn't represented only in integers then
        //we automatically know it's wrong
        }else if(isInteger(dateIn, 6,dateIn.length())==false){
            isFormattedCorrectly=false;
        //if the '/' isn't here then the formatter won't take the date
        }else if(dateIn.charAt(2)!= '/'){
            isFormattedCorrectly=false;
        //if the '/' isn't here then the formatter won't take the date
        }else if(dateIn.charAt(5)!= '/'){
            isFormattedCorrectly=false;
        //if the time string isn't the length we desire then we automatically know it's wrong
        }else if(timeIn.length()!=lengthOfTimeString){
            isFormattedCorrectly=false;
        //if the first two characters of the time aren't integers then 
        //we automatically know it's wrong
        }else if(isInteger(timeIn, 0, 2)==false){
            isFormattedCorrectly=false;
        //if the third and fourth characters of the time aren't integers then
        //we automatically know it's wrong
        }else if(isInteger(timeIn, 3, 5)==false){
            isFormattedCorrectly=false;
        //if the ':' isn't here then the formatter won't take the time
        }else if(timeIn.charAt(2)!= ':'){
            isFormattedCorrectly=false;
        }else{
            month=dateIn.substring(0, 2);
            day=dateIn.substring(3, 5);
            year=dateIn.substring(6, dateIn.length());
            hour=timeIn.substring(0, 2);
            minute=timeIn.substring(3, 5);
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
        if(e.getActionCommand().equals("m")){
            isMemberInput.setText("You are now a member! :)");
            isMemberInput.setActionCommand("n");
            panel.revalidate();
            panel.repaint();
            boolIsMember=true;
        }else if(e.getActionCommand().equals("n")==false){
            firstName = firstNameInput.getText();
            lastName = lastNameInput.getText();
            cardNumber = cardNumberInput.getText();
            phoneNumber = phoneNumberInput.getText();
            dateIn = dateInInput.getText();
            timeIn = timeInInput.getText();
            if(isDateFormatted(timeIn, dateIn)==true){
                client newClient = new client(firstName, lastName, cardNumber, phoneNumber, 
                dateIn, timeIn, boolIsMember, whichFloor, whichSpot);
                parkingGarage.setClientAt(whichFloor-1, whichSpot-1, newClient);
                //this line is temporary for testing
                System.out.println(newClient.toString()); 
            }else{
                new GUI_I(whichFloor, whichSpot, true, parkingGarage);
            }
            new GUI_P(false, parkingGarage, whichFloor, whichSpot);
            GUI.updateLabels();
            frame.setVisible(false);
        }
    }
}