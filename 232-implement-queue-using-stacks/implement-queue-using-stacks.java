class MyQueue {
    public Stack<Integer> stkMain;
    public Stack<Integer> stkSupport;
    public MyQueue() {
        stkMain=new Stack<>();
        stkSupport=new Stack<>();
    }
    
    public void push(int x) {
        while(!stkMain.empty()){
            int temp= stkMain.peek();
            stkMain.pop();
            stkSupport.push(temp);
        }
        stkMain.push(x);

        while(!stkSupport.empty()){
            int temp= stkSupport.peek();
            stkSupport.pop();
            stkMain.push(temp);
        }
    }
    
    public int pop() {
        int temp= stkMain.peek();
        stkMain.pop();
        return temp;
    }
    
    public int peek() {
        return stkMain.peek();
    }
    
    public boolean empty() {
        return stkMain.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */