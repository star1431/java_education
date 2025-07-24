
package EDU0723.work;
/**
 * 강사님 풀이
 * 문제1 : 1~50까지 총합 출력하기
 * 문제2 : 1~100까지 짝수 총합을 출력하기
 * 문제3 : 프린트 이용해서 별탑 쌓기 (10층)
 * 문제4 : 구구단 출력하기 (2, 4, 5단)
 */
public class Answer {

    public static void main(String[] args) throws Exception {
        Answer obj = new Answer();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        obj.example01();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        obj.example02();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        obj.example03();
        obj.example03A();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        obj.example04();
    }
    
    // example01 : 문제1 풀이
    public void example01() {
        System.out.println("문제1 : 1~50까지 총합 출력하기");
        /**
         * 작성전 설계
         * 과정         | 횟수
         * ---------------------
         * 0            | 0
         * 0+1          | 1
         * 0+1+2        | 2
         * 0+1+2+3      | 3  
         * 0+ ... +50   | 50
         */
        int data = 1;   // 더할 변수
        int total = 0;  // 최종 결과값

        /**
         * 디버거 브레이크포인트 설정 방법 : F9 (실행>중단점)
         * 단위실행 : F10
         */
        for(int i = 0; i < 50; i++) {
            total = total + data;
            data++;
        }

        System.out.println("1부터 50까지 총합: " + total);
    }

    // example02 : 문제2
    public void example02() {
        System.out.println("문제2 : 1~100까지 짝수 총합을 출력하기");
        /**
         * 작성전 설계
         * 과정         | 횟수
         * ---------------------
         * 0            | 0
         * 0+2          | 1
         * 0+2+4        | 2
         * 0+2+4+6      | 3  
         * 0+ ... +100  | 100
         */
        int data = 1;   // 더할 변수
        int total = 0;  // 최종 결과값
        for(int i = 0; i < 100; i++) {
            if (data % 2 == 0) { // 짝수만 더하기
                total = total + data;
            }
            data = data + 1;   
        }
        System.out.println("1~100까지 짝수 총합: " + total);
    }
    
    // example03 : 문제3
    public void example03() {
        System.out.println("문제3 : 별표 탑 쌓기 (10층)");
        /**
         * 작성전 설계
         * 별갯수       | 횟수
         * ---------------------
         * *            | 1
         * **           | 2
         * ...          | ...
         * **********   | 10
         * 
         * 조건1    : 층수 증가 
         * 조건2    : 층수마다 별 1개씩 증가
         * 설계     : 층 부터 반복문 설계 -> 내부 별갯수 반복문 설계
         */
        int cnt = 1;
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < cnt; j++) {
                System.out.print("*");
            }
            System.out.println();
            cnt++;
        }
    }
    
    // example03A : 문제3A
    public void example03A() {
        System.out.println("문제3A : 별표 피라미드 쌓기 (5층)");
        /**
         * 작성전 설계
         * 별갯수       | 횟수
         * ---------------------
         * ____*            | 1
         * ___***           | 2
         * __*****          | 3
         * _*******         | 4
         * *********        | 5
         * 조건1    : 층수 증가 
         * 조건2    : 층수마다 별 1,3,5.. 홀수 증가
         * 조건3    : 층수마다 앞에 공백 4,3,2,1,0.. 감소
         * 설계     : line반복, 별반복, 공백반복 for문 3개 설계 필요
         *           - 라인최대값,증가값 변수 설정하여 별홀수증가 및 공백갯수 감소시키기
         *
         * [추가설계] 역 피라미드 가능 만들기
         *  - 역 피라미드가 가능할라면 반대 방식 실행이 필요
         *  - 정피라미드 이후 다시 for문으로 역피라미드 설계
         *  - 감가카운팅은 정피라미드 다음 실행해서 해야되므로 최대치보다 1낮은상태에서 반대 적용
         */

        // 피라미드 쌓기
        final int MAX_COUNT = 5;    // 라인 최대치 설정
        int cnt = 1;                // 증가값
        for(int i = 0; i < MAX_COUNT; i++) {
            // 공백 갯수 삽입
            for(int j = 0; j < (MAX_COUNT - cnt); j++) {
                System.out.print(" ");
            }
            // 별 갯수 삽입
            for(int j = 0; j < (cnt*2 - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
            cnt++;
        }
        
        // 역 피라미드 추가해보기
        final int MAX_COUNT2 = MAX_COUNT - 1;   // 역 피라미드 최대치 설정
        int cnt2 = MAX_COUNT2;                  // 역 피라미드 감소값
        for(int i = 0; i < MAX_COUNT; i++) {
            // 공백 갯수 삽입
            for(int j = 0; j < (MAX_COUNT - cnt2); j++) {
                System.out.print(" ");
            }
            // 별 갯수 삽입
            for(int j = 0; j < (cnt2*2 - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
            cnt2--;
        }
    }
    
    // example04 : 문제4
    public void example04() {
        // System.out.println("문제4 : 구구단 출력하기 (2, 4, 5단)");

    }
}
