import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class GUI_SS implements ActionListener{
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JButton coming;
    private JButton leaving;
    private GUI garage;
    private int gDoesExist;

    public GUI_SS(){

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

    public static void main(String[] args){
        new GUI_SS();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("c")){
            garage.isDroppingOff = true;
        }else if(e.getActionCommand().equals("l")){
            garage.isDroppingOff = false;
        }
        if(gDoesExist==1){
            garage.frame.setVisible(true);
        }else{
            garage = new GUI(true);
            gDoesExist = 1;
        }
    }
}
