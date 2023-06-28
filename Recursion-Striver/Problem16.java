// Rat in a Maze

import java.util.ArrayList;
import java.util.List;

public class Problem16 {
  public static void solve(int i, int j, int n, int[][] board, List<String> res, String curr, int[] di, int[] dj,
      int[][] visited) {
    if (i == n - 1 && j == n - 1) {
      res.add(curr);
      return;
    }
    String seq = "DLRU";
    for (int index = 0; index < 4; index++) {
      int nexti = i + di[index];
      int nextj = j + dj[index];
      if (nexti >= 0 && nexti < n && nextj >= 0 && nextj < n && visited[nexti][nextj] == 0
          && board[nexti][nextj] == 1) {
        visited[i][j] = 1;
        solve(nexti, nextj, n, board, res, curr + seq.charAt(index), di, dj, visited);
        visited[i][j] = 0;
      }
    }
  }

  public static void main(String[] args) {
    int n = 4;
    List<String> res = new ArrayList<>();
    int[][] board = {
        { 1, 0, 0, 0 },
        { 1, 1, 0, 1 },
        { 1, 1, 0, 0 },
        { 0, 1, 1, 1 }
    };
    int[][] visited = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        visited[i][j] = 0;
      }
    }
    int[] di = { 1, 0, 0, -1 };
    int[] dj = { 0, -1, 1, 0 };
    solve(0, 0, n, board, res, "", di, dj, visited);
    System.out.println(res);
  }
}
