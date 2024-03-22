/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea2;

/**
 *
 * @author victo
 */
import java.util.*;

public class Orden {

    public int[] selectionSort(int[] datos) {
        if (datos.length == 1) {
            return datos;
        }
        //        int[] datosdesordenados = {4, 2, 7, 6, 1, 9};
        //dado que el tamanioo es 6 y es <6 entonces el i llegara a 5 - 1 -> 4 este apuntara a uno antes del final
        for (int i = 0; i < datos.length - 1; i++) {
            int valorMinimo = i;
            //este es como si apuntara al final osea a 5
            for (int j = i + 1; j < datos.length; j++) {
                //si el indice j en esa posicion es menor que el apuntador anterior entonces el 
                //vas sa comparar al de atras cno el siguiente si el siguiente es menor entonces dale ese valor a valor minimo
                if (datos[j] < datos[valorMinimo]) {
                    valorMinimo = j;
                }
            }
            // Intercambiar el elemento actual con el mínimo encontrado
            int temp = datos[valorMinimo];
            datos[valorMinimo] = datos[i];
            datos[i] = temp;
        }
        /* info 
1. En cada iteracion busca el minimo del todo el arreglo
2. cuando obtiene el minimo intercambia los datos en el arreglo
3. el primer bucle sube una posicion 
4. el segundo bucle sube una posicion y ya no toma en cuenta el primero
5. repite 
cuando compara la posicioon de adelante con la de atras si J es menor que 
        el primer valor entonces el valor minimo ahora va a ser j guardamos ese valor y volvemos a empezar
        
         */
        return datos;
    }

    public int[] bubbleSort(int[] datos) {

        if (datos.length == 1) {
            return datos;
        }
        //        int[] datosdesordenados = {4, 2, 7, 6, 1, 9};
        //dado que el tamanioo es 6 y es <6 entonces el i llegara a 5 - 1 -> 4 este apuntara a uno antes del final
        for (int i = 0; i < datos.length - 1; i++) {
            //este es como si apuntara al final osea a 5 en la primera iteracion pero una condicion nos dice que si ya sabemos que es el maximo
            //no debemos llegar hasta el final por ese caso le restamos el indice por ejemplo en la segunda iteracion
            //6-1-1 = 4 y ya solo llegariamos a 3
            for (int j = 0; j < datos.length - i - 1; j++) {
                //la condicion nos dice que si el primero es mayor que el siguiente entonces
                if (datos[j] > datos[j + 1]) {
                    // Intercambiar el elemento actual con el mínimo encontrado
                    //guardamos el actual en temp
                    int temp = datos[j];
                    //en la posicion del dato ya guardado vamos a colocar el siguiente osea intercambiando
                    datos[j] = datos[j + 1];
                    //ahora el siguiente como era menor le daremos ese valor
                    datos[j + 1] = temp;
                }
            }

        }
        return datos;
    }

    public int[] insertionSort(int[] datos) {
        if (datos.length == 1) {
            return datos;
        }
        int j;
//        int[] datosdesordenados = {4, 2, 7, 6, 1, 9};
//seccionamos el tamanio ahora -> {2,7,6,1}
        for (int i = 1; i < datos.length - 1; i++) {
            int temp = datos[i];//-> i:1 datos[i]:2 donde guardamos el valor actual en una variable temporal
            j = i; //j = 1
            //j > 0 si
            //temp:2 <  datos[j-1]: 4 Si
            //aqui los va a ir corriendo hacia la derecha hasta que temp sea menor que su anterio
            while (j > 0 && temp < datos[j - 1]) {
                //datos[j]: 2 ahora =  datos[j-1] : 4
                datos[j] = datos[j - 1];
                //j:1 = j-1:0
                j--;
            }
            // datos[j]: 2 = 2
            //por ultimo actualizamos el valor del que seria el primero
            datos[j] = temp;
        }
        return datos;
    }
    //divide y venceras - recursividad

    public int[] mergeSort(int[] datos, int Inicio, int Final) {
        if (datos.length == 1) {
            return datos;
        }
        if (Inicio < Final) {
            int Mitad = (Inicio + Final) / 2;
            // System.out.println(Mitad);
            mergeSort(datos, Inicio, Mitad);
            mergeSort(datos, Mitad + 1, Final);
            merge(datos, Inicio, Mitad, Final);
        }
        return datos;
    }

    private void merge(int[] datos, int Inicio, int Mitad, int Final) {
        int listaAuxiliar[] = new int[Final - Inicio + 1];
        int izquierda = Inicio;
        int derecha = Mitad + 1;
        int iAuxiliar = 0;

        while (izquierda <= Mitad && derecha <= Final) {
            if (datos[izquierda] < datos[derecha]) {
                listaAuxiliar[iAuxiliar] = datos[izquierda];
                izquierda++;
            } else {
                listaAuxiliar[iAuxiliar] = datos[derecha];
                derecha++;
            }
            iAuxiliar++;
        }

        for (int k = derecha; k <= Final; k++) {
            listaAuxiliar[iAuxiliar] = datos[derecha];
            //derecha++;
            iAuxiliar++;
        }

        for (int k = izquierda; k <= Mitad; k++) {
            listaAuxiliar[iAuxiliar] = datos[izquierda];
            //izquierda++;
            iAuxiliar++;
        }

        for (int k = 0; k < iAuxiliar; k++) {
            datos[Inicio + k] = listaAuxiliar[k];
        }
    }

