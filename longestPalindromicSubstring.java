public class longestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int start = 0, end = 0; // inclusive indices of best palindrome

        for (int i = 0; i < s.length(); i++) {
            int[] odd = expand(s, i, i);       // center at i
            int[] even = expand(s, i, i + 1);  // center between i and i+1

            if (odd[1] - odd[0] > end - start) {
                start = odd[0];
                end = odd[1];
            }
            if (even[1] - even[0] > end - start) {
                start = even[0];
                end = even[1];
            }
        }

        return s.substring(start, end + 1);
    }

    // returns [L, R] of the longest palindrome after expanding
    private static int[] expand(String s, int L, int R) {
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        // went 1 step too far, so return last valid
        return new int[]{L + 1, R - 1};
    }

    // quick test
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // "bab" or "aba"
        System.out.println(longestPalindrome("cbbd"));  // "bb"
        System.out.println(longestPalindrome("a"));     // "a"
        System.out.println(longestPalindrome("ac"));    // "a" or "c"
    }
}
