import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class GUI_L implements ActionListener {
    private JLabel label;
    public  JFrame frame;
    private JPanel panel;
    private JButton button_r;
    private static String lv;
    public static boolean isDroppingOff;
    private static int intWhichFloor;
    private static int numSpots;
    private JButton[] spotButtons;
    private String whichSpot;
    private int intWhichSpot;
    private static parkingGarage parkingGarage;
    private int[][] garageArray;

    public GUI_L(String level, boolean isLeavingCar,int floor, int numSpot, parkingGarage garage) {
        lv=level;
        isDroppingOff=isLeavingCar;
        intWhichFloor=floor;
        numSpots=numSpot;
        parkingGarage = garage;
        garageArray = parkingGarage.getArray();

        frame = new JFrame();
        label = new JLabel("Please indicate the space where you parked. :)");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(120, 120, 40, 120));
        panel.setLayout(new GridLayout(0, 5));

        spotButtons = new JButton[numSpots];
        for(int i=0; i < numSpots; i++){
            int j=i+1;
            spotButtons[i]=new JButton("Spot "+j);
            spotButtons[i].setActionCommand(Integer.toString(j));
            spotButtons[i].addActionListener(this);
            panel.add(spotButtons[i]);
        }
        button_r = new JButton("Return to Previous Page");
        button_r.setActionCommand("r");
        button_r.addActionListener(this);
        panel.add(button_r);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("You are selecting from: Level "+lv);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new GUI_L(lv, isDroppingOff, intWhichFloor, numSpots, parkingGarage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("r")){
            frame.setVisible(false);
        }else if(isDroppingOff == true){
            //here we only want this to happen if we check the garage 
            //class and the spot is actually empty
            whichSpot=e.getActionCommand();
            intWhichSpot=Integer.parseInt(whichSpot);
            if(parkingGarage.isAvailable(garageArray, intWhichFloor-1,intWhichSpot-1)==true){
                garageArray[intWhichFloor-1][intWhichSpot-1]=1;
                spotButtons[intWhichSpot-1].setText("Spot "+intWhichSpot+" TAKEN");
                panel.revalidate();
                panel.repaint();
                new GUI_I(intWhichFloor, intWhichSpot);
                frame.setVisible(false);
            }
        }else if(isDroppingOff == false){
            //here we only want this to happen if we check the garage 
            //class and the spot is actually taken
            whichSpot=e.getActionCommand();
            intWhichSpot=Integer.parseInt(whichSpot);
            if(parkingGarage.isAvailable(garageArray, intWhichFloor-1,intWhichSpot-1)==false){
            garageArray[intWhichFloor-1][intWhichSpot-1]=0;
            spotButtons[intWhichSpot-1].setText("Spot "+whichSpot);
            panel.revalidate();
            panel.repaint();

            new GUI_TO();
            frame.setVisible(false);
            }
        }
    }
}