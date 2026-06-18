class Solution {
    public String simplifyPath(String path) {
        // Splitting cleanly isolates directory names from the slashes
        String[] tokens = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        
        for (String token : tokens) {
            // An empty token happens when there are consecutive slashes (e.g., "///")
            if (token.isEmpty() || token.equals(".")) {
                continue;
            }
            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }
        
        // Reconstructing the path from the bottom of the stack up
        if (stack.isEmpty()) {
            return "/";
        }
        
        StringBuilder sb = new StringBuilder();
        // ArrayDeque iteration works from oldest element to newest element (FIFO order)
        for (String dir : stack) {
            sb.insert(0, "/" + dir);
        }
        
        return sb.toString();
    }
}