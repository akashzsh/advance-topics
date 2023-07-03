// print from n to 1 using backtracking

class Problem02 {

  public static void output(int i, int n) {
    if (i > n)
      return;
    output(i + 1, n);
    System.out.println(i);
  }

  public static void main(String[] args) {
    int n = 5;
    output(1, n);
  }
}
