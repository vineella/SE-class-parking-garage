import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class GUI_P {
    public static JFrame frame;
    private JPanel panel;
    private JLabel label;

    public GUI_P(){
        frame = new JFrame();
        label = new JLabel("A charge in the amount of //amount// has been made to the "+ 
        "account you provided. Have a nice day! :)");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        panel.setLayout(new GridLayout(0, 1));
        
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Thank you for using Group 5 Parking Garage!");
        frame.pack();
        frame.setVisible(true);
    }

}
