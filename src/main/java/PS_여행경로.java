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

    public static String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];

        Set<String> set = Stream.of(tickets)
                                .flatMap(ticket -> Stream.of(ticket))
                                .collect(Collectors.toSet());

        Map<String, List<Travel>> hanger = set.stream()
                                        .collect(Collectors.toMap(Function.identity(), key -> new ArrayList<Travel>()));

        for(String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];

            List<Travel> list = null;

            if(!hanger.containsKey(start)) {
                list = new ArrayList<>();
            }
            else {
                list = hanger.get(start);
            }

            Travel travel = new Travel(end);
            list.add(travel);
            hanger.put(start, list);
            visited.put(travel, false);
        }

        for(Map.Entry<String, List<Travel>> entry : hanger.entrySet())
        {
            Collections.sort(entry.getValue());
        }

        answer[0] = "ICN";
        dfs(hanger, answer[0], answer);

        return answer;
    }

    public static void dfs(Map<String, List<Travel>> hanger, String start, String[] answer) {
//                A -> B, C
//                B -> D
//                C -> A
        List<Travel> adj = hanger.get(start);

        for(Travel end : adj)
        {
            if(!visited.get(end)) {
                visited.put(end, true);
                answer[k++] = end.getName();
                dfs(hanger, end.getName(), answer);
            }
        }
    }

    public static class Travel implements Comparable<Travel> {

        private String name;

        public Travel(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Travel o) {
            return this.name.compareTo(o.getName());
        }
    }


}
