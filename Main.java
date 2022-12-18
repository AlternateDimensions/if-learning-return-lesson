// Main manages and executes the applications.

// TermIDE Imports
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;


// IMPORTS java.awt
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.font.TextAttribute;

// IMPORTS java.beans
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

// IMPORTS java.util
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.HashMap;

// IMPORTS javax.swing
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.text.BadLocationException;

// IMPORTS java.io
import java.io.FileNotFoundException;

// CLASS Main
public class Main {
    //--- Function Vars
    private static boolean isLesson;
    private static int pageNumber;
    private static int maxPages;
    private static int spacer = 2;

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
    private static TextPane codeEditorPane;
    private static Button codeExecuteButton;
    
    private static Panel codePanelOut;
    private static TextPane codeOutputPane;

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

    // Listeners
    private static ActionListener actionListener;
    private static PropertyChangeListener pcListener;
    
    public static void main(String[] args) throws BadLocationException, FileNotFoundException {
        //------ TermIDE Vars ------//
        PrintWriter out = new PrintWriter("Code.java");

        //------ TEST VALUES ------//
        isLesson = false;
        pageNumber = 1;
        maxPages = 20;

        //------ CREATION ------//

        // Frame/BG
        appFrame = new Frame();
        backgroundPanel = new GradientPanel();
        
        // Header Panel
        headerPanel = new Panel();
        buttonLeft = new Button("<", 23, true);
        titleLabel = new Label(false, false, "", new int[]{0,0,0}, 0, "if (learning) {return lesson;}", new int[]{255,255,255, Math.round((255/255)*255)}, new String[]{"JetBrains Mono", "1", "60"},0, new int[]{45+117,0,1550,81});
        sectionLabel = new Label(false, false, "", new int[]{0,0,0}, 0, String.valueOf(pageNumber), new int[]{255,255,255, Math.round((255/255)*255)}, new String[]{"JetBrains Mono", "0", "35"},0,new int[]{45+117,81,1550,81});
        buttonRight = new Button(">", 1735, false);

        // Left COntent Panel
        leftContentPanel = new Panel(new int[]{116, 177, 233, (int)(0.6*255)}, new int[]{23,207,926, 850}, true);
       
        codePanelWrite = new Panel(new int[]{31,31,31,255}, new int[]{23,23,881, 510}, true);
        codeEditorPane = new TextPane(true);

        codePanelOut = new Panel(new int[]{31,31,31,255}, new int[]{23,555, 881, 272}, true);
        codeOutputPane = new TextPane(false);
        codeExecuteButton = new Button("Compile & Run", new int[]{290,86,301,100});

        rightContentPanel = new Panel(new int[]{116, 177, 233, (int)(0.6*255)}, new int[]{971,207,926, 850}, true);

        descPanelFull = new Panel(new int[]{166,193,225,255}, new int[]{23,23,881,805}, true);

        descPanelTask = new Panel(new int[]{166,193,225,255}, new int[]{23,23,881, 510}, false);
        taskPanel = new Panel(new int[]{166,193,225,255}, new int[]{23,555, 881, 272}, false);
        
        //------ CONFIG ------//

        // Button ActionListener config
        actionListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("YOOOO");
                if (e.getSource()== buttonLeft && pageNumber > 1){
                    // LEFT BUTTON
                    pageNumber --;
                    if (!isLesson){
                        codeExecuteButton.setVisible(true);
                        codeOutputPane.setVisible(false);
                    }
                } else if (e.getSource() == buttonRight && pageNumber < maxPages){
                    // RIGHT BUTTON
                    pageNumber++;
                    if (!isLesson){
                        codeExecuteButton.setVisible(true);
                        codeOutputPane.setVisible(false);
                    }
                } else if (e.getSource() == codeExecuteButton){
                    // COMPILE BUTTON
                    codeOutputPane.setVisible(true);
                    codeExecuteButton.setVisible(false);
                    try{
                        out.write(codeEditorPane.getText());
                        out.close();
                        codeOutputPane.setText(codeOutputPane.getText()+runProcess(new String[]{"java","./Code.java"}));
                    } catch (Exception a){}
                }
                updateSectionHeader(); 
            }
        };

        // EditorPane PropertyChangeListener config
        pcListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e){
                System.out.print(e.getNewValue());
            }            
        };


        // Config buttons
        buttonLeft.addActionListener(actionListener);
        buttonRight.addActionListener(actionListener);
        codeExecuteButton.addActionListener(actionListener);
        codeEditorPane.addPropertyChangeListener(pcListener);

        // Config Labels
        sectionLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        sectionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        codeOutputPane.setVisible(false);

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

        codePanelWrite.add(codeEditorPane);
        codePanelOut.add(codeOutputPane);
        codePanelOut.add(codeExecuteButton);

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

    private static void updateSectionHeader (){
        SwingWorker<String, Object> sw = new SwingWorker<String, Object>(){
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

    // Takes the command and combines it into a printed statement
    private static String printLines(String cmd, InputStream ins) throws Exception {
        String output = "";
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            output+=(cmd + " " + line);
        }
        return output;
      }

      // compiles and runs the file, then returns the stdout and stderr
      private static String runProcess(String[] command) throws Exception {
        String result= "";
        Process pro = Runtime.getRuntime().exec(command);
        result+= printLines("OUT: |", pro.getInputStream()) + "\n";
        result+= printLines("ERR: |", pro.getErrorStream()) + "\n";
        pro.waitFor();
        result+=("EXIT: | exitValue() " + pro.exitValue());
        return result;
      }
}