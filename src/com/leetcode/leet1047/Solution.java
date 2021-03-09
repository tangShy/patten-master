package com.leetcode.leet1047;

/**
 * 1047. 删除字符串中的所有相邻重复项     --easy
 * <p>
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static String removeDuplicates(String S) {
        //超时
//        int n = S.length();
//        int i = 1;
//        while (n > 1 && i < n) {
//            char[] chars = S.toCharArray();
//            if (chars[i - 1] == chars[i]) {
//                S = S.substring(0, i - 1) + S.substring(i + 1);
//                n = S.length();
//                i = i==1 ? 1 : i - 1;
//            } else {
//                i++;
//            }
//        }
//        return S;

        //栈
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i=0; i<S.length(); i++) {
            char ch = S.charAt(i);
            if (top >= 0 && ch == stack.charAt(top)) {
                stack.deleteCharAt(top);
                top--;
            } else {
                stack.append(S.charAt(i));
                top++;
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        String s = "dcabbac";
        System.out.println(removeDuplicates(s));
    }
}
