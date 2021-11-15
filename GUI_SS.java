import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class GUI_SS implements ActionListener{
    private JLabel label;
    public static JFrame frame;
    private JPanel panel;
    private JButton coming;
    private JButton leaving;
    private GUI garage;
    private int gDoesExist;
    private static int numFloors;
    private static int numSpots;
    private parkingGarage parkingGarage;

    public GUI_SS(int numFloor, int numSpot){
        numFloors=numFloor;
        numSpots=numSpot;
        parkingGarage = new parkingGarage(numFloors, numSpots);

        frame = new JFrame();

        coming = new JButton("I am leaving my car here");
        leaving = new JButton("I am leaving with my car");
        
        coming.setActionCommand("c");
        leaving.setActionCommand("l");

        coming.addActionListener(this);
        leaving.addActionListener(this);

        label = new JLabel("Please select an option below.");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 60, 200));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(coming);
        panel.add(leaving);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Welcome to Group 5 Parking Garage!");
        frame.pack();
        frame.setVisible(true);
    }

    public static int getNumFloors(){
        return numFloors;
    }

    public static int getNumSpots(){
        return numSpots;
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i=0; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static int findNumFloor(){
        int numFloor=0;
        System.out.println("How many floors would you like in your garage?");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if(isInteger(str)==true){
            numFloor = Integer.parseInt(str);
        }
        return numFloor;
    }

    public static int findNumSpot(){ 
        int numSpot=0;
        System.out.println("How many spots would you like on each floor?");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if(isInteger(str)==true){
            numSpot = Integer.parseInt(str);
        }
        return numSpot;
    }


    public static void main(String[] args){
        //eventually we will need for this to check if there is an already existing garage
        //that the person wants to use, and if so, not do the following stuff
        //if there already is a garage in use, then we will just skip to the GUI_SS of that garage
        int numFloor=findNumFloor();
        while(numFloor == 0){
            System.out.println("Please enter a positive integer only.");
            numFloor=findNumFloor();
        }
        int numSpot = findNumSpot();
        while(numSpot == 0){
            System.out.println("Please enter a positive integer only.");
            numSpot=findNumSpot();
        }
        new GUI_SS(numFloor, numSpot);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //the value of IDO doesn't matter in the line below.
        //It is just to initialize it in a form the final else
        //statement will accept.
        boolean IDO =true;
        if(e.getActionCommand().equals("c")){
            IDO = true;
            garage.isDroppingOff = IDO;
        }else if(e.getActionCommand().equals("l")){
            IDO = false;
            garage.isDroppingOff = IDO;
        }
        if(gDoesExist==1){
            garage.frame.setVisible(true);
        }else{
            garage = new GUI(IDO, numFloors, numSpots, parkingGarage);
            gDoesExist = 1;
        }
    }
}
