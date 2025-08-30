class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";

        Map<Character,Integer> map=new HashMap<>();

        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        } 

        int l=0,r=0;
        int count=map.size();
        String minLengthSubString="";

        while(r<s.length()){
            char chr=s.charAt(r);
            if(map.containsKey(chr)){
                map.put(chr,map.get(chr)-1);
                if(map.get(chr)==0){
                    count--;
                }
            }
            
            if(count==0){
                
                while(l<=r){
                    char ch=s.charAt(l);

                    if(map.containsKey(ch)){
                        if(map.get(ch)+1 <=0){
                            map.put(ch,map.get(ch)+1);
                            l++;
                        }
                        else
                            break;
                    }
                    else{
                        l++;
                    }
                }

                String currString=s.substring(l,r+1);
                if(minLengthSubString.isEmpty() || currString.length() < minLengthSubString.length())
                    minLengthSubString=currString;

            }
            r++;
        }

        return minLengthSubString;
    }
}