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
    val topic = LeetCode_5("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab")
    println(topic.solve())
}

class LeetCode_5(val s: String) : LeetCodeTopic() {

    override fun formatParams() {
        params.addProperty("s", s)
    }

    var max = ""
    override fun solution(): String {
        loopMain@
        for ((index, start) in s.toCharArray().withIndex()) {
            val lastIndex = s.lastIndexOf(start)
            val subStr = s.substring(index, lastIndex + 1)
            if (lastIndex - index < 3) {
                max = pickMax(max, subStr)
                continue@loopMain
            }

            val tmp = subFunc(subStr)
            if (!tmp.isNullOrEmpty()) {
                println("[match]:$subStr")
                max = pickMax(max, tmp)
            }
        }

        return max
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