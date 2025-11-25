package javacodeptit;
import java.util.*;

public class J02011 {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        
        for (int i = 0; i < n - 1; i++){
            int minPos = i;
            for (int j = i + 1; j < n; j++){
                if(a[minPos] > a[j])
                    minPos = j;
            }
            int tmp = a[minPos];
            a[minPos] = a[i];
            a[i] = tmp;
            System.out.print("Buoc " + (i + 1) +": ");
            for (int x : a) 
            System.out.print(x + " ");
            System.out.println("");
        }
    }
}
