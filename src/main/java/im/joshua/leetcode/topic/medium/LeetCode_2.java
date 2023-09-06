package im.joshua.leetcode.topic.medium;

import im.joshua.leetcode.topic.LeetCodeTopic;
import im.joshua.leetcode.util.ListNode;

public class LeetCode_2 extends LeetCodeTopic {

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
