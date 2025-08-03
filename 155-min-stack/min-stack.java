class MinStack {
    Stack<Pair<Integer,Integer>> stack;

    public MinStack() {
       stack=new Stack<>(); 
    }
    
    public void push(int val) {
        //List<Integer> list=new ArrayList<>(2);
        Pair<Integer,Integer> pair;
        if(stack.empty()){
            pair=new Pair<>(val,val);
        }
        else{
            int minVal= Math.min(val,stack.peek().getValue());
            pair=new Pair<>(val,minVal);
        }

        stack.push(pair);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().getKey();
    }
    
    public int getMin() {
        return stack.peek().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */