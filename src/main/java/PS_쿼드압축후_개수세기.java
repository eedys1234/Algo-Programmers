public class PS_쿼드압축후_개수세기 {

    public static void main(String... args) throws Exception {

        int[][] arr = {
            {1, 1, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 1},
            {1, 1, 1, 1}
        };

        int[] solution = solution(arr);
        System.out.println(solution[0] + ", " + solution[1]);
    }

    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];

        int zero_count = 0;
        int one_count = 0;

        String s = quadTree(arr, 0, 0, arr.length);
        for(char c : s.toCharArray())
        {
            if(c == '0') {
                zero_count++;
            }
            if(c == '1') {
                one_count++;
            }
        }

        answer[0] = zero_count;
        answer[1] = one_count;

        return answer;
    }

    public static String quadTree(int[][] arr, int beginX, int beginY, int size) {

        int data = arr[beginY][beginX];
        boolean isCompress = true;

        for(int i=beginY;i<beginY+size;i++)
        {
            for(int j=beginX;j<beginX+size;j++)
            {
                if(data != arr[i][j]) {
                    isCompress = false;
                    break;
                }
            }
            if(!isCompress) {
                break;
            }
        }

        if(isCompress) {
            return String.valueOf(data);
        }

        int half = size / 2;
        return "(" +
                quadTree(arr, beginX, beginY, half) +
                quadTree(arr, beginX + half, beginY, half) +
                quadTree(arr, beginX, beginY + half, half) +
                quadTree(arr, beginX + half, beginY + half, half) +
                ")";
    }
}
