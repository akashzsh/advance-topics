// Print subsequences using recursion

import java.util.ArrayList;

class Problem7 {

  public static void subsequence(int index, int[] arr, ArrayList<Integer> nums) {
    if (index >= arr.length) {
      System.out.println(nums);
      return;
    } else {
      nums.add(arr[index]);
      subsequence(index + 1, arr, nums);
      nums.remove(nums.size() - 1);
      subsequence(index + 1, arr, nums);
    }
  }

  public static void main(String[] args) {
    int[] input = { 3, 1, 2 };
    ArrayList<Integer> nums = new ArrayList<>();
    subsequence(0, input, nums);
  }
}
