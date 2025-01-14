package org.solutions.tree;

import static org.solutions.tree.TreeUtils.*;


public class IsSymmetric {

    public static void main(String[] args) {

        Integer[] r = {1,2,2};
        TreeNode tr = arrayToTree(r);

        System.out.println(isSymmetric(tr));


    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isS(root.left, root.right);
    }

    private static boolean isS(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true; // Both nodes are null, so they are symmetric.
        }
        if (l == null || r == null || l.val != r.val) {
            return false; // One node is null, or values don't match, so not symmetric.
        }

        // Recursively check the subtrees.
        return isS(l.left, r.right) && isS(l.right, r.left);
    }




}
