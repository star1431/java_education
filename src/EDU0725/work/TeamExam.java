
package EDU0725.work;
import java.util.Arrays;
import java.util.Random;
/**
 * 팀단위 과제 : 로또번호 만들기
 * 1) 사용자에게 숫자 입력값 받음 (1 ~ 5) -> 게임횟수
 * 2) 1 ~ 45 사이의 랜덤한 숫자 6개를 생성하여 출력
 *  * 단, 게임횟수 만큼 반복 출력
 *  * 번호는 오름차순, 중복없이
*/
public class TeamExam {

    public static void main(String[] args) throws Exception {
        /**
         * 작업 설계
         *  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
         * 프로세스 과정
         * 사용자 <-> 로또티켓(func) <-> 로또번호생성(func)
         *
         *  사용자 입력값 받아 "로또티켓(1~5)" 실행
         *  "로또티켓(1~5)"는 "로또번호생성()" 1~5번 실행 후
         *  리턴 값을 받고서 사용자에게 전달
         *  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
         * 로또티켓 (lottoTicket)
         *  1) 게임 횟수 배열 생성
         *      - 여러개 구매로 int[][] 2차원 배열 활용
         *  
         *  2) 로또번호 생성기 CALL
         *      - 티켓 갯수 만큼 호출 후 2차원 배열에 지정
         *
         *  3) return : 사용자한테 전달
         *  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
         * 로또번호생성 (lottoRandom)
         *  1) 로또번호 생성
         *      - new Random() 객체 사용하여 1 ~ 45 랜덤숫자 생성
         *      - for문 통해 숫자 삽입하되
         *          중복값 있는지 내부 for문으로 순회 확인 후
         *          중복값 제거하고 재 순회하기
         *
         *  2) 로또번호 오름차순 정렬
         *      - 로또번호 생성 이후 정렬
         *          for문 활용하여 요소간 비교하는 내부 for문 작업
         * 
         *  3) return : 로또게임구매(func) 한테 전달
         *  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
         */

        int buy = 5;
        int[][] result = lottoTicket(buy); // 티켓구매

        System.out.println("====== 로또번호 " + buy + " 게임 ======");
        for (int i = 0; i < result.length; i++) {
            // import java.util.Arrays;
            System.out.println("로또 " + (i + 1) + " 게임 : [" + i + "] " + Arrays.toString(result[i]));
        }
    }

    /**
     * lottoTicket : 로또 게임 구매 함수
     * @param cnt 게임 횟수
     * @return (int[][]) 게임 횟수만큼의 로또번호 전달
     */
    public static int[][] lottoTicket(int cnt) {
        if(cnt > 5 || cnt <= 0) {
            System.out.println("입력값 : " + cnt + ", 1 ~ 5 사이의 숫자를 입력해주세요.");
            return new int[0][0];
        } else {
            int[][] ticket = new int[cnt][6];
            /** 
             *  int[cnt][6] 2차원 배열
             *  [cnt]   : [6]
             *  0       : [0, 0, 0, 0, 0, 0] // 1게임
             *  1       : [0, 0, 0, 0, 0, 0] // 2게임
             *  ...
             *  cnt     : [0, 0, 0, 0, 0, 0] // cnt 게임
             */
            for (int i = 0; i < cnt; i++) {
                ticket[i] = lottoRandom();
            }
            return ticket; 
        }
    }

    /**
     * lottoRandom : 로또 번호 생성기
     * @return (int[]) 로또 번호 (6개, 중복없음, 오름차순) 전달
     */
    public static int[] lottoRandom() {
        int[] data = new int[] {0, 0, 0, 0, 0, 0};
        
        // 1) 로또번호 번호 삽입
        // import java.util.Random;
        Random random = new Random();
        int addNum = 0;
        for (int i = 0; i < data.length; i++) {
            // 랜덤 생성 (1 ~ 45)
            addNum = random.nextInt(45) + 1;

            // 요소간 중복값 확인 순회 체크
            for (int j = 0; j < i; j++) {
                if (data[j] == addNum) {
                    i--; // 중복된 경우 다시 최상위 for문 i값 감소시켜서 재 탐색
                    break;
                } 
            }
            
            data[i] = addNum;
        }

        // 2) 삽입완료된 로또번호 오름차순 정렬  
        // ex : {29, 4, 13, 43 , 39, 27} -> {4, 13, 27, 29, 39, 43}
        int swapNum = 0;
        for(int i = 0; i < data.length; i++) {
            // 요소간 숫자크기 순회 체크
            for(int j = 0; j < i; j++) {
                if(data[j] > data[i]) {
                    swapNum = data[j];
                    data[j] = data[i];
                    data[i] = swapNum;
                }
            }
        }

        return data;
    }

}
