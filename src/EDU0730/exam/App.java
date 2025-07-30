package EDU0730.exam;
import EDU0730.exam.common.*;


public class App {
    public static void main(String[] args) {
        User person01 = new User();
        person01.setName("12324");
        String getName01 = person01.getName();
        User person02 = new User("홍길동", 15, 200, 150);
        String getName02 = person02.getName();

         System.out.println();
    }
}
