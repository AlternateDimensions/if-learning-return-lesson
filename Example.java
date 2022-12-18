import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

// something i got from stackoverflow 

public class Example {

    public Example() {

        JFrame frame = new JFrame();
        JTextPane pane = new JTextPane();
        JButton button = new JButton("Button");

        addColoredText(pane, "Red Text\n", Color.RED);
        addColoredText(pane, "Blue Text\n", Color.BLUE);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.setPreferredSize(new Dimension(200, 200));
        frame.getContentPane().add(pane, BorderLayout.CENTER);
        frame.getContentPane().add(button, BorderLayout.WEST);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Example();
    }

    public void addColoredText(JTextPane pane, String text, Color color) {
        StyledDocument doc = pane.getStyledDocument();

        Style style = pane.addStyle("Color Style", null);
        StyleConstants.setForeground(style, color);
        try {
            doc.insertString(doc.getLength(), text, style);
        } 
        catch (BadLocationException e) {
            e.printStackTrace();
        }           
    }
}