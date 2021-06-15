public class PS_이진변환_반복하기 {

    public static void main(String... args) throws Exception {

        String[] s = {"110010101001", "01110", "1111111"};
        for(int i=0;i<s.length;i++)
        {
            int[] solution = solution(s[i]);
            System.out.println(solution[0] + ", " + solution[1]);
        }
    }

    public static int[] solution(String s) {

        int[] answer = new int[2];
        int count = 0;
        int sum = 0;
        int sub = 0;

        while(s.length() > 1) {
            sub = subtractZero(s);
            s = convert(s);
            count++;
            sum += sub;
        }

        answer[0] = count;
        answer[1] = sum;

        return answer;
    }

    public static int subtractZero(String s) {
        int orgLen = s.length();
        s = s.replace("0", "");
        int newLen = s.length();
        return orgLen - newLen;
    }

    public static String convert(String s) {
        s = s.replace("0", "");
        int len = s.length();
        StringBuilder sb = new StringBuilder();

        while(len > 0) {
            sb.append(len%2);
            len /= 2;
        }

        return sb.toString();
    }
}
