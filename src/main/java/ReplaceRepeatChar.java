
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;

public class ReplaceRepeatChar {
    public static String replaceConsecutiveChars(String s) {
        if (StringUtils.isEmpty(s)) {
            return s;
        }
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            char current = chars[i];
            if (current != chars[i - 1]) {
                replaceChar(stack, chars, i - 1);
            }
            stack.push(current);
        }
        replaceChar(stack, chars, chars.length - 1);
        // Convert stack to string
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    private static void replaceChar(LinkedList<Character> stack, char[] chars, int pre) {
        int count = 0;
        char preChar = chars[pre];
        while (!stack.isEmpty() && stack.peek() == preChar) {
            stack.pop();
            count++;
        }
        if (count == 1) {
            stack.push(preChar);
        } else if (count == 2) {
            stack.push(preChar);
            stack.push(preChar);
        } else {
            // three times or more，replace the repeat char
            if (preChar != 'a') {
                stack.push((char) (preChar - 1));
            }
        }
    }

    public static void main(String[] args) {
        String input = "abcccbad";
        String output = replaceConsecutiveChars(input);
        System.out.println(output);
    }
}
