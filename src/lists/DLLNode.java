package lists;

import java.util.List;
import java.util.NoSuchElementException;

public class DLLNode {

    private ListNode head;
    private ListNode tail;
    private int length;

    public static void main(String[] args) {
        DLLNode DLL = new DLLNode();

        DLL.appendNode(1);
        DLL.appendNode(10);
        DLL.appendNode(23);
        DLL.prependNode(54);
        DLL.insertAfter(54, 521);

        if (DLL.findNode(21)!= null)
            System.out.println("Found");
        else
            System.out.println("No Found");


        DLL.deleteNode(10);


        System.out.println(DLL.toString());
        System.out.println(DLL.toStringReverse());


    }

    private class ListNode {
        private int data;
        private ListNode next;
        private ListNode prev;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public DLLNode() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void insertAfter(int src, int data)
    {
        ListNode src_node = this.findNode(src);
        if (src_node == null)
        {
            this.appendNode(data);
            return;
        }

        ListNode new_node = new ListNode(data);

        new_node.next = src_node.next;
        src_node.next = new_node;

        new_node.prev = src_node.prev;
        src_node.prev = new_node;
    }

    public String toString() {

        String str = new String();

        if(head == null) {
            return str;
        }

        ListNode temp = head;
        while(temp != null) {
            str += temp.data + " --> ";
            temp = temp.next;
        }
        return str;
    }

    public String toStringReverse() {

        String str = new String();

        if(tail == null) {
            return str;
        }

        ListNode temp = tail;
        while (temp != null) {
            str += temp.data + " <-- ";
            temp = temp.prev;
        }
        return str;
    }

    public void prependNode(int value) {
        ListNode newNode = new ListNode(value);
        if(isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void appendNode(int value) {
        ListNode newNode = new ListNode(value);
        if(isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.prev = tail;
        tail = newNode;
        length++;
    }


    public ListNode findNode(int data) {

        if(head == null) {
            return null;
        }

        ListNode temp = head;
        while(temp != null) {
            if (data == temp.data)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public ListNode deleteNode(int data) {

        ListNode del = this.findNode(data);

        if (head == null || del == null) {
            return del;
        }

        if (head == del) {
            head = del.next;
        }

        if (del.next != null) {
            del.next.prev = del.prev;
        }

        if (del.prev != null) {
            del.prev.next = del.next;
        }

        return del;

    }
}
