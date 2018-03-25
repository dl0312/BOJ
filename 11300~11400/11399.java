import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// BOJ - 11399
// Algorithm - Greedy Algorithm

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] people;
        int n = sc.nextInt();
        int sum=0;
        people = new int [n];
        for(int i=0;i<n;i++){
            people[i] = sc.nextInt();
        }
        Arrays.sort(people);
        for(int i=0;i<n;i++) {
            for (int j = 0; j <= i; j++) {
                sum += people[j];
            }
        }
        sc.close();
        System.out.println(sum);
    }
}
