import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Map;
import java.awt.font.TextAttribute;
import java.util.HashMap;

public class Main {

    Button buttonRight;
    
    public static void main(String[] args){
        Frame appFrame = new Frame();
        GradientPanel backgroundPanel = new GradientPanel();
        Panel headerPanel = new Panel();
        Button buttonRight = new Button(">", 1735, false);
        Button buttonLeft = new Button("<", 23, true);
        Label titleLabel = new Label(false, false, "", new int[]{0,0,0}, 0, "if (learning) {return lesson;}", new int[]{255,255,255, Math.round((255/255)*255)}, new String[]{"JetBrains Mono", "1", "60"},0,new int[]{255,255,255,100}, new int[]{45+117,0,1550,81});
        Label sectionLabel = new Label(false, false, "", new int[]{0,0,0}, 0, "Conditional Statements - IF", new int[]{255,255,255, Math.round((255/255)*255)}, new String[]{"JetBrains Mono", "0", "35"},0,new int[]{255,255,255,100}, new int[]{45+117,81,1550,81});
        
        Panel leftContentPanel = new Panel(new int[]{116, 177, 233, (int)(0.6*255)}, new int[]{23,207,926, 828});

        Panel rightContentPanel = new Panel(new int[]{116, 177, 233, (int)(0.6*255)}, new int[]{971,207,926, 828});

        sectionLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        sectionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = titleLabel.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        titleLabel.setFont(font.deriveFont(attributes));

        buttonLeft.addActionListener(e -> System.out.println("Prev"));
        buttonRight.addActionListener(e -> System.out.println("Next"));
        headerPanel.add(buttonLeft);
        headerPanel.add(titleLabel);
        headerPanel.add(buttonRight);
        headerPanel.add(sectionLabel);

        backgroundPanel.add(headerPanel);
        backgroundPanel.add(leftContentPanel);
        backgroundPanel.add(rightContentPanel);

        appFrame.add(backgroundPanel);
        appFrame.setVisible(true);
    }    
}