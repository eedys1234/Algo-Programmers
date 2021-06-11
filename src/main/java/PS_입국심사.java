import java.util.Arrays;

public class PS_입국심사 {

    public static void main(String... args) throws Exception {

        int[] times = {7, 10};
        int n = 6;

        long solution = solution(n, times);
        System.out.println(solution);
    }

    public static long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long min = (long) times[times.length - 1] * (long) n;
        long left = 1;
        long right = (long) times[times.length - 1] * (long) n;

        while(left < right)
        {
            long mid = (left + right) / 2;

            if(check(times, mid, n)) {
                min = Math.min(min, mid);
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        answer = min;
        return answer;
    }

    public static boolean check(int[] times, long mid, int n) {
        long sum = 0;

        for(int i=0;i<times.length;i++)
        {
            sum += mid/(long)times[i];
        }

        return sum >= n;
    }
}
