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
    private JLabel firstName;
    private JTextField firstNameInput;
    private JLabel lastName;
    private JTextField lastNameInput;
    private JLabel cardNumber;
    private JTextField cardNumberInput;
    private JLabel phoneNumber;
    private JTextField phoneNumberInput;
    private JLabel isMember;
    private JButton isMemberInput;
    private boolean boolIsMember;
    private client Client;
    private int whichFloor;
    private int whichSpot;


    public GUI_I(int whichFloor, int whichSpot){
        this.whichFloor=whichFloor;
        this.whichSpot=whichSpot;
        done = new JButton("Click here when finished.");
        done.setActionCommand("d");
        done.addActionListener(this);
        firstName = new JLabel("Please input your first name.");
        firstNameInput = new JTextField("");
        lastName = new JLabel("Please input your last name.");
        lastNameInput = new JTextField("");
        cardNumber = new JLabel("Please input your credit card number");
        cardNumberInput = new JTextField("");
        phoneNumber = new JLabel("Please input your phone number");
        phoneNumberInput = new JTextField("");


        frame = new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(210, 210, 65, 210));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(firstName);
        panel.add(firstNameInput);
        panel.add(lastName);
        panel.add(lastNameInput);
        panel.add(cardNumber);
        panel.add(cardNumberInput);
        panel.add(phoneNumber);
        panel.add(phoneNumberInput);
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
            Client = new client(firstNameInput.getText(), lastNameInput.getText(), cardNumberInput.getText(), phoneNumberInput.getText(), boolIsMember, whichFloor, whichSpot);
            System.out.println(Client.toString()); //this line is temporary for testing
            //here we bring up the frame that says you clocked in at
            //whatever time, we'll see you later.
            frame.setVisible(false);
        }
    }
    
}