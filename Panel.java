import javax.swing.JPanel;
import java.awt.Color;

public class Panel extends JPanel {
    public Panel(){
        this.setBackground(new Color(137, 173, 215));
        this.setBounds(15, 15, 1875, 128);
        this.setSize(1875, 128);
        this.setVisible(true);
    }

    public Panel(int[] backgroundRGB, int[] panelBounds){
        this.setBackground(new Color(backgroundRGB[0], backgroundRGB[1], backgroundRGB[2], backgroundRGB[3]));
        this.setBounds(panelBounds[0], panelBounds[1], panelBounds[2], panelBounds[3]);
    }
    
}
