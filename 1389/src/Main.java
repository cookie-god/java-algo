import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] arr = new int[n+1][n+1];


    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b= sc.nextInt();

      arr[a][b] = 1;
      arr[b][a] = 1;
    }

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        if (arr[i][j] == 0) {
          arr[i][j] = 100000;
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        for (int k = 1; k <= n; k++) {
          arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
        }
      }
    }

    int res = 100000;
    int idx = -1;

    for (int i = 1; i <= n; i++) {
      int total = 0;
      for (int j = 1; j <= n; j++) {
        total += arr[i][j];
      }

      if (res > total) {
        res = total;
        idx = i;
      }
    }
    System.out.println(idx);
  }
}