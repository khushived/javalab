import javax.swing.*;
import java.awt.event.*;

abstract class Compartment {
    abstract void notice();
}

class FirstClass extends Compartment {
    private int ticketCount;

    FirstClass(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    void bookTicket() {
        if (ticketCount > 0) {
            ticketCount--;
            System.out.println("Ticket booked in First Class");
        } else {
            System.out.println("No more tickets available in First Class");
        }
    }

    void cancelTicket() {
        ticketCount++;
        System.out.println("Ticket canceled in First Class");
    }

    void notice() {
        System.out.println("First Class - " + ticketCount + " seats available");
    }
}

class General extends Compartment {
    private int ticketCount;

    General(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    void bookTicket() {
        if (ticketCount > 0) {
            ticketCount--;
            System.out.println("Ticket booked in General Class");
        } else {
            System.out.println("No more tickets available in General Class");
        }
    }

    void cancelTicket() {
        ticketCount++;
        System.out.println("Ticket canceled in General Class");
    }

    void notice() {
        System.out.println("General Class - " + ticketCount + " seats available");
    }
}

public class RailCoachGUI extends JFrame implements ActionListener {
    private FirstClass firstClass;
    private General general;

    private JTextField nameField, ageField;
    private JButton bookFirstClassButton, cancelFirstClassButton, bookGeneralButton, cancelGeneralButton;

    public RailCoachGUI(FirstClass firstClass, General general) {
        this.firstClass = firstClass;
        this.general = general;

        setTitle("Rail Coach GUI");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField(3);

        bookFirstClassButton = new JButton("Book First Class");
        bookFirstClassButton.addActionListener(this);
        cancelFirstClassButton = new JButton("Cancel First Class");
        cancelFirstClassButton.addActionListener(this);
        bookGeneralButton = new JButton("Book General");
        bookGeneralButton.addActionListener(this);
        cancelGeneralButton = new JButton("Cancel General");
        cancelGeneralButton.addActionListener(this);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(bookFirstClassButton);
        panel.add(cancelFirstClassButton);
        panel.add(bookGeneralButton);
        panel.add(cancelGeneralButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());

        if (e.getSource() == bookFirstClassButton) {
            firstClass.bookTicket();
            firstClass.notice();
        } else if (e.getSource() == cancelFirstClassButton) {
            firstClass.cancelTicket();
            firstClass.notice();
        } else if (e.getSource() == bookGeneralButton) {
            general.bookTicket();
            general.notice();
        } else if (e.getSource() == cancelGeneralButton) {
            general.cancelTicket();
            general.notice();
        }
    }

    public static void main(String[] args) {
        FirstClass firstClass = new FirstClass(10);
        General general = new General(50);
        new RailCoachGUI(firstClass, general);
    }
}
