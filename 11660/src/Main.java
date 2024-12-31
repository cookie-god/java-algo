import java.util.*;

public class Main {
  public static void main(String[] args) {
    int n, m;
    int[][] arr;
    int[][] dp;

    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();

    arr = new int[n][n];
    dp = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    int sum;
    for (int i = 0; i < n; i++) {
      sum = 0;
      for (int j = 0; j < n; j++) {
        sum += arr[i][j];
        dp[i][j] = sum;
      }
    }

    int x1, y1, x2, y2;
    int result;
    for (int i = 0; i < m; i++) {
      x1 = sc.nextInt() - 1;
      y1 = sc.nextInt() - 1;
      x2 = sc.nextInt() - 1;
      y2 = sc.nextInt() - 1;

      result = 0;
      for (int j = x1; j <= x2; j++) {
        if (y1 == 0) {
          result += (dp[j][y2] - dp[j][0]);
        } else {
          result += (dp[j][y2] - dp[j][y1-1]);
        }
      }
      System.out.println(result);
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
  }
}