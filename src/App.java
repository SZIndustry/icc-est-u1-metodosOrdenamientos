import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int opcion;  
        
        Scanner leer = new Scanner(System.in);
        boolean continuar = true;
        
        while (continuar) {

            int[] listado = { 12, -7, 25, 0, -15, 33, 19, -22, 5, 48, -3, 27, -30, 14, 7, -1, 41, 20, -11, 8};

            System.out.println();
            System.out.print("Elige una opción:\n");
            System.out.println("1. Método Selección \n2. Método Burbuja \n3. Método Inserción \n4. Método Burbuja Avanzado \n5. Salir");
            System.out.println();
            
            opcion = getPositive(leer, "Ingrese su opción (1-5):", 1, 5);
            
            if (opcion == 5) {
                System.out.println();
                System.out.println("adiós");
                System.out.println();
                continuar = false;
                break;
            }

            System.out.println();
            System.out.println("¿Desea ver los pasos? (true/false):");
            boolean pasos = getValidBoolean(leer);

            System.out.println();
            String orden = getValidString(leer, new String[]{"A", "D"}, "¿Desea ordenar ascendente (A) o descendente (D)?");
            boolean conditional = orden.equalsIgnoreCase("A");

            System.out.println();
            System.out.println("Arreglo original:");
            printArray(listado);
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.println("\nMétodo Selección");
                    MetodoSeleccion mS = new MetodoSeleccion();
                    mS.ordenar(listado, conditional, pasos);
                    System.out.println();
                    System.out.println("Arreglo ordenado " + (conditional ? "ASCENDENTE" : "DESCENDENTE") + ":");
                    mS.printArray(listado);
                    System.out.println();
                    break;
                    
                case 2:
                    System.out.println("\nMétodo Burbuja");
                    MetodoBurbuja mB = new MetodoBurbuja();
                    mB.ordenar(listado, conditional, pasos);
                    System.out.println();
                    System.out.println("Arreglo ordenado " + (conditional ? "ASCENDENTE" : "DESCENDENTE") + ":");
                    mB.printArray(listado);
                    System.out.println();
                    break;
                    
                case 3:
                    System.out.println("\nMétodo Inserción");
                    MetodoInsercion mI = new MetodoInsercion();
                    mI.ordenar(listado, conditional, pasos);
                    System.out.println();
                    System.out.println("Arreglo ordenado " + (conditional ? "ASCENDENTE" : "DESCENDENTE") + ":");
                    mI.imprimirArreglo(listado);
                    System.out.println();
                    break;

                case 4:
                    System.out.println("\nMétodo Burbuja Avanzado");
                    MetodoBurbujaAvanzado mBA = new MetodoBurbujaAvanzado();
                    mBA.ordenar(listado, conditional, pasos);
                    System.out.println();
                    System.out.println("Arreglo ordenado " + (conditional ? "ASCENDENTE" : "DESCENDENTE") + ":");
                    mBA.printArray(listado);
                    System.out.println();
                    break;
   
                default:
                    System.out.println("\n¡Opción no válida!");
            }
        }
    }

    public static int getPositive(Scanner scanner, String message, int min, int max) {
        int input;
        do {
            System.out.print(message + " ");
            while (!scanner.hasNextInt()) {
                System.out.println(" Debe ingresar un número entero válido.");
                scanner.next();
                System.out.print(message + " ");
            }
            input = scanner.nextInt();
            if (input < min || input > max) {
                System.out.println(" El número debe estar entre " + min + " y " + max + ".");
            }
        } while (input < min || input > max);
        return input;
    }

    public static String getValidString(Scanner scanner, String[] posibles, String message) {
        String input;
        boolean valido;
        do {
            System.out.print(message + " ");
            input = scanner.next();
            valido = false;
            for (String posible : posibles) {
                if (input.equalsIgnoreCase(posible)) {
                    valido = true;
                    break;
                }
            }
            if (!valido) {
                System.out.println(" Opciones válidas: " + String.join("/", posibles));
            }
        } while (!valido);
        return input;
    }

    public static boolean getValidBoolean(Scanner scanner) {
        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("true")) {
                return true;
            } else if (input.equalsIgnoreCase("false")) {
                return false;
            } else {
                System.out.println(" Opción no válida.");
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}