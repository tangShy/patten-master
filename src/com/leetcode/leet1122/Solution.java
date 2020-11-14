package com.leetcode.leet1122;

/**
 * 1122. 数组的相对排序        --easy
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int[] count = new int[1001];
        // 遍历arr1,记录每个数字出现的次数
        for (int a : arr1) {
            count[a]++;
        }
        // 遍历arr2,将arr1中出现在arr2中的数字记录到result
        int index=0;
        for (int a2 : arr2) {
            while(count[a2] > 0) {
                result[index++] = a2;
                count[a2]--;
            }
        }
        // 遍历count，将arr1中剩下的数字记录
        for (int i=0;i<count.length;i++){
            while(count[i]>0){
                result[index++] = i;
                count[i]--;
            }
        }
        return result;
    }
}
