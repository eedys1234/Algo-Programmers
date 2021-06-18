public class PS_스타수열 {

    public static void main(String... args) throws Exception {

        int[] a = {5, 2, 3, 3, 5, 3};
        int answer = solution(a);
        System.out.println(answer);
    }

    public static int solution(int[] a) {
        int answer = 0;
        int[] store = new int[a.length+1];

        for(int i=0; i<a.length; i++)
        {
            store[a[i]]++;
        }

        for(int i=0;i< store.length;i++)
        {
            if(store[i] == 0) continue;
            if(store[i] <= answer) continue;

            int result = 0;
            for(int j=0;j<a.length-1;j++)
            {
                if(a[j] != i && a[j+1] != i) continue;
                if(a[j] == a[j+1]) continue;
                result++;
                j++;
            }
            answer = Math.max(answer, result);
        }

        return answer * 2;
    }

}
