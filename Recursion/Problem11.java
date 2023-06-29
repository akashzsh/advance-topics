// Merge Sort

import java.util.ArrayList;
import java.util.Arrays;

public class Problem11 {

  static void merge(int[] nums, int low, int mid, int high) {
    int i = low, j = mid + 1;
    ArrayList<Integer> temp = new ArrayList<>();
    while (i <= mid && j <= high) {
      if (nums[i] <= nums[j])
        temp.add(nums[i++]);
      else
        temp.add(nums[j++]);
    }
    while (i <= mid)
      temp.add(nums[i++]);
    while (j <= high)
      temp.add(nums[j++]);
    for (int p = low; p <= high; p++)
      nums[p] = temp.get(p - low);
  }

  static void mergeSort(int[] nums, int low, int high) {
    if (low >= high)
      return;
    int mid = low + (high - low) / 2;
    mergeSort(nums, low, mid);
    mergeSort(nums, mid + 1, high);
    merge(nums, low, mid, high);
  }

  public static void main(String[] args) {
    int[] nums = { 4, 2, 1, 1, 9, 8, 6, 3, 5 };
    mergeSort(nums, 0, nums.length - 1);
    System.out.println(Arrays.toString(nums));
  }
}
