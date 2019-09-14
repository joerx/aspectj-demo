package io.yodo.springcourse.aspectjdemo.entity;

public class Account {

    private String name;

    private boolean vip;

    public Account(String name) {
        this.name = name;
        this.vip = false;
    }

    public Account(String name, boolean vip) {
        this.name = name;
        this.vip = vip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", vip=" + vip +
                '}';
    }
}
