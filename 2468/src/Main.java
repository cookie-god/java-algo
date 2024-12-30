import java.util.*;

public class Main {
  static int n;
  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) {
    int answer = 1;
    int check;

    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();

    arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    for (int i = 1; i <= 100; i++) { // 잠기는 높이는 1이상 100이하
      visited = new boolean[n][n];
      check = 0; // 잠긴 지역 카운팅
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (arr[j][k] > i && !visited[j][k]) { // j, k 위치가 i보다 크거나 방문하지 않았다면
//            bfs(j, k, i);
            dfs(j, k, i);
            check++;
          }
        }
      }
      answer = Math.max(answer, check); // answer 계산
    }

    System.out.println(answer);
  }

  static void dfs(int x, int y, int limit) {
    visited[x][y] = true;
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (checkBorder(nx, ny)) {
        if (arr[nx][ny] > limit && !visited[nx][ny]) {
          dfs(nx, ny, limit);
        }
      }
    }
  }

  static void bfs(int x, int y, int limit) {
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(x, y));
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = pair.x + dx[i];
        int ny = pair.y + dy[i];

        if (checkBorder(nx, ny)) {
          if (arr[nx][ny] > limit && !visited[nx][ny]) {
            queue.offer(new Pair(nx, ny));
            visited[nx][ny] = true;
          }
        }
      }
    }
  }

  static boolean checkBorder(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < n;
  }

  static class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}