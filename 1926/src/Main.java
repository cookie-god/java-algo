import java.util.*;

public class Main {
  static int n;
  static int m;
  static boolean[][] visited;
  static int[][] arr;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int answer;
  static List<Integer> answerList = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();

    visited = new boolean[n][m];
    arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
          arr[i][j] = sc.nextInt();
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 1 && !visited[i][j]) {
          answer = 0;
          dfs(i, j);
          answerList.add(answer);
        }
      }
    }

    if (answerList.isEmpty()) {
      System.out.println(0);
      System.out.println(0);
    } else {
      Collections.sort(answerList, (o1, o2) -> o2 - o1);
      System.out.println(answerList.size());
      System.out.println(answerList.get(0));
    }
  }

  public static void dfs(int x, int y) {
    visited[x][y] = true;
    answer++;
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (checkBorder(nx, ny) && arr[nx][ny] == 1 && !visited[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }

  public static boolean checkBorder(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m;
  }
}