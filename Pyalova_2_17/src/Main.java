import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void createArray(int n, int arr[][]) throws FileNotFoundException { //создает массив
        System.out.println("Type elements of Array: ");
        FileReader fr = new FileReader("C:\\Users\\lizap\\Desktop\\учьоба\\PAZURA\\laba2\\Pyalova_2_17\\in.txt");
        Scanner sc1 = new Scanner(fr);
        Scanner scan = new Scanner(new File("in.txt"));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                    arr[i][j] = scan.nextInt();

            }
        }
    }

    public static void printA(int n, int  arr[][]){ //для вывода массива
        System.out.println("Your array: ");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

    public static void printA(int  arr[]){ //для вывода сумм массива
        System.out.println("Your diag sum array: ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.print('\n');
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        Scanner scan = new Scanner(new File("in.txt"));
        int n = scan.nextInt();
        System.out.println("N: " + n);
        int [][] arr = new int[n][n];
        int [] diagSum = new int[n+n-1]; //количество таких диагоналей =кол-во строк + кол-во столбцов - 1
        for (int i = 0; i < diagSum.length; i++) {
            diagSum[i] = 0;
        }
        //createArray(n,arr);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //int k=i+j;
                diagSum[i+j] += Math.abs(arr[i][j]);
            }
        }
        printA(diagSum);
        int min=diagSum[0];
        for(int i=0; i<diagSum.length; i++){
            if(diagSum[i]<min) min=diagSum[i];
        }
        System.out.println("Minimum diagonal sum is "+min);
    }
}


