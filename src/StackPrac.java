public class StackPrac {
    private int top;
    private int[] stackArray;
    private int maxSize;

    public StackPrac(int size) {
        this.top = -1;
        this.maxSize = size;
        this.stackArray = new int[maxSize];
    }

    private void push(int data){
        if (!isFull()){
            top++;
            stackArray[top] = data;
        } else {
            throw new IllegalArgumentException("스택이 꽉 찼습니다");
        }
    }

    private int pop(){
        if (!isEmpty()){
            int data = stackArray[top];
            top--;
            return data;
        } else {
            throw new IllegalArgumentException("스택이 비어있습니다");
        }
    }
    private int peek(){
        if (!isEmpty()){
            return stackArray[top];
        } else {
            throw new IllegalArgumentException("스택이 비어있습니다");
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
