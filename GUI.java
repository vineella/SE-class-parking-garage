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
    private JButton button_g1;
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton button_r;
    private GUI_L negative_first;
    private GUI_L first;
    private GUI_L second;
    private GUI_L third;
    private int nDoesExist;
    private int fDoesExist;
    private int sDoesExist;
    private int tDoesExist;
    public static boolean isDroppingOff;

    public GUI(boolean isLeavingCar) {
        isDroppingOff=isLeavingCar;

        frame = new JFrame();

        button_g1 = new JButton("Level G1");
        button_1 = new JButton("Level 1");
        button_2 = new JButton("Level 2");
        button_3 = new JButton("Level 3");
        button_r = new JButton("Return to Previous Page");

        button_g1.setActionCommand("g1");
        button_1.setActionCommand("1");
        button_2.setActionCommand("2");
        button_3.setActionCommand("3");
        button_r.setActionCommand("r");

        button_g1.addActionListener(this);
        button_1.addActionListener(this);
        button_2.addActionListener(this);
        button_3.addActionListener(this);
        button_r.addActionListener(this);

        label = new JLabel("Please indicate the space where you parked. :)");


        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(120, 120, 40, 120));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button_g1);
        panel.add(button_1);
        panel.add(button_2);
        panel.add(button_3);
        panel.add(button_r);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Welcome to Group 5 Parking Garage!");
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args){
        new GUI(isDroppingOff);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("r")){
            frame.setVisible(false);
        }else if(e.getActionCommand().equals("g1")){
            if(nDoesExist==1){
                negative_first.frame.setVisible(true);
                negative_first.isDroppingOff=isDroppingOff;
            }else{
                negative_first = new GUI_L("g1", isDroppingOff);
                nDoesExist = 1;
            }
        }
        else if(e.getActionCommand().equals("1")){
            if(fDoesExist==1){
                first.frame.setVisible(true);
                first.isDroppingOff=isDroppingOff;
            }else{
                first = new GUI_L("1", isDroppingOff);
                fDoesExist = 1;
            }
        }
        else if(e.getActionCommand().equals("2")){
            if(sDoesExist==1){
                second.frame.setVisible(true);
                second.isDroppingOff=isDroppingOff;
            }else{
                second = new GUI_L("2", isDroppingOff);
                sDoesExist = 1;
            }
        }
        else if(e.getActionCommand().equals("3")){
            if(tDoesExist==1){
                third.frame.setVisible(true);
                third.isDroppingOff=isDroppingOff;
            }else{
                third = new GUI_L("3", isDroppingOff);
                tDoesExist = 1;
            }
        }
    }
}