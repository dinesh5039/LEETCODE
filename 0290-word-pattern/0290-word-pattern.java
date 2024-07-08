class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        Map<String, Integer> wordIndexMap = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            char c = pattern.charAt(i);
            String word = words[i];           
            Integer charIndex = charIndexMap.put(c, i);
            Integer wordIndex = wordIndexMap.put(word, i);
            if (!Objects.equals(charIndex, wordIndex)) {
                return false;
            }
        }

        return true;
    }
}