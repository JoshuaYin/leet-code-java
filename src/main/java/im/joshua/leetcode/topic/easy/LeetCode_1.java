package im.joshua.leetcode.topic.easy;

import com.google.gson.JsonArray;
import im.joshua.leetcode.topic.LeetCodeTopic;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1 extends LeetCodeTopic {

    public static void main(String[] args) {
        LeetCodeTopic t1 = new LeetCode_1(new int[]{2, 5, 8, 12, 24, 63}, 32);
        System.out.println(t1.solve());
    }

    private final int[] nums;
    private final int target;

    public LeetCode_1(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    @Override
    protected void formatParams() {
        JsonArray jsonNums = new JsonArray();
        for (int num : nums)
            jsonNums.add(num);
        params.add("nums", jsonNums);
        params.addProperty("target", target);
    }

    @Override
    public String solution() {
        if (nums == null || nums.length == 0)
            return MSG_INPUT_PARAM_WRONG;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            if (map.containsKey(nums[i])) {
                int left = map.get(nums[i]);
                return String.format("[%d, %d]", left, i);
            } else {
                map.put(target - nums[i], i);
            }
        }

        return MSG_NO_SOLUTION;
    }
}
