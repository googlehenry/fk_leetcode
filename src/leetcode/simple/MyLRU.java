package leetcode.simple;

import javax.sql.rowset.CachedRowSet;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyLRU<K,V> {

    public static void main(String[] args) throws InterruptedException {
        MyLRU<Integer,Integer> cache = new MyLRU(5);
        for(int i=0;i<10;i++){
            cache.put(i,i);
        }
        cache.put(8,8);
        //cache should have keys: 5-9
        cache.printLinkedList();
    }

    /**
     * 手写LRU
     * @param s
     * @return
     */

    public Map<K,Node<K,V>> nodes = new ConcurrentHashMap<>();
    public LinkedList<Node<K,V>> nodesList = new LinkedList<>();
    private int size = 5;

    public MyLRU(int size){
        this.size = size;
    }

    public synchronized Collection<K> keys(){
        return nodes.keySet();
    }

    public void printLinkedList(){
        nodesList.stream().forEach((it)->System.out.println(it.key));
    }

    public synchronized void put(K key, V val){
        Node<K,V> newNode = new Node<>(key,val);

        Node<K,V> existing = nodes.get(key);
        //existing
        if(existing!=null){
            //delete
            //add head
            nodesList.remove(existing);
            nodes.remove(key);

            nodesList.addFirst(newNode);
            nodes.put(key,newNode);
            return;
        }

        //check capacity
        if(nodes.size()==size){
            //full,replace
            //remove tail
            //add head
            Node<K,V> last = nodesList.removeLast();
            nodes.remove(last.key);

            nodesList.addFirst(newNode);
            nodes.put(key,newNode);
            return;
        }

        //not full
        //add head
        nodesList.addFirst(newNode);
        nodes.put(key,newNode);
    }

    public synchronized V get(K key){
        Node<K,V> existingNode = nodes.get(key);
        if(existingNode==null){
            return null;
        }
        //update position to head
        //delete existing
        //add head
        nodesList.remove(existingNode);
        nodesList.addFirst(existingNode);
        return existingNode.val;
    }

    public synchronized void delete(K key){
        Node<K,V> existingNode = nodes.get(key);
        if(existingNode==null){
            return;
        }
        nodesList.remove(existingNode);
        nodes.remove(key);
    }


    public static class Node<K,V>{
        K key;
        V val;
        public Node(K key,V val){
            this.key = key;
            this.val = val;
        }
    }




}
