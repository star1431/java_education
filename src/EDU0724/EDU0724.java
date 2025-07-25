package EDU0724;
import java.lang.reflect.Method;
/**
 * EDU0724 > EDU0724.java
 * example01 : 배열 (Array)
 * example02 : 총점, 평균 구하기 (Array)
 * example03 : 참조된 메모리 디버깅 확인
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
    
    // example03 : 참조된 메모리 디버깅 확인
    public void example03() {
        System.out.println("* [example03] 참조된 메모리 디버깅 확인");
        
        int[] arr = new int[] {10, 20, 30, 40, 50};        
        // arr  = {10, 20, 30, 40, 50}

        arr[0]  = 11;
        // arr  = {11, 20, 30, 40, 50}

        int[] arr2 = arr; 
        // arr  = {11, 20, 30, 40, 50}
        // arr2 = {11, 20, 30, 40, 50} (같은 메모리 참조됨)

        arr2[0] = 12;
        // arr  = {12, 20, 30, 40, 50} (arr2를 변경했지만 같은 참조를 바라보고있어서 arr도 변경됨)
        // arr2 = {12, 20, 30, 40, 50}

        /**
         * 처음 한번만 카피하고 독립적으로 사용하고 싶은 경우 (deep copy의 개념)
         * 1) clone() 메서드를 사용하여 복사
         *      - clone메서드는 피상적인 복사만 함 
         *      - 배열의 경우 참조만 복사되고 요소 하나하나 복사되는 건 아니라서 요런거는 따로 로직필요
         *      - 구글링 : java 깊은 복사
         *  
         * 2) for문을 사용하여 각 요소를 복사
         */

         int[] arr3 = arr.clone();
         // arr3  = {12, 20, 30, 40, 50 }

         int[] arr4 = new int[arr.length];
         for (int i = 0; i < arr.length; i++) {
             arr4[i] = arr[i];
         }
         // arr4  = {12, 20, 30, 40, 50 }

         arr3[0] = 13;
         // arr1,2 은 그대로
         // arr3  = {13, 20, 30, 40, 50 }

         arr4[0] = 15;
         // arr1,2 은 그대로
         // arr4  = {15, 20, 30, 40, 50 }

         System.out.println("test");
    }
}