public class regExMatching {
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        // empty s vs pattern like a*, a*b*, ...
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pj = p.charAt(j - 1);

                if (pj != '*') {
                    // normal char or '.'
                    if (charMatch(s.charAt(i - 1), pj)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    // '*' case: p[j-1] == '*', preceding is p[j-2]
                    // option 1: use zero occurrences
                    dp[i][j] = dp[i][j - 2];

                    // option 2: use one or more occurrences if preceding matches
                    char prev = p.charAt(j - 2);
                    if (charMatch(s.charAt(i - 1), prev)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }

    private static boolean charMatch(char sc, char pc) {
        return pc == '.' || sc == pc;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));    // false
        System.out.println(isMatch("aa", "a*"));   // true
        System.out.println(isMatch("ab", ".*"));   // true
        System.out.println(isMatch("aab", "c*a*b"));// true
    }




}
