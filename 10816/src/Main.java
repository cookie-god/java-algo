import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n, m;
    int[] arr, check;

    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    m = Integer.parseInt(br.readLine());
    check = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      check[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < m; i++) {
      bw.write(binarySearch(n, check[i], arr) + " ");
    }
    bw.flush();
    bw.close();

  }

  static int binarySearch(int n, int target, int[] arr) {
    int start, end, mid, lower, upper;
    start = 0;
    end = n - 1;

    // 아래쪽 값 구하기
    while (start <= end) {
      mid = (start + end) / 2;

      if (target <= arr[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    lower = start;

    start = 0;
    end = n - 1;

    // 위쪽 값 구하기
    while (start <= end) {
      mid = (start + end) / 2;

      if (target >= arr[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    upper = start;

    return upper - lower;
  }
}