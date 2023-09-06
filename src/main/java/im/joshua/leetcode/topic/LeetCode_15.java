package im.joshua.leetcode.topic;

import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2023/9/5 21:44
 */
public class LeetCode_15 extends LeetCodeTopic<List<List<Integer>>> {

    int[] nums;

    public LeetCode_15(int[] nums) {
        this.nums = nums;
    }

    public static void main(String[] args) {
        LeetCodeTopic topic = new LeetCode_15(new int[]{0, 0, 0, 0, 0, 0, 0});
        System.out.println(topic.solve());
    }

    @Override
    protected void formatParams() {
        JsonArray jarr = new JsonArray();
        for (int num : nums) {
            jarr.add(num);
        }
        params.add("nums", jarr);
    }

    @Override
    protected List<List<Integer>> solution() {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();

        for (int first = 0, len = nums.length; first < len; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) continue;

            // c 对应的指针初始指向数组的最右端
            int third = len - 1;
            int target = -nums[first];

            // 枚举 b
            for (int second = first + 1; second < len; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;

                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> an = new ArrayList<>();
                    an.add(nums[first]);
                    an.add(nums[second]);
                    an.add(nums[third]);
                    answer.add(an);
                }
            }
        }

        return answer;
    }
}
