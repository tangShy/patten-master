package com.leetcode.leet39;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和  --mid
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, candidates, target, result, temp);
        return result;
    }

    private static void dfs(int curr, int[] candidates, int target, List<List<Integer>> result, List<Integer> temp) {
        if(curr == candidates.length){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }

        //不选择当前数，下一个
        dfs(curr+1, candidates, target, result, temp);
        //选择当前数
        if(target - candidates[curr] >= 0){
            temp.add(candidates[curr]);
            dfs(curr, candidates, target - candidates[curr], result, temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(candidates, target);
        for (int i=0; i<lists.size(); i++){
            for (Integer integer : lists.get(i)){
                System.out.print(integer);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
