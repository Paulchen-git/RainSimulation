import java.awt.*;

public class Raindrop {

    private float x;
    private float y;
    private int length;
    private float speed;
    private int thickness;
    private int time;

    public Raindrop() {
        this.x = (float) (Math.random() * RainSimulation.WIDTH);
        this.y = (float) (Math.random() * RainSimulation.HEIGHT)-RainSimulation.HEIGHT;
        this.length = (int) (Math.random() * 20) + 1;
        this.thickness = (int) this.length / 10;
        this.speed = RainSimulation.SPEED;
    }

    public void update() {
        time++;
        y += speed*time/10;
        if (y > RainSimulation.HEIGHT) {
            y = (float) (Math.random() * RainSimulation.HEIGHT)-RainSimulation.HEIGHT;
            x = (float) (Math.random() * RainSimulation.WIDTH);
            time = 0;
        }
        
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(thickness));
        g.drawLine((int) x, (int) y, (int) x, (int) y + length);
    }
}
