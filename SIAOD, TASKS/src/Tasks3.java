import  java.util.Arrays;

public class Tasks3 {
    public static void main(String[] args) {
        System.out.println("Задача 1. Стопки монет");

        int[] piles = {2,4,1,2,7,8};
        max_coins(piles);

        piles = new int[]{2,4,5};
        max_coins(piles);

        piles = new int[]{9,8,7,6,5,1,2,3,4};
        max_coins(piles);
    }

    public static void max_coins(int[] piles){
        Arrays.sort(piles);

        int sum = 0;
        int i = piles.length - 2;
        int j = 0;

        while(j++ < piles.length / 3){
            sum += piles[i];
            i -=2;
        }
        System.out.println("Максимальное число монет " + sum);
    }
}