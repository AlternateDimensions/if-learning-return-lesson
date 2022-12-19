import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

// Button extends JButton, allowing the creation of JButtons in use with other JComponenets

public class Button extends JButton {
    public Button(String textString, int sizeDim, boolean isLeft){
        this.setText(textString);
        this.setFont(new Font("JetBrains Mono", 1, 100));
        this.setFocusable(false);
        this.setRolloverEnabled(false);
        this.setBorderPainted(false);
        this.setBackground(new Color(166, 193, 225));
        this.setBounds(sizeDim, 23, 117, 117);
        this.setPreferredSize(new Dimension(117, 117));
        this.setAlignmentX(isLeft ? JButton.LEFT : JButton.RIGHT);
    }
    public Button(String textString, int[] sizeDim){
        this.setText(textString);
        this.setFont(new Font("JetBrains Mono", 1, 30));
        this.setFocusable(false);
        this.setRolloverEnabled(false);
        this.setBorderPainted(false);
        this.setBackground(new Color(166, 193, 225));
        //this.setBackground(Color.WHITE);
        this.setBounds(sizeDim[0], sizeDim[1], sizeDim[2], sizeDim[3]);
        this.setPreferredSize(new Dimension(sizeDim[2], sizeDim[3]));
        this.setAlignmentX(JButton.CENTER);
    }
}

