import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem01 {
  public static void bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] v, ArrayList<Integer> res) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(node);
    v[node] = true;
    while (!q.isEmpty()) {
      Integer curr = q.poll();
      res.add(curr);
      for (Integer i : adj.get(curr)) {
        if (!v[i]) {
          v[i] = true;
          q.offer(i);
        }
      }
    }
  }

  public static void main(String[] args) {
    new MyGraph();
    ArrayList<ArrayList<Integer>> adj = MyGraph.adj;
    int V = 8;
    ArrayList<Integer> res = new ArrayList<>();
    boolean[] v = new boolean[V + 1];
    bfs(1, adj, v, res);
    System.out.println(res);
  }
}
