package com.leetcode.leet861;

/**
 * 861. 翻转矩阵后的得分    --mid
 *
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static int matrixScore(int[][] A) {
        //首先，通过横或竖变换，将第一列都变为1,再通过竖变将0个数多与1个数的竖变换
        int row = A.length;
        int col = A[0].length;
        for (int i=0; i<row; i++) {
            if (A[i][0] == 0) {
                reversRow(A[i]);
            }
        }
        for (int j=1; j<col; j++) {
            int count0 = 0, count1=0;
            int[] colInts = new int[row];
            for (int k=0; k<row; k++) {
                if (A[k][j] == 0) {
                    count0++;
                }else {
                    count1++;
                }
                colInts[k] = A[k][j];
            }
            if (count0 > count1) {
                reversRow(colInts);
                for (int m=0; m<row; m++) {
                    A[m][j] = colInts[m];
                }
            }
        }

        int ans = 0;
        for (int i=0; i<row; i++) {
            int temp = 0;
            for (int j=0; j<col; j++) {
                System.out.print(A[i][j]);
                temp += (int) (A[i][j] * (Math.pow(2, col-j-1)));
            }
            System.out.println();
            ans += temp;
        }
        return ans;
    }

    private static void reversRow(int[] ints) {
        for (int i=0; i<ints.length; i++) {
            if (ints[i] == 0) {
                ints[i] = 1;
            }else {
                ints[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] temp1 = {0, 0, 1, 1};
        int[] temp2 = {1, 0, 1, 0};
        int[] temp3 = {1, 1, 0, 0 };
        int[][] ints = new int[3][4];
        ints[0] = temp1;
        ints[1] = temp2;
        ints[2] = temp3;
        int i1 = matrixScore(ints);
        System.out.println(i1);
//        for (int i=0; i<ints.length; i++) {
//            for (int j=0; j<ints[0].length; j++) {
//                System.out.print(ints[i][j]);
//            }
//            System.out.println();
//        }
    }
}
