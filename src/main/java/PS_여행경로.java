import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PS_여행경로 {

    public static int k = 1;
    public static Map<Travel, Boolean> visited = new HashMap<>();

    public static void main(String[] args) {

        String[][] tickets = {
                {"ICN","A"},{"A","B"},{"A","C"},{"C","A"},{"B","D"}
//                A -> B, C
//                B -> D
//                C -> A
//            {"ICN", "SFO"},
//            {"ICN", "ATL"},
//            {"SFO", "ATL"},
//            {"ATL", "ICN"},
//            {"ATL", "SFO"}
        };

        String[] answer = solution(tickets);

        for(int i=0;i<answer.length;i++)
        {
            System.out.print(answer[i]+ " ");
        }
    }

    public static StringBuilder sb = new StringBuilder();

    public static String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];

        Map<String, List<Travel>> hanger = Stream.of(tickets)
                .flatMap(strings -> Stream.of(strings))
                .collect(Collectors.toSet())
                .stream()
                .collect(Collectors.toMap(Function.identity(), key -> new ArrayList<Travel>()));

        Map<Travel, Boolean> visited = new HashMap<>();

        for(int i=0;i<tickets.length;i++)
        {
            String start = tickets[i][0];
            String end = tickets[i][1];

            Travel travel = new Travel(end);
            hanger.get(start).add(travel);
            visited.put(travel, false);
        }

        for(Map.Entry<String, List<Travel>> travel_list : hanger.entrySet())
        {
            Collections.sort(travel_list.getValue());
        }

        answer[0] = "ICN";
        dfs(hanger, visited, answer, "ICN", 1);
        answer = sb.toString().split(",");
        return answer;
    }

    public static boolean dfs(Map<String, List<Travel>> hanger, Map<Travel, Boolean> visited, String[] answer, String start, int k) {

        if(k == answer.length) {
            for(int i=0;i<answer.length;i++) {
                sb.append(answer[i]).append(",");
            }
            return true;
        }

        List<Travel> list = hanger.get(start);

        for(Travel travel : list)
        {
            if(!visited.get(travel)) {
                visited.put(travel, true);
                answer[k] = travel.name;
                if(dfs(hanger, visited, answer, travel.name, k+1)) {
                    return true;
                }
                visited.put(travel, false);
            }
        }

        return false;
    }

    public static class Travel implements Comparable<Travel> {

        private String name;

        public Travel(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Travel o) {
            return this.name.compareTo(o.name);
        }
    }


}
