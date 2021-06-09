import java.util.Arrays;

public class PS_HIndex {

    public static void main(String... args) throws Exception {

        int[] citations = {
           88, 89
        };

        int answer = solution(citations);
        System.out.println(answer);
    }

    public static int solution(int[] citations) {
        int answer = 0;

        //sorting -> 0, 1, 3, 3, 3, 5, 6
        Arrays.sort(citations);
        int len = citations.length;


        for(int i=0; i<len; i++)
        {
            int h = len - i;
            if(citations[i] > h) {
                answer = Math.max(answer, h);
            }
        }

        return answer;
    }
}
