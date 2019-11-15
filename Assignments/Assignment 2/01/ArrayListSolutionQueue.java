import java.util.ArrayList;

class ArrayListSolutionQueue implements SolutionQueue
{
    ArrayList<Solution> queue;

    public ArrayListSolutionQueue()
    {
        queue = new ArrayList<Solution>();
    }

    public void enqueue(Solution value)
    {
        queue.add(value);
    }

    public Solution dequeue()
    {
        Solution firstItem = queue.get(0);
        queue.remove(firstItem);
        return firstItem;
    }

    public boolean isEmpty()
    {
        return (queue.size() == 0);
    }
}