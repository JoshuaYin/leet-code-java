package im.joshua.leetcode.topic;

import im.joshua.leetcode.util.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_3 extends LeetCodeTopic {

    public static void main(String[] args) {
        LeetCodeTopic t3 = new LeetCode_3("dvddfcv");
        System.out.println(t3.solve());
    }

    private final String string;

    public LeetCode_3(String string) {
        this.string = string;
    }

    @Override
    protected void formatParams() {
        params.addProperty("string", string);
    }

    @Override
    public String solution() {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0, len = string.length(); j < len; j++) {
            char c = string.charAt(j);
            System.out.println(String.format("Before->[c]:%s [i]:%d [j]:%d [res]:%d", c, i, j, res));
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c));
            }
            System.out.println("j - i + 1 = " + (j - i + 1));
            res = Math.max(res, j - i + 1);
            map.put(c, j + 1);
            System.out.println(String.format("After->[c]:%s [i]:%d [j]:%d [res]:%d", c, i, j, res));
        }
        return String.valueOf(res);
    }
}
