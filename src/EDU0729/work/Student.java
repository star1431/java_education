
package EDU0729.work;
import java.util.HashSet;
import java.util.Set;

/** Student */
/**
 * 1. Getter, Setter 메서드 사용
 * 2. default Constructor 생성
 * 3. 총점 메서드 (getTotal)
 * 4. 평균 메서드 (getAvg) -> 소수점 첫째자리까지 
 * 5. 성적은 0 ~ 100 사이 값
 */
public class Student {

    private String name;    // 이름
    private int id;         // 번호
    private int cls;        // 학년
    private int kor;        // 국어
    private int eng;        // 영어
    private int math;       // 수학
    private int[] scores;   // 성적 배열
    private int total;      // 총점
    private double avg;     // 평균
    
    private static int nextId = 1; // 번호강제할당
    private static Set<Integer> usedIds = new HashSet<>(); // 사용된 번호 집합

    public Student() {
        name    = "";
        id      = 0;
        cls     = 1;
        kor     = 0;
        eng     = 0;
        math    = 0;
        total   = 0;
        avg     = 0.0;

        // System.out.println(nextId);
        this.id = nextId++;
        usedIds.add(this.id);
        // System.out.println(usedIds + "\n" + this.id);
    }

    /** 이름 (get,set) */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        // System.out.println(name + "\n" + this.name);
        // 초기화, 빈값, 길이 
        if(name == null || name.isEmpty() || name.length() < 2) {
            return;
        }
        this.name = name;
    }
    /** 학년 (get,set) */
    public int getCls() {
        return cls;
    }
    public void setCls(int cls) {
        if(cls < 1 || cls > 6) {
            return;
        }
        this.cls = cls;
    }
    /** 번호 (get,set) */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        // 음수이거나 이미 사용된 ID인 경우
        if(id < 0 || usedIds.contains(id)) {
            return;
        }
        usedIds.remove(this.id);  // 기존 ID 제거
        this.id = id;
        usedIds.add(this.id);     // 새 ID 추가
    }

    /** 국어 (get,set) */
    public int getKor() {
        return kor;
    }
    public void setKor(int kor) {
        if(kor < 0 || kor > 100) {
            return;
        }
        this.kor = kor;
    }

    /** 영어 (get,set) */
    public int getEng() {
        return eng;
    }
    public void setEng(int eng) {
        if(eng < 0 || eng > 100) {
            return;
        }
        this.eng = eng;
    }

    /** 수학 (get,set) */
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        if(math < 0 || math > 100) {
            return;
        }
        this.math = math;
    }

    /** 성적 배열 (set) */
    public void setScores() {
        this.scores = new int[] {
            this.kor, this.eng, this.math
        };
    }

    /** 총점 (get) */
    public int getTotal() {
        setScores();
        this.total = 0;
        for(int i = 0; i < scores.length; i++) {
            this.total = total + scores[i];
        }
        return total;
    }

    /** 평균 (get) */
    public double getAvg() {
        setScores();
        if (scores.length == 0) {
            return 0.0;
        }
        System.out.println(scores.length);
        double avg2 = getTotal() / (double) scores.length;
        this.avg = Math.floor(avg2 * 10) / 10.0;
        /**
         * Math.round() : 소수점 첫째자리에서 반올림 / 2.7 -> 3 (long 타입)
         * Math.rint()  : 소수점 첫째자리에서 반올림 / 2.7 -> 3.0 (double 타입)
         * Math.ceil()  : 소수점 이하 올림 / 2.2 -> 3.0
         * Math.floor() : 소수점 이하 내림 / 2.7 -> 2.0
         */
        return avg;
        /** or */
        // int total2 = getTotal();
        // double avg2 = total2 / 3;
        // return ((int)(avg2 * 10)) / 10.0;
    }
}
