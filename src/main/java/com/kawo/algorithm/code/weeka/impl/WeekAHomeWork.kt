package com.kawo.algorithm.code.weeka.impl

import com.kawo.algorithm.code.weeka.agreement.WeekAHomeWorkAgreement
import com.kawo.algorithm.code.weeka.vo.Node
import com.kawo.algorithm.common.LOGGER
import java.util.*
import kotlin.math.max
import kotlin.math.min


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

    override fun <NodeType> detectCycle(head: NodeType): NodeType {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <NodeType> hasCycle(head: NodeType): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <NodeType> swapPairs(head: NodeType): NodeType {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <NodeType> reverseList(head: NodeType): NodeType {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun plusOne(digits: IntArray): IntArray {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun twoSum(nums: IntArray, target: Int): IntArray {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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