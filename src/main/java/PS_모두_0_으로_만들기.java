import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PS_모두_0_으로_만들기 {

    public static void main(String... args) throws Exception {

//        int[] a = {0, 1, 0};
//        int[][] edges = {{0, 1}, {1, 2}};
        int[] a = { -5, 0, 2, 1, 2 };
        int[][] edges = { {0, 1}, {3, 4}, {2, 3}, {0, 3} };
        long solution = solution(a, edges);
        System.out.println(solution);
    }

    public static long solution(int[] a, int[][] edges) {
        long answer = 0;
        long sum = 0;
        long[] b = new long[a.length];
        boolean[] visited = new boolean[a.length];
        List<List<Integer>> adj = new ArrayList<>();
        Stack<Integer> visit_stack = new Stack<>();
        Stack<Relation> store_stack = new Stack<>();

        for(int i=0;i<a.length;i++)
        {
            sum += a[i];
            b[i] = a[i];
            adj.add(new ArrayList<>());
        }

        if(sum != 0) {
            answer = -1;
            return answer;
        }

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        visit_stack.push(0);
        store_stack.push(new Relation(0, 0));

        int node = 0;

        while(!visit_stack.isEmpty()) {
            node = visit_stack.pop();

            if(!visited[node]) {
                visited[node] = true;
                List<Integer> list = adj.get(node);

                for(int next : list)
                {
                    if(!visited[next]) {
                        visit_stack.push(next);
                        store_stack.push(new Relation(node, next));
                    }
                }
            }
        }

        while(!store_stack.isEmpty()) {
            Relation relation = store_stack.pop();
            answer += Math.abs(b[relation.getChild()]);
            b[relation.getParent()] += b[relation.getChild()];
            b[relation.getChild()] = 0;
        }

        return answer;
    }

    public static class Relation {

        private final int parent;
        private final int child;

        public Relation(final int parent, final int child) {
            this.parent = parent;
            this.child = child;
        }

        public int getParent() {
            return this.parent;
        }

        public int getChild() {
            return this.child;
        }
    }
}
