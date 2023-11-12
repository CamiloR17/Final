package com.ejemplo.estudiantes.utils;
import java.util.Scanner;

public class KeyBoard {
    public static int Int(String mensaje) {
        Scanner in = new Scanner(System.in);
        System.out.print(mensaje + "-> ");
        return in.nextInt();
    }

    public static double dou(String mensaje) {
        Scanner in = new Scanner(System.in);
        System.out.print(mensaje + "-> ");
        return in.nextDouble();
    }

    public static String str(String mensaje) {
        Scanner in = new Scanner(System.in);
        System.out.print(mensaje + "-> ");
        return in.nextLine();
    }

    public static void nLine(String mensaje) {
        Scanner in = new Scanner(System.in);
        System.out.print(mensaje);
        in.nextLine();
    }
}
