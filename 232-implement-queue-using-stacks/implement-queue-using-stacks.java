//method 1(teachers approach):  push always in input queue and for pop/peek use output queue 
//if output queue is empty while peek/pop, (ulti bottel) push all elelments till now
//in input queue into output queue and the do peek /pop 
class MyQueue {
    public Stack<Integer> output;
    public Stack<Integer> input;
    public MyQueue() {
        output=new Stack<>();
        input=new Stack<>();
    }
    
    public void fillOutputWithInputStack(){ 
        if(output.empty()){
            while(!input.empty()){
                int topElement= input.pop();
                output.push(topElement);
            }
        }    
    }

    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        fillOutputWithInputStack();
        return output.pop();
    }
    
    public int peek() {
        fillOutputWithInputStack();
        return output.peek();
    }
    
    public boolean empty() {
        return input.empty() && output.empty();
    }
}

//method 2:  maintin queue like order while pushing the element (our approach)
// class MyQueue {
//     public Stack<Integer> stkMain;
//     public Stack<Integer> stkSupport;
//     public MyQueue() {
//         stkMain=new Stack<>();
//         stkSupport=new Stack<>();
//     }
    
//     public void push(int x) {
//         while(!stkMain.empty()){
//             int topElement= stkMain.peek();
//             stkMain.pop();
//             stkSupport.push(topElement);
//         }
//         stkMain.push(x);

//         while(!stkSupport.empty()){
//             int topElement= stkSupport.peek();
//             stkSupport.pop();
//             stkMain.push(topElement);
//         }
//     }
    
//     public int pop() {
//         int topElement= stkMain.peek();
//         return stkMain.pop();
//     }
    
//     public int peek() {
//         return stkMain.peek();
//     }
    
//     public boolean empty() {
//         return stkMain.empty();
//     }
// }
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */