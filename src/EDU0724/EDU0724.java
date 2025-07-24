package EDU0724;
import java.lang.reflect.Method;
/**
 * EDU0724 > EDU0724.java
 * example01 : 배열 (Array)
 */
public class EDU0724 {
    public static void main(String[] args) {
        System.out.println("[EDU0724] Example");
        EDU0724 obj = new EDU0724();
        obj.exControl(obj); // 예제 실행
    }

    public void exControl(EDU0724 obj) {
        Method[] getObj = EDU0724.class.getMethods();
        int cnt = 0;
        for (int i = 0; i < getObj.length; i++) {
            if (getObj[i].getName().startsWith("example")) cnt++;
        }
        for(int i = 1; i <= cnt; i++) {
            obj.printLine();
            try {
                if(i < 10) {
                    EDU0724.class.getMethod("example0" + i).invoke(obj);
                } else {
                    EDU0724.class.getMethod("example" + i).invoke(obj);
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
        int kor     = 86;
        int eng     = 77;  
        int math    = 90; 
        
        int[] intArr = {kor, eng, math};
        String[] strArr = {"안녕", "하세요"};
        
        int[] scoreArr = new int[5];
        scoreArr[3] = 100;
        
        String[] textArr = new String[5];
        textArr[0] = "hi";

        double[] doubleArr = new double[] {
            1.0, 
            2.0, 
            3.0, 
            4.0, 
            5.0
        };
        doubleArr[0] = doubleArr[0] + 1;

        System.out.println("test");
    }

    // example02 : 총점, 평균 구하기 (Array)
    public void example02() {
        System.out.println("* [example02] 총점, 평균 구하기");
        int kor     = 86;
        int eng     = 77;  
        int math    = 90; 
        int[] examArr = new int[3];
        
        examArr[0] = kor;
        examArr[1] = eng;
        examArr[2] = math;

        int total = 0;
        int average = 0;
        for(int i = 0; i < examArr.length; i++) {
            total = total + examArr[i];
        }

        average = (total / examArr.length);

        System.out.println("총점: " + total);
        System.out.println("평균: " + average);
    }

}