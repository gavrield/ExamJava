package Answer1;

import java.util.Scanner;

public class Q4 {

    public static int factorial(int n){
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
    public static double f(double x, int n){
        double sum = 0;
        int exponent = 2;
        for (int i = 1; i <= n; i++) {
            if(i%2 != 0)
                sum -= Math.pow(x,exponent*i)/factorial(i);
            else
                sum += Math.pow(x,exponent*i)/factorial(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n; double x;

        System.out.println(" enter x and n:");
        x = s.nextDouble();
        n = s.nextInt();
        System.out.println("Result of f(x,n)= " + f(x, n));
    }
}
