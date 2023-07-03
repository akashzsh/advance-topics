// Boundary Traversal of a Binary Tree

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem11 {
  Node root;

  Problem11() {
    root = null;
  }

  public static void leftBoundary(List<Integer> res, Node root) {
    res.add(root.val);
    while (true) {
      if (root.left != null)
        root = root.left;
      else
        root = root.right;
      if (root.left == null && root.right == null)
        break;
      res.add(root.val);
    }
  }

  public static void leafBoundary(List<Integer> res, Node root) {
    if (root == null)
      return;
    leafBoundary(res, root.left);
    if (root.left == null && root.right == null)
      res.add(root.val);
    leafBoundary(res, root.right);
  }

  public static void rightBoundary(List<Integer> res, Stack<Integer> stack, Node root) {
    stack.push(root.val);
    while (true) {
      if (root.right != null)
        root = root.right;
      else
        root = root.left;
      if (root.left == null && root.right == null)
        break;
      stack.push(root.val);
    }
    while (!stack.isEmpty())
      res.add(stack.pop());
  }

  public static void main(String[] args) {
    Problem11 tree = new Problem11();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.right = new Node(6);
    tree.root.left.right.right = new Node(7);
    tree.root.left.right.right.right = new Node(8);
    tree.root.right.right.left = new Node(9);

    List<Integer> res = new ArrayList<>();
    leftBoundary(res, tree.root);
    leafBoundary(res, tree.root);
    rightBoundary(res, new Stack<>(), tree.root.right);
    System.out.println(res);
  }
}
