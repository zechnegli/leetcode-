class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        int max = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
    // public int lengthOfLongestSubstring(String s) {
    //     int max = 1;
    //     if (s.length() < 1) {
    //         return 0;
    //     }
    //     for (int i = 0; i < s.length() - 1; i++) {
    //         for (int j = i + 1; j < s.length(); j++) {
    //             if (allUnique(s, i, j)) {
    //                 max = Math.max(max, j - i + 1);
    //             }
    //         }
    //     }
    //     return max;
    // }
    // public boolean allUnique (String s, int start, int end) {
    //     Set<Character> set = new HashSet<>();
    //     for (int i = start; i <= end; i++) {
    //         Character ch = s.charAt(i);
    //         if (set.contains(ch)) {
    //             return false;
    //         } else {
    //             set.add(ch);
    //         }
    //     }
    //     return true;
    // }
}