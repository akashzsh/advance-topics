// Leetcode question 46 - Approach 1

import java.util.ArrayList;
import java.util.List;

public class Problem13 {
  public static void permutations(int[] nums, boolean[] freq, List<Integer> ds, List<List<Integer>> res) {
    if (ds.size() == nums.length) {
      res.add(new ArrayList<>(ds));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!freq[i]) {
        freq[i] = true;
        ds.add(nums[i]);
        permutations(nums, freq, ds, res);
        ds.remove(ds.size() - 1);
        freq[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3 };
    List<List<Integer>> res = new ArrayList<>();
    boolean[] freq = new boolean[nums.length];
    permutations(nums, freq, new ArrayList<>(), res);
    System.out.println(res);
  }
}