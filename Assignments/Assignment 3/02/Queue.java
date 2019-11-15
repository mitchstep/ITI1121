public interface Queue<E>
{
    public void enqueue(E object);
    public E dequeue();
    public boolean isEmpty();
}
