package com.kawo.algorithm.code.weeka.impl

import com.kawo.algorithm.code.weeka.agreement.WeekAHomeWorkAgreement
import com.kawo.algorithm.code.weeka.vo.Node
import com.kawo.algorithm.common.LOGGER
import java.util.*
import kotlin.math.max
import kotlin.math.min
import java.util.HashMap




class WeekAHomeWork : WeekAHomeWorkAgreement {

    override fun maxArea(height: Array<Int>): Int {
        /**初始化左边界为0*/
        var left = 0
        /**初始化右边界为最右坐标*/
        var right: Int = height.size - 1
        /**初始化结果为0*/
        var result = 0
        /**当左侧与右侧不相遇时执行以下操作*/
        while (left < right) {
            /**右坐标减去左坐标 获得矩形的长*/
            val w = right.minus(left)
            /**比较两根柱子 哪一根比较短就当作宽*/
            val h = min(height[left], height[right])
            /**相乘获得面积*/
            result = max(result, w * h)
            /**当左侧柱子比右侧柱子低时 柱子往内靠近一格 相反 右侧柱子往内靠近一格*/
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }
        return result
    }

    override fun moveZeroes(nums: Array<Int>) {
        var j = 0
        /**循环把非零数字都移动到最前方*/
        for (num in nums) if (num != 0) {
            nums[j++] = num
        }
        /**循环把 数组size - 非零数字size 剩余的数组元素 重置为0*/
        for (i in j until nums.size) {
            nums[i] = 0
        }
    }

    /**
     * 递归完成非波拉契数列
     */
    override fun climbStairs(n: Int): Int {
        if (n == 1) {
            return 1
        } else if (n == 2) {
            return 2
        }
        return  climbStairs(n - 1) + climbStairs(n - 2)
    }

    override fun threeSum(nums: Array<Int>): List<List<Int>> {
        /**排序*/
        Arrays.sort(nums)
        /**初始化结果值*/
        val result = LinkedList<List<Int>>()
        /**外层循环 判断那两个数和他相加为）*/
        for (k in 0 until nums.size - 1) {
            /**初始化左坐标 为k+1*/
            var left = k + 1
            /** 初始化右坐标 为数组size -1*/
            var right = nums.size - 1
            /** 获取外层循环的Item数值*/
            var num = nums[k]
            /** 如果num==0 说明三个数都为正数 相加不会为0 */
            if (num > 0) break
            /** 如果k>0 并且k坐标的数字和k-1坐标数字一致 则则表示该数值已被计算 不必重复计算 跳过即可*/
            if (k > 0 && nums[k] == nums[k - 1]) continue
            /**当两侧不相遇时执行以下代码*/
            while (left < right) {
                /**计算三数之和*/
                var count = num + nums[left] + nums[right]
                /**和大于0时 说明右侧数字过大 把右侧相同的数字通过减下标的形式跳过*/
                if (count > 0) {
                    while (left < right && nums[right] == nums[--right]);
                    /**小于0时 说明左侧数字过小 把左侧相同的数字通过增加下标的形式跳过*/
                } else if (count < 0) {
                    while (left < right && nums[left] == nums[++left]);
                    /**结果匹配 过滤掉相同的数字*/
                } else {
                    result.add(listOf(num, nums[right], nums[left]))
                    while (left < right && nums[right] == nums[--right]);
                    while (left < right && nums[left] == nums[++left]);
                }
            }
        }
        return result
    }

    override fun reverseKGroup(head: Node, k: Int): Node {
        var pre :Node? = null
        var next :Node? = null
        var cur :Node? = head
        var check:Node? = head
        var can = 0
        var count = 0
        /**检查链表长度是否在k范围中*/
        while (can < k && check != null){
            check = check.next
            can +=1
        }
        /**如果链表长度在k范围，反转链表 相反字节返回原链表头*/
        return if(can == k){
            /** 当计数器还在k范围内 并且当前游标不为null*/
            while (count < k  && cur != null){
                next = cur.next /**下个节点赋值*/
                cur.next = pre /**当前节点下个节点赋值为上个节点*/
                pre = cur  /**上个节点赋值为当前节点*/
                cur = next /**把当前节点赋值为下个节点*/
                count ++ /**添加计数器*/
            }
            /**
             * 下个节点不为null时，继续递归反转
             */
            if(next != null){
                head.next = reverseKGroup(next,k)
            }
            return pre!!
        }else{
            head
        }
    }

