package com.design.patten.command;

//创建命令接口
public interface Command {
    //执行动作
    void execute();

    //撤销操作
    void undo();
}
