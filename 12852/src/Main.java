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
      dp[i] = dp[i-1] + 1; // 1로 뺀 것 먼저 체크
      trace[i] = i - 1; // 위치 저장

      if (i % 2 == 0 && dp[i] > dp[i/2]+1) { // 2로 나눴을 때 비교
        dp[i] = dp[i/2] + 1; // 값 변경
        trace[i] = i/2; // 위치 변경
      }
      if (i % 3 == 0 && dp[i] > dp[i/3]+1) { // 3으로 나눴을 때 비교
        dp[i] = dp[i/3] + 1; // 값 변경
        trace[i] = i/3; // 위치 변경
      }
    }

    System.out.println(dp[x]);

    while (x > 0) {
      System.out.print(x + " "); // x값 출력
      x = trace[x]; // 위치 기반으로 x값 변경
    }
  }
}