import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int F, S, G, U, D; // F는 총 층, S는 현재층, G는 목표층, U는 올라가는 수, D는 내려가는 수
    int[] floor = new int[1000001]; // 총 층수에 대한 기록
    Queue<Integer> queue = new LinkedList<>(); // 현재 층수에 대한 큐

    Arrays.fill(floor, Integer.MAX_VALUE);

    F = sc.nextInt();
    S = sc.nextInt();
    G = sc.nextInt();
    U = sc.nextInt();
    D = sc.nextInt();


    floor[S] = 0; // 현재 층은 한번에 도달하므로 0으로 처리
    queue.offer(S); // 현재 층 큐에 삽입

    while (!queue.isEmpty()) { // 큐 순회
      int temp = queue.poll(); // pop

      if (temp == G) { // 현재층이랑 같다면
        System.out.println(floor[G]); // 배열 값 리턴
        return;
      }

      int up = temp + U; // 현재 위치에서 U만큼 이동
      if (up >= 1 && up <= F && floor[up] > floor[temp] + 1) { // 이동한 위치가 1하고 F사이에 있으며, 이동하려는 층이 현재 층의 횟수보다 크다면
        queue.offer(up); // 큐 삽입
        floor[up] = floor[temp] + 1; // 이동횟수 변경
      }

      int down = temp - D;
      if (down >= 1 && down <= F && floor[down] > floor[temp] + 1) { // 이동한 위치가 1하고 F사이에 있으며, 이동하려는 층이 현재 층의 횟수보다 크다면
        queue.offer(down); // 큐 삽입
        floor[down] = floor[temp] + 1;  // 이동횟수 변경
      }
    }



    System.out.println("use the stairs");
  }
}