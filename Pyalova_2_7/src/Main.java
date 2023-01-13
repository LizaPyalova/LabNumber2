import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void createArray(int n, int m, int arr[][]) throws FileNotFoundException { //создает массив
        System.out.println("Type elements of Array: ");
        Scanner sc = new Scanner(System.in);
        Scanner scan = new Scanner(new File("in.txt"));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = scan.nextInt();
            }
        }
    }

    public static void printA(int n, int m, int  arr[][]){ //для вывода массива
        System.out.println("Your array: ");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print('\n');
        }
    }
    public static boolean Up(int a[]){
        for(int i=0; i<a.length -1; i++){
            if(a[i]>a[i+1] || a[i]==a[i+1]){
                return false;
            }
        }
        return true;
    }

    public static boolean Down(int a[]){
        for(int i=0; i<a.length -1; i++){
            if(a[i]<a[i+1] || a[i]==a[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void task(int n, int m,int arr[][]){
        boolean flag = false;     //создаем флаг для того, чтобы знать, есть ли вообще такие строчки упорядоченные
        int max = 0;
        for(int i = 0; i < n; i++) {
            if (Up(arr[i]) || Down(arr[i])){    //сравниваем строчки
                if (!flag) {          //с помощью флага убираем ошибку того, что макс элемент становится первым элементом строчки (если это не первая упорядоченная)
                    max = arr[i][0];
                }
                flag = true;
                for (int j = 0; j < m; j++) {
                    if (max < arr[i][j]){
                        max = arr[i][j];
                    }
                }
            }
        }
        if (flag){
            System.out.println("Max element is " + max);
        }
        else {
            System.out.println("No needed lines");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        Scanner scan = new Scanner(new File("in.txt"));
        int n = scan.nextInt();
        int m = scan.nextInt();
        System.out.println("Your n and m: " +n +" " + m);
        int [][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = scan.nextInt();
            }
        }
        task(n, m, arr);
    }
}
