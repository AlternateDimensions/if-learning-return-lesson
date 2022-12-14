import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Frame extends JFrame{
    private int[] options = {
        JFrame.DO_NOTHING_ON_CLOSE, 
        JFrame.HIDE_ON_CLOSE,
        JFrame.DISPOSE_ON_CLOSE, 
    };
    
    // Default Constructor
    Frame(){
        this.setTitle("Frank's Funny Frame");

        // ImageIcon
        ImageIcon image = new ImageIcon("jagodzinski_4k.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(115, 138, 219));

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(true);
        this.setSize(420, 420);
        this.setVisible(true);

    }

    // Custom Constructor
    Frame(String frameTitle, int closeBehavior, boolean resizable, int width, int height, boolean visible, String faviconFile, int bgRed, int bgGreen, int bgBlue, int bgAlpha){
        this.setTitle(frameTitle);

        // ImageIcon
        ImageIcon image = new ImageIcon(faviconFile);
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(bgRed, bgGreen, bgBlue, bgAlpha));

        this.setDefaultCloseOperation(options[closeBehavior]);
        this.setResizable(resizable);
        this.setSize(width, height);
        this.setVisible(visible);

    }


}
