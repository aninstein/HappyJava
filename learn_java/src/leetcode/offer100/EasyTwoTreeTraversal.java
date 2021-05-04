package leetcode.offer100;

import leetcode.offer100.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class EasyTwoTreeTraversal {

    /*
    * 题目：剑指 Offer 27. 二叉树的镜像
    * 题目链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
    *
    * 树的镜像，意味着不断的交换节点的左右节点，并且把左右节点给放到队列里，继续交换左右节点
    *
    *
    * */
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
        treeQueue.offer(root);
        while (!treeQueue.isEmpty()) {
            TreeNode node = treeQueue.poll();
            // 交换左右节点
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // 继续进队列
            if (node.left != null) {
                treeQueue.offer(node.left);
            }
            if (node.right != null) {
                treeQueue.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }

}
