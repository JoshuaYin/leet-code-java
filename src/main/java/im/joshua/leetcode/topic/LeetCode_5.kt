package im.joshua.leetcode.topic

/**
 * @description:
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2020/8/5 16:10
 */

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划
fun main(args: Array<String>) {
    val topic = LeetCode_5("aaabaaaa")
    println(topic.solve())
}

class LeetCode_5(val s: String) : LeetCodeTopic() {

    override fun formatParams() {
        params.addProperty("s", s)
    }

    override fun solution(): String {
        var max = ""

        loopMain@
        for (start in s.indices) {
            val c = s[start]
            var end = s.lastIndexOf(c)

            loopSub1@
            while (end >= start) {
                val subLen = end - start + 1
                println("[$start]:${c} [$end]:${s[end]} [subLen]:$subLen")
                if (subLen > 3) {
                    val mid = subLen / 2
                    println("[mid]:$mid")
                    var match = true
                    for (j in 0..mid) {
                        if (s[start + j] != s[end - j]) {
                            println("not match --> [${start+j}]:${s[start + j]} [${end - j}]:${s[end - j]}")
                            match = false
                            break
                        }
                    }
                    if (match) {
                        val tmpMax = s.substring(start, end + 1)
                        if (tmpMax.length > max.length)
                            max = tmpMax
                    }
                } else {
                    val tmpMax = s.substring(start, end + 1)
                    println("[quick match]:$tmpMax")
                    if (tmpMax.length > max.length)
                        max = tmpMax
                }

                end = s.substring(start, end).lastIndexOf(c) + start
                println("[new end]:$end")
            }
        }

        return max
    }
}