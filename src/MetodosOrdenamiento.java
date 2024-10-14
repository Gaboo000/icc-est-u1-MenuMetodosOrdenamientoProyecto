import java.util.Arrays;
import java.util.Scanner;

public class MetodosOrdenamiento {
    Scanner leer = new Scanner(System.in);

    //METODO BUBBLE SORT
    public int[] metodoBurbuja (int[] array ,boolean logs, boolean opcionBubble){
        int tamanio = array.length;
        if(logs){
            System.out.println("Ordenando arreglo por Metodo de Burbuja: \nEspere un momento....");
        }
        boolean mostrarPasos = logs;
        for (int i = 0 ; i < tamanio; i++ ){
            if (mostrarPasos){
                System.out.println("Pasando numero: "+(i+1));
            }
            for ( int j= i+1 ; j < tamanio; j++){
                if (mostrarPasos) {
                    System.out.println("i=" + array[i] + " j=" + array[j]);
                }
                if (opcionBubble){
                    if(array[i]>array[j]){
                        if(mostrarPasos){
                            System.out.println("~~ SI ES MAYOR ASI QUE HAY CAMBIO ");
                            System.out.println("  __________________________________");
                        }
                        //intercambio de elementos
                        int temp = array[i];
                        array [i]= array[j];
                        array[j]=temp;
                        if(mostrarPasos){
                            System.out.println(" || ");
                            print(array);
                        }


                    }
                }else{
                    if(array[i]<array[j]){
                        if (mostrarPasos) {
                            System.out.println("~~ SI ES MENOR ASI QUE HAY CAMBIO");
                            System.out.println("  __________________________________");  
                        }
                        // intercambio de elementos
                        int temporal = array[i];
                        array[i] = array[j];
                        array[j] = temporal;
                        if (mostrarPasos) {
                            System.out.println(" ");
                            print(array);
                        }
                    }
                }
            }
        }
        return array;
    }


    //METODO BUBBLE SORT ADVANCE

    public int[] metodoBurbujaMejorado (int[] array, boolean logs, boolean opcionBubbleOptimized){
        int tamanio = array.length;
        boolean cambio;
        if(logs){
            System.out.println("Ordenando arreglo por Metodo de Burbuja: \nEspere un momento....");
        }
        for(int i = 0; i<tamanio-1; i++){
            cambio= false;

            for(int j = 0; j < tamanio - i - 1; j++ ){
                
                if((opcionBubbleOptimized && array[j]>array[j+1]) || (!opcionBubbleOptimized && array[j]<array[j+1])){

                    //intercambio de elementos
                    int temp = array [j];
                    array[j]= array[j+1];
                    array[j+1]= temp;
                    cambio = true;
                }
                if(logs){
                    System.out.println("~~ PASOS EN LA ITERACION:  " + (j+1) + ": " + Arrays.toString(array));
                }


            }if(!cambio){
                break;
            }
        }
        return array;

    }


    //METODO INSERTION

    public int[] metodoInsercion (int[] array ,boolean logs, boolean opcionInsertion){
        int tamanio = array.length;
        if(logs){
            System.out.println("Ordenando el arreglo por el método de Insercion: \nEspere un momento....");
        }

        for (int i = 1; i < tamanio; ++i) {
            int position = array[i];
            int j = i - 1;

            while (j >= 0 && ((opcionInsertion && array[j] > position) || (!opcionInsertion && array[j] < position))) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = position;

            if (logs) {
                System.out.println("~~ MOVIENDO ELEMENTO: " + position + ", ARREGLO: " + Arrays.toString(array));
            }
        }
        return array;

    }


    //METODO SELECTION SORT


    public int[] metodoSelection(int[] array, boolean logs, boolean opcionSelection) {
        int tamano = array.length;

        if (logs) {
            System.out.println("Ordenando el arreglo por el método de Seleccion: \nEspere un momento....");

        }

        for (int i = 0; i < tamano - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < tamano; j++) {
                if ((opcionSelection && array[j] < array[indiceMinimo]) || (!opcionSelection && array[j] > array[indiceMinimo])) {
                    indiceMinimo = j;
                }
            }

            int temporal = array[indiceMinimo];
            array[indiceMinimo] = array[i];
            array[i] = temporal;

            if (logs) {
                System.out.println("~~ INTERCAMBIANDO LOS ELEMENTOS: " + Arrays.toString(array));
            }
        }

        return array;
    }



    private void print(int[] array) {
        for( int i=0; i< array.length; i++){
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }
    
}
