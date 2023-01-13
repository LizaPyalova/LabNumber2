

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void createArray(int n, int m, int arr[][]){ //создает массив
        System.out.println("Type elements of Array: ");
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public static void printA(int n, int m, int  arr[][]){ //для вывода массива, но он тут не пригодился
        System.out.println("Your array: ");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

    public static void sortUp(int n, int arr[][]){  //сортировка в порядке возрастания
        for(int i = 0; i < n; i++) {
            Arrays.sort(arr[i]);
        }
    }

    public static void sortDown(int n, int m, int[][] arr){  //сортировка в порядке убывания
        int [][] arrC = new int[n][m];
        for(int i = 0; i < n; i++) {          //создадим такой же массив, который отсортируем в порядке возрастания
            for (int j = 0; j < m; j++) {
                arrC[i][j] = arr[i][j];
            }
        }
        for(int i = 0; i < n; i++) {
            Arrays.sort(arrC[i]);
        }
        for(int i = 0; i < n; i++) {            //зеркалим этот отсортированный массив
            for (int j = 0; j < m; j++){
                arr[i][j] = arrC[i][m-1-j];
            }
        }
    }

    public static boolean compareA(int n, int m, int a[][]){  //функция сравниваниет два массива (одномерных, мы сравниваем строчки двумерных) и возвращает тру, если они равны
        for (int i = 0; i < n/2; i++)
        {
            for(int ii = i+1; ii < n; ii++)
            {
                for (int j = 0; j<m; j++)
                {
                    for (int jj = 0; jj<m; jj++)
                    {
                        if(a[i][j] != a[ii][jj])
                        {

                        }
                    }
                }
            }
        }
        return true;
    } /**/

    public static boolean compare(int a[], int b[]){  //функция сравниваниет два массива (одномерных, мы сравниваем строчки двумерных) и возвращает тру, если они равны
        for (int i = 0; i < a.length; i++){
            if (a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    public static void task(int n, int m,int arr[][]){
        int [][] arrUp = new int[n][m];         // создаем два массива, как исходный, которые отсортируем позже
        int [][] arrSec = new int[n][m];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arrUp[i][j] = arr[i][j];
            }
        }
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arrSec[i][j] = arr[i][j];
            }
        }
        sortUp(n, arrUp);           //сортируем
        sortUp(n, arrSec);
        boolean flag = false;     //создаем флаг для того, чтобы знать, есть ли вообще такие строчки (упорядоченные)
        int sum = 1;
        int [] sumS = new int[n];
        for (int i = 0; i < n; i++){
            sumS[i]=1;
        }

        for(int i = 0; i < n-1; i++) {
            flag = false;
            for (int j = 0; j < n; j++){
                if (!compare(arrSec[i], arrUp[j]) && i!=j){
                    for(int k=j+1; k<n; k++){
                        if(k!=i){
                            if(compare(arrUp[k],arrUp[j])){
                                sumS[i]--;
                                break;
                            }
                        }
                    }
                    if (!flag){
                        sumS[i]++;
                    }
                }
            }

        }
        Arrays.sort(sumS);
        System.out.println("Sum of different lines is " + sumS[n-1]);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type n and m: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] arr = new int[n][m];
        createArray(n, m, arr);
        task(n, m, arr);
    }
}