    public int[] quickSort(int[] datos, int Inicio, int Final) {
        if (datos.length == 1) {
            return datos;
        }
        if (Inicio < Final) {
            //el pivooote es nuestro punto de referencia similar a la mitad en el metoodo anterior
            int pivote = pivote(datos, Inicio, Final);
            // ordena los elementos antes y después del pivote
            quickSort(datos, Inicio, pivote - 1);
            quickSort(datos, pivote + 1, Final);
        }
        return datos;
    }

    private int pivote(int[] datos, int Inicio, int Final) {
        int pivote = datos[Inicio];//realmente esta en la posicion 0 siempre
        int i = Inicio;
        //apuntamos al inicio el cual es 0
        //poosoteriormente aumentamoos para recorrer hasta el final
        for (int j = Inicio + 1; j <= Final; j++) {
            if (datos[j] < pivote) {
                i++;
                //similar a los casos anteriores este temporal nos sirve para intercambiar datos
                int temp = datos[i];//guarda el valor del indice cero
                datos[i] = datos[j];//intercambia el valor
                datos[j] = temp;//ahora j tiene el valoor del primero
            }
        }
        // si no se da el casoo de arriba intercambiamos i coon el inicioo y el inicio con el pivote
        int temp = datos[i];
        datos[i] = datos[Inicio];
        datos[Inicio] = temp;
        return i;
    }

    public int[] heapSort(int[] datos) {
        int n = datos.length;

        // Construimoos un heap 
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(datos, n, i);
        }

        // Extraemos elementos uno por uno del heap y reconstruir el heap
        for (int i = n - 1; i > 0; i--) {
            // movemos el nodo raíz actual al final del arreglo haciendoo intercambios
            int temp = datos[0];
            datos[0] = datos[i];
            datos[i] = temp;

            // Llamar a heapify en el heap reducido
            heapify(datos, i, 0);
        }
        return datos;
    }

    private void heapify(int[] datos, int n, int i) {
        int nodoMasGrande = i; // Inicializar el nodo más grande como la raíz
        int izquierda = 2 * i + 1; // Índice del hijo izquierdo
        int derecha = 2 * i + 2; // Índice del hijo derecho

        // Si el hijo izquierdo es más grande que la raíz
        if (izquierda < n && datos[izquierda] > datos[nodoMasGrande]) {
            nodoMasGrande = izquierda;
        }

        // Si el hijo derecho es más grande que el más grande hasta ahora
        if (derecha < n && datos[derecha] > datos[nodoMasGrande]) {
            nodoMasGrande = derecha;
        }

        // Si el mayor no es la raíz
        if (nodoMasGrande != i) {
            int temp = datos[i];
            datos[i] = datos[nodoMasGrande];
            datos[nodoMasGrande] = temp;

            // Usamomos recursividad
            heapify(datos, n, nodoMasGrande);
        }
    }

    // función para ordenar el arreglo utilizando Counting Sort
    public int[] countingSort(int[] datos) {
        // arreglo auxiliar para contar la frecuencia de cada elemento
        int valorMaximo = obtenerMayor(datos);
        int[] count = new int[valorMaximo + 1];

        // contar la frecuencia de cada elemento en el arreglo
        for (int num : datos) {
            count[num]++;
        }

        // reconstruir el arreglo ordenado utilizando la frecuencia de cada elemento
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                datos[index++] = i;
                count[i]--;
            }
        }

        return datos;
    }
    // función para encontrar el valor máximo en el arreglo

    private int obtenerMayor(int[] datos) {
        int max = datos[0];
        for (int i = 1; i < datos.length; i++) {
            if (datos[i] > max) {
                max = datos[i];
            }
        }
        return max;
    }

    public int[] radixSort(int[] datos) {
        // realizar el Radix Sort para cada dígito en el valor máximo
        int valorMaximo = obtenerMayor(datos);
        for (int exp = 1; valorMaximo / exp > 0; exp *= 10) {
            countingSort(datos, exp);
        }
        return datos;
    }

    private void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; // arreglo de salida
        int[] count = new int[10]; // arreglo para contar la frecuencia de cada dígito

        // contamos la frecuencia de cada dígito en el arreglo
        for (int num : array) {
            count[(num / exp) % 10]++;
        }

        // actualizamos el arreglo de conteo para indicar la posición correc    ta de cada dígito
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // construimos el arreglo de salida basado en el arreglo de conteo
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // copiamos el arreglo de salida al arreglo original
        System.arraycopy(output, 0, array, 0, n);
    }
    // función para realizar el Bucket Sort en el arreglo
    public int  []  bucketSort(int[] datos) {
        int n = datos.length;
        List<Integer>[] buckets = new ArrayList[n];

        // creamos buckets vacíos
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // distribuimos los elementos en los buckets
        for (int num : datos) {
            int index = (int) (n * num);
            buckets[index].add(num);
        }

        // ordenamos los elementos dentro de cada bucket
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // concatenamos los buckets en el arreglo original
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                datos[index++] = num;
            }
        }
        return datos ;
    }

}
    