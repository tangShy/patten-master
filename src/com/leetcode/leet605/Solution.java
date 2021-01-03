package com.leetcode.leet605;

/**
 * 605. 种花问题       --easy
 * <p>
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * <p>
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n > flowerbed.length / 2 + 1) {
            return false;
        }
        if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (n <= 0) {
                return true;
            }
            if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i] = 1;
            } else if (i == flowerbed.length - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                n--;
                flowerbed[i] = 1;
            } else if (i != 0 && flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0};
        int n = 1;
        System.out.println(canPlaceFlowers(arr, n));
    }
}
