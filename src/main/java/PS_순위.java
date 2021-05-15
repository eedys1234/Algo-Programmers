
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PS_순위 {

    public static void main(String... args) throws Exception {

        int n = 5;
        int[][] results = {
            {4, 3,},
            {4, 2,},
            {3, 2,},
            {1, 2,},
            {2, 5,},
        };

        int answer = solution(n, results);
        System.out.println(answer);
    }

    public static boolean[] visited;

    public static int solution(int n, int[][] results) {
        int answer = 0;
        List<List<Integer>> child_adj = new ArrayList<>();
        List<List<Integer>> parent_adj = new ArrayList<>();
        visited = new boolean[n+1];

        for(int i=0;i<=n;i++)
        {
            parent_adj.add(new ArrayList<>());
            child_adj.add(new ArrayList<>());
        }

        for(int[] result : results)
        {
            int a = result[0];
            int b = result[1];

            parent_adj.get(a).add(b);
            child_adj.get(b).add(a);
        }

        for(int i=1;i<=n;i++)
        {
            if(dfs(parent_adj, i) + dfs(child_adj, i) == n-1) {
                answer++;
            }
            Arrays.fill(visited, false);
        }

        return answer;
    }

    public static int dfs(List<List<Integer>> adj, int start) {

        int cnt = 0;
        List<Integer> list = adj.get(start);

        for(int next : list)
        {
            if(!visited[next]) {
                visited[next] = true;
                cnt += 1 + dfs(adj, next);
            }
        }

        return cnt;
    }
}
