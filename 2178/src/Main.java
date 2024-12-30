import java.util.*;

public class Main {
  static int n;
  static int m = 0;
  static int[][] visited;
  static int [][] maps;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) {
    boolean flag = false;
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    maps = new int[n][m];
    visited = new int[n][m];
    sc.nextLine(); // buffer 비우기

    for (int i = 0; i < n; i++) {
      String line = sc.next();
      for (int j = 0; j < m; j++) {
        maps[i][j] = line.charAt(j) - '0';
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (maps[i][j] == 1 && visited[i][j] == 0) {
          bfs(i, j);
          flag = true;
          break;
        }
      }
      if (flag) {
        break;
      }
    }
    System.out.println(visited[n-1][m-1]);
  }

  static void bfs(int x, int y) {
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(x, y));
    visited[x][y] = 1;

    while (!queue.isEmpty()) {
      Pair pair = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = pair.x + dx[i];
        int ny = pair.y + dy[i];

        if (checkBorder(nx, ny)) {
          if (maps[nx][ny] == 1 && visited[nx][ny] == 0) {
            queue.offer(new Pair(nx, ny));
            visited[nx][ny] = visited[pair.x][pair.y] + 1;
          }
        }
      }
    }
  }

  static boolean checkBorder(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m;
  }

  static class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }


}