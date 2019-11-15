import java.util.ArrayList;

class LightsOut
{
    public static void main(String[] args)
    {
        LightsOut lights = new LightsOut();

        String widthString;
        String heightString;
        if (args.length < 1)
        {
            widthString = "3";
            heightString = "3";
        }
        else if (args.length < 2)
        {
            widthString = (args[0] != null) ? args[0] : "3";
            heightString = "3";
        }
        else 
        {
            widthString = (args[0] != null) ? args[0] : "3";
            heightString = (args[1] != null) ? args[1] : "3";
        }        

        int width = (Integer.valueOf(widthString) > 0) ? Integer.valueOf(widthString) : 3;
        int height = (Integer.valueOf(heightString) > 0) ? Integer.valueOf(heightString) : 3;

        ArrayList<Solution> solutions = lights.solve(width, height);

        //System.out.println(" ");

        for (int i = 0; i < solutions.size(); i++)
        {
            System.out.println(solutions.get(i));
        }

        System.out.println("In a board of " + width + "x" + height + ": " + solutions.size() + " solutions");
    }


    public ArrayList<Solution> solve(int width, int height)
    {
        ArrayList<Solution> result = new ArrayList<Solution>();

        ArrayListSolutionQueue partialSolutions = new ArrayListSolutionQueue();
        partialSolutions.enqueue(new Solution(width, height));

        //int cellNumber = width * height;
        //int possibilities = (int)Math.pow(2, cellNumber) * 2 - 2;

        //int counter = 0;
        while (!partialSolutions.isEmpty())
        {
            Solution current = partialSolutions.dequeue();

            //int percent = (int)Math.round(((double)counter / (double)possibilities) * 100);
            //System.out.println(percent + "%");

            if (current.isReady())
            {
                if (current.isSuccessful())
                {
                    result.add(current);
                }
            }
            else
            {
                Solution falseBranch = new Solution(current);
                Solution trueBranch = new Solution(current);

                trueBranch.setNext(true);
                falseBranch.setNext(false);

                partialSolutions.enqueue(trueBranch);
                partialSolutions.enqueue(falseBranch);
            }

            //counter++;
        }

        return result;
    }
}