public class PS_약수의_개수와_덧셈 {

    public static void main(String... args) throws Exception {

        int left = 13;
        int right = 17;
        int solution = solution(left, right);
        System.out.println(solution);
    }

    public static int solution(int left, int right) {
        int sum = 0;

        for(int i=left; i<=right; i++)
        {
            int sqrt = (int)Math.sqrt(i);
            if(sqrt * sqrt == i) {
                sum -= i;
            }
            else {
                sum += i;
            }
        }

        return sum;
    }
}
