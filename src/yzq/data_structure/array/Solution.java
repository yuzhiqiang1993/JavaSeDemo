package yzq.data_structure.array;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {-1, -2, -3, -4, -5};
        Solution solution = new Solution();
        int[] ints = solution.twoSum(nums, -8);

        System.out.println("ints = " + Arrays.toString(ints));

    }

    public int[] twoSum(int[] nums, int target) {


//        用来存储遍历过的数据的值和对应的下标
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>(nums.length - 1);
        hashMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            /*计算差额*/
            int temp = target - nums[i];
            /*先判断HashMap中是否存在差额值，存在的话直接返回即可*/
            if (hashMap.containsKey(temp)) {
                return new int[]{hashMap.get(temp), i};
            }
            /*不存在则将该数据存入hash表中*/
            hashMap.put(nums[i], i);
        }

        return new int[]{-1, -1};

    }


}
