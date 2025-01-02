import java.util.*;

public class Main {
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int arr[][];
  static int m;
  static int n;
  static int answer;
  static List<Integer> answerList = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    m = sc.nextInt(); // row
    n = sc.nextInt(); // column
    int k = sc.nextInt(); // 직사각형 개수

    arr = new int[m][n];

    int x1, x2, y1, y2;
    for (int i = 0; i < k; i++) {
      x1 = sc.nextInt();
      y1 = sc.nextInt();
      x2 = sc.nextInt();
      y2 = sc.nextInt();


      for (int y = y1; y < y2; y++) {
        for (int x = x1; x < x2; x++) {
          arr[y][x] = 1;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][j] == 0) {
          answer = 1;
          dfs(i, j);
          answerList.add(answer);
        }
      }
    }

    answerList.sort(Comparator.comparingInt(o -> o));
    System.out.println(answerList.size());
    for (Integer i : answerList) {
      System.out.print(i + " ");
    }
  }

  public static void dfs(int y, int x) {
    arr[y][x] = 1; //visited를 따로 만들어주지 않고, 들어왔음을 1로 표시했다.

    for(int i=0;i<4;i++) {
      int nx = dx[i] + x;
      int ny = dy[i] + y;

      if(checkBorder(nx, ny) && arr[ny][nx]==0) {
        answer++;
        dfs(ny,nx);
      }
    }
  }

  public static boolean checkBorder(int x, int y) {
    return x >= 0 && y >= 0 && x < n && y < m;
  }
}