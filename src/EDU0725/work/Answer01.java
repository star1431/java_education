
package EDU0725.work;
import java.util.Arrays;

/**
 * 문제1 : 정수 짝수 ? 홀수 ? 판단 함수
 * 문제2 : 정수의 제곱을 구하는 함수
 * 문제3 : 같은 크기 배열 2개 입력 받아 두 배열의 각 인덱스끼리 합한 새로운 배열로 리턴하는 함수
 *      ex: {1,2,3,4,5}, {4,5,6,7,8} -> {5,7,9,11,13}
 * 문제4 : 랜덤한 값 6개가 저장된 배열을 리턴하는 함수
 */
public class Answer01 {

    public static void main(String[] args) throws Exception {
        Answer01 obj = new Answer01();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        obj.example01();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        obj.example02();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        obj.example03();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        obj.example04();
    }
    
    /**
     * utilNumType : 홀수,짝수 판단 함수
     * @param num 대상 값
     * @return true : 짝수 | false : 홀수
     */
    public static boolean utilNumType(int num) {
        boolean returnData = false;
        if(num % 2 == 0) {
            returnData = true;
        }
        return returnData;
    }

    /**
     * utilNumSquare : 정수 제곱 함수
     * @param num 대상 값
     * @param cnt 제곱 횟수
     * @return 제곱 계산 값
     */
    public static int utilNumSquare(int num, int cnt) {
        int returnData = 1;
        for(int i = 0; i < cnt; i++) {
            returnData = returnData * num;
        }
        return returnData;
    }
    
    /**
     * utilSumArray : 배열 요소 합산
     * @param arrA 첫번째 배열
     * @param arrB 두번째 배열
     * @return 두 배열의 요소끼리 합한 배열로 출력
     */
    public static int[] utilSumArray(int[] arrA, int[] arrB) {
        
        // 두개 배열 길이가 다른 case 고려하여 적용
        int leng = 0;
        if(arrA.length > arrB.length) {
            leng = arrA.length;
        } else {
            leng = arrB.length;
        }

        int[] returnData = new int[leng];
        int numA = 0;
        int numB = 0;

        for(int i = 0; i < leng; i++) {
            if(i < arrA.length) {
                numA = arrA[i];
            } 
            if(i < arrB.length) {
                numB = arrB[i];
            }
            returnData[i] = numA + numB;
        }
        
        return returnData;
    }
    
    /**
     * utilRandomArray : 랜덤 배열 생성 함수
     * @param min 최소값
     * @param max 최대값
     * @param leng 배열 길이
     * @return min 이상 max 이하의 랜덤 정수로 구성된 배열
     */
    public static int[] utilRandomArray(int min, int max, int leng) {
        int[] returnData = new int[leng];
        for (int i = 0; i < leng; i++) {
            returnData[i] = (int) (Math.random() * (max - min + 1)) + min;
            /** 
             * Math.random()        : 0 ~ 1 사이의 랜덤 값 (실수값 : 0 ~ 0.9999...)
             * (int) Math.random()  : 정수 변환 
             * 예시
             * => (int) (Math.random()*3) => (int) (0.0 ~ 2.9999...) => 0, 1, 2 중 하나
             * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
             * 계산 원리
             * 1. 최소(min) = -9 / 최대(max) = 2 가정 ( -9 ~ 2 범위 )
             *  = (int) (Math.random() * (max - min + 1)) + min
             *  = (int) (0.222 * (2 - (-9) + 1)) + (-9)
             *  = (int) (0.222 * 12) - 9
             *  = (int) (2.664) - 9
             *  = 2 - 9
             *  = -7
             */
        }
        return returnData;
    }


    // example01 : 문제1
    public void example01() {
        System.out.println("문제1 : 정수 짝수 ? 홀수 ? 판단 함수");
        int num1 = 5;
        int num2 = 10;
        System.out.println("num1 = " + num1 + " 짝수 ? -> " + utilNumType(num1));
        System.out.println("num2 = " + num2 + " 짝수 ? -> " + utilNumType(num2));
    }

    // example02 : 문제2
    public void example02() {
        System.out.println("문제2 : 정수의 제곱을 구하는 함수");
        int num = 5;
        System.out.println(num + "^2 은 " + utilNumSquare(num, 2));
        System.out.println(num + "^3 은 " + utilNumSquare(num, 3));
        System.out.println(num + "^4 은 " + utilNumSquare(num, 4));
    }

    // example03 : 문제3
    public void example03() {
        System.out.println("문제3 : 같은 크기 배열 2개 입력 받아 두 배열의 각 인덱스끼리 합한 새로운 배열로 리턴하는 함수");
        // ex: {1,2,3,4,5}, {4,5,6,7,8} -> {5,7,9,11,13}

        int[] arr1 = new int[] {1, 2, 3, 4, 5};
        int[] arr2 = new int[] {4, 5, 6, 7, 8, 9};
        int[] result = utilSumArray(arr1, arr2); //  가비지컬렉션 방지 - 할당

        System.out.println("arr1 와 arr2 요소 합 배열 : " + Arrays.toString(result));
        /**
         * obj.toString()       : 받은 객체를 문자열로 변환
         * Arrays.toString()    : 배열 전용 // [, , , ] 형태로 변환
         * ㅡㅡㅡ
         * 상단에 import java.util.Arrays; 추가 필요 
         */
    }
    // example04 : 문제4
    public void example04() {
        System.out.println("문제4 : 랜덤한 값 6개가 저장된 배열을 리턴하는 함수");
        int min = 1;
        int max = 50;
        // 가비지컬렉션 방지 - 할당
        int[] ranArr01 = utilRandomArray(min, max, 6);
        int[] ranArr02 = utilRandomArray(min, max, 6);
        int[] ranArr03 = utilRandomArray(min, max, 6);
        
        System.out.println("랜덤 배열 1 : " + Arrays.toString(ranArr01));
        System.out.println("랜덤 배열 2 : " + Arrays.toString(ranArr02));
        System.out.println("랜덤 배열 3 : " + Arrays.toString(ranArr03));
    }
}
