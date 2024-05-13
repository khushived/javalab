import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalindromeGUI extends JFrame {
    private JTextField inputField;
    private JButton checkButton;
    private JLabel resultLabel;

    public PalindromeGUI() {
        setTitle("Palindrome Checker");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        setLayout(new FlowLayout());

        inputField = new JTextField(15);
        add(inputField);

        checkButton = new JButton("Check");
        checkButton.addActionListener(new CheckButtonListener());
        add(checkButton);

        resultLabel = new JLabel();
        add(resultLabel);
    }

    private class CheckButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputField.getText();
            if (isPalindrome(input)) {
                resultLabel.setText("Palindrome!");
            } else {
                resultLabel.setText("Not a Palindrome!");
            }
        }
    }

    private boolean isPalindrome(String str) {
        str = str.toLowerCase();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PalindromeGUI().setVisible(true);
            }
        });
    }
}
