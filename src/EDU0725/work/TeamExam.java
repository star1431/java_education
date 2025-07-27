
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
         * 기능 설계
         *  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
         * 프로세스 과정
         * 사용자 <-> 로또티켓(func) <-> 랜덤번호생성(func)
         *
         *  사용자 입력값 받아 "로또티켓(func)" 실행
         *  "로또티켓(func)"에서 "랜덤번호생성(func)" 호출하여 횟수만큼 번호받고 사용자에게 전달
         *  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
         * 로또티켓 | func : lottoTicket(int 숫자)
         *  1) 게임 횟수만큼 배열 생성
         *  2) 랜덤번호생성(func) CALL 후 횟수만큼 배열에 저장
         *  3) return : 사용자한테 전달
         *  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
         * 랜덤번호생성 | func : lottoRandom()
         *  1) 랜덤번호 생성
         *  2) 랜덤번호 오름차순 정렬
         *  3) return : 로또티켓(func) 한테 전달
         *  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
         */

        int buy = 5;
        if(buy < 1 || buy > 5) {
            System.out.println("입력값 : " + buy + ", 1 ~ 5 사이의 숫자를 입력해주세요.");
            return;
        }

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
        int[][] ticket = new int[cnt][6];
        /** 
         *  int[cnt][6] 2차원 배열
         * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
         *  세로[cnt] : 가로[6]
         * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
         *  int[cnt][6] = {
         *      {0, 0, 0, 0, 0, 0}, // 1 게임
         *      {0, 0, 0, 0, 0, 0}, // 2 게임
         *      ...
         *      {0, 0, 0, 0, 0, 0}, // cnt 게임
         *  }
         *  
         */
        for (int i = 0; i < cnt; i++) {
            ticket[i] = lottoRandom();
        }
        return ticket; 
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
                    addNum = -1;
                    break;
                } 
            }
            if (addNum == -1) {
                i--; 
            } else {
                data[i] = addNum;
            }
        }

        // 2) 삽입완료된 로또번호 오름차순 정렬  
        // ex : {29, 4, 13, 43 , 39, 27} -> {4, 13, 27, 29, 39, 43}
        int swapNum = 0;
        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < (data.length - i - 1); j++) {
                if(data[j] > data[j + 1]) {
                    swapNum = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = swapNum;
                }
            }
            /*
            * 오름차순 버블 정렬
            * 인접한 요소끼리 비교하여 큰 값을 인덱스 높은 쪽으로 변경
            * 
            * 예시)
            *  [22, 5, 29, 1 , 8, 15]
            *  i = 0 | 1회전
            *  j = 0 | (22 <-> 5), 29, 1, 8, 15 = [5, 22, 29, 1, 8, 15]
            *  j = 1 | 5, (22 <-> 29), 1, 8, 15 = [5, 22, 29, 1, 8, 15]
            *  j = 2 | 5, 22, (29 <-> 1), 8, 15 = [5, 22, 1, 29, 8, 15]
            *  j = 3 | 5, 22, 1, (29 <-> 8), 15 = [5, 22, 1, 8, 29, 15]
            *  j = 4 | 5, 22, 1, 8, (29 <-> 15) = [5, 22, 1, 8, 15, 29]
            * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
            *  i = 1 | 2회전
            *  j = 0 | (5 <-> 22), 1, 8, 15, 29 = [5, 22, 1, 8, 15, 29]
            *  j = 1 | 5, (22 <-> 1), 8, 15, 29 = [5, 1, 22, 8, 15, 29]
            *  j = 2 | 5, 1, (22 <-> 8), 15, 29 = [5, 1, 8, 22, 15, 29]
            *  j = 3 | 5, 1, 8, (22 <-> 15), 29 = [5, 1, 8, 15, 22, 29]
            * 
            * (data.length - i - 1) 
            * data.length 전체 배열 크기 (6)
            * (- 1) : 배열 인덱스는 0부터 시작하면서 [j + 1]과 비교할 때 마지막 인덱스를 피하기 위함
            * (- i) : 매 회전마다 가장 큰 값이 맨뒤로 정렬되어 있으므로 마지막 인덱스는 비교할 필요없음
            * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
            */
        }

        return data;
    }

}
