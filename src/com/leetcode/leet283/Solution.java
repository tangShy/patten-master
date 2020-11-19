package com.leetcode.leet283;

/**
 * 283. 移动零     --easy
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 *      必须在原数组上操作，不能拷贝额外的数组。
 *      尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public void moveZeroes(int[] nums) {
//        for (int i=0; i<nums.length; i++) {
//            boolean flag = false;   //标记后面是否存在非0数字
//            if (nums[i] == 0) {
//                for (int j=i+1; j<nums.length; j++) {
//                    if (nums[j] != 0) {
//                        nums[i] = nums[j];
//                        nums[j] = 0;
//                        flag = true;
//                        break;
//                    }
//                }
//                if (!flag) {
//                    break;
//                }
//            }
//        }

        //法二
        int index = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                nums[i] = 0;
                index++;
            }
        }
    }
}
