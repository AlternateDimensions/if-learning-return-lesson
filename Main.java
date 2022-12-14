public class Main {
    public static void main(String[] args){
        Frame appFrame = new Frame("if (learning) {return lesson;}", 1, false, 1920, 1080, true, "Images/favicon.png", 0, 0, 0,0, false, false); 
        GradientPanel backgroundPanel = new GradientPanel();
        Panel headerPanel = new Panel();
        appFrame.add(headerPanel);
        appFrame.add(backgroundPanel);

    }
}