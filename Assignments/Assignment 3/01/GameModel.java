public class GameModel 
{
    public boolean[][] board;

    private int width;
    private int height;

    public GameModel(int width, int height)
    {
        this.width = width;
        this.height = height;
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
        return (board[i][j] == true) ? true : false;
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
                returnString += ", ";
            }
        }
        returnString += "]";

        return returnString;
    }
}
