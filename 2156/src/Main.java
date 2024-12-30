import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    int[] dp = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    dp[0] = arr[0];

    if (n == 1) {
      System.out.println(dp[0]);
    } else if (n == 2) {
      dp[1] = arr[0] + arr[1];
      System.out.println(dp[1]);
    } else {
      dp[1] = arr[0] + arr[1];
      dp[2] = Math.max(Math.max(dp[1], dp[0] + arr[2]), arr[1]+arr[2]);
      for (int i = 3; i < n; i++) {
        dp[i] = Math.max(Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]), dp[i-1]); // 전에 잔 안마신 경우, 전에 잔 마신 경우, 이번 잔 안마시는 경우
      }
      System.out.println(dp[n-1]);
    }
  }
}