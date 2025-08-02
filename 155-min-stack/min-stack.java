class MinStack {
    Stack<List<Integer>> stack;

    public MinStack() {
       stack=new Stack<>(); 
    }
    
    public void push(int val) {
        List<Integer> list=new ArrayList<>(2);
        list.add(val);

        if(stack.empty()){
            list.add(val);
        }
        else{
            int minVal= Math.min(val,stack.peek().get(1));
            list.add(minVal);
        }

        stack.push(list);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().get(0);
    }
    
    public int getMin() {
        return stack.peek().get(1);
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