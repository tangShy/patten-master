package com.design.patten.state;

/**
 * 奖品发送完毕状态
 * 说明，当状态变为dispenseOutState 时，抽奖活动结束
 */
public class DispenseOutState extends State {
    RaffleActivity activity;

    public DispenseOutState(RaffleActivity raffleActivity) {
        this.activity = raffleActivity;
    }

    @Override
    public void deductMoney() {
        System.out.println("奖品发送完了，请下次再参加！");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发送完了，请下次再参加！");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发送完了，请下次再参加！");
    }
}
