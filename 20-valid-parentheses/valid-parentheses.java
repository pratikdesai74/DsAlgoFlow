class Solution {
    public boolean isValid(String s) {
        int n= s.length();
        Map<Character,Character> map=new HashMap<>();

        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> stk=new Stack<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(map.containsKey(ch)){
                stk.push(ch);
            }
            else{
                if(!stk.empty() && ch == map.get(stk.peek())){
                    stk.pop();
                }
                else{
                    return false;
                }
            }
        }

        return stk.empty();
    }
}