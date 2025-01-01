import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    for (int i = 0; i < n; i++) { // i는 거쳐가는 곳
      for (int j = 0; j < n; j++) { // j는 출발하는 곳
        for (int k = 0; k < n; k++) { // k는 도착하는 곳
          if (arr[j][i] == 1 && arr[i][k] == 1) {
            arr[j][k] = 1;
          }
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}