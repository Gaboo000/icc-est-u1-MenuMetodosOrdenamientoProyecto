import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner (System.in);
        MetodosOrdenamiento metodos = new MetodosOrdenamiento();
        int opcion;

        int[] arregloNumeros= new int[0];
        do{
            System.out.println("\n      Menu Principal");
            System.out.println("============================");
            System.out.println("||1. Ingrese un arreglo   ||");
            System.out.println("||2. Ordenar arreglo      ||");
            System.out.println("||0. Salir                ||");
            System.out.println("============================");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    boolean tamanioValido = false;
                    int tamanio = 0;
                
                    
                    while (!tamanioValido) {
                        try {
                            System.out.println("Ingrese un tamaño para su arreglo: ");
                            tamanio = scanner.nextInt();
                            if (tamanio > 0) { 
                                tamanioValido = true;
                            } else {
                                System.out.println("El tamaño debe ser un número positivo. Intente nuevamente.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("~ ERROR!: No se puede ingresar caracteres o letras.\n Intente nuevamente.\n");
                            scanner.next(); 
                        }
                    }
                
                    
                    arregloNumeros = new int[tamanio]; 
                
                    
                    for (int i = 0; i < tamanio; i++) {
                        boolean valorValido = false;
                        while (!valorValido) {
                            try {
                                System.out.println("Ingrese el valor para la posición " + (i + 1) + ": ");
                                arregloNumeros[i] = scanner.nextInt();
                                valorValido = true; 
                            } catch (InputMismatchException e) {
                                System.out.println("~ ERROR!: No se puede ingresar caracteres o letras.\n Intente nuevamente.\n");
                                scanner.next(); 
                            }
                        }
                    }
                
                    
                    System.out.println("\n~ EL ARREGLO QUE INGRESÓ ES: " + Arrays.toString(arregloNumeros));
                
                    break;
                case 2:
                    if(arregloNumeros.length < 1){
                        System.out.println("================================================");
                        System.out.println("    Aún no se ha ingresado un arreglo.          ");
                        System.out.println("    Ingrese primero una arreglo para continuar  ");
                        System.out.println("================================================");
                    }else{
                        Arrays.sort(arregloNumeros);
                        mostrarSegundoMenu(scanner, metodos, arregloNumeros);
                    }
                    break;
                case 0:
                    System.out.println("Saliendo . . . .\nGracias por usar el programa, Adios.");

                    break;
            
                default:
                    System.out.println("opcion no valida por favor ingrese una opcion valida.\nRegresando al menu principal....");
                    break;
                
            } 
        }while(opcion != 0 );

        scanner.close();

    }

    private static void mostrarSegundoMenu(Scanner scanner, MetodosOrdenamiento metodos, int[] arregloNumeros) {
        int opcionMetodo=0;
        do {
            System.out.println("\n¿Con que metodo quisiera ordenar su arreglo?");
            System.out.println("==========================================");
            System.out.println("|| 1. Metodo Burbuja                    ||");
            System.out.println("|| 2. Metodo Seleccion                  ||");
            System.out.println("|| 3. Metodo Insercion                  ||");
            System.out.println("|| 4. Metodo Burbuja mejorado           ||");
            System.out.println("|| 0. Regresar al menu principal        ||");
            System.out.println("==========================================");
            opcionMetodo = scanner.nextInt();
            switch (opcionMetodo) {
                case 1:
                    System.out.println("Ingrese 'S' para ver los pasos o 'N' para mostrar solo el resultado:");
                    String opcionBubble = scanner.next();
                    boolean mostrarPasosBubble;
                    if(opcionBubble.equalsIgnoreCase("S")){
                        mostrarPasosBubble = true;
                    }else if(opcionBubble.equalsIgnoreCase("N")){
                        mostrarPasosBubble= false;
                    }else{
                        System.out.println("La opcion ingresada no es valida, por favor ingrese una opcion valida");
                        break;
                    }
                    boolean ascendentBubble = pedirDireccionOrden(scanner);


                    //se llama al metodo
                    int[] arregloCopiaBubble = arregloNumeros.clone();
                    int[] arregloOrdenadoBubble = metodos.metodoBurbuja(arregloCopiaBubble, mostrarPasosBubble, ascendentBubble);
                    System.out.println("||  Arreglo ordenado con Burbuja : " + Arrays.toString(arregloOrdenadoBubble));
                    break;
                case 2:
                    System.out.println("Ingrese 'S' para ver los pasos o 'N' para mostrar solo el resultado:");
                    String opcionLogSelection = scanner.next();
                    boolean mostrarPasosSelection;
                    if (opcionLogSelection.equalsIgnoreCase("S")) {
                        mostrarPasosSelection = true;
                    } else if (opcionLogSelection.equalsIgnoreCase("N")) {
                        mostrarPasosSelection = false;
                    } else {
                        System.out.println("Opción no válida,ingrese una opcion valida");
                        break;
                    }
                    boolean ascendentSelection = pedirDireccionOrden(scanner);

                    int[] arregloOrdenadoSelection = metodos.metodoSelection(arregloNumeros, mostrarPasosSelection, ascendentSelection);
                    System.out.println("||  Arreglo ordenado con Selección: " + Arrays.toString(arregloOrdenadoSelection));
                    break;
                case 3:
                    System.out.println("Ingrese 'S' para ver los pasos o 'N' para mostrar solo el resultado:");
                    String opcionLogInsertion = scanner.next();
                    boolean mostrarPasosInsertion;
                    if (opcionLogInsertion.equalsIgnoreCase("S")) {
                        mostrarPasosInsertion = true;
                    } else if (opcionLogInsertion.equalsIgnoreCase("N")) {
                        mostrarPasosInsertion = false;
                    } else {
                        System.out.println("||  Opción no válida,ingrese una opcion valida");
                        break;
                    }
                
                    boolean ascendentInsertion = pedirDireccionOrden(scanner);
                    int[] arregloOrdenadoInsertion = metodos.metodoInsercion(arregloNumeros, mostrarPasosInsertion, ascendentInsertion);
                    System.out.println("||  Arreglo ordenado con Inserción: " + Arrays.toString(arregloOrdenadoInsertion));
                    break;
                case 4:
                    System.out.println("Ingrese 'S' para ver los pasos o 'N' para mostrar solo el resultado:");
                    String opcionLogBubbleOptimizado = scanner.next();
                    boolean mostrarPasosOptimizado;
                    if (opcionLogBubbleOptimizado.equalsIgnoreCase("S")) {
                        mostrarPasosOptimizado = true;
                    } else if (opcionLogBubbleOptimizado.equalsIgnoreCase("N")) {
                        mostrarPasosOptimizado = false;
                    } else {
                        System.out.println("Opción no válida,ingrese una opcion valida");
                        break;
                    }
                    boolean ascendentOptimizado = pedirDireccionOrden(scanner);
                    
                    int[] arregloCopiaOptimizado = arregloNumeros.clone();
                    int[] arregloOrdenadoOptimizado = metodos.metodoBurbujaMejorado(arregloCopiaOptimizado, mostrarPasosOptimizado, ascendentOptimizado);
                    System.out.println("||  Arreglo ordenado con Burbuja Optimizado: " + Arrays.toString(arregloOrdenadoOptimizado));
                    break;
                case 0:
                    System.out.println("Regresando al menu principal,espere un momento . . . . .");
                    break;
            
                default:
                    System.out.println("||  La opcion ingresada no está dentro de el menú de opciones,por favor ingrese una opcion valida   ||");
                    System.out.println("------------------------------------------------------------------------------------------------------");
                    break;
            }

            
        } while (opcionMetodo !=0);
        
    }

    public static boolean pedirDireccionOrden(Scanner scanner) {
        System.out.println("¿Cómo desea ordenar su arreglo?");
        System.out.println("  A. Ascendentemente");
        System.out.println("  D. Descendentemente");
        String opcionOrden = scanner.next();
        return opcionOrden.equalsIgnoreCase("a");
    }
}
