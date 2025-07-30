package EDU0730.exam.common;

public class User {
    private String name;
    private long level;
    private int life;
    private int mana;

    public User() {
        name    = "NULL";
        level   = 1;
        life    = 100;
        mana    = 50;
    }

    /** 
     * 다형성 - overloading 
     * @param () 생략
     * 설명
     * 1. 생성자 오버로딩은 같은 이름의 생성자를 여러 개 정의하는 것을 의미
     * 2. 매개변수 유형과 개수를 다르게 사용 가능
     * 3. 과하게 사용 x
     * 
    */
    public User(String name, long level, int life, int mana) {
        this.name = name;
        this.level = level;
        this.life = life;
        this.mana = mana;
    }

    public void setName(String name) {
        if(name.isBlank()) return;
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
