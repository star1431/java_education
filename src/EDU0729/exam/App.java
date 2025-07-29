
package EDU0729.exam;

/** App */
public class App {


    public static void main(String[] args) {
        System.out.println("Hello, this is the EDU0729 exam application!");
        
        // 예시로 Student 객체 생성
        Student st1 = new Student(); // 클래스 인스턴스 or 클래스 오브젝트
        st1.name = "홍길동";
        st1.id = 12345;
        st1.addr = "서울시 강남구";
        st1.grade = "A";
        st1.kor = 90;
        st1.eng = 85;
        st1.math = 95;
        st1.total = st1.kor + st1.eng + st1.math; // 총점 계산

        // 학생 정보 출력
        st1.printAll();

        System.out.println("ㅡㅡㅡ");
        // private 변수 접근 예시
        st1.setKor2(80);
        System.out.println("점수2: " + st1.getKor2());




        System.out.println("ㅡㅡㅡ");
        Student01 st01 = new Student01();
        st01.setKor(-999);
        st01.setEng(88);
        st01.setMath(92);
        System.out.println("국어 점수: " + st01.getKor());
        System.out.println("영어 점수: " + st01.getEng());
        System.out.println("수학 점수: " + st01.getMath());
        System.out.println("총점: " + st01.getTotal()); 
    }
}
