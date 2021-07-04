public class PS_문자열의아름다움 {

    public static void main(String... args) throws Exception {

        String s = "baby";
        long solution = solution(s);
        System.out.println(solution);
    }

    public static long solution(String s) {
        long answer = 0;
        long prev = 0;

        for(int i=0;i<s.length()-1;i++)
        {
            for(int j=i+1;j<s.length();j++)
            {
                if(s.charAt(i) != s.charAt(j))
                {
                    answer += j-i;
                    prev = j-i;
                }
                else{
                    answer += prev;
                }
            }
        }

        return answer;
    }
}
