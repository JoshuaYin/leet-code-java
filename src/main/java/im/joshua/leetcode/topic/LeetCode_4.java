package im.joshua.leetcode.topic;

import com.google.gson.JsonArray;

public class LeetCode_4 extends LeetCodeTopic {
/*
    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

    你可以假设 nums1 和 nums2 不会同时为空。

    示例 1:

    nums1 = [1, 3]
    nums2 = [2]

    则中位数是 2.0
    示例 2:

    nums1 = [1, 2]
    nums2 = [3, 4]

    则中位数是 (2 + 3)/2 = 2.5
    Related Topics
    数组
    二分查找
    分治算法
*/

    public static void main(String[] args) {
        LeetCodeTopic t4 = new LeetCode_4(new int[]{2,3,4}, new int[]{1});
        System.out.println(t4.solve());
        System.out.println((-1/2)+"");
    }

    private int[] num1, num2;

    public LeetCode_4(int[] num1, int[] num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    protected void formatParams() {
        JsonArray jArrNum1 = new JsonArray();
        if (num1 != null)
            for (int n : num1) {
                jArrNum1.add(n);
            }

        JsonArray jArrNum2 = new JsonArray();
        if (num2 != null)
            for (int n : num2) {
                jArrNum2.add(n);
            }
        params.add("num1", jArrNum1);
        params.add("num2", jArrNum2);
    }

    @Override
    public String solution() {
        int len1 = num1 == null ? 0 : num1.length;
        int len2 = num2 == null ? 0 : num2.length;
        int[] array = num1;

        for (int i = 0; i < len2; i++)
            array = insert(num2[i], array);

        for (int n : array)
            System.out.print(n + "\t");

        if ((len1 + len2) % 2 == 0) {
            int index = (len1 + len2) / 2;
            return String.valueOf((array[index - 1] + array[index]) / 2.f);
        } else {
            return String.valueOf(array[(len1 + len2) / 2]);
        }

    }

    private int[] insert(int n, int[] src) {
        if (src == null)
            return null;

        int len = src.length;
        if (len == 0)
            return new int[]{n};

        int start = 0;
        int end = len - 1;
        int mid = (start + end) / 2;

        boolean isEqual = false;
        while ((end - start + 1) > 2) {
            if (n == src[mid]) {
                isEqual = true;
                break;
            }

            if (n > src[mid]) {
                start = mid;
            } else {
                end = mid;
            }
            mid = (start + end) / 2;
        }

        if (!isEqual) {
            if (n >= src[end])
                mid = end + 1;
            else if (n < src[start])
                mid = start;
            else
                mid = end;
        }

        int[] res = new int[len + 1];
        for (int i = 0; i < (len + 1); i++) {
            if (i == mid) {
                res[i] = n;
            } else if (i > mid) {
                res[i] = src[i - 1];
            } else {
                res[i] = src[i];
            }
        }

        return res;
    }


}
