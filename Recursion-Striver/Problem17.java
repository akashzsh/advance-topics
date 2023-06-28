// Count Inversions in Array

import java.util.ArrayList;
import java.util.List;

public class Problem17 {
  public static int merge(int[] nums, int low, int mid, int high) {
    int left = low, right = mid + 1, count = 0;
    List<Integer> ans = new ArrayList<>();
    while (left <= mid && right <= high) {
      if (nums[left] <= nums[right])
        ans.add(nums[left++]);
      else {
        ans.add(nums[right++]);
        count += (mid - left + 1);
      }
    }
    while (left <= mid)
      ans.add(nums[left++]);
    while (right <= high)
      ans.add(nums[right++]);
    for (int i = low; i <= high; i++) {
      nums[i] = ans.get(i - low);
    }
    return count;
  }

  public static int mergeSort(int[] nums, int low, int high) {
    int count = 0;
    if (low >= high)
      return count;
    int mid = low + (high - low) / 2;
    count += mergeSort(nums, low, mid);
    count += mergeSort(nums, mid + 1, high);
    count += merge(nums, low, mid, high);
    return count;
  }

  public static void main(String[] args) {
    int[] nums = { 5, 3, 2, 1, 4 };
    int cnt = mergeSort(nums, 0, nums.length - 1);
    System.out.println(cnt);
  }
}
