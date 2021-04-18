import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PS_두개뽑아서_더하기 {

    public static void main(String[] args) {

        int[] numbers = {
            2, 1, 3, 4, 1
        };

        int[] result = solution(numbers);

        for(int i=0;i<result.length;i++)
        {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] solution(int[] numbers) {

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<numbers.length-1;i++)
        {
            for(int j=i+1;j<numbers.length;j++)
            {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] result = new int[set.size()];
        List<Integer> list = set.stream().collect(Collectors.toList());

        Collections.sort(list);

        for(int i=0;i<list.size();i++)
        {
            result[i] = list.get(i);
        }

        return result;
    }
}
