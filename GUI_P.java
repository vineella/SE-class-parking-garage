import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class GUI_P implements ActionListener{
    public static JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton done;

    public GUI_P(){
        frame = new JFrame();
        label = new JLabel("A charge in the amount of //amount// has been made to the "+ 
        "account you provided. Have a nice day! :)");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        GUI_SS.frame.setVisible(true);
    }

}
