package com.leetcode.leet118;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角    --easy
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        int index = 1;
        while (numRows >= index) {
            getNums(index);
            index++;
        }
        return ans;
    }

    private void getNums(int numRows) {
        if (numRows < 1) {
            return;
        }
        if (numRows == 1) {
            temp.add(1);
            this.ans.add(temp);
            return;
        }
        temp = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            if (i == 0 || i == numRows-1) {
                temp.add(1);
            } else {
                temp.add(this.ans.get(numRows-2).get(i-1) + this.ans.get(numRows-2).get(i));
            }
        }
        this.ans.add(temp);
    }
}
