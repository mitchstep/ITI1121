import java.util.ArrayList;

public class QueueImplementation<E> implements Queue<E> {

    private ArrayList<E> queue;

    public QueueImplementation()
    {
        queue = new ArrayList<E>();
    }

    public void enqueue(E object)
    {
        queue.add(object);
    }

    public E dequeue()
    {
        E object = queue.get(0);
        queue.remove(0);

        return object;
    }

    public boolean isEmpty()
    {
        return (queue.size() == 0);
    }
}
