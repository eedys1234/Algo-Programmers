import java.util.Arrays;

public class PS_징검다리 {

    public static void main(String... args) throws Exception {

        int distance = 25;
        int[] rocks = {
            2, 14, 11, 21, 17
        };

        int n = 2;

        int answer = solution(distance, rocks, n);
        System.out.println(answer);
    }

    public static int solution(int distance, int[] rocks, int n) {

        int answer = 0;
        int len = rocks.length;

        int[] diff = new int[len];
        Arrays.sort(rocks);

        diff[0] = rocks[0];

        for(int i=1;i<len;i++)
        {
            diff[i] = rocks[i] - rocks[i-1];
        }


        int left = 1;
        int right = distance;

        while(left <= right) {

            int mid = (left + right)/2;
            int count = 0;
            int prev = 0;

            for(int i=0;i<len;i++)
            {
                if(mid > rocks[i] - prev) {
                    count++;
                }
                else {
                    prev = rocks[i];
                }
            }

            if(distance - prev < mid) {
                count++;
            }

            if(count <= n) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }

        answer = left;

        return answer;
    }
}
