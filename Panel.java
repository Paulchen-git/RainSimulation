import javax.swing.JPanel;
import java.awt.*;

public class Panel extends JPanel {

    private RainSimulation rainSimulation;
    

    public Panel(RainSimulation rainSimulation) {
        this.rainSimulation = rainSimulation;
        setPanelSize();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        rainSimulation.update();
        rainSimulation.render(g);
    }

    private void setPanelSize() {
        setPreferredSize(new Dimension(RainSimulation.WIDTH, RainSimulation.HEIGHT));
    }
}
