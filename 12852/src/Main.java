import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();

    int[] dp = new int[x+1];
    int[] trace = new int[x+1];

    dp[0] = 0;
    dp[1] = 0;

    for (int i = 2; i <= x; i++) {
      dp[i] = dp[i-1] + 1;
      trace[i] = i - 1;
      if (i % 2 == 0 && dp[i] > dp[i/2]+1) {
        dp[i] = dp[i/2] + 1;
        trace[i] = i/2;
      }
      if (i % 3 == 0 && dp[i] > dp[i/3]+1) {
        dp[i] = dp[i/3] + 1;
        trace[i] = i/3;
      }
    }

    System.out.println(dp[x]);

    while (x > 0) {
      System.out.print(x + " ");
      x = trace[x];
    }
  }
}