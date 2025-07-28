
package EDU0728.exam;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 로또 번호 만들기 예제
 * 1) 1 ~ 45 사이의 랜덤한 숫자 6개를 생성
 * 2) 중복된 숫자는 제외하고, 오름차순으로 정렬
 * 3) 로또 번호를 n게임 생성
 */
public class LottoTicket {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
    
        // 게임 수 입력받기
        System.out.println("===== Lotto 구매 =====");
        int games = 0;
        boolean buyValid = true;
        while (buyValid) {
            System.out.print("구매할 횟수 입력해주세요. (1 ~ 5) \n입력 : ");
            games = scan.nextInt();
            if(games < 1 || games > 5) {
                System.out.println("ERROR! (입력값 : " + games + ")\n안내 : 1 ~ 5 사이의 숫자를 입력해주세요.");
            } else {
                buyValid = false;
            }
        }

        // 로또 게임 배열 생성
        int[][] result = new int[games][6];
        
        for (int i = 0; i < games; i++) {
            result[i] = makeLotto();
            System.out.println( (i + 1) + "게임 = " + Arrays.toString(result[i]));
        }

    }
    
    /**
     * makeLotto : 로또 번호 생성
     * @return (int[]) 6개의 로또 번호 배열
     */
    public static int[] makeLotto() {
        int[] data = new int[6];
        Random random = new Random();
        int index = 0;
        int addNum = 0;
        boolean isBreak = false;
        String type = "asc";

        // 6개의 랜덤번호 생성
        while(index < data.length) {
            // 랜덤번호 할당
            addNum = random.nextInt(45) + 1;
            
            // 중복체크
            isBreak = isBreak(data, addNum);

            // 중복이 아니면 데이터에 추가
            if(isBreak == false) {
                data[index] = addNum;
                index++;
            }
        }

        // 오름차순 정렬
        data = arraySort(data, type);

        return data;
    }

    /**
     * isBreak : 숫자중복 체크
     * @param data - 배열 데이터
     * @param addNum - 비교대상 정수
     * @return (boolean) 중복 여부
     */
    public static boolean isBreak(int[] data, int addNum) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == addNum) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * arraySort : 배열 정렬
     * @param data - 배열 데이터
     * @param type - 정렬 타입 (오름: "asc", 내림: "desc")
     * @return (int[]) 정렬된 배열
     */
    public static int[] arraySort(int[] data, String type) {
        int[] sortData = data;
        int swapNum = 0; 

        for(int i = 0; i < sortData.length; i++) {
            // 오름차순 정렬
            if(type == "asc") {
                // 내장 lib
                // Arrays.sort(sortData);

                // 알고리즘 - 버블정렬
                for(int j = 0; j <(sortData.length - i - 1); j++) {
                    if(sortData[j] > sortData[j + 1]) {
                        swapNum = sortData[j];
                        sortData[j] = sortData[j + 1];
                        sortData[j + 1] = swapNum;
                    }
                }
            }
            if(type == "desc") {
                // 알고리즘 - 버블정렬
                for(int j = 0; j < (sortData.length - i - 1); j++) {
                    if(sortData[j] < sortData[j + 1]) {
                        swapNum = sortData[j];
                        sortData[j] = sortData[j + 1];
                        sortData[j + 1] = swapNum;
                    }
                }
            }

        }

        return sortData;
    }
}
