public class PS_3진법뒤집기 {

    public static void main(String... args) throws Exception {

        int n = 45;
        int answer = solution(n);
        System.out.println(answer);
    }

    public static int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            sb.append(n % 3);
            n /= 3;
        }

        String x = sb.toString();

        int multi = 1;

        for(int i=x.length()-1;i>=0;i--)
        {
            int num = sb.charAt(i) - '0';
            answer += num * multi;
            multi *= 3;
        }

        return answer;
    }
}
