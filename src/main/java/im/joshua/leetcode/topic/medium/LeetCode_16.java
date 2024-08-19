package im.joshua.leetcode.topic.medium;

import com.google.gson.JsonArray;
import im.joshua.leetcode.topic.LeetCodeTopic;

import java.util.*;

/**
 * @description:
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2023/9/6 11:18
 */
public class LeetCode_16 extends LeetCodeTopic<Integer> {

    int[] nums;
    int target;

    public LeetCode_16(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    public static void main(String[] args) {
        LeetCodeTopic topic = new LeetCode_16(new int[]{-1, 2, -3, 4, -5, 6, -7, 8}, 6);
        System.out.println(topic.solve());
    }

    @Override
    protected void formatParams() {
        params.addProperty("target", target);
        JsonArray jarr = new JsonArray();
        for (int num : nums) {
            jarr.add(num);
        }
        params.add("nums", jarr);
    }

    @Override
    protected Integer solution() {
        Arrays.sort(nums);
        int size = nums.length;
        List<Integer> results = new ArrayList<>();

        Integer preRes = null;

        for (int a = 0; a < size; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;

            for (int b = a + 1; b < size; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;

                int c = size - 1;
                int r = 0;
                while (b < c && (r = nums[a] + nums[b] + nums[c]) > target) {
                    c--;
                }

                if (r > target) {
                    c--;
                } else if (r < target) {
                    break;
                } else {
                    return r;
                }

                if (preRes == null) {
                    preRes = target - (nums[a] + nums[b] + nums[c]);
                }
                c--;
                while (b < c) {
                    int r = target - (nums[a] + nums[b] + nums[c]);
                    if (Math.abs(r) < Math.abs(preRes)) {

                    } else {

                    }
                }
            }
        }

        return target - preRes;
    }
}
