import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int p = sc.nextInt();
    int answer = 0;
    List<Stack<Integer>> stacks = new ArrayList<>();
    for (int i = 0; i <= 6; i++) {
      stacks.add(new Stack<>());
    }

    for (int i = 0; i < n; i++) {
      int line = sc.nextInt();
      int fret = sc.nextInt();

      while (!stacks.get(line).isEmpty() && stacks.get(line).peek() > fret) { // 비어있거나 스택 최상단이 현재 fret보다 높은 경우 쭉 빼야함
        stacks.get(line).pop();
        answer++;
      }

      if (stacks.get(line).isEmpty() || stacks.get(line).peek() < fret) { // 스택이 비어있거나 현재 스택 최상단이 fret보다 작은 경우만 그러나 위의 조건으로 != 으로 해도 됨
        stacks.get(line).push(fret);
        answer++;
      }
    }
    System.out.println(answer);
  }
}