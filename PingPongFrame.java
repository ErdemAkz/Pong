
import javax.swing.*;
import java.awt.*;

public class PingPongFrame extends JFrame {

    public PingPongFrame() {
        setSize(Screen.width, Screen.heigth);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        PingPongPanel p1 = new PingPongPanel();
        p1.setLayout(null);
        p1.setBackground(Color.BLACK);
        add(p1);
        this.setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        getContentPane().setPreferredSize(new Dimension(Screen.width, Screen.heigth));
        pack();

        while (true){
            p1.repaint();
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


}
