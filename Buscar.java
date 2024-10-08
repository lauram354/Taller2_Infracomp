import java.util.Scanner;

/*LABORATORIO 2 - INFRAESTRUCTURA COMPUTACIONAL */
/*Grupo 11: Laura Murcia, Monica Gonzalez, Camilo Quimbay */

public class Buscar extends Thread{
    private static Maximo maximo = new Maximo();
    private static Vector vector;
    private static int actual = 0;
    private int inicio;
    private int ultimaPos;

    public Buscar(Vector vector, int inicio, int ultimaPos){
        this.inicio = inicio;
        this.ultimaPos = ultimaPos;
    }

    @Override 
    public void run(){
        int localMax = 0;
        for (int j = inicio; j < ultimaPos; j++){
            if (vector.getValue(j) > localMax){
                localMax = vector.getValue(j);
            }
        }
        synchronized(maximo){
            maximo.actualizar(localMax);
        }
        actual = actual + 1;
    }

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenido, por favor ingresa el tamanio del vector que deseas: ");
        int n = entrada.nextInt();
        System.out.println("Ahora introduce el número de threads a ejecutar (máximo " + Integer.toString(n) + "): ");
        int i = entrada.nextInt();
        if (i> (n)){
            System.out.println("El número de threads sobrepasa el máximo definido para el vector de tamaño " + Integer.toString(n) + " se ejecutaran " + Integer.toString(n) + " threads :)");
            i = n;
        }
        entrada.close();
        Vector vector = new Vector(n);
        Buscar.vector = vector;
        
        System.out.println("El vector generado se presenta a continuación: ");
        for (int value : vector.getVector()) {
            System.out.print(value + " ");
        }

        int pasos =  n/i;
        int y = 1;
        
        for (int k = 0; y <= i; k= k + pasos){
            
            if (y == i){
                new Buscar(vector, k, n).start();
            }
            else{
                new Buscar(vector, k, k + pasos).start();
                
            }
            y = y + 1;
        }

        while(actual < i){
        }

        System.out.println("\nEl maximo es: " + maximo.getMaximo());
    }
}
