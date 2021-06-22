public class PS_2개이하로_다른_비트 {

    public static void main(String... args) throws Exception {

        long[] numbers = {2, 7};
        long[] answer = solution(numbers);
        print(answer);
    }

    public static void print(long[] answer) {
        for(int i=0;i<answer.length;i++)
        {
            System.out.print(answer[i] + ", ");
        }
    }

    public static long[] solution(long[] numbers) {

        long[] answer = new long[numbers.length];

        for(int i=0;i<numbers.length;i++)
        {
            StringBuilder sb = new StringBuilder();
            long number = numbers[i];

            //짝수일때
            if(number % 2 == 0) {
                answer[i] = number + 1;
            }
            else {
                String s = Long.toBinaryString(number);
                int last_zero_index = s.lastIndexOf('0');
                int first_one_index = s.indexOf('1', last_zero_index);

                //0을 미포함하는 경우
                if(last_zero_index == -1) {
                    sb.append("10").append(s.substring(1).replace("0", "1"));
                }
                //0을 포함하는 경우
                else {
                    sb.append(s.substring(0, last_zero_index));
                    sb.append("1");
                    sb.append(s.substring(last_zero_index+1, first_one_index));
                    sb.append("0");
                    sb.append(s.substring(first_one_index+1));
                }

                answer[i] = Long.parseLong(sb.toString(), 2);
            }
        }

        return answer;
    }
}
