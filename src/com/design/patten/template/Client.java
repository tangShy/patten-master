package com.design.patten.template;

/**
 * 代理模式：解决豆浆制作问题
 */
public class Client {
    public static void main(String[] args) {
        //制作红豆豆浆
        System.out.println("---------制作红豆豆浆----------");
        SoyaMilk soyaMilk = new RedBeanSoyaMilk();
        soyaMilk.make();

        //制作花生豆浆
        System.out.println("---------制作花生豆浆----------");
        SoyaMilk soyaMilk1 = new PeanutSoyaMile();
        soyaMilk1.make();
    }
}
