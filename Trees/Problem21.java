// Inorder Successor of a Binary Search Tree

public class Problem21 {
  Node root;

  Problem21() {
    root = null;
  }

  public static int findSuccessor(Node root, int key) {
    int ans = -1;
    if (root == null)
      return -1;
    while (root != null) {
      if (root.val <= key)
        root = root.right;
      else {
        ans = root.val;
        root = root.left;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Problem21 tree = new Problem21();
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

    System.out.println(findSuccessor(tree.root, 9));
  }
}
