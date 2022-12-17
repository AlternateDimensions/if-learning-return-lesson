import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Map;
import java.awt.font.TextAttribute;
import java.util.HashMap;


// Main focuses on creating the GUI. 

public class Main {
    
    public static void main(String[] args){

        //------ CREATION ------//

        // Frame
        Frame appFrame = new Frame();

        // Panels
        GradientPanel backgroundPanel = new GradientPanel();
        Panel headerPanel = new Panel();

        Panel leftContentPanel = new Panel(new int[]{116, 177, 233, (int)(0.6*255)}, new int[]{23,207,926, 828});
        Panel rightContentPanel = new Panel(new int[]{116, 177, 233, (int)(0.6*255)}, new int[]{971,207,926, 828});

        Panel codePanelWrite = new Panel(new int[]{31,31,31,255}, new int[]{23,23,881, 510});
        Panel codePanelOut = new Panel(new int[]{31,31,31,255}, new int[]{23,555, 881, 250});

        Panel descPanelFull = new Panel(new int[]{166,193,225,255}, new int[]{23,23,881,783});

        Panel descPanelTask = new Panel(new int[]{166,193,225,255}, new int[]{23,23,881, 510});
        Panel taskPanel = new Panel(new int[]{166,193,225,255}, new int[]{23,555, 881, 250});
       
        // Buttons
        Button buttonRight = new Button(">", 1735, false);
        Button buttonLeft = new Button("<", 23, true);
        
        // Labels
        Label titleLabel = new Label(false, false, "", new int[]{0,0,0}, 0, "if (learning) {return lesson;}", new int[]{255,255,255, Math.round((255/255)*255)}, new String[]{"JetBrains Mono", "1", "60"},0,new int[]{255,255,255,100}, new int[]{45+117,0,1550,81});
        Label sectionLabel = new Label(false, false, "", new int[]{0,0,0}, 0, "Conditional Statements - IF", new int[]{255,255,255, Math.round((255/255)*255)}, new String[]{"JetBrains Mono", "0", "35"},0,new int[]{255,255,255,100}, new int[]{45+117,81,1550,81});
        
        //------ CONFIG ------//

        // Config Labels
        sectionLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        sectionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        Font font = titleLabel.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        titleLabel.setFont(font.deriveFont(attributes));

        // Config Panels
        descPanelTask.setVisible(false);
        taskPanel.setVisible(false);
        descPanelFull.setVisible(true);

        // Add Labels and buttons >> Panels
        headerPanel.add(buttonLeft);
        headerPanel.add(titleLabel);
        headerPanel.add(buttonRight);
        headerPanel.add(sectionLabel);

        // Add inner panels >> outer panels
        leftContentPanel.add(codePanelWrite);
        leftContentPanel.add(codePanelOut);

        rightContentPanel.add(descPanelFull);
        rightContentPanel.add(descPanelTask);
        rightContentPanel.add(taskPanel);

        // Add outer panels >> BG panel
        backgroundPanel.add(headerPanel);
        backgroundPanel.add(leftContentPanel);
        backgroundPanel.add(rightContentPanel);

        // add BG panel >> frame
        appFrame.add(backgroundPanel);
        
        // Finalize Frame
        appFrame.setVisible(true);

        //------ COMMENCE ------//

        // Create manager and execute
        Manager manager = new Manager();
        manager.run();
    }   
}