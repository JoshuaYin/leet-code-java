package im.joshua.leetcode.topic;

/**
 * @description:
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2023/9/5 18:31
 */
public class LeetCode_12 extends LeetCodeTopic<String> {
    int num;

    public LeetCode_12(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        LeetCodeTopic topic = new LeetCode_12(3456);
        System.out.println(topic.solve());
    }

    @Override
    protected void formatParams() {
        params.addProperty("num", num);
    }

    private final String[] m = new String[]{"", "M", "MM", "MMM"};
    private final String[] h = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private final String[] t = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private final String[] i = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    @Override
    protected String solution() {

        return m[num / 1000] + h[num % 1000 / 100] + t[num % 100 / 10] + i[num % 10];
    }

    String makeStr(int index, int n) {
        StringBuilder sb = new StringBuilder();
        switch (index) {
            case 0: {
                do {
                    sb.append('M');
                } while (--n > 0);
            }
            case 1: {
                do {
                    sb.append('M');
                } while (--n > 0);
            }
        }
        return sb.toString();
    }
}
