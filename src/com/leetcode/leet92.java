package com.leetcode;

import com.leetcode.common.ListNode;

/**
 * 92. 反转链表 II      --mid
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *  
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *  
 *
 * 进阶： 你可以使用一趟扫描完成反转吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leet92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
         ListNode dummy = new ListNode(0);
         dummy.next = head;
         ListNode pre = dummy;
         for(int i = 1; i < left; i++){
             pre = pre.next;
         }
         head = pre.next;
         for(int i = left; i < right; i++){
             ListNode nex = head.next;
             head.next = nex.next;
             nex.next = pre.next;
             pre.next = nex;
         }
         return dummy.next;
    }
}
