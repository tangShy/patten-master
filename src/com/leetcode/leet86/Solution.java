package com.leetcode.leet86;

import com.leetcode.common.ListNode;

/**
 * 86. 分隔链表     --mid
 *
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
//        ListNode listNodeYounger = new ListNode(0);
//        ListNode listNodeOlder = new ListNode(0);
//        ListNode node1 = listNodeYounger;
//        ListNode node2 = listNodeOlder;
//        while (head != null) {
//            if (head.val < x) {
//                node1.next = head;
//                node1 = node1.next;
//                node1.next = null;
//            } else {
//                node2.next = head;
//                node2 = node2.next;
//                node2.next = null;
//            }
//            head = head.next; // TODO: 这一句放外面为啥不行？？？
//        }
//        node1.next = listNodeOlder.next;
//        return listNodeYounger.next;

//        ListNode small = new ListNode(0);
//        ListNode smallHead = small;
//        ListNode large = new ListNode(0);
//        ListNode largeHead = large;
//        while (head != null) {
//            if (head.val < x) {
//                small.next = head;
//                small = small.next;
//            } else {
//                large.next = head;
//                large = large.next;
//            }
//            head = head.next;
//        }
//        large.next = null;
//        small.next = x.next;
//        return smallHead.next;

        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        while (head != null) {
            if (head.val < x) {
                node1.next = head;
                head = head.next;
                node1 = node1.next;
                node1.next = null;
            } else {
                node2.next = head;
                head = head.next;
                node2 = node2.next;
                node2.next = null;
            }
        }
        node1.next = dummyHead2.next;
        return dummyHead1.next;
    }
}
