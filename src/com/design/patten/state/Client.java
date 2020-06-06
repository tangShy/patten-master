package com.design.patten.state;

/**
 * 状态模式：完成APP抽奖活动
 */
public class Client {
    public static void main(String[] args) {
        //创建活动对象，奖品有一个
        RaffleActivity activity = new RaffleActivity(1);

        //连续抽取100次奖
        for (int i=0; i<30; i++){
            System.out.println("------------第"+(i+1)+"次抽奖-------------");
            activity.deductMoney();//扣积分
            activity.raffle();//开始抽奖
        }
    }
}
