public class MetodoSeleccion {
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

        for (int i = 0; i < arreglo.length; i++) {
            int extremo = i;
            String tipoBusqueda = conditional ? "mínimo" : "máximo";
            
            if (pasos) {
                System.out.println("Buscando " + tipoBusqueda + " desde posición " + i);
            }
            
            for (int j = i + 1; j < arreglo.length; j++) {
                comparaciones++;
                boolean condicionComparacion = conditional ? (arreglo[j] < arreglo[extremo]) 
                                                          : (arreglo[j] > arreglo[extremo]);
                
                if (pasos) {
                    System.out.print("Comparación " + comparaciones + ": " + arreglo[j] + 
                                   (conditional ? " < " : " > ") + arreglo[extremo] + "? " + 
                                   (condicionComparacion ? "SÍ" : "NO"));
                }
                
                if (condicionComparacion) {
                    extremo = j;
                    if (pasos) {
                        System.out.println(" - Nuevo " + tipoBusqueda + " encontrado en posición " + 
                                         extremo + " (" + arreglo[extremo] + ")");
                    }
                } else if (pasos) {
                    System.out.println();
                }
            }
            
            if (i != extremo) {
                cambios++;
                if (pasos) {
                    System.out.println("Intercambio: " + arreglo[i] + " <-> " + arreglo[extremo]);
                }
                
                int aux = arreglo[i];
                arreglo[i] = arreglo[extremo];
                arreglo[extremo] = aux;
                
                if (pasos) {
                    System.out.print("Estado actual -> ");
                    printArray(arreglo);
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