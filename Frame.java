import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JRootPane;

// Frame extends JFrame, allowing the creation of a JFrame for a Java GUI

public class Frame extends JFrame{   
 
    // Default Constructor
    Frame(){
        this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);


        this.setTitle("if (learning) {return lesson;}");

        // ImageIcon
        ImageIcon image = new ImageIcon("Images/favicon.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(0,0,0,0));
        
        // Frame properties
        this.setResizable(false);
        this.setUndecorated(true);
        this.setSize(1920, 1080);
        this.setResizable(false);
        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}