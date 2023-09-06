package im.joshua.leetcode.topic.easy

import im.joshua.leetcode.topic.LeetCodeTopic
import im.joshua.leetcode.util.TreeNode


/**
 * @description:
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2020/8/5 16:10
 */


fun main(args: Array<String>) {
    val topic = LeetCode_543(makeRoot(listOf(1, 2, 2, 3, 4, 4, 3)))
    println(topic.solve())
}

class LeetCode_543(val root: TreeNode<Int>?) : LeetCodeTopic<Int>() {

    override fun formatParams() {
        params.addProperty("root", root?.toString())
    }

    override fun solution(): Int {

        return 0
    }

    fun check(p: TreeNode<Int>?, q: TreeNode<Int>?): Boolean {
        if (p == null || q == null) false
        if (p == null && q == null) true

        return p!!.value == q!!.value && check(p.left, q.right) && check(p.right, q.left)
    }

}