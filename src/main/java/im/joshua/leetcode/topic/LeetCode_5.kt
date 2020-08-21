package im.joshua.leetcode.topic

import java.util.*

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
    val topic = LeetCode_5("abacabbacad")
    println(topic.solve())
}

class LeetCode_5(val s: String) : LeetCodeTopic() {

    override fun formatParams() {
        params.addProperty("s", s)
    }

    var max = ""
    override fun solution(): String {
        val len = s.length
        if (len < 2)
            return s

        val dp: Array<BooleanArray> = Array(len) { BooleanArray(len) { false } }

        for (i in 0 until len) {
            dp[i][i] = true
        }

        val charArr = s.toCharArray()
        var maxLen = 1
        var start = 0

        for (j in 1 until len) {
            // 只有下面这一行和「参考代码 2」不同，i 正着写、倒过来写都行，因为子串都有参考值
            for (i in (j - 1) downTo 0) {
                println("[$i]:${charArr[i]} [$j]:${charArr[j]}")
                if (charArr[i] == charArr[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true
                    } else {
                        println("else-> [${i + 1}]:${charArr[i + 1]} [${j - 1}]:${charArr[j - 1]}")
                        dp[i][j] = dp[i + 1][j - 1]
                    }
                } else {
                    dp[i][j] = false
                }
                println("dp[$i][$j]:${dp[i][j]}")

                // 只要 dp[i][j] == true 成立，就表示子串 s[i, j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j]) {
                    val curLen = j - i + 1
                    if (curLen > maxLen) {
                        maxLen = curLen
                        start = i
                    }
                }
            }

            println("-------------------------------------")
        }

        for (i in 0 until len) {
            var sb = StringBuilder()
            for (j in 0 until len) {
                sb.append("[$i][$j]:${dp[i][j]}\t")
            }
            println(sb.toString())
        }

        return s.substring(start, start + maxLen)
    }

    private fun pickMax(old: String, new: String): String {
        if (old.length > new.length)
            return old

        return new
    }

    private fun subFunc(str: String): String? {
        val len = str.length
        val start = str[0]
//        println("[start]: $start\t[leng]: $len\t[sub]: $str")
        var left = 0
        var right = len - 1
        while (left < right) {
//            println("sub[$i]:${str[i]} sub[${len - 1 - i}]:${str[len - 1 - i]}")
            if (str[left] != str[right]) {
                return if (str.count { it == start } > 2) {
                    val sub = str.substring(0, str.substring(0, len - 1).lastIndexOf(start) + 1)
                    return if (max.isEmpty() || sub.length > max.length)
                        subFunc(sub)
                    else null
                } else {
                    null
                }
            }
            left++
            right--
        }

        return str
    }

}