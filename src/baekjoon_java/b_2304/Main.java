package baekjoon_java.b_2304;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[1001];
        int start = Integer.MAX_VALUE;
        int end = 0;

        for(int i = 0; i < n; i++) {
            int L = sc.nextInt();
            int H = sc.nextInt();
            arr[L] = H;
            start = Math.min(L, start);
            end = Math.max(L, end);
        }

        Stack<Integer> height = new Stack<>();

        int temp = arr[start];
        for(int i = start + 1; i <= end; i++) {
            if(arr[i] < temp) {
                height.push(i);
            } else {
                while(!height.isEmpty()) {
                    int x = height.pop();
                    arr[x] = temp;
                }
                temp = arr[i];
            }
        }
        height.clear();

        temp = arr[end];
        for(int i = end - 1; i >= start; i--) {
            if(arr[i] < temp) {
                height.push(i);
            } else {
                while(!height.isEmpty()) {
                    int x = height.pop();
                    arr[x] = temp;
                }
                temp = arr[i];
            }
        }

        int result = 0;
        for(int i = start; i <= end; i++) {
            result += arr[i];
        }

        System.out.println(result);
    }
}
