import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n, m;
    n = sc.nextInt();
    long[] arr = new long[n];

    for (int j = 0; j < n; j++) {
      arr[j] = sc.nextLong();
    }

    Arrays.sort(arr);


    m = sc.nextInt();
    long[] check = new long[m];

    for (int i = 0; i < m; i++) {
      check[i] = sc.nextLong();
    }

    for (long num : check) {
      System.out.println(binarySearch(num, arr) ? 1 : 0);
    }
  }

  static boolean binarySearch(long target, long[] arr) {
    int start, end, mid;

    start = 0;
    end = arr.length - 1;
    while (start <= end) {
      mid = (start + end) / 2;
      if (target < arr[mid]) {
        end = mid - 1;
      } else if (target > arr[mid]) {
        start = mid + 1;
      } else {
        return true;
      }
    }
    return false;
  }
}