package com.design.patten.composite;

public abstract class OrganizationComponent {
    private String name;//名字
    private String des; //描述

    public void add(OrganizationComponent organizationComponent){

        throw new UnsupportedOperationException();
    }

    public void remove(OrganizationComponent organizationComponent){

        throw new UnsupportedOperationException();
    }

    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public abstract void print();
}
