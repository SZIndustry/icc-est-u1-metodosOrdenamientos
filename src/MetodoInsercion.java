public class MetodoInsercion {
    private int comparaciones = 0;
    private int cambios = 0;

    public void ordenar(int[] array, boolean conditional, boolean pasos) {
        comparaciones = 0;
        cambios = 0;

        if (pasos) {
            System.out.print("Arreglo original -> ");
            imprimirArreglo(array);
            System.out.println();
        }

        for (int i = 1; i < array.length; i++) {
            int aux = array[i];
            int j = i - 1;
            String tipoOrden = conditional ? "ascendente" : "descendente";

            if (pasos) {
                System.out.println("Iteración " + i + " (Orden " + tipoOrden + ")");
                System.out.println("Elemento actual -> " + aux + " en posición " + i);
            }

            while (j >= 0) {
                comparaciones++;
                boolean condicion = conditional ? (aux < array[j]) : (aux > array[j]);
                
                if (pasos) {
                    System.out.print("Comparación " + comparaciones + ": " + aux + 
                                   (conditional ? " < " : " > ") + array[j] + "? " + 
                                   (condicion ? "SÍ" : "NO"));
                }

                if (condicion) {
                    cambios++;
                    if (pasos) {
                        System.out.println(" - Mover " + array[j] + " a posición " + (j + 1));
                    }
                    array[j + 1] = array[j];
                    j--;
                } else {
                    if (pasos) {
                        System.out.println();
                    }
                    break;
                }
            }

            if (j + 1 != i) {
                array[j + 1] = aux;
                if (pasos) {
                    System.out.println("Insertar " + aux + " en posición " + (j + 1));
                    System.out.print("Estado actual -> ");
                    imprimirArreglo(array);
                    System.out.println();
                }
            }
        }

        if (pasos) {
            System.out.println("---FIN DEL METODO---");
            System.out.println();
            System.out.println("Comparaciones Totales -> " + comparaciones);
            System.out.println("Cambios Totales -> " + cambios);
        }
    }

    public void imprimirArreglo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
    }
}