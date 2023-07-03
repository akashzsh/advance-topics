// PostOrder Traversal (Iterative - 2 Stacks)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem07 {
  Node root;

  Problem07() {
    root = null;
  }

  public static void postOrder(Node root, List<Integer> res) {
    Stack<Node> stack1 = new Stack<>();
    Stack<Node> stack2 = new Stack<>();
    stack1.push(root);
    while (!stack1.isEmpty()) {
      root = stack1.pop();
      stack2.push(root);
      if (root.left != null)
        stack1.push(root.left);
      if (root.right != null)
        stack1.push(root.right);
    }
    while (!stack2.isEmpty())
      res.add(stack2.pop().val);
  }

  public static void main(String[] args) {
    Problem07 tree = new Problem07();
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
