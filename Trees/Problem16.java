// Min Time to Burn a Binary Tree from any node

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Problem16 {
  Node root;

  Problem16() {
    root = null;
  }

  public static void getParent(Node root, HashMap<Node, Node> parent) {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node curr = queue.poll();
        if (curr.left != null) {
          queue.offer(curr.left);
          parent.put(curr.left, curr);
        }
        if (curr.right != null) {
          queue.offer(curr.right);
          parent.put(curr.right, curr);
        }
      }
    }
  }

  public static int burnTime(Node root) {
    int max = 0;
    Queue<Node> queue = new LinkedList<>();
    HashMap<Node, Node> parent = new HashMap<>();
    HashMap<Node, Boolean> visited = new HashMap<>();
    getParent(root, parent);
    visited.put(root, true);
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      int flag = 0;
      for (int i = 0; i < size; i++) {
        Node curr = queue.poll();
        if (curr.left != null && visited.get(curr.left) == null) {
          flag = 1;
          queue.offer(curr.left);
          visited.put(curr.left, true);
        }
        if (curr.right != null && visited.get(curr.right) == null) {
          flag = 1;
          queue.offer(curr.right);
          visited.put(curr.right, true);
        }
        if (parent.get(curr) != null && visited.get(parent.get(curr)) == null) {
          flag = 1;
          queue.offer(parent.get(curr));
          visited.put(parent.get(curr), true);
        }
      }
      if (flag == 1)
        max++;
    }
    return max;
  }

  public static void main(String[] args) {
    Problem16 tree = new Problem16();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.right = new Node(6);
    tree.root.left.right.right = new Node(7);
    tree.root.left.right.right.right = new Node(8);
    tree.root.right.right.left = new Node(9);

    System.out.println("Burn Time is " + burnTime(tree.root));
  }
}
