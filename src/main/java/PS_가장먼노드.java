
import java.util.*;

public class PS_가장먼노드 {

    public static void main(String[] args) throws Exception {

        int n = 6;
        int[][] vertex = {
            {3, 6},
            {4, 3},
            {3, 2},
            {1, 3},
            {1, 2},
            {2, 4},
            {5, 2}
        };

        int resValue = solution(n, vertex);
        System.out.println(resValue);
    }

    public static int solution(int n, int[][] edge) {

        List<List<Node>> adj = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
            nodes.add(new Node(i));
        }

        for(int i=0;i<edge.length;i++)
        {
            int a = edge[i][0];
            int b = edge[i][1];

            adj.get(a).add(nodes.get(b));
            adj.get(b).add(nodes.get(a));
        }
        nodes.get(0).setWeight(0);
        nodes.get(1).setWeight(0);
        queue.add(nodes.get(1));

        while(!queue.isEmpty()) {

            Node cur = queue.poll();
            int cur_num = cur.num;

            for(Node next : adj.get(cur_num))
            {
                if(cur.getWeight() + 1 < next.getWeight()) {
                    next.setWeight(cur.getWeight() + 1);
                    queue.add(next);
                }
            }
        }

        int max = nodes.stream().map(Node::getWeight).max(Comparator.naturalOrder())
        .orElse(1);

        return (int) nodes.stream().filter(node -> node.getWeight() == max).count();
    }

    public static class Node {

        private int num;
        private int weight;

        public Node(int num) {
            this.num = num;
            this.weight = 100000000;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getNum() {
            return num;
        }

        public int getWeight() {
            return weight;
        }
    }

}
