// Count number of subsequences that adds upto K

public class Problem10 {

  public static int subsequences(int index, int[] arr, int sum, int k, int count) {
    if (index >= arr.length) {
      if (sum == k)
        return 1;
      return 0;
    }
    sum += arr[index];
    int l = subsequences(index + 1, arr, sum, k, count);
    sum -= arr[index];
    int r = subsequences(index + 1, arr, sum, k, count);
    return l + r;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 1 };
    int k = 4;
    System.out.println(subsequences(0, arr, 0, k, 0));
  }
}
