import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class GUI_I implements ActionListener{
    public  JFrame frame;
    private JPanel panel;
    private JButton done;
    private JLabel firstNameLabel;
    private JTextField firstNameInput;
    private JLabel lastNameLabel;
    private JTextField lastNameInput;
    private JLabel cardNumberLabel;
    private JTextField cardNumberInput;
    private JLabel phoneNumberLabel;
    private JTextField phoneNumberInput;
    private JLabel dateInLabel;
    private JTextField dateInInput;
    private JLabel timeInLabel;
    private JTextField timeInInput;
    private JLabel isMember;
    private JButton isMemberInput;
    private boolean boolIsMember;
    private client Client;
    private int whichFloor;
    private int whichSpot;
    private String firstName;
    private String lastName;
    private String cardNumber;
    private String phoneNumber;
    private String dateIn;
    private String timeIn;


    public GUI_I(int whichFloor, int whichSpot){
        this.whichFloor=whichFloor;
        this.whichSpot=whichSpot;
        done = new JButton("Click here when finished.");
        done.setActionCommand("d");
        done.addActionListener(this);
        firstNameLabel = new JLabel("Please input your first name.");
        firstNameInput = new JTextField("");
        lastNameLabel = new JLabel("Please input your last name.");
        lastNameInput = new JTextField("");
        cardNumberLabel = new JLabel("Please input your credit card number");
        cardNumberInput = new JTextField("");
        phoneNumberLabel = new JLabel("Please input your phone number");
        phoneNumberInput = new JTextField("");
        dateInLabel = new JLabel("Please Indicate Today's Date (MM/DD/YYYY):");
        dateInInput = new JTextField("");
        timeInLabel = new JLabel("Please Indicate the Current Time Using the Military"+
        "/24-Hour System(HH:MM)");
        timeInInput = new JTextField("");


        frame = new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(210, 210, 65, 210));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(firstNameLabel);
        panel.add(firstNameInput);
        panel.add(lastNameLabel);
        panel.add(lastNameInput);
        panel.add(cardNumberLabel);
        panel.add(cardNumberInput);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberInput);
        panel.add(dateInLabel);
        panel.add(dateInInput);
        panel.add(timeInLabel);
        panel.add(timeInInput);

        if(boolIsMember==false){
            isMember = new JLabel("Would you like to become a member?" +
            "(This adds a $20 charge to your account, but gives you 25%"
            + "off per hour you stay here for the next 30 days)");
            isMemberInput = new JButton("Click here to become a member!");
            isMemberInput.setActionCommand("m");
            isMemberInput.addActionListener(this);
            panel.add(isMember);
            panel.add(isMemberInput);
        }
        panel.add(done);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Please provide the information below:");
        frame.pack();
        frame.setVisible(true);
    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("m")){
            isMemberInput.setText("You are now a member! :)");
            isMemberInput.setActionCommand("n");
            panel.revalidate();
            panel.repaint();
            boolIsMember=true;
        }else if(e.getActionCommand().equals("n")==false){
            firstName = firstNameInput.getText();
            lastName = lastNameInput.getText();
            cardNumber = cardNumberInput.getText();
            phoneNumber = phoneNumberInput.getText();
            dateIn = dateInInput.getText();
            timeIn = timeInInput.getText();
            Client = new client(firstName, lastName, cardNumber, phoneNumber, dateIn, timeIn, boolIsMember, whichFloor, whichSpot);
            System.out.println(Client.toString()); //this line is temporary for testing
            //here we bring up the frame that says you clocked in at
            //whatever time, we'll see you later.
            frame.setVisible(false);
        }
    }
}