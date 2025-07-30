package EDU0730.work.common;
public class User {
    private String name;
    private String id;
    private String addr;

    public User() {
        name    = "unknown";
        id      = "unknown";
        addr    = "unknown";
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public String getAddr() {
        return this.addr;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", id=" + id + ", addr=" + addr + "]";
    }
}
