import javax.swing.*;
import java.awt.*;

public class GUI implements UI{

    JPanel panel = new JPanel();
    panel.setBackground(Color.white);
    panel.setBounds(0, 0, 250, 250);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);
    frame.setSize(750, 750);
    frame.setVisible(true);
    frame.add(panel);
}
