class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        if(n%2 !=0)
            return false;

        Map<Character,Character> mapOfBrackets=new HashMap<>();
        mapOfBrackets.put(')','(');
        mapOfBrackets.put('}','{');
        mapOfBrackets.put(']','[');

        Stack<Character> stackOfBrackets=new Stack<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(!mapOfBrackets.containsKey(ch)){
                // we received opening bracket
                stackOfBrackets.push(ch);
            }
            else{
                // we received closing bracket
                if(stackOfBrackets.size()>0 && stackOfBrackets.peek() == mapOfBrackets.get(ch)){
                    stackOfBrackets.pop();
                }
                else{
                    return false;
                }
            }
        }

        return stackOfBrackets.size()==0;
    }
}