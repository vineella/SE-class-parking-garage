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
    private JFrame frame;
    private JPanel panel;
    private JButton coming;
    private JButton leaving;
    private GUI garage;
    private int gDoesExist;
    private int numFloors;
    private int numSpots;

    public GUI_SS(int numFloor, int numSpot){
        numFloors=numFloor;
        numSpots=numSpot;

        frame = new JFrame();

        coming = new JButton("I am leaving my car here");
        leaving = new JButton("I am leaving with my car");
        
        coming.setActionCommand("c");
        leaving.setActionCommand("l");

        coming.addActionListener(this);
        leaving.addActionListener(this);

        label = new JLabel("Please select an option below.");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(120, 120, 40, 120));
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

    public static int findNumFloor(){
        System.out.println("How many floors would you like in your garage?");
        Scanner in = new Scanner(System.in);
        int numFloor = in.nextInt();
        return numFloor;
    }

    public static int findNumSpot(){ 
        System.out.println("How many spots would you like on each floor?");
        Scanner in = new Scanner(System.in);
        int numSpot = in.nextInt();
        return numSpot;
    }


    public static void main(String[] args){
        int numFloor = findNumFloor();
        int numSpot = findNumSpot();
        //following line is temporary for testing only
        System.out.println("Floors: "+numFloor+" Spots: "+numSpot);
        new GUI_SS(numFloor, numSpot);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //the value of IDO doesn't matter in the line below
        //this is just to initialize it in a form the final else
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
            garage = new GUI(IDO, numFloors, numSpots);
            gDoesExist = 1;
        }
    }
}
