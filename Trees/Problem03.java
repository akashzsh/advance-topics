// InOrder Traversal of Tree

import java.util.ArrayList;
import java.util.List;

class Node {
  int val;
  Node left;
  Node right;

  Node(int data) {
    val = data;
    left = right = null;
  }
}

public class Problem03 {
  Node root;

  Problem03() {
    root = null;
  }

  public static void inOrder(Node root, List<Integer> res) {
    if (root == null)
      return;
    inOrder(root.left, res);
    res.add(root.val);
    inOrder(root.right, res);
  }

  public static void main(String[] args) {
    Problem03 tree = new Problem03();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.right = new Node(6);

    List<Integer> res = new ArrayList<>();
    inOrder(tree.root, res);
    System.out.println(res);
  }
}
