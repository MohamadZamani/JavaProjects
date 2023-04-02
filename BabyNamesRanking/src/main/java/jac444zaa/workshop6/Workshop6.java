/**********************************************
Workshop 6
Course:JAC44 - Winter
Last Name:Zamani
First Name:Mohamad
ID:153110192
Section:ZAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:2023.03.29
**********************************************/
package jac444zaa.workshop6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Workshop6 {
    private JFrame frame;
    private JTextField yearField;
    private JTextField nameField;
    private JComboBox<String> genderComboBox;
    private JButton searchButton;
    private JButton exitButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Workshop6 app = new Workshop6();
            app.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Baby Name Popularity Ranking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 2));

        frame.add(new JLabel("Enter the year:"));
        yearField = new JTextField();
        frame.add(yearField);

        frame.add(new JLabel("Enter the gender (M/F):"));
        String[] genders = {"M", "F"};
        genderComboBox = new JComboBox<>(genders);
        frame.add(genderComboBox);

        frame.add(new JLabel("Enter the name:"));
        nameField = new JTextField();
        frame.add(nameField);

        searchButton = new JButton("Search");
        searchButton.addActionListener((ActionEvent e) -> {
            searchNameRanking();
        });
        frame.add(searchButton);

        exitButton = new JButton("Exit");
        exitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        frame.add(exitButton);

        frame.setVisible(true);
    }

    private void searchNameRanking() {
    String year = yearField.getText().trim();
    String gender = (String) genderComboBox.getSelectedItem();
    String name = nameField.getText().trim().toLowerCase();
    String fileName = "babynamesranking" + year + ".txt";
    String result = null;
    String genderDisplay = "";

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split("\\s+");
            String currentName = "";
            if (gender.equalsIgnoreCase("M")) {
                currentName = data[1].toLowerCase();
                genderDisplay = "Boy";
            } else if (gender.equalsIgnoreCase("F")) {
                currentName = data[3].toLowerCase();
                genderDisplay = "Girl";
            }

            if (currentName.equals(name)) {
                result = name + " is ranked #" + data[0] + " in year " + year;
                break;
            }
        }
        if (result == null) {
            result = "The name " + name + " is not ranked in year " + year;
        }
    } catch (IOException e) {
        result = "Error reading file: " + e.getMessage();
    }

    int option = JOptionPane.showConfirmDialog(frame, "<html>" + genderDisplay + " " + name + "<br>" + result + "<br><br>Do you want to search another name?</html>",
            "Search Result", JOptionPane.YES_NO_OPTION);

    if (option == JOptionPane.NO_OPTION) {
        System.exit(0);
    }
}

}
