// Manager focuses on managing button inputs, providing the data for pages, and other functions
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.util.HashMap;

public class Manager implements ActionListener {

    private boolean isLesson;
    private int pageNumber;
    private int maxPages;

    private Button buttonLeft;
    private Button buttonRight;
    private Label sectionLabel;
    private Panel headerPanel;
    
    public Manager(){}
    
    public void run(){

        //------ TEST VALUES ------//
        isLesson = !isLesson;
        pageNumber = 0;
        maxPages = 20;

        //------ CREATION ------//

        // Frame
        Frame appFrame = new Frame();

        // Panels
        GradientPanel backgroundPanel = new GradientPanel();
        headerPanel = new Panel();

        Panel leftContentPanel = new Panel(new int[]{116, 177, 233, (int)(0.6*255)}, new int[]{23,207,926, 828});
        Panel rightContentPanel = new Panel(new int[]{116, 177, 233, (int)(0.6*255)}, new int[]{971,207,926, 828});

        Panel codePanelWrite = new Panel(new int[]{31,31,31,255}, new int[]{23,23,881, 510});
        Panel codePanelOut = new Panel(new int[]{31,31,31,255}, new int[]{23,555, 881, 250});

        Panel descPanelFull = new Panel(new int[]{166,193,225,255}, new int[]{23,23,881,783});

        Panel descPanelTask = new Panel(new int[]{166,193,225,255}, new int[]{23,23,881, 510});
        Panel taskPanel = new Panel(new int[]{166,193,225,255}, new int[]{23,555, 881, 250});
       
        // Buttons
        buttonRight = new Button(">", 1735, false);
        buttonLeft = new Button("<", 23, true);
        
        // Labels
        Label titleLabel = new Label(false, false, "", new int[]{0,0,0}, 0, "if (learning) {return lesson;}", new int[]{255,255,255, Math.round((255/255)*255)}, new String[]{"JetBrains Mono", "1", "60"},0, new int[]{45+117,0,1550,81});
        sectionLabel = new Label(false, false, "", new int[]{0,0,0}, 0, "Conditional Statements - IF", new int[]{255,255,255, Math.round((255/255)*255)}, new String[]{"JetBrains Mono", "0", "35"},0,new int[]{45+117,81,1550,81});
        
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

        buttonLeft.addActionListener(this);
        buttonRight.addActionListener(this);

        // Button shenanigans
        
        // Gather pages
        // Get first page

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()== buttonLeft && pageNumber > 1){
            // LEFT BUTTON
            pageNumber --;
        } else if (e.getSource() == buttonRight && pageNumber < maxPages){
            // RIGHT BUTTON
            pageNumber++;
        }
    }
}
