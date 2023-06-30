// Maximum Depth of a Binary Tree (BFS)

import java.util.LinkedList;
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

public class Problem10 {
  Node root;

  Problem10() {
    root = null;
  }

  public static int maxDepth(Node node) {
    int count = 0;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(node);
    while (!queue.isEmpty()) {
      int level = queue.size();
      for (int i = 0; i < level; i++) {
        if (queue.peek().left != null)
          queue.offer(queue.peek().left);
        if (queue.peek().right != null)
          queue.offer(queue.peek().right);
        queue.poll();
      }
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    Problem10 tree = new Problem10();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.right = new Node(6);
    tree.root.left.right.right = new Node(7);
    tree.root.left.right.right.right = new Node(8);
    tree.root.right.right.left = new Node(9);

    System.out.println("Maximum Depth is " + maxDepth(tree.root));
  }
}
