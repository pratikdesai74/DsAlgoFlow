class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
            
        int[] charFrequency=new int[26];

        for(char ch:s.toCharArray()){
            charFrequency[ch-'a']++;
        }

        for(char ch:t.toCharArray()){
            charFrequency[ch-'a']--;
        }

        for(int num:charFrequency){
            if(num!=0)
                return false;
        }

        return true;
    }
}