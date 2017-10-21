import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.*;

public class WideGUI extends JFrame {
    private JFrame main;
    private JTextField[] speedLabel;
    private JTextField[] heightLabel;
    private JTextField[] directionLabel;
    private JTextField[] stopLabel;
    private JTextField[] currentFloor;
    private JButton[] ups;
    private JButton[] downs;
    private Scheduling theScheduler;

    private class eventListener implements ActionListener {
		WideGUI display;
		public eventListener (WideGUI d) {
			display = d;
		}
		public void actionPerformed (ActionEvent e) {
			if (e.getSource() == ups[0]) {
				theScheduler.callUp(4);
			} else if (e.getSource() == ups[1]) {
				theScheduler.callUp(3);
			} else if (e.getSource() == ups[2]) {
				theScheduler.callUp(2);
			} else if (e.getSource() == ups[3]) {
				theScheduler.callUp(1);
			} else if (e.getSource() == ups[4]) {
				theScheduler.callUp(0);
			} else if (e.getSource() == downs[0]) {
                theScheduler.callDown(5);
            } else if (e.getSource() == downs[1]) {
                theScheduler.callDown(4);
            } else if (e.getSource() == downs[2]) {
                theScheduler.callDown(3);
            } else if (e.getSource() == downs[3]) {
                theScheduler.callDown(2);
            } else if (e.getSource() == downs[4]) {
                theScheduler.callDown(1);
            }
		}
    }

    public WideGUI () {
        main = new JFrame();
        main.setTitle("Elevator Wide View");
		main.setSize(600, 1020);
		main.setLocationRelativeTo(null);
		main.setResizable(false);
		main.setLayout(new BorderLayout());
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        theScheduler = new Scheduling();

        eventListener listen = new eventListener(this);

        JPanel top = new JPanel(new GridLayout(0, 6));
        speedLabel = new JTextField[3];
        double[] speeds = new double[3]; ////////REPLACE WITH ACTUAL VALUES
        for (int i = 0; i < 3; i++) {
            speeds[i] = (double) i; //////////REPLACE WITH ACTUAL VALUES
            JLabel temp = new JLabel("Speed: ");
            temp.setFont(new Font("Courier", Font.PLAIN, 13));
            top.add(temp);
    		speedLabel[i] = new JTextField("" + theScheduler.getSpeed(i));
    		speedLabel[i].setFont(new Font("Courier", Font.PLAIN, 13));
            speedLabel[i].setEditable(false);
    		top.add(speedLabel[i]);
        }
        heightLabel = new JTextField[3];
        double[] heights = new double[3]; ////////REPLACE WITH ACTUAL VALUES
        for (int i = 0; i < 3; i++) {
            heights[i] = (double) i + 3; //////////REPLACE WITH ACTUAL VALUES
            JLabel temp = new JLabel("Height: ");
            temp.setFont(new Font("Courier", Font.PLAIN, 13));
            top.add(temp);
    		heightLabel[i] = new JTextField("" + theScheduler.getHeight(i));
    		heightLabel[i].setFont(new Font("Courier", Font.PLAIN, 13));
            heightLabel[i].setEditable(false);
    		top.add(heightLabel[i]);
        }
        directionLabel = new JTextField[3];
        double[] direction = new double[3]; ////////REPLACE WITH ACTUAL VALUES
        for (int i = 0; i < 3; i++) {
            direction[i] = (double) i + 6; //////////REPLACE WITH ACTUAL VALUES
            JLabel temp = new JLabel("Direction: ");
            temp.setFont(new Font("Courier", Font.PLAIN, 13));
            top.add(temp);
    		directionLabel[i] = new JTextField("" + theScheduler.getDirection(i));
    		directionLabel[i].setFont(new Font("Courier", Font.PLAIN, 13));
            directionLabel[i].setEditable(false);
    		top.add(directionLabel[i]);
        }
        stopLabel = new JTextField[3];
        double[] stop = new double[3]; ////////REPLACE WITH ACTUAL VALUES
        for (int i = 0; i < 3; i++) {
            stop[i] = (double) i + 9; //////////REPLACE WITH ACTUAL VALUES
            JLabel temp = new JLabel("Stop At: ");
            temp.setFont(new Font("Courier", Font.PLAIN, 13));
            top.add(temp);
    		stopLabel[i] = new JTextField("" + theScheduler.getDestinations(i).toString());
    		stopLabel[i].setFont(new Font("Courier", Font.PLAIN, 13));
            stopLabel[i].setEditable(false);
    		top.add(stopLabel[i]);
        }
        main.add("North", top);

        ups = new JButton[5];
        JPanel mid = new JPanel(new GridLayout(0, 3));
        JPanel mid1 = new JPanel(new BorderLayout());
        JPanel mid1r = new JPanel(new GridLayout(0, 1, 20, 130));
        JLabel temp = new JLabel("");
        mid1r.add(temp);
        for (int i = 0; i < 5; i++) {
            ups[i] = new JButton("/\\");
            ups[i].addActionListener(listen);
            mid1r.add(ups[i]);
        }
        mid1.add("East", mid1r);
        currentFloor = new JTextField[3];
        currentFloor[0] = new JTextField("" + 0);
        currentFloor[0].setFont(new Font("Courier", Font.PLAIN, 18));
        currentFloor[0].setEditable(false);
        currentFloor[0].setHorizontalAlignment(JTextField.CENTER);
        mid1.add("North", currentFloor[0]);
        mid.add(mid1);

        downs = new JButton[5];
        JPanel mid2 = new JPanel(new BorderLayout());
        JPanel mid2r = new JPanel(new GridLayout(0, 1, 20, 130));
        temp = new JLabel("");
        for (int i = 0; i < 5; i++) {
            downs[i] = new JButton("\\/");
            downs[i].addActionListener(listen);
            mid2r.add(downs[i]);
        }
        mid2r.add(temp);
        mid2.add("East", mid2r);
        currentFloor[1] = new JTextField("" + 1);
        currentFloor[1].setFont(new Font("Courier", Font.PLAIN, 18));
        currentFloor[1].setEditable(false);
        currentFloor[1].setHorizontalAlignment(JTextField.CENTER);
        mid2.add("North", currentFloor[1]);
        mid.add(mid2);

        JPanel mid3 = new JPanel(new BorderLayout());
        currentFloor[2] = new JTextField("" + 2);
        currentFloor[2].setFont(new Font("Courier", Font.PLAIN, 18));
        currentFloor[2].setEditable(false);
        currentFloor[2].setHorizontalAlignment(JTextField.CENTER);
        mid3.add("North", currentFloor[2]);
        mid.add(mid3);

        main.add("Center", mid);



        main.setVisible(true);
    }

    public void updates() {
        while (true) {
            for (int i = 0; i < 3; i++) {
                speedLabel[i].setText("" + theScheduler.getSpeed(i));
                heightLabel[i].setText("" + theScheduler.getHeight(i));
                if (theScheduler.getDirection(i) > 0) {
                    directionLabel[i].setText("Up");
                } else if (theScheduler.getDirection(i) < 0) {
                    directionLabel[i].setText("Down");
                } else {
                    directionLabel[i].setText("Stopped");
                }
                stopLabel[i].setText("" + theScheduler.getDestinations(i).toString());
            }
        }
    }

    public static void main(String[] args) {
		WideGUI d = new WideGUI();
        d.updates();
	}
}
