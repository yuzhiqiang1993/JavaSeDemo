package yzq.data_structure.array

import java.util.*


fun main(args: Array<String>) {
    val nums = intArrayOf(-1, -2, -3, -4, -5)
    val solutionKt = SolutionKt()
    val ints = solutionKt.twoSum(nums, -8)

    println("ints = " + Arrays.toString(ints))
}

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
class SolutionKt {


    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = intArrayOf(-1,-1);


        val hashMap = HashMap<Int, Int>(nums.size - 1)
        hashMap.put(nums[0], 0)

        for (index in 1 until nums.size) {
            val temp = target - nums[index]
            if (hashMap.contains(temp)) {
                result[0] = hashMap.get(temp)!!
                result[1] = index
                return result
            }
            hashMap.put(nums[index], index)
        }

        return result
    }
}

