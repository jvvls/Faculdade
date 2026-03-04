package lista00;
import java.util.Scanner;

public class ex8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] quantidade = new int[10];
        double[] preco = new double[10];

        int maior = 0;
        double total = 0;
        double geral = 0;
        double comissao = 0;
        int pos = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Insira quantidade do produto " + i + ": ");
            quantidade[i] = sc.nextInt();

            System.out.print("Insira preco do produto " + i + ": ");
            preco[i] = sc.nextDouble();
        }

        for (int i = 0; i < 10; i++) {
            if (quantidade[i] > maior) {
                maior = quantidade[i];
                pos = i;
            }

            System.out.println("Quantidade do produto " + i + ": " + quantidade[i]);
            System.out.println("Valor do produto " + i + ": " + preco[i]);

            total = quantidade[i] * preco[i];
            geral += total;
            comissao += total * 0.05;

            System.out.println("Total do produto " + i + ": " + total);
        }

        System.out.println("Total: " + geral);
        System.out.println("Comissao: " + comissao);
        System.out.println("O produto mais vendido foi " + maior + " na posicao " + pos);

        sc.close();
    }
}
