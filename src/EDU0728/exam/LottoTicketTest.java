
package EDU0728.exam;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 로또 번호 만들기 예제 - 심화 작업중
 * 자동, 반자동, 수동 선택 기능 추가 - (작업중)
 */
public class LottoTicketTest {


    public static void main(String[] args) throws Exception {
    
        // 게임 수 입력받기
        System.out.println("===== Lotto 구매 =====");
        int games = 0;
        boolean buyValid = true;
        while (buyValid) {
            System.out.print("[안내] 구매할 횟수 입력해주세요. (1 ~ 5) \n입력 : ");
            games = (int) inputValue("int");
            if(games < 1 || games > 5) {
                System.out.println("[ERROR!] (입력값 : " + games + ")\n[안내] 1 ~ 5 사이의 숫자를 입력해주세요.");
            } else {
                buyValid = false;
            }
        }

        // 로또 게임 배열 생성
        int[][] result = new int[games][6];

        // 게임 타입 선택
        int gameType = 0;
        for (int i = 0; i < games; i++) {
            System.out.println("\n===== " + (i + 1) + "번째 게임 번호선택 방식 =====");
            boolean typeValid = true;
            while (typeValid) {
                System.out.print("[안내] 번호선택 방법을 정해주세요. (1:자동, 2:반자동, 3:수동) \n입력 : ");
                gameType = (int) inputValue("int");
                if(gameType < 1 || gameType > 3) {
                    System.out.println("[ERROR!] (입력값 : " + gameType + ")\n[안내] 1, 2, 3 중에서 선택해주세요.");
                } else {
                    switch (gameType) {
                        case 1:
                            System.out.println("자동 선택 완료!");
                            result[i] = makeLotto(gameType);
                            break;
                        case 2:
                            System.out.print("반자동 번호를 입력하세요. (예: 1,2,3) \n입력 : ");
                            String inputVal = (String) inputValue("string");
                            inputVal = inputVal.replaceAll(" ", ""); // 공백 제거
                            String[] strArr = inputVal.split(",");
                            int[] testArr = stringToIntArray(strArr);
                            System.out.println("입력된 번호: " + Arrays.toString(testArr));
                            result[i] = makeLotto(1); // 로직미구현 자동번호로 대체
                            break;
                        case 3:
                            System.out.print("수동 번호를 입력하세요. (예: 1,2,3,5,6) \n입력 : ");
                            String inputVal2 = (String) inputValue("string");
                            result[i] = makeLotto(1); // 로직미구현 자동번호로 대체
                            break;
                    
                        default:
                            System.out.println("ERROR! (입력값 : " + gameType + ")\n안내 : 1, 2, 3 중에서 선택해주세요.");
                            return;
                    }
                    typeValid = false;
                }
            }
        }
        
        System.out.println("\n===== " + games + "장 로또구매 완료! =====");
        for (int i = 0; i < games; i++) {
            System.out.println( (i + 1) + "게임 = " + Arrays.toString(result[i]));
        }

    }

    /**
     * makeLotto : 로또 번호 생성 함수
     * @param gameType - 게임 타입 (1:자동, 2:반자동, 3:수동)
     * @return (int[]) 6개의 로또 번호 배열
     */
    public static int[] makeLotto(int gameType) {
        int[] data = new int[6];
        String type = "asc";
        
        if(gameType == 1) { 
            // 자동
            data = randomNumber();
        } 
        else if (gameType == 2 || gameType == 3) {
            // 반자동, 수동
            // data = chooseNumber(gameType);
        }

        // 오름차순 정렬
        data = arraySort(data, type);

        return data;
    }
    
    /**
     * randomNumber : 로또 번호 자동 생성     
     * @return (int[]) 6개의 로또 번호 배열
     */
    public static int[] randomNumber() {
        int[] data = new int[6];
        Random random = new Random();
        int index = 0;
        int addNum = 0;
        boolean isBreak = false;

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
        data = arraySort(data, "asc");

        return data;
    }


    /**
     * chooseNumber : 로또 번호 선택
     * @param gameType
     * @return (int[]) 6개의 로또 번호 배열
     */
    public static int[] chooseNumber(int gameType) {
        int[] data = new int[6];
        // if(gameType == 3) {}
        // 오름차순 정렬
        data = arraySort(data, "asc");
        
        return data;
    }
    
    /**
     * inputValue : 스캐너 별도관리용
     * @param type - 입력 타입 (string, int)
     * @return (Object) 입력값
     */
    public static Object inputValue(String type) {
        Scanner inputScan = new Scanner(System.in);
        if(type.equals("string")) {
            try {
                String input = inputScan.nextLine();
                inputScan.close();
                return input;
            } catch (Exception e) {
                inputScan.next(); // 잘못된 입력을 스킵
                return null;
            } finally {
                inputScan.close();
            }
        } else if(type.equals("int")) {
            try {
                int input = inputScan.nextInt();
                return input;
            } catch (Exception e) {
                inputScan.next(); // 잘못된 입력을 스킵
                return -505;
            } finally {
                inputScan.close();
            }
        }

        inputScan.close();
        return null;
    }
    
    /**
     * stringToIntArray : 문자열을 정수 배열로 변환
     * @param strArr
     * @return
     */
    public static int[] stringToIntArray(String[] strArr) {
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
             intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
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

