import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

// Label extends JLabel to allow text to be displayed but not edited in a JPanel.

public class Label extends JLabel {

    //Constructor
    Label(){
        // Image Properties
        ImageIcon image = new ImageIcon("Images/VS Code.png");
        Border border = BorderFactory.createLineBorder(Color.BLUE, 3);

        // Label Properties
        this.setText("YOOOO MR J CHECK ME OUTTTTTT");
        this.setIcon(image);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.TOP);
        this.setForeground(new Color(123, 255, 123));
        this.setFont(new Font("JetBrains Mono", 1, 40));
        this.setIconTextGap(-10);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(border);
        this.setOpaque(true);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVisible(true);
    }

    Label(boolean icon, boolean border, String iconImage, int[] borderRGB, int borderThickness, String text, int[] foregroundRGB, String[] fontInfo, int iconTextGap, int[] sizeDim){
        // Image Properties
        if (icon) {
            ImageIcon image = new ImageIcon(iconImage);
            this.setIcon(image);
            this.setIconTextGap(iconTextGap);
        }
        if (border){
            Border borderObj = BorderFactory.createLineBorder(new Color(borderRGB[0], borderRGB[1], borderRGB[2]), borderThickness);
            this.setBorder(borderObj);
        }

        // Label Properties
        this.setText(text);
        this.setOpaque(true);
        this.setHorizontalTextPosition(0);
        this.setForeground(new Color(foregroundRGB[0], foregroundRGB[1], foregroundRGB[2], foregroundRGB[3]));
        this.setFont(new Font(fontInfo[0], Integer.parseInt(fontInfo[1]), Integer.parseInt(fontInfo[2])));
        this.setBackground(new Color(0,0,0,0));

        this.setBounds(sizeDim[0], sizeDim[1], sizeDim[2], sizeDim[3]);
        this.setMinimumSize(new Dimension(sizeDim[2], sizeDim[3]));
        this.setPreferredSize(new Dimension(sizeDim[2], sizeDim[3]));
        this.setMaximumSize(new Dimension(sizeDim[2], sizeDim[3]));
        
        this.setAlignmentX(0);
    }
    
}
