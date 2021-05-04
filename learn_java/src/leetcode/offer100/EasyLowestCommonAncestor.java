package leetcode.offer100;

import leetcode.offer100.base.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class EasyLowestCommonAncestor {

    /**
     * 题目：二叉树的最近公共祖先（LCA节点问题）
     * 题目链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
     *
     * 二叉树最近公共祖先，一般可以用存储父节点的方式进行：
     * 1. 先遍历二叉树，存储key为节点，value为父节点，到map里面
     * 2. 不断的找p和q，来找到公共祖先
     *
     * 由于所有的节点的值都是唯一的，因此可以直接使用node的val当做key
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    HashMap<Integer, TreeNode> treeMap = new HashMap<>();
    // 因为是公共祖先，所以如果有相同的则输出即可
    HashSet<Integer> treeSet = new HashSet<>();

    /**
     * 实际上就是dfs
     * @param root
     */
    public void traversalTree(TreeNode root) {
        if (root.left != null) {
            treeMap.put(root.left.val, root);
            traversalTree(root.left);
        }

        if (root.right != null) {
            treeMap.put(root.right.val, root);
            traversalTree(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traversalTree(root);
        TreeNode pParent = p, qParent = q;

        // 先把p的父节点都存入
        while (pParent != null) {
            treeSet.add(pParent.val);
            pParent = treeMap.get(pParent.val);
        }

        // 再判断q的父节点中第一个存在与set中的
        while (qParent != null) {
            if (treeSet.contains(qParent.val)) {
                return qParent;
            }
            qParent = treeMap.get(qParent.val);
        }

        return null;
    }


    public static void main(String[] args) {

    }

}
