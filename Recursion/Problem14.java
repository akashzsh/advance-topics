// Leetcode problem 46 - Approach 2

import java.util.ArrayList;
import java.util.List;

public class Problem14 {
  public static void swap(int[] nums, int pos1, int pos2) {
    int temp = nums[pos1];
    nums[pos1] = nums[pos2];
    nums[pos2] = temp;
  }

  public static void permutations(int index, int[] nums, List<List<Integer>> res) {
    if (index == nums.length) {
      List<Integer> ds = new ArrayList<>();
      for (int i : nums)
        ds.add(i);
      res.add(new ArrayList<>(ds));
      return;
    }
    for (int i = index; i < nums.length; i++) {
      swap(nums, index, i);
      permutations(index + 1, nums, res);
      swap(nums, index, i);
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3 };
    List<List<Integer>> res = new ArrayList<>();
    permutations(0, nums, res);
    System.out.println(res);
  }
}
