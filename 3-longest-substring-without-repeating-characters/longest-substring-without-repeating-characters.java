class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueChars= new HashSet<>();
        int longestSubstringLength=0;
        int l=0,r=0;
        
        while(r <s.length()){
            while(uniqueChars.contains(s.charAt(r))){
                uniqueChars.remove(s.charAt(l));
                l++;
            }
            uniqueChars.add(s.charAt(r));
            
            longestSubstringLength=Math.max(longestSubstringLength,r-l+1);
            r++;
        }

        return longestSubstringLength;
    }
}