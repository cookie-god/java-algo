import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n+1];
    int[] dp = new int[n+1]; // n번째 값은 n개의 카드를 살 때, 가장 많은 금액을 사용한 경우

    for (int i = 1; i <= n; i++) {
      arr[i] = sc.nextInt();
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] = Math.max(dp[i], dp[i-j] + arr[j]); // i번째 인덱스에서 카드를 가장 비싸게 살 수 있는 법을 찾는 점화식
      }
    }
    System.out.println(dp[n]);
  }
}