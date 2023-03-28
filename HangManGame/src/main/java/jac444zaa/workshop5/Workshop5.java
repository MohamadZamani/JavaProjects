/*
Last Name:Zamani
First Name:Mohamad
ID:153110192
Section:JAC444ZAA
This workshop represents my own work in accordance with Seneca Academic
Policy.
Signature
Date:03.17.2023
*/

package jac444zaa.workshop5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class Workshop5 {
    private JFrame frame;
    private JTextField guessField;
    private JLabel wordLabel;
    private JLabel messageLabel;
    private JLabel missedLabel;
    private JButton submitButton;

    private ArrayList<String> words;
    private String currentWord;
    private StringBuilder hiddenWord;
    private int missedCount;
    private final ArrayList<Character> missedLetters;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Workshop5 game = new Workshop5();
                game.createAndShowGUI();
            } catch (IOException e) {
            }
        });
    }

    public Workshop5() throws IOException {
        words = new ArrayList<>();
        missedLetters = new ArrayList<>();
        loadWords("hangman.txt");
        pickRandomWord();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Hangman Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1));

        wordLabel = new JLabel(hiddenWord.toString(), SwingConstants.CENTER);
        frame.add(wordLabel);

        messageLabel = new JLabel("Enter a letter in the word", SwingConstants.CENTER);
        frame.add(messageLabel);

        guessField = new JTextField();
        frame.add(guessField);

        missedLabel = new JLabel("Missed letters: ", SwingConstants.CENTER);
        frame.add(missedLabel);

        submitButton = new JButton("Submit");
        submitButton.addActionListener((ActionEvent e) -> {
            processGuess();
        });
        frame.add(submitButton);

        frame.setVisible(true);
    }

    private void loadWords(String filename) throws IOException {
        words = (ArrayList<String>) Files.readAllLines(Paths.get(filename));
    }

    private void pickRandomWord() {
        Random random = new Random();
        currentWord = words.get(random.nextInt(words.size())).toLowerCase();
        hiddenWord = new StringBuilder(currentWord.replaceAll(".", "*"));
        missedCount = 0;
        missedLetters.clear();
    }

    private void processGuess() {
        String guess = guessField.getText().toLowerCase();
        guessField.setText("");

        if (guess.length() != 1 || !Character.isLetter(guess.charAt(0))) {
            messageLabel.setText("Invalid input. Enter a single letter.");
            return;
        }

        char letter = guess.charAt(0);
        if (missedLetters.contains(letter) || hiddenWord.indexOf(Character.toString(letter)) != -1) {
            messageLabel.setText("You've already tried this letter, try another letter.");
            return;
        }

        int index = currentWord.indexOf(letter);
        if (index == -1) {
            missedCount++;
            missedLetters.add(letter);
            missedLabel.setText("Missed letters: " + missedLetters.toString());
            messageLabel.setText(letter + " is not in the word.");
        } else {
            while (index >= 0) {
                hiddenWord.setCharAt(index, letter);
                index = currentWord.indexOf(letter, index + 1);
            }
            messageLabel.setText("Correct!");
            wordLabel.setText(hiddenWord.toString());
        }

        if (hiddenWord.indexOf("*") == -1) {
            JOptionPane.showMessageDialog(frame, "The word is " + currentWord + ". You missed " + missedCount + " times.");
            pickRandomWord(); // Start a new game
            wordLabel.setText(hiddenWord.toString());
            messageLabel.setText("Enter a letter in the word");
            missedLabel.setText("Missed letters: ");
                    // Add a new word to the hangman.txt file
        String newWord = JOptionPane.showInputDialog(frame, "Enter a new word to be added to the memory:");
        if (newWord != null && !newWord.isEmpty()) {
            addWordToFile("hangman.txt", newWord.toLowerCase());
        }

        // Ask the user if they want to continue playing
        int continuePlaying = JOptionPane.showConfirmDialog(frame, "Do you want to guess another word? Enter y or n:", "Continue Playing?", JOptionPane.YES_NO_OPTION);
        if (continuePlaying == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
    }
}

private void addWordToFile(String filename, String newWord) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
        writer.newLine();
        writer.write(newWord);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(frame, "Error adding word to file: " + e.getMessage());
      }
    }
}
