// PreOrder Traversal of Tree

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

public class Problem01 {
  Node root;

  Problem01() {
    root = null;
  }

  public static void preOrder(Node root, List<Integer> res) {
    if (root == null)
      return;
    res.add(root.val);
    preOrder(root.left, res);
    preOrder(root.right, res);
  }

  public static void main(String[] args) {
    Problem01 tree = new Problem01();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.right = new Node(6);

    List<Integer> res = new ArrayList<>();
    preOrder(tree.root, res);
    System.out.println(res);
  }
}
