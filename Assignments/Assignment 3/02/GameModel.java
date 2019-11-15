import java.util.Random;

public class GameModel
{
    public boolean[][] board;

    private int width;
    private int height;
    private int clicks;

    public GameModel(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.clicks = 0;
        board = new boolean[height][width];
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public boolean isON(int i, int j)
    {
        return board[i][j];
    }

    public void reset()
    {
        for (int a = 0; a < board.length; a++)
        {
            for (int b = 0; b < board[0].length; b++)
            {
                board[a][b] = false;
            }
        }
        clicks = 0;
    }

    public void set(int i, int j, boolean value)
    {
        board[j][i] = value;
    }

    public String toString()
    {
        String returnString = "[";

        for (int i = 0; i < board.length; i++)
        {
            returnString += "[";
            for (int j = 0; j < board[i].length; j++)
            {
                returnString += String.valueOf(board[i][j]);

                if (j != board[i].length - 1)
                {
                    returnString += ", ";
                }
            }
            returnString += "]";

            if (i != board.length - 1)
            {
                returnString += ",\n ";
            }
        }
        returnString += "]";

        return returnString;
    }

    public void click(int i, int j){
        set(i,j,!board[i][j]);

        if(i > 0) {
            set(i-1,j,!board[i-1][j]);
        }

        if (i+1<width){
            set(i+1,j,!board[i+1][j]);
        }

        if (j > 0){
            System.out.println(board[i][j-1]);
            set(i,j-1,!board[i][j-1]);
        }

        if (j+1<height){
            System.out.println(board[i][j+1]);
            set(i,j+1,!board[i][j+1]);
        }

        clicks++;
    }

    public int getNumberOfSteps(){
        return clicks;
    }

    public boolean isFinished(){
        Solution solution = new Solution(getWidth(), getHeight());
        return solution.isSuccessful(this);
    }

    public void randomize(){
        Random rand = new Random();
        do{
            this.reset();
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[0].length;j++){
                    set(i,j,rand.nextBoolean());
                }
            }
        }while (LightsOut.solve(this)==null);
    }

    //ask about what the fuck this does
    public void setSolution(){
        LightsOut.solveShortest(this);
    }

    public boolean solutionSelects(int i, int j){
        GameModel a = this;
        a.click(i,j);
        return LightsOut.solve(a)!=null;
    }
}
