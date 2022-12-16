import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class Panel extends JPanel {
    public Panel(){
        this.setLayout(null);
        this.setBackground(new Color(116, 177, 233, (int)(0.6*255)));
        this.setBounds(23,23,1875,162);
        this.setPreferredSize(new Dimension(1875, 162));
    }

    public Panel(int[] backgroundRGB, int[] panelBounds){
        this.setLayout(null);
        this.setBackground(new Color(backgroundRGB[0], backgroundRGB[1], backgroundRGB[2], backgroundRGB[3]));
        this.setBounds(panelBounds[0],panelBounds[1],panelBounds[2],panelBounds[3]);
        this.setPreferredSize(new Dimension(panelBounds[2], panelBounds[3]));
    }
    
}
