package com.kawo.algorithm.code.weeka.impl

import com.kawo.algorithm.code.weeka.agreement.WeekAHomeWorkAgreement
import java.util.*
import kotlin.math.max
import kotlin.math.min

class WeekAHomeWork : WeekAHomeWorkAgreement {

    override fun maxArea(height: Array<Int>): Int {
        var left = 0
        var right : Int = height.size - 1
        var result = 0
        while (left < right){
            val w = right.minus(left)
            val h = min(height[left], height[right])
            result = max(result, w*h)
            if(height[left] < height[right]){
                left ++
            }else{
                right --
            }
        }
        return result
    }

    override fun moveZeroes(nums: Array<Int>) {
        var j = 0
        for (num in nums)if(num !=0){ nums[j++] = num}
        for (i in j until nums.size){ nums[i] = 0 }
    }

    override fun climbStairs(n: Int): Int {
        if (n == 1){
            return 1
        }else if (n == 2){
            return 2
        }
        var result = 2
        result = climbStairs(n-1) + climbStairs(n - 2)
        return result
    }

    override fun threeSum(nums: Array<Int>): List<List<Int>> {
        Arrays.sort(nums);
        val result = LinkedList<List<Int>>()
        for (k in 0 until  nums.size - 1){
            var left = k+1
            var right = nums.size -1
            var num = nums[k]
            if(num > 0) break
            if (k > 0 && nums[k] == nums[k -1]) continue
            while (left < right){
                var count = num + nums[left] + nums[right]
                if(count > 0){
                    while (left < right && nums[right] == nums[--right]);
                }else if (count < 0){
                    while (left < right && nums[left] == nums[++left]);
                }else{
                    result.add(listOf(num,nums[right],nums[left]))
                    while (left < right && nums[right] == nums[--right]);
                    while (left < right && nums[left] == nums[++left]);
                }
            }
        }
        return result
    }

    override fun <NodeType> reverseKGroup(head: NodeType, k: Int): NodeType {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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