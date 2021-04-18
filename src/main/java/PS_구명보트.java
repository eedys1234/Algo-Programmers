import java.util.*;
import java.util.stream.Collectors;

public class PS_구명보트 {

    public static void main(String[] args) {

        int[] people = {
                40, 50, 60, 90
        };

        int limit = 100;

        int answer = solution(people, limit);
        System.out.println(answer);
    }

    /**
     * 투 포인트 문제
     * 보트에 최대 2명까지 밖에 탈 수 없다는 게 포인트!
     * 오름차순으로 정렬 후 가장 왼쪽과 가장 오른쪽의 합이 limit보다 작으면 둘 모두 보트에 탈 수 있음
     * 만약 limit보다 크다면 가장 오른쪽의 사람만이 탈 수 있음(오름차순으로 정렬되었기 때문에 현재 타려고했던 왼쪽 사람보다 작은 무게의 사람은 없음)
     */
    public static int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0, right = people.length - 1;

        Arrays.sort(people);

        while(right >= left) {
            if(limit >= people[left] + people[right]) {
                left++;
                right--;
            }
            else {
                right--;
            }
            answer++;
        }

        return answer;
    }
}
