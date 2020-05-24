package com.design.patten.proxy.staticproxy;

public class TeacherDaoProxy implements ITeacherDao {
    //目标对象
    private ITeacherDao targert;

    public TeacherDaoProxy(ITeacherDao targert) {
        this.targert = targert;
    }

    @Override
    public void teach() {
        System.out.println("开始代理。。。执行一些操作");
        targert.teach();
        System.out.println("结束代理、、、执行一些操作");
    }
}
