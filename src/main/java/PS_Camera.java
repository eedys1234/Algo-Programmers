import java.util.*;

public class PS_Camera {

    public static void main(String... args) {

        int[][] routes = {
            {-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}
        };

        int answer = solution(routes);
        System.out.println(answer);
    }

    public static int solution(int[][] routes) {

        int answer = 1;

        Arrays.sort(routes, Comparator.comparingInt((int[] a) -> a[0]));

        int temp = routes[0][1];

        for(int i=1; i<routes.length; i++)
        {
            if(temp < routes[i][0]) {
                answer++;
                temp = routes[i][1];
            }

            if(temp > routes[i][1]) {
                temp = routes[i][1];
            }
        }

        return answer;
    }
}
