package lista00;

import java.util.Scanner;

public class ex9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[6];
        int somaPares = 0;
        int qtdImpares = 0;

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o numero " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }

        System.out.println("\nRELATORIO");
        System.out.println("Os numeros pares sao:");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                System.out.println("numero " + numeros[i] + " na posicao " + (i + 1));
                somaPares += numeros[i];
            }
        }

        System.out.println("Soma dos pares = " + somaPares);

        System.out.println("Os numeros impares sao:");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 != 0) {
                System.out.println("numero " + numeros[i] + " na posicao " + (i + 1));
                qtdImpares++;
            }
        }

        System.out.println("Quantidade de impares = " + qtdImpares);

        sc.close();
    }
}
