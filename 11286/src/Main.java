import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, x;
    PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
      if (o1.absValue != o2.absValue) {
        return o1.absValue - o2.absValue;
      } else {
        return o1.value - o2.value;
      }
    });

    n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      x = sc.nextInt();
      if (x != 0) {
        pq.offer(new Pair(x, Math.abs(x)));
      } else {
        if (!pq.isEmpty()) {
          Pair pair = pq.poll();
          System.out.println(pair.value);
        } else {
          System.out.println(0);
        }
      }
    }
  }

  static class Pair {
    int value;
    int absValue;

    public Pair(int value, int absValue) {
      this.value = value;
      this.absValue = absValue;
    }
  }
}