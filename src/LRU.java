


import java.util.HashMap;

public class LRU {
    int capacity;
    HashMap < Integer, Node > map = new HashMap < Integer, Node > ();
    Node head = null;
    Node end = null;

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Get Node by key
     * @param key the key
     * @return the Node
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.getValue();
        }

        return -1;
    }

    /**
     * Remove node
     * @param n the node to remove
     */

    public void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }

    }

    /**
     * Set head of the hashmap
     * @param n the node
     */
    public void setHead(Node n) {
        n.next = head;
        n.pre = null;

        if (head != null)
            head.pre = n;

        head = n;

        if (end == null)
            end = head;
    }

    /**
     * Add item (or set, by the way) on de Hashmap
     * @param key the key of Node
     * @param value the vlue of Node
     */
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.setValue(value);
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.getKey());
                remove(end);
                setHead(created);

            } else {
                setHead(created);
            }
            map.put(key, created);
        }
    }
}