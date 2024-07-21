

import java.util.LinkedList;

public class RemoveRepeatChar {
    public static String removeConsecutiveChars(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        char pre = chars[0];
        stack.push(pre);
        for (int i = 1; i < chars.length; i++) {
            char current = chars[i];
            if (current != pre) {
                removeChar(stack, pre);
            }
            stack.push(current);
            pre = current;
        }
        removeChar(stack, pre);
        // Convert stack to string
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    private static void removeChar(LinkedList<Character> stack, char pre) {
        int count = 0;
        while (!stack.isEmpty() && stack.peek() == pre) {
            stack.pop();
            count++;
        }
        if (count == 1) {
            stack.push(pre);
        }
        if (count == 2) {
            stack.push(pre);
            stack.push(pre);
        }
    }

    public static void main(String[] args) {
        String input = "aabcccbbad";
        String output = removeConsecutiveChars(input);
        System.out.println(output);
    }
}
