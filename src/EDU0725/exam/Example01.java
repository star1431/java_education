
package EDU0725.exam;
/**
 * 문제1 :
 * 1) 배열 하나를 만들기 ( int[5] { 30, 20, 30, 40, 33 } )
 * 2) 배열의 합을 구하는 함수
 */
public class Example01 {

    public static void main(String[] args) throws Exception {

        // 1) 배열 하나를 만들기
        int[] dataArr = { 30, 20, 30, 40, 33 };
        System.out.println("배열의 합 :" + sumArray(dataArr));
    }
    
    public static int sumArray(int[] array) {
        int data = 0; 
        for(int i= 0; i < array.length; i++) {
            data = data + array[i];
        }
        return data;
    }
}
