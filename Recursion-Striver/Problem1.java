// Sum of N numbers using recursion

class Problem1 {

  int count = 0, sum = 0;

  public int sum(int n) {
    if (count == n + 1)
      return 0;
    else {
      sum += count++;
      sum(n);
    }
    return sum;
  }

  public static void main(String[] args) {
    Problem1 obj = new Problem1();
    int n = 5;
    System.out.println(obj.sum(n));
  }
}
