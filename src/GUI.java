import javax.swing.*;
import java.awt.*;

public class GUI implements UI{

    JPanel panel = new JPanel();
    JFrame frame = new JFrame();

    public GUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(10, 10, 512, 512);
        frame.setVisible(true);

        World world = new World(25,25);
        JPanel panel = new JPanel() {
            public void paint(Graphics g) {
                boolean isEmpty = true;
                for (int y = 0; y < world.grid.length(); y++) {
                    for (int x = 0; x < world.grid[y].length(); x++) {
                        if (world.grid[y][x].getCurrState.equalsIgnoreCase("Herbivore")) {
                            g.setColor(Color.yellow);
                        } else if (world.grid[y][x].getCurrState().equalsIgnoreCase("Plant")) {
                            g.setColor(Color.green);
                        }
                        g.fillRect(x * 25, y * 25, 625, 625);
                    }
                }
            }


        }
        frame.add(panel);
    }
}
