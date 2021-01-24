package learn;

import leetcode.offer100.base.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    /**
     * 使用栈对树进行前序遍历比较简单栈，由于每次先输出根节点，再输出左节点随后是右节点。
     * 因此实现步骤是：
     * - 1. 若栈非空输出根节点，并出栈
     * - 2. 将右节点压栈（如果存在），注意是先右后左
     * - 3. 将左节点压栈（如果存在）
     * - 4. 若栈非空输出根节点，并出栈
     * 注意：之所以先压右节点是考虑了栈的特性，这样在迭代过程中可以先拿到左节点处理
     * @param root
     * @return
     */
    public static Integer[] preTraversalStack(TreeNode root, LinkedList<Integer> treeList) {
        if (root == null) {
            return null;
        }

        if (treeList == null) {
            treeList = new LinkedList<>();
        }

        Stack<TreeNode> treeStack = new Stack<>();
        TreeNode now = root;
        treeStack.add(now);
        while (!treeStack.empty()) {
            now = treeStack.pop();
            treeList.add(now.val);
            if (now.right != null) {
                treeStack.add(now.right);
            }
            if (now.left != null) {
                treeStack.add(now.left);
            }
        }
        return treeList.toArray(new Integer[0]);
    }

    /**
     * 使用栈对树进行中序遍历
     *
     * 栈的中序遍历需要套两层循环，由于需要先输出左节点，因此必须向下查找直到左节点为空才能输出。
     * 处理逻辑如下：
     * - 1. 如果栈顶元素非空且左节点存在，将其入栈，重复该过程。若不存在则进入第2步
     * - 2. 若栈非空，输出栈顶元素并出栈。判断刚出栈的元素的右节点是否存在，不存在重复第2步，存在则将右节点入栈，跳至第1步
     *
     * @param root
     * @return
     */
    public static Integer[] midTraversalStack(TreeNode root, LinkedList<Integer> treeList) {
        if (root == null) {
            return null;
        }

        if (treeList == null) {
            treeList = new LinkedList<>();
        }

        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.add(root);
        while (!treeStack.empty()) {
            // 该过程一直找到没有左节点的节点才停止
            while (treeStack.peek().left != null) {
                treeStack.add(treeStack.peek().left);
            }

            // 此时的栈顶元素是没有左节点的，按照中序遍历的特性，可以将其直接输出。
            // while循环会一直将栈顶输出，直到遇到有右节点的节点，这样能保证栈中元素不会重复寻找左孩子
            while (!treeStack.empty()) {
                TreeNode now = treeStack.pop();
                treeList.add(now.val);

                if (now.right != null) {
                    treeStack.add(now.right);
                    break;
                }
            }

        }
        return treeList.toArray(new Integer[0]);
    }

    public static TreeNode lastTraversalStack(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> treeStack = new Stack<>();
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

    /**
     * 按照层序遍历打印树
     * @param head
     */
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
        Integer[] preStackRes = preTraversalStack(tree, null);
        printArray(preRes);
        printArray(preStackRes);

        System.out.println("midTraversal: ");
        Integer[] midRes = midTraversal(tree, null);
        Integer[] midStackRes = midTraversalStack(tree, null);
        printArray(midRes);
        printArray(midStackRes);

        System.out.println("lastTraversal: ");
        Integer[] lastRes = lastTraversal(tree, null);
        printArray(lastRes);
    }


}
