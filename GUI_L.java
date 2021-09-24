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
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton button_4;
    private JButton button_5;
    private JButton button_r;
    private static String lv;

    //this holds the info of which spot a user has taken
    private int which_level;
    private int which_spot;

    public GUI_L(String level) {
        lv=level;

        frame = new JFrame();

        button_1 = new JButton("1");
        button_2 = new JButton("2");
        button_3 = new JButton("3");
        button_4 = new JButton("4");
        button_5 = new JButton("5");
        button_r = new JButton("Return to Previous Page");

        button_1.addActionListener(this);
        button_2.addActionListener(this);
        button_3.addActionListener(this);
        button_4.addActionListener(this);
        button_5.addActionListener(this);
        button_r.addActionListener(this);

        label = new JLabel("Please indicate the space where you parked. :)");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(120, 120, 40, 120));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button_1);
        panel.add(button_2);
        panel.add(button_3);
        panel.add(button_4);
        panel.add(button_5);
        panel.add(button_r);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if(level.equals("g1")){
            frame.setTitle("You are selecting from: Level G1");
            which_level=-1;
        }else if(level.equals("1")){
            frame.setTitle("You are selecting from: Level 1");
            which_level=1;
        }else if(level.equals("2")){
            frame.setTitle("You are selecting from: Level 2");
            which_level=2;
        }else if(level.equals("3")){
            frame.setTitle("You are selecting from: Level 3");
            which_level=3;
        }
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new GUI_L(lv);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Return to Previous Page")){
            frame.setVisible(false);
        }else{
            which_spot=Integer.parseInt(e.getActionCommand());
            if(e.getActionCommand().equals("1")){
                button_1.setText("Spot 1 TAKEN");
                button_1.removeActionListener(this);
            }else if(e.getActionCommand().equals("2")){
                button_2.setText("Spot 2 TAKEN");
                button_2.removeActionListener(this);
            }else if(e.getActionCommand().equals("3")){
                button_3.setText("Spot 3 TAKEN");
                button_3.removeActionListener(this);
            }else if(e.getActionCommand().equals("4")){
                button_4.setText("Spot 4 TAKEN");
                button_4.removeActionListener(this);
            }else if(e.getActionCommand().equals("5")){
                button_5.setText("Spot 5 TAKEN");
                button_5.removeActionListener(this);
            }
            panel.revalidate();
            panel.repaint();
        }
    }
}