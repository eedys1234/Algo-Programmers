import java.util.Stack;

public class PS_괄호_회전하기 {

    public static void main(String... args) throws Exception {

        String[] s = {"[](){}", "}]()[{", "[)(]", "}}}"};
        for(int i=0; i<s.length; i++)
        {
            int solution = solution(s[i]);
            System.out.println(solution);
        }
    }

    public static int solution(String s) {
        int answer = 0;

        //(), [], {}
        String temp = s;
        for(int i=0;i<s.length();i++)
        {
            if(i > 0) {
                temp = temp.substring(1) + temp.charAt(0);
            }

            if(correctString(temp)) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean correctString(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            else if(c == '}') {
                if(stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
            else if(c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
            else if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
        }

        if(!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
