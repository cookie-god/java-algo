import java.util.*;

public class Main {
  public static void main(String[] args) {
    int n, m;
    int[][] arr;
    int[][] dp;

    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();

    arr = new int[n+1][n+1];
    dp = new int[n+1][n+1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    int sum;
    for (int i = 1; i <= n; i++) {
      sum = 0;
      for (int j = 1; j <= n; j++) {
        sum += arr[i][j];
        dp[i][j] = sum;
      }
    }

    int x1, y1, x2, y2;
    int result;
    for (int i = 0; i < m; i++) {
      x1 = sc.nextInt();
      y1 = sc.nextInt();
      x2 = sc.nextInt();
      y2 = sc.nextInt();

      result = 0;
      for (int j = x1; j <= x2; j++) {
        result += (dp[j][y2] - dp[j][y1-1]);
      }
      System.out.println(result);
    }

//    for (int i = 1; i <= n; i++) {
//      for (int j = 1; j <= n; j++) {
//        System.out.print(dp[i][j] + " ");
//      }
//      System.out.println();
//    }
  }
}