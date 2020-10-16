package com.leetcode.leet1002;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002. 查找常用字符     --easy
 *
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        // 首先找到长度最短的字符串，返回的列表大小不大于该长度
        String minLenStr = A[0];
        for (String str : A){
            if (minLenStr.length() > str.length()){
                minLenStr = str;
            }
        }
        // 循环遍历长度最短的字符串
        for (int i=0; i<minLenStr.length(); i++){
            String ch = String.valueOf(minLenStr.charAt(i));

            boolean flag = true;    //标志所有字符串是否都包含该字符
            for (String str : A){
                if (!str.contains(ch)){
                    flag = false;
                }
            }
            if (flag){
                int j=0;
                // 将该字符从原集合的所有的字符串中删除
                for (String str : A){
                    str = str.substring(0, str.indexOf(ch)) + str.substring(str.indexOf(ch) + 1);
                    A[j++] = str;
                }
                // 将该字符添加进目标集合中
                result.add(ch);
                // 原字符串的长度减1
                i--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"cool","lock","cook"};
        List<String> list = commonChars(A);
        System.out.println(list.toString());
    }
}
