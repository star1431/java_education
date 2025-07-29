
package EDU0729.exam;

/**  */
public class Student01 {

    // 기본 생성자 (default constructor)
    public Student01() {
        // class name = constructor name 동일해야함
        System.out.println("Student01 객체가 생성되었습니다.");
    }

    private int kor;
    private int eng;
    private int math;
    private int total;

    public void setKor(int kor) {
        if(kor < 0 || kor > 100) return;
        this.kor = kor;
    }
    public int getKor() {
        return kor;
    }
    public void setEng(int eng) {
        if(eng < 0 || eng > 100) return;
        this.eng = eng;
    }
    public int getEng() {
        return eng;
    }
    public void setMath(int math) {
        if(math < 0 || math > 100) return;
        this.math = math;
    }
    public int getMath() {
        return math;
    }
    public int getTotal() {
        this.total = kor + eng + math;
        return total;
    }
}
