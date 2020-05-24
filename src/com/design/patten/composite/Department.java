package com.design.patten.composite;

public class Department extends OrganizationComponent {
    //因为该类是叶子节点，不需要重写add、remove方法

    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    public void print() {
        System.out.println(getName());
    }
}
