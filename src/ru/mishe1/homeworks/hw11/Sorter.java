package ru.mishe1.homeworks.hw11;

import java.util.ArrayList;

class Sorter {
    static void bubbleSort(int[] xx) {
        if (xx.length < 2) return;

        var counter = xx.length;
        while (counter-- != 0) {
            var swapFound = false;
            for (var i = 0; i < counter; i++) {
                if (xx[i] > xx[i + 1]) {
                    final var tmp = xx[i];
                    xx[i] = xx[i + 1];
                    xx[i + 1] = tmp;
                    swapFound = true;
                }
            }
            if (!swapFound) break;
        }
    }

    static void bubbleSort(ArrayList<Comparable> xx) {
        int counter = xx.size();
        if (counter < 2) return;

        while (counter-- != 0) {
            var swapFound = false;

            for (var i = 0; i < counter; i++) {
                final var x1 = xx.get(i);
                final var x2 = xx.get(i + 1);

                if (x1.compareTo(x2) <= 0) continue;

                xx.set(i, x2);
                xx.set(i + 1, x1);
                swapFound = true;
            }

            if (!swapFound) return;
        }
    }
}
