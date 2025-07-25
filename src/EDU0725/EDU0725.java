package EDU0725;
import java.lang.reflect.Method;
/**
 * EDU0725 > EDU0725.java
 * example01 : 배열 (Array)
 */
public class EDU0725 {
    public static void main(String[] args) {
        System.out.println("[EDU0724] Example");
        EDU0725 obj = new EDU0725();
        obj.exControl(obj); // 예제 실행
    }

    public void exControl(EDU0725 obj) {
        Method[] getObj = EDU0725.class.getMethods();
        int cnt = 0;
        for (int i = 0; i < getObj.length; i++) {
            if (getObj[i].getName().startsWith("example")) cnt++;
        }
        for(int i = 1; i <= cnt; i++) {
            obj.printLine();
            try {
                if(i < 10) {
                    EDU0725.class.getMethod("example0" + i).invoke(obj);
                } else {
                    EDU0725.class.getMethod("example" + i).invoke(obj);
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

    // example01 : 배열 (Array)
    public void example01() {
        System.out.println("* [example01] 배열 (Array)");
    }
}