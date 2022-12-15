import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;


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
        this.setFont(new Font("JetBrains Mono", Font.PLAIN, 40));
        this.setIconTextGap(-10);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(border);
        this.setOpaque(true);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVisible(true);
    }

    Label(boolean icon, boolean border, String iconImage, int[] borderRGB, int borderThickness, String text, int textPotH, int textPotV, int[] foregroundRGB, String[] fontInfo, int iconTextGap, int[] backgroundRGB,boolean opaque,  int alignV, int alignH){
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
        this.setHorizontalTextPosition(textPotH);
        this.setVerticalTextPosition(textPotV);
        this.setForeground(new Color(foregroundRGB[0], foregroundRGB[1], foregroundRGB[2], foregroundRGB[3]));
        this.setFont(new Font(fontInfo[0], Font.PLAIN, Integer.parseInt(fontInfo[1])));
        this.setBackground(new Color(backgroundRGB[0], backgroundRGB[1], backgroundRGB[2], backgroundRGB[3]));
        this.setOpaque(opaque);
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVisible(true);
    }
    
}
