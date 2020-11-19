package im.joshua.leetcode.topic;

public class LeetCode_9 extends LeetCodeTopic<String> {
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
