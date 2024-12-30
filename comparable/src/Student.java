public class Student {
  private String name;
  private int korScore;
  private int engScore;
  private int mathScore;

  public Student(String name, int korScore, int engScore, int mathScore) {
    this.name = name;
    this.korScore = korScore;
    this.engScore = engScore;
    this.mathScore = mathScore;
  }

  public String getName() {
    return name;
  }

  public int getKorScore() {
    return korScore;
  }

  public int getEngScore() {
    return engScore;
  }

  public int getMathScore() {
    return mathScore;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setKorScore(int korScore) {
    this.korScore = korScore;
  }

  public void setEngScore(int engScore) {
    this.engScore = engScore;
  }

  public void setMathScore(int mathScore) {
    this.mathScore = mathScore;
  }
}
