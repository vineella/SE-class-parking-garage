import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener{

    private JLabel label;
    public JFrame frame;
    private JPanel panel;
    private JButton button_r;
    public static boolean isDroppingOff;
    private static int numFloors;
    private static int numSpots;
    private JButton[] floorButtons;
    private boolean[] floorExists;
    private String whichFloor;
    private int intWhichFloor;
    private GUI_L[] floorGUIs;

    public GUI(boolean isLeavingCar, int numFloor, int numSpot) {
        isDroppingOff=isLeavingCar;
        numFloors = numFloor;
        numSpots = numSpot;
        floorExists = new boolean[numFloors];
        floorGUIs = new GUI_L[numFloors];

        frame = new JFrame();

        label = new JLabel("Please indicate the space where you parked. :)");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(120, 120, 40, 120));
        panel.setLayout(new GridLayout(0, 1));

        floorButtons = new JButton[numFloors];
        for(int i=0; i < numFloors; i++){
            int j=i+1;
            floorButtons[i]=new JButton("Level "+j);
            floorButtons[i].setActionCommand(Integer.toString(j));
            floorButtons[i].addActionListener(this);
            panel.add(floorButtons[i]);
        }
        button_r = new JButton("Return to Previous Page");
        button_r.setActionCommand("r");
        button_r.addActionListener(this);
        panel.add(button_r);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Welcome to Group 5 Parking Garage!");
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args){
        new GUI(isDroppingOff, numFloors, numSpots);
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
                //will have to change this to match the updated form
                floorGUIs[intWhichFloor-1]= new GUI_L(whichFloor, isDroppingOff, numSpots);
                floorExists[intWhichFloor-1]=true;
            }
        }
    }
}