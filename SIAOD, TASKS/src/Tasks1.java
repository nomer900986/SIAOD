public class Tasks1 {

    public static void main(String[] args) {
        System.out.println("Задание 1. Треугольник с максимальным периметром");

        int[] params = {2,1,2};
        maxPerimeter(params);

        params = new int[]{1,2,1};
        maxPerimeter(params);

        params = new int[]{3,2,3,4};
        maxPerimeter(params);

        params = new int[]{3,6,2,3};
        maxPerimeter(params);

        System.out.println();
        System.out.println("Задание 2. Максимальное число");

        int[] nums = {10, 2};
        System.out.println("Максимальное число " + findMax(nums));

        nums = new int[]{3, 30, 34, 5, 9};
        System.out.println("Максимальное число " + findMax(nums));

        nums = new int[]{1};
        System.out.println("Максимальное число " + findMax(nums));

        nums = new int[]{10};
        System.out.println("Максимальное число " + findMax(nums));

        System.out.println();
        System.out.println("Задание 3. Сортировка диагоналей в матрице");

        int[][] arr = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        output_mat(resSort(arr, 3,4),3,4);

        arr = new int[][]{{11, 25, 66, 1, 69, 7},{23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}};
        output_mat(resSort(arr, 5,6),5,6);
    }

    public static void output_mat(int [][] mat, int m, int n){
        System.out.println();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void maxPerimeter(int[] arr) {
        int maxi = 0;                        // инициализируем максимальный периметр как 0.
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {     // подбираем 3 разных элемента из массива
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int a = arr[i];
                    int b = arr[j];
                    int c = arr[k];

                    if (a < b + c && b < c + a && c < a + b) {         //проверяем, a, b, c образуют треуг. или нет
                        maxi = Math.max(maxi, a + b + c);          // если он образует треугольник
                    }                                              // затем обновляем максимум
                }
            }
        }

        if (maxi > 0)                                                // Если максимальный периметр ненулевой
            System.out.println("Максимальный периметр: " + maxi);
        else                                                         // иначе треугольник не строится
            System.out.println("Невозможно составить треугольник");
        }

    public static String findMax(int[] int_nums) {
        String str = "";
        int k = 0;

        for (int i= 0; i < int_nums.length; i++){
            for (int j = 1; j < int_nums.length-i; j++) {
                String x = Integer.toString(int_nums[j-1])+Integer.toString(int_nums[j]);
                String y = Integer.toString(int_nums[j])+Integer.toString(int_nums[j-1]);

                if (x.compareTo(y)<0) {
                    k=int_nums[j];int_nums[j]=int_nums[j-1];int_nums[j-1]=k;
                }
            }
        }

        for (int item:int_nums) {
            str+=Integer.toString(item);
        }

        return str;
    }

    public static int[][] resSort(int[][] a,int m,int n){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sort(a,i,j);
            }

        }
        return a;
    }

    public static void sort(int [][] a, int i, int j){
        if (i==0 || j==0){}
        else{
            if(a[i][j]<a[i-1][j-1]){
                int k = a[i][j];
                a[i][j]=a[i-1][j-1];
                a[i-1][j-1]=k;
            }
            sort(a,i-1,j-1);
        }
    }
}

