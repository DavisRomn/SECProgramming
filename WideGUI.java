import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class WideGUI extends JFrame {
    private JFrame main;
//    private Scheduler theScheduler;

    public WideGUI () {
        main = new JFrame();
        main.setTitle("Elevator Wide View");
		main.setSize(440, 860);
		main.setLocationRelativeTo(null);
		main.setResizable(false);
		main.setLayout(new BorderLayout());
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        main.setVisible(true);
    }

    public static void main(String[] args) {
		WideGUI d = new WideGUI();
	}
}
