// Morris Traversal for Inorder

import java.util.ArrayList;

public class Problem17 {
  Node root;

  Problem17() {
    root = null;
  }

  public static void inorder(Node root, ArrayList<Integer> res) {
    Node curr = root;
    while (curr != null) {
      if (curr.left == null) {
        res.add(curr.val);
        curr = curr.right;
      } else {
        Node prev = curr.left;
        while (prev.right != null && prev.right != curr) {
          prev = prev.right;
        }
        if (prev.right == null) {
          prev.right = curr;
          curr = curr.left;
        } else {
          prev.right = null;
          res.add(curr.val);
          curr = curr.right;
        }
      }
    }
  }

  public static void main(String[] args) {
    Problem17 tree = new Problem17();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.right = new Node(6);
    tree.root.left.right.right = new Node(7);
    tree.root.left.right.right.right = new Node(8);
    tree.root.right.right.left = new Node(9);

    ArrayList<Integer> res = new ArrayList<>();
    inorder(tree.root, res);
    System.out.println("Inorder Traversal: " + res);
  }
}
