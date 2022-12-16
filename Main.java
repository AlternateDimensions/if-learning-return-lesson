public class Main {
    public static void main(String[] args){
        Frame appFrame = new Frame();
        GradientPanel backgroundPanel = new GradientPanel();
        Panel headerPanel = new Panel();
        Label titleLabel = new Label(false, false, "", new int[]{0,0,0}, 0, "if (learning) {return lesson;}",0, 0, new int[]{255,255,255, Math.round((255/255)*255)}, new String[]{"JetBrains Mono", "1", "50"},0,new int[]{255,255,255,100}, false, 3,2);
        headerPanel.add(titleLabel);
        backgroundPanel.add(headerPanel);
        appFrame.add(backgroundPanel);
        appFrame.setVisible(true);

    }
}