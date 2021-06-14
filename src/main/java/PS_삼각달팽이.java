public class PS_삼각달팽이 {

    public static int[][] dir = {{1, 0}, {0, 1}, {-1, -1}};

    public static void main(String... args) throws Exception {
        int n = 4;
        int[] solution = solution(n);
        print(solution);
    }

    public static void print(int[] solution) {
        for(int i=0;i<solution.length;i++)
        {
            System.out.print(solution[i] + " ");
        }
    }

    public static int[] solution(int n) {

        int len = 0;
        int signal = n;
        int count = 0;

        for(int i=1;i<=n;i++) {
            len += i;
        }

        int[] answer = new int[len];
        int[][] triangle = new int[n][n];

        int i = 1;
        int j = 0;
        int x = 0;
        int y = 0;

        while(i <= len) {
            triangle[y][x] = i;
            count++;
            i++;

            if(count == signal) {
                j++;
                j %= 3;
                signal--;
                count = 0;
            }

            y += dir[j][0];
            x += dir[j][1];
        }

        int m = 0;
        for(int k=0;k<triangle.length;k++)
        {
            for(int l=0;l<triangle[0].length;l++)
            {
                if(triangle[k][l] > 0) {
                    answer[m++] = triangle[k][l];
                }
            }
        }

        return answer;
    }
}
