public class MetodoBurbuja {

    public void ordenar(int[] array, boolean conditional, boolean pasos) {
        int comparaciones = 0;
        int cambios = 0;
        
        if (pasos) {
            System.out.print("Arreglo original -> ");
            printArray(array);
            System.out.println();
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                comparaciones++;
                
                if (pasos) {
                    System.out.print("Comparación " + comparaciones + ": " + array[j] + 
                                   (conditional ? " > " : " < ") + array[j + 1]);
                }

                boolean debeIntercambiar = conditional ? (array[j] > array[j + 1]) : (array[j] < array[j + 1]);

                if (debeIntercambiar) {
                    cambios++;
                    if (pasos) {
                        System.out.println(" - Intercambio: " + array[j] + " <-> " + array[j + 1]);
                    }
                    
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    
                    if (pasos) {
                        System.out.print("Estado actual -> ");
                        printArray(array);
                        System.out.println();
                    }
                } 

                else if (pasos) {
                    System.out.println(" - No hay intercambio");
                    System.out.print("Estado actual -> ");
                    printArray(array);
                    System.out.println();
                }
            }
        }

        if (pasos) {
            System.out.println("---FIN DEL METODO---");
            System.out.println("Comparaciones Totales -> " + comparaciones);
            System.out.println("Cambios Totales -> " + cambios);
        }
    }

    public void printArray(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) {
                System.out.print(" ");
            }
        }
    }
}