import javax.swing.JFrame;

public class Window {

    private JFrame jframe;

    public Window(Panel panel) {
        jframe = new JFrame("Rain Simulation");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(panel);
        jframe.pack();
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
