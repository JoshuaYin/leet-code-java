package im.joshua.leetcode.topic

import im.joshua.leetcode.util.TreeNode
import kotlin.math.ceil
import kotlin.math.log2
import kotlin.math.pow


/**
 * @description:
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2020/8/5 16:10
 */


fun main(args: Array<String>) {
    val topic = LeetCode_101(makeRoot(listOf(1, 2, 2, 3, 4, 4, 3)))

//    println(topic.solve())
}

fun makeRoot(array: List<Int?>): TreeNode<Int>? {
    if (array.isNullOrEmpty()) return null
    val len = array.size
    val lineCount = ceil(log2(len.toFloat())).toInt()
    println("len=$len lineCount=$lineCount")

    val iterator = array.iterator()
    val root = TreeNode(iterator.next())
    var cur = root

    for (line in 1..lineCount) {
        val nodeLine = mutableListOf<TreeNode<Int>?>()
        val lineNodeMax = 2.0.pow(line).toInt()
        var count = 0
        for (count in 0 until lineNodeMax) {
            if (iterator.hasNext()) {
                val value = iterator.next()
                nodeLine.add(if (value == null) null else TreeNode(value))
            } else {
                nodeLine.add(null)
            }
        }
    }

    return TreeNode(1)
}

class LeetCode_101(val root: TreeNode<Int>?) : LeetCodeTopic<Boolean>() {

    override fun formatParams() {
        params.addProperty("root", root?.toString())
    }

    override fun solution(): Boolean {
        return check(root, root)
    }

    fun check(p: TreeNode<Int>?, q: TreeNode<Int>?): Boolean {
        if (p == null || q == null) false
        if (p == null && q == null) true

        return p!!.value == q!!.value && check(p.left, q.right) && check(p.right, q.left)
    }

}