import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PS_가장큰수 {

    public static void main(String[] args) {

        int[] numbers = {
            898, 89//?
                //515, 51
        };

        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        String answer = "";
        int[][] temp = new int[2][numbers.length];
        int max = 0;
        int len = 0;

        //최대값을 구하는 이유 - 가장 큰 값의 자릿수
        for(int i=0;i<numbers.length;i++) {
            temp[0][i] = numbers[i];
            max = Math.max(max, numbers[i]);
        }

        len = String.valueOf(max).length();

        //최대 4
        for(int i=0;i<numbers.length;i++) {
            int numbersLen = String.valueOf(numbers[i]).length();

            if(numbersLen < len) {
                StringBuilder sb = new StringBuilder();
                sb.append(numbers[i]);
                for(int j=numbersLen;j<len;j++)
                {
                    sb.append(String.valueOf(numbers[i]).charAt(0));
                }
                temp[1][i] = Integer.valueOf(sb.toString());
            }
            else {
                temp[1][i] = numbers[i];
            }
        }

        mergeSort(temp, 0, temp[0].length -1);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<temp[0].length;i++) {
            sb.append(temp[0][i]);
        }
        return sb.toString().replaceFirst("^0+(?!$)", "");
    }

    public static void mergeSort(int[][] value, int left, int right) {

        if(left < right) {

            int mid = (left + right) / 2;

            mergeSort(value, left, mid);
            mergeSort(value, mid+1, right);
            merge(value, left, mid, right);
        }
    }

    public static void merge(int[][] value, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;
        int k = 0;
        int[][] temp = new int[2][right-left+1];

        while(i <= mid && j <= right) {

            if(value[1][i] < value[1][j]) {
                temp[0][k] = value[0][j];
                temp[1][k++] = value[1][j++];
            }
            else if(value[1][i] > value[1][j]) {
                temp[0][k] = value[0][i];
                temp[1][k++] = value[1][i++];
            }
            else {
                //첫글자와 마지막글자 비교 필요
                int a = Integer.valueOf(String.valueOf(value[0][i]) + String.valueOf(value[0][j]));
                int b = Integer.valueOf(String.valueOf(value[0][j]) + String.valueOf(value[0][i]));

                if(a < b) {
                    temp[0][k] = value[0][j];
                    temp[1][k++] = value[1][j++];
                }
                else {
                    temp[0][k] = value[0][i];
                    temp[1][k++] = value[1][i++];
                }
            }
         }

        while(i <= mid) {
            temp[0][k] = value[0][i];
            temp[1][k++] = value[1][i++];
        }

        while(j <= right) {
            temp[0][k] = value[0][j];
            temp[1][k++] = value[1][j++];
        }

        for(int l=0;l<k;l++)
        {
            value[0][left] = temp[0][l];
            value[1][left++] = temp[1][l];
        }
    }


}
