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

    // example01 : 배열 랭스
    public void example01() {
        System.out.println("* [example01] 배열 랭스");

        int[] arr = new int[] {
            1, 2, 3, 4, 5,
            6, 7, 8, 9, 10
        };

        System.out.println("배열 길이: " + arr.length);
        for(int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }

    // example02 : 함수
    public void example02() {
        System.out.println("* [example02] 함수");

        int a = 10;
        int b = 20;
        /** public static int add() */
        int result = add(a, b);
        System.out.println("a + b = " + result);
        System.out.println("a + 501 = " + add(a, 501));
        System.out.println("11 + 22 = " + add(11, 22));
    }

    public static int add(int num0, int num1) {
        return num0 + num1; 
        /** or
         *  int result = num0 + num1;
         *  return result;
         */
    }
}