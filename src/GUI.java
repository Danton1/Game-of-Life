import javax.swing.*;
import java.awt.*;

/**
 * The GUI class represents the graphical user interface for the Game of Life.
 * @author Danton Soares
 * @version Assignment 2a
 */
public class GUI {
    // Class variables declaration
    private Game game;
    private World world;
    private int width;
    private int height;

    // 2D array to hold JPanel objects representing cells
    private JPanel[][] cells;

    // JFrame object for the GUI
    JFrame frame = new JFrame();

    /**
     * Constructs a GUI object with the specified Game object.
     *
     * @param game The Game object representing the Game of Life simulation.
     */
    public GUI(Game game) {
        // Initializing class variables
        this.game = game;
        world = game.getWorld();
        width = world.getWidth();
        height = world.getHeight();

        // Setting up JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 10, 710, 710);
        frame.setTitle("A2A - Danton Soares");

        // Setting up a border to the whole frame
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        // Setting layout for the frame with negative gaps to make borders smaller
        frame.setLayout(new GridLayout(height, width, -1 , -1));

        // Initializing a 2D array of cell panels
        cells = new JPanel[height][width];

        // Looping through each cell in the world grid
        for(int i = 0; i < world.getHeight(); i++){
            for(int j = 0; j < world.getWidth(); j++){
                // Creating a new JPanel for each cell
                JPanel newPanel = new JPanel();
                // Setting up borders for the panels
                newPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
                // Adding the panel to the cells array
                cells[i][j] = newPanel;
                // Updating the Panel's color based on the lifeform
                update(new int[]{i, j});
                frame.add(newPanel);
            }
        }

        // Making the frame visible
        frame.setVisible(true);
    }

    /**
     * Updates the appearance of the specified cell based on the lifeform it currently holds.
     *
     * @param coord The coordinates of the cell to update.
     */
    public void update(int[] coord) {
        // Variables to hold the coordinates of the cell being updated
        int x = coord[0];
        int y = coord[1];

        // Getting the type of life form present in the cell
        String typeOfLife = world.grid[x][y].getCurrState();

        // Setting the background color of the cell based on the type of life form
        if (typeOfLife.equalsIgnoreCase("plant")) {
            cells[x][y].setBackground(Color.GREEN);
        } else if (typeOfLife.equalsIgnoreCase("herbivore")) {
            cells[x][y].setBackground(Color.YELLOW);
        } else {
            cells[x][y].setBackground(Color.WHITE);
        }
    }

}
