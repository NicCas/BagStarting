public class ArrayBag <T> implements BagInterface <T> {

    public static final int DEFAULT_SIZE = 50;
    public static final int MAX_SIZE = 10000;
    private T[] store;
    private int qtyOfItems = 0;
    private int current_size;

    public ArrayBag()
    {
        this(DEFAULT_SIZE);
    }

    public ArrayBag(int currentSize)
    {
        this.current_size = currentSize;
        store = (T[]) new Object[this.current_size];
    }

    /** Gets the current number of entries in this bag.
     * @return  The integer number of entries currently in the bag.
     */
    public int getCurrentSize ()
    {
        return qtyOfItems;
    }

    /** Sees whether this bag is empty.
     * @return  True if the bag is empty, or false if not.
     */
    public boolean isEmpty()
    {
        return qtyOfItems == 0;
    }

    /** Adds a new entry to this bag.
     * @param newEntry  The object to be added as a new entry.
     * @return  True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry)
    {
        if(qtyOfItems == MAX_SIZE)
        {
            return false;
        }

        if(qtyOfItems == current_size)
        {
            resizeStorage();
        }

        store[qtyOfItems++] = newEntry; // This (the ++) is a post incrementation

        return false;
    }

    private void resizeStorage()
    {
        // Java likes to double a data structure every time it is resized since it is an expensive process
        current_size *= 2;

        // Check that current_size is not > than MAX_SIZE by using Math.min() which outputs the smaller int
        current_size = Math.min(current_size, MAX_SIZE);

        T[] newStore = (T[]) new Object[current_size];
        for (int i = 0; i < qtyOfItems; i++)
        {
            newStore[i] = store[i];
        }
        store = newStore;
    }

    /** Removes one unspecified entry from this bag, if possible.
     * @return  Either the removed entry, if the removal was successful, or null.
     */
    public T remove()
    {
        if(qtyOfItems == 0)
        {
            return null;
        }

        T returnItem = store[qtyOfItems - 1]; // Because array
        store[--qtyOfItems] = null; // Decrement qtyOfItems before set element to null
        return returnItem;

    }

    /** Removes one occurrence of a given entry from this bag.
     * @param anEntry  The entry to be removed.
     * @return  True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry)
    {
        for (int i = 0; i < qtyOfItems; i++)
        {
            if (anEntry.equals(store[i]))
            {
                removeItem(i);
                return true;
            }
        }
        return false;
    }

    /** Store last item then set to null
     *
     * @param i
     */
    private void removeItem(int i)
    {
        store[i] = store[qtyOfItems - 1];
        store[qtyOfItems - 1] = null;
        qtyOfItems--;
    }

    /** Removes all entries from this bag. */
    public void clear()
    {
        for (int i = 0; i < qtyOfItems; i++) {
            store[i] = null;
        }
        qtyOfItems = 0;
    }

    /** Counts the number of times a given entry appears in this bag.
     * @param anEntry  The entry to be counted.
     * @return  The number of times anEntry appears in the bag.
     */
    public int getFrequencyOf(T anEntry)
    {
        /* This is the in class code */
        int counter = 0;
        for (int i = 0; i < qtyOfItems; i++)
        {
            if(anEntry.equals(store[i]))
            {
                counter++;
            }
        }
        return counter;

        /*
         * This was my code
         *
        int frequency = 0; // Is this the best place to put it? Would it be better to initialize this as a global variable?
        for (int i = 0; i < qtyOfItems; i++)
        {
            if (store[i] == anEntry)
            {
                frequency++;
            }
        }
        return frequency;

         */
    }

    /** Tests whether this bag contains a given entry.
     * @param anEntry  The entry to locate.
     * @return  True if the bag contains anEntry, or false if not.
     */
    public boolean contains(T anEntry)
    {
        /* This is the in class code */

        for (int i = 0; i < qtyOfItems; i++) {
            if(anEntry.equals(store[i]))
            {
                return true;
            }
        }
        return false;

        /*
         * This was my code

        for (int i = 0; i < qtyOfItems; i++)
        {
            if (store[i] == anEntry)
            {
                return true;
            }
        }
        return false;

         */
    }

    /** Retrieves all entries that are in this bag.
     * @return  A newly allocated array of all the entries in the bag.
     * Note: If the bag is empty, the returned array is empty.
     */
    public T[] toArray()
    {
        /* This is teh in class code */
        // This avoids return a reference to store[] as well as avoids returning any null elements

        T[] returnStore = (T[]) new Object[qtyOfItems];

        for (int i = 0; i < qtyOfItems; i++)
        {
            returnStore [i] = store[i];
        }

        return returnStore;
        /*
         * This was my code
         *
        T [] intBagArray = (T[]) new Object[this.currentSize];
        for (int i = 0; i < qtyOfItems; i++)
        {
            intBagArray[i] = store[i];
        }
        return intBagArray;
         */
    }

    @Override
    public String toString()
    {
        String output = "[";
        String comma = "";
        for (int i = 0; i < qtyOfItems; i++)
        {
            output += comma + store[i];
            comma = " , ";
        }

        return output + "]";
    }
}
