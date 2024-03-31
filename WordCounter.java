/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.wordcounter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class WordCounter extends JFrame {
    private JTextArea textArea;
    private JLabel wordCountLabel;

    public WordCounter() {
        setTitle("Real-Time Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        wordCountLabel = new JLabel("Word count: 0");

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateWordCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateWordCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateWordCount();
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        add(wordCountLabel, BorderLayout.SOUTH);
    }

    private void updateWordCount() {
        String text = textArea.getText();
        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;
        wordCountLabel.setText("Word count: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordCounter wordCounter = new WordCounter();
            wordCounter.setVisible(true);
        });
    }
}
