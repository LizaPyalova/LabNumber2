import java.lang.reflect.Array;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class Main {
    public static int task(int n, int m,char arr[][]){
        HashSet<Integer> set1 = new HashSet<Integer>();              //1 1 0 0 set1 = 1 0
        HashSet<Integer> set2 = new HashSet<Integer>();              //0 5 0 1 set2= 0 1 5
        int h=0;
        while(h<n){
        for(int i=h+1;i<arr.length; i++){
            if(arr[h][0]!='*' && arr[i][0]!='*'){
            for(int j=0; j<m; j++) {
                set1.add((int)arr[h][j]);
                set2.add((int)arr[i][j]);
            }
            if(set1.equals(set2)){
                for(int j=0; j<m; j++)
                arr[i][j]='*';
            }
        }
        }
        h++;
        }
        int count1=n;
       for(int i=0; i<n; i++){
           if (arr[i][0]=='*') count1--;
       }
       return count1;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("in.txt"));
        int n = scan.nextInt();
        int m = scan.nextInt();
        System.out.println("Your n and m: " + n +" " +m);
        char [][] arr = new char[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = (char)(scan.nextInt()+'0');
            }
        }
        System.out.println(task(n, m, arr));
    }
}