import java.util.Random;

public class MatrixOperations {
    public static void main(String[] args) {
        MatrixGenerator matrixGenerator = new MatrixGenerator();
        MatrixPrinter matrixPrinter = new MatrixPrinter();
        GeometricMeanCalculator geometricMeanCalculator = new GeometricMeanCalculator();

        int[][] generatedMatrix = matrixGenerator.generateMatrix();
        matrixPrinter.printMatrix(generatedMatrix);

        double geometricMean = geometricMeanCalculator.calculateGeometricMean(generatedMatrix);
        System.out.println("Наибольшее среднее геометрическое: " + geometricMean);
    }
}

class MatrixGenerator {
    public int[][] generateMatrix() {
        Random random = new Random();
        int[][] matrix = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = random.nextInt(10); // Генерируем случайные числа от 0 до 9
            }
        }
        return matrix;
    }
}

class MatrixPrinter {
    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

class GeometricMeanCalculator {
    public double calculateGeometricMean(int[][] matrix) {
        double product = 1.0;

        // Четыре числа в верхнем правом углу
        int[] topRight = {matrix[0][matrix[0].length - 1], matrix[1][matrix[1].length - 1],
                matrix[0][matrix[0].length - 2], matrix[1][matrix[1].length - 2]};

        // Вычисляем произведение чисел
        for (int num : topRight) {
            product *= num;
        }

        // Вычисляем среднее геометрическое
        return Math.pow(product, 1.0 / topRight.length);
    }
}





