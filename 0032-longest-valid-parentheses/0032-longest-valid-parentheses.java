class Solution {
    public int longestValidParentheses(String s) {
      Stack<Integer> stack = new Stack<>();
      stack.push(-1);
      int max=0;
      for(int i=0;i<s.length();i++){
        Character ch = s.charAt(i);
        if(ch == '('){
            stack.push(i);
        }
        else{
            stack.pop();
            if(stack.isEmpty()){
                stack.push(i);
            }
            max = Math.max(max,i-stack.peek());
        }
      }
    return max;
    }
}