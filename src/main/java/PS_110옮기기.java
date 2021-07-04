import java.util.*;

public class PS_110옮기기 {

    public static void main(String... args) throws Exception {

        String[] s = {
            "1110",
            "100111100",
            "0111111010"
        };

        String[] solution = solution(s);
        print(solution);
    }

    public static void print(String[] solution) {
        for(int i=0;i<solution.length;i++)
        {
            System.out.print(solution[i] + ", ");
        }
        System.out.println();
    }

    public static String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for(int i=0;i<s.length;i++)
        {
            answer[i] = convertString(s[i]);
        }

        return answer;
    }

    public static String convertString(String s) {

        Stack<String> stack = new Stack<>();
        Stack<Character> store = new Stack<>();

        char[] chars = s.toCharArray();
        int cnt = 0;

        for(int i=0;i<chars.length;i++)
        {
            char z = chars[i];

            if(store.size() >= 2) {
                char y = store.pop();
                char x = store.pop();

                if(x == '1' && y == '1' && z == '0') {
                    cnt++;
                    continue;
                }
                else {
                    store.push(x);
                    store.push(y);
                    store.push(z);
                }
            }
            else {
                store.push(z);
            }
        }
        boolean flag = false;
        int index = store.size();
        StringBuilder sb = new StringBuilder();

        while(!store.isEmpty()) {
            if(!flag && store.peek() == '1') {
                index--;
            }
            if(!flag && store.peek() == '0') {
                flag = true;
            }
            sb.insert(0, store.pop());
        }
        if(cnt > 0) {
            while(cnt > 0) {
                sb.insert(index, "110");
                index += 3;
                cnt--;
            }

            return sb.toString();
        }
        else {
            return s;
        }
    }
}
