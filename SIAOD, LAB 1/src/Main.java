import java.util.Scanner;
import java.util.Arrays;

public class Main{

    public static int[][] mat;
    public static int m, n, min_limit, max_limit;

    public static void main(String[] args) {
        System.out.println("ЛАБОРАТОРНАЯ РАБОТА №1\nВыполнил студент группы БФИ1902 Крутиков Степан Сергеевич");
        hello();
        mat_gen();
        selection_sort();
        insertionSort();
        exchangeSort();
        shellSort();
    }

    public static void hello(){
        System.out.println();
        System.out.println("@Задание 1@");

        System.out.println("Hello, World!");
    }

    public static void mat_gen(){
        System.out.println();
        System.out.println("@Задание 2");

        m = 50;
        n = 50;
        min_limit = -250;
        max_limit = 1000 + 9;
        String var = "";

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите значение m или отбейте enter");
        var = sc.nextLine();
        if (!var.equals(""))
            m = Integer.parseInt(var);

        System.out.println("Введите значение n или отбейте enter");
        var = sc.nextLine();
        if (!var.equals(""))
            n = Integer.parseInt(var);

        System.out.println("Введите значение min_limit или отбейте enter");
        var = sc.nextLine();
        if (!var.equals(""))
            min_limit = Integer.parseInt(var);

        System.out.println("Введите значение max_limit или отбейте enter");
        var = sc.nextLine();
        if (!var.equals(""))
            max_limit = Integer.parseInt(var);

        mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = (int) (Math.random() * (max_limit - min_limit)) + min_limit;
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static void selection_sort(){
        int[][] sel_mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(mat[i], 0, sel_mat[i], 0, n);
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++){
                int min = mat[i][j];
                int index = j;

                for (int k = j + 1; k < n; k++)
                    if (mat[i][k] < min){
                        min = mat[i][k];
                        index = k;
                    }

                if (j != index) {
                    int z = mat[i][j];
                    mat[i][j] = mat[i][index];
                    mat[i][index] = z;
                }
            }

        System.out.println();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static void insertionSort() {
        int[][] ins_mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(mat[i], 0, ins_mat[i], 0, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = j; k >= 1; k--) {
                    if (ins_mat[i][k] < ins_mat[i][k - 1]) {
                        int z = ins_mat[i][k];
                        ins_mat[i][k] = ins_mat[i][k - 1];
                        ins_mat[i][k - 1] = z;
                    }
                    else
                        break;
                }
            }
        }

        System.out.println();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ins_mat[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static void  exchangeSort(){
        int[][] ex_mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(mat[i], 0, ex_mat[i], 0, n);
        }

        for (int i = 0; i < m; i++) {
            boolean needIteration = true;
            while (needIteration) {
                needIteration = false;
                for (int j = 1; j < n; j++) {
                    if (ex_mat[i][j] < ex_mat[i][j - 1]) {
                        int z = ex_mat[i][j];
                        ex_mat[i][j] = ex_mat[i][j - 1];
                        ex_mat[i][j - 1] = z;
                        needIteration = true;
                    }
                }
            }
        }

        System.out.println();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ex_mat[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static void shellSort(){
        int[][] shell_mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(mat[i], 0, shell_mat[i], 0, n);
        }

        int h = 1;
        while (h*3 < m)
            h = h * 3 + 1;

        while(h >= 1) {
            hSort(shell_mat, h);
            h = h/3;
        }

        System.out.println();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(shell_mat[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static void hSort(int[][] arr, int h) {
        for (int i = 0; i < m; i++) {
            for (int j = h; j < n; j++) {
                for (int k = j; k >= h; k = k - h) {
                    if (arr[i][k] < arr[i][k - h]) {
                        int z = arr[i][k];
                        arr[i][k] = arr[i][k - h];
                        arr[i][k - h] = z;
                    }
                    else
                        break;
                }
            }
        }
    }

}