//package com;
//
///**
// * 2.天猫国际每天都会卖出很多跨境商品，用户每次下单可能购买多个商品，购买总数小于10件，由于海关规定，每一个进入海关的箱子里面的商品总额不能超过2000元（否则不能清关）所以当用户下单总金额超过2000，必须使用多个箱子分开包装运输；现在为了节约运输成本，希望在满足海关的要求下，能够使用尽可能少的箱子。
// * 注：每个商品都有自己的单价，有特定的长宽高，所有商品都是长方体。商品可以横放、竖放、侧放，但不用考虑斜放，但是长宽高各项总和必须都要小于等于箱子的长宽高。假定目前天猫国际使用同一种规格的箱子：boxLong,boxWidth,boxHigh（箱子长，箱子宽，箱子高）。
// *  某用户下单买了如下商品：
// * n（商品件数）
// * item1Price,item1Long,item1With,item1High
// * item2Price,item2Long,item2With,item2High
// * item3Price,item3Long,item3With,item3High
// * item4Price,item4Long,item4With,item4High
// * ...
// * （商品价格，商品长，商品宽，商品高，所有输入类型均为int型正整数)
// * 请你算出需要使用最小的箱子数量，可以将这些商品顺利得清关送到消费者手中，如果无解，输出-1
// */
//import java.util.Scanner;
//
///**
// * Created by hcw on 2017/8/25.
// */
//
//public class Test2 {
//    /**
//     * 非100%的通过解法，写的垃圾代码拿来给大伙娱乐下，勿喷哈~~应该动态规划求解才对！
//     *
//     * @param length  长
//     * @param width   宽
//     * @param height  高
//     * @param itemNum 商品件数
//     * @param items   商品价格、长、宽、高
//     */
//    private static int process(int length, int width, int height, int itemNum, int[][] items) {
//
//        int totalPrice = 0;
//        int totalLength = 0;
//        int totalWidth = 0;
//        int totalHeight = 0;
//
//        for (int i = 0; i < items.length; i++) {
//            totalPrice += items[i][0];
//        }
//
//        for (int i = 0; i < items.length; i++) {
//            totalLength += items[i][1];
//        }
//
//        for (int i = 0; i < items.length; i++) {
//            totalWidth += items[i][2];
//        }
//
//        for (int i = 0; i < items.length; i++) {
//            totalHeight += items[i][3];
//        }
//
//        if (totalPrice <= 2000 && totalLength <= length && totalWidth <= width && totalHeight <= height) {
//            return 1;
//        } else {
//            int remainderLength = (int) Math.ceil(totalLength / length);
//            int remainderWidth = (int) Math.ceil(totalWidth / width);
//            int remainderHeight = (int) Math.ceil(totalHeight / height);
//            int result = 0;
//            if (remainderHeight >= remainderWidth && remainderHeight >= remainderLength) {
//                result = remainderHeight;
//            }
//            if (remainderWidth >= remainderHeight && remainderWidth >= remainderLength) {
//                result = remainderWidth;
//            }
//            if (remainderLength >= remainderWidth && remainderLength >= remainderHeight) {
//                result = remainderLength;
//            }
//
//            return result;
//        }
//
//    }
//
//    public static void main(String args[]) {
//        Scanner scanner = new Scanner(System.in);
//
//        while (scanner.hasNext()) {
//            int length = scanner.nextInt();
//            int width = scanner.nextInt();
//            int height = scanner.nextInt();
//
//            int itemNum = scanner.nextInt();
//            int[][] items = new int[itemNum][4];
//            for (int i = 0; i < itemNum; i++) {
//                items[i][0] = scanner.nextInt();
//                items[i][1] = scanner.nextInt();
//                items[i][2] = scanner.nextInt();
//                items[i][3] = scanner.nextInt();
//            }
//            int result = process(length, width, height, itemNum, items);
//            System.out.println(String.valueOf(result));
//        }
//    }
//
//}
