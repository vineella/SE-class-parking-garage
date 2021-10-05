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

    public GUI_I(){
        done = new JButton("Click here when finished.");
        done.setActionCommand("d");
        done.addActionListener(this);
        firstName = new JLabel("Please input your first name.");
        firstNameInput = new JTextField("");
        lastName = new JLabel("Please input your last name.");
        lastNameInput = new JTextField("");

        frame = new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(210, 210, 65, 210));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(firstName);
        panel.add(firstNameInput);
        panel.add(lastName);
        panel.add(lastNameInput);
        panel.add(done);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Please provide the information below:");
        frame.pack();
        frame.setVisible(true);
    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        //following two lines are temporary for testing purposes
        String input = firstNameInput.getText()+" "+lastNameInput.getText();
        System.out.println(input);
    }
    
}
