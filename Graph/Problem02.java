import java.util.ArrayList;

class DisjointSet {
  ArrayList<Integer> rank = new ArrayList<>();
  ArrayList<Integer> parent = new ArrayList<>();
  ArrayList<Integer> size = new ArrayList<>();

  DisjointSet(int n) {
    for (int i = 0; i <= n; i++) {
      rank.add(0);
      parent.add(i);
      size.add(1);
    }
  }

  // Path Compression
  int findUParent(int node) {
    if (node == parent.get(node))
      return node;
    int ulp = findUParent(parent.get(node));
    parent.set(node, ulp);
    return parent.get(node);
  }

  void findUnionRank(int u, int v) {
    int ulpU = findUParent(u), ulpV = findUParent(v);
    if (ulpU == ulpV)
      return;
    if (rank.get(ulpU) < rank.get(ulpV)) {
      parent.set(ulpU, ulpV);
    } else if (rank.get(ulpU) > rank.get(ulpV)) {
      parent.set(ulpV, ulpU);
    } else {
      parent.set(ulpU, ulpV);
      rank.set(ulpV, rank.get(ulpV) + 1);
    }
  }

  void findUnionSize(int u, int v) {
    int ulpU = findUParent(u), ulpV = findUParent(v);
    if (ulpU == ulpV)
      return;
    if (size.get(ulpU) < size.get(ulpV)) {
      parent.set(ulpV, ulpU);
      size.set(ulpV, size.get(ulpU) + size.get(ulpV));
    } else {
      parent.set(ulpU, ulpV);
      size.set(ulpU, size.get(ulpU) + size.get(ulpV));
    }
  }
}

public class Problem02 {
  public static void main(String[] args) {
    DisjointSet ds = new DisjointSet(7);

    // Find Union by Rank

    /*
     * ds.findUnionRank(1, 2);
     * ds.findUnionRank(2, 3);
     * ds.findUnionRank(4, 5);
     * ds.findUnionRank(6, 7);
     * ds.findUnionRank(5, 6);
     * 
     * if (ds.findUParent(3) == ds.findUParent(7)) {
     * System.out.println("Same component");
     * } else {
     * System.out.println("Not in the same component");
     * }
     * 
     * ds.findUnionRank(3, 7);
     * 
     * if (ds.findUParent(3) == ds.findUParent(7)) {
     * System.out.println("Same component");
     * } else {
     * System.out.println("Not in the same component");
     * }
     */

    // Find Union By Size

    ds.findUnionSize(1, 2);
    ds.findUnionSize(2, 3);
    ds.findUnionSize(4, 5);
    ds.findUnionSize(6, 7);
    ds.findUnionSize(5, 6);

    if (ds.findUParent(3) == ds.findUParent(7)) {
      System.out.println("Same component");
    } else {
      System.out.println("Not in the same component");
    }

    ds.findUnionSize(3, 7);

    if (ds.findUParent(3) == ds.findUParent(7)) {
      System.out.println("Same component");
    } else {
      System.out.println("Not in the same component");
    }
  }
}
