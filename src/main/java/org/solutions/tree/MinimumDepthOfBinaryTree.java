package org.solutions.tree;

import static org.solutions.tree.TreeUtils.*;

public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {

        Integer[] arr = {3,9,20,null,null,15,7};

        TreeNode tn = arrayToTree(arr);

        System.out.println(treeToArray(tn));
        System.out.println(minDepth(tn));

    }

    public static int minDepth(TreeNode root) {
        // Если дерево пустое
        if (root == null) {
            return 0;
        }

        // Если у узла нет потомков (лист)
        if (root.left == null && root.right == null) {
            return 1;
        }

        // Если нет левого поддерева
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        // Если нет правого поддерева
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // Если оба поддерева существуют, выбираем минимальную глубину
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }




}
