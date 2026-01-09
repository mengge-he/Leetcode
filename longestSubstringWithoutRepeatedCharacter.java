import java.util.HashMap;
import java.util.Map;
public class longestSubstringWithoutRepeatedCharacter {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                left = lastSeen.get(c) + 1; // shrink window past the duplicate
            }

            lastSeen.put(c, right);
            best = Math.max(best, right - left + 1);
        }

        return best;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));    // 3
        System.out.println(lengthOfLongestSubstring(""));         // 0
    }
}
