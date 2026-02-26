package lista00;
import java.util.Scanner;

public class ex2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("x: ");
        int x = sc.nextInt();

        System.out.print("y: ");
        int y = sc.nextInt();

        System.out.print("z: ");
        int z = sc.nextInt();

        if (x > y && x > z) {
            System.out.println("X é o maior");
        } else if (y > x && y > z) {
            System.out.println("Y é o maior");
        } else {
            System.out.println("Z é o maior");
        }

        if (x < y && x < z) {
            System.out.println("X é o menor");
        } else if (y < x && y < z) {
            System.out.println("Y é o menor");
        } else {
            System.out.println("Z é o menor");
        }

        if ((x > y && x < z) || (x > z && x < y)) {
            System.out.println("X está entre Y e Z");
        } else {
            System.out.println("X NÃO está entre Y e Z");
        }

        if (y != 0 && z != 0 && x % y == 0 && x % z == 0) {
            System.out.println("X é divisível por Y e Z");
        } else {
            System.out.println("X NÃO é divisível por Y e Z");
        }

        sc.close();
    }
}