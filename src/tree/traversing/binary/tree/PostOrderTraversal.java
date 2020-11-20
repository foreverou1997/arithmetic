package tree.traversing.binary.tree;

import tree.TreeNode;

import java.util.Stack;

/**
 * @author oulei
 * 二叉树后序遍历 -- 左右根
 */
public class PostOrderTraversal {
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
        //normalPostOrderTraversal(node4);
        // 递归调用
        recursionPostOrderTraversal(node4);
    }


    /**
     * 非递归遍历
     */
    public static  void normalPostOrderTraversal(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        TreeNode cur, pre;
        pre = null;
        while (stack.size() > 0){
            cur = stack.peek();
           if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))){
               System.out.println(cur.val);
               stack.pop();
               pre = cur;
           }else{
               if (cur.right != null){
                   stack.push(cur.right);
               }
               if (cur.left != null){
                   stack.push(cur.left);
               }
           }
        }
    }


    /**
     * 递归实现
     */
    public static  void recursionPostOrderTraversal(TreeNode node){
        if (node.left != null){
            recursionPostOrderTraversal(node.left);
        }
        if (node.right != null){
            recursionPostOrderTraversal(node.right);
        }
        System.out.println(node.val);
    }
}
