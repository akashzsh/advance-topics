// Floor in a Binary Search Tree

public class Problem20 {
  Node root;

  Problem20() {
    root = null;
  }

  public static int findFloor(Node root, int key) {
    int ans = Integer.MIN_VALUE;
    while (root != null) {
      if (root.val <= key && root.val > ans) {
        ans = root.val;
      }
      if (root.val > key)
        root = root.left;
      else
        root = root.right;
    }
    return ans == Integer.MIN_VALUE ? -1 : ans;
  }

  public static void main(String[] args) {
    Problem20 tree = new Problem20();
    tree.root = new Node(10);
    tree.root.left = new Node(5);
    tree.root.right = new Node(13);
    tree.root.left.left = new Node(3);
    tree.root.left.right = new Node(6);
    tree.root.right.left = new Node(11);
    tree.root.right.right = new Node(14);
    tree.root.left.left.left = new Node(2);
    tree.root.left.left.right = new Node(4);
    tree.root.left.right.right = new Node(9);

    System.out.println("Floor Value is " + findFloor(tree.root, 7));
  }
}
