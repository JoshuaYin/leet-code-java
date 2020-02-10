package im.joshua.leetcode.topic;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1 extends LeetCodeTopic {
/*
    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

    示例:

    给定 nums = [2, 7, 11, 15], target = 9

    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
    Related Topics
    数组
    哈希表
*/

    public static void main(String[] args) {
        LeetCodeTopic t1 = new LeetCode_1(new int[]{2, 5, 8, 12, 24, 63}, 32);
        System.out.println(t1.solve());
    }

    private int[] nums;
    private int target;

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
