

public class PS_풍선터트리기 {

    public static void main(String... args) throws Exception {

        int[] a = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};
        int answer = solution(a);
        System.out.println(answer);

    }

    public static int solution(int[] a) {
        int answer = 0;
        int[] left_mins = new int[a.length];
        int[] right_mins = new int[a.length];

        int left_min = Integer.MAX_VALUE;
        int right_min = Integer.MAX_VALUE;

        for(int i=0;i<a.length;i++)
        {
            int j = a.length - 1 - i;

            right_min = Math.min(right_min, a[j]);
            right_mins[j] = right_min;

            left_min = Math.min(left_min, a[i]);
            left_mins[i] = left_min;
        }

        for(int i=0;i<a.length;i++)
        {
            if(i>0 && i<a.length-1 && (left_mins[i-1] > a[i] || a[i] < right_mins[i+1])) {
                answer++;
            }
        }

        return answer+2;
    }
}
