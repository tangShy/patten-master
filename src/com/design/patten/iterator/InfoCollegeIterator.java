package com.design.patten.iterator;

import java.util.Iterator;
import java.util.List;

public class InfoCollegeIterator implements Iterator {
    List<Department> departments;  //信息学院是以List方式存放系
    int index = -1; //索引

    public InfoCollegeIterator(List<Department> departments) {
        this.departments = departments;
    }

    //判断是否存在下一个元素
    @Override
    public boolean hasNext() {
        if(index >= departments.size()-1){
            return false;
        }else {
            index += 1;
            return true;
        }
    }

    @Override
    public Object next() {
        return departments.get(index);
    }

    //空实现
    @Override
    public void remove() {

    }
}
