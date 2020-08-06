package im.joshua.leetcode.topic;

import im.joshua.leetcode.util.ListNode;

public class LeetCode_2 extends LeetCodeTopic {
/*
    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    示例：

    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
    Related Topics
    链表
    数学
*/

    public static void main(String[] args) {
        LeetCodeTopic t2 = new LeetCode_2(parse("4-6-8"),
                parse("3-6"));
        System.out.println(t2.solve());
    }

    private ListNode<Integer> l1, l2;

    public LeetCode_2(ListNode<Integer> l1, ListNode<Integer> l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    @Override
    protected void formatParams() {
        params.addProperty("l1", l1.toString());
        params.addProperty("l2", l2.toString());
    }

    @Override
    public String solution() {
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode cursor = res;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.getVal().intValue();
            int n2 = l2 == null ? 0 : l2.getVal().intValue();

            int r = n1 + n2 + carry;
            carry = r / 10;
            r = r % 10;
            cursor.setNext(new ListNode(r));
            cursor = cursor.getNext();

            if (l1 != null)
                l1 = l1.getNext();
            if (l2 != null)
                l2 = l2.getNext();
        }

        if (carry != 0)
            cursor.setNext(new ListNode(carry));

        return res.getNext() == null ? "null" : res.getNext().toString();
    }

    public static ListNode<Integer> parse(String list) {
        String[] split = list.split("-");
        ListNode res = null;
        ListNode cursor = null;
        for (String s : split) {
            if (res == null) {
                res = new ListNode(Integer.parseInt(s));
                cursor = res;
            } else {
                cursor.setNext(new ListNode(Integer.parseInt(s)));
                cursor = cursor.getNext();
            }
        }

        return res;
    }
}
