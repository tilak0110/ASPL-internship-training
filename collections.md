# Java Collections Guide (Detailed)

## **Introduction**
The Java Collections Framework (JCF) is a unified architecture for representing and manipulating collections. It includes interfaces and their implementations to store and process data efficiently.

---

# **1. Hierarchy of Java Collections Framework**

### **1.1 Collection Hierarchy**
```
java.util.Collection (Interface)
│
├── List (Interface) — Ordered, allows duplicates
│   ├── ArrayList
│   ├── LinkedList
│   ├── Vector
│   │   ├── Stack
│
├── Set (Interface) — Unordered, unique elements
│   ├── HashSet
│   ├── LinkedHashSet
│   ├── TreeSet
│   ├── EnumSet
│   ├── CopyOnWriteArraySet
│
├── Queue (Interface) — FIFO, elements are processed in order
│   ├── PriorityQueue
│   ├── ArrayDeque
│   ├── LinkedList (also implements Queue)
│
├── Deque (Interface) — Double-ended queue
│   ├── ArrayDeque
│   ├── LinkedList (also implements Deque)
│
├── BlockingQueue (Interface) — Thread-safe queues
│   ├── ArrayBlockingQueue
│   ├── LinkedBlockingQueue
│   ├── PriorityBlockingQueue
│   ├── DelayQueue
│   ├── SynchronousQueue
│   ├── LinkedTransferQueue
```

### **1.2 Map Hierarchy**
```
java.util.Map (Interface) — Stores key-value pairs
│
├── HashMap
│   ├── LinkedHashMap
│   ├── IdentityHashMap
│
├── TreeMap
├── WeakHashMap
├── ConcurrentHashMap
├── Hashtable
```

---

# **2. List Implementations & Methods**
## **2.1 List (Interface)**
- `add(E e)`, `add(int index, E e)`
- `get(int index)`
- `set(int index, E e)`
- `remove(int index)`, `remove(Object o)`
- `indexOf(Object o)`, `lastIndexOf(Object o)`
- `size()`
- `contains(Object o)`
- `toArray()`
- `iterator()`, `listIterator()`

## **2.2 ArrayList**
- Implements `List`, resizable array, fast access.
- Default capacity: `10`, grows dynamically.

## **2.3 LinkedList**
- Implements `List`, `Deque`, and `Queue`.
- Supports `addFirst()`, `addLast()`, `removeFirst()`, `removeLast()`.

## **2.4 Vector**
- Thread-safe, synchronized version of `ArrayList`.

## **2.5 Stack**
- LIFO structure, uses `push()`, `pop()`, `peek()`.

---

# **3. Set Implementations & Methods**
## **3.1 Set (Interface)**
- `add(E e)`, `remove(Object o)`, `size()`, `contains(Object o)`
- `toArray()`, `iterator()`

## **3.2 HashSet**
- Uses a hash table for storage, unordered, allows `null` values.

## **3.3 LinkedHashSet**
- Maintains insertion order, extends `HashSet`.

## **3.4 TreeSet**
- Implements `NavigableSet`, stores elements in sorted order.

## **3.5 EnumSet**
- Optimized set for `enum` types.

## **3.6 CopyOnWriteArraySet**
- Thread-safe variant of `Set`, based on `CopyOnWriteArrayList`.

---

# **4. Queue & Deque Implementations & Methods**
## **4.1 Queue (Interface)**
- `offer(E e)`, `poll()`, `peek()`, `remove()`

## **4.2 PriorityQueue**
- Elements are ordered based on natural ordering or a comparator.

## **4.3 BlockingQueue**
- Thread-safe queues:
  - `ArrayBlockingQueue`, `LinkedBlockingQueue`, `PriorityBlockingQueue`, `DelayQueue`, `SynchronousQueue`, `LinkedTransferQueue`

## **4.4 Deque (Double-Ended Queue)**
- `ArrayDeque`, `LinkedList` (as Deque)
- Supports `addFirst()`, `addLast()`, `removeFirst()`, `removeLast()`.

---

# **5. Map Implementations & Methods**
## **5.1 Map (Interface)**
- `put(K key, V value)`, `get(K key)`, `remove(K key)`, `size()`
- `containsKey(K key)`, `containsValue(V value)`
- `keySet()`, `values()`, `entrySet()`

## **5.2 HashMap**
- Stores key-value pairs, no ordering.

## **5.3 LinkedHashMap**
- Maintains insertion order.

## **5.4 TreeMap**
- Implements `SortedMap`, maintains sorted order.

## **5.5 IdentityHashMap**
- Uses `==` instead of `.equals()` for key comparison.

## **5.6 WeakHashMap**
- Uses weak references for keys (eligible for GC if no strong reference exists).

## **5.7 ConcurrentHashMap**
- Thread-safe implementation of `Map`.

## **5.8 Hashtable**
- Legacy thread-safe `Map`, slower than `ConcurrentHashMap`.

---

# **6. Summary Table**
| Collection Type | Implementation | Ordering | Duplicate Allowed | Thread Safe |
|---------------|----------------|----------|-------------------|-------------|
| List | ArrayList | Insertion Order | Yes | No |
| List | LinkedList | Insertion Order | Yes | No |
| List | Vector | Insertion Order | Yes | Yes |
| List | Stack | LIFO Order | Yes | No |
| Set | HashSet | No Order | No | No |
| Set | TreeSet | Sorted Order | No | No |
| Set | LinkedHashSet | Insertion Order | No | No |
| Set | EnumSet | Enum Order | No | No |
| Queue | PriorityQueue | Natural Order | Yes | No |
| Queue | ArrayDeque | Insertion Order | Yes | No |
| Queue | BlockingQueue | Varies | Yes | Yes |
| Deque | LinkedList | Insertion Order | Yes | No |
| Map | HashMap | No Order | No (Keys Unique) | No |
| Map | TreeMap | Sorted Order | No (Keys Unique) | No |
| Map | LinkedHashMap | Insertion Order | No (Keys Unique) | No |
| Map | IdentityHashMap | No Order | No (Keys Unique) | No |
| Map | WeakHashMap | No Order | No (Keys Unique) | No |
| Map | ConcurrentHashMap | No Order | No (Keys Unique) | Yes |

---

# **Conclusion**
This guide provides a detailed breakdown of Java Collections. Understanding the characteristics of each implementation allows efficient data manipulation based on use cases.

- Use **ArrayList** for random access.
- Use **LinkedList** for frequent insertions/deletions.
- Use **HashSet** for unique unordered elements.
- Use **TreeMap** if key sorting is required.
- Use **ConcurrentHashMap** for thread-safe `Map`.


