import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class conjecture implements ActionListener {
    //Setting up static variables that will be used outside of main function
    private static JLabel conclusion;
    private static JTextField initialInt;
    private static JPanel panel;
    private static functions run = new functions();

    public static void main(String[] args) {
        //Setting up frame and panel
        JFrame frame = new JFrame();
        panel = new JPanel();
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        //Setting up first label with instructions on using the program
        JLabel label = new JLabel("Enter an integer to be tested in the Collatz Conjecture: ");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(500, 100);
        label.setLocation(70, 100);
        panel.add(label);

        //Setting up text field
        initialInt = new JTextField();
        initialInt.setBounds(500, 135, 100, 30);
        panel.add(initialInt);

        //Setting up label that will display results
        conclusion = new JLabel();
        conclusion.setBounds(100, 200, 600, 400);
        panel.add(conclusion);

        //Setting up enter button
        JButton button = new JButton("Enter");
        button.setBounds(620, 120, 75, 50);
        button.addActionListener(new conjecture());
        panel.add(button);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            //Grabs text from box and returns results from algorithms
            int integerValue = Integer.parseInt(initialInt.getText());
            conclusion.setText("<html>Success! The integer " + initialInt.getText()
                    + " has a clear path when put through the collatz conjecture. It's hailstone number tree looks like: </br>"
                    + run.collatz(integerValue) + "</br> It has a total of "
                    + Integer.toString(run.iterations(integerValue)) + " hailstone numbers with a maximum value of "
                    + Integer.toString(run.max(integerValue)) + ".</html>");
            //Accounts for integers that create null pointer error
        } catch (NumberFormatException ex) {
            conclusion.setText("Failure! Integer is out of the scope for this program.");
        }

    }

}
