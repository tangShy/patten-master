package com.design.patten.memento.game;

/**
 * 备忘录模式：解决游戏角色状态恢复
 */
public class Client {
    public static void main(String[] args) {
        //创建游戏角色
        GameRole gameRole = new GameRole();
        gameRole.setDef(100);
        gameRole.setVit(100);

        System.out.println("和大Boss大战前的状态");
        gameRole.display();

        //把当前状态保存到 caretaker
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.createMemento());

        System.out.println("和大Boss大战~~");
        gameRole.setVit(30);
        gameRole.setDef(30);
        gameRole.display();

        System.out.println("===========================================");
        System.out.println("大战后，使用备忘录模式恢复游戏角色初始状态~");
        gameRole.recoverGameRoleFromMemento(caretaker.getMemento());
        System.out.println("恢复后的状态");
        gameRole.display();
    }
}
