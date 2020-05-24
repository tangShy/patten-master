package com.design.patten.proxy.cglib;

public class TeacherDao {

	public String teach() {
		System.out.println("老师授课中，我是cglib代理，不用实现接口 ");
		return "hello";
	}
}
