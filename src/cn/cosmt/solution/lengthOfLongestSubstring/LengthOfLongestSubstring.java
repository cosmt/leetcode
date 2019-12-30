package cn.cosmt.solution.lengthOfLongestSubstring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {


    //    简单处理的
    public static int lengthOfLongestSubstring(String s) {


        //参数判断
        if (s == null || "".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        } else {
            //返回的结果
            int result = 1;
            //截取子串
            for (int start = 0; start <= s.length() - 1; start++) {
                for (int end = start + 1; end <= s.length(); end++) {
                    //截取每次的子串
                    String tmpStr = s.substring(start, end);
                    //判断新子串的最后一个字符在新子串的重复位置.
                    int index = tmpStr.indexOf(s.charAt(end - 1));
                    //如果不是最后一个位置，即新的子串中有重复的
                    if (index == tmpStr.length() - 1) {
                        result = tmpStr.length() > result ? tmpStr.length() : result;
                    } else {
                        start += index;
                        break;
                    }
                }
            }
            return result;
        }
    }

    //    优秀答案
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int result = 0, i = 0, j = 0;
        while (i < n && j < n) {
            //如果set中不包含char字符，
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcdeffad";
        System.out.println(lengthOfLongestSubstring2(s));
    }
}
