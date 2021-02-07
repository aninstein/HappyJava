package leetcode.offer100;

import leetcode.offer100.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
public class EasyLayerTraversalTree {

    /**
     * 树的层序遍历
     * 题目链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retData = new LinkedList<>();
        if (root == null) {
            return retData;
        }
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.offer(root);
        while (!treeQueue.isEmpty()) {
            List<Integer> layerList = new LinkedList<>();
            Queue<TreeNode> layerQueue = new LinkedList<>();
            while (!treeQueue.isEmpty()) {
                TreeNode now = treeQueue.poll();
                layerList.add(now.val);
                if (now.left != null) {
                    layerQueue.offer(now.left);
                }
                if (now.right != null) {
                    layerQueue.offer(now.right);
                }
            }
            retData.add(layerList);
            treeQueue = layerQueue;
        }
        return retData;
    }

    public static void main(String[] args) {

    }

}
