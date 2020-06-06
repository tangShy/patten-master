package com.design.patten.state;

import java.util.Random;

/**
 * 可以抽奖的状态
 */
public class CanRaddleState extends State {
    RaffleActivity activity;

    public CanRaddleState(RaffleActivity raffleActivity) {
        this.activity = raffleActivity;
    }

    //已经扣除了积分，不能再扣
    @Override
    public void deductMoney() {
        System.out.println("已经扣除了积分");
    }

    //可以抽奖，抽完奖后，根据实际情况，更新状态
    @Override
    public boolean raffle() {
        System.out.println("正在抽奖，请稍等！");
        Random random = new Random();
        int num = random.nextInt(10);
        //10%的中奖概率
        if(num == 0){
            //等于0设为中奖，改变状态为发送奖品
            activity.setState(activity.getDispenseState());
            return true;
        }else{
            System.out.println("很遗憾，您没有中奖！");
            //改变状态为不能抽奖
            activity.setState(activity.getNoRaffleState());
            return false;
        }
    }

    //不能发放奖品
    @Override
    public void dispensePrize() {
        System.out.println("没中奖，不能发放奖品");
    }
}
