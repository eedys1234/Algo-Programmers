import java.util.ArrayList;
import java.util.List;

public class PS_카펫 {

    public static void main(String... args) throws Exception {

        int brown = 8;
        int yellow = 6;
        int[] answer = solution(brown, yellow);

    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        List<Pair> pairs = new ArrayList<>();

        for(int i=1;i<=yellow;i++)
        {
            if(yellow % i == 0) {
                int m = yellow / i;
                pairs.add(new Pair(m, i));
            }
        }

        for(int i=0;i<pairs.size();i++)
        {
            Pair pair = pairs.get(i);
            int m = pair.getM();
            int n = pair.getN();

            if(2 * (m + 2 + n) == brown) {
                answer[0] = m + 2;
                answer[1] = n + 2;
                return answer;
            }
        }

        return answer;
    }

    public static class Pair {
        private int m;
        private int n;

        public Pair(int m, int n) {
            this.m = m;
            this.n = n;
        }

        public int getM() {
            return this.m;
        }

        public int getN() {
            return this.n;
        }
    }
}
