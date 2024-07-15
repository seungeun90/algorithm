import java.util.Stack;
class Solution {
    public int solution(String s) {
           int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String x = s.substring(i, s.length()) + s.substring(0, i);
            if(isRight(x, i))  answer++;
        }
        return answer;
    }
    public  boolean isRight(String s, int start){
         Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
     
        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}