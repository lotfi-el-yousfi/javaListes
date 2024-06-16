import java.util.*;

public class ArrayListEx1 {
    static Random r = new Random();
    static ArrayList<Integer> list = new ArrayList<Integer>();
    /*
     * Exercise: Write a Java program to create an ArrayList of integers, add elements to it,
     * and print out the list.
     * Ensure you practice adding elements using both the add() method and the addAll()
     * method to add elements from another collection.
     */

    /*
      Iteration and Access:

    Exercise: Write a program to iterate through an ArrayList of strings using different approaches:
    Use a simple for-loop.
    Use an enhanced for-loop (for-each loop).
    Use an iterator to traverse and modify the list while iterating.
      */

    /*
    Searching and Index Operations:

Exercise: Implement a method to search for a specific element in
an ArrayList of objects (e.g., strings, integers).
Use the indexOf() method to find the index of the element.
Handle scenarios where the element may not be present in the list (check for -1 return value).

*/

    /*
    * Sorting and Manipulation:

Exercise: Write a program to sort an ArrayList of integers in ascending order.
Use the Collections.sort() method to sort the list.
Experiment with custom comparators for sorting objects based on different
* criteria (e.g., alphabetical order for strings).

* */
    public static void main(String[] args) {
        addElementToList();
//        AccessElementList();
        findInList();

//        Collections.sort(list);
        sortingList();
        removeLast();
    }

    private static Integer removeLast() {
        return list.remove(list.size() - 1);
    }

    private static void sortingList() {
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }

    private static void findInList() {
        if (list.indexOf(1) > -1) System.out.println("there is a 5 in the list ");
    }

    private static void AccessElementList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.set(i, 1));
        }
        for (int element : list) {
            System.out.println(element);

        }
    }

    private static void addElementToList() {

        list.add(r.nextInt(20, 300));
        list.add(r.nextInt(20, 300));
        list.add(r.nextInt(20, 300));
        list.add(r.nextInt(20, 300));
        list.add(r.nextInt(20, 300));
        list.add(r.nextInt(20, 300));
        list.add(r.nextInt(20, 300));
        list.add(r.nextInt(20, 300));
        list.add(r.nextInt(20, 300));
        list.add(r.nextInt(20, 300));
        list.add(r.nextInt(20, 300));
        list.add(r.nextInt(20, 300));
        list.add(r.nextInt(20, 300));
        System.out.println(list);
    }
}
