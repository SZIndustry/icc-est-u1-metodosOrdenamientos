public class MetodoBurbujaAvanzado {
    private int comparaciones = 0;
    private int cambios = 0;

    public void ordenar(int[] arreglo, boolean conditional, boolean pasos) {
        comparaciones = 0;
        cambios = 0;

        if (pasos) {
            System.out.print("Arreglo original -> ");
            printArray(arreglo);
            System.out.println();
        }

        for (int i = 0; i < arreglo.length - 1; i++) {
            if (pasos) {
                System.out.println("--- Pasada " + (i + 1) + " ---");
            }

            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                comparaciones++;
                boolean debeIntercambiar = conditional ? (arreglo[j] > arreglo[j + 1]) 
                                                    : (arreglo[j] < arreglo[j + 1]);

                if (pasos) {
                    System.out.print("Comparación " + comparaciones + ": " + arreglo[j] + 
                                   (conditional ? " > " : " < ") + arreglo[j + 1] + "? " + 
                                   (debeIntercambiar ? "SÍ" : "NO"));
                }

                if (debeIntercambiar) {
                    cambios++;
                    if (pasos) {
                        System.out.println(" - Intercambio: " + arreglo[j] + " <-> " + arreglo[j + 1]);
                    }

                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;

                    if (pasos) {
                        System.out.print("Estado actual -> ");
                        printArray(arreglo);
                        System.out.println();
                    }
                } else if (pasos) {
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

    protected void printArray(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) {
                System.out.print(" ");
            }
        }
    }
}