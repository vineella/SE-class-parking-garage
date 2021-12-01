import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class GUI_SS implements ActionListener{
    private JLabel prelabel;
    private static JLabel label;
    public static JFrame preframe;
    public static JFrame frame;
    private JPanel prepanel;
    private static JPanel panel;
    private JButton oldGarage;
    private JButton newGarage;
    private static JButton coming;
    private static JButton leaving;
    private GUI garage;
    private int gDoesExist;
    private static int numFloors;
    private static int numSpots;
    private static parkingGarage parkingGarage;
    private static boolean isUsingOldGarage=false;
    private JButton shutdown;

    public GUI_SS(){
        preframe = new JFrame();

        oldGarage = new JButton("I would like to use my previous garage.");
        newGarage = new JButton("I would like to start a new garage.");

        oldGarage.setActionCommand("o");
        newGarage.setActionCommand("n");

        oldGarage.addActionListener(this);
        newGarage.addActionListener(this);

        prelabel = new JLabel("Please select an option");

        prepanel = new JPanel();

        prepanel.setBorder(BorderFactory.createEmptyBorder(200, 200, 60, 200));
        prepanel.setLayout(new GridLayout(0, 1));
        prepanel.add(prelabel);
        prepanel.add(oldGarage);
        prepanel.add(newGarage);
    
        preframe.add(prepanel, BorderLayout.CENTER);
        preframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        preframe.setTitle("Please select an option below.");
        preframe.pack();
        preframe.setVisible(true);
    }

    public static void setGarage(int numFloors, int numSpots){
        parkingGarage = new parkingGarage(numFloors, numSpots);
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

    public static void findGarageSize(){
        numFloors=findNumFloor();
        while(numFloors == 0){
            System.out.println("Please enter a positive integer only.");
            numFloors=findNumFloor();
        }
        numSpots = findNumSpot();
        while(numSpots == 0){
            System.out.println("Please enter a positive integer only.");
            numSpots=findNumSpot();
        }
    }

    public void pullUpgarage(){
        if(isUsingOldGarage==true){
            //load old garage
        }else{
            findGarageSize();
            setGarage(numFloors, numSpots);

            frame = new JFrame();

            coming = new JButton("I am leaving my car here");
            leaving = new JButton("I am leaving with my car");
            shutdown = new JButton("Power Off");


            coming.setActionCommand("c");
            leaving.setActionCommand("l");
            shutdown.setActionCommand("s");
    
            coming.addActionListener(this);
            leaving.addActionListener(this);
            shutdown.addActionListener(this);
    
            label = new JLabel("Please select an option below.");
    
            panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 60, 200));
            panel.setLayout(new GridLayout(0, 1));
            panel.add(label);
            panel.add(coming);
            panel.add(leaving);
            panel.add(shutdown);
    
            frame.add(panel, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Welcome to Group 5 Parking Garage!");
            frame.pack();
            frame.setVisible(true);
        }
    }

    public static void main(String[] args){
        new GUI_SS();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //the value of IDO doesn't matter in the line below.
        //It is just to initialize it in a form the final else
        //statement will accept.
        if(e.getActionCommand().equals("o")){
            isUsingOldGarage = true;
            pullUpgarage();
            preframe.setVisible(false);
        }else if(e.getActionCommand().equals("n")){
            isUsingOldGarage = false;
            pullUpgarage();
            preframe.setVisible(false);
        }else if (e.getActionCommand().equals("s")){ 
            //where we read out the garage to the flat file
        }else{
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
}