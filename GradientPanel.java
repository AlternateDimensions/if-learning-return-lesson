import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.GradientPaint;

import java.awt.Dimension;

// GradientPanel extends JPanel and incoporates Graphics to make a gradient background for a JFrame

public class GradientPanel extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth(), h = getHeight();
        Color color1 = new Color(62, 133, 199);
        Color color2 = new Color(39, 17, 177);
        GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
    
    public GradientPanel(){
        this.setLayout(null);
        this.setBounds(0,0,1920,1080);
        this.setPreferredSize(new Dimension(1920, 1080));
    }
}