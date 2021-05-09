import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class PS_위장 {

    public static void main(String... args) throws Exception {

        String[][] clothes = {
//            {"yellowhat", "headgear"},
//            {"bluesunglasses", "eyewear"},
//            {"green_turban", "headgear"}
                {"crowmask", "face"},
                {"bluesunglasses", "face"},
                {"smoky_makeup", "face"}
        };

        int answer = solution(clothes);
        System.out.println(answer);
    }

    public static int solution(String[][] clothes) {
        int answer = 0;
        Map<String, List<String[]>> tempClothes = Stream.of(clothes)
                .collect(groupingBy(strings -> strings[1], toList()));

        Map<String, Integer> clothesCount = tempClothes.entrySet().stream().collect(toMap(entry->entry.getKey(),
                entry -> entry.getValue().size()));

        answer = clothesCount.values().stream().map(value -> value+1).reduce((a, b) -> a * b)
                .orElse(0);

        answer -= 1;

        return answer;
    }
}
