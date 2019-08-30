import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BagInterface<Integer> bag = new ArrayBag<>();

        /*
         * This is the code created in class
         */
        System.out.println(bag.getCurrentSize());

        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        bag.add(5);
        System.out.println(bag.getCurrentSize());
        System.out.println(bag);

        bag.remove(5);
        System.out.println("The current size of the bag is: " + bag.getCurrentSize());

        Object[] tmp = bag.toArray();
        System.out.println(Arrays.toString(tmp));

        /*
         * This was my code
         *
        // Check that bag is empty
        System.out.println("The current size of the bag is: " + bag.getCurrentSize());
        System.out.println("The bag is empty: " + bag.isEmpty());

        // Check add()
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        bag.add(5);
        System.out.println("The bag is empty: " + bag.isEmpty());
        System.out.println("The current size of the bag is: " + bag.getCurrentSize());

        // Check remove() [a specific item]
        bag.remove(3);
        System.out.println("The current size of the bag is: " + bag.getCurrentSize());

        // Check remove() [an item]
        bag.remove();
        System.out.println("The current size of the bag is: " + bag.getCurrentSize());

        // Check getFrequencyOf()
        bag.add(6);
        bag.add(6);
        System.out.println("There is/are " + bag.getFrequencyOf(1) + " instance(s) of 1");
        System.out.println("There is/are " + bag.getFrequencyOf(6) + " instance(s) of 6");

        // Check contains()
        System.out.println("Contains the number 4: " + bag.contains(4));
        System.out.println("Contains the number 3: " + bag.contains(3));

        // Check toArray()
        // This isn't cooperating. How do I set an array type T to an array type int
        Integer[] bagArray = bag.toArray();
        System.out.println("The current array is: ");
        for (int i = 0; i < bagArray.length; i++)
        {
            System.out.println(bagArray [i] + " , " );
        }

        // Check clear()
        bag.clear();
        System.out.println("The current size of the bag is: " + bag.getCurrentSize());
        */



    }
}
