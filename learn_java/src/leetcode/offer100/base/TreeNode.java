package leetcode.offer100.base;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }
    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}