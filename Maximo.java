public class Maximo {
    private int maximo = 0;

    public synchronized void actualizar(int numero){
        if (numero > maximo){
            maximo = numero;
        }
    }

    public synchronized int getMaximo(){
        return maximo;
    }
    
}
