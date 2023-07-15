import java.util.ArrayList;

final class MyGraph {
  static final ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

  MyGraph() {
    for (int i = 0; i <= 8; i++)
      adj.add(new ArrayList<>());
    adj.get(1).add(2);
    adj.get(2).add(1);
    adj.get(1).add(3);
    adj.get(3).add(1);
    adj.get(2).add(5);
    adj.get(5).add(2);
    adj.get(2).add(6);
    adj.get(6).add(2);
    adj.get(3).add(4);
    adj.get(4).add(3);
    adj.get(3).add(7);
    adj.get(7).add(3);
    adj.get(7).add(8);
    adj.get(4).add(8);
    adj.get(8).add(4);
    adj.get(8).add(7);
  }
}
