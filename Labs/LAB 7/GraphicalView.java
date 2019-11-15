import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicalView extends JFrame implements View {
    private JLabel input;
    private Timer model;
    public GraphicalView (Timer model, Controller controller) {
        setLayout (new GridLayout(2, 3));
        this.model = model;


        //Increment buttons
        JButton incHour;
        incHour = new JButton("IncrementHours");
        incHour.addActionListener(controller);
        add(incHour);

        JButton incMin;
        incMin = new JButton("IncrementMinutes");
        incMin.addActionListener(controller);
        add(incMin);

        JButton incSec;
        incSec = new JButton("IncrementSeconds");
        incSec.addActionListener(controller);
        add(incSec);

        //clock display
        input = new JLabel();
        add(input);

        //Decrement buttons
        JButton decHour;
        decHour = new JButton("DecrementHours");
        decHour.addActionListener(controller);
        add(decHour);

        JButton decMin;
        decMin = new JButton("DecrementMinutes");
        decMin.addActionListener(controller);
        add(decMin);

        JButton decSec;
        decSec = new JButton("DecrementSeconds");
        decSec.addActionListener(controller);
        add(decSec);

        //setup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 100);

        //display the window
        setVisible(true);
    }
    public void update () {
        input.setText(model.toString());
    }
}