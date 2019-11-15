/**
 * An implementation of the interface WordMap using linked elements.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

public class LinkedWordMap implements WordMap {

    private Node first;

    public LinkedWordMap()
    {
        first = new Node(null, null, null, 0);
        first.next = first;
        first.previous = first;
    }

    /**
     * Returns the logical size of this WordMap. That is the number of
     * associations currently stored in it.
     *
     * @return the logical size of this WordMap
     */

    public int size() {
        Node current = first.next;
        int total = 0;

        while (true)
        {
            if (current == first)
            {
                break;
            }

            total++;

            if (current.next != first)
            {
                current = current.next;
            }
            else
            {
                break;
            }
        }
        return total;
    }

    /**
     * Returns true if and only if this WordMap contains the specified
     * word.
     *
     * @param key the specified word
     * @return true if and only if this WordMap contains the specified word
     * @throws NullPointerException if the value of the parameter is null
     */

    public boolean contains(String key)
    {
        if (key == null)
        {
            throw new NullPointerException();
        }

        Node current = first.next;

        while (true)
        {
            if (current == first)
            {
                break;
            }

            if (current.key.equals(key))
            {
                return true;
            }
            else
            {
                if (current.next != first)
                {
                    current = current.next;
                }
                else
                {
                    break;
                }
            }
        }
        return false;
    }

    /**
     * Returns the count associated with the specified word or 0 if
     * the word is absent.
     *
     * @param key the specified word
     * @return the count associated with the specified word or 0 if absent
     * @throws NullPointerException if the value of the parameter is null
     */

    public int get(String key) {

        if (key == null)
        {
            throw new NullPointerException();
        }

        Node current = first.next;

        while (true)
        {
            if (current == first)
            {
                break;
            }

            if (current.key.equals(key))
            {
                return current.value;
            }
            else
            {
                if (current.next != first)
                {
                    current = current.next;
                }
                else
                {
                    break;
                }
            }
        }
        return 0;
    }

    /**
     * Increments by 1 the counter associated with the specified
     * word. If the specified word is absent from the data structure,
     * a new association is created.
     *
     * @param key the specified word
     * @throws NullPointerException if the value of the parameter is null
     */

    public void update(String key)
    {
        if (key == null)
        {
            throw new NullPointerException();
        }

        Node current = first.next;

        // if there are no nodes other than the first, add one
        if (current == first)
        {
            Node newNode = new Node(first, first, key, 1);
            first.next = newNode;
            first.previous = newNode;
            return;
        }

        // go over the whole list and find out if the key exists.
        // Done here instead of calling contains() so we don't end up having to iterated over the whole list twice (once to find out if the key is contained, and once to find the key to actually increment the value)
        while (true)
        {
            if (current == first)
            {
                break;
            }

            if (current.key.equals(key))
            {
                current.value++;
                return;
            }
            else
            {
                if (current.next != first)
                {
                    current = current.next;
                }
                else
                {
                    break;
                }
            }
        }

        // if it's not done, add a new node
        // iterate over list and find out where the new node goes
        current = first.next;
        while (current != first)
        {
            if (current.next == first)
            {
                Node newNode = new Node(current, first, key, 1);
                current.next = newNode;
                break;
            }

            current = current.next;
        }
    }

    /**
     * Returns all the keys (words) of this WordMap using their
     * natural order.
     *
     * @return all the keys (words)
     */

    public String[] keys()
    {
        int size = size();
        Node current = first.next;
        String[] keys = new String[size];

        // fill the array
        for (int i = 0; i < size; i++)
        {
            keys[i] = current.key;
            current = current.next;
        }

        // sort the array
        for (int i = 0; i < size - 1; i++)
        {
            for (int j = 0; j < size - i - 1; j++)
            {
                if (keys[j].compareTo(keys[j+1]) > 0)
                {
                    String temp = keys[j];
                    keys[j] = keys[j+1];
                    keys[j+1] = temp;
                }
            }
        }

        return keys;
    }

    /**
     * Returns all the counts associated with keys in this
     * WordMap. The counts are in the same order as that of the keys
     * returned by the method keys().
     *
     * @return all the counts
     */

    public Integer[] counts() {
        String[] keys = keys();
        Integer[] values = new Integer[keys.length];

        for (int i = 0; i < values.length; i++)
        {
            values[i] = get(keys[i]);
        }

        return values;
    }

    public void print()
    {
        System.out.println();

        Node current = first.next;

        while (true)
        {
            System.out.println(current.key + " : " + current.value);

            if (current.next == first)
            {
                break;
            }

            current = current.next;
        }

        System.out.println();
    }


    private class Node
    {
        private Node next;
        private Node previous;

        private String key;
        private int value;

        private Node(Node previous, Node next, String key, int value)
        {
            this.next = next;
            this.previous = previous;
            this.key = key;
            this.value = value;
        }
    }


}
