import java.util.Scanner;

public class Buscar extends Thread{
    private static Maximo maximo = new Maximo();
    private static Vector vector;
    private int id;

    public Buscar(Vector vector, int id){
        this.id = id;
    }

    @Override 
    public void run(){
        
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
        
        /* 
        for (int value : vector.getVector()) {
            System.out.print(value + " ");
        }
        */

    }

    
}
