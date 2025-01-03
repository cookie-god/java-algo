import java.util.*;

public class Main {
  static int n;
  static int m;
  static int[][] arr;
  static boolean[][] visited;
  static List<Integer> answerList = new ArrayList<>();
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int answer;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int k, x, y;

    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();

    arr = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < k; i++) {
      x = sc.nextInt();
      y = sc.nextInt();
      arr[x-1][y-1] = 1;
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

    System.out.println(Collections.max(answerList));
  }

  static void dfs(int x, int y) {
    visited[x][y] = true; // 방문 처리
    answer++;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (checkBorder(nx, ny) && arr[nx][ny] == 1 && !visited[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }

  static void bfs(int x, int y) {
    visited[x][y] = true;
    answer++;

    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(x, y));

    while(!queue.isEmpty()) {
      Pair pair = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = pair.x + dx[i];
        int ny = pair.y + dy[i];

        if (checkBorder(nx, ny) && arr[nx][ny] == 1 && !visited[nx][ny]) {
          visited[nx][ny] = true;
          answer++;
          queue.offer(new Pair(nx, ny));
        }
      }
    }
  }

  static boolean checkBorder(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m;
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