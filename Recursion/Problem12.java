// Quick sort

import java.util.Arrays;

public class Problem12 {

  static void swap(int[] nums, int pos1, int pos2) {
    int temp = nums[pos1];
    nums[pos1] = nums[pos2];
    nums[pos2] = temp;
  }

  static int getPartition(int[] nums, int low, int high) {
    int i = low, j = high, pivot = low;
    while (i < j) {
      while (nums[i] <= nums[pivot] && i <= high - 1)
        i++;
      while (nums[j] > nums[pivot] && j >= low + 1)
        j--;
      if (i < j)
        swap(nums, i, j);
    }
    swap(nums, low, j);
    return j;
  }

  static void quickSort(int[] nums, int low, int high) {
    if (low < high) {
      int partition = getPartition(nums, low, high);
      quickSort(nums, low, partition - 1);
      quickSort(nums, partition + 1, high);
    }
  }

  public static void main(String[] args) {
    int[] nums = { 2, 4, 1, 7, 1, 9, 3, 5, 8 };
    quickSort(nums, 0, nums.length - 1);
    System.out.println(Arrays.toString(nums));
  }
}
