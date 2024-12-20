import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class RainSimulation implements Runnable {

    private Window window;
    private Panel panel;

    private Thread thread;

    private static final int FPS = 60;
    private static final int UPS = 1;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final float SPEED = 5f;

    private ArrayList<Raindrop> raindrops;

    public RainSimulation(int numDrops) {
        panel = new Panel(this);
        window = new Window(panel);
        raindrops = new ArrayList<>();
        for (int i = 0; i < numDrops; i++) {
            raindrops.add(new Raindrop());
        }
        start();
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void update() {
        for (Raindrop raindrop : raindrops) {
            raindrop.update();
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        for (Raindrop raindrop : raindrops) {
            raindrop.render(g);
        }
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS; // DFS: 1 second divided by the FPS
        double timePerUpdate = 1000000000.0 / UPS; // DFS: 1 second divided by the UPS

        long previousTime = System.nanoTime(); // DFS: Get the current time in nanoseconds

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis(); 
        
        double deltaFrame = 0;
        double deltaUpdate = 0;

        while (true) { // DFS: Main loop of the game
            long currentTime = System.nanoTime();
            deltaFrame += (currentTime - previousTime) / timePerFrame; // DFS: Calculate the deltaFrame
            deltaUpdate += (currentTime - previousTime) / timePerUpdate; // DFS: Calculate the deltaUpdate
            previousTime = currentTime;
            

            if (deltaUpdate >= 1) { // DFS: If the deltaUpdate is greater than or equal to 1, update the game
                update();
                updates++;
                deltaUpdate--;
            }

            if (deltaFrame >= 1) { // DFS: If the deltaFrame is greater than or equal to 1, render the game
                panel.repaint();
                frames++;
                deltaFrame--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                System.out.println("FPS: " + frames + " UPS: " + updates);
                frames = 0;
                updates = 0;
                lastCheck = System.currentTimeMillis();
            }

        }
    }
}