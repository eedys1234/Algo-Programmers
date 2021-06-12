public class PS_도둑질 {

    public static void main(String... args) throws Exception {

        int[] money = {0,0,2,1,0,0,1};
        int answer = solution(money);
        System.out.println(answer);
    }

    public static int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        int[][] dp = new int[2][len];

        dp[0][0] = money[0];
        //첫번째 선택을 강제했는데 dp[0][1] = 0인 경우도 존재하면 안됨
        dp[0][1] = money[0];
        dp[1][1] = money[1];

        for(int i=2; i<len-1; i++)
        {
            dp[0][i] = Math.max(dp[0][i-2] + money[i], dp[0][i-1]);
        }

        for(int i=2; i<len; i++)
        {
            dp[1][i] = Math.max(dp[1][i-2] + money[i], dp[1][i-1]);
        }

        answer = Math.max(dp[0][len-2], dp[1][len-1]);
        return answer;
    }
}
