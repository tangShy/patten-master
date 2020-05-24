package com.design.patten.composite;

import java.util.ArrayList;
import java.util.List;

public class University extends OrganizationComponent {
    //list中存放的是 College
    List<OrganizationComponent> organizationComponentList = new ArrayList<OrganizationComponent>();

    public University(String name, String des) {
        super(name, des);
    }

    @Override
    public void add(OrganizationComponent organizationComponent) {
        organizationComponentList.add(organizationComponent);
    }

    @Override
    public void remove(OrganizationComponent organizationComponent) {
        organizationComponentList.remove(organizationComponent);
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
        System.out.println("-----------"+getName()+"---------------");
        for(OrganizationComponent organizationComponent : organizationComponentList){
            organizationComponent.print();
        }

    }
}
