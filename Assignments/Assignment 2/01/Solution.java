class Solution
{
    public Boolean[][] board;
    public int[] boardIndex;


    public Solution(int width, int height)
    {
        board = new Boolean[height][width];
        boardIndex = new int[]{0,0};
    }

    public Solution(Solution other)
    {
        board = new Boolean[other.board.length][other.board[0].length];
        boardIndex = new int[]{other.boardIndex[0],other.boardIndex[1]};

        for (int i = 0; i < other.board.length; i++)
        {
            for (int j = 0; j < other.board[i].length; j++)
            {
                board[i][j] = other.board[i][j];
            }
        }
    }

    public boolean equals(Object other)
    {
        if (!(other instanceof Solution))
        {
            return false;
        }

        Solution otherSolution = (Solution)other;

        for (int i = 0; i < otherSolution.board.length; i++)
        {
            for (int j = 0; j < otherSolution.board[i].length; j++)
            {
                if (otherSolution.board[i][j] != board[i][j])
                {
                    return false;
                }
            }
        }

        return true;
    }

    public void setNext(Boolean value)
    {
        board[boardIndex[0]][boardIndex[1]] = value;
        incrementBoardIndex();
    }

    private void incrementBoardIndex()
    {
        int y = boardIndex[0];
        int x = boardIndex[1];

        if (x+1 < board[0].length)
        {
            x++;
        }
        else
        {
            x = 0;
            if (y+1 < board.length)
            {
                y++;
            }
        }

        boardIndex[0] = y;
        boardIndex[1] = x;
    }

    public boolean isReady()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == null)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSuccessful()
    {
        int[][] boardSelections = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j])
                {
                    boardSelections = incrementSelfAndNeighbors(boardSelections, i, j);
                }
            }
        }

        for (int i = 0; i < boardSelections.length; i++)
        {
            for (int j = 0; j < boardSelections[i].length; j++)
            {
                if (boardSelections[i][j] % 2 == 0)
                {
                    return false;
                }
            }
        }

        return true;
    }

    private int[][] incrementSelfAndNeighbors(int[][] boardSelections, int y, int x)
    {
        int[][] selections = boardSelections;

        // increment selection
        selections[y][x]++;

        // increment top neighbor if exists
        if (y > 0)
        {
            selections[y-1][x]++;
        }
        
        // increment bottom neighbor if exists
        if (y < selections.length-1)
        {
            selections[y+1][x]++;
        }

        // increment left neighbor if exists
        if (x > 0)
        {
            selections[y][x-1]++;
        }

        // increment right neighbor if exists
        if (x < selections[y].length-1)
        {
            selections[y][x+1]++;
        }

        return selections;
    }

    public String toString()
    {
        String returnString = "[";

        for (int i = 0; i < board.length; i++)
        {
            returnString += "[";
            for (int j = 0; j < board[i].length; j++)
            {
                returnString += (board[i][j] != null) ? board[i][j].toString() : "null";

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