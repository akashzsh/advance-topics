// Reverse Array using recursion

import java.util.Arrays;

class Problem4 {

  public static void reverse(int[] nums, int start, int end) {
    if (start >= end)
      return;
    else {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      reverse(nums, start + 1, end - 1);
    }
  }

  public static void main(String[] args) {
    int[] nums = { 12, 4, 5, 14, 65 };
    reverse(nums, 0, nums.length - 1);
    System.out.println(Arrays.toString(nums));
  }
}
