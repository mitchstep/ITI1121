/**
 * A Binary Search Tree implementation of the interface WordMap.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

public class TreeWordMap implements WordMap {

    private static class Elem {

        private String key;
        private int count;
        private Elem left, right;

        private Elem(String key) {
            this.key = key;
            count = 1;
        }

    }

    private Elem root;
    private int size;

    public TreeWordMap()
    {
        size = 0;
        root = null;
    }

    /**
     * Returns true if and only if this WordMap contains the specified
     * word.
     *
     * @param key the specified word
     * @return true if and only if this WordMap contains the specified key
     * @throws NullPointerException if the value of the parameter is null
     */

    public boolean contains(String key) {

        if (key == null) {
            throw new NullPointerException();
        }

        boolean found = false;
        Elem current = root;
        while (! found && current != null) {
            int test = key.compareTo(current.key);
            if (test == 0) {
                found = true;
            } else if (test < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return found;
    }

    /**
     * Increments by 1 the counter associated with the specified
     * word. If the specified word is absent from the data structure,
     * a new association is created.
     *
     * @param key the specified word
     * @throws NullPointerException if the value of the parameter is null
     */

    public void update(String key) {
        if (key == null)
        {
            throw new NullPointerException();
        }

        Elem current = root;

        if (root == null)
        {
            root = new Elem(key);
            size++;
            return;
        }

        while (true)
        {
            if (key.equals(current.key))
            {
                current.count++;
                return;
            }
            else if (key.compareTo(current.key) < 0)
            {
                Elem next = current.left;

                if (next == null)
                {
                    current.left = new Elem(key);
                    size++;
                    return;
                }

                current = current.left;
            }
            else
            {
                Elem next = current.right;

                if (next == null)
                {
                    current.right = new Elem(key);
                    size++;
                    return;
                }

                current = current.right;
            }
        }
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

        if (key == null) {
            throw new NullPointerException();
        }

        boolean found = false;
        Elem current = root;
        while (current != null) {
            int test = key.compareTo(current.key);
            if (test == 0) {
                return current.count;
            } else if (test < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return 0;
    }

    /**
     * Returns the logical size of this WordMap. That is the number of
     * associations currently stored in it.
     *
     * @return the logical size of this WordMap
     */

    public int size() {
        return size;
    }

    /**
     * Returns all the keys (words) of this WordMap using their
     * natural order.
     *
     * @return all the keys (words)
     */

    public String[] keys() {

        Elem current = root;
        String[] keys = buildKeyArray(new String[size], current);

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

    private String[] buildKeyArray(String[] keys, Elem current)
    {
        if (current != null)
        {
            keys = appendItemToArray(keys, current.key);

            buildKeyArray(keys, current.left);
            buildKeyArray(keys, current.right);
        }

        return keys;
    }

    private String[] appendItemToArray(String[] array, String item)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == null)
            {
                array[i] = item;
                break;
            }
        }
        return array;
    }

    /**
     * Returns all the counts associated with keys in this
     * WordMap. The counts are in the same order as that of the keys
     * returned by the method keys().
     *
     * @return all the counts
     */

    public Integer[] counts()
    {
        String[] keys = keys();
        Integer[] values = new Integer[keys.length];

        for (int i = 0; i < values.length; i++)
        {
            values[i] = get(keys[i]);
        }

        return values;
    }

}
