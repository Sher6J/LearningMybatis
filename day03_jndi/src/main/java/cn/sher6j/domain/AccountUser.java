package cn.sher6j.domain;

/**
 * 主表从表对应的实体类的联系类
 * 此种方法几乎不用
 * 应该通过主表和从表建立联系
 * @author sher6j
 * @create 2020-04-12-17:46
 */
public class AccountUser extends Account{

    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + "     AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
