public class PS_정수삼각형 {

    public static void main(String... args) throws Exception {

        int[][] triangle = {
            {7},
            {3, 8},
            {8, 1, 0},
            {2, 7, 4, 4},
            {4, 5, 2, 6, 5}
        };

        int answer = solution(triangle);
        System.out.println(answer);
    }

    public static int solution(int[][] triangle) {

        int row_len = triangle.length;
        int[][] dp = new int[row_len + 1][triangle[row_len - 1].length + 1];

        dp[1][1] = triangle[0][0];

        for(int i=1;i<dp.length;i++)
        {
            int min = triangle[i-1].length;
            for(int j = 1; j <= min; j++)
            {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i-1][j-1];
            }
        }

        int max = 0;

        for(int j=1;j<dp[dp.length-1].length;j++)
        {
            max = Math.max(max, dp[dp.length-1][j]);
        }

        return max;
    }
}
