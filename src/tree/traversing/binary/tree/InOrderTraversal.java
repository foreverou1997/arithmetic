package tree.traversing.binary.tree;

import tree.TreeNode;

import java.util.Stack;

/**
 * @author oulei
 * 二叉树中序遍历 -- 左根右
 */
public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node4.left = node2;
        node4.right = node6;

        node2.left = node1;
        node2.right = node3;

        node6.left = node5;
        node6.right = node7;

        // 非递归调用
        // normalInOrderTraversal(node4);
        // 递归调用
        recursionInOrderTraversal(node4);
    }

    /**
     * 非递归遍历
     */
    public  static  void normalInOrderTraversal(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
       while (node != null || stack.size() > 0){
           if (node != null){
               stack.push(node);
               node = node.left;
           }else{
               TreeNode tem = stack.pop();
               System.out.println(tem.val);
               node = tem.right;
           }

       }
    }


    /**
     * 递归遍历
     */
    public static  void recursionInOrderTraversal(TreeNode node){
        if (node.left != null){
            recursionInOrderTraversal(node.left);
        }
        System.out.println(node.val);
        if (node.right != null){
            recursionInOrderTraversal(node.right);
        }

    }

}
