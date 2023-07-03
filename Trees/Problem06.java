// InOrder Traversal (Iterative)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem06 {
  Node root;

  Problem06() {
    root = null;
  }

  public static void inOrder(Node root, List<Integer> res) {
    Stack<Node> stack = new Stack<>();
    while (true) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        if (stack.isEmpty())
          break;
        else {
          root = stack.pop();
          res.add(root.val);
          root = root.right;
        }
      }
    }
  }

  public static void main(String[] args) {
    Problem06 tree = new Problem06();
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
