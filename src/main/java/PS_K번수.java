import java.util.Arrays;

public class PS_K번수 {

    public static void main(String[] args) {

        int[] array = {
            1, 5, 2, 6, 3, 7, 4
        };

        int[][] commands = {
            {2, 5, 3},
            {4, 4, 1},
            {1, 7, 3}
        };

        int[] answer = solution(array, commands);

        for(int i=0;i<answer.length;i++)
        {
            System.out.println(answer[i]);
        }
    }

    public static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int i=0;i<commands.length;i++) {
            int l = commands[i][0];
            int n = commands[i][1];
            int k = commands[i][2];

            //2, 5, 3

            int[] temp = new int[n-l+1];
            System.arraycopy(array, l-1, temp, 0, n-l+1);

            Arrays.sort(temp);
            answer[i] = temp[k-1];
        }

        return answer;
    }
}
