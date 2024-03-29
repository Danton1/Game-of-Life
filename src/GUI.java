import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The GUI class represents the graphical user interface for the Game of Life.
 * It is responsible for displaying the current state of the world and handling
 * user input. The appearance of each cell in the world is updated based on the
 * lifeform it currently holds. The GUI class also listens for user input and
 * updates the game state when the user interacts with the GUI through mouse
 * clicks or key presses.
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
     * The GUI object is responsible for displaying the current state of the world grid and handling user input.
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
        frame.setBounds(400, 20, 710, 710);
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

        // Adding a mouse listener to the frame to handle user input
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                game.incrementTurn();
                // Looping through each cell in the world grid
                for(int i = 0; i < world.getHeight(); i++) {
                    for (int j = 0; j < world.getWidth(); j++) {
                        update(new int[]{i, j});
                    }
                }
                // Repainting the frame to reflect the updated state of the world grid
                frame.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            // Method to handle pressing Spacebar and Enter to increment the turn
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER){
                    game.incrementTurn();
                    // Looping through each cell in the world grid
                    for(int i = 0; i < world.getHeight(); i++) {
                        for (int j = 0; j < world.getWidth(); j++) {
                            update(new int[]{i, j});
                        }
                    }
                }
                // Repainting the frame to reflect the updated state of the world grid
                frame.repaint();
            }
        });
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
        // Repainting the cell to reflect the updated appearance
        cells[x][y].repaint();
    }

}
