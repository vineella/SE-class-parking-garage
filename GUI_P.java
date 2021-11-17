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
    private JButton done;
    private static double amountCharged;
    private client Client;

    public GUI_P(boolean isCheckingOut){
        frame = new JFrame();
        Client = GUI_I.getClient();
        if(isCheckingOut==true){
            label = new JLabel("A charge in the amount of $"+amountCharged+" has been made to the "+ 
            "card you provided. Have a nice day! :)");
        }else{
            label = new JLabel("Thanks! You checked into Floor: "+Client.getFloor()+" Spot: "+Client.getSpot()+" under the name "+Client.getfirstN()+" "+Client.getLastN()+" at "+Client.gettimeIn()+" on "+Client.getdateIn());
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

    public static void setAmountCharged(double newAmount){
        amountCharged = newAmount;
        label.setText("A charge in the amount of $"+amountCharged+" has been made to the "+ 
        "card you provided. Have a nice day! :)");
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
