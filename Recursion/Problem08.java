// All subsequences that add upto K

import java.util.ArrayList;

public class Problem08 {

  public static void subsequences(int index, int[] arr, ArrayList<Integer> nums, int k, int sum) {
    if (index >= arr.length) {
      if (sum == k)
        System.out.println(nums);
      return;
    } else {
      nums.add(arr[index]);
      sum += arr[index];
      subsequences(index + 1, arr, nums, k, sum);
      sum -= arr[index];
      nums.remove(nums.size() - 1);
      subsequences(index + 1, arr, nums, k, sum);
    }
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 1 };
    int k = 2;
    ArrayList<Integer> nums = new ArrayList<>();
    subsequences(0, arr, nums, k, 0);
  }
}
