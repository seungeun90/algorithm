import java.util.Stack;
class Solution {
    boolean solution(String s) {
         Stack<Character> stack = new Stack<>();
        for (char a : s.toCharArray()) {
            if(a=='(') {
                stack.push(a);
            } else {
                if(!stack.isEmpty()) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }
}