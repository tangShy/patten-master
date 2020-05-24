package com.design.patten.builder.improve;

/**
 * 使用建造者模式 搭建房子
 */
public class Client {
    public static void main(String[] args) {
        //盖普通房子
        CommonHouse commonHouse = new CommonHouse();
        //准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        //完成盖房子，返回产品（普通房子）
        House house = houseDirector.constructHouse();

        System.out.println("=============================");

        //盖高楼
        HighHouse highHouse = new HighHouse();
        houseDirector.setHouseBuilder(highHouse);
        houseDirector.constructHouse();

    }
}
