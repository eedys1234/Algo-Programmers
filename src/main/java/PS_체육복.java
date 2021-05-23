import java.util.Arrays;

public class PS_체육복 {

    public static void main(String... args) throws Exception {

        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        int answer = solution(n, lost, reserve);
        System.out.println(answer);
    }

    public static int solution(int n, int[] lost, int[] reserve) {

        int answer = 0;
        Suit[] suits = new Suit[n+1];

        //중복제거 필요!!!
        for(int i=0;i<=n;i++)
        {
            suits[i] = new Suit(1, i);
        }

        for(int i=0;i<lost.length;i++)
        {
            suits[lost[i]].num--;
        }

        for(int i=0;i<reserve.length;i++)
        {
            suits[reserve[i]].num++;
        }

        lost = Arrays.stream(suits).filter(suit -> suit.num == 0 && suit.index > 0).mapToInt(suit -> suit.index).toArray();
        reserve = Arrays.stream(suits).filter(suit -> suit.num > 1 && suit.index > 0).mapToInt(suit -> suit.index).toArray();

        Arrays.sort(lost);
        Arrays.sort(reserve);

        answer = n - lost.length;

        int i = 0;
        int j = 0;

        while(i < lost.length && j < reserve.length) {

            if(lost[i]-1 == reserve[j] || lost[i]+1 == reserve[j]) {
                i++;
                j++;
                answer++;
            }
            else {

                if(lost[i] < reserve[j]) {
                    i++;
                }
                else {
                    j++;
                }
            }
         }

        return answer;
    }

    public static class Suit {

        private int num;
        private int index;

        public Suit(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}
