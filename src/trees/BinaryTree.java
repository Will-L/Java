package trees;

/*import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(new Node(40, "NeHow"));
        tree.insert(new Node(30, "NHow"));
        tree.insert(new Node(50, "Neow"));

        Node[] nodes = new Node[] {
                new Node(48, "Jes");
                new Node(56, "Yo Jama");
                new Node(23,"Got Ya w");
        };

        BinaryTree tree = new BinaryTree(List.of(nodes));

        System.out.println("Pre-Order" + tree.traversePreOrder());
        System.out.println("In-Order" + tree.traverseInOrder());
        System.out.println("Post-Order" + tree.traversePostOrder());

        tree.find(30).data = "Got ya!";

        System.out.println(tree.traverseInOrder());
    }



    public static class Node {
        int key;
        Node left, right;
        Object data;

        public Node(int key, Object data) {
            this.key = key;
            this.data = data;
        }

        public String toString() {
            return Integer.toString(this.key) + " = " + data.toString();
        }
    }
    Node root;

    public BinaryTree() {}

    public BinaryTree(List<Node> nodes) {
        for (Node node : nodes) {
            this.insert(node);
        }
    }

    public Node find(int key) {
        return find(this.root, key);
    }

    private Node find(Node focusNode, int key) {
        if (focusNode.key == key) {
            return focusNode;
        } else if (key < focusNode.key) {
            return find(focusNode.left, key);
        } else if (key > focusNode.key) {
            return find (focusNode.right, key);
        } else {
            return null;
        }
    }

    public void insert(Node insertNode) {
        if (this.root == null) {
            this.root = insertNode;
        } else {
            insert(this.root, insertNode);
        }
    }

    private void insert(Node focusNode, Node insertNode) {
        if (insertNode.key < focusNode.key) {
            if (focusNode.left == null) {
                focusNode.left = insertNode;
            } else {
                insert(focusNode.left, insertNode);
            }
        } else if (insertNode.key > focusNode.key) {
            if (focusNode.right == null) {
                focusNode.right = insertNode;
            } else {
                insert(focusNode.right, insertNode);
            }
        }
    }

    public ArrayList<Node> traversePreOrder() {
        return traversePreOrder(this.root);
    }

    private ArrayList<Node> traversePreOrder(Node focusNode) {
        ArrayList<Node> nodes = new ArrayList<>();

        if (focusNode != null) {
            nodes.add(focusNode);
            nodes.addAll(traversePreOrder(focusNode.left));
            nodes.addAll(traversePreOrder(focusNode.right));

        }
        return nodes;
    }

    public ArrayList<Node> traversePostOrder() {
        return traversePostOrder(this.root);
    }

    private ArrayList<Node> traversePostOrder(Node focusNode) {
        ArrayList<Node> nodes = new ArrayList<>();

        if (focusNode != null) {
            nodes.addAll(traversePostOrder(focusNode.left));
            nodes.addAll(traversePostOrder(focusNode.right));
            nodes.add(focusNode);
        }
        return nodes;
    }

    public ArrayList<Node> traverseInOrder() {
        return traverseInOrder(this.root);
    }

    private ArrayList<Node> traverseInOrder(Node focusNode) {
        ArrayList<Node> nodes = new ArrayList<>();

        if (focusNode != null) {
            nodes.addAll(traverseInOrder(focusNode.left));
            nodes.add(focusNode);
            nodes.addAll(traverseInOrder(focusNode.right));
        }

        return nodes;
    }
}
*/