package EDU0723;
import java.lang.reflect.Method;

/**
 * EDU0723 > Example.java
 */
public class Example {
    public static void main(String[] args) {
        String classTitle = "Example";
        Example obj = new Example();
        System.out.println("[class] " + classTitle);
        obj.exControl(obj); // 예제 실행
    }

    public void exControl(Example obj) {
        Method[] getObj = Example.class.getMethods();
        int cnt = 0;
        for (int i = 0; i < getObj.length; i++) {
            if (getObj[i].getName().startsWith("example")) {
                // System.out.println(getObj[i].getName());
                cnt++;
            }
        }
        
                System.out.println(cnt);
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
    
    // example01 : 정수형 사용해보기
    public void example01() {
        System.out.println("* [example01] 정수형 사용해보기");
        int age = 99; // 4byte 정수형
        long money = 1234567890123L; // 8byte 정수형 (L 붙임)
        System.out.println("int age = " + age + ";");
        System.out.println("long money = " + money + "L;");
    }
}