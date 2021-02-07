package leetcode.classic;

import leetcode.offer100.base.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class EasyKthBinarySearchTree {

    /**
     * 题目：剑指 Offer 54. 二叉搜索树的第k大节点
     * 题目链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
     *
     * 二叉搜索树（BST）（又：二叉搜索树，二叉排序树）：
     * - 可以是一棵空树
     * - 也可以是具有下列性质的二叉树：
     *   - 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     *   - 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     *   - 它的左、右子树也分别为二叉排序树。
     *
     * 即对于二叉搜索树：左边 < 根节点 < 右边
     * 意味着当进行中序遍历的时候，排列的数据内容就是一个递增序列
     * 中序遍历：左 -> 中 -> 右
     *
     * 也意味着二叉搜索树：右边 > 根节点 > 左边，即中序遍历的倒序是一个递减序列
     * 中序遍历倒序：右 -> 中 -> 左
     *
     * 因此我们可以求：二叉搜索树的中序遍历的倒序的第k个节点
     *
     * @param root 树的根节点
     * @param k 第k个
     * @return 第k个大的
     */
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        LinkedList<Integer> dataList = new LinkedList<>();

        // 写一个基于栈的倒序中序遍历
        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.push(root);
        while (!treeStack.empty()) {
            while (treeStack.peek().right != null) {
                treeStack.push(treeStack.peek().right);
            }

            while (!treeStack.empty()) {
                TreeNode now = treeStack.pop();
                dataList.add(now.val);

                if (now.left != null) {
                    treeStack.push(now.left);
                    break;
                }
            }
        }

        for (Integer data: dataList) {
            k--;
            if (k == 0) {
                return data;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }

}

//// 官方题解
//class Solution {
//    int res, k;
//    public int kthLargest(TreeNode root, int k) {
//        this.k = k;
//        dfs(root);
//        return res;
//    }
//    void dfs(TreeNode root) {
//        if(root == null) return;
//        dfs(root.right);
//        if(k == 0) return;
//        if(--k == 0) res = root.val;
//        dfs(root.left);
//    }
//}