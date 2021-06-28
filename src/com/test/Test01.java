package com.test;

import com.leetcode.common.ListNode;

/**
 * 腾讯音乐-全民k歌面试算法题
 *
 * 1、有两个无序链表A和B，请按照奇数在前，偶数在后，局部有序（奇数，偶数分别有序），并且相同数字需要去重的要求输出链表中的元素（不使用语言库函数）￼
 * A : {3,2,1,4,5}
 * B: {4,5,6,7,8,9}
 * res: {1,3,5,7,9,2,4,6,8}
 */
public class Test01 {
    //存奇数
    static int[] a1 = new int[5];
    //存偶数
    static int[] a2 = new int[5];
    static int[] b1 = new int[4];
    static int[] b2 = new int[4];
    public static ListNode solution(ListNode A, ListNode B) {
//        //存奇数
//        int[] a1 = new int[5];
//        //存偶数
//        int[] a2 = new int[5];
//        int[] b1 = new int[4];
//        int[] b2 = new int[4];
        ListNode res = new ListNode();
        int i1 = 0, i2 = 0;
        int j1 = 0, j2 = 0;
        while (A != null) {
            if (A.val % 2 != 0) {
                a1[i1++] = A.val;
            } else {
                a2[i2++] = A.val;
            }
            A = A.next;
        }
        while (B != null) {
            if (B.val % 2 != 0) {
                b1[j1++] = B.val;
            } else {
                b2[j2++] = B.val;
            }
            B = B.next;
        }
        sortNum(a1);
        sortNum(a2);
        sortNum(b1);
        sortNum(b2);
        int[] a = append(a1, b1);
        int[] b = append(a2, b2);
        int[] append = new int[a.length + b.length];
        int len = a.length;
        for (int i=0; i<a.length; i++) {
            append[i] = a[i];
        }
        for (int i =0; i<b.length; i++) {
            append[len+i] = b[i];
        }
        res = new ListNode(append[0]);
        for (int i = 1; i < append.length; i++) {
            if (append[i] != 0) {
                res.add(append[i]);
            }
        }
        res.print();
        return res.next;
    }

    private static void sortNum(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[i] > nums[j + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    private static int[] append(int[] a, int[] b) {
        int lenA = a.length;
        int lenB = b.length;
        int i = 0, j = 0, k = 0;
        int[] re = new int[lenA + lenB];
        while (i < lenA && j < lenB) {
            if (a[i] < b[j]) {
                re[k++] = a[i++];
            } else if (a[i] > b[j]) {
                re[k++] = b[j++];
            } else {
                re[k++] = a[i++];
                j++;
            }
        }
        if (i < lenA) {
            for (int m = i; m < lenA; m++) {
                if (a[m] == re[k]) {
                    continue;
                }
                re[k++] = a[m];
            }
        }
        if (j < lenB) {
            for (int m = j; m < lenB; m++) {
                if (b[m] == re[k]) {
                    continue;
                }
                re[k++] = b[m];
            }
        }
        return re;
    }

    // 32145
    // 4569
    public static void main(String[] args) {
        ListNode A = new ListNode(3);
        A.add(2);
        A.add(1);
        A.add(4);
        A.add(5);
        A.print();
        System.out.println();
        System.out.println("================");
        ListNode B = new ListNode(9);
        B.add(4);
        B.add(5);
        B.add(6);
        B.print();
        System.out.println();
        System.out.println("================");
//        System.out.println(A.getNodeSize());
//        System.out.println(B.getNodeSize());
        solution(A, B);
    }
}
