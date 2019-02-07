package leetcocde.q_3;

import java.util.Arrays;

/**
 * Input: "pwwkew"
 */
public class Solution {

    public static void main(String args[]) {
        System.out.println(new Solution().lengthOfLongestSubstring("1abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int[] lengthArray = new int[s.length()];

        char[] chars = s.toCharArray();
        int limit = 0;
        for (int i = 0; i < chars.length; i++) {
            char _char = chars[i];
            int index = indexOf(_char, limit, i-1, chars);
            if (index != -1) {
                limit = index + 1;
            }

            for (int i1 = limit; i1 <= i; i1++) {
                lengthArray[i1] ++;
            }
        }

        int max = 0;
        for (int i : lengthArray) {
            if (i > max) {
                max = i;
            }
        }
//        System.out.println(Arrays.toString(lengthArray));
        return max;
    }

    private int indexOf(char _char, int limit, int max, char[] chars) {
        for (int i = limit; i <= max; i++) {
            if (chars[i] == _char) {
                return i;
            }
        }

        return  -1;
    }
}
