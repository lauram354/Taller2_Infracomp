import java.util.Random;

public class Vector {
    private int size;
    private int[] vector;

    public Vector(int size){
        this.size = size;
        this.vector = new int[size];
        Random numeroAleatorio = new Random();

        for (int i = 0; i < size; i++){
            vector[i] = numeroAleatorio.nextInt(50);
        }
    }

    public int[] getVector(){
        return vector;
    }

    public int getValue(int position){
        return vector[position];
    }
}
