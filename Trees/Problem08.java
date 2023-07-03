// PreOrder, PostOrder, InOrder in one go

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {
  Node node;
  int freq;

  Pair(Node node, int freq) {
    this.node = node;
    this.freq = freq;
  }
}

public class Problem08 {
  Node root;

  Problem08() {
    root = null;
  }

  public static void traversals(Node root, List<Integer> pre, List<Integer> post, List<Integer> in) {
    Stack<Pair> stack = new Stack<>();
    stack.push(new Pair(root, 1));
    while (!stack.isEmpty()) {
      Pair curr = stack.pop();
      if (curr.freq == 1) {
        pre.add(curr.node.val);
        curr.freq++;
        stack.push(curr);
        if (curr.node.left != null)
          stack.push(new Pair(curr.node.left, 1));
      } else if (curr.freq == 2) {
        in.add(curr.node.val);
        curr.freq++;
        stack.push(curr);
        if (curr.node.right != null)
          stack.push(new Pair(curr.node.right, 1));
      } else {
        post.add(curr.node.val);
      }
    }
  }

  public static void main(String[] args) {
    Problem08 tree = new Problem08();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.right = new Node(6);

    List<Integer> preOrders = new ArrayList<>();
    List<Integer> postOrders = new ArrayList<>();
    List<Integer> inOrders = new ArrayList<>();
    traversals(tree.root, preOrders, postOrders, inOrders);
    System.out.println("Preorder: " + preOrders + "\nPostorder: " + postOrders + "\nInorder: " + inOrders);
  }
}
