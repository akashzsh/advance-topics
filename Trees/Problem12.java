// Top View of a Binary Tree

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class Problem12 {
  Node root;

  Problem12() {
    root = null;
  }

  public static void topView(List<Integer> res, Node root) {
    Queue<TwoTuple> queue = new LinkedList<>();
    queue.offer(new TwoTuple(root, 0));
    TreeMap<Integer, Integer> map = new TreeMap<>();
    while (!queue.isEmpty()) {
      TwoTuple tmp = queue.poll();
      if (tmp.node.left != null)
        queue.offer(new TwoTuple(tmp.node.left, tmp.val - 1));
      if (tmp.node.right != null)
        queue.offer(new TwoTuple(tmp.node.right, tmp.val + 1));
      if (!map.containsKey(tmp.val)) {
        map.put(tmp.val, tmp.node.val);
      }
    }
    for (int val : map.values())
      res.add(val);
  }

  public static void main(String[] args) {
    Problem12 tree = new Problem12();
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
    topView(res, tree.root);
    System.out.println("Top View: " + res);
  }
}
