import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;


public class Label extends JLabel {
    private int[] options = {
        JLabel.LEFT,
        JLabel.CENTER,
        JLabel.RIGHT,
    };


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
    }

    Label(String iconImage, int[] borderRGB, int borderThickness, String text, int textPotH, int textPotV, int[] foregroundRGB, String[] font, int iconTextGap, int[] backgroundRGB, int alignV, int alignH ){
        // Image Properties
        ImageIcon image = new ImageIcon(iconImage);
        Border border = BorderFactory.createLineBorder(new Color(borderRGB[0], borderRGB[1], borderRGB[2]), borderThickness);

        // Label Properties
        this.setText(text);
        this.setIcon(image);
        this.setHorizontalTextPosition(textPotH);
        this.setVerticalTextPosition(textPotV);
        this.setForeground(new Color(foregroundRGB[0], foregroundRGB[1], foregroundRGB[2]));
        this.setFont(new Font(font[0], Integer.parseInt(font[1]), Integer.parseInt(font[2])));
        this.setIconTextGap(iconTextGap);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(border);
        this.setOpaque(true);
        this.setVerticalAlignment(options[alignV]);
        this.setHorizontalAlignment(options[alignH]);
    }
    
}
