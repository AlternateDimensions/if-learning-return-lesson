import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.Style;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class TextPane extends JTextPane {
    TextPane(boolean codePanel) throws BadLocationException {
        this.putClientProperty(JTextPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        if (this.getStyledDocument() == null){
            DefaultStyledDocument document = new DefaultStyledDocument();
            this.setStyledDocument(document);
        }

        

        if (codePanel){
            this.setMinimumSize(new Dimension(836, 465));
            this.setSize(new Dimension(836, 465));
            this.setPreferredSize(new Dimension(836, 465));
            this.setMaximumSize(new Dimension(836, 465));

            //this.setText("public class Code {\n    public static void main(String[] args){\n        System.out.println(\"Hello World!\");\n    }\n}");
            this.setOpaque(false);
            this.setForeground(new Color(255,255,255,255));
            this.setFont(new Font("JetBrains Mono", Font.PLAIN, 25));
            this.setBackground(new Color(0,0,0,0));

            
            this.setAlignmentX(0);
            this.setVisible(true);
        } else {
            this.setBounds(23, 23, 836, 465);
            this.setMinimumSize(new Dimension(836, 465));
            this.setPreferredSize(new Dimension(836, 465));
            this.setSize(new Dimension(836, 465));
            this.setMaximumSize(new Dimension(836, 465));

            this.setEditable(false);
            this.setFont(new Font("JetBrains Mono", 1, 20));
            //String output = "\033[32;1m| Hello World!\033[0m";
            //this.setText("Output [~/Code.java/]\n-------------------\n"+output);
            this.setOpaque(false);
            this.setForeground(new Color(255,255,255,255));
            this.setFont(new Font("JetBrains Mono", Font.PLAIN, 25));
            this.setBackground(new Color(0,0,0,0));
            
            this.setAlignmentX(0);
            this.setVisible(true);
        }
    }
}
