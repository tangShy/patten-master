package com.leetcode.week3.leet51;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author tang
 * @Date 2021/9/4 11:24
 */
// 51. N 皇后(困难)
public class Solution {
    List<List<String>> res = new LinkedList<>();

    // 输入棋盘边长 n，返回所有合法的放置
    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘 "."代表空，"Q"代表皇后
        List<String> board = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            board.add(".");
        }
        backtrack(board, 0);
        return res;
    }

    // 路径：board 中小于 row 的那些行都已经成功放置了皇后
    // 选择列表：第 row 行的所有列都是放置皇后的选择
    // 结束条件：row 超过 board 的最后一行
    private void backtrack(List<String> board, int row) {
        // 触发结束条件
        if (row == board.size()) {
            res.add(new LinkedList<>(board));
            return;
        }
//        int n = board[row]
    }
}
