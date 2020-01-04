package cn.cosmt.solution.longestPalindrome;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    //    先解决问题  超时
    public static String longestPalindrome(String s) {
//      参数判断
        if (s == null) {
            return null;
        }
        int start = 0, end = 0;
//      循环所有节点，找出每个节点的最长回文串
        for (int i = 0; i < s.length(); i++) {
//          判断左右节点是否相同
            for (int j = i + 1; j <= s.length(); j++) {
                String tmp = s.substring(i, j);
                int tmpLen = j - i;
                if (tmpLen > (end - start) && isPalindrome(s, i, j)) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end);
    }

    public static boolean isPalindrome(String tmp, int i, int j) {
        int n = j - i;
        for (int k = 0; k < n / 2; k++) {
            if (tmp.charAt(k + i) != tmp.charAt(n - k - 1 + i)) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s = "klvxwqyzugrdoaccdafdfrvxiowkcuedfhoixzipxrkzbvpusslsgfjocvidnpsnkqdfnnzzawzsslwnvvjyoignsfbxkgrokzyusxikxumrxlzzrnbtrixxfioormoyyejashrowjqqzifacecvoruwkuessttlexvdptuvodoavsjaepvrfvbdhumtuvxufzzyowiswokioyjtzzmevttheeyjqcldllxvjraeyflthntsmipaoyjixygbtbvbnnrmlwwkeikhnnmlfspjgmcxwbjyhomfjdcnogqjviggklplpznfwjydkxzjkoskvqvnxfzdrsmooyciwulvtlmvnjbbmffureoilszlonibbcwfsjzguxqrjwypwrskhrttvnqoqisdfuifqnabzbvyzgbxfvmcomneykfmycevnrcsyqclamfxskmsxreptpxqxqidvjbuduktnwwoztvkuebfdigmjqfuolqzvjincchlmbrxpqgguwuyhrdtwqkdlqidlxzqktgzktihvlwsbysjeykiwokyqaskjjngovbagspyspeghutyoeahhgynzsyaszlirmlekpboywqdliumihwnsnwjc";
        System.out.println(longestPalindrome(s));
        System.out.println(System.currentTimeMillis() - start);
    }
}