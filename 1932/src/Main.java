import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][n];
    int[][] dp = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    if (n == 1) {
      System.out.println(arr[0][0]);
    } else {
      dp[0][0] = arr[0][0];
      dp[1][0] = arr[1][0] + dp[0][0];
      dp[1][1] = arr[1][1] + dp[0][0];

      for (int i = 2; i < n; i++) {
        for (int j = 0; j <= i; j++) {
          if (j == 0) {
            dp[i][j] = arr[i][j] + dp[i-1][j];
          } else if (j == i) {
            dp[i][j] = arr[i][j] + dp[i-1][j-1];
          } else {
            dp[i][j] = Math.max(arr[i][j] + dp[i-1][j-1], arr[i][j] + dp[i-1][j]);
          }
        }
      }
      Arrays.sort(dp[n-1]);
      System.out.println(dp[n-1][n-1]);
    }
  }
}