package com.leetcode.tree.leet94;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历 --mid
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private static List<Integer> result = new ArrayList<>();

    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return result;
        }
        //法一：递归法
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;

        //法二：栈
//        Deque<TreeNode> stk = new LinkedList<>();
//        while (root != null || !stk.isEmpty()){
//            while (root != null){
//                stk.push(root);
//                root = root.left;
//            }
//            root = stk.pop();
//            result.add(root.val);
//            root = root.right;
//        }
//        return result;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2, left, null);
        TreeNode root = new TreeNode(1, null, right);

        System.out.println(inorderTraversal(root));
    }
}
