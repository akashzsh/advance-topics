// Level Order Traversal of Tree

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
  int val;
  Node left;
  Node right;

  Node(int data) {
    val = data;
    left = right = null;
  }
}

public class Problem04 {
  Node root;

  Problem04() {
    root = null;
  }

  public static void levelOrder(Node root, List<List<Integer>> res) {
    if (root == null)
      return;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      List<Integer> ds = new LinkedList<>();
      int currLevel = queue.size();
      for (int i = 0; i < currLevel; i++) {
        if (queue.peek().left != null)
          queue.offer(queue.peek().left);
        if (queue.peek().right != null)
          queue.offer(queue.peek().right);
        ds.add(queue.poll().val);
      }
      res.add(ds);
    }
  }

  public static void main(String[] args) {
    Problem04 tree = new Problem04();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.right = new Node(6);

    List<List<Integer>> res = new LinkedList<>();
    levelOrder(tree.root, res);
    System.out.println(res);
  }
}
