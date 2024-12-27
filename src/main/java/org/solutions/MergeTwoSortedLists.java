package org.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

//        list1 = [1,1,1], list2 = [1,3,4]
        printLl(mergeTwoLists(transform(new int[]{}), transform(new int[]{})));

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        ListNode dummy = new ListNode(0);
        ListNode r = dummy;

        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null && list1.val > list2.val) {
                r.next = new ListNode(list2.val);
                r = r.next;
                list2 = list2.next;

            } else if (list1 != null && list2 != null && list1.val < list2.val) {
                r.next = new ListNode(list1.val);;
                r = r.next;
                list1 = list1.next;
            } else {
                if(list1 != null) {
                    r.next = new ListNode(list1.val);
                    r = r.next;
                    list1 = list1.next;
                }
                if(list2 != null) {
                    r.next = new ListNode(list2.val);
                    r = r.next;
                    list2 = list2.next;
                }

            }
        }

        return dummy.next;
    }


    public static ListNode transform(int[] arr) {
        if(arr.length == 0) {
            return null;
        }
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
