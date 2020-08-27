package lists;

public class LLNode {

    Node head, tail;

    public static void main (String[] args) {

        LLNode LL = new LLNode();

        LL.append("Hi");
        LL.append("this");
        LL.append("is");
        LL.append("a");
        LL.prepend("YO");
        LL.append("linked list");
        LL.insertAfter("a", "awesome");
        LL.delete("hello");

        System.out.println(LL.toString());
    }

    public static class Node {
        public Object data;
        public Node next;

        public Node(Object data)
        {
            this.data = data;
        }
        public Object getData()
        {
            return data;
        }
        public void setData(Object data)
        {
            this.data = data;
        }
        public Node getNext() {
            return next;
        }
    }
    public String toString()
    {
        Node focus_node = this.head;
        String str = "Linked List: ";

        while (focus_node != null) {
            str += focus_node.data.toString();
            if (focus_node != null)
                str += "->";

            focus_node = focus_node.next;
        }
        return str;
    }
    public void append(Object data) {
        Node new_node = new Node(data);

        if (this.head == null || this.tail == null)
            this.head = new_node;
        else
            this.tail.next = new_node;
        this.tail = new_node;
    }
    public void prepend(Object data)
    {
        Node new_node = new Node(data);

        if (this.head == null || this.tail == null)
            this.tail = new_node;
        else
            new_node.next = this.head;
        this.head = new_node;
    }
    public Node find(Object data)
    {
        Node focus_node = this.head;

        while (focus_node != null)
        {
            if (focus_node.data == data)
                return focus_node;

            focus_node = focus_node.next;
        }
        return null;
    }
    public void insertAfter(Object src, Object data)
    {
        Node src_node = this.find(src);
        if (src_node == null)
        {
            this.append(data);
            return;
        }

        Node new_node = new Node(data);

        new_node.next = src_node.next;
        src_node.next = new_node;
    }
    public void delete(Object data)
    {
        Node node = this.find(data);
        if (node == null)
            return;

        if (node == this.head)
            this.head = node.next;

        if (node == this.tail)
            this.tail = null;

        Node focus_node = this.head;
        Node prev_node = null;

        while (focus_node != null) {
            if (focus_node == node)
                prev_node.next = node.next;

            prev_node = focus_node;
            focus_node = focus_node.next;
        }
    }
}
