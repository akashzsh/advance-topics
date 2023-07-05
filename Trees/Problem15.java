// Children Sum Property in Binary Tree

import java.util.ArrayList;
import java.util.List;

public class Problem15 {
  Node root;

  Problem15() {
    root = null;
  }

  public static void construct(Node node) {
    if (node == null)
      return;
    int child = 0;
    if (node.left != null)
      child += node.left.val;
    if (node.right != null)
      child += node.right.val;

    if (child > node.val)
      node.val = child;
    else {
      if (node.left != null)
        node.left.val = node.val;
      if (node.right != null)
        node.right.val = node.val;
    }

    construct(node.left);
    construct(node.right);

    int total = 0;
    if (node.left != null)
      total += node.left.val;
    if (node.right != null)
      total += node.right.val;
    if (node.left != null || node.right != null)
      node.val = total;
  }

  public static void main(String[] args) {
    Problem15 tree = new Problem15();
    Problem04 obj = new Problem04();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.right = new Node(6);
    tree.root.left.right.right = new Node(7);
    tree.root.left.right.right.right = new Node(8);
    tree.root.right.right.left = new Node(9);

    List<List<Integer>> res = new ArrayList<>();
    construct(tree.root);
    obj.levelOrder(tree.root, res);
    System.out.println(res);
  }
}
