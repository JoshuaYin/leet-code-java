package im.joshua.leetcode.topic;

import com.google.gson.JsonArray;

/**
 * @description:
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2023/1/11 11:17
 */
public class LeetCode_11 extends LeetCodeTopic<Integer> {
    int[] heights;

    public LeetCode_11(int[] heights) {
        this.heights = heights;
    }

    public static void main(String[] args) {
        LeetCodeTopic topic = new LeetCode_11(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(topic.solve());
    }

    @Override
    protected void formatParams() {
        JsonArray jarr = new JsonArray();
        for (int i : heights) {
            jarr.add(i);
        }
        params.add("height", jarr);
    }

    @Override
    protected Integer solution() {
        int max = 0;
        int i = 0;
        int j = heights.length - 1;
        do {
            int width = j - i;
            int left = heights[i];
            int right = heights[j];
            int area = Math.min(left, right) * width;
            if (area > max) max = area;
            if (left < right) {
                i++;
            } else {
                j--;
            }
        } while (i < j);

        return max;
    }
}
