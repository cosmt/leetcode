package cn.cosmt.solution.FindMedianSortedArrays;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * <p>
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

//    先解决问题
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        两个数组的总长度
        int n = nums1.length + nums2.length;

//        将两个数组合并
        int[] result = Arrays.copyOf(nums1, n);
        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
//        对新的数组排序
        Arrays.sort(result);

//        计算中位数
        int a = result[((n + 1) / 2) - 1];
        int b = result[((n + 2) / 2) - 1];
        return (a + b) / 2.0;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));

    }
}