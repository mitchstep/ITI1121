import javax.swing.*;
import java.awt.*;

// your other import here if needed

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out a matrix of <b>GridButton</b> (the actual game) and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameView extends JFrame {

    // your variables here
    private GameModel gameModel;
    private GameController gameController;
    private GridButton buttons;


    /**
     * Constructor used for initializing the Frame
     * 
     * @param gameModel
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public GameView(GameModel gameModel, GameController gameController) {
        super("Lights Out");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);


        JFrame window = new JFrame();

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(gameModel.getHeight(),gameModel.getWidth()));
        JPanel choice = new JPanel();

        window.setBounds(0,0,200,200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBackground(Color.WHITE);
        window.setLayout(new GridLayout(2, 3));


        this.gameModel = gameModel;
        this.gameController = gameController;
        this.buttons = new GridButton(gameModel.getWidth(),gameModel.getHeight());

        for (int i = 0; i < buttons.getColumn(); i++){
            for (int j = 0; j < buttons.getRow(); j++){
                buttons.buttons[i][j].addActionListener(gameController);
                buttons.buttons[i][j].setIcon(new ImageIcon("Icons\\Light-1.png"));
                this.buttons.buttons[i][j].setSize(10,10);
                grid.add(this.buttons.buttons[i][j]);
            }
        }

        JButton reset;
        reset = new JButton("reset");
        reset.addActionListener(gameController);
        choice.add(reset);

        JButton random;
        random = new JButton("random");
        random.addActionListener(gameController);
        choice.add(random);

        JButton quit;
        quit = new JButton("quit");
        quit.addActionListener(gameController);
        choice.add(quit);

        window.getContentPane().add(grid);

        window.getContentPane().add(choice);
        window.pack();

        window.setVisible(true);
    }

    /**
     * updates the status of the board's GridButton instances based 
     * on the current game model, then redraws the view
     */

    public void update(){



        // YOUR CODE HERE

    }

    /**
     * returns true if the ``solution'' checkbox
     * is checked
     *
     * @return the status of the ``solution'' checkbox
     */

    public boolean solutionShown(){
        return false;
        // YOUR CODE HERE

    }

}
