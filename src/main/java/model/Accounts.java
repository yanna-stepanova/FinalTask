package model;

import java.util.Date;
import java.util.List;

public class Accounts {
    private long acctId;
    private Users users;
    private double money;
    private Date date;

    public Accounts(long acctId, Users users, Date date) {
        this.acctId = acctId;
        this.users = users;
        this.date = date;
    }

    public long getAcctId() {
        return acctId;
    }

    public void setAcctId(long acctId) {
        this.acctId = acctId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "acctId=" + acctId +
                ", users=" + users +
                ", money=" + money +
                ", date=" + date +
                '}';
    }
}
