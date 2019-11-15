import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.Scanner;

// YOUR OTHER IMPORTS HERE IF NEEDED

/**
 * The class <b>GameController</b> is the controller of the game. It is a listener
 * of the view, and has a method <b>play</b> which computes the next
 * step of the game, and  updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */


public class GameController implements ActionListener, ItemListener {

    // YOUR VARIABLES HERE
    private int width;
    private int height;

    private GameModel model;

    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param width
     *            the width of the board on which the game will be played
     * @param height
     *            the height of the board on which the game will be played
     */
    public GameController(int width, int height) {
        this.width = width;
        this.height = height;

        this.model = new GameModel(width, height);
    }


    /**
     * Callback used when the user clicks a button (reset, 
     * random or quit)
     *
     * @param e
     *            the ActionEvent
     */

    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("reset")) {
            model.reset();
        }

        if(e.getActionCommand().equals("random")) {
            model.randomize();
        }

        if(e.getActionCommand().equals("quit")) {
            System.exit(0);
        }

    }

    /**
     * Callback used when the user select/unselects
     * a checkbox
     *
     * @param e
     *            the ItemEvent
     */

    public void  itemStateChanged(ItemEvent e){

        // YOU CODE HERE
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    // YOUR OTHER METHODS HERE

    public static void test(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Test UI");
        System.out.println("Enter Width then Height:");
        int width = scan.nextInt();
        int height = scan.nextInt();
        GameModel test = new GameModel(width,height);
        System.out.println(test);
        do{
            System.out.println("Enter the dot you want to click at positon i then j:");
            int i = scan.nextInt();
            int j = scan.nextInt();
            test.click(i,j);
            System.out.println(test);
        }while (!test.isFinished());
        System.out.print("Congratulations! you solved it in "+test.getNumberOfSteps()+" steps");

    }

    public static void main(String[] args){
        GameController test = new GameController(3,3);
        GameModel b = new GameModel(3,3);
        GameView a = new GameView(b,test);
        //test();
    }

}
