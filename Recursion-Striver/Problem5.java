// Palindrome using Recursion

public class Problem5 {

  public static boolean palindrome(String name, int start, int end) {
    if (start >= end)
      return true;
    if (name.charAt(start) != name.charAt(end))
      return false;
    return palindrome(name, start + 1, end - 1);
  }

  public static void main(String[] args) {
    String name = "malayalam";
    if (palindrome(name, 0, name.length() - 1))
      System.out.println("Palindrome");
    else
      System.out.println("Not a palindrome");
  }
}
