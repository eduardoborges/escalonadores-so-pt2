import java.util.Iterator;
import java.util.Map;

class TestLRU{
    public static void main(String args[]){

        LRU lru = new LRU(11);

        lru.set(1, 5);
        lru.set(2, 9);
        lru.set(3, 2);
        lru.set(6, 9);
        lru.set(5, 6);
        lru.set(5, 5);
        lru.set(7, 9);
        lru.set(5, 9);
        lru.set(4, 4);
        lru.set(5, 9);

        for (Map.Entry<Integer, Node> item : lru.map.entrySet()) {
            Node node = item.getValue();
            System.out.println( node.getKey() + " " + node.getValue() );           
        }
    }
}