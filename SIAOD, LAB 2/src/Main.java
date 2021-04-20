import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Main{

    public static ArrayList<Integer> list;
    public static int []arr;
    public static int n = 20;
    public static int min_limit = -250;
    public static int max_limit = 1000 + 9;

    public static void main(String[] args) {
        System.out.println("ЛАБОРАТОРНАЯ РАБОТА №2\nВыполнил студент группы БФИ1902 Крутиков Степан Сергеевич\n");

        list_gen();

        System.out.println("Введите элемент для поиска");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();

        binarySearch(key);
        binaryTree(key);

        Arrays.sort(arr);
        System.out.print("\nSorted array\n");
        output_arr(arr);

        System.out.println("\nFibonacciSearch");
        FibonachySearch F = new FibonachySearch();
        int index = F.search(arr,key);
        System.out.println(index);

        System.out.println("\nInterpolationSearch");
        System.out.println(interpolationSearch(arr,key));


        HashTable table = new HashTable(7);
        try
        {
            File file = new File(System.getProperty("user.dir")+"\\src\\input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext())
            {
                table.addElement(scanner.next());
            }
            scanner.close();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        System.out.println("Введите искомое слово: ");
        String word = sc.nextLine();
        table.printHashTable();

        if(table.findElement(word))
        {
            System.out.print("Такое слово есть. " + "Его Хэш: " + table.hashFunc(word));
        }
        else
            System.out.print("Такого слова нету.");




    }

    public static void list_gen() {
        String var = "";

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество элементов или отбейте enter (стандартное значение = 20)");
        var = sc.nextLine();
        if (!var.equals(""))
            n = Integer.parseInt(var);

        System.out.println("Введите значение min_limit или отбейте enter (стандартное значение = -250)");
        var = sc.nextLine();
        if (!var.equals(""))
            min_limit = Integer.parseInt(var);

        System.out.println("Введите значение max_limit или отбейте enter (стандартное значение = 1009)");
        var = sc.nextLine();
        if (!var.equals(""))
            max_limit = Integer.parseInt(var);

        list = new ArrayList<Integer>();
        arr = new int[n];

        System.out.println("\nSource array");

        int temp = 0;

        for (int i = 0; i < n; i++) {
            temp = (int) (Math.random() * (max_limit - min_limit)) + min_limit;
            list.add(temp);
            arr[i] = temp;
            System.out.print(list.get(i) + " ");
        }
        System.out.println("\n");
    }

    public static void output_list(ArrayList<Integer> list){
        for (int i = 0; i < n; i++) {
                System.out.print(list.get(i) + " ");
            }
    }

    public static void output_arr(int []arr){
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int  findMidPoint(int min, int max){
        return (min+max)/2;
    }

    public static void binarySearch(int key){
        System.out.println("\nBinarySearch");

        ArrayList<Integer> sortedList = new ArrayList<Integer>(list);
        Collections.sort(sortedList);
        System.out.print("Sorted array\n");
        output_list(sortedList);
        int position;
        int first = 0;
        int last = n - 1;

        position = (first + last) / 2;

        while ((sortedList.get(position) != key) && (first <= last)) {
            if (sortedList.get(position) > key) {  // если число заданного для поиска
                last = position - 1; // уменьшаем позицию на 1.
            } else {
                first = position + 1;    // иначе увеличиваем на 1
            }
            position = (first + last) / 2;
        }
        if (first <= last)
            System.out.println("\n" + key + " является " + ++position + " элементом в массиве.\n");
        else
            System.out.println("\n" + "Элемент не найден в массиве.\n");
    }

    public static void binaryTree(int key){
        System.out.println("Tree search");
        Tree tree = new Tree();
        for (int i = 0; i < n; i++){
            tree.insertNode(list.get(i));
        }
        tree.printTree();
        Node foundNode = tree.findNodeByValue(key);
        if (foundNode == null){
            System.out.println("Такого узла в дереве нет");
        }
        else
            foundNode.printNode();
    }

    //Фибоначиев поиск
    public static class FibonachySearch{
        private int i;
        private int p;
        private int q;
        private boolean stop = false;

        private void init(int[] arr){
            stop = false;
            int k = 0;
            int n = arr.length;
            for(; getFibonachyNumber(k+1) < n+1;){
                k +=1;
            }
            int m = getFibonachyNumber(k+1)-(n+1);
            i = getFibonachyNumber(k) - m;
            p = getFibonachyNumber(k-1);
            q = getFibonachyNumber(k-2);
        }

        public int getFibonachyNumber(int k){
            int firstNumber = 0;
            int secondNumber = 1;
            for (int i = 0;i<k;i++){
                int temp = secondNumber;
                secondNumber += firstNumber;
                firstNumber = temp;
            }
            return firstNumber;
        }

        private void upIndex(){
            if (p==1)
                stop = true;
            i = i + q;
            p = p - q;
            q = q - p;
        }

        private void downIndex(){
            if (q==0)
                stop = true;
            i = i - q;
            int temp = q;
            q = p - q;
            p = temp;
        }

        public int search(int[] arr,int element){
            init(arr);
            int n = arr.length;
            int resIn = -1;
            for (; !stop;){
                if (i < 0){
                    upIndex();
                }
                else if (i>=n){
                    downIndex();
                }
                else if (arr[i]==element){
                    resIn = i;
                    break;
                }
                else if (element <arr[i]){
                    downIndex();
                }
                else if (element > arr[i])
                {
                    upIndex();
                }
            }
            return resIn;
        }
    }

    //Интерполяционный поиск
    public static int interpolationSearch(int[] sortedArray, int toFind) {
        // Возвращает индекс элемента со значением toFind или -1, если такого элемента не существует
        int mid;
        int low = 0;
        int high = sortedArray.length - 1;

        while (sortedArray[low] < toFind && sortedArray[high] > toFind) {
            if (sortedArray[high] == sortedArray[low]) // Защита от деления на 0
                break;
            mid = low + ((toFind - sortedArray[low]) * (high - low)) / (sortedArray[high] - sortedArray[low]);

            if (sortedArray[mid] < toFind)
                low = mid + 1;
            else if (sortedArray[mid] > toFind)
                high = mid - 1;
            else
                return mid;
        }

        if (sortedArray[low] == toFind)
            return low;
        if (sortedArray[high] == toFind)
            return high;

        return -1;
    }
}