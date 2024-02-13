import javax.swing.*;
import java.awt.*;

public class GUI implements UI{

    JPanel panel = new JPanel();
    JFrame frame = new JFrame();

    public GUI(){
        panel.setBackground(Color.white);
        panel.setBounds(0, 0, 250, 250);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(750, 750);
        frame.add(panel);
        frame.setVisible(true);
    }

}
