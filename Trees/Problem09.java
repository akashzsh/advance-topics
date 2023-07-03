// Maximum Depth of a Binary Tree (DFS)

public class Problem09 {
  Node root;

  Problem09() {
    root = null;
  }

  public static int maxDepth(Node node) {
    if (node == null)
      return 0;
    int left = maxDepth(node.left);
    int right = maxDepth(node.right);
    return 1 + Math.max(left, right);
  }

  public static void main(String[] args) {
    Problem09 tree = new Problem09();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.right = new Node(6);
    tree.root.left.right.right = new Node(7);
    tree.root.left.right.right.right = new Node(8);
    tree.root.right.right.left = new Node(9);

    System.out.println("Max Depth is " + maxDepth(tree.root));
  }
}
