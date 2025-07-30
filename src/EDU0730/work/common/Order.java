package EDU0730.work.common;

public class Order {
    private long number;        // 주문 번호
    private long date;          // 주문 날짜
    private String product;     // 상품 ID
    private String dateKor;     // 주문 날짜 형식화

    public Order() {
        number      = 0;
        date        = 0;
        product     = "unknown";
        dateKor     = "unknown";
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getNumber() {
        this.number = this.date;
        return this.number;
    }
    
    public String getDateKor() {
        this.dateKor = dateFormat(this.date);
        return this.dateKor;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProduct() {
        return this.product;
    }
    
    /** int YYYYMMDD => YYYY년 M월 D일  */
    public static String dateFormat(long date) {
        String dateStr = String.valueOf(date);
        if (dateStr.length() != 8) {
            return "ERROR!";
        }
        String year = dateStr.substring(0, 4);
        int month = Integer.parseInt(dateStr.substring(4, 6));
        int day = Integer.parseInt(dateStr.substring(6, 8));

        String sumStr = year + "년 " + month + "월 " + day + "일";
        return sumStr;
    }
    @Override
    public String toString() {
        return "Order [number=" + number + ", date=" + date + ", product=" + product + ", dateKor=" + dateKor + "]";
    }
}
