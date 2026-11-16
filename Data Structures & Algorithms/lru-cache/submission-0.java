class Node {
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private int capacity = 0;
    private final Map<Integer, Node> cache;
    private Node head, tail; // Dummy boundary nodes

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;

        // intialize dummy head and tail
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToHead(node); // Mark as most recently used
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node existingNode = cache.get(key);
            existingNode.value = value;
            moveToHead(existingNode);            
        } else {
            if (cache.size() == capacity) {
                Node lru = tail.prev; // remove node right before tail i.e. least recently used
                removeNode(lru);
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
        }
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
}
