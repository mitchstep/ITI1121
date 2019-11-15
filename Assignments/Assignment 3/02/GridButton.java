// YOUR IMPORT HERE

import javax.swing.*;
import java.awt.*;

public class GridButton extends JButton {


    // YOUR VARIABLES HERE
    public static final ImageIcon on = new ImageIcon("\\Icons\\Light-0.png");
    public static final ImageIcon off = new ImageIcon("\\Icons\\Light-1.png");

    private int column;
    private int row;

    public JButton[][] buttons;


    /**
     * Constructor used for initializing a GridButton at a specific
     * Board location.
     * 
     * @param column
     *            the column of this Cell
     * @param row
     *            the row of this Cell
     */

    public GridButton(int column, int row) {
        this.column = column;
        this.row = row;
        this.buttons = new JButton[column][row];

        for (int i = 0; i < buttons.length; i++){
            for (int j = 0; j < buttons[0].length; j++){
                JButton button = new JButton();
                button.setBackground(Color.WHITE);
                button.setIcon(off);
                button.setVisible(true);
                button.setSize(10,10);
                buttons[i][j] = button;
                add(buttons[i][j]);
            }
        }
        this.setVisible(true);
    }

   /**
    * sets the icon of the button to reflect the
    * state specified by the parameters
    * @param isOn true if that location is ON
    * @param isClicked true if that location is
    * tapped in the model's current solution
    */ 
    public void setState(boolean isOn, boolean isClicked) {

    }

    public void getImageIcon(){

    }

 

    /**
     * Getter method for the attribute row.
     * 
     * @return the value of the attribute row
     */

    public int getRow() {
        return row;
    }

    /**
     * Getter method for the attribute column.
     * 
     * @return the value of the attribute column
     */

    public int getColumn() {
        return column;
    }


    // YOUR OTHER METHODS HERE
}
