package im.joshua.leetcode.topic;

public class LeetCode_9 extends LeetCodeTopic {
    /*
        判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

        示例 1:
        输入: 121
        输出: true

        示例 2:
        输入: -121
        输出: false
        解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

        示例 3:
        输入: 10
        输出: false
        解释: 从右向左读, 为 01 。因此它不是一个回文数。
        进阶:

        你能不将整数转为字符串来解决这个问题吗？

        Related Topics
        数学
    */
    public static void main(String[] args) {
        LeetCodeTopic t9 = new LeetCode_9(242);
        System.out.println(t9.solve());
    }

    private int x;

    public LeetCode_9(int x) {
        this.x = x;
    }

    @Override
    protected void formatParams() {
        params.addProperty("x", x);
    }

    @Override
    protected String solution() {
        if (x < 0 || x != 0 && x % 10 == 0)
            return String.valueOf(false);

        int r = 0;
        while (x > r) {
            r = r * 10 + x % 10;
            x /= 10;
        }

        if (x == r || r / 10 == x) {
            return String.valueOf(true);
        }

        return String.valueOf(false);
    }
}
