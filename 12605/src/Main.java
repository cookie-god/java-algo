import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < n; i++) {
      String[] arr = sc.nextLine().split(" ");
      Stack<String> stack = new Stack<>();
      for (String s : arr) {
        stack.push(s);
      }
      System.out.print("Case #" + (i+1) + ": ");
      while (!stack.isEmpty()) {
        System.out.print(stack.pop() + " ");
      }
      System.out.println();
    }
  }
}