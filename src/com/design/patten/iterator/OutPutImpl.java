package com.design.patten.iterator;

import java.util.Iterator;
import java.util.List;

public class OutPutImpl {
    //学院集合
    List<College> collegeList;

    public OutPutImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    //遍历所有学院，然后调用 printDepartment 打印该学院下的所有系
    public void printCollege(){
        //从 collegeList 中取出所有学院，Java中的List已经实现了 Iterator
        Iterator<College> iterator = collegeList.iterator();

        while (iterator.hasNext()){
            //取出一个学院
            College college = iterator.next();
            System.out.println("====="+college.getName()+"===========");
            printDepartment(college.createIterator());//得到对应迭代器
        }
    }

    //输出学院下的各个系
    public void printDepartment(Iterator iterator){
        while (iterator.hasNext()){
            Department d = (Department) iterator.next();
            System.out.println(d.getName());
        }
    }
}
