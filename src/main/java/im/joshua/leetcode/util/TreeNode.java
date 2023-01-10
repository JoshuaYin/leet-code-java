package im.joshua.leetcode.util;

import com.google.gson.Gson;


/**
 * @description:
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2020/11/20 11:12
 */
public class TreeNode<T> {
    private TreeNode parent;
    private T value;
    private TreeNode left, right;

    public TreeNode(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(TreeNode parent, T value) {
        this.parent = parent;
        this.value = value;
    }

    public TreeNode(T value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    public TreeNode(TreeNode parent, T value, TreeNode left, TreeNode right) {
        this.parent = parent;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public TreeNode<T> setParent(TreeNode parent) {
        this.parent = parent;
        return this;
    }

    public T getValue() {
        return value;
    }

    public TreeNode<T> setValue(T value) {
        this.value = value;
        return this;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> setLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public TreeNode<T> setRight(TreeNode right) {
        this.right = right;
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
