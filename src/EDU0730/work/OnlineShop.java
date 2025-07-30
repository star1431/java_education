package EDU0730.work;
import EDU0730.work.common.*;
import java.util.Scanner;
/**
 * 출력결과 예시
 * 주문번호 : 20240731
 * 주문자 아이디 : abc123
 * 주문 날짜 : 2024년 7월 31일
 * 주문자 이름 : 홍길순 
 * 주문 상품 번호 : PD0345-12
 * 배송 주소 : 서울시 영등포구 여의도동 20번지
 */
public class OnlineShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "UTF-8");
        System.out.println("===== 온라인 쇼핑몰 =====");
        User user = new User();
        Order order = new Order();
        inputUser(scan, user);
        inputOrder(scan, order);
        if(user.getName().equals("dd")) {
            System.out.println("입력된 이름: [" + user.getName() + "]");
        }
        if(user.getName().equals("??")) {
            System.out.println("입력된 이름: [" + user.getName() + "]");
        }
        if(user.getName().equals("정")) {
            System.out.println("입력된 이름: [" + user.getName() + "]");
        }
        outputInfo(user, order);
        System.out.println("입력된 이름: [" + user.getName() + "]");
        scan.close();
    }

    public static void inputUser(Scanner scan, User user) {
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("[안내] 사용자 정보 입력");
        System.out.print("성함 : ");
        String name = scan.nextLine();
        System.out.println("입력된 이름: [" + name + "]");
        System.out.print("아이디 : ");
        String id = scan.nextLine();
        System.out.print("주소 : ");
        String addr = scan.nextLine();
        user.setName(name);
        user.setId(id);
        user.setAddr(addr);
        System.out.println("[결과] 사용자 정보 입력완료!");
    }

    public static void inputOrder(Scanner scan, Order order) {
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("[안내] 주문 정보 입력");
        System.out.print("주문일 : ");
        long date = scan.nextLong();
        scan.nextLine(); // 버퍼 개행 제거
        System.out.print("상품코드 : ");
        String codeStr = scan.nextLine();
        order.setDate(date);
        order.setProduct(codeStr);
        System.out.println("[결과] 주문 입력완료!");
    }
    
    public static void outputInfo(User user, Order order) {
        System.out.println("\n===== 주문 정보 =====");
        System.out.println("주문번호 : " + order.getNumber()); 
        System.out.println("주문자 아이디 : " + user.getId());
        System.out.println("주문 날짜 : " + order.getDateKor());
        System.out.println("주문자 이름 : " + user.getName());
        System.out.println("주문 상품 번호 : " + order.getProduct());
        System.out.println("배송 주소 : " + user.getAddr());
    }
}
