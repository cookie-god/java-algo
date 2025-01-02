import java.util.*;

public class Main {
  static int[] dx = {0, -1};
  static int[] dy = {1, 0};
  static int[][] visited;
  static int[][] arr;
  static int n;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    arr = new int[n][n];
    visited = new int[n][n];

    bfs();

    System.out.println(visited[n-1][n-1]);

  }

  static void bfs() {
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(0, 0));

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      for (int i = 0; i < 2; i++) {
        int nx = pair.x + (dx[i] * arr[pair.x][pair.y]);
        int ny = pair.y + (dy[i] * arr[pair.x][pair.y]);

        if (checkBorder(nx, ny)) {
          visited[nx][ny] = visited[pair.x][pair.y] + 1;
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