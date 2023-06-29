// PostOrder Traversal of Tree

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

public class Problem02 {
  Node root;

  Problem02() {
    root = null;
  }

  public static void postOrder(Node root, List<Integer> res) {
    if (root == null)
      return;
    postOrder(root.left, res);
    postOrder(root.right, res);
    res.add(root.val);
  }

  public static void main(String[] args) {
    Problem02 tree = new Problem02();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.right = new Node(6);

    List<Integer> res = new ArrayList<>();
    postOrder(tree.root, res);
    System.out.println(res);
  }
}
