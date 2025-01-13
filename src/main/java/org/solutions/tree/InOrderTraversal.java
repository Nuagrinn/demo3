package org.solutions.tree;

import java.util.ArrayList;
import java.util.List;
import static org.solutions.tree.TreeUtils.*;

public class InOrderTraversal {

    public static void main(String[] args) {


        Integer[] arr = {1,2,3,4,5,null,8,null,null,6,7,9};
        TreeNode tn = arrayToTree(arr);


        System.out.println(inorderTraversal(tn));
    }
    public static List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> ints = new ArrayList<>();
        inOrder(node, ints);
        return ints;
    }

    public static void inOrder (TreeNode node, List<Integer> ints) {

        if (node == null) {
            return;
        }

        // Рекурсивный вызов для левого поддерева
        inOrder(node.left, ints);

        // Печать значения текущего узла
        ints.add(node.val);
        System.out.println("Обработка узла: " + node.val);

        // Рекурсивный вызов для правого поддерева
        inOrder(node.right, ints);

    }



}
