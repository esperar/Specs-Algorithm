package baekjoon.b_2587;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        // 버블 정렬
        for (int i = 0; i < arr.length; i++) {
            boolean isSwap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                int temp = 0;
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwap = true;
                }
            }
            if (isSwap == false) {
                break;
            }
        }


        System.out.println(sum / 5);
        System.out.println(arr[2]);

    }
}
