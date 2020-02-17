package im.joshua.leetcode.util;

public class ListNode<T> {
    private ListNode previous;
    private T val;
    private ListNode next;

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(ListNode previous, T val) {
        this.previous = previous;
        this.val = val;
    }

    public ListNode(T val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(ListNode previous, T val, ListNode next) {
        this.previous = previous;
        this.val = val;
        this.next = next;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public ListNode getPrevious() {
        return previous;
    }

    public ListNode<T> setPrevious(ListNode previous) {
        this.previous = previous;
        return this;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }


    @Override
    public String toString() {
        ListNode tmp = this;
        StringBuilder sb = new StringBuilder(String.valueOf(val));
        while (tmp.next != null) {
            tmp = tmp.next;
            sb.append("->").append(tmp.val);
        }

        return sb.toString();
    }
}