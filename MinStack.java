import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    // Constructor
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element
    public void push(int val) {
        stack.push(val);

        // If minStack is empty OR val is smaller, push val
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            // Push current minimum again
            minStack.push(minStack.peek());
        }
    }

    // Pop element
    public void pop() {
        stack.pop();
        minStack.pop();
    }

    // Get top element
    public int top() {
        return stack.peek();
    }

    // Get minimum element
    public int getMin() {
        return minStack.peek();
    }
}
