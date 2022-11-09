public class ST<Key extends Comparable <Key>, Value> {
    private Node root;

    public ST()
    {

    }

    public void put(Value v, Key k)
    {
        root = put(root, v, k);
    }

    private Node put(Node n, Value v, Key k)
    {
        if (n == null)
            return new Node(v, k);
        int cmp = k.compareTo(n.key);
        if (cmp < 0)
            n.left = put(n.left, v, k);
        else if (cmp > 0)
            n.right = put(n.right, v, k);
        else
            n.value = v;
        return root;
    }

    public Value get(Key k)
    {
        return get(root, k);
    }

    private Value get(Node n, Key k)
    {
        if (n == null)
            return null;
        int cmp = k.compareTo(n.key);
        if (cmp < 0)
            return get(n.left, k);
        else if (cmp > 0)
            return get(n.right, k);
        return n.value;
    }

    public Key min()
    {
        Key k = root.key;
        Node n = root;
        while (n != null)
        {
            k = n.key;
            n = n.left;
        }
        return k;
    }

    public Key max()
    {
        Key k = root.key;
        Node n = root;
        while (n != null)
        {
            k = n.key;
            n = n.right;
        }
        return k;
    }

    public Key ceiling(Key k)
    {
        Node n = ceiling(root, k);
        if (n == null)
            return null;
        return n.key;
    }

    private Node ceiling(Node n, Key k)
    {
        if (n == null) 
            return null;
        int cmp = k.compareTo(x.key);
        if (cmp == 0) 
            return n;
        if (cmp < 0) 
            return ceiling(n.left, k);
        Node x = ceiling(n.right, k);  // not finished
        if (x != null) 
            return x;
        return n.right;
    }

    public Key floor(Key k)
    {
        Node n = floor(root, k);
        if (n == null)
            return null;
        return n.key;
    }

    private Node floor(Node n, Key k)
    {
        if (n==null) 
            return null;
        int cmp = k.compareTo(x.key);
        if (cmp==0) 
            return n;
        if (cmp < 0) 
            return floor(n.left, k);
        Node x = floor(n.right, k); 
        if (x != null) 
            return x;
        return n;
    }

    public int size()
    {
        return size(root);
    }

    private Node size(Node n)
    {
        
    }

    public Key select(int i)
    {
        return select(root, i);
    }

    private Node select(Node n, int i)
    {
        if (n == null) 
            return null;
        int s = size(n.left);
        if (s > i) 
            return select(n.left, i);
        if (s < i) 
            return select(n.right, (i-s-1));
        if (s == i)
            return n;
    }

    public class Node {
        public Key key;
        public Value value;
        public Node left;
        public Node right;
    
        public Node(Value v, Key k)
        {
            key = k;
            value = v;
        }
    }
    
}
