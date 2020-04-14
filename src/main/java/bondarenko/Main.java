package bondarenko;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int min = 1;
        int max = 100;
        int diff = max - min;
        Random random = new Random();

        int[][] matrix1 = new int[1000][1000];
        int[][] matrix2 = new int[1000][1000];
        int[][]	result = new int[1000][1000];

        for(int index1 = 0; index1 < 1000; index1++) {
            for(int  index2 = 0; index2 < 1000; index2++) {
                matrix1[index1][index2] = random.nextInt(diff + 1) + min;
            }
        }

        for(int index1 = 0; index1 < 1000; index1++) {
            for(int  index2 = 0; index2 < 1000; index2++) {
                matrix2[index1][index2] = random.nextInt(diff + 1) + min;
            }
        }

        long time = System.currentTimeMillis();

        ArrayList<Calc> list = new ArrayList<Calc>();
        Calc calc;
        for(int index = 0; index < 1000;) {
            calc = new Calc(matrix1, matrix2, result, index, index += 250);
            list.add(calc);
            calc.start();
        }

        for(Calc one : list) {
            try {
                one.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Время выполнения при многопоточном вычислении = " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();

        Calc calc1 = new Calc(matrix1, matrix2, result, 0, 1000);
        calc1.start();

        try {
            calc1.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Время выполнения при одном потоке = " + (System.currentTimeMillis() - time));
    }
}

