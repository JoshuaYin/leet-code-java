package im.joshua.leetcode.topic;

public class LeetCode_7 extends LeetCodeTopic {

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
