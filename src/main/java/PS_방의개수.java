import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PS_방의개수 {

    public static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public static Map<Location, Integer> store = new HashMap<>();

    public static void main(String... args) throws Exception {

        int[] arrows = {6, 0, 3, 0, 5, 2, 6, 0, 3, 0, 5};
        int answer = solution(arrows);
        System.out.println(answer);
    }

    public static int solution(int[] arrows) {
        int answer = 0;
        answer = dfs(arrows, 0, 0, 0);
        return answer;
    }

    public static int dfs(int[] arrows, int y, int x, int start) {

        if(start == arrows.length) {
            return store.containsKey(new Location(y, x)) ? 1 : 0;
        }
        else {
            int cnt = 0;
            if(store.containsKey(new Location(y, x))) {
                int visit = store.get(new Location(y, x));
                if(visit == 0) {
                    store.put(new Location(y, x), 1);
                    cnt++;
                }
            }
            else {
                store.put(new Location(y, x), 0);
            }
            int arrow = arrows[start];
            int next_y = y + dir[arrow][0];
            int next_x = x + dir[arrow][1];
            cnt += dfs(arrows, next_y, next_x, start+1);
            return cnt;
        }
    }

    public static class Location {
        private int x;
        private int y;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return x == location.x && y == location.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
