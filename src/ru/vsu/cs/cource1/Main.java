package ru.vsu.cs.cource1;

import java.util.Scanner;

public class Main {
//17. Считалочка. N ребят расположены по кругу. (Каждому присвоен номер по порядку).
//Начав отсчѐт от первого, удаляют каждого k-ого, смыкая при этом круг. Определить
//номер последнего, оставшегося в круге. (kN).
//Указание: для решения задачи использовать список, в котором ссылочное поле
//последнего элемента содержит ссылку на первый элемент

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.print("Enter k: ");
        int k = sc.nextInt();

//        int i = 0;
//        for (Integer v : list.fillingInTheList(n)) {
//            if (i < n) {
//                System.out.print((i > 0 ? ", " : "") + v);
//                i++;
//            } else break;
//        }
        System.out.println();

        System.out.println("Result: " + list.searcher(k, list.fillingInTheList(n)));
    }
}
