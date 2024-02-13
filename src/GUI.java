import javax.swing.*;
import java.awt.*;

public class GUI {

    JPanel panel = new JPanel();
    JFrame frame = new JFrame();

    public GUI() {
        JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setLayout(new GridLayout(25,25,0,0));
        frame.setTitle("Game of Life");

        World world = new World(25,25);

        JPanel panel[][] = new JPanel[25][25];
        
        for (int y = 0; y < world.grid.length; y++) {
            for (int x = 0; x < world.grid[y].length; x++) {
                panel[y][x] = new JPanel();
                panel[y][x].setBorder(BorderFactory.createLineBorder(Color.black, 1));
                if (world.grid[y][x].getCurrState().equalsIgnoreCase("Herbivore")) {
                    panel[y][x].setBackground(Color.yellow);
                } else if (world.grid[y][x].getCurrState().equalsIgnoreCase("Plant")) {
                    panel[y][x].setBackground(Color.green);
                } else {
                    panel[y][x].setBackground(Color.white);
                }
                frame.add(panel[y][x]);
            }
        }

		frame.setVisible(true);
    }
}
