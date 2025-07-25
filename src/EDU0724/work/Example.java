
package EDU0724.work;
/**
 * 문제1 : 데이터의 총합과 평균 ( 30.0, 22.0, 44.2, 345.3, 5.9 )
 * 문제2 : 배열에서 가장 큰 값 (12, 33, 11, 5, 6, 4, 5, 77, 113, 89 ) (*단, 배열의 값은 변경될 수 있음)
 */
public class Example {

    public static void main(String[] args) throws Exception {
        Example obj = new Example();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        obj.example01();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        obj.example02();
    }
    
    // example01 : 문제1
    public void example01() {
        System.out.println("문제1 :데이터의 총합과 평균");
        /**
         * 제공된 데이터    : { 30.0, 22.0, 44.2, 345.3, 5.9 }
         * 배열 총 길이     : 5
         */
        
         double[] dataArr = new double[] { 30.0, 22.0, 44.2, 345.3, 5.9 };
         double total = 0.0;    // 총합
         double avg = 0.0;      // 평균값
         int cnt = 0;           // 인덱스 카운트

         for(int i = 0; i < dataArr.length; i++) {
                total = total + dataArr[cnt];
                cnt++;
         }
         avg = (total / dataArr.length);
         
        System.out.println("총합: " + total);
        System.out.println("평균: " + avg);
    }

    // example02 : 문제2
    public void example02() {
        System.out.println("문제2 : 배열에서 가장 큰 값");
        /**
         * 제공된 데이터    : { 12, 33, 11, 5, 6, 4, 5, 77, 113, 89 }
         * 배열 총 길이     : 10
         */
        int[] dataArr = new int[] { 12, 33, 11, 5, 6, 4, 5, 77, 113, 89 };
        int maxNum = dataArr[0]; // 0 부터 미리 참조
        int minNum = dataArr[0]; // 0 부터 미리 참조
        int cnt = 0;             // 인덱스 카운트

        for(int i = 0; i < dataArr.length; i++) {
            if(dataArr[cnt] > maxNum) {
                maxNum = dataArr[cnt];
            }
            if(dataArr[cnt] < minNum) {
                minNum = dataArr[cnt];
            }
            
            cnt++;
        }

        System.out.println("가장 큰 값: " + maxNum);
        System.out.println("가장 작은 값: " + minNum);
    }
}
