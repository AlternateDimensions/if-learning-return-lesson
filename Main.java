// Main manages and executes the applications.

// IMPORTS java.awt
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.font.TextAttribute;

// IMPORTS java.util
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.HashMap;
import java.util.List;

// IMPORTS javax.swing
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

// CLASS Main
public class Main {
    //--- Function Vars
    private static boolean isLesson;
    private static int pageNumber;
    private static int maxPages;

    //--- GUI Vars
    // Frame/BG
    private static Frame appFrame;
    private static GradientPanel backgroundPanel;

    // Header Panel
    private static Panel headerPanel;
    private static Button buttonLeft;
    private static Label titleLabel;
    private static Label sectionLabel;
    private static Button buttonRight;

    // Left Content Panel
    private static Panel leftContentPanel;
    
    private static Panel codePanelWrite;
    // private static TextField codeTextField;
    private static Button codeExecuteButton;
    
    private static Panel codePanelOut;
    private static Label codeOutputLabel;

    // Right Content Panel
    private static Panel rightContentPanel;

    private static Panel descPanelFull;
    private static Label descLabelFull;

    private static Panel descPanelTask;
    private static Panel descLabelTask;

    private static Panel taskPanel;
    private static Label taskLabel1;
    private static Label taskLabel2;
    private static Label taskLabel3;

    // Button ActionListener
    private static ActionListener listener;
    
    public static void main(String[] args){

        //------ TEST VALUES ------//
        isLesson = false;
        pageNumber = 1;
        maxPages = 20;

        //------ CREATION ------//

        // Frame
        appFrame = new Frame();

        // Panels
        backgroundPanel = new GradientPanel();
        headerPanel = new Panel();

        leftContentPanel = new Panel(new int[]{116, 177, 233, (int)(0.6*255)}, new int[]{23,207,926, 850}, true);
        rightContentPanel = new Panel(new int[]{116, 177, 233, (int)(0.6*255)}, new int[]{971,207,926, 850}, true);

        codePanelWrite = new Panel(new int[]{31,31,31,255}, new int[]{23,23,881, 510}, true);
        codePanelOut = new Panel(new int[]{31,31,31,255}, new int[]{23,555, 881, 272}, true);

        descPanelFull = new Panel(new int[]{166,193,225,255}, new int[]{23,23,881,805}, true);

        descPanelTask = new Panel(new int[]{166,193,225,255}, new int[]{23,23,881, 510}, false);
        taskPanel = new Panel(new int[]{166,193,225,255}, new int[]{23,555, 881, 272}, false);
       
        // Buttons
        buttonRight = new Button(">", 1735, false);
        buttonLeft = new Button("<", 23, true);
        
        // Labels
        titleLabel = new Label(false, false, "", new int[]{0,0,0}, 0, "if (learning) {return lesson;}", new int[]{255,255,255, Math.round((255/255)*255)}, new String[]{"JetBrains Mono", "1", "60"},0, new int[]{45+117,0,1550,81});
        sectionLabel = new Label(false, false, "", new int[]{0,0,0}, 0, String.valueOf(pageNumber), new int[]{255,255,255, Math.round((255/255)*255)}, new String[]{"JetBrains Mono", "0", "35"},0,new int[]{45+117,81,1550,81});
        
        //------ CONFIG ------//

        // Button ActionListener config
        listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // set page number
                if (e.getSource()== buttonLeft && pageNumber > 1){
                    // LEFT BUTTON
                    pageNumber --;
                } else if (e.getSource() == buttonRight && pageNumber < maxPages){
                    // RIGHT BUTTON
                    pageNumber++;
                } else if (true){
                    // here, it would be the third button to compile code.
                }
                
                System.out.println("Button clicked, time to set the page");
                // Update section incase
                updateSectionHeader();
            }
        };

        // Config buttons
        buttonLeft.addActionListener(listener);
        buttonRight.addActionListener(listener);

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
    }

    private static void updateSectionHeader () {
        SwingWorker sw = new SwingWorker(){
            @Override
            protected String doInBackground() throws Exception {
                String res = String.valueOf(pageNumber);
                return res;
            }

            @Override
            protected void done(){
                try{
                    String newMsg = String.valueOf(get());
                    System.out.println("Section Title updated!");
                    sectionLabel.setText(newMsg);
                    appFrame.repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e){
                    e.printStackTrace();
                }
            }
        };
        sw.execute();
    }
}
