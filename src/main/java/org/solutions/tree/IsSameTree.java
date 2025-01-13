package org.solutions.tree;

import static org.solutions.tree.TreeUtils.*;

public class IsSameTree {

    public static void main(String[] args) {

        Integer[] p = {1,2,3};
        Integer[] q = {1,2,3};

        TreeNode tp = arrayToTree(p);
        TreeNode tq = arrayToTree(q);

        System.out.println(isSameTree(tp, tq));

    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, they are the same
        if (p == null && q == null) {
            return true;
        }
        // If one of them is null or their values are different, they are not the same
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }



}
