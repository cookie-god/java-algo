import java.util.*;

public class Main {
  static boolean[] visited;
  static int[][] arr;
  static int n;
  static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    arr = new int[n][n];
    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    dfs(0, 0);
    System.out.println(answer);
  }

  static void dfs(int index, int depth) {
    if (n/2 == depth) { // depth에 맞게 팀을 이뤘을 경우
      calculate();
      return;
    }

    for (int i = index; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true; // 방문 기록 등록
        dfs(i + 1, depth + 1);
        visited[i] = false; // 방문 기록 해제
      }
    }
  }

  static void calculate() {
    int start = 0;
    int link = 0;

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (visited[i] && visited[j]) { // 둘다 방문한 경우 스타트팀
          start += arr[i][j];
          start += arr[j][i];
        } else if (!visited[i] && !visited[j]) { // 둘다 방문하지 않은 경우 링크팀
          link += arr[i][j];
          link += arr[j][i];
        }
      }
    }

    answer = Math.min(answer, Math.abs(start - link));
  }
}