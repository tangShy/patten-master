package com.demo;

public class VolatileVisibility {
    public static volatile int i =0;

    public static void increase(){
        i++;
    }

    public static void main(String[] args) {
        VolatileVisibility volatileVisibility ;
        while(true) {
            i=0;
            volatileVisibility = new VolatileVisibility();
            volatileVisibility.increase();
            if (i != 1) {
                System.out.println(i);
                return;
            }
        }
//        System.out.println(i);
    }
}
