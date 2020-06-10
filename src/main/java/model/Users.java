package model;

import java.util.List;

public class Users {
    private long userId;
    private String name;
    private List<Accounts> accounts;

    public Users() {
    }

    public Users(long userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
