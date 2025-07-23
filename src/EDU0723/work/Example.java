
package EDU0723.work;
/**
 * 문제1 : 1~50까지의 합 출력하기
 * 문제2 : 1~100까지의 수중에서 짝수 합을 출력하기.
 * 문제3 : 프린트 이용해서 별탑 쌓기 (10층)
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
    }
    // example01 : 문제1
    public void example01() {
        System.out.println("* 문제1 : 1~50까지의 합 출력하기");
        int total = 0;
        for(int i = 1; i <= 50; i++) {
            total = total + i;
        }
        System.out.println("1부터 50까지의 합: " + total);
    }

    // example02 : 문제2
    public void example02() {
        System.out.println("* 문제2 : 1~100까지의 수중에서 짝수 합을 출력하기");
        int total = 0;
        for(int i = 1; i <= 100; i++) {
            if(i % 2 == 0) {
                total = total + i;
            }
        }
        System.out.println("1부터 100까지의 짝수 합: " + total);
    }
    
    // example03 : 문제3
    public void example03() {
        System.out.println("* 문제3 : 별표 탑 쌓기 (10층)");
        String star = "*";
        for(int i = 0; i < 10; i++) {
            System.out.println(star);
            star = star + "*";
        }
    }
}
