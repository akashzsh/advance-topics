// Sum of N numbers using recursion

// Functional Fashion

class Problem1 {

  public static int sum(int n) {
    if (n < 1)
      return 0;
    else
      return n + sum(n - 1);
  }

  public static void main(String[] args) {
    int n = 5;
    System.out.println(sum(n));
  }
}

// Parameterized Fashion

/*
 * class Problem1 {
 * 
 * public static void sum(int count, int sum) {
 * if (count < 1) {
 * System.out.println(sum);
 * return;
 * } else
 * sum(count - 1, sum + count);
 * }
 * 
 * public static void main(String[] args) {
 * int n = 5;
 * sum(n, 0);
 * }
 * }
 */