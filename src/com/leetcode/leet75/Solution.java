package com.leetcode.leet75;

/**
 * 75. 颜色分类     --mid
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public void sortColors(int[] nums) {
        //法一：新建一个数组
//        int[] result = new int[nums.length];
//        Arrays.fill(result, 1);    //初始化数组
//        int k = 0, j = nums.length-1;
//        for (int i=0; i<nums.length; i++){
//            if (nums[i] == 0){
//                result[k++] = nums[i];
//            }
//            if (nums[i] == 2){
//                result[j--] = nums[i];
//            }
//        }
//        for (int i=0; i<nums.length; i++){
//            nums[i] = result[i];
//        }

        //法二：双指针
//        int head=0, tail=nums.length-1;
//        int i=0;
//        while (i <= tail) {
//            if (nums[i] == 0){
//                int temp = nums[i];
//                nums[i] = nums[head];
//                nums[head] = temp;
//                head++;
//                i++;
//            } else if (nums[i] == 1){
//                ++i;
//            } else if(nums[i] == 2) {
//                int temp = nums[i];
//                nums[i] = nums[tail];
//                nums[tail] = temp;
//                tail--;
//            }
//        }

        //法3：单指针
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }

}
