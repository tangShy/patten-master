package com.leetcode.leet1232;

/**
 * 1232. 缀点成线       --easy
 * <p>
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * <p>
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 设f(x) = ax + b, 求出a和b
    public boolean checkStraightLine(int[][] coordinates) {
//        double a, b;
//        if (coordinates[1][1] - coordinates[0][1] == 0) {
//            b = coordinates[0][1];
//            for (int i = 2; i < coordinates.length; i++) {
//                if (coordinates[i][1] != b) {
//                    return false;
//                }
//            }
//        } else if (coordinates[1][0] - coordinates[0][0] == 0) {
//            b = coordinates[0][0];
//            for (int i = 2; i < coordinates.length; i++) {
//                if (coordinates[i][0] != b) {
//                    return false;
//                }
//            }
//        } else {
//            a = Double.valueOf(coordinates[1][1] - coordinates[0][1]) / Double.valueOf(coordinates[1][0] - coordinates[0][0]);
//            b = coordinates[1][1] - a * coordinates[1][0];
//            for (int i = 2; i < coordinates.length; i++) {
//                if (coordinates[i][1] != coordinates[i][0] * a + b) {
//                    return false;
//                }
//            }
//        }
//        return true;
        int x0 = coordinates[0][0];
        int x1 = coordinates[1][0];
        int y0 = coordinates[0][1];
        int y1 = coordinates[1][1];
        for (int[] coordinate : coordinates) {
            if ((coordinate[0] - x0) * (y1 - y0) != (x1 - x0) * (coordinate[1] - y0)) {
                return false;
            }
        }
        return true;
    }
}
