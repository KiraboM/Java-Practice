public class Fibonacci{

    public int fibonacci(int n){
        if(n <= 1){
            return n; //Base case
        } else{
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args){
        Fibonacci series = new Fibonacci();
        System.out.println("Fibonacci of 8: " + series.fibonacci(8));
    }
}