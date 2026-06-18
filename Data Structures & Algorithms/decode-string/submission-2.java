class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder currentString = new StringBuilder();
        int currentK = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Form the multi-digit number safely
                currentK = currentK * 10 + (c - '0');
            } else if (c == '[') {
                // Push the multiplier and the current string context
                countStack.push(currentK);
                stringStack.push(currentString);
                
                // Reset for the nested layer inside the brackets
                currentString = new StringBuilder();
                currentK = 0;
            } else if (c == ']') {
                // Pop the multiplier count
                int repeatTimes = countStack.pop();
                
                // Pop the previous string context we saved before the '['
                StringBuilder decodedString = stringStack.pop();
                
                // Append the current inner string segment k times to the previous string
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                
                // The combined result becomes our new baseline currentString
                currentString = decodedString;
            } else {
                // It's a normal character, append linearly
                currentString.append(c);
            }
        }
        
        return currentString.toString();
    }
}