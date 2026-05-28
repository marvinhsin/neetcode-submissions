class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // 1. Build the initial frequency arrays
        for (int i = 0; i < n1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // 2. Slide the window across s2
        for (int i = 0; i < n2 - n1; i++) {
            if (matches(count1, count2)) return true;
            
            // Move window: add next char, remove oldest char
            count2[s2.charAt(i + n1) - 'a']++;
            count2[s2.charAt(i) - 'a']--;
        }

        // 3. Check the final window
        return matches(count1, count2);
    }

    private boolean matches(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }
}
