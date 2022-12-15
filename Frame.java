import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Frame extends JFrame{    
    // Default Constructor
    Frame(){
        this.setTitle("if (learning) {return lesson;}");

        // ImageIcon
        ImageIcon image = new ImageIcon("Images/favicon.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(0,0,0,0));

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1920, 1080);
        this.setVisible(true);

    }
}