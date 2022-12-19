// Main manages and executes the applications.

// TermIDE Imports
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

// IMPORTS java.awt
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.awt.Color;

// IMPORTS java.beans
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

// IMPORTS java.util
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.HashMap;
import java.util.ArrayList;

// IMPORTS javax
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.text.BadLocationException;

// IMPORTS java.io
import java.io.FileNotFoundException;

// CLASS Main
public class Main {
    //--- Function Vars
    private static int pageNumber;
    private static int maxPages;

    private static String[] patternsToCheck;
    private static boolean[] containOrAvoid;

    private static boolean passedChecks;
    private static String res;

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
    private static TextPane descTextPaneFull;

    private static Panel descPanelTask;
    private static TextPane descTextPaneTask;

    private static Panel taskPanel;
    private static Label taskLabel1;
    private static Label taskLabel2;
    private static Label taskLabel3;

    // Listeners
    private static ActionListener actionListener;
    private static PropertyChangeListener pcListener;


    // Other
    private static ArrayList<Page> pages = new ArrayList<Page>();
    
    public static void main(String[] args) throws BadLocationException, FileNotFoundException {
        //------ PAGE CREATION ------//
        pages.add(new Page("Start Menu", "public class Code {\n    public static void main(String[] args) {\n        // You will be able to write code here!\n        System.out.println(\"...output goes here!\");\n    }\n}","Output [~/Code.java/]\n-----------------------\nOUT | ...output goes here!", false, "Welcome to if (learning) {return lesson;}! Here you'll learn about iterations and conditional statements in Java!", false));
        pages.add(new Page("IF/THEN Statements","public class Code {\n    public static void main(String[] args) {\n        int x = 5;\n        if (x == 5) {\n            System.out.println(\"Hello World!\");\n        }\n    }\n}","Output [~/Code.java/]\n-----------------------\nOUT | Hello World!",false,"An IF/THEN statememnt is a conditional statement. That means that a condition must be met in order for certain code to be ran! It asks the question: \"IF...THEN...\"\nIn the code editor, a simple IF statement has been written. The code checks to see if the int x has a value of 5. If it does, it will print \"Hello World!\". Since x is equal to 5, it meets the condition and does the within the IF/THEN statement.",false));
        pages.add(new Page("IF/THEN Statements", "public class Code {\n    public static void main(String[] args) {\n        ","Output [~/Code.java/]\n-----------------------\n",true,"Here is your first challenge: can you make a successful IF/THEN statement? Your requirements are provided below. Make sure to close your brackets!! In order to restart, simply go to the previous page and back!",true,"if(", true, "The code must have an IF/THEN statement.", "){System.out.println(\"", true,"The code must println from within an IF/THEN statement.", "", false,  ""));
        pages.add(new Page("Demo End", "public class Code {\n    public static void main(String[] args) {\n        // You will be able to write code here!\n        System.out.println(\"...output goes here!\");\n    }\n}","Output [~/Code.java/]\n-----------------------\nOUT | ...output goes here!", false, "This is a temporary page for the end of the project. ", false));


        //------ VARS ------//
        pageNumber = 1;
        maxPages = pages.size();
        patternsToCheck = new String[3];
        containOrAvoid = new boolean[3];

        //------ CREATION ------//

        // Frame/BG
        appFrame = new Frame();
        backgroundPanel = new GradientPanel();
        
        // Header Panel
        headerPanel = new Panel();
        buttonLeft = new Button("<", 23, true);
        titleLabel = new Label("if (learning) {return lesson;}", new int[]{0,0,0, Math.round((255/255)*255)}, new int[]{45+117,0,1550,81}, 1, 60);
        sectionLabel = new Label("Main Menu | 1", new int[]{0,0,0, Math.round((255/255)*255)},new int[]{45+117,81,1550,81},0, 35);
        buttonRight = new Button(">", 1735, false);

        // Left oOntent Panel
        leftContentPanel = new Panel(new int[]{116, 177, 233, (int)(0.6*255)}, new int[]{23,207,926, 850}, true);
       
        codePanelWrite = new Panel(new int[]{31,31,31,255}, new int[]{23,23,881, 510}, true);
        codeEditorPane = new TextPane(0);

        codePanelOut = new Panel(new int[]{31,31,31,255}, new int[]{23,555, 881, 272}, true);
        codeOutputPane = new TextPane(1);
        codeExecuteButton = new Button("Compile & Run", new int[]{290,86,301,100});

        // Right Content Panel
        rightContentPanel = new Panel(new int[]{116, 177, 233, (int)(0.6*255)}, new int[]{971,207,926, 850}, true);

        descPanelFull = new Panel(new int[]{166,193,225,255}, new int[]{23,23,881,805}, true);
        descTextPaneFull = new TextPane(2);

        descPanelTask = new Panel(new int[]{166,193,225,255}, new int[]{23,23,881, 510}, false);
        descTextPaneTask = new TextPane(3);

        taskPanel = new Panel(new int[]{166,193,225,255}, new int[]{23,555, 881, 272}, false);
        taskLabel1 = new Label("", new int[]{0,0,0,255}, new int[]{23,23, 836, 75}, 0, 18);
        taskLabel2 = new Label("", new int[]{0,0,0,255}, new int[]{23,98, 836, 75}, 0, 18); 
        taskLabel3 = new Label("", new int[]{0,0,0,255}, new int[]{23,173, 836, 75}, 0, 18);
        
        //------ CONFIG ------//

        // Button ActionListener config
        actionListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getSource()== buttonLeft && pageNumber > 1){
                    // LEFT BUTTON
                    pageNumber --;
                    // adjust page content with new page
                    refreshFrame(true);
                } else if (e.getSource() == buttonRight && pageNumber < maxPages){
                    // RIGHT BUTTON
                    pageNumber++;
                    
                    // adjust page content with new page
                    refreshFrame(true);
                } else if (e.getSource() == codeExecuteButton){
                    // COMPILE BUTTON
                    codeOutputPane.setVisible(true);
                    codeExecuteButton.setVisible(false);
                    try{
                        PrintWriter out = new PrintWriter("Code.java");
                        String codeText = codeEditorPane.getText();
                        out.write(codeText);
                        out.close();

                        res = runProcess(new String[]{"java","Code.java"});

                        codeOutputPane.setText(codeOutputPane.getText()+res);

                        // Check if patterns are in / out of code
                        // MAKE SURE TO STRIP WHITESPACES AND NEWLINES!!

                        codeText = codeText.replace("public class Code {\n    public static void main(String[] args) {\n        ", "");
                        codeText = codeText.replace(" ", "");
                        codeText = codeText.replace("\n", "");

                        System.out.println(codeText);

                        // Checker
                        for (int i = 0; i <= 2; i++){
                            System.out.println(containOrAvoid[i] && codeText.contains(patternsToCheck[i]));
                            System.out.println(!containOrAvoid[i] && !codeText.contains(patternsToCheck[i]));
                            if (containOrAvoid[i] && codeText.contains(patternsToCheck[i])){ // if must contain TRUE and code contains pattern
                                containOrAvoid[i] = true;
                            } else if (!containOrAvoid[i] && !codeText.contains(patternsToCheck[i])){ // if must NOT CONTAIN and code DOES NOT contain code
                                containOrAvoid[i] = true;
                            } else if (patternsToCheck[i].equals("")){ // Pattern does not exist
                                containOrAvoid[i] = true;
                            } else { // code contains pattern but it's not supposed to OR it doesn't contain the required pattern when it does
                                passedChecks = false;
                                containOrAvoid[i] = false;
                            }
                        }
                        refreshFrame(false);
                    } catch (Exception a){
                        a.printStackTrace();
                    }
                }
            }
        };

        // EditorPane PropertyChangeListener config
        pcListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e){
                codeEditorPane.setCaretColor(Color.WHITE);
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

        descPanelFull.add(descTextPaneFull);
        descPanelTask.add(descTextPaneTask);

        taskPanel.add(taskLabel1);
        taskPanel.add(taskLabel2);
        taskPanel.add(taskLabel3);

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
        refreshFrame(true);
        
    }

    // Refresh Frame
    private static void refreshFrame (boolean wholeFrame){
        if (wholeFrame){
            SwingWorker<ArrayList<Object>,Object> sw = new SwingWorker<ArrayList<Object>, Object>(){
                @Override
                // generate new values
                protected ArrayList<Object> doInBackground() throws Exception {
                    ArrayList<Object> values = new ArrayList<Object>();
                    values.add(String.valueOf(pageNumber));
                    for (Object field : pages.get(pageNumber-1).getFields()){
                        values.add(field);
                    }
                    return values;
                }
    
                @Override
                protected void done(){
                    try{
                        // Update the actual texts with new values
                        ArrayList<Object> results = get();
                        sectionLabel.setText(String.valueOf(results.get(0))+" | "+String.valueOf(results.get(1)));
                        codeEditorPane.setText(String.valueOf(results.get(2)));
                        codeOutputPane.setText(String.valueOf(results.get(3)));
    
                        if ((boolean) results.get(4)){
                            // editable is true
                            codeEditorPane.setEditable(true);
                            codeEditorPane.setCaretColor(Color.WHITE);
                            codeOutputPane.setVisible(false);
                            codeExecuteButton.setVisible(true);
                        } else{
                            // editable is false
                            codeEditorPane.setEditable(false);
                            codeOutputPane.setVisible(true);
                            codeExecuteButton.setVisible(false);
                        }
    
                        if ((boolean) results.get(6)){
                            descPanelFull.setVisible(false);
                            descPanelTask.setVisible(true);
                            taskPanel.setVisible(true);
                            taskLabel1.setVisible(true);
                            taskLabel2.setVisible(true);
                            taskLabel3.setVisible(true);
    
                            descTextPaneTask.setText((String) results.get(5));
                            patternsToCheck[0] = (String) results.get(7);
                            containOrAvoid[0] = (boolean) results.get(8);
                            taskLabel1.setText("X | "+(String) results.get(9));
                            patternsToCheck[1] = (String) results.get(10);
                            containOrAvoid[1] = (boolean) results.get(11);
                            taskLabel2.setText("X | "+(String) results.get(12));
                            patternsToCheck[2] = (String) results.get(13);
                            containOrAvoid[2] = (boolean) results.get(14);
                            taskLabel3.setText("X | "+(String) results.get(15));
                            passedChecks = true;
    
                            buttonRight.setVisible(false);
                      
                            // has task, meaning needs to use task version
                        } else {
                            buttonRight.setVisible(true);
                            // full version!
                            descPanelFull.setVisible(true);
                            descPanelTask.setVisible(false);
                            taskPanel.setVisible(false);
                            taskLabel1.setVisible(false);
                            taskLabel2.setVisible(false);
                            taskLabel3.setVisible(false);
    
                            descTextPaneFull.setText((String) results.get(5));
                        }
    
                        // refresh screen
                        appFrame.repaint();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e){
                        e.printStackTrace();
                    }
                }
            };
            sw.execute();
        } else {
            SwingWorker<ArrayList<Object>,Object> sw2 = new SwingWorker<ArrayList<Object>, Object>(){
                @Override
                // FORCED inheritence
                protected ArrayList<Object> doInBackground() throws Exception {
                    ArrayList<Object> values = new ArrayList<Object>();
                    return values;
                }
    
                @Override
                protected void done(){
                    try{
                        // Update the actual texts with new values
                        for (int i = 0; i <= 2; i++){
                            if (containOrAvoid[i]){
                                if (i == 0){taskLabel1.setText("V "+taskLabel1.getText().substring(2));}
                                else if (i == 1){taskLabel2.setText("V "+taskLabel2.getText().substring(2));}
                                else {taskLabel3.setText("V "+taskLabel3.getText().substring(2));}
                            }
                        }
                        buttonRight.setVisible(passedChecks);
                        codeEditorPane.setEditable(false);
    
                        // refresh screen
                        appFrame.repaint();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
            sw2.execute();
        }
        
    }

    // Takes the command and combines it into a printed statement
    private static String printLines(String cmd, InputStream ins) throws Exception {
        String output = "";
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            output+=(cmd + " " + line +"\n");
        }
        return output;
    }

    // compiles and runs the file, then returns the stdout and stderr
    private static String runProcess(String[] command) throws Exception {
        String result= "";
        Process pro = Runtime.getRuntime().exec(command);
        result+= printLines("OUT |", pro.getInputStream());
        result+= printLines("ERR |", pro.getErrorStream());
        pro.waitFor();
        return result;
    }
}