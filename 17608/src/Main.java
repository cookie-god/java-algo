import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = n-1; i >= 0; i--) {
      arr[i] = sc.nextInt();
    }


    for (int i = 0; i < n; i++) {
      if (stack.isEmpty()) {
        stack.push(arr[i]);
      } else {
        if (stack.peek() < arr[i]) {
          stack.push(arr[i]);
        }
      }
    }

    System.out.println(stack.size());
  }
}