import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentMarksGUI extends JFrame {
    private JLabel rollNoLabel, nameLabel, mark1Label, mark2Label, totalMarksLabel;
    private JTextField rollNoField, nameField, mark1Field, mark2Field, totalMarksField;
    private JButton importButton, calculateButton;

    public StudentMarksGUI() {
        setTitle("Student Marks");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        rollNoLabel = new JLabel("Roll No:");
        nameLabel = new JLabel("Name:");
        mark1Label = new JLabel("Mark 1:");
        mark2Label = new JLabel("Mark 2:");
        totalMarksLabel = new JLabel("Total Marks:");

        rollNoField = new JTextField(10);
        nameField = new JTextField(10);
        mark1Field = new JTextField(10);
        mark2Field = new JTextField(10);
        totalMarksField = new JTextField(10);
        totalMarksField.setEditable(false); // Make it read-only

        importButton = new JButton("Import Data");
        calculateButton = new JButton("Calculate");

        // Set layout
        setLayout(new GridLayout(6, 2));

        // Add components to the frame
        add(rollNoLabel);
        add(rollNoField);
        add(nameLabel);
        add(nameField);
        add(mark1Label);
        add(mark1Field);
        add(mark2Label);
        add(mark2Field);
        add(totalMarksLabel);
        add(totalMarksField);
        add(importButton);
        add(calculateButton);

        // Add action listeners
        importButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                importData();
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateTotalMarks();
            }
        });

        setVisible(true);
    }

    private void importData() {
        String rollNo = rollNoField.getText();
        String name = nameField.getText();
        String mark1 = mark1Field.getText();
        String mark2 = mark2Field.getText();

        JOptionPane.showMessageDialog(this, "Data Imported:\nRoll No: " + rollNo + "\nName: " + name + "\nMark 1: " + mark1 + "\nMark 2: " + mark2);
    }

    private void calculateTotalMarks() {
        try {
            int mark1 = Integer.parseInt(mark1Field.getText());
            int mark2 = Integer.parseInt(mark2Field.getText());
            int totalMarks = mark1 + mark2;
            totalMarksField.setText(String.valueOf(totalMarks));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input for marks. Please enter numbers only.");
        }
    }

    public static void main(String[] args) {
        new StudentMarksGUI();
    }
}
