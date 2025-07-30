package EDU0730;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * EDU0730 > EDU0730.java
 */
public class EDU0730 {
    public static void main(String[] args) {
        System.out.println("[EDU0730] Example");
        EDU0730 obj = new EDU0730();
        obj.exControl(obj); // 예제 실행
    }

    public void exControl(EDU0730 obj) {
        Method[] getObj = EDU0730.class.getMethods();
        int cnt = 0;
        for (int i = 0; i < getObj.length; i++) {
            if (getObj[i].getName().startsWith("example")) cnt++;
        }
        for(int i = 1; i <= cnt; i++) {
            obj.printLine();
            try {
                if(i < 10) {
                    EDU0730.class.getMethod("example0" + i).invoke(obj);
                } else {
                    EDU0730.class.getMethod("example" + i).invoke(obj);
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

    // example01 : 
    public void example01() {
        int [] arr = {7, 1, 4, 3, 8, 9, 2, 5, 10, 6};
        // int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        buubbleSort(arr);

        System.out.println("정렬 : " + java.util.Arrays.toString(arr));
    }

    /** 버블소트 */
    public static void buubbleSort(int[] arr) {
        int swapNum = 0;
        int compCnt = arr.length - 1;
        boolean swapped = false;
        for(int i = 0; i < (arr.length - 1); i++) {
            // 오름차순 정렬
            for(int j = 0; j < compCnt; j++) {
                // 현재인덱스 <-> 다음인덱스 비교하여 다음인덱스가 크면 현재인덱스랑 값 스와핑 
                if(arr[j] > arr[j + 1]) {
                    swapNum = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swapNum;
                    swapped = true;
                }
            }
            if(!swapped) break; // 첫 회전부터 스왑이 안일어났다면 정렬 중단. 
            compCnt--;          // 마지막 인덱스는 이미 정렬되어 있으므로 제외 시킴
        }
    }

    // example02 : 122p
    public void example02() {
        // 1~ 100 사이 3배수
        int num;
        for (num = 1; num < 101; num++) {
            if(num % 3 != 0)
            continue;
            System.out.println(num);
        }
    }
    
    // example03 : 123p
    public void example03() {
        // 입력값 팩토리얼 계산
        // import java.util.Scanner;
        Scanner scan = new Scanner(System.in);
        System.out.print("팩토리얼을 계산할 숫자를 입력하세요: ");
        long num = scan.nextInt();
        long resNum = 1;
        for(int i = 0; i < num; i++) {
            resNum = resNum*(num - i);
        }
        System.out.println(num + " 팩토리얼은 " + resNum + " 입니다.");
    }

}