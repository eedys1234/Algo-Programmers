public class PS_등굣길 {

    public static int[][] next = {{1, 0}, {0, 1}};

    public static void main(String... args) throws Exception {

        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        int solution = solution(m, n, puddles);
        System.out.println(solution);
    }

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[m+1][n+1];
        int[][] obstacle = new int[m+1][n+1];

        for(int[] puddle : puddles)
        {
            int r = puddle[0];
            int c = puddle[1];
            obstacle[r][c] = -1;
        }

        answer = go(dp, obstacle, 1, 1);
        return answer;
    }

    public static int go(int[][] dp, int[][] obstacle, int x, int y) {

        if(x >= dp.length || y >= dp[0].length) {
            return 0;
        }
        //이전에 지나왔던 경로인지..
        else if(dp[x][y] > 0) {
            return dp[x][y];
        }
        //도착
        else if(x == dp.length-1 && y == dp[0].length-1) {
            return 1;
        }
        //장애물 도착
        else if(obstacle[x][y] == -1) {
            return 0;
        }
        else {
            int cnt = 0;

            for(int[] add : next)
            {
                int next_x = x + add[0];
                int next_y = y + add[1];
                cnt += go(dp, obstacle, next_x, next_y) % 1_000_000_007;
            }

            dp[x][y] = cnt % 1_000_000_007;
            return dp[x][y];
        }
    }
}
