/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tarea2;

/**
 *
 * @author victo
 */
import java.util.*;

public class Tarea2 {

    public static void main(String[] args) {
        Orden orden = new Orden();
        int[] datos;
        Scanner entrada = new Scanner(System.in);
        String opcion;
        int[] datosdesordenados = {4, 2, 7, 6, 1, 9};
        do {
            System.out.println("+-----------------------------------------------+");
            System.out.println("|[1]|Selection sort\t\t|(Selección)\t|");
            System.out.println("|[2]|Bubble    sort\t\t|(Burbuja)\t|");
            System.out.println("|[3]|Insertion sort\t\t|(Inserción)\t|");
            System.out.println("|[4]|Merge     sort\t\t|(Combinación)\t|");
            System.out.println("|[5]|Quick     sort\t\t|(Rápida)\t|");
            System.out.println("|[6]|Heap      sort\t\t|(Montón)\t|");
            System.out.println("|[7]|Counting  sort\t\t|(Conteo)\t|");
            System.out.println("|[8]|Radix     sort\t\t|(Raíz)\t\t|");
            System.out.println("|[9]|Bucket    sort\t\t|(Cubo)\t\t|");
            System.out.println("+-----------------------------------------------+");
            System.out.println("|[0]|Salir                                      |");
            System.out.println("+-----------------------------------------------+");

            System.out.println("Ingrese una opción:");

            opcion = entrada.nextLine();
            switch (opcion) {
                case "1":
                    datos = orden.selectionSort(datosdesordenados);
                    for (int i = 0; i < datos.length; i++) {
                        System.out.print(datos[i]);
                    }
                    System.out.println();
                    break;
                case "2":
                    datos = orden.bubbleSort(datosdesordenados);
                    for (int i = 0; i < datos.length; i++) {
                        System.out.print(datos[i]);
                    }
                    System.out.println();
                    break;
                case "3":
                    datos = orden.insertionSort(datosdesordenados);
                    for (int i = 0; i < datos.length; i++) {
                        System.out.print(datos[i]);
                    }
                    System.out.println();
                    break;
                case "4":
                    datos = orden.mergeSort(datosdesordenados, 0, datosdesordenados.length - 1);
                    for (int i = 0; i < datos.length; i++) {
                        System.out.print(datos[i]);
                    }
                    System.out.println();
                    break;
                case "5":
                    datos = orden.quickSort(datosdesordenados, 0, datosdesordenados.length - 1);
                    for (int i = 0; i < datos.length; i++) {
                        System.out.print(datos[i]);
                    }
                    System.out.println();
                    break;
                case "6":
                    datos = orden.heapSort(datosdesordenados);
                    for (int i = 0; i < datos.length; i++) {
                        System.out.print(datos[i]);
                    }
                    System.out.println();
                    break;
                case "7":
                    datos = orden.countingSort(datosdesordenados);
                    for (int i = 0; i < datos.length; i++) {
                        System.out.print(datos[i]);
                    }
                    System.out.println();
                    break;
                case "8":
                    datos = orden.radixSort(datosdesordenados);
                    for (int i = 0; i < datos.length; i++) {
                        System.out.print(datos[i]);
                    }
                    System.out.println();
                    break;
                case "9":
                    datos = orden.radixSort(datosdesordenados);
                    for (int i = 0; i < datos.length; i++) {
                        System.out.print(datos[i]);
                    }
                    System.out.println();
                    break;
            }
        } while (!opcion.equalsIgnoreCase("0"));
    }
}
    