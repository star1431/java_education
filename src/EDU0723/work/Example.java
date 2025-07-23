
package EDU0723.work;
/**
 * 문제1 : 1~50까지 총합 출력하기
 * 문제2 : 1~100까지 짝수 총합을 출력하기
 * 문제3 : 프린트 이용해서 별탑 쌓기 (10층)
 * 문제4 : 구구단 출력하기 (2, 4, 5단)
 */
public class Example {

    public static void main(String[] args) throws Exception {
        Example obj = new Example();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        obj.example01();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        obj.example02();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        obj.example03();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        obj.example04();
    }
    // example01 : 문제1
    public void example01() {
        System.out.println("문제1 : 1~50까지 총합 출력하기");

        // 루프 변수 사용 (권장 X)
        // int total = 0;
        // for(int i = 1; i <= 50; i++) {
        //     total = total + i;
        // }
        // System.out.println("1부터 50까지의 합: " + total);

        // 루프 변수 미사용 (권장 O)
        int total = 0;
        int num = 0;
        for(int i = 0; i < 50; i++) {
            num++;
            total = total + num;
        }
        System.out.println("1부터 50까지 총합: " + total);
    }

    // example02 : 문제2
    public void example02() {
        System.out.println("문제2 : 1~100까지 짝수 총합을 출력하기");

        // 루프 변수 사용 (권장 X)
        // int total = 0;
        // for(int i = 1; i <= 100; i++) {
        //     if(i % 2 == 0) {
        //         total = total + i;
        //     }
        // }
        // System.out.println("1부터 100까지의 짝수 합: " + total);

        // 루프 변수 미사용 (권장 O)
        int total = 0;
        int num = 0;
        for (int i = 0; i < 100; i++) {
            num++;
            if(num % 2 == 0) {
                total = total + num;
            }
        }
        System.out.println("1~100까지 짝수 총합: " + total);
    }
    
    // example03 : 문제3
    public void example03() {
        System.out.println("문제3 : 별표 탑 쌓기 (10층)");
        String star = "*";
        for(int i = 0; i < 10; i++) {
            System.out.println(star);
            star = star + "*";
        }
    }
    
    // example04 : 문제4
    public void example04() {
        System.out.println("문제4 : 구구단 출력하기 (2, 4, 5단)");
        int resultNum = 0;  // 결과 값
        int step = 0;       // 단
        int num = 0;        // 곱셈 수
        for(int i = 0; i < 9; i++) {
            step++; 
            num = 0;
            switch (step) {
                case 2:
                case 4:
                case 5:
                    System.out.println("---[" + step + "단]---");
                    for(int j = 0; j < 9; j++) {
                        num++;
                        resultNum = step * num;
                        System.out.println(step + " x " + num + " = " + resultNum);
                    }
                    System.out.println("-----------");
                    break;
                default:
                    break;
            }
        }
    }
}
