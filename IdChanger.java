package Answer1;

import java.util.Scanner;

public class IdChanger {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter your name = > ");
        String name = s.nextLine();
        System.out.print("Please enter your id number = > ");
        long id = s.nextLong();
        long newId = changeId(id);
        System.out.println("name: " + name + ", new id: "+ newId);
    }

    public static long changeId(long id){
        long newId, ones, tens, mul = 1, left, right;
        ones = id%10;
        tens = (id%100)/10;
        for (int i = 0; i < tens; i++) {
            mul *= 10;
        }
        left = id/mul;
        right = id%mul;
        newId = (left*10 + ones)*mul + right;
        return newId;
    }
}
