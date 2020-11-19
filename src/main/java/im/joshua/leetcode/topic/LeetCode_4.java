package im.joshua.leetcode.topic;

import com.google.gson.JsonArray;

import java.util.Arrays;

public class LeetCode_4 extends LeetCodeTopic {

    public static void main(String[] args) {
        LeetCodeTopic t4 = new LeetCode_4(new int[]{2, 3, 4}, new int[]{1});
        System.out.println(t4.solve());
    }

    private final int[] num1;
    private final int[] num2;

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
        System.out.println("[after insert]:" + Arrays.toString(array));
        if ((len1 + len2) % 2 == 0) {
            int index = (len1 + len2) / 2;
            return String.valueOf((array[index - 1] + array[index]) / 2.f);
        } else {
            return String.valueOf(array[(len1 + len2) / 2]);
        }

    }

    private int[] insert(int n, int[] src) {
        if (src == null)
            return new int[]{n};

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
