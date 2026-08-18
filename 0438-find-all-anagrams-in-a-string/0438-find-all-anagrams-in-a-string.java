class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length()) {
            return ans;
        }

        int[] freq = new int[26];

        // Frequency of characters in p
        for (char ch : p.toCharArray()) {
            freq[ch - 'a']++;
        }

        int windowSize = p.length();

        // Sliding window
        for (int i = 0; i < s.length(); i++) {

            // Add current character
            freq[s.charAt(i) - 'a']--;

            // Remove character outside window
            if (i >= windowSize) {
                freq[s.charAt(i - windowSize) - 'a']++;
            }

            // If all frequencies are zero
            if (i >= windowSize - 1 && isAnagram(freq)) {
                ans.add(i - windowSize + 1);
            }
        }

        return ans;
    }

    private boolean isAnagram(int[] freq) {
        for (int x : freq) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }
}