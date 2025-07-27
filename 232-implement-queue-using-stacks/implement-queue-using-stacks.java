class MyQueue {
    public Stack<Integer> stkMain;
    public Stack<Integer> stkSupport;
    public MyQueue() {
        stkMain=new Stack<>();
        stkSupport=new Stack<>();
    }
    
    public void push(int x) {
        while(!stkMain.empty()){
            int topElement= stkMain.peek();
            stkMain.pop();
            stkSupport.push(topElement);
        }
        stkMain.push(x);

        while(!stkSupport.empty()){
            int topElement= stkSupport.peek();
            stkSupport.pop();
            stkMain.push(topElement);
        }
    }
    
    public int pop() {
        return stkMain.pop();
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