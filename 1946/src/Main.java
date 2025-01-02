import java.util.*;


public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    for (int i = 0; i < t; i++) {
      int n = sc.nextInt(); // 면접자 수

      int answer = 0; // 합격자 수
      int minY = 0; // 최소 면접 등수
      List<Grade> grades = new ArrayList<>();

      for (int j = 0; j < n; j++) {
        int x = sc.nextInt(); // 서류
        int y = sc.nextInt(); // 면접
        grades.add(new Grade(x, y));
      }

      Collections.sort(grades, Comparator.comparingInt(o -> o.x));

      answer = 1; // 서류 1등은 합격
      minY = grades.get(0).y;
      for (int j = 1; j < n; j++) {
        if (grades.get(j).y < minY) { // 면접 등수가 더 높다면
          answer++; // 합격자 인정
          minY = grades.get(j).y; // 합격 최소 면접 등수 변경
        }
      }
      System.out.println(answer);
    }
  }

  public static class Grade {
    int x;
    int y;

    public Grade(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}