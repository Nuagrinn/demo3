package org.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {

//    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
//    and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.


//    Input: l1 = [2,4,3], l2 = [5,6,4]
//    Output: [7,0,8]
//    Explanation: 342 + 465 = 807.

    public static void main(String[] args) {

        var l1 = new int[]{2,4,3};
        var l2 = new int[]{5,6,4};

        var result = addTwoNumbers(transform(l1), transform(l2));
        printLl(result);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            sum += carry;
            carry = 0;

            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            current.next = new ListNode(sum);
            current = current.next;
        }

        return dummy.next;
    }

    public static ListNode transform(int[] arr) {
        List<ListNode> nodes = new ArrayList<>();
        for (int n : arr) {
            ListNode node = new ListNode(n);
            if (!nodes.isEmpty()) {
                var last = nodes.getLast();
                last.next = node;
            }
            nodes.add(node);


        }
        return nodes.getFirst();
    }

    public static void printLl(ListNode listNode) {
        List<Integer> llInts = new ArrayList<>();
        var node = new ListNode(listNode.val, listNode.next);
        while (node.next != null) {
            llInts.add(node.val);
            node = node.next;
        }
        llInts.add(node.val);

        System.out.println(Arrays.toString(llInts.toArray()));
    }

       static class ListNode {

           int val;
           ListNode next;

           ListNode() {}

           ListNode(int val) { this.val = val; }

           ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}
