// PreOrder Traversal (Iterative)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem05 {
  Node root;

  Problem05() {
    root = null;
  }

  public static void preOrder(Node root, List<Integer> res) {
    if (root == null)
      return;
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      root = stack.pop();
      res.add(root.val);
      if (root.right != null)
        stack.add(root.right);
      if (root.left != null)
        stack.add(root.left);
    }
  }

  public static void main(String[] args) {
    Problem05 tree = new Problem05();
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
