package com.leetcode.leet37;

/**
 * 37. 解数独  --hard
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * Note:
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++) {
                if (board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;
                    block[i/3*3+j/3][num] = true;
                }
            }
        }
        dfs(board, row, col, block, 0 ,0);
    }

    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
        //找空位置
        while (board[i][j] != '.'){
            if (++j >= 9){
                i++;
                j = 0;
            }
            if( i >=9 ){
                return true;
            }
        }
        for (int num=0; num<9; num++){
            int blocker = i/3*3 + j/3;
            if (!row[i][num] && !col[j][num] && !block[blocker][num]){
                //递归
                board[i][j] = (char) (num + '1');
                row[i][num] = true;
                col[j][num] = true;
                block[blocker][num] = true;
                if(dfs(board, row, col, block, i, j)){
                    return true;
                }else{
                    //回溯
                    row[i][num] = false;
                    col[j][num] = false;
                    block[blocker][num] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }
}
