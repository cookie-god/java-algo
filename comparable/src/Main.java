import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Student> classRoom = new ArrayList<>();
    classRoom.add(new Student("김철수", 80, 60, 40));
    classRoom.add(new Student("나영희", 90, 80, 60));
    classRoom.add(new Student("다람쥐", 80, 60, 60));

    Collections.sort(classRoom, new Comparator<>() {
      @Override
      public int compare(Student s1, Student s2) {
        if (s1.getKorScore() != s2.getKorScore()) {
          return s2.getKorScore() - s1.getKorScore();
        } else if (s1.getEngScore() != s2.getEngScore()) {
          return s2.getEngScore() - s1.getEngScore();
        } else {
          return s2.getMathScore() - s1.getMathScore();
        }
      }
    });

    for (Student student: classRoom) {
      System.out.println(student.getName());
    }
  }
}