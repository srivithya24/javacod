import java.util.Stack;
import java.util.HashMap;

class Solution {
    public boolean isValid(String s) {
        // 1. Initialize the stack
        Stack<Character> stack = new Stack<>();
        
        // 2. Create the mapping for closing to opening brackets
        HashMap<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 3. If the character is a closing bracket
            if (mapping.containsKey(c)) {
                // Get the top element of the stack. If empty, use a dummy value
                char topElement = stack.isEmpty() ? '#' : stack.pop();

                // If the mapping doesn't match the popped element, return false
                if (topElement != mapping.get(c)) {
                    return false;
                }
            } else {
                // 4. If it's an opening bracket, push it onto the stack
                stack.push(c);
            }
        }

        // 5. If the stack is empty, it's valid
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid("()"));      // true
        System.out.println(sol.isValid("()[]{}"));  // true
        System.out.println(sol.isValid("(]"));      // false
        System.out.println(sol.isValid("([])"));    // true
        System.out.println(sol.isValid("([)]"));    // false
    }
}
