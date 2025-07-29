package EDU0728;
import java.lang.reflect.Method;
/**
 * EDU0728 > EDU0728.java
 * example01 : 2차원배열
 */
public class EDU0728 {
    public static void main(String[] args) {
        System.out.println("[EDU0728] Example");
        EDU0728 obj = new EDU0728();
        obj.exControl(obj); // 예제 실행
    }

    public void exControl(EDU0728 obj) {
        Method[] getObj = EDU0728.class.getMethods();
        int cnt = 0;
        for (int i = 0; i < getObj.length; i++) {
            if (getObj[i].getName().startsWith("example")) cnt++;
        }
        for(int i = 1; i <= cnt; i++) {
            obj.printLine();
            try {
                if(i < 10) {
                    EDU0728.class.getMethod("example0" + i).invoke(obj);
                } else {
                    EDU0728.class.getMethod("example" + i).invoke(obj);
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

    // example01 : 배열 차원
    public void example01() {
        System.out.println("* [example01] 배열 차원 예시1");

        int[] arr = new int[6]; // 4byte <= 6 * 4byte
        int[][] arr2 = new int[3][6];  // 4byte <= 3 * (6 * 4byte)
        int[][][] arr3 = new int[3][6][2];  // 4byte <= 3 * (6 * (2 * 4byte))
        int[][][][] arr4 = new int[3][6][2][7];  // 4byte <= 3 * (6 * (2 * (7 * 4byte)))
        /**
         * // 1차원
         * [] = {n, n, n, n, n};
         * 
         * // 2차원
         * [][] = {
         *      {n, n}, 
         *      {n, n}, 
         *      {n, n} 
         * };
         * 
         * // 3차원
         * [][][] = {
         *      { {n, n}, {n, n}, {n, n}, {n, n}, {n, n}, {n, n} },
         *      { {n, n}, {n, n}, {n, n}, {n, n}, {n, n}, {n, n} },
         *      { {n, n}, {n, n}, {n, n}, {n, n}, {n, n}, {n, n} }
         * };
         */

        int[] arrT0 = new int[] { 1, 2, 3, 4, 5, 6 };
        int[][] arrT1 = new int[][] { arrT0, arrT0, new int[] {0,0} };
        
        System.out.println("");

    }
    // example01 : 배열 차원
    public void example02() {
        System.out.println("* [example02] 배열 차원 예시2");

        int[] arr1 = new int[] { // = [5];
            1, 2, 3, 4, 5
        };
        int[][] arr2 = new int[][] { // = [3][5];
            { 1, 0, 0, 0, 5 },
            { 0, 2, 0, 4, 0 },
            { 0, 0, 3, 0, 0 }
        };
        int[][][] arr3 = new int[][][] { // = [2][3][5];
            {
                { 1, 0, 0, 0, 5 },
                { 0, 2, 0, 4, 0 },
                { 0, 0, 3, 0, 0 }
            },
            {
                { 1, 0, 0, 0, 5 },
                { 0, 2, 0, 4, 0 },
                { 0, 0, 3, 0, 0 }
            }
        };


    }

}