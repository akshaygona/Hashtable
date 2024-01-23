// --== CS400 Project One File Header ==--
// Name: Akshay Gona
// CSL Username: gona
// Email: gona@wisc.edu
// Lecture #: Lecture 002, (1pm -2:15pm Tuesday Thursday)
// Notes to Grader: -none-
import java.util.NoSuchElementException;

/**
 * This abstract data type represents a collection that maps keys to values,
 *
 * @param <KeyType>   the type of the keys stored in this collection
 * @param <ValueType> the type of the values stored in this collection
 */
public class HashtableMap<KeyType, ValueType> implements MapADT {

    protected KeyValue<KeyType,ValueType>[] arr;
    //instance fields
    private int capacity;
    private int size;
    //delete key field
    private final KeyValue delete = new KeyValue<>(null, null);

    //Constructors

    /**
     * This method constructs a hashtableMap with the given capacity
     *
     * @param capacity the capacity of the hashtableMap
     */
    public HashtableMap(int capacity) {
        this.capacity = capacity;
        this.arr = new KeyValue[capacity];
        this.size = 0;
    }

    //default constructor
    public HashtableMap() {
        this(8);
    }

    @Override
    /**
     * This method returns the capacity of the hashtableMap
     * @return the capacity of the hashtableMap
     */ public void put(Object key, Object value) throws IllegalArgumentException {
        if (key == null || containsKey(key)) {
            throw new IllegalArgumentException(
                "Given key is null or duplicate of one already stored");
        }
        KeyType key1 = (KeyType) key;
        ValueType val1 = (ValueType) value;
        KeyValue kV = new KeyValue(key1, val1);

        int hash = key1.hashCode();
        hash = Math.abs(hash);
        hash = hash % capacity;

        int count = 0;
        while (arr[hash] != null && arr[hash] != delete) {
            hash++;
            hash = hash % capacity;
            count++;
            if (count == capacity) {
                return;
            }
        }
        arr[hash] = kV;
        size++;

        if (size >= 0.7 * capacity){
            reHash();
        }
    }

    @Override
    /**
     * This method returns the size of the hashtableMap
     * @return the size of the hashtableMap
     */ public boolean containsKey(Object key) {
        Integer index = findKeyIndex(key);
        return (index != null);
    }

    @Override
    /**
     * This method returns the value of the key in the hashtableMap
     * @return the value of the key in the hashtableMap
     */ public Object get(Object key) throws NoSuchElementException {
        Integer index = findKeyIndex(key);
        if (index == null) {
            throw new NoSuchElementException("No element with given key was found.bozo");
        }
        return arr[index].getValue();
    }

    @Override
    /**
     * This method removes the key and value from the hashtableMap
     * @return the value of the key in the hashtableMap
     */ public Object remove(Object key) throws NoSuchElementException {
        Integer index = findKeyIndex(key);
        if (index == null) {
            throw new NoSuchElementException("No element with given key was found.bozo");
        }
        ValueType temp = (ValueType) arr[index].getValue();
        arr[index] = delete;
        size--;
        return temp;
    }

    @Override
    /**
     * This method removes all the key and value from the hashtableMap
     */ public void clear() {
        arr = new KeyValue[capacity];
        size = 0;
    }

    @Override
    /**
     * This method returns the size of the hashtableMap
     * @return the size of the hashtableMap
     */ public int getSize() {
        return this.size;
    }

    @Override
    /**
     * This method returns the capacity of the hashtableMap
     * @return the capacity of the hashtableMap
     */ public int getCapacity() {
        return this.capacity;
    }

    //private helper methods
    /**
     * This method returns the index of the key in the hashtableMap
     * @return the index of the key in the hashtableMap
     */
    private Integer findKeyIndex(Object key) {
        KeyType key1 = (KeyType) key;
        int hash = key1.hashCode();
        hash = Math.abs(hash);
        hash = hash % capacity;

        int count = 0;
        while (arr[hash] != null) {
            if (!arr[hash].equals(delete) && arr[hash].getKey().equals(key1)) {
                return hash;
            }
            hash++;
            hash = hash % capacity;

            count++;
            if (count == capacity) {
                return null;
            }
        }
        return null;
    }
    /**
     * This method rehashes the hashtableMap
     */
    private void reHash() {
        size = 0;
        capacity = capacity * 2;
        KeyValue[] arr1 = arr.clone();
        arr = new KeyValue[capacity];
        for (KeyValue keyValue : arr1) {
            if (keyValue != null && keyValue != delete) {
                put(keyValue.getKey(), keyValue.getValue());
            }
        }
    }

    /**
     * This method returns the string representation of the hashtableMap
     * @return the string representation of the hashtableMap
     *
     * @param <KeyType>
     * @param <ValueType>
     */
    private class KeyValue<KeyType, ValueType> {

        private final KeyType key;
        private final ValueType value;

        private KeyValue(KeyType key, ValueType value) {
            this.key = key;
            this.value = value;
        }

        private KeyType getKey() {
            return this.key;
        }

        private ValueType getValue() {
            return this.value;
        }
    }
}
