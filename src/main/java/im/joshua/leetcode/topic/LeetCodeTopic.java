package im.joshua.leetcode.topic;

import com.google.gson.JsonObject;

public abstract class LeetCodeTopic<Res> {
    public final static String MSG_INPUT_PARAM_WRONG = "input params is wrong";
    public final static String MSG_NO_SOLUTION = "there is no solution with the input params";

    protected JsonObject params = new JsonObject();

    protected abstract void formatParams();

    protected abstract Res solution();

    public String solve() {
        formatParams();
        long time = System.currentTimeMillis();
        Res answer = solution();
        time = System.currentTimeMillis() - time;
        StringBuilder sb = new StringBuilder("[params]:")
                .append(params)
                .append("\n[answer]:")
                .append(answer);
        sb.append("\n[time]:").append(time).append("ms");
        return sb.toString();
    }
}
