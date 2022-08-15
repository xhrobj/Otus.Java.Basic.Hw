package ru.mishe1.homeworks.hw6_5;

/*
    3. Создать массив с любым типом данных пример String[] array = {"test"} и сделать так чтобы можно было бы в него
       добавить данные и в результате было бы {"test", "НОВОЕ ЗНАЧЕНИЕ"}
 */

public class HomeWorkExtra {
    public static void main(String[] agrs) {
        int[] xx = {1, 2, 3};
        System.out.println(xx[2]);
        xx = addValue(4, xx);
        System.out.println(xx[3]);
    }

    private static int[] addValue(int x, int[] xx) {
        final var result = new int[xx.length + 1];
        for (var i = 0; i < xx.length; i++) {
            result[i] = xx[i];
        }
        result[xx.length] = x;
        return result;
    }
}
