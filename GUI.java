import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener{

    public JFrame frame;
    private JPanel panel;
    private JButton button_r;
    public static boolean isDroppingOff;
    private static int numFloors;
    private static int numSpots;
    private JButton[] floorButtons;
    public JLabel[] floorLabels;
    private boolean[] floorExists;
    private String whichFloor;
    private int intWhichFloor;
    private GUI_L[] floorGUIs;
    private static parkingGarage parkingGarage;

    public GUI(boolean isLeavingCar, int numFloor, int numSpot, parkingGarage garage) {
        isDroppingOff=isLeavingCar;
        numFloors = numFloor;
        numSpots = numSpot;
        floorExists = new boolean[numFloors];
        floorGUIs = new GUI_L[numFloors];
        parkingGarage = garage;


        frame = new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(120, 120, 40, 120));
        panel.setLayout(new GridLayout(0, 2));

        floorButtons = new JButton[numFloors];
        floorLabels = new JLabel [numFloors];
        for(int i=0; i < numFloors; i++){
            int j=i+1;
            floorButtons[i]=new JButton("Level "+j);
            floorButtons[i].setActionCommand(Integer.toString(j));
            floorButtons[i].addActionListener(this);
            panel.add(floorButtons[i]);
            floorLabels[i]=new JLabel("There are "+parkingGarage.numSpotsAvailable(i)+" spots available on this floor.");
            panel.add(floorLabels[i]);
        }
        button_r = new JButton("Return to Previous Page");
        button_r.setActionCommand("r");
        button_r.addActionListener(this);
        panel.add(button_r);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Welcome to Group 5 Parking Garage! Please indicate the space where you parked. :)");
        frame.pack();
        frame.setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("r")){
            frame.setVisible(false);
        }else{
            whichFloor = e.getActionCommand();
            intWhichFloor=Integer.parseInt(whichFloor);
            if(floorExists[intWhichFloor-1]==true){
                floorGUIs[intWhichFloor-1].frame.setVisible(true);
                floorGUIs[intWhichFloor-1].isDroppingOff=isDroppingOff;
            }else{
                floorGUIs[intWhichFloor-1]= new GUI_L(whichFloor, isDroppingOff, intWhichFloor, numSpots, parkingGarage);
                floorExists[intWhichFloor-1]=true;
            }
        }
    }
}