package ru.larin.laba2;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by denislarin on 21.01.17.
 */
public class Main {
    static Scanner scanner_Line = new Scanner(System.in);
    static String help;

    public static void main(String[] args) {
        int number_of_maximum = 0;
        int Number_of_element = 0;
        System.out.println("Введите количество элементов массива");
        help = scanner_Line.nextLine();
        Number_of_element = Integer.parseInt(help);
        int[] array = new int[Number_of_element];
        System.out.println("1.заполнить Random\n2.заполнить вручную");
        help = scanner_Line.nextLine();
        switch (Integer.parseInt(help)) {
            default:
                break;
            case 1:
                Rand_take(array);
                break;
            case 2:
                Hand_take(array);
                break;
        }
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                if (array[i] > array[i + 1]) {
                    number_of_maximum++;
                    i++;
                }
            } else if (i == array.length - 1) {
                if (array[i] > array[i - 1]) {
                    number_of_maximum++;
                    i++;
                }
            } else if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                number_of_maximum++;
                i++;
            }
        }
        System.out.println("Количество точек максимума " + number_of_maximum);
    }

    private static void Hand_take(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите " + (i + 1) + " элемент массива");
            if (scanner_Line.hasNextInt()) {
                help = scanner_Line.nextLine();
                array[i] = Integer.parseInt(help);
            } else {
                System.out.println("Введиче число");
            }
        }
    }

    private static void Rand_take(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }
}
