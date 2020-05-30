package com.design.patten.visitor;

/**
 * 这里使用了双分派，即首先在客户端程序中，j将具体状态作为参数传递给Woman中（第一次分派）
 * 然后Woman 类调用作为参数的“具体方法”中方法 getWomanResult，同时将自己（this）作为参数传入，完成第二次的分派
 */
public class Woman extends Person {
    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
