
package EDU0729.exam;

/** 학생 정보를 저장하는 클래스 */
public class Student {

    /**
     * 다른 java 파일에서 이 클래스를 사용하려면 new 키워드로 인스턴스를 생성해야 함
     * new로 생성된 객체(인스턴스)는 HEAP 영역에 저장됨
     * 객체 내의 모든 변수들도 해당 객체와 함께 HEAP 영역에 저장됨 
     *  - primitive 타입이든 reference 타입이든 상관없이 모두 HEAP에 저장
     * 
     * STACK 영역에는 지역변수와 메서드 호출 정보만 저장됨
     */

    String name;                // 학생 이름
    int id;                     // 학생 ID
    String addr;                // 학생 주소
    String grade;               // 학생 등급
    int kor;                    // 국어 점수
    int eng;                    // 영어 점수
    int math;                   // 수학 점수
    int total;                  // 총점


    /** 학생 정보 각각 출력 */
    void printAll() {
        System.out.println("===== 학생 정보 =====");
        System.out.println("학생 이름: " + name);
        System.out.println("학생 ID: " + id);
        System.out.println("학생 주소: " + addr);
        System.out.println("학생 등급: " + grade);
        System.out.println("국어 점수: " + kor);
        System.out.println("영어 점수: " + eng);
        System.out.println("수학 점수: " + math);
        System.out.println("점수 총합: " + total);
        System.out.println("======= END =======");
    }
    
    public int age;             // 나이         (public 변수로 외부 접근 허용)
    private int kor2;           // 점수2    (private 변수로 외부 접근 제한)

    /**
     * getKor2 : getter 메서드
     * @return kor2
     */
    public int getKor2() { // getter
        return kor2;          // 학교 정보 반환
    }
    /**
     * setKor2 : setter 메서드
     * @param kor2
     */
    public void setKor2(int kor2) {
        /**
         * this : 현재객체 참조 (Student 클래스의 인스턴스)
         */
        this.kor2 = kor2;   // 학교 정보 설정
    }
}
