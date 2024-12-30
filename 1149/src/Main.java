import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] cost = new int[n][3];
    int[][] dp = new int[n][3];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        cost[i][j] = sc.nextInt();
      }
    }

    dp[0][0] = cost[0][0];
    dp[0][1] = cost[0][1];
    dp[0][2] = cost[0][2];

    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.min(cost[i][0] + dp[i-1][1], cost[i][0] + dp[i-1][2]);
      dp[i][1] = Math.min(cost[i][1] + dp[i-1][0], cost[i][1] + dp[i-1][2]);
      dp[i][2] = Math.min(cost[i][2] + dp[i-1][0], cost[i][2] + dp[i-1][1]);
    }
    
    Arrays.sort(dp[n-1]);
    System.out.println(dp[n-1][0]);
  }
}