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
        heapSort();
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

    public static void selection_sort(){ // Сортировка выбором
        int[][] sel_mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(mat[i], 0, sel_mat[i], 0, n);
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++){
                int min = mat[i][j]; // Минимум определяем как текущий элемент
                int index = j; // Запоминаем индекс условного минимума

                for (int k = j + 1; k < n; k++) // Цикл для прохода по массиву (начиная со следующего элемента) в поисках элемента, который меньше условного минимума
                    if (mat[i][k] < min){
                        min = mat[i][k];
                        index = k;
                    }

                if (j != index) { // Если новый минимум был найден, то меняем местами текущий элемент и найденный минимум
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

    public static void insertionSort() { // Сортировка вставкой
        int[][] ins_mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(mat[i], 0, ins_mat[i], 0, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) { // Цикл для прохода по неотсортированной части массива
                    for (int k = j; k >= 1; k--) { // Цикл для прохода по отсортированной части масива
                    if (ins_mat[i][k] < ins_mat[i][k - 1]) { // Поиск места для вставки текущего элемента
                        int z = ins_mat[i][k];
                        ins_mat[i][k] = ins_mat[i][k - 1];
                        ins_mat[i][k - 1] = z;
                    }
                    else // Если нету элемента, меньше текущего, то текущий остается на своем месте
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
                for (int j = 1; j < n; j++) { // Проход по массиву, в каждой итерации которого максимальный элемент будет оказываться справа
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

        int h = 1; // Описывается переменная шага
        while (h*3 < m) // Находится максимальное значение для кнутовской последовательности
            h = h * 3 + 1;

        while(h >= 1) { // Вызывается метод сортировки с h, равной максимальному значению кнутовской последовательности, а после в h записывается предыдущий элемент кнутовской последовательности
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
                for (int k = j; k >= h; k = k - h) { // Выполняется пузырьковай сортировка, но с шагом h
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

    public static void heapSort(){
        int[][] heap_mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(mat[i], 0, heap_mat[i], 0, n);
        }

        for (int j = 0; j < m; j++)
            sort(heap_mat, j);

        System.out.println();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(heap_mat[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static void sort(int[][] arr, int j)
    {
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, j);

        // Один за другим извлекаем элементы из кучи
        for (int i=n-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = arr[j][0];
            arr[j][0] = arr[j][i];
            arr[j][i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0,j);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
// индексом в arr[]. n - размер кучи
    public static void heapify(int[][] arr, int n, int i, int j)
    {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[j][l] > arr[j][largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[j][r] > arr[j][largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = arr[j][i];
            arr[j][i] = arr[j][largest];
            arr[j][largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest,j);
        }
    }
}