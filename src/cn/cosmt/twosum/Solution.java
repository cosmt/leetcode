package cn.cosmt.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 */
public class Solution {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
     * <p>
     * <p>
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        // 循环所有数据，将每个数字对应的解存入map，
        Map map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{(int) map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return nums;
    }

    //大神的答案
    public static int[] twoSum1(int[] nums, int target) {
        int[] map = new int[2048];
        for (int i = 0; i < nums.length; i++) {
            int b = map[(target - nums[i]) & 2047];
            if (b != 0) {
                return new int[]{b - 1, i};
            }
            map[nums[i] & 2047] = i + 1;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15,3000,4000};
        int target = 7000;
        int[] ints = twoSum1(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}