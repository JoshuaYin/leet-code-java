package im.joshua.leetcode.topic;

import im.joshua.leetcode.util.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_3 extends LeetCodeTopic {
/*
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    示例 1:

    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:

    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:

    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    Related Topics
    哈希表
    双指针
    字符串
    Sliding Window
*/

    public static void main(String[] args) {
        LeetCodeTopic t3 = new LeetCode_3("dvddfcv");
        System.out.println(t3.solve());
    }

    private String string;

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

    public static ListNode<Character> parse(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        char[] chars = str.toCharArray();
        ListNode<Character> res = null;
        ListNode<Character> cursor = null;
        for (char c : chars) {
            if (res == null) {
                res = new ListNode(c);
                cursor = res;
            } else {
                cursor.setNext(new ListNode(cursor, c));
                cursor = cursor.getNext();
            }
        }

        return res;
    }
}
