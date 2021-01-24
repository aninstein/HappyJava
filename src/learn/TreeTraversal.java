package learn;

import leetcode.offer100.base.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

    /**
     * 前序遍历
     * @param root
     * @param treeList
     * @return
     */
    public static Integer[] preTraversal(TreeNode root, LinkedList<Integer> treeList) {
        if (root == null) {
            return treeList.toArray(new Integer[0]);
        }
        if (treeList == null) {
            treeList = new LinkedList<>();
        }
        treeList.add(root.val);
        preTraversal(root.left, treeList);
        preTraversal(root.right, treeList);
        return treeList.toArray(new Integer[0]);
    }

    /**
     * 中序遍历
     * @param root
     * @param treeList
     * @return
     */
    public static Integer[] midTraversal(TreeNode root, LinkedList<Integer> treeList) {
        if (root == null) {
            return treeList.toArray(new Integer[0]);
        }
        if (treeList == null) {
            treeList = new LinkedList<>();
        }
        midTraversal(root.left, treeList);
        treeList.add(root.val);
        midTraversal(root.right, treeList);
        return treeList.toArray(new Integer[0]);
    }

    /**
     * 后序遍历
     * @param root
     * @param treeList
     * @return
     */
    public static Integer[] lastTraversal(TreeNode root, LinkedList<Integer> treeList) {
        if (root == null) {
            return treeList.toArray(new Integer[0]);
        }
        if (treeList == null) {
            treeList = new LinkedList<>();
        }
        lastTraversal(root.left, treeList);
        lastTraversal(root.right, treeList);
        treeList.add(root.val);
        return treeList.toArray(new Integer[0]);
    }

    public static TreeNode preTraversalStack(TreeNode root) {
        return root;
    }

    public static TreeNode midTraversalStack(TreeNode root) {
        return root;
    }

    public static TreeNode lastTraversalStack(TreeNode root) {
        return root;
    }

    /**
     * 生成一颗完全二叉树
     * @param data 整型数组
     * @return 返回整型数组生成的二叉树的头节点
     */
    private static TreeNode createTree(int [] data) {
        if (data == null) {
            return null;
        }
        int dataLen = data.length;
        TreeNode[] treeData = new TreeNode[dataLen];
        for (int i = 0; i < dataLen; i++) {
            treeData[i] = new TreeNode(data[i]);
        }

        for (int i = 0; i < dataLen; i++) {
            int leftChild = (i * 2) + 1;
            if (leftChild < dataLen) {
                treeData[i].left = treeData[leftChild];
            }

            if (leftChild + 1 < dataLen) {
                treeData[i].right = treeData[leftChild + 1];
            }
        }
        return treeData[0];
    }

    public static void printTree(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(">>>>> print tree: ");
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.offer(head);
        int layer = 1;
        while (!treeQueue.isEmpty()) {
            Queue<TreeNode> layerQueue = new LinkedList<>();
            while (!treeQueue.isEmpty()) {
                TreeNode now = treeQueue.poll();
                System.out.print(now.val + " ");
                if (now.left != null) {
                    layerQueue.offer(now.left);
                }

                if (now.right != null) {
                    layerQueue.offer(now.right);
                }
            }
            System.out.println();
            treeQueue = layerQueue;
            layer++;
        }
    }

    public static void printArray(Integer[] data) {
        if (data == null) {
            System.out.println();
            return;
        }
        for (int datum : data) {
            System.out.print(datum + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode tree = createTree(data);
        printTree(tree);

        System.out.println("preTraversal: ");
        Integer[] preRes = preTraversal(tree, null);
        printArray(preRes);

        System.out.println("midTraversal: ");
        Integer[] midRes = midTraversal(tree, null);
        printArray(preRes);

        System.out.println("lastTraversal: ");
        Integer[] lastRes = lastTraversal(tree, null);
        printArray(lastRes);
    }


}
