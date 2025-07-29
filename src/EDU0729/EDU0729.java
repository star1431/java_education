package EDU0729;
import java.lang.reflect.Method;
import EDU0729.exam.*;
/**
 * EDU0729 > EDU0729.java
 * example01 : 2차원배열
 */
public class EDU0729 {
    public static void main(String[] args) {
        System.out.println("[EDU0729] Example");
        EDU0729 obj = new EDU0729();
        obj.exControl(obj); // 예제 실행
    }

    public void exControl(EDU0729 obj) {
        Method[] getObj = EDU0729.class.getMethods();
        int cnt = 0;
        for (int i = 0; i < getObj.length; i++) {
            if (getObj[i].getName().startsWith("example")) cnt++;
        }
        for(int i = 1; i <= cnt; i++) {
            obj.printLine();
            try {
                if(i < 10) {
                    EDU0729.class.getMethod("example0" + i).invoke(obj);
                } else {
                    EDU0729.class.getMethod("example" + i).invoke(obj);
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

    // example01 : Student.java
    public void example01() {
        System.out.println("* [example01] Student.java");

        Student st1 = new Student(); // 클래스 인스턴스 생성
        // st1.name = "홍길동";
    }
}