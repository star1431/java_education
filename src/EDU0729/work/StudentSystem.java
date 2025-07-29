
package EDU0729.work;
import java.util.Scanner;
import java.util.ArrayList;

/** Setup */
public class StudentSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        System.out.println("[StudentSystem] 학생 추가 시스템");
        // inputField에서 학생 정보 입력받아서 반환
        Student stu = inputField(scan);
        studentList.add(stu);
        System.out.println("\n=== 입력된 학생 정보 ===");
        studentInfo(stu);

        boolean isContinue = true;
        while (isContinue) {
            System.out.print("\n[안내] 추가 학생 정보를 입력하시겠습니까? (y/n) \n입력 : ");
            String choice = scan.nextLine();
            if(choice.equals("y")) {
                Student addStu = inputField(scan);
                studentList.add(addStu);
                System.out.println("\n=== 입력된 학생 정보 ===");
                studentInfo(addStu);
            } else {
                isContinue = false;
            }
        }
        System.out.println("\n[안내] 모든 학생 정보 입력이 완료되었습니다.");
        System.out.println("\n======= 전체 학생 정보 =======");
        for (int i = 0; i < studentList.size(); i++) {
            Student resStu = studentList.get(i);
            System.out.println("\n=== " + (i + 1) + " 번째 학생 ===");
            studentInfo(resStu);
            System.out.println("====== End ======");
        }
        scan.close();
    }

    /**
     * 학생 정보 입력 폼
     * @param scan Scanner 객체
     * @return Student 객체
     */
    public static Student inputField(Scanner scan) {
        Student stu = new Student();
        System.out.println("=== 다음 항목 입력해주세요. ===");

        System.out.print("이름: ");
        String name = scan.nextLine();
        stu.setName(name);
        
        System.out.print("학년: ");
        int cls = scan.nextInt();
        stu.setCls(cls);
        
        System.out.print("국어: ");
        int kor = scan.nextInt();
        stu.setKor(kor);
        
        System.out.print("영어: ");
        int eng = scan.nextInt();
        stu.setEng(eng);
        
        System.out.print("수학: ");
        int math = scan.nextInt();
        stu.setMath(math);

        scan.nextLine(); // 버퍼
        
        System.out.println("=== 입력 완료! ===");
        return stu;
    }
    /**
     * 학생 정보 출력
     * @param stu 학생 정보
     */
    public static void studentInfo(Student stu) {
        System.out.println("이름 : " + stu.getName());
        System.out.println("ID : " + stu.getId());
        System.out.println("학년 : " + stu.getCls());
        System.out.println("국어 : " + stu.getKor());
        System.out.println("영어 : " + stu.getEng());
        System.out.println("수학 : " + stu.getMath());
        System.out.println("총점 : " + stu.getTotal());
        System.out.println("평균 : " + stu.getAvg());
    }
}
