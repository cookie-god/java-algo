import java.util.*;

public class Main {
  static int k;
  static String[] arr; // arr비교 위치는 현재 인덱스의 -1에 접근
  static List<String> answerList = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    k = sc.nextInt();
    sc.nextLine();
    arr = sc.nextLine().split(" ");

    for (int i = 0; i <= 9; i++) {
      boolean[] visited = new boolean[10];
      visited[i] = true;
      dfs(i, 1, String.valueOf(i), visited); // 현재 인덱스와 만들어진 숫자 단어
    }

    Collections.sort(answerList);
    System.out.println(answerList.get(answerList.size()-1));
    System.out.println(answerList.get(0));
  }

  static void dfs(int now, int index, String digit, boolean[] visited) {
    if (index == k + 1) { // 조건에 맞는 다면 리턴
      answerList.add(digit);
      return;
    }

    for (int i = 0; i <= 9; i++) {
      if (arr[index-1].equals("<")) {
        if (now < i && !visited[i]) {
          visited[i] = true;
          dfs(i, index+1, digit+i, visited);
          visited[i] = false;
        }
      } else {
        if (now > i && !visited[i]) {
          visited[i] = true;
          dfs(i, index+1, digit+i, visited);
          visited[i] = false;
        }
      }
    }
  }
}