// N Queens Problem

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem15 {
  public static List<String> construct(char[][] board) {
    List<String> curr = new LinkedList<>();
    for (int i = 0; i < board.length; i++) {
      String tmp = new String(board[i]);
      curr.add(tmp);
    }
    return curr;
  }

  public static void solve(int n, char[][] board, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, int col,
      List<List<String>> res) {
    if (col == n) {
      res.add(construct(board));
      return;
    }
    for (int row = 0; row < n; row++) {
      if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 & upperDiagonal[n - 1 + col - row] == 0) {
        board[row][col] = 'Q';
        leftRow[row] = 1;
        lowerDiagonal[row + col] = 1;
        upperDiagonal[n - 1 + col - row] = 1;
        solve(n, board, leftRow, upperDiagonal, lowerDiagonal, col + 1, res);
        board[row][col] = '-';
        leftRow[row] = 0;
        lowerDiagonal[row + col] = 0;
        upperDiagonal[n - 1 + col - row] = 0;
      }
    }
  }

  public static void main(String[] args) {
    int n = 6;
    List<List<String>> res = new ArrayList<>();
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '-';
      }
    }
    int[] leftRow = new int[n];
    int[] upperDiagonal = new int[2 * n - 1];
    int[] lowerDiagonal = new int[2 * n - 1];
    solve(n, board, leftRow, upperDiagonal, lowerDiagonal, 0, res);
    System.out.println("Arrangements:");
    for (List<String> list : res) {
      for (String curr : list) {
        System.out.println(curr);
      }
      System.out.println();
    }
  }
}
