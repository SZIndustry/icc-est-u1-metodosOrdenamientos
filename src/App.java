import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Variables
        int[] listado = {10, 21, 5, 8, -1, 0};
        int opcion;  
        
        // Configuración de Scanner
        Scanner leer = new Scanner(System.in);

        System.out.print("Elige una opción:");

        System.out.println();

        System.out.println("1. Metodo Seleccion \n2. Metodo Burbuja \n3. Metodo Insercion");

        opcion = leer.nextInt();
        
        // Estructura condicional corregida
        if (opcion == 1) {
            System.out.println(" Método Selección");

            MetodoSeleccion mS = new MetodoSeleccion();

            System.out.println("Arreglo original:");
            mS.printArray(listado);

            // Ordenar en forma ascendente
            mS.ordenar(listado, true);
            System.out.println("Arreglo ordenado ascendente:");
            mS.printArray(listado);

            // Ordenar en forma descendente
            mS.ordenar(listado, false);
            System.out.println("Arreglo ordenado descendente:");
            mS.printArray(listado);
        } 

        else if (opcion == 2) {
            System.out.println("Método Burbuja");

            MetodoBurbuja mB = new MetodoBurbuja();

            // Imprimir el arreglo original solo una vez
            System.out.println("Arreglo original:");
            for (int i = 0; i < listado.length; i++) {
                System.out.print(listado[i] + " ");
            }
            System.out.println();

            // Ordenar y mostrar en orden ascendente
            mB.ordenar(listado, true);
            mB.imprimirArreglo(listado, true);

            // Ordenar y mostrar en orden descendente
            mB.ordenar(listado, false);
            mB.imprimirArreglo(listado, false);
        }

        else if (opcion == 3) {
            MetodoInsercion metodo = new MetodoInsercion();                
            
            System.out.println("Arreglo original");
            metodo.imprimirArreglo(listado);
            metodo.ordenar(listado, true);
            System.out.println("Arreglo ordenado sin pasos");
            metodo.imprimirArreglo(listado);
            metodo.ordenar(listado, false);
            System.out.println("Arreglo ordenado con pasos");
            metodo.imprimirArreglo(listado);
        }

        else {
            System.out.println("Opción no válida");
        }
        
        // Cerrar Scanner
        leer.close();
    }
}
