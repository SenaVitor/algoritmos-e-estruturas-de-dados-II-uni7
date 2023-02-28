package primeNumber;
import java.lang.Math;
public class Main {
    public static void main(String[] args){
        for(int j = 1; j < Integer.MAX_VALUE; j++) {
            System.out.println(j + " = " + ehPrimo(j));
        }
    }

    public static boolean ehPrimo(int x){
        if(x == 1) return false;
        for(int i = 2; i < Math.sqrt(x); i++){
            if(x%i == 0){
                return false;
            }
        }
        return true;
    }
}
