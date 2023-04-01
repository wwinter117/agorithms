package cn.wwinter.letcode_01;

import java.util.HashSet;

/**
 * @Author: zhangdongdong
 * @CreateTime: 2023-04-02
 */
public class AgrTest_01 {
    public static void main(String[] args) {
        String s = "abcabcabc";
        int length = lengthOfLongestSubstring(s);
        System.out.println("length = " + length);
    }

    /**
     * 返回一个字符串的不包含重复字符的最长子串的长度
     */
    private static int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();

        // rk-右指针
        int rk = -1;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            // 右指针右移
            while (rk + 1 < s.length() && !hashSet.contains(s.charAt(rk + 1))) {
                hashSet.add(s.charAt(i));
                rk++;
            }
            if (i > 0) {
                hashSet.remove(s.charAt(i - 1));
            }
            maxLength = Math.max(maxLength, rk - i + 1);
        }
        return maxLength;
    }

}
