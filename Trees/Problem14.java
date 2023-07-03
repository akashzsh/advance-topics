// Path from root to a specific node

import java.util.ArrayList;

public class Problem14 {
  Node root;

  Problem14() {
    root = null;
  }

  public static boolean getPath(ArrayList<Integer> res, Node root, int target) {
    if (root == null)
      return false;

    res.add(root.val);
    if (root.val == target)
      return true;

    if (getPath(res, root.left, target) || getPath(res, root.right, target))
      return true;

    res.remove(res.size() - 1);
    return false;
  }

  public static void main(String[] args) {
    Problem14 tree = new Problem14();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.right = new Node(6);
    tree.root.left.right.right = new Node(7);
    tree.root.left.right.right.right = new Node(8);
    tree.root.right.right.left = new Node(9);

    ArrayList<Integer> res = new ArrayList<>();
    if (getPath(res, tree.root, 7))
      System.out.println(res);
    else
      System.out.println("Node not present");
  }
}
