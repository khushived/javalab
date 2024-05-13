import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PrintTask extends Thread {
    private String message;
    private int count;

    public PrintTask(String message, int count) {
        this.message = message;
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(message);
            try {
                Thread.sleep(100); // Sleep for 100 milliseconds for demonstration purposes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class PrintGUI extends JFrame implements ActionListener {
    private JTextField countField;
    private JButton printButton;

    public PrintGUI() {
        setTitle("Print GUI");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel countLabel = new JLabel("Count N:");
        countField = new JTextField(10);
        printButton = new JButton("PRINT");
        printButton.addActionListener(this);

        panel.add(countLabel);
        panel.add(countField);
        panel.add(printButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == printButton) {
            int count = Integer.parseInt(countField.getText());

            PrintTask t1 = new PrintTask("Thrikkakara", count);
            PrintTask t2 = new PrintTask("Kochi", count);

            // Without synchronization
            t1.start();
            t2.start();
        }
    }

    public static void main(String[] args) {
        new PrintGUI();
    }
}
