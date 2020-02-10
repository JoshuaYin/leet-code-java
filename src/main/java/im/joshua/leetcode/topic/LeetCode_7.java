package im.joshua.leetcode.topic;

public class LeetCode_7 extends LeetCodeTopic {
    /*
        给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

        示例 1:

        输入: 123
        输出: 321
        示例 2:

        输入: -123
        输出: -321
        示例 3:

        输入: 120
        输出: 21
        注意:

        假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

        Related Topics
        数学
    */

    public static void main(String[] args) {
        LeetCodeTopic t7 = new LeetCode_7(-2147483648);
        System.out.println(t7.solve());
    }

    private int x;

    public LeetCode_7(int x) {
        this.x = x;
    }

    @Override
    protected void formatParams() {
        params.addProperty("x", x);
    }

    @Override
    protected String solution() {
        long r = 0;
        while (x != 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }

        if (r >= Integer.MIN_VALUE && r <= Integer.MAX_VALUE)
            return String.valueOf((int) r);

        return "0";
    }
}
