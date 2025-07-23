package EDU0723;
import java.lang.reflect.Method;
/**
 * EDU0723 > Example.java
 * example01 : 조건문 사용해보기
 * example02 : 스위치 사용해보기
 */
public class Example {
    public static void main(String[] args) {
        System.out.println("[EDU0723] Example");
        Example obj = new Example();
        obj.exControl(obj); // 예제 실행
    }

    public void exControl(Example obj) {
        Method[] getObj = Example.class.getMethods();
        int cnt = 0;
        for (int i = 0; i < getObj.length; i++) {
            if (getObj[i].getName().startsWith("example")) cnt++;
        }
        for(int i = 1; i <= cnt; i++) {
            obj.printLine();
            try {
                if(i < 10) {
                    Example.class.getMethod("example0" + i).invoke(obj);
                } else {
                    Example.class.getMethod("example" + i).invoke(obj);
                }
            } catch (Exception e) {
                System.out.println("메서드 호출 오류");
            }
        }
        obj.printLine();
    }

    public void printLine() {
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }
    
    // example01 : 조건문 사용해보기
    public void example01() {
        System.out.println("* [example01] 조건문 사용해보기");
        int age = 121;
        String innerText;

        /**
         * 자바에서 if문은 항상 불리언으로 비교하기 때문에 단순 if (age) { ... } 형태는 불가능 (가능한언어 : C, C++, js)
         */

        if ((age > 0) && (age <= 3)) {
            innerText = "유아";
        } else if (age <= 7) {
            innerText = "유치원생";
        } else if (age <= 13) {
            innerText = "초등학생";
        } else if (age <= 16) {
            innerText = "중학생";
        } else if (age <= 19) {
            innerText = "고등학생";
        } else if (age <= 34) {
            innerText = "성인(청년)";
        } else if (age <= 65) {
            innerText = "성인(중년)";
        } else if (age <= 150) {
            innerText = "노인";
        } else {
            innerText = "유효하지 않은 나이";
        }

        if(innerText != null) {
            final String RESULT_TEXT = "나이: " + age + "세, " + innerText + " 입니다.";
            System.out.println(RESULT_TEXT);
        } else {
            System.out.println("데이터가 없습니다.");
        }
    }

    // example02 : 스위치 사용해보기
    public void example02() {
        System.out.println("* [example02] 스위치 사용해보기");
        int lastYear = 7;
        String familyName ="홍";
        /**
         * 스위치는 정수와 문자열만 케이스로 적용 가능 (실수는 불가, ex: float, double)
         */

        switch (lastYear) {
            case 2:
            case 7:
                System.out.println("끝년도 " + lastYear + "년이며, 지원 가능합니다.");
                break;
            default:
                System.out.println("끝년도 " + lastYear + "년이며, 지원 불가능합니다.");
                break;
        }
        
        switch (familyName) {
            case "정":
            case "홍":
                System.out.println("신청자 성은 " + familyName + "씨이며, 대상자 입니다.");
                break;
            default:
                System.out.println("신청자 성은 " + familyName + "씨이며, 대상자가 아닙니다.");
                break;
        }
    }
}