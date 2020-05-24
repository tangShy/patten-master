package com.design.patten.composite;

/**
 * 使用组合模式，展示一个学校的专业结构
 */
public class Client {
    public static void main(String[] args) {
        //从大到小，创建对象 学校
        OrganizationComponent university = new University("清华大学","中国顶级大学");

        //创建学院
        OrganizationComponent computeCollege = new College("计算机学院","计算机学院");
        OrganizationComponent infoEngineerCollege = new College("信息工程学院","信息工程学院");

        //创建各个学院下的各专业
        computeCollege.add(new Department("计算机科学与技术","王牌专业"));
        computeCollege.add(new Department("软件工程","软件工程很不错"));
        computeCollege.add(new Department("网络工程","网络工程也不错"));

        infoEngineerCollege.add(new Department("通信工程","通信工程偏硬件"));
        infoEngineerCollege.add(new Department("信息工程","信息安全方向"));

        //将学院加入到学校
        university.add(computeCollege);
        university.add(infoEngineerCollege);

//        computeCollege.print();
//        infoEngineerCollege.print();
        //打印学校组织
        university.print();

        /*
        -----------清华大学---------------
        =============计算机学院================
        计算机科学与技术
        软件工程
        网络工程
        =============信息工程学院================
        通信工程
        信息工程
        */
    }
}
