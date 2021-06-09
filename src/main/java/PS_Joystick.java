public class PS_Joystick {

    public static void main(String... args) throws Exception {

        String name = "ZZAAAZZ";

        int answer = solution(name);
        System.out.println(answer);
    }

    public static int solution(String name) {
        int answer = 0;

        //조이스틱 위, 아래 조작
        for(char c : name.toCharArray()) {
            if(c < 78) {
                answer += c%65;
            }
            else {
                answer += 91-c;
            }
        }

        //좌에서 우로가는게 가장 최단거리
        int length = name.length();
        int min = length - 1;

        //조이스틱 좌, 우 조작
        for(int i = 0; i< length; i++)
        {
            int index = i;

            if(name.charAt(index) == 'A') {

                while(index < length && name.charAt(index) == 'A') {
                    index++;
                }

                min = Math.min(min, (i-1) * 2 + length-index);
            }
        }

        answer += min;

        return answer;
    }
}
