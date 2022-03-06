package Answer1;

import java.util.Scanner;

public class ThreadQuestion {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num1, num2;
        System.out.println("enter 2 numbers: ");
        num1 = s.nextInt();
        num2 = s.nextInt();
        Runnable[] runnables = {
               new Runnable() {
                   @Override
                   public void run() {
                       System.out.println("sum = " +(num1 + num2));
                   }
               },
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("num1*num2 = " +(num1*num2));
                    }
                },
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("num1/num2 = " + (num1/(double)num2));
                    }
                },
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("num1 - num2 = " + (num1 - num2));
                    }
                }
        };
        Thread[] threads =
                {
                        new Thread(runnables[0]),
                        new Thread(runnables[1]),
                        new Thread(runnables[2]),
                        new Thread(runnables[3])
                };

        for (Thread t: threads
             ) {
            t.start();
        }

        for (Thread t: threads
             ) {
            try {
                t.join();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("Done deal!");

    }

}
