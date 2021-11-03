import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class GUI_TO implements ActionListener {
    public  JFrame frame;
    private JPanel panel;
    private JButton done;
    private JLabel dateOutLabel;
    private JTextField dateOutInput;
    private JLabel timeOutLabel;
    private JTextField timeOutInput;
    private String dateOut;
    private String timeOut;
    private client Client;

    public GUI_TO(){
        done = new JButton("Click here when finished.");
        done.setActionCommand("d");
        done.addActionListener(this);

        frame=new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(120, 120, 40, 120));
        panel.setLayout(new GridLayout(0, 1));

        dateOutLabel = new JLabel("Please Indicate Today's Date (MM/DD/YYYY):");
        dateOutInput = new JTextField("");
        timeOutLabel = new JLabel("Please Indicate the Current Time Using the Military"+
        "/24-Hour System(HH:MM)");
        timeOutInput = new JTextField("");

        panel.add(dateOutLabel);
        panel.add(dateOutInput);
        panel.add(timeOutLabel);
        panel.add(timeOutInput);
        panel.add(done);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Please provide the information below:");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            dateOut = dateOutInput.getText();
            timeOut = timeOutInput.getText();
            //the following line is for testing purposes only and should be
            //replaced with an instance of grabbing a specific client from the 
            //database when that becomes possible
            Client = new client("Guy", "Fieri", "0000111122223333", "(555)555-5555", "11/03/2021", "00:00", true, 1, 1);
            Client.setdateOut(dateOut);
            Client.settimeOut(timeOut);
            System.out.println(Client.toString()); //this line is temporary for testing
            frame.setVisible(false);
            new GUI_P();
    }
}
