import java.util.Stack;

class Solution {

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        // Split path using "/"
        String[] parts = path.split("/");

        for (String part : parts) {

            // Ignore empty strings and "."
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Handle ".."
            else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Valid folder name
            else {
                stack.push(part);
            }
        }

        // Build simplified path
        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }

        // Return root if empty
        return result.length() == 0 ? "/" : result.toString();
    }
}
