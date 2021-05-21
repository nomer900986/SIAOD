import java.util.Arrays;
import java.util.Comparator;

public class Tasks2{
    public static void main(String[] args) {
        System.out.println("Задача 1. Шарики и стрелы");

        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println("Ответ: " + minArrow(points));

        points = new int[][]{{1,2},{3,4},{5,6},{7,8}};
        System.out.println("Ответ: " + minArrow(points));

        points = new int[][]{{1,2},{2,3},{3,4},{4,5}};
        System.out.println("Ответ: " + minArrow(points));

        points = new int[][]{{1,2}};
        System.out.println("Ответ: " + minArrow(points));

        points = new int[][]{{2,3},{2,3}};
        System.out.println("Ответ: " + minArrow(points));
    }

    public static int minArrow(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1])); // Сортировка по координате Xend
        System.out.println("Массив отсортирован: " + Arrays.deepToString(points));

        int arrow = 1; // Переменная кол-ва стрел
        int end = points[0][1]; // Берём первый шарик

        for (int i = 1; i < points.length; i++) {
            if (end < points[i][0]) { // Если шарик оказался дальше по координате xEnd
                arrow++; // Прибавляем кол-во стрел
                end = points[i][1]; // Перемещаем конечную точку на этот шар
            }
        }

        return arrow;
    }
}
