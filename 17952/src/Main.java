import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Stack<Pair> stack = new Stack<>();
    int n = sc.nextInt();
    int check, score, minute;
    int answer = 0;

    for (int i = 0; i < n; i++) {
      check = sc.nextInt();
      if (check == 1) { // 1일때 삽입
        score = sc.nextInt();
        minute = sc.nextInt();
        if (minute - 1 == 0) {
          answer += score;
        } else {
          Pair pair = new Pair(score, minute-1);
          stack.push(pair);
        }
      } else { // 0일때 추출
        if (!stack.isEmpty()) {
          Pair pair = stack.pop();
          pair.setMinute(pair.getMinute()-1); // 1빼기
          if (pair.getMinute() == 0) { // 숙제를 다했다면
            answer += pair.getScore(); // 점수 추가
          } else { // 숙제를 다하지 못했다면
            stack.push(pair); // 스택에 재삽입
          }
        }
      }
    }

    System.out.println(answer);
  }

  public static class Pair {
    int score;
    int minute;

    public Pair(int score, int minute) {
      this.score = score;
      this.minute = minute;
    }

    public int getScore() {
      return score;
    }

    public void setScore(int score) {
      this.score = score;
    }

    public int getMinute() {
      return minute;
    }

    public void setMinute(int minute) {
      this.minute = minute;
    }
  }
}