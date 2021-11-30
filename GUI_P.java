import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;

public class GUI_P implements ActionListener{
    public static JFrame frame;
    private static JPanel panel;
    private static JLabel label;
    private static JLabel label2;
    private static JLabel label3;
    private static JLabel label4;
    private static JButton done;
    private static double amountCharged;
    private static client Client;

    public GUI_P(boolean isCheckingOut, parkingGarage parkingGarage, int whichFloor, int whichSpot){
        frame = new JFrame();
        Client = parkingGarage.getClientAt(whichFloor-1, whichSpot-1);
        if(isCheckingOut==false){
            label = new JLabel("Thanks! You checked into Floor: "+Client.getFloor()+" Spot: "
            +Client.getSpot()+" under the name "+Client.getfirstN()+" "+Client.getLastN()
            +" at "+Client.gettimeIn()+" on "+Client.getdateIn());
        }
        done = new JButton("Main Menu");
        done.addActionListener(this);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        panel.setLayout(new GridLayout(0, 1));
        
        panel.add(label);
        panel.add(done);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Thank you for using Group 5 Parking Garage!");
        frame.pack();
        frame.setVisible(true);
    }

    public static void setAmountCharged(double newAmount, client Client){
        amountCharged = newAmount;
        label.setText("You checked in at "+Client.gettimeIn()+" on "+Client.getdateIn()
        +" and you checked out at "+Client.gettimeOut()+" on "+Client.getdateOut()+"!");
        panel.remove(done);
        label2 = new JLabel("At the rate of $1/hr for stays shorter than 12 hours and $12/day for "
        +"stays longer");
        label3 = new JLabel("than 12 hours (and a 25% discount if you're a member) a charge in the"
        +" amount of "); 
        label4 = new JLabel("$"+amountCharged+" has been made to the card you provided. Have a nice day! :)");
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(done);
        panel.revalidate();
        panel.repaint();
    }

    public static double getAmountCharged(){
        return amountCharged;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        GUI_SS.frame.setVisible(true);
    }

}
