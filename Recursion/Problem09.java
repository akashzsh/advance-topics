// Print only one subsequence that adds upto K

import java.util.ArrayList;

class Problem09 {

  public static boolean subsequences(int index, int[] arr, ArrayList<Integer> nums, int sum, int k) {
    if (index >= arr.length) {
      if (sum == k) {
        System.out.println(nums);
        return true;
      }
      return false;
    }
    nums.add(arr[index]);
    sum += arr[index];
    if (subsequences(index + 1, arr, nums, sum, k))
      return true;
    nums.remove(nums.size() - 1);
    sum -= arr[index];
    if (subsequences(index + 1, arr, nums, sum, k))
      return true;
    return false;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 1 };
    int k = 4;
    ArrayList<Integer> nums = new ArrayList<>();
    subsequences(0, arr, nums, 0, k);
  }
}
