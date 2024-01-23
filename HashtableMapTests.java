// --== CS400 Project One File Header ==--
// Name: Akshay Gona
// CSL Username: gona
// Email: gona@wisc.edu
// Lecture #: Lecture 002, (1pm -2:15pm Tuesday Thursday)
// Notes to Grader: -none-
public class HashtableMapTests {

    //test 1: test constructor and getCapacity method and getSize method

    /**
     * This method tests the constructor and getCapacity method and getSize method
     *
     * @return true if the tests pass, false otherwise
     */
    public static boolean test1() {
        //initialize a hashtableMap with default capacity
        HashtableMap hashtableMap = new HashtableMap<>();
        //initialize a hashtableMap with capacity 5
        HashtableMap hashtableMap1 = new HashtableMap<>(5);
        //check if the capacity is 8, which is the default capacity
        if (hashtableMap.getCapacity() != 8) {
            return false;
        }
        //check if the capacity is 5
        if (hashtableMap1.getCapacity() != 5) {
            return false;
        }
        //check if the size is 0 for both hashtableMap and hashtableMap1
        if (hashtableMap.getSize() != 0) {
            return false;
        }
        return hashtableMap1.getSize() == 0;
        //if all the tests pass, return true
    }

    //test 2: test put method and containsKey method

    /**
     * This method tests the put method and containsKey method
     *
     * @return true if the tests pass, false otherwise
     */
    public static boolean test2() {
        HashtableMap hashtableMap = new HashtableMap<>();
        //put a key-value pair into the hashtableMap
        hashtableMap.put("a", 1);
        //check if the key-value pair is in the hashtableMap
        if (!hashtableMap.containsKey("a")) {
            return false;
        }
        //check if the value is 1
        if ((int) hashtableMap.get("a") != 1) {
            return false;
        }
        //check if the size is 1
        if (hashtableMap.getSize() != 1) {
            return false;
        }
        //check if the capacity is unchanged
        if (hashtableMap.getCapacity() != 8) {
            return false;
        }
        //put another key-value pair into the hashtableMap
        hashtableMap.put("b", 2);
        //check if the key-value pair is in the hashtableMap
        if (!hashtableMap.containsKey("b")) {
            return false;
        }
        //check if the value is 2
        if ((int) hashtableMap.get("b") != 2) {
            return false;
        }
        //check if the size is 2
        if (hashtableMap.getSize() != 2) {
            return false;
        }
        //check if the capacity is still 8
        return hashtableMap.getCapacity() == 8;
        //if all the tests pass, return true
    }

    //test 3: test remove method

    /**
     * This method tests the remove method
     *
     * @return true if the tests pass, false otherwise
     */
    public static boolean test3() {
        {
            HashtableMap hashtableMap = new HashtableMap<>();
            //put a key-value pair into the hashtableMap
            hashtableMap.put("a", 1);
            hashtableMap.put("b", 2);
            hashtableMap.put("c", 3);
            //remove the key-value pair
            hashtableMap.remove("b");
            //check if the key-value pair is removed
            if (hashtableMap.containsKey("b")) {
                return false;
            }
            if (!hashtableMap.containsKey("c")) {
                return false;
            }
            //check if the size is 0
            if (hashtableMap.getSize() != 2) {
                return false;
            }
            //check if the capacity is unchanged
            if(hashtableMap.getCapacity() != 8){
                return false;
            }
            //if all the tests pass, return true
            //return true;
        }

        {
            HashtableMap hashtableMap = new HashtableMap<>();
            //put a key-value pair into the hashtableMap
            hashtableMap.put(5, 1);
            hashtableMap.put(13, 2);
            hashtableMap.put(21, 3);
            //remove the key-value pair
            hashtableMap.remove(13);
            //check if the key-value pair is removed
            if (hashtableMap.containsKey(13)) {
                return false;
            }
            if(!hashtableMap.get(21).equals(3)){
                System.out.println("hello");
                return false;
            }
            //check if the size is 0
            if (hashtableMap.getSize() != 2) {
                return false;
            }
            //check if the capacity is unchanged
            if(hashtableMap.getCapacity() != 8){
                return false;
            }
            //if all the tests pass, return true
            //return true;
        }
        return true;
    }

    //test 4: test clear method

    /**
     * This method tests the clear method
     *
     * @return true if the tests pass, false otherwise
     */
    public static boolean test4() {
        HashtableMap hashtableMap = new HashtableMap<>();
        //put a key-value pair into the hashtableMap
        hashtableMap.put("a", 1);
        //clear the hashtableMap
        hashtableMap.clear();
        //check if the size is 0
        if (hashtableMap.getSize() != 0) {
            return false;
        }
        //check if the capacity is unchanged
        return hashtableMap.getCapacity() == 8;
        //if all the tests pass, return true
    }

    //test 5: test get method

    /**
     * This method tests the get method
     *
     * @return true if the tests pass, false otherwise
     */
    public static boolean test5() {
        HashtableMap hashtableMap = new HashtableMap<>();
        //put a key-value pair into the hashtableMap
        hashtableMap.put("a", 1);
        //check if the value is 1
        if ((int) hashtableMap.get("a") != 1) {
            return false;
        }
        //check if the size is unchanged
        if (hashtableMap.getSize() != 1) {
            return false;
        }
        //check if the capacity is unchanged
        return hashtableMap.getCapacity() == 8;
        //if all the tests pass, return true
    }

    /**
     * This method runs all the tests
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(test1());
        System.out.println(test2());
        System.out.println(test3());
        System.out.println(test4());
        System.out.println(test5());
    }
}
