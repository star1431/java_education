/**
 * Example.java
 */
public class Example {
    public static void main(String[] args) {
        String classTitle = "Example";
        Example obj = new Example();
        System.out.println("[class] " + classTitle);
        obj.printLine();
        obj.example01();
        obj.printLine();
        obj.example02();
        obj.printLine();
        obj.example03();
        obj.printLine();
        obj.example04();
        obj.printLine();
        obj.example05();
        obj.printLine();
        obj.example06();
        obj.printLine();
        obj.example07();
        obj.printLine();
    }
    public void objControl(int data) {
        int objLang = data;
        Example obj = new Example();
        for(int i = 0; i < objLang; i++) {
            if(i < 10) {

            }
        }
    }
    // printLine : 라인 출력 메서드
    public void printLine() {
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }
    
    // example01 : 정수형 사용해보기
    public void example01() {
        System.out.println("* [example01] 정수형 사용해보기");
        int age = 99; // 4byte 정수형
        long money = 1234567890123L; // 8byte 정수형 (L 붙임)
        System.out.println("int age = " + age + ";");
        System.out.println("long money = " + money + "L;");
    }

    // example02 : 실수형 사용해보기
    public void example02() {
        System.out.println("* [example02] 실수형 사용해보기");
        float pie = 3.14f;
        double pie2 = 3.14; // or 3.14d
        System.out.println("float pie = " + pie + "f;");
        System.out.println("double pie2 = " + pie2 + "; // or 3.14d");
        if(pie == pie2) {
            // 어차피 false로 나옴
        } else {
            System.out.println("-> (pie == pie2) if문 결과 : 플룻과 더블 비교시 바이트 달라서 다름");
        }
    }
    
    // example03 : var 사용해보기
    public void example03() {
        System.out.println("* [example03] var 사용해보기");
        var valData0 = 10;      // int 로 컴파일됨
        var valData1 = 10.3;    // double 로 컴파일됨
        var valData2 = "Hello"; // String 으로 컴파일됨
        System.out.println(
            "var valData0 = " + valData0 + ";"
            + "\n" + 
            "var valData1 = " + valData1 + ";"
            + "\n" + 
            "var valData2 = " + valData2 + ";"
            );
        System.out.println("-> 메서드체이닝할때 쓰는거고 일반적으로 숫자 할당하면 안됨");
    }
    
    // example04 : 재할당 및 파이널 사용해보기
    public void example04() {
        System.out.println("* [example04] 재할당 및 파이널 사용해보기");
        int num = 10;
        final int MAX_HOUR = 24;
        System.out.println("num값 기존 : " + num);
        num = 20;
        System.out.println("num값 재할당 : " + num);
        System.out.println("final int MAX_HOUR = " + MAX_HOUR + ";");
        System.out.println("-> 파이널은 const 개념으로 재할당 불가. 파이널쓸때 변수네이밍 대문자로하는게 좋음");
    }

    // example05 : 형변환
    public void example05() {
        System.out.println("* [example05] 형변환 (비권장임!)");
        int num = 10;
        long longNum = num; // int -> long
        float a = 10.3f;
        int k = (int) a; // float -> int (명시적 형변환 필요)
        /*
         * 형변환 ?
         * 1. 작은 타입에서 큰 타입으로는 자동 형변환이 가능하다. ( 같거나 큰 타입)
         * 2. 큰 타입에서 작은 타입으로는 명시적 형변환이 필요하다.
         * -> 왠만하면 형변환 사용x 
         */
        System.out.println("int num = " + num + ";");
        System.out.println("long longNum = num;");
        System.out.println("float a = " + a + ";");
        System.out.println("int k = (int) " + k + ";");
        System.out.println("-> int에서 long은 형변환 자동으로 됨");
        System.out.println("-> 반대로 long을 int 형변환시 에러임. (역 바이트수 차이로 손실 발생 가능성이 있어서)");
    }
    
    // example06 : 사칙연산 및 증감연산
    public void example06() {
        System.out.println("* [example06] 사칙연산 및 증감연산");
        int a = 5;
        int b = 3;
        System.out.println("int a = 5;\nint b = 3;");
        System.out.println("a + b : " + (a + b));
        System.out.println("a - b : " + (a - b));
        System.out.println("a * b : " + (a * b));
        System.out.println("a / b : " + (a / b));
        System.out.println("a % b : " + (a % b));
        System.out.println("++a : " + (++a));
        System.out.println("--b : " + (--b));
        System.out.println("-> 사칙연산은 기본적으로 +, -, *, /, % 사용");
        System.out.println("-> 증감연산은 ++ or -- 이며, ++a (먼저증가) a++ (후에증가)");
    }

    // example07 : 논리연산
    public void example07() {
        System.out.println("* [example07] 논리연산 (교육중)");
        boolean a = 10 > 5; // true
        boolean b = 10 < 5; // false
        System.out.println("boolean a = 10 > 5; // " + a);
        System.out.println("boolean b = 10 < 5; // " + b);
        System.out.println("-> 논리연산 <=, >=, ==, !=, &&, ||, ! 사용");
    }
}