import java.util.*;

class ArrayListDemo {

    void demo() {

        ArrayList<String> list = new ArrayList<>();

        // Add
        list.add("Java");
        list.add("Python");

        // Insert
        list.add(1, "C++");

        // Read
        System.out.println(list.get(0));

        // Update
        list.set(0, "Spring Boot");

        // Search
        System.out.println(list.contains("Python"));
        System.out.println(list.indexOf("Python"));

        // Size
        System.out.println(list.size());

        // Remove
        list.remove("Python");
        list.remove(0);

        // Iterate
        for (String s : list) {
            System.out.println(s);
        }

        // Clear
        list.clear();

        System.out.println(list.isEmpty());
    }
}

class HashSetDemo {

    void demo() {

        HashSet<String> set = new HashSet<>();

        set.add("Java");
        set.add("Python");
        set.add("Java"); // Duplicate ignored

        System.out.println(set.contains("Java"));

        for (String s : set) {
            System.out.println(s);
        }

        set.remove("Python");

        System.out.println(set.size());

        set.clear();
    }
}

class HashMapDemo {

    void demo() {

        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "Java");
        map.put(2, "Python");

        System.out.println(map.get(1));

        map.replace(1, "Spring");

        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("Python"));

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        map.remove(2);

        System.out.println(map.size());

        map.clear();
    }
}

class StringBuilderDemo {

    void demo() {

        StringBuilder sb = new StringBuilder("Java");

        // append()
        sb.append(" Spring");
        System.out.println("append() : " + sb);

        // insert()
        sb.insert(4, " Core");
        System.out.println("insert() : " + sb);

        // replace()
        sb.replace(0, 4, "Advanced");
        System.out.println("replace() : " + sb);

        // delete()
        sb.delete(8, 13);
        System.out.println("delete() : " + sb);

        // deleteCharAt()
        sb.deleteCharAt(0);
        System.out.println("deleteCharAt() : " + sb);

        // charAt()
        System.out.println("charAt(0) : " + sb.charAt(0));

        // setCharAt()
        sb.setCharAt(0, 'X');
        System.out.println("setCharAt() : " + sb);

        // length()
        System.out.println("length() : " + sb.length());

        // capacity()
        System.out.println("capacity() : " + sb.capacity());

        // ensureCapacity()
        sb.ensureCapacity(100);
        System.out.println("ensureCapacity() : " + sb.capacity());

        // substring()
        System.out.println("substring(0, 5) : " + sb.substring(0, 5));

        // indexOf()
        System.out.println("indexOf(\"Spring\") : " + sb.indexOf("Spring"));

        // lastIndexOf()
        System.out.println("lastIndexOf(\"Spring\") : " + sb.lastIndexOf("Spring"));

        // reverse()
        sb.reverse();
        System.out.println("reverse() : " + sb);

        // toString()
        String str = sb.toString();
        System.out.println("toString() : " + str);

        // isEmpty() (Java 11+)
        System.out.println("isEmpty() : " + sb.isEmpty());
    }
}

class PriorityQueueDemo {

    void demo() {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(50);
        pq.offer(10);
        pq.offer(30);

        System.out.println(pq.peek());

        System.out.println(pq.poll());

        System.out.println(pq.size());
    }
}

public class CollectionClasses {

    public static void main(String[] args) {

        new ArrayListDemo().demo();

        new HashSetDemo().demo();

        new HashMapDemo().demo();

        new StringBuilderDemo().demo();

        new PriorityQueueDemo().demo();
    }
}

// ================= ArrayList =================

// add() -> Adds an element at the end of the list.
// add(index, value) -> Inserts an element at a specific index.
// get(index) -> Returns the element at the specified index.
// set(index, value) -> Replaces the element at the specified index.
// remove(index/value) -> Removes an element by index or value.
// contains(value) -> Checks if the element exists in the list.
// indexOf(value) -> Returns the first index of the element.
// size() -> Returns the number of elements.
// isEmpty() -> Checks whether the list is empty.
// clear() -> Removes all elements from the list.

// ================= HashSet =================

// add() -> Adds an element if it does not already exist.
// remove() -> Removes the specified element.
// contains() -> Checks if the element exists in the set.
// size() -> Returns the number of elements.
// isEmpty() -> Checks whether the set is empty.
// clear() -> Removes all elements from the set.

// ================= HashMap =================

// put(key, value) -> Adds or updates a key-value pair.
// get(key) -> Returns the value associated with the key.
// remove(key) -> Removes the key-value pair.
// replace(key, value) -> Replaces the value of an existing key.
// containsKey(key) -> Checks whether the key exists.
// containsValue(val) -> Checks whether the value exists.
// keySet() -> Returns all keys as a Set.
// values() -> Returns all values as a Collection.
// entrySet() -> Returns all key-value pairs as a Set.
// size() -> Returns the number of key-value pairs.
// clear() -> Removes all entries from the map.

// ================= Queue / PriorityQueue =================

// offer() -> Inserts an element into the queue.
// poll() -> Removes and returns the front element.
// peek() -> Returns the front element without removing it.
// size() -> Returns the number of elements in the queue.
// isEmpty() -> Checks whether the queue is empty.

// ================= StringBuilder =================

// append(value) -> Adds the given value at the end.
// insert(index, value) -> Inserts the value at the specified index.
// replace(start, end, str) -> Replaces characters between start and end
// indexes.
// delete(start, end) -> Removes characters between start and end indexes.
// deleteCharAt(index) -> Removes the character at the specified index.
// reverse() -> Reverses the entire string.
// charAt(index) -> Returns the character at the specified index.
// setCharAt(index, ch) -> Replaces the character at the specified index.
// length() -> Returns the current length.
// capacity() -> Returns the current capacity.
// ensureCapacity(size) -> Increases capacity if needed.
// substring(start) -> Returns substring from start index.
// substring(start, end) -> Returns substring from start to end-1.
// indexOf(str) -> Returns first occurrence index.
// lastIndexOf(str) -> Returns last occurrence index.
// toString() -> Converts StringBuilder to String.
// isEmpty() -> Checks whether length is 0 (Java 11+).
// compareTo(sb) -> Compares two StringBuilder objects (Java 11+).