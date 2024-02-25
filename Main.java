import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n = 3; // Размер массива
        int[][] arr = ArrayGenerator.generateRandomArray(n);

        System.out.println("Исходный массив:");
        ArrayPrinter.printArray(arr);

        int maxSum = MaxSumCalculator.findMaxSumUpperTriangle(arr);

        System.out.println("\nМаксимальная сумма подстрок верхнего треугольника: " + maxSum);
    }
}

class ArrayGenerator {
    public static int[][] generateRandomArray(int n) {
        Random random = new Random();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = random.nextInt(10); // Генерируем случайные числа от 0 до 9
            }
        }
        return arr;
    }
}

class ArrayPrinter {
    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

class MaxSumCalculator {
    public static int findMaxSumUpperTriangle(int[][] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // Заполняем только верхний треугольник массива dp
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], (j > i) ? dp[i - 1][j - 1] : 0) + arr[i][j];
                }
            }
        }

        // Выводим массив dp
        System.out.println("\nЗаполненный массив dp:");
        ArrayPrinter.printArray(dp);

        // Находим максимальную сумму в последней строке верхнего треугольника
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, dp[n - 1][i]);
        }

        return maxSum;
    }
}

