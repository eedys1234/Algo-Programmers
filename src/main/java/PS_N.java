import java.util.HashSet;
import java.util.Set;

public class PS_N {

    public static void main(String... args) throws Exception {

        int N = 5;
        int number = 12;

        int answer = solution(N, number);
        System.out.println(answer);

    }

    public static int solution(int N, int number) {

        if(N == number) {
            return 1;
        }

        final int MIN = 8;
        Set<Integer>[] set = new Set[MIN];
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<MIN;i++)
        {
            sb.append(N);
            set[i] = new HashSet<Integer>();
            set[i].add(Integer.valueOf(sb.toString()));
        }

        for(int i=1;i<MIN;i++)
        {
            for(int j=0;j<i;j++)
            {
                for(Integer op1 : set[j])
                {
                    for(Integer op2 : set[i-j-1])
                    {
                        set[i].add((op1 + op2));
                        set[i].add((op1 - op2));
                        set[i].add((op1 * op2));

                        if(op2 != 0) {
                            set[i].add((op1 / op2));
                        }
                    }
                }
            }

            if(set[i].stream().anyMatch(k -> k == number)) {
                return i+1;
            }
        }

        return -1;
    }
}
