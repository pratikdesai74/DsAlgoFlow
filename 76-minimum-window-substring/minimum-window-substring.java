class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";

        Map<Character,Integer> map=new HashMap<>();

        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        } 

        int left=0, right=0;
        int count=map.size();
        String minLengthSubString="";

        while(right<s.length()){
            char chr=s.charAt(right);
            if(map.containsKey(chr)){
                map.put(chr,map.get(chr)-1);
                if(map.get(chr)==0){
                    count--;
                }
            }
            
            if(count==0){
                
                while(left <= right){
                    char ch=s.charAt(left);

                    if(map.containsKey(ch)){
                        if(map.get(ch)+1 <=0){
                            map.put(ch,map.get(ch)+1);
                            left++;
                        }
                        else
                            break;
                    }
                    else{
                        left++;
                    }
                }

                String currString=s.substring(left,right+1);
                if(minLengthSubString.isEmpty() || currString.length() < minLengthSubString.length())
                    minLengthSubString=currString;

            }
            right++;
        }

        return minLengthSubString;
    }
}