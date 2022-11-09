public class Node<K, V> {
    public K key;
    public V value;
    public Node left;
    public Node right;

    public Node(Value v, Key k)
    {
        key = k;
        value = v;
    }
}