    override fun detectCycle(head: Node): Node? {
        /**快指针*/
        var fast :Node? = head
        /**慢指针*/
        var slow :Node? = head
        /**循环查找环*/
        while (true) {
            /**如果链表中有值为空，证明此链表无环*/
            if (fast?.next == null) return null
            /**快指针指向当前节点的下下节点*/
            fast = fast?.next?.next
            /**慢指针 指向下一个节点*/
            slow = slow?.next
            /**当下个节点等于下一个证明链表有环 并退出循环*/
            if (fast == slow) break
        }
        /**重置快节点为首节点*/
        fast = head
        /**当快慢节点不同时 也就是首尾没有相交时 执行循环 一直到首尾相接时退出循环 这是快指针就是环的入口*/
        /**快节点走了 慢节点两倍的步数 当快节点设为开始节点时 两个节点再走一半距离两个节点就会相遇 相遇后fast节点就是环入口*/
        while (slow != fast) {
            slow = slow?.next
            fast = fast?.next
        }
        /**返回环的入口节点*/
        return fast
    }

    override fun hasCycle(head: Node): Boolean {
        /**快指针*/
        var fast : Node? = head
        /**慢指针*/
        var slow : Node? = head
        /**当快指针为null 活着快指针的下个节点为null 则无环 反之进入循环校验*/
        while (fast != null || fast?.next == null){
            fast = fast?.next?.next
            slow = slow?.next
            /**快指针 慢指针相遇 该链表有环*/
            if(fast == slow){
                return true
            }
        }
        return false
    }


    override fun swapPairs(head: Node): Node {
        /**把头节点的下个节点置为新节点*/
        val newNode = head.next
        /**当新节点为null时直接返回head 代表剩余元素不足两个 无需反转*/
        if (newNode == null) {
            return head
        /**当新节点不为null时 把头节点的下一个节点重置为头节点的下下个节点 且把新节点的下个节点指向头节点 完成节点转制*/
        } else {
            head.next = newNode.next
            newNode.next = head
        }
        /**当下下个节点不为null时 继续转制剩余节点*/
        if (head.next != null) {
            head.next = swapPairs(head.next!!)
        }
        /**返回转制完成的头节点*/
        return newNode
    }

    override fun reverseList(head: Node): Node {
        /**设置当前坐标*/
        var cur = head
        /**当下个节点不为null时执行*/
        if(head.next != null){
            /**递归转制 下一个坐标*/
            cur = reverseList(head.next!!)
            /**添加反向链表节点*/
            head.next!!.next = head
            /**防止链表有环 置空正向链表节点 使链表结构变为反向*/
            head.next = null
        }
        return cur
    }

    override fun plusOne(digits: Array<Int>): Array<Int> {
        /**倒叙循环*/
        for (i in digits.size - 1 downTo 0) {
            /**每个数字先自增加一*/
            digits[i]++
            /**求余数 用此方法把值为10可以进一位的数字 变为0*/
            digits[i] = digits[i] % 10
            /**当处理完后 当有一位数字不为零时 代表此数组不满足增加新一位的要求 直接返回结果*/
            if (digits[i] !== 0) return digits
        }
        /**新建数组 位数为原数组位数加一 且默认值都为0 因为走到这一步 代表原数组加一后所有的位数均是0 需要新增加一位数组元素到数组头 且首位为1*/
        var digits = Array(digits.size + 1) {0}
        digits[0] = 1
        return digits
    }

    override fun twoSum(nums: Array<Int>, target: Int): Array<Int> {
        /**新建一个HashMap用来存储计算过的值*/
        val map = HashMap<Int, Int>()
        /**遍历计算*/
        for (i in 0 until nums.size) {
            /**获取目标值减去 当前数字的差*/
            val complement = target - nums[i]
            /**看计算过的数字是否有和差值相同的*/
            if (map.containsKey(complement)) {
                /**如果有相同的 从map中拿取坐标 和 当前数字坐标一起返回*/
                return arrayOf(map[complement]!!, i)
            }
            /**如果没有找到合适的值 把当前计算过的数值放到HashMap中缓存*/
            map[nums[i]] = i
        }
        return arrayOf()
    }

    override fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <NodeType> mergeTwoLists(l1: NodeType, l2: NodeType): NodeType {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun rotate(nums: IntArray, k: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeDuplicates(nums: IntArray): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun trap(height: IntArray): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <ValueType, DequeType : Deque<ValueType>> dequeTest(deque: DequeType) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun largestRectangleArea(heights: IntArray): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun minStack() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isValid(s: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}