import java.util.*;

public class PS_보석쇼핑 {

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String, Integer> store = new HashMap<>();
        Set<String> overlap = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        int startPoint = 0;
        int start = 0;
        int length = gems.length + 1;

        for (String gem : gems) {
            overlap.add(gem);
        }

        for (int i = 0; i < gems.length; i++) {
            String gem = gems[i];
            store.merge(gem, 1, (oldValue, newValue) -> ++oldValue);
            queue.offer(gem);

            while (!queue.isEmpty() && store.getOrDefault(queue.peek(), 0) > 1) {
                String poll = queue.poll();
                store.put(poll, store.get(poll) - 1);
                startPoint++;
            }

            if (overlap.size() == store.size() && length > queue.size()) {
                length = queue.size();
                start = startPoint;
            }
        }

        answer[0] = start + 1;
        answer[1] = start + length;
        return answer;

    }
}
