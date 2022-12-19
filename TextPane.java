import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class TextPane extends JTextPane {
    TextPane(int panelType) throws BadLocationException {
        this.putClientProperty(JTextPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        this.setCaretColor(Color.WHITE);

        if (panelType == 0){
            this.setBounds(23, 23, 836, 465);
            this.setMinimumSize(new Dimension(836, 465));
            this.setSize(new Dimension(836, 465));
            this.setPreferredSize(new Dimension(836, 465));
            this.setMaximumSize(new Dimension(836, 465));

            this.setText("public class Code {\n    public static void main(String[] args){\n        System.out.println(\"Hello World!\");\n    }\n}");
            this.setOpaque(false);
            this.setForeground(new Color(255,255,255,255));
            this.setFont(new Font("JetBrains Mono", Font.PLAIN, 25));
            this.setBackground(new Color(0,0,0,0));

            
            this.setAlignmentX(0);
            this.setVisible(true);
        } else if (panelType == 1) {
            this.setBounds(23, 23, 836, 227);
            this.setMinimumSize(new Dimension(836, 227));
            this.setPreferredSize(new Dimension(836, 227));
            this.setSize(new Dimension(836, 227));
            this.setMaximumSize(new Dimension(836, 227));

            this.setEditable(false);
            this.setFont(new Font("JetBrains Mono", 1, 20));
            this.setText("Output [~/Code.java/]\n-----------------------\n");
            this.setOpaque(false);
            this.setForeground(new Color(255,255,255,255));
            this.setBackground(new Color(0,0,0,0));
            
            this.setAlignmentX(0);
            this.setVisible(true);
        } else if (panelType == 2) {
            this.setBounds(23, 23, 836, 465);
            this.setMinimumSize(new Dimension(836, 465));
            this.setSize(new Dimension(836, 465));
            this.setPreferredSize(new Dimension(836, 465));
            this.setMaximumSize(new Dimension(836, 465));

            this.setEditable(false);
            this.setOpaque(false);
            this.setText("A description goes here!");
            this.setForeground(new Color(0,0,0,255));
            this.setFont(new Font("JetBrains Mono", Font.PLAIN, 25));
            this.setBackground(new Color(0,0,0,0));
            
            this.setAlignmentX(0);
        } else if (panelType == 3) {
            this.setBounds(23, 23, 836, 227);
            this.setMinimumSize(new Dimension(836, 227));
            this.setSize(new Dimension(836, 465));
            this.setPreferredSize(new Dimension(836, 227));
            this.setMaximumSize(new Dimension(836, 227));

            this.setEditable(false);
            this.setOpaque(false);
            this.setText("A description goes here!");
            this.setForeground(new Color(0,0,0,255));
            this.setFont(new Font("JetBrains Mono", Font.PLAIN, 25));
            this.setBackground(new Color(0,0,0,0));
            
            this.setAlignmentX(0);
        }
    }
}
