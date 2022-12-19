import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

// Some code borrowed from Penkaj at https://www.digitalocean.com/community/tutorials/compile-run-java-program-another-java-program

// TermIDE runs in the terminal. It acts like a lightweight and strict IDE that forces you to write line-by-line. It writes to a file, comoiles said file, and then returns back stdout and stderr.

public class TermIDE {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            while (true) {
                // Intro
                System.out.println("\033[H\033[2JWelcome to the temporary code editor! Enter code line-by-line. Boilerplate code is already written for you. To save and compile, enter the closing bracket for the main method.\n\n");
                
                // Init Read/Writer
                PrintWriter out = new PrintWriter("TermIDE-Prototype/Code.java");
                ArrayList<String> codeLines = new ArrayList<String>();
                
                // Boilerplate Code
                codeLines.add("import java.util.ArrayList;");
                codeLines.add("");
                codeLines.add("public class Code {");
                codeLines.add("public static void main(String[] args) {");
                
                // Input Vars
                int lineCount = codeLines.size()+1;
                String inputValue = "";
                String str = "";
                int spacer = 0;

                // Print boot
                String bootFormat;
                for (int i = 0; i < codeLines.size(); i++){
                    str = lineCount < 10 ? "0" : "";
                    String line = codeLines.get(i);
                    bootFormat = String.format("{%s%d} | "+"    ".repeat(spacer), str, i+1);
                    System.out.println(bootFormat+line);
                    if (line.contains("{")){
                        spacer++;
                    } else if (line.contains("}")){
                        spacer --;
                    }
                }

                // Loop handler
                while (spacer >= 1){ // will wait until spacer is 0
                    str = lineCount < 10 ? "0" : "";
                    String lineFormatter = (String.format("{%s%d} | ", str, lineCount)) + "    ".repeat(spacer);
                    System.out.print(lineFormatter);
                    inputValue = in.nextLine();

                    // Spacer adjustment
                    if (inputValue.contains("{")){
                        spacer++;
                    }
                    if (inputValue.contains("}")){
                        spacer--;
                    }

                    // Prettier
                    String prettyFormat;

                    if (inputValue.equals("}")){
                        // input is SOLELY close bracket
                        prettyFormat = (String.format("{%s%d} | ", str, lineCount) + "    ".repeat(spacer));
                        System.out.print("\033[H"+"\n".repeat(2+lineCount)); // bring to the beginning of the line to adjust
                        System.out.println(prettyFormat+inputValue+"    "); // replace the line
                        // Line addition
                        codeLines.add(inputValue);
                        lineCount++;
                    } else if (inputValue.contains("}") && !(inputValue.contains("{"))){
                        // input has a close bracket but not on the line with open bracket
                        prettyFormat = (String.format("{%s%d} | ", str, lineCount) + "    ".repeat(spacer+1));
                        inputValue = inputValue.replace("}", "");
                        System.out.print("\033[H"+"\n".repeat(2+lineCount)); // bring to the beginning of the line to adjust
                        System.out.println(prettyFormat+inputValue+"    "); // replace the line
                        // line addition
                        codeLines.add(inputValue);
                        lineCount++;
                        // account for bracket replacement
                        str = lineCount < 10 ? "0" : "";
                        prettyFormat = (String.format("{%s%d} | ", str, lineCount) + "    ".repeat(spacer));
                        System.out.println(prettyFormat+"}    ");
                        codeLines.add("}");
                        lineCount++;
                    } else {
                        // Line has both open and close brackets, or no brackets at all. spacing won't change.
                        codeLines.add(inputValue);
                        lineCount++;
                    }
                }
                
                // Write to file
                out.write(String.join("\n", codeLines));                                                                                                                                                                                                                                                                                                                                                    

                // Prepare results
                System.out.println("\n*********// $ java TermIDE-Prototype/Code.java //*********\n");
                out.close();
                runProcess(new String[]{"java","TermIDE-Prototype/Code.java"});
                System.out.print("\n\033[0m*********// End Process //*********\n\nEnter {Q} to Quit\n >> ");
                if (in.nextLine().equals("Q")) {
                    break;
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // Takes the command and combines it into a printed statement
    private static void printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + " " + line);
        }
      }

      // compiles and runs the file, then returns the stdout and stderr
      private static void runProcess(String[] command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines("\033[32;1m|", pro.getInputStream());
        printLines("\033[31;1m|", pro.getErrorStream());
        pro.waitFor();
        System.out.println("\033[33;1m| exitValue()\033[0m\033[33m " + pro.exitValue());
      }

